// ===========����ģ�� ��ʼ=====================
var liHtml;
liHtml = "<li id='[[diyType_div_id]]' class='diyType_div_obj' style='margin:3px 3px 0 3px;border:1px solid #9eaeb9;'>";
// ���������ã��������ĸ������ϼ��� class='diyType_head'
liHtml += "<div class='diyType_head' style='margin:3px 3px 0 3px;'>";
liHtml += "<input type='hidden' name='projectTypeCode' value='[[screenDiy_projectTypeCode]]'/><input type='hidden' name='tradingType' value='[[screenDiy_tradingType]]'/>";
liHtml += "<p class='p1'><strong>&nbsp;������⣺</strong><input type='text' name='tTitle' value='[[screenDiy_tTitle]]' style='width: 400px;' />";
//liHtml += "<p class='p1'><strong>&nbsp;������⣺</strong><input type='text' name='tTitle' value='' style='width: 400px;' />";
liHtml += "&nbsp;����ţ�<input type='text' name='tSeq' value='10'/></p>";
liHtml += "<p class='p3'>-<a href='javascript:void(0);' class='link-close'>չ��</a> -<a href='javascript:void(0);'  class='link-del'>ɾ��</a></p>";
liHtml += "</div>";
liHtml += "<table width='100%' class='c4' style='display:none'>";
liHtml += "<tr>";
liHtml += "<td colspan='4' class='diyType_head gl'>&nbsp;���������С(����)��<input type='text'  name='tSize' value='20'/>&nbsp;�������С(����):<input type='text' name='cSize' value='12'/>&nbsp;ÿ����ʾ����:<input type='text' name='cPageNo' value='10'/></td>";
liHtml += "</tr>";

// liHtml += "<tr>";
// liHtml += "<td class='diyType_head gl' colspan='2'>&nbsp;<strong>���׷�ʽ��</strong>";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tPlaceOrder' value='0'/>�µ�����";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tBidOrder' value='0'/>��������";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tTransferOrder' value='0'/>Э��ת��";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tTenderOrder' value='0'/>�б�ת��";
// liHtml += "</td>";
// liHtml += "</tr>";
liHtml += "<tr>";
liHtml += "<td class='diyType_head gl' colspan='2'>&nbsp;<strong>״̬��</strong>";
liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tT' value='0'/>������Ŀ";
liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tO' value='0'/>�ɽ���Ŀ";
liHtml += "</td>";
liHtml += "</tr>";
// ---------------------------------
liHtml += "<tr>";
liHtml += "<td>&nbsp;&nbsp;<strong>�ֶ���</strong></td>";
liHtml += "<td><strong>�б���</strong></td>";
liHtml += "<td><strong>�п�����</strong></td>";
liHtml += "<td><strong>�����</strong></td>";
liHtml += "</tr>";

// ## ����Ҫ��ʾ���� - ��ʼ
// ## ��PROJECT_LISTING�е��ֶΣ�
liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='TITLE'/>��Ŀ����</td>"; // TITLE
liHtml += "<td><input type='text' name='cTitle' value='��Ŀ����' style='width: 200px;' /></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='CODE'/>��Ŀ���</td>"; // CODE
liHtml += "<td><input type='text' name='cTitle' value='��Ŀ���' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_TYPE'/>����/�ɹ�</td>"; // LISTING_TYPE
liHtml += "<td><input type='text' name='cTitle' value='����/�ɹ�' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='QUANTITY'/>��������</td>"; // QUANTITY
liHtml += "<td><input type='text' name='cTitle' value='��������' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_PRICE'/>���Ƽ۸�</td>"; // LISTING_PRICE
liHtml += "<td><input type='text' name='cTitle' value='���Ƽ۸�' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='PROJECT_TYPE_CODE'/>��Ŀ����</td>"; // PROJECT_TYPE_CODE
liHtml += "<td><input type='text' name='cTitle' value='��Ŀ����' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='TRADING_TYPE'/>���׷�ʽ</td>"; // TRADING_TYPE
liHtml += "<td><input type='text' name='cTitle' value='���׷�ʽ' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_START_TIME'/>���ƿ�ʼʱ��</td>"; // LISTING_START_TIME
liHtml += "<td><input type='text' name='cTitle' value='���ƿ�ʼʱ��' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_END_TIME'/>���ƽ���ʱ��</td>"; // LISTING_END_TIME
liHtml += "<td><input type='text' name='cTitle' value='���ƽ���ʱ��' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='USER_ACCOUNT'/>�����˺�</td>"; // USER_ACCOUNT
liHtml += "<td><input type='text' name='cTitle' value='�����˺�' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='DELIVERY_DATE'/>��������</td>"; // DELIVERY_DATE
liHtml += "<td><input type='text' name='cTitle' value='��������' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ADDRESS'/>��ַ</td>"; // ADDRESS
liHtml += "<td><input type='text' name='cTitle' value='��ַ' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

