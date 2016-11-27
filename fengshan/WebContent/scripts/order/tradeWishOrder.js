var YI = 10000000000;// 亿
var WAN = 1000000;// 万
var YUAN = 100;// 元
var clk;//倒计时器
var countdown = 3;//倒计时时间
var prjCode;//存储当前报价的意向对应的项目编号
 
 $(function() {
        $("#place_start_from").datePicker({
            clickInput : true,
            startDate:"1970-01-01"
        });
        $("#place_start_to").datePicker({
            clickInput : true,
            startDate:"1970-01-01"
        });
});
 function clearMsg(){
		jQuery("#query_wishOrderNum").attr("value","");
		jQuery("#query_status").attr("value","");
		jQuery("#query_paymentType").attr("value","");
		jQuery("#query_projectName").attr("value","");
		jQuery("#place_start_from").attr("value","");
		jQuery("#place_start_to").attr("value","");
}
 
function checkWishOrder(wishOrderNum, priceTitle){
	if(confirm("系统将冻结您的交易保证金"+priceTitle+"，确定提交审核吗？")){
		window.location.href = appServer + "/tradeWishOrder/registration/check.htm?wishOrderNum=" + wishOrderNum;
	}
}

function loginOutTrade(wishOrderNum){
	if(confirm("如果已提交审核，系统将会返还您的交易保证金，退出后将不能参与交易")){
		window.location.href = appServer + "/auction/loginOut.htm?wishOrderNum=" + wishOrderNum;
	}
}

