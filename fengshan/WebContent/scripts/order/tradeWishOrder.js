var YI = 10000000000;// ��
var WAN = 1000000;// ��
var YUAN = 100;// Ԫ
var clk;//����ʱ��
var countdown = 3;//����ʱʱ��
var prjCode;//�洢��ǰ���۵������Ӧ����Ŀ���
 
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
	if(confirm("ϵͳ���������Ľ��ױ�֤��"+priceTitle+"��ȷ���ύ�����")){
		window.location.href = appServer + "/tradeWishOrder/registration/check.htm?wishOrderNum=" + wishOrderNum;
	}
}

function loginOutTrade(wishOrderNum){
	if(confirm("������ύ��ˣ�ϵͳ���᷵�����Ľ��ױ�֤���˳��󽫲��ܲ��뽻��")){
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
			showMessage("��ȡ�ϴα���ʧ�ܣ�");
			return ;
		}
		var content = "";
		content = content +"<table width=\"100%\" class=\"tb2\">"
						+ "<tr><th>�����ƺţ�</th><td>" 
						+ trademark
						+ "</td></tr><tr><th>�ϴα��ۣ�</th><td>";
		if(latestBidInfo){
			content = content	+ getBidMoneyDesc(latestBidInfo.price,unite)
								+"</td></tr>"
								+ "<tr><th>���α��ۣ�</th><td>"
								+"<input type=\"text\" name=\"bidPrice\" id=\"bidPrice\" value=\""
								+transMoneyToUnite(latestBidInfo.price,unite)
								+"\"  onfocus=\"javascript:this.value='';\" />";
		}else{
			content = content + "�ޱ���"
								+"</td></tr>"
								+ "<tr><th>���α��ۣ�</th><td>"
								+"<input type=\"text\" name=\"bidPrice\" id=\"bidPrice\" value=\"�����뱨��\"  onfocus=\"javascript:this.value='';\" />"; 
		}
			content = content + getUniteDesc(unite)
								+ "&nbsp;&nbsp;&nbsp;&nbsp;<span id=\"bidErr\" style=\"color:red;\"></span></td></tr>"
								+"<tr><th>&nbsp;</th><td><span>�۸�ȷ����</span></td></tr>"
								+"<tr><th>&nbsp;</th><td>ע�⣺������α���������Ŀ�����ļۣ���ô��Ŀ<br />�����Ըü۸�ɽ��������������ж����ͬ�ı�<br />�ۣ�ϵͳ�Զ�ѡȡʱ�������ȳɹ��ı��۽��гɽ���</td></tr>"
								+"</table>";
		var op = {
			id : "bid",
			title : '���ɱ���',
			drag : false,
			lock : true,
			content : content,
			yesFn : function(){
				var price = $("#bidPrice").val();
				if(validateInputPrice(price,unite)){//���뱨�ۼ���
					var price_cent = transMoneyToCent(price,unite);
					bidAjax(price_cent,wishOrderNum);//����
					return true;
				}
				else{
					$("#bidErr").text("�۸񲻷��淶");
					return false;
				}
			},
			noFn : true
		};
		art.dialog(op);
	}catch(e){
		showMessage("��ʼ�����ɱ���ʧ�ܣ�");
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
						if( result.errorNO == "30"){//�����Ѽ���������3����Զ���ת������
							showSpecialMsg();
						}else{
							showMessage(result.errorInfo);
						}
					} 
				},
				error : function() {
					c = false;
					showMessage('�������ɱ���ʧ�ܣ�');
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
						showMessage("���۳ɹ���");
					}
				},
				error : function() {
					showMessage('������æ�����Ժ����ԣ�');
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
		title : '��Ϣ��ʾ',
		drag : true,
		lock : true,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}