// ## �ɽ���¼���Բο�������TRADE_ORDER�е��ֶΣ���ѡ����ӽ�ģ��
// liHtml += "<tr class='cols'>";
// liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_NO'/>�������(�ɽ�����)</td>";
// liHtml += "<td><input type='Text' name='cTitle' value='�������' style='width:200px;'/></td>";
// liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
// liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
// liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='BID_PRICE'/>�ɽ�����(�ɽ�����)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='�ɽ�����' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_QUANTITY'/>�ɽ�����(�ɽ�����)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='�ɽ�����' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_AMOUNT'/>�ɽ��ܼ�(�ɽ�����)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='�ɽ��ܼ�' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='DELIVERY_TYPE'/>������ʽ(�ɽ�����)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='������ʽ' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='PAYMENT_TYPE'/>֧����ʽ(�ɽ�����)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='֧����ʽ' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_STATUS'/>����״̬(�ɽ�����)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='����״̬' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

// ===========����ģ�� ����=====================

// =========== ��̬���Ե�ģ�� =====================
var liHtmlD = ""; // ��diyTable()�����ͨ��AJAXȡ��json����ƴװ

// =================================================
// ��չJS��replaceAll����
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
}
// ���ַ����е�˫���ź͵����Ź��˳��»���
String.prototype.trimQuote = function() {
	return this.replaceAll("'", "_").replaceAll("\"", "_");
}
// ���������
function rand(number) {
	number = number || 99999999;
	number = Math.floor(Math.random() * number + 1); // 1-number
	return number;
}
/*
 * ����:Array.remove(dx) ����:ɾ������Ԫ��. ����:dxɾ��Ԫ�ص��±�. ����:��ԭ�������޸�����
 */
Array.prototype.remove = function(index) {
	if (isNaN(index) || index > this.length) {
		return false;
	}
	for (var i = 0, n = 0; i < this.length; i++) {
		if (this[i] != this[index]) {
			this[n++] = this[i];
		}
	}
	this.length -= 1;
}
// ��չJson��ع��ܣ�
jQuery.extend({
			/**
			 * @see ��json�ַ���ת��Ϊ����
			 * @param json�ַ���
			 * @return ����object,array,string�ȶ���
			 */
			strToJson : function(strJson) {
				if (typeof(strJson) == "string")
					return eval("(" + strJson + ")");
				else
					return strJson
			}
		});
