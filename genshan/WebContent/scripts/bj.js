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
	//alert("״̬"+jsonData.status);
	if ("unLogin" == jsonData.status) {
		art.dialog({
			id:"bj_button",
			drag: false,
			width: "300px",
	        height: "20px",
			content :"��δ��½��"+ "<a target='_blank' href='"+ctx + "/user/login_page.html"+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>�����¼</a>",
			lock : true,//�Ƿ�����
			noFn : true
		});
	}
	
	if ("unApply" == jsonData.status) {
		
		art.dialog({
			id:"bj_button",
			title:"δ������������",
			drag: false,
			width: "300px",
	        height: "20px",
	        skin: 'aero',
			content : "<a target='_blank' style=\"text-decoration:underline;\" href='"+ctx + "/u/network/signUpActivity.html?id="+actId+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>�����μ�С����Ŀ����</a>",
			lock : true,//�Ƿ�����
			noFn : true
		});
	}
	
	if ("W" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"��ʾ��Ϣ",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "���Ѿ���������Ŀ�������ĵȴ�ϵͳ���������",
			lock : true,//�Ƿ�����
			yesFn :true,
			noFn : true
		});
	}
	
	if ("X" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"��ʾ��Ϣ",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "���ı���δ����������±�����\n"+"<a target='_blank' href='"+ctx + "/u/network/signUpActivity.html?id="+actId+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>�����μ�С����Ŀ����</a>",
			lock : true,//�Ƿ�����
			noFn : true
		});
	}
	
	if ("M" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"��ʾ��Ϣ",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "����δ�ύ��������ı�֤�����Ƚ���֤��",
			lock : true,//�Ƿ�����
			yesFn :true,
			noFn : true
		});
	}
	
	if ("H" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"��ʾ��Ϣ",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "���ı�����δ���������ĵȴ�����",
			lock : true,//�Ƿ�����
			yesFn :true,
			noFn : true
		});
	}
	
	if ("K" == jsonData.status){
		art.dialog({
			id:"bj_button",
			title:"δͨ������",
			drag: false,
			width: "300px",
	        height: "20px",
			content : "���ı���δͨ����������±�����\n"+"<a target='_blank' href='"+ctx + "/u/network/signUpActivity.html?id="+actId+"' onclick='javascript:art.dialog.list[\"bj_button\"].close();'>�����μ�С����Ŀ����</a>",
			lock : true,//�Ƿ�����
			noFn : true
		});
	}
	if ("ok" == jsonData.status){
		unitType = jsonData.unitType;
		if (unitType == "yuan") {
			unitTypeName = "Ԫ";
		}
		if (unitType == "wan") {
			unitTypeName = "��";
		}
		if (unitType == "yi") {
			unitTypeName = "��";
		}
		if(jsonData.raiseMod =="����"){
			notice ="������ڵ�ǰ���ۣ�С����������λС��";
		}
		if(jsonData.raiseMod =="����"){
			notice ="����С�ڵ�ǰ���ۣ�С����������λС��";
		}
		art.dialog({
			id:"bj_button",
			title:"������Ϣ",
			width: "300px",
			content : "<style>\r " +
					".aui_header{vertical-align: middle;} \r " +
					".aui_content table,.aui_content tr ,.aui_content td, .aui_content span{border-spacing:1px 5px;border-collapse:separate;} \r" +
					"</style>"+
					"<table style='font-size:12px;'>" +
			"<tr><td align='left'><span>������Ŀ��</span></td><td align='left' style='font-size:16px;color:#0066CC'>"+actName+"</td></tr>" +
			"<tr><td align='left'><span>���±��ۣ�</span></td><td align='left' style='font-size:12px;font-weight:bold;color:red;'>"+jsonData.bidPrice+"&nbsp;"+unitTypeName+"</td></tr>"+
			"<tr><td align='left'><span>���۷���</span></td><td align='left'><span>"+jsonData.raiseMod+"</span></td></tr>" +
			"<tr><td align='left'><span>���뱨�ۣ�</span></td><td align='left'><input id='bidPrice' type='text' value='�������±���' onfocus='javascript:this.value=\"\"' />"+unitTypeName+"</td></tr>"+
			"</table>" +
			"<span style='color:red;'>"+notice+"</span>"  ,
			lock : true,//�Ƿ�����
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
			alert("����ȷ���뱨�۽�");
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
			alert("����ȷ���뱨�۽�");
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
			alert("����ȷ���뱨�۽�");
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
	//����ύ�ı���  ��λ�ǣ���
	//alert("finally"+bidPrice);
	if(confirm("ȷ�ϱ��ۣ�")){
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
 * ���ۻص�
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
