//added by guowei 2011-08-03
var actId;
var actName;
var unitType;
var unitTypeName;
function enterFor(activityId,activityName) {  
	
	//alert(activityId);alert(activityName);
	
	actId = activityId;
	actName = activityName;

	var url = ctx + "/u/network/checkUserStatus.html";
	var params = {
		"activityId" : activityId
	};
	
	jQuery.getJSON(url, params, call_back);
	
}

function call_back(jsonData) {
	var notice;
	//alert(actId);
	//alert("状态"+jsonData.status);
	if ("unLogin" == jsonData.status) {
		art.dialog({
			id:"bj_button",
			drag: false,
			width: "300px",
	        height: "20px",
			content :"尚未登陆！"+ "<a target='_blank' href='"+ctx + "/user/login_page.html"+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>点击登录</a>",
			lock : true,//是否锁屏
			noFn : true
		});
	}
	
	if ("unApply" == jsonData.status) {
		
		art.dialog({
			id:"bj_button",
			title:"未报名请点击报名",
			drag: false,
			width: "300px",
	        height: "20px",
	        skin: 'aero',
			content : "<a target='_blank' style=\"text-decoration:underline;\" href='"+ctx + "/u/network/signUpActivity.html?id="+actId+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>报名参加小额项目竞价</a>",
			lock : true,//是否锁屏
			noFn : true
		});
	}
	
	if ("W" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"提示信息",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "您已经报名此项目，请耐心等待系统受理该请求！",
			lock : true,//是否锁屏
			yesFn :true,
			noFn : true
		});
	}
	
	if ("X" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"提示信息",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "您的报名未被受理，请从新报名！\n"+"<a target='_blank' href='"+ctx + "/u/network/signUpActivity.html?id="+actId+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>报名参加小额项目竞价</a>",
			lock : true,//是否锁屏
			noFn : true
		});
	}
	
	if ("M" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"提示信息",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "您尚未提交报价所需的保证金，请先交保证金！",
			lock : true,//是否锁屏
			yesFn :true,
			noFn : true
		});
	}
	
	if ("H" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"提示信息",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "您的报名尚未终审，请耐心等待终审！",
			lock : true,//是否锁屏
			yesFn :true,
			noFn : true
		});
	}
	
	if ("K" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"未通过终审",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "您的报名未通过终审，请从新报名！\n"+"<a target='_blank' href='"+ctx + "/u/network/signUpActivity.html?id="+actId+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>报名参加小额项目竞价</a>",
			lock : true,//是否锁屏
			noFn : true
		});
	}
	if ("ok" == jsonData.status){
		unitType = jsonData.unitType;
		if (unitType == "yuan") {
			unitTypeName = "元";
		}
		if (unitType == "wan") {
			unitTypeName = "万";
		}
		if (unitType == "yi") {
			unitTypeName = "亿";
		}
		if(jsonData.raiseMod =="向上"){
			notice ="必须大于当前报价，小数点后最多两位小数";
		}
		if(jsonData.raiseMod =="向下"){
			notice ="必须小于当前报价，小数点后最多两位小数";
		}
		art.dialog({
			id:"bj_button",
			title:"报价信息",
			width: "300px",
			content : "<style>\r " +
					".aui_header{vertical-align: middle;} \r " +
					".aui_content table,.aui_content tr ,.aui_content td, .aui_content span{border-spacing:1px 5px;border-collapse:separate;} \r" +
					"</style>"+
					"<table style='font-size:12px;'>" +
			"<tr><td align='left'><span>报价项目：</span></td><td align='left' style='font-size:16px;color:#0066CC'>"+actName+"</td></tr>" +
			"<tr><td align='left'><span>最新报价：</span></td><td align='left' style='font-size:12px;font-weight:bold;color:red;'>"+jsonData.bidPrice+"&nbsp;"+unitTypeName+"</td></tr>"+
			"<tr><td align='left'><span>竞价方向：</span></td><td align='left'><span>"+jsonData.raiseMod+"</span></td></tr>" +
			"<tr><td align='left'><span>输入报价：</span></td><td align='left'><input id='bidPrice' type='text' value='输入最新报价' onfocus='javascript:this.value=\"\"' />"+unitTypeName+"</td></tr>"+
			"</table>" +
			"<span style='color:red;'>"+notice+"</span>"  ,
			lock : true,//是否锁屏
			yesFn:function(){
			      var price = document.getElementById('bidPrice').value;
			      Muller_For_Operator(price,this);
			      return false;
		    },
			noFn : true
		});
	}
}
function Muller_For_Operator(price, bjlog) {
	var url = ctx + "/u/network/doBid.html";
	var bidPrice = price;
	//var reg =/^[1-9][0-9]{0,17}|0\.[0-9]{1,2}|[1-9][0-9]{0,17}\.[0-9]{1,2}$/;
	var regB=/^0\.[0-9]{1,2}$/;
	
	if (unitType == "yuan") {
		var regA =/^[1-9][0-9]{0,15}$/;
		var regC=/^[1-9][0-9]{0,15}\.[0-9]{1,2}$/;
		if(!(regA.test(bidPrice) || regB.test(bidPrice) || regC.test(bidPrice))){
			alert("请正确输入报价金额！");
			return ;
		}
		if(bidPrice.indexOf(".")>0){
			bidPrice = bidPrice+"00";
			var part1 = bidPrice.substring(0,bidPrice.indexOf("."));
			var part2 = bidPrice.substr(bidPrice.indexOf(".")+1,2);
			if(part1 =="0"){
				part1="";
				part2=part2.replace(/\b(0+)/gi,"");
			}
			bidPrice = part1+part2;
		}else{
			bidPrice = bidPrice+"00";
		}
		
	}
	if (unitType == "wan") {
		var regA =/^[1-9][0-9]{0,9}$/;
		var regC=/^[1-9][0-9]{0,9}\.[0-9]{1,2}$/;
		if(!(regA.test(bidPrice) || regB.test(bidPrice) || regC.test(bidPrice))){
			alert("请正确输入报价金额！");
			return ;
		}
		if(bidPrice.indexOf(".")>0){
			bidPrice = bidPrice+"000000";
			var part1 = bidPrice.substring(0,bidPrice.indexOf("."));
			var part2 = bidPrice.substr(bidPrice.indexOf(".")+1,6);
			if(part1 =="0"){
				part1="";
				part2=part2.replace(/\b(0+)/gi,"");
			}
			
			bidPrice = part1+part2;
		}else{
			bidPrice = bidPrice+"000000";
	   }
	}
	if (unitType == "yi") {
		var regA =/^[1-9][0-9]{0,5}$/;
		var regC=/^[1-9][0-9]{0,5}\.[0-9]{1,2}$/;
		if(!(regA.test(bidPrice) || regB.test(bidPrice) || regC.test(bidPrice))){
			alert("请正确输入报价金额！");
			return ;
		}
		if(bidPrice.indexOf(".")>0){
			bidPrice = bidPrice+"0000000000";
			var part1 = bidPrice.substring(0,bidPrice.indexOf("."));
			var part2 = bidPrice.substr(bidPrice.indexOf(".")+1,10);
			if(part1 =="0"){
				part1="";
				part2=part2.replace(/\b(0+)/gi,"");
			}
			
			bidPrice = part1+part2;
		}else{
			
			bidPrice = bidPrice+"0000000000";
	   }
	}
	//输出提交的报价  单位是：分
	//alert("finally"+bidPrice);
	if(confirm("确认报价？")){
	var params = {
		"activityId" : actId,
		"bidPrice" : bidPrice
	};
	jQuery.post(url, params, callBack_Muller, "json");
	}
	else{
		bjlog.close();
		
	}

}

/**
 * 报价回调
 * 
 * @param {}
 *            jsonData
 */
function callBack_Muller(jsonData) {
	if(jsonData.message!=undefined)
		alert(jsonData.message);
	alert(jsonData.bidStatus.message);
	if(jsonData.bidStatus.needRefresh) {
		window.location.reload();
	}
}

//end