jQuery.extend({
			/**
			 * @see ��javascript��������ת��Ϊjson�ַ���
			 * @param ��ת������,֧��object,array,string,function,number,boolean,regexp
			 * @return ����json�ַ���
			 */
			jsonToStr : function(object) {
				var type = typeof object;
				if ('object' == type) {
					if (Array == object.constructor)
						type = 'array';
					else if (RegExp == object.constructor)
						type = 'regexp';
					else
						type = 'object';
				}
				switch (type) {
					case 'undefined' :
					case 'unknown' :
						return;
						break;
					case 'function' :
					case 'boolean' :
					case 'regexp' :
						return object.toString();
						break;
					case 'number' :
						return isFinite(object) ? object.toString() : 'null';
						break;
					case 'string' :
						return '"'
								+ object.replace(/(\\|\")/g, "\\$1").replace(
										/\n|\r|\t/g, function() {
											var a = arguments[0];
											return (a == '\n')
													? '\\n'
													: (a == '\r')
															? '\\r'
															: (a == '\t')
																	? '\\t'
																	: ""
										}) + '"';
						break;
					case 'object' :
						if (object === null)
							return 'null';
						var results = [];
						for (var property in object) {
							var value = jQuery.jsonToStr(object[property]);
							if (value !== undefined)
								results.push(jQuery.jsonToStr(property) + ':'
										+ value);
						}
						return '{' + results.join(',') + '}';
						break;
					case 'array' :
						var results = [];
						for (var i = 0; i < object.length; i++) {
							var value = jQuery.jsonToStr(object[i]);
							if (value !== undefined)
								results.push(value);
						}
						return '[' + results.join(',') + ']';
						break;
				}
			}
		});
// =================================================
function replaceData(newLiHtml) {
	var projectTypeCode, projectTypeCodeText;
	var tradingType, tradingTypeText;
	var status, statusText;
	var screenDiy_tTitle, diyType_div_id;
	// Ҫ�滻��ֵ

	// ��̬����
	projectTypeCode = $("#projectTypeCode").val();
	projectTypeCodeText = $("#projectTypeCodeText").val();

	tradingType = $("#tradingType").val();
	tradingTypeText = $("#tradingTypeText").val();

//	diyType_div_id = projectTypeCode + "-" + tradingType + "-" + rand();
	diyType_div_id = new Date().getTime() + "";
	screenDiy_tTitle = projectTypeCodeText + "-" + tradingTypeText + "-";
	// diyType_div_id = rand();
	// �滻ģ���е���Ŀ����
	newLiHtml = newLiHtml.replace("[[screenDiy_projectTypeCode]]",
			projectTypeCode);
	// �滻ģ���еĽ��׷�ʽ
	newLiHtml = newLiHtml.replace("[[screenDiy_tradingType]]", tradingType);
	// �滻ģ���еķ���Div��ID
	newLiHtml = newLiHtml.replace("[[diyType_div_id]]", diyType_div_id);
	// �滻ģ���еķ������
	newLiHtml = newLiHtml.replace("[[screenDiy_tTitle]]", screenDiy_tTitle);
	return newLiHtml;
}

// ===============================================
function diyTable(newLiHtml, projectTypeCode, projectTradingType, diyCfg) {
	// �жϴ������ͣ���ѡ�����ĸ�ģ��

	newLiHtml = newLiHtml || liHtml;
	var typeCode = projectTypeCode ? projectTypeCode : $("#projectTypeCode")
			.val();
	var tradingType = projectTradingType
			? projectTradingType
			: $("#tradingType").val();
	var typeAttriList = [];
	$.ajax({
		type : "POST",
		url : ajaxUrl,
		cache : false,
		data : {
			"typeCode" : typeCode,
			"tradingType" : tradingType,
			random : Math.random()
		},
		dataType : "json",
		timeout : 30000,
		success : function(json) {
			// /* 2011-7-21 ��Ϊ���Ӷ�̬���Զ���showCfgInDiyTable()����ת�ƽ������� START */
			var diyType_div_id;
			var screenDiy_tTitle;
			if (diyCfg) {
				// �滻ģ���еķ���Div��ID
				//	diyType_div_id = typeCode + "-" + tradingType + "-" + rand();
				diyType_div_id = new Date().getTime() + "";
				// diyType_div_id = rand();
				newLiHtml = newLiHtml.replace("[[diyType_div_id]]",
						diyType_div_id);
				// �滻ģ���еķ������
				screenDiy_tTitle = diyCfg.tTitle;
				newLiHtml = newLiHtml.replace("[[screenDiy_tTitle]]",
						screenDiy_tTitle);
				// �滻ģ���еı��������
				newLiHtml = newLiHtml.replace("[[screenDiy_projectTypeCode]]",
						diyCfg.projectTypeCode);
				// �滻ģ���еĽ��׷�ʽ
				newLiHtml = newLiHtml.replace("[[screenDiy_tradingType]]",
						diyCfg.tradingType);
			}
			/* 2011-7-21 ��Ϊ���Ӷ�̬���Զ���showCfgInDiyTable()����ת�ƽ������� END */
			liHtmlD = "";
			if (json) {
				typeAttriList = json.data;
				for (var i = 0; i < typeAttriList.length; i++) {
					var typeMeta = typeAttriList[i];
					liHtmlD += "<tr class='cols'>";
					liHtmlD += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' />"
							+ "<input type='hidden' name='cName' value='"
							+ typeMeta.key + "'/>" + typeMeta.name + "</td>";
					liHtmlD += "<td><input type='text' name='cTitle' value='"
							+ typeMeta.name + "' style='width: 200px;'/></td>";
					liHtmlD += "<td><input type='text' name='cWidth' value='80'/></td>";
					liHtmlD += "<td><input type='text' name='cSeq' value='10'/></td>";
					liHtmlD += "</tr>";
				}
			}
			newLiHtml += liHtmlD;// �ӽ���̬����ģ��2011-7-20
			newLiHtml += "</table></li>";// ����̬����ģ�����β�� 2011-7-20

			newLiHtml = replaceData(newLiHtml);

			$(".ul-diy").append(newLiHtml);
			$(".ul-diy .link-close").unbind().toggle(function() {
						$(this).html("����").addClass("link-close");
						$(this).parent().parent().next("table").show();
					}, function() {
						$(this).html("չ��").removeClass("link-show");
						$(this).parent().parent().next("table").hide();
					});

			$(".ul-diy .link-del").unbind().click(function() {
						$(this).parent().parent().parent().remove();
					});

			/* 2011-7-21 ��Ϊ���Ӷ�̬���Զ���showCfgInDiyTable()����ת�ƽ������� START */
			if (diyCfg) {
				// ����HTML�ϵ����ݣ�
				var diyType_div_obj = $("#" + diyType_div_id);
				// ��ѡ�������Ϊ��ѡ��״̬
				$("input:checkbox", diyType_div_obj).each(function() {
							$(this).removeAttr("checked");// ѡ�д���//$(this).attr("checked",
															// 'true');
						});
				$(".diyType_head input[name=tTitle]", diyType_div_obj)
						.val(diyCfg.tTitle);
				// ���ط���ı��������С
				$(".diyType_head input[name=tSize]", diyType_div_obj)
						.val(diyCfg.tSize);
				// ���ط���������
				var headInputList = $(".diyType_head input", diyType_div_obj);
				$(".diyType_head input[name=tSeq]", diyType_div_obj)
						.val(diyCfg.tSeq);
				// ���ط�����������С
				$(".diyType_head input[name=cSize]", diyType_div_obj)
						.val(diyCfg.cSize);
				// ���ط����ÿҳ��ʾ������
				$(".diyType_head input[name=cPageNo]", diyType_div_obj)
						.val(diyCfg.cPageNo);

				// if(diyCfg.tPlaceOrder==1)
				// $(".diyType_head input:checkbox[name=tPlaceOrder]",
				// diyType_div_obj).attr("checked", 'true');
				// if(diyCfg.tBidOrder==1)
				// $(".diyType_head input:checkbox[name=tBidOrder]",
				// diyType_div_obj).attr("checked", 'true');
				// if(diyCfg.tTransferOrder==1)
				// $(".diyType_head input:checkbox[name=tTransferOrder]",
				// diyType_div_obj).attr("checked", 'true');
				// if(diyCfg.tTenderOrder==1)
				// $(".diyType_head input:checkbox[name=tTenderOrder]",
				// diyType_div_obj).attr("checked", 'true');
				if (diyCfg.tT == 1)
					$(".diyType_head input:checkbox[name=tT]", diyType_div_obj)
							.attr("checked", 'true');
				if (diyCfg.tO == 1)
					$(".diyType_head input:checkbox[name=tO]", diyType_div_obj)
							.attr("checked", 'true');
				// alert(diyType_div_obj);
				// ��ʼ����������
				$(diyCfg.cols).each(function() {
					if (this.cEnable == 1) {
						var cTitle = this.cTitle;
						var cName = this.cName;
						var cEnable = this.cEnable;
						var cWidth = this.cWidth;
						var cSeq = this.cSeq;

						// add by yueliang 2013-9-5
						// �ҵ�����HTML��������
						// var colList =
						// $("input[name=cName][value="+cName+"]");
						var colList = diyType_div_obj
								.find("input[name='cName'][value='" + cName+ "']");

						// ѡ��ѡ���
						if (cEnable == 1)
							colList.parent()
									.find("input:checkbox[name=cEnable]").attr(
											"checked", 'true');
						else
							colList.parent()
									.find("input:checkbox[name=cEnable]")
									.removeAttr("checked");
						// ���ø��������
						colList.parent().parent().find("input[name=cTitle]").val(cTitle);
						colList.parent().parent().find("input[name=cWidth]").val(cWidth);
						colList.parent().parent().find("input[name=cSeq]").val(1);

						// // HTML�е����������List
						// var colsList = $(".cols", diyType_div_obj);
						// $(colsList).each(function(){
						// var colList = $("input[name=cName][value="+cName+"]",
						// this);
						// // �ҵ�����HTML��������
						// if(colList.length>0){
						// // ѡ��ѡ���
						// $("input:checkbox[name=cEnable]",
						// this).each(function(){
						// if(cEnable==1)
						// $(this).attr("checked", 'true');
						// else
						// $(this).removeAttr("checked");
						// });
						// // ���ø��������
						// $("input[name=cTitle]", this).val(cTitle);
						// $("input[name=cWidth]", this).val(cWidth);
						// $("input[name=cSeq]", this).val(cSeq);
						// }
						// });
					}

				});
			}
			/* 2011-7-21 ��Ϊ���Ӷ�̬���Զ���showCfgInDiyTable()����ת�ƽ������� END */

		},
		error : function() {
			// alert("����ʧ�ܻ�ʱ�����Ժ����ԣ�");
			return;
		}
	});

};

// �ύ��ʱ������װ���ݣ��뵽Form�У����ύ
function submitForm() {
	var tList = $("#ul-diy li");
	var cfgTxt = "[";
	if (tList.length > 0) {
		// ��ʼ��װ������
		tList.each(function(i) {
			if (cfgTxt.length > 1)
				cfgTxt = cfgTxt + ",";
			cfgTxt = cfgTxt + "{";

			// ��װdiyType_head������
			var inputList = $(".diyType_head input", tList[i]);
			var diyType_head_data = "";
			var diyType_head_data_tProjectType = "";
			if (inputList.length > 0) {
				inputList.each(function(j) {
					if (j > 0)
						diyType_head_data = diyType_head_data + ",";
					// ������׷�ʽ��״̬��ѡ����ѡ���ģ���װ��ֵΪ��1��������Ϊ��0��
					if ((
							// inputList[j].name == "tPlaceOrder"
							// || inputList[j].name == "tBidOrder"
							// || inputList[j].name == "tTransferOrder"
							// || inputList[j].name == "tTenderOrder"
							// ||
							inputList[j].name == "tT" || inputList[j].name == "tO")
							&& $(inputList[j]).attr("checked")) {
						diyType_head_data = diyType_head_data + "'"
								+ inputList[j].name.trimQuote() + "':'1'";
					}
					// else if(inputList[j].name == "tProjectType" &&
					// $(inputList[j]).attr("checked")) {
					// diyType_head_data_tProjectType =
					// diyType_head_data_tProjectType +
					// $(inputList[j]).val().trimQuote() + "-";
					// }
					else {
						diyType_head_data = diyType_head_data + "'"
								+ inputList[j].name.trimQuote() + "':'"
								+ $(inputList[j]).val().trimQuote() + "'";
					}

				});
				// if(diyType_head_data_tProjectType.length > 0)
				// diyType_head_data = diyType_head_data + ",'" +
				// inputList[j].name.trimQuote() + "':'" +
				// diyType_head_data_tProjectType + "'";
			}
			// ��װ�������õ�����
			var colsData = "";
			var colsList = $(".cols", tList[i]);
			if (colsList.length > 0) {
				colsData = colsData + ",cols:[";
				colsList.each(function(k) {
					var colsInputList = $("input", colsList[k]);
					var tmp = "";
					var isEnable = 1;
					if (colsInputList.length > 0) {
						colsInputList.each(function(j) {
									if (tmp != "") {
										tmp = tmp + ",";
									}
									if (colsInputList[j].name == "cEnable") { // type=="checkbox"
																				// //name=="cEnable"
										if ($(colsInputList[j]).attr("checked")) // �ж��Ƿ��Ѿ���
										{
											tmp = tmp
													+ "'"
													+ colsInputList[j].name
															.trimQuote()
													+ "':'1'";
										} else {
											isEnable = 0;
										}
									} else {
										tmp = tmp
												+ "'"
												+ colsInputList[j].name
														.trimQuote()
												+ "':'"
												+ $(colsInputList[j]).val()
														.trimQuote() + "'";
									}
								});
					}
					if (isEnable == 1) {
						if (colsData != ",cols:[")
							colsData = colsData + ",";
						colsData = colsData + "{";
						colsData = colsData + tmp;
						colsData = colsData + "}"
					}
				});
				colsData = colsData + "]";
			}

			// ��һ�������������װ��һ��
			cfgTxt = cfgTxt + diyType_head_data + colsData;

			cfgTxt = cfgTxt + "}";
		});
	}
	cfgTxt = cfgTxt + "]";

	$('#screenDiy_name').val($('#screenDiy_name_tmp').val());
	$('#screenDiy_diyCfg').val(cfgTxt);
	if ($('#screenDiy_name').val() == "") {
		alert("�������Ʋ���Ϊ�գ�");
		return false;
	}
	// return false;
}

function showCfgInDiyTable(diyCfg) {
	var newLiHtml = newLiHtml || liHtml;
	diyTable(newLiHtml, diyCfg.projectTypeCode, diyCfg.tradingType, diyCfg);
}

/**
 * �������е��������ݽ�������,���diyCfg����Json���󣬻��Զ��Ƚ�diyCfg��Stringת�ɶ���
 * 
 * @param {}
 *            diyCfgList
 * @return {}
 */
function sortCfg(diyCfgList) {
	diyCfgList = $.strToJson(diyCfgList);
	// if(diyCfgList.length<=1)
	// return diyCfgList;
	// 1:�������,��С��������
	for (i = 1; i < diyCfgList.length; i++) {
		for (j = 0; j < i; j++) {
			if (parseFloat(diyCfgList[i].tSeq) < parseFloat(diyCfgList[j].tSeq)) {
				var tmp = diyCfgList[i];
				diyCfgList[i] = diyCfgList[j];
				diyCfgList[j] = tmp;
			}
		}
	}
	// 2:��������µ����ֶ�,��С��������
	for (i = 0; i < diyCfgList.length; i++) {
		if (diyCfgList[i].cols.length <= 1)
			continue;
		for (j = 1; j < diyCfgList[i].cols.length; j++) {
			for (k = 0; k < j; k++) {
				if (parseFloat(diyCfgList[i].cols[j].cSeq) < parseFloat(diyCfgList[i].cols[k].cSeq)) {
					var tmp = diyCfgList[i].cols[j];
					diyCfgList[i].cols[j] = diyCfgList[i].cols[k];
					diyCfgList[i].cols[k] = tmp;
				}
			}
		}
	}

	return diyCfgList;
}

/**
 * �������������ļ���װ��HTML��
 * 
 * @param {}
 *            diyCfgList
 * @param {}
 *            typeIndex
 * @param {}
 *            dataTmpList
 * @return {String}
 */
function makeFrameTable(diyCfgList, typeIndex, dataTmpList) {
	if (diyCfgList.length < 1 || diyCfgList.length < typeIndex) {
		return "";
	}
	var diyCfgObj = diyCfgList[typeIndex];
	var count = diyCfgObj.cols.length;

	var itemsHtml = "<style>";
	itemsHtml += "\r .screenDiyDiv table thead tr th{ color:#f6f67a; text-align:center; line-height:30px; font-size:"
			+ diyCfgObj.tSize + "px;}";
	itemsHtml += "\r .screenDiyDiv table tbody tr th, .screenDiyDiv table tr td{ font-size:"
			+ diyCfgObj.cSize
			+ "px; line-height:22px; overflow:hidden;border:1px solid #fff; color:#00e32b; padding:0px 5px; font-weight:300; text-align:left;}";
	itemsHtml += "\r .screenDiyDiv table tbody tr th div{overflow:hidden;line-height:22px; height:22px;}";
	itemsHtml += "\r .screenDiyDiv table tr td div{color:#eb0b00; overflow:hidden;line-height:22px; height:22px;}";
	itemsHtml += "\r</style>";

	itemsHtml += "<table>";
	// ��ͷ
	itemsHtml += "<thead>";
	itemsHtml += "<tr>";
	itemsHtml += "<th colspan='" + count + "'><div style='overflow:hidden;'>"
			+ diyCfgObj.tTitle + "</div></th>";
	itemsHtml += "</tr>";
	itemsHtml += "</thead>";
	// ������
	itemsHtml += "<tbody>";
	// ��ͷ
	itemsHtml += "<tr>";
	for (i = 0; i < count; i++) {
		itemsHtml += "<th><div style='width:" + diyCfgObj.cols[i].cWidth
				+ "px;'>" + diyCfgObj.cols[i].cTitle + "</div></th>";
	}
	itemsHtml += "</tr>";
	// ����
	for (k = 0; k < dataTmpList.length; k++) {
		itemsHtml += "<tr>";
		for (i = 0; i < count; i++) {
			itemsHtml += "<td><div style='width:" + diyCfgObj.cols[i].cWidth
					+ "px;'>"
					+ eval("dataTmpList[k]." + diyCfgObj.cols[i].cName)
					+ "</div></td>";
		}
		itemsHtml += "</tr>";
	}

	itemsHtml += "</tbody>";

	itemsHtml += "</table>";

	return itemsHtml;
}

var nextTypeIndex = -1; // ������ס��ǰ��ʾ�����ĸ�����
var nextPage = 0; // ������ס��ǰ����ʾ�ĵڼ�ҳ
var dataList = [];// Ҫ��ʾ�������б�
/**
 * ��ȡ��һ�����͵������б�(ȫ��ȡ��������ҳ����ҳ��Web��)
 */
function getNextDataList(needShow) {
	nextTypeIndex++;
	if (diyCfgJson.length <= nextTypeIndex)
		nextTypeIndex = 0;
	var colsCfg = [];
	var colsCfgStrs = "";
	$(diyCfgJson[nextTypeIndex].cols).each(function() {
				colsCfg.push(this.cName);
				if (colsCfgStrs.length > 0)
					colsCfgStrs = colsCfgStrs + "," + this.cName;
				else
					colsCfgStrs = this.cName;
			});
	nextPage = 0;
	dataList = [];
	$.ajax({
				type : "POST",
				url : ajaxUrl,
				cache : false,
				data : {
					// "tProjectType": diyCfgJson[nextTypeIndex].tProjectType,
					"tProjectType" : diyCfgJson[nextTypeIndex].projectTypeCode,
					"tTradingType" : diyCfgJson[nextTypeIndex].tradingType,
					// "tPlaceOrder": diyCfgJson[nextTypeIndex].tPlaceOrder,
					// "tBidOrder": diyCfgJson[nextTypeIndex].tBidOrder,
					// "tTransferOrder":
					// diyCfgJson[nextTypeIndex].tTransferOrder,
					// "tTenderOrder": diyCfgJson[nextTypeIndex].tTenderOrder,
					"tT" : diyCfgJson[nextTypeIndex].tT,
					"tO" : diyCfgJson[nextTypeIndex].tO,
					"cols" : colsCfgStrs,// colsCfg,
					random : Math.random()
				},
				dataType : "json",
				timeout : 30000,
				success : function(json) {
					dataList = json.data;
					// �������д��붼���ܻ��������ѭ�������������û�����ݵĻ��ͻ���֣�
					if (needShow == true)
						showNextData(); // Ajax����������ȥչʾ���ݣ�������������ַ����ĺ��
					// if(dataList.length<1) getNextDataList(); //
					// ����˷���û�����ݣ���ȡ��һ������
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					// alert("����ʧ�ܻ�ʱ�����Ժ����ԣ�"+XMLHttpRequest+textStatus+errorThrown);
					return;
				}
			});
	// ���������
	// var count = diyCfgJson[nextTypeIndex].cols.length;
	// for (i=0;i<50;i++){
	// var dataObj={};
	// for(j=0;j<count;j++){
	// eval("dataObj."+diyCfgJson[nextTypeIndex].cols[j].cName+"='"+"��������-"+j+"-"+i+"'");
	// }
	// dataList.push(dataObj);
	// }
	// alert(dataList[0]);

}

function showNextData() {
	if (diyCfgJson.length < 1)
		return;
	if (dataList.length < 1 || diyCfgJson.length <= nextTypeIndex) {
		getNextDataList();
		// �������ݺ󣬻����µ�showNextData()��������ʾ���ݣ����ԣ���������ʱ���Ͳ��ټ�����ʾ������
		return;
	}
	// ��ͣ����ʱ��
	// $('body').stopTime ('showNextDataTime');
	// ȡ��Ҫ��ʾ������
	var cPageNo = diyCfgJson[nextTypeIndex].cPageNo;
	var dataListTmp = [];
	var count = dataList.length;
	for (i = 0; i < cPageNo && i < count; i++) {
		dataListTmp.push(dataList[0]);
		dataList.remove(0);// ɾ����һ��
	}
	// ��װ���ģ��
	frameTable = makeFrameTable(diyCfgJson, nextTypeIndex, dataListTmp);
	$('#screenDiyDiv').html(frameTable);

	nextPage++;
	// ���������ݺ���������ʱ��
	// $('body').everyTime('5s','showNextDataTime',showNextData);
}

$(document).ready(function() {
			var diyCfgTmp = $.strToJson(diyCfgJson);
			// ## �޸�ʱ������������Ϣ
			if (doWhat == "edit" && screenDiy_id != "") {
				// ��������Ϣ������HTML��ʾ����
				if (diyCfgTmp.length > 0) {
					diyCfgTmp = sortCfg(diyCfgTmp);
					// $("#screenDiy_diyCfg_test").html($.jsonToStr(diyCfgJson));
					$(diyCfgTmp).each(function(i) {
								showCfgInDiyTable(diyCfgTmp[i]);
							})
				}
			}
			// ������ʾ
			if (doWhat == "show" && screenDiy_id != "") {
				// ��������Ϣ������HTML��ʾ����
				if (diyCfgTmp.length > 0) {
					diyCfgJson = sortCfg(diyCfgTmp);
					// $("#screenDiy_diyCfg_test").html($.jsonToStr(diyCfgJson));
					getNextDataList(true);
					// ����һ����ʱ��
					$('body').everyTime('5s', 'showNextDataTime', showNextData);
					// $('body').stopTime ('showNextDataTime');
				}
			}

		});