function bid(wishOrderNum,unite,trademark,projectCode) {
	prjCode = projectCode ; 
	if(!canFreeBid(wishOrderNum)){
		return ;
	}
	try{
		var latestBidInfo = getLatestBidInfoAjax(trademark);
		if(latestBidInfo == ""){
			showMessage("获取上次报价失败！");
			return ;
		}
		var content = "";
		content = content +"<table width=\"100%\" class=\"tb2\">"
						+ "<tr><th>报价牌号：</th><td>" 
						+ trademark
						+ "</td></tr><tr><th>上次报价：</th><td>";
		if(latestBidInfo){
			content = content	+ getBidMoneyDesc(latestBidInfo.price,unite)
								+"</td></tr>"
								+ "<tr><th>本次报价：</th><td>"
								+"<input type=\"text\" name=\"bidPrice\" id=\"bidPrice\" value=\""
								+transMoneyToUnite(latestBidInfo.price,unite)
								+"\"  onfocus=\"javascript:this.value='';\" />";
		}else{
			content = content + "无报价"
								+"</td></tr>"
								+ "<tr><th>本次报价：</th><td>"
								+"<input type=\"text\" name=\"bidPrice\" id=\"bidPrice\" value=\"请输入报价\"  onfocus=\"javascript:this.value='';\" />"; 
		}
			content = content + getUniteDesc(unite)
								+ "&nbsp;&nbsp;&nbsp;&nbsp;<span id=\"bidErr\" style=\"color:red;\"></span></td></tr>"
								+"<tr><th>&nbsp;</th><td><span>价格精确到分</span></td></tr>"
								+"<tr><th>&nbsp;</th><td>注意：如果本次报价优于项目的起拍价，那么项目<br />可能以该价格成交；上述情况如果有多个相同的报<br />价，系统自动选取时间上最先成功的报价进行成交！</td></tr>"
								+"</table>";
		var op = {
			id : "bid",
			title : '自由报价',
			drag : false,
			lock : true,
			content : content,
			yesFn : function(){
				var price = $("#bidPrice").val();
				if(validateInputPrice(price,unite)){//输入报价检验
					var price_cent = transMoneyToCent(price,unite);
					bidAjax(price_cent,wishOrderNum);//报价
					return true;
				}
				else{
					$("#bidErr").text("价格不符规范");
					return false;
				}
			},
			noFn : true
		};
		art.dialog(op);
	}catch(e){
		showMessage("初始化自由报价失败！");
	}
}
function canFreeBid(wishOrderNum){
		var c = true;
		jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/canFreeBid.htm",
				data : "wishOrderNum=" + wishOrderNum,
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						c= false;
						if( result.errorNO == "30"){//大厅已激活的情况，3秒后自动跳转到大厅
							showSpecialMsg();
						}else{
							showMessage(result.errorInfo);
						}
					} 
				},
				error : function() {
					c = false;
					showMessage('请求自由报价失败！');
				}
			});
			return c;
}
function bidAjax(price,wishOrderNum){
	jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/freeBid.htm",
				data : "price=" + price + "&wishOrderNum=" + wishOrderNum,
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						showMessage(result.errorInfo);
					} else {
						showMessage("报价成功！");
					}
				},
				error : function() {
					showMessage('服务器忙，请稍后再试！');
				}
			});
}
function getLatestBidInfoAjax(trademark){
	var info;
	jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/latestFreeBid.htm",
				data :"trademark=" + trademark,
				dataType : "json",
				async : false,
				cache : false,
				success : function(bidInfo) {
					info = bidInfo;
					return info;
				},
				error : function() {
					info = ""
				}
			});
	return info;
}
function showMessage(message) {
	var op = {
		id : "msg",
		title : '信息提示',
		drag : true,
		lock : true,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}
function showSpecialMsg(){
	var m = "自由报价已结束，系统将在"+countdown+"秒后自动进入拍卖大厅"
	var op = {
		id : "msg",
		title : '信息提示',
		drag : true,
		lock : true,
		content : "<span id=\"specialMsg\">"+m+"</span>",
		yesFn : function(){
			window.clearInterval(clk);
			window.location.href = clientServer + "/auction/join.htm?projectCode="+prjCode;
		},
		noFn : function(){
			countdown = 3;
			window.clearInterval(clk);
			return true;
		}
	};
	art.dialog(op);
	clk = self.setInterval("clock()", 1000);
}
function clock() {
	countdown = countdown - 1;
	if(countdown >=0){
		var msg = "自由报价已结束，系统将在"+countdown+"秒后自动进入拍卖大厅";
		$("#specialMsg").text(msg);
	}else{
		countdown = 3;
		window.clearInterval(clk);
		window.location.href = clientServer + "/auction/join.htm?projectCode="+prjCode;
	}
}

function getUniteDesc(unite) {
	var desc = "";
	if (unite == "yiyuan") {
		desc = "亿元";
	} else if (unite == "wanyuan") {
		desc = "万元";
	} else if (unite == "yuan") {
		desc = "元";
	}
	return desc;
}
function validateInputPrice(price,unite) {
	var priceStr = "" + price;
	var result = true;
	var _bid_unite = unite;// 报价单位
	if (priceStr.indexOf(".") != -1) {// 有小数点
		if (priceStr.length > 18) {
			result = false;
		} else {
			if ("yiyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;// 小数，小数点后10位
				result = reg.test(priceStr);
			} else if ("wanyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;// 小数，小数点后6位
				result = reg.test(priceStr);
			} else if ("yuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;// 小数，小数点后2位
				result = reg.test(priceStr);
			}
		}
	} else {
		if (priceStr.length > 17) {
			result = false;
		}else{
			if ("yiyuan" == _bid_unite) {
				var reg = /^[1-9][0-9]{0,6}$/;// 最多7位
				result = reg.test(priceStr);
			} else if ("wanyuan" == _bid_unite) {
				var reg = /^[1-9][0-9]{0,10}$/;// 最多11位
				result = reg.test(priceStr);
			} else if ("yuan" == _bid_unite) {
				var reg = /^[1-9][0-9]{0,14}$/;// 最多15位
				result = reg.test(priceStr);
			}
		}
		
	}
	return result;
}

function transMoneyToCent(money,unite) {
	var _money_cent;
	var _bid_unite = unite;// 报价单位
	if (_bid_unite == "yiyuan") {
		_money_cent = accMul(money, YI);
	} else if (_bid_unite == "wanyuan") {
		_money_cent = accMul(money, WAN);
	} else if (_bid_unite == "yuan") {
		_money_cent = accMul(money, YUAN);
	} else {
		_money_cent = 0;
	}
	return _money_cent;
}
/**
 * 将分为单位的金钱转换为其他单位对应的数额<br />
 * 小数点后最多保留的位数取决于要转换成的单位： 亿10位(yiyuan)、万6位(wanyuan)、元2位(yuan)<br />
 * 其他单位返回0<br />
 * 精确到分，如：传(101)，如果当前项目的单位是“yuan”，返回1.01)
 */
function transMoneyToUnite(money,munite) {
	var unite = munite;// 报价单位
	var _money_unite ="";
	if(money){
		if (unite == "yiyuan") {
			_money_unite = accDiv(money,YI)+ "";
		} else if (unite == "wanyuan") {
			_money_unite = accDiv(money,WAN) + "";
		} else if (unite == "yuan") {
			_money_unite = accDiv(money,YUAN) + "";
		} else {
			_money_unite = 0;
			return _money_unite;
		}
		var point = _money_unite.indexOf(".");
		if (point > 0) {
			var partInt = _money_unite.substring(0, point);
			var partDecimal;
			if (unite == "yiyuan") {
				partDecimal = _money_unite.substr(point, 11);
			} else if (unite == "wanyuan") {
				partDecimal = _money_unite.substr(point, 7);
			} else if (unite == "yuan") {
				partDecimal = _money_unite.substr(point, 3);
			}
			_money_unite = partInt + partDecimal;
		}
	}
	return _money_unite;
}

function getBidMoneyDesc(money,munite){
	var m_desc = "尚无报价";
	if(money){
		if(munite){
			m_desc = transMoneyToUnite(money,munite) + getUniteDesc(munite);
		}
	}
	return m_desc;
}
/**除法函数，用来得到精确的除法结果
*说明：javascript的除法结果会有误差，在两个浮点数相除的时候会比较明显。这个函数返回较为精确的除法结果。
*调用：accDiv(arg1,arg2)
*返回值：arg1除以arg2的精确结果
*/
function accDiv(arg1,arg2){
    var t1=0,t2=0,r1,r2;
    try{t1=arg1.toString().split(".")[1].length}catch(e){}
    try{t2=arg2.toString().split(".")[1].length}catch(e){}
    with(Math){
        r1=Number(arg1.toString().replace(".",""))
        r2=Number(arg2.toString().replace(".",""))
        return (r1/r2)*pow(10,t2-t1);
    }
}


/**乘法函数，用来得到精确的乘法结果
*说明：javascript的乘法结果会有误差，在两个浮点数相乘的时候会比较明显。这个函数返回较为精确的乘法结果。
*调用：accMul(arg1,arg2)
*返回值：arg1乘以arg2的精确结果
**/
function accMul(arg1,arg2)
{
    var m=0,s1=arg1.toString(),s2=arg2.toString();
    try{m+=s1.split(".")[1].length}catch(e){}
    try{m+=s2.split(".")[1].length}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}


/**
*加法函数，用来得到精确的加法结果
*说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
*调用：accAdd(arg1,arg2)
*返回值：arg1加上arg2的精确结果
*/
function accAdd(arg1,arg2){
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2));

    return accDiv((accMul(arg1,m)+accMul(arg2,m)),m);
}

/**
 * 减法函数
 */
function accSub(arg1,arg2){
	return accAdd(arg1,-arg2);
}