function showSpecialMsg(){
	var m = "���ɱ����ѽ�����ϵͳ����"+countdown+"����Զ�������������"
	var op = {
		id : "msg",
		title : '��Ϣ��ʾ',
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
		var msg = "���ɱ����ѽ�����ϵͳ����"+countdown+"����Զ�������������";
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
		desc = "��Ԫ";
	} else if (unite == "wanyuan") {
		desc = "��Ԫ";
	} else if (unite == "yuan") {
		desc = "Ԫ";
	}
	return desc;
}
function validateInputPrice(price,unite) {
	var priceStr = "" + price;
	var result = true;
	var _bid_unite = unite;// ���۵�λ
	if (priceStr.indexOf(".") != -1) {// ��С����
		if (priceStr.length > 18) {
			result = false;
		} else {
			if ("yiyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;// С����С�����10λ
				result = reg.test(priceStr);
			} else if ("wanyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;// С����С�����6λ
				result = reg.test(priceStr);
			} else if ("yuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;// С����С�����2λ
				result = reg.test(priceStr);
			}
		}
	} else {
		if (priceStr.length > 17) {
			result = false;
		}else{
			if ("yiyuan" == _bid_unite) {
				var reg = /^[1-9][0-9]{0,6}$/;// ���7λ
				result = reg.test(priceStr);
			} else if ("wanyuan" == _bid_unite) {
				var reg = /^[1-9][0-9]{0,10}$/;// ���11λ
				result = reg.test(priceStr);
			} else if ("yuan" == _bid_unite) {
				var reg = /^[1-9][0-9]{0,14}$/;// ���15λ
				result = reg.test(priceStr);
			}
		}
		
	}
	return result;
}

function transMoneyToCent(money,unite) {
	var _money_cent;
	var _bid_unite = unite;// ���۵�λ
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
 * ����Ϊ��λ�Ľ�Ǯת��Ϊ������λ��Ӧ������<br />
 * С�������ౣ����λ��ȡ����Ҫת���ɵĵ�λ�� ��10λ(yiyuan)����6λ(wanyuan)��Ԫ2λ(yuan)<br />
 * ������λ����0<br />
 * ��ȷ���֣��磺��(101)�������ǰ��Ŀ�ĵ�λ�ǡ�yuan��������1.01)
 */
function transMoneyToUnite(money,munite) {
	var unite = munite;// ���۵�λ
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
	var m_desc = "���ޱ���";
	if(money){
		if(munite){
			m_desc = transMoneyToUnite(money,munite) + getUniteDesc(munite);
		}
	}
	return m_desc;
}
/**���������������õ���ȷ�ĳ������
*˵����javascript�ĳ�����������������������������ʱ���Ƚ����ԡ�����������ؽ�Ϊ��ȷ�ĳ��������
*���ã�accDiv(arg1,arg2)
*����ֵ��arg1����arg2�ľ�ȷ���
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


/**�˷������������õ���ȷ�ĳ˷����
*˵����javascript�ĳ˷������������������������˵�ʱ���Ƚ����ԡ�����������ؽ�Ϊ��ȷ�ĳ˷������
*���ã�accMul(arg1,arg2)
*����ֵ��arg1����arg2�ľ�ȷ���
**/
function accMul(arg1,arg2)
{
    var m=0,s1=arg1.toString(),s2=arg2.toString();
    try{m+=s1.split(".")[1].length}catch(e){}
    try{m+=s2.split(".")[1].length}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
}


/**
*�ӷ������������õ���ȷ�ļӷ����
*˵����javascript�ļӷ������������������������ӵ�ʱ���Ƚ����ԡ�����������ؽ�Ϊ��ȷ�ļӷ������
*���ã�accAdd(arg1,arg2)
*����ֵ��arg1����arg2�ľ�ȷ���
*/
function accAdd(arg1,arg2){
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
    try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
    m=Math.pow(10,Math.max(r1,r2));

    return accDiv((accMul(arg1,m)+accMul(arg2,m)),m);
}

/**
 * ��������
 */
function accSub(arg1,arg2){
	return accAdd(arg1,-arg2);
}
