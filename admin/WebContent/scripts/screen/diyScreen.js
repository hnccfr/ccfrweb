// ===========基础模板 开始=====================
var liHtml;
liHtml = "<li id='[[diyType_div_id]]' class='diyType_div_obj' style='margin:3px 3px 0 3px;border:1px solid #9eaeb9;'>";
// 分类主配置，在输入框的父容器上加上 class='diyType_head'
liHtml += "<div class='diyType_head' style='margin:3px 3px 0 3px;'>";
liHtml += "<input type='hidden' name='projectTypeCode' value='[[screenDiy_projectTypeCode]]'/><input type='hidden' name='tradingType' value='[[screenDiy_tradingType]]'/>";
liHtml += "<p class='p1'><strong>&nbsp;分类标题：</strong><input type='text' name='tTitle' value='[[screenDiy_tTitle]]' style='width: 400px;' />";
//liHtml += "<p class='p1'><strong>&nbsp;分类标题：</strong><input type='text' name='tTitle' value='' style='width: 400px;' />";
liHtml += "&nbsp;排序号：<input type='text' name='tSeq' value='10'/></p>";
liHtml += "<p class='p3'>-<a href='javascript:void(0);' class='link-close'>展开</a> -<a href='javascript:void(0);'  class='link-del'>删除</a></p>";
liHtml += "</div>";
liHtml += "<table width='100%' class='c4' style='display:none'>";
liHtml += "<tr>";
liHtml += "<td colspan='4' class='diyType_head gl'>&nbsp;标题字体大小(像素)：<input type='text'  name='tSize' value='20'/>&nbsp;列字体大小(像素):<input type='text' name='cSize' value='12'/>&nbsp;每次显示条数:<input type='text' name='cPageNo' value='10'/></td>";
liHtml += "</tr>";

// liHtml += "<tr>";
// liHtml += "<td class='diyType_head gl' colspan='2'>&nbsp;<strong>交易方式：</strong>";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tPlaceOrder' value='0'/>下单交易";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tBidOrder' value='0'/>拍卖交易";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tTransferOrder' value='0'/>协议转让";
// liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tTenderOrder' value='0'/>招标转让";
// liHtml += "</td>";
// liHtml += "</tr>";
liHtml += "<tr>";
liHtml += "<td class='diyType_head gl' colspan='2'>&nbsp;<strong>状态：</strong>";
liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tT' value='0'/>挂牌项目";
liHtml += "&nbsp;<input type='checkbox' checked='checked' name='tO' value='0'/>成交项目";
liHtml += "</td>";
liHtml += "</tr>";
// ---------------------------------
liHtml += "<tr>";
liHtml += "<td>&nbsp;&nbsp;<strong>字段名</strong></td>";
liHtml += "<td><strong>列标题</strong></td>";
liHtml += "<td><strong>列宽：像素</strong></td>";
liHtml += "<td><strong>排序号</strong></td>";
liHtml += "</tr>";

// ## 定制要显示的列 - 开始
// ## 表PROJECT_LISTING中的字段：
liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='TITLE'/>项目名称</td>"; // TITLE
liHtml += "<td><input type='text' name='cTitle' value='项目名称' style='width: 200px;' /></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='CODE'/>项目编号</td>"; // CODE
liHtml += "<td><input type='text' name='cTitle' value='项目编号' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_TYPE'/>销售/采购</td>"; // LISTING_TYPE
liHtml += "<td><input type='text' name='cTitle' value='销售/采购' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='QUANTITY'/>挂牌数量</td>"; // QUANTITY
liHtml += "<td><input type='text' name='cTitle' value='挂牌数量' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_PRICE'/>挂牌价格</td>"; // LISTING_PRICE
liHtml += "<td><input type='text' name='cTitle' value='挂牌价格' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='PROJECT_TYPE_CODE'/>项目类型</td>"; // PROJECT_TYPE_CODE
liHtml += "<td><input type='text' name='cTitle' value='项目类型' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' checked='checked' name='cEnable' value='1' /><input type='hidden' name='cName' value='TRADING_TYPE'/>交易方式</td>"; // TRADING_TYPE
liHtml += "<td><input type='text' name='cTitle' value='交易方式' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_START_TIME'/>挂牌开始时间</td>"; // LISTING_START_TIME
liHtml += "<td><input type='text' name='cTitle' value='挂牌开始时间' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='LISTING_END_TIME'/>挂牌结束时间</td>"; // LISTING_END_TIME
liHtml += "<td><input type='text' name='cTitle' value='挂牌结束时间' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='USER_ACCOUNT'/>挂牌账号</td>"; // USER_ACCOUNT
liHtml += "<td><input type='text' name='cTitle' value='挂牌账号' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='DELIVERY_DATE'/>交货日期</td>"; // DELIVERY_DATE
liHtml += "<td><input type='text' name='cTitle' value='交货日期' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ADDRESS'/>地址</td>"; // ADDRESS
liHtml += "<td><input type='text' name='cTitle' value='地址' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

// ## 成交记录可以参看订单表TRADE_ORDER中的字段，来选择添加进模板
// liHtml += "<tr class='cols'>";
// liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_NO'/>订单编号(成交属性)</td>";
// liHtml += "<td><input type='Text' name='cTitle' value='订单编号' style='width:200px;'/></td>";
// liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
// liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
// liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='BID_PRICE'/>成交单价(成交属性)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='成交单价' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_QUANTITY'/>成交数量(成交属性)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='成交数量' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_AMOUNT'/>成交总价(成交属性)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='成交总价' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='DELIVERY_TYPE'/>交货方式(成交属性)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='交货方式' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='PAYMENT_TYPE'/>支付方式(成交属性)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='支付方式' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

liHtml += "<tr class='cols'>";
liHtml += "<td>&nbsp;<input type='checkbox' name='cEnable' value='1' /><input type='hidden' name='cName' value='ORDER_STATUS'/>订单状态(成交属性)</td>";
liHtml += "<td><input type='Text' name='cTitle' value='订单状态' style='width: 200px;'/></td>";
liHtml += "<td><input type='text' name='cWidth' value='80'/></td>";
liHtml += "<td><input type='text' name='cSeq' value='10'/></td>";
liHtml += "</tr>";

// ===========基础模板 结束=====================

// =========== 动态属性的模板 =====================
var liHtmlD = ""; // 在diyTable()函数里，通过AJAX取得json数据拼装

// =================================================
// 扩展JS的replaceAll功能
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
}
// 将字符串中的双引号和单引号过滤成下划线
String.prototype.trimQuote = function() {
	return this.replaceAll("'", "_").replaceAll("\"", "_");
}
// 生成随机数
function rand(number) {
	number = number || 99999999;
	number = Math.floor(Math.random() * number + 1); // 1-number
	return number;
}
/*
 * 方法:Array.remove(dx) 功能:删除数组元素. 参数:dx删除元素的下标. 返回:在原数组上修改数组
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
// 扩展Json相关功能：
jQuery.extend({
			/**
			 * @see 将json字符串转换为对象
			 * @param json字符串
			 * @return 返回object,array,string等对象
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
			 * @see 将javascript数据类型转换为json字符串
			 * @param 待转换对象,支持object,array,string,function,number,boolean,regexp
			 * @return 返回json字符串
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
	// 要替换的值

	// 动态属性
	projectTypeCode = $("#projectTypeCode").val();
	projectTypeCodeText = $("#projectTypeCodeText").val();

	tradingType = $("#tradingType").val();
	tradingTypeText = $("#tradingTypeText").val();

//	diyType_div_id = projectTypeCode + "-" + tradingType + "-" + rand();
	diyType_div_id = new Date().getTime() + "";
	screenDiy_tTitle = projectTypeCodeText + "-" + tradingTypeText + "-";
	// diyType_div_id = rand();
	// 替换模板中的项目类型
	newLiHtml = newLiHtml.replace("[[screenDiy_projectTypeCode]]",
			projectTypeCode);
	// 替换模板中的交易方式
	newLiHtml = newLiHtml.replace("[[screenDiy_tradingType]]", tradingType);
	// 替换模板中的分类Div的ID
	newLiHtml = newLiHtml.replace("[[diyType_div_id]]", diyType_div_id);
	// 替换模板中的分类标题
	newLiHtml = newLiHtml.replace("[[screenDiy_tTitle]]", screenDiy_tTitle);
	return newLiHtml;
}

// ===============================================
function diyTable(newLiHtml, projectTypeCode, projectTradingType, diyCfg) {
	// 判断大屏类型，而选择用哪个模板

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
			// /* 2011-7-21 因为增加动态属性而从showCfgInDiyTable()函数转移进这里里 START */
			var diyType_div_id;
			var screenDiy_tTitle;
			if (diyCfg) {
				// 替换模板中的分类Div的ID
				//	diyType_div_id = typeCode + "-" + tradingType + "-" + rand();
				diyType_div_id = new Date().getTime() + "";
				// diyType_div_id = rand();
				newLiHtml = newLiHtml.replace("[[diyType_div_id]]",
						diyType_div_id);
				// 替换模板中的分类标题
				screenDiy_tTitle = diyCfg.tTitle;
				newLiHtml = newLiHtml.replace("[[screenDiy_tTitle]]",
						screenDiy_tTitle);
				// 替换模板中的标的物类型
				newLiHtml = newLiHtml.replace("[[screenDiy_projectTypeCode]]",
						diyCfg.projectTypeCode);
				// 替换模板中的交易方式
				newLiHtml = newLiHtml.replace("[[screenDiy_tradingType]]",
						diyCfg.tradingType);
			}
			/* 2011-7-21 因为增加动态属性而从showCfgInDiyTable()函数转移进这里里 END */
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
			newLiHtml += liHtmlD;// 加进动态属性模板2011-7-20
			newLiHtml += "</table></li>";// 给动态属性模板加上尾巴 2011-7-20

			newLiHtml = replaceData(newLiHtml);

			$(".ul-diy").append(newLiHtml);
			$(".ul-diy .link-close").unbind().toggle(function() {
						$(this).html("收起").addClass("link-close");
						$(this).parent().parent().next("table").show();
					}, function() {
						$(this).html("展开").removeClass("link-show");
						$(this).parent().parent().next("table").hide();
					});

			$(".ul-diy .link-del").unbind().click(function() {
						$(this).parent().parent().parent().remove();
					});

			/* 2011-7-21 因为增加动态属性而从showCfgInDiyTable()函数转移进这里里 START */
			if (diyCfg) {
				// 加载HTML上的数据：
				var diyType_div_obj = $("#" + diyType_div_id);
				// 将选择框重置为不选中状态
				$("input:checkbox", diyType_div_obj).each(function() {
							$(this).removeAttr("checked");// 选中代码//$(this).attr("checked",
															// 'true');
						});
				$(".diyType_head input[name=tTitle]", diyType_div_obj)
						.val(diyCfg.tTitle);
				// 加载分类的标题字体大小
				$(".diyType_head input[name=tSize]", diyType_div_obj)
						.val(diyCfg.tSize);
				// 加载分类的排序号
				var headInputList = $(".diyType_head input", diyType_div_obj);
				$(".diyType_head input[name=tSeq]", diyType_div_obj)
						.val(diyCfg.tSeq);
				// 加载分类的列字体大小
				$(".diyType_head input[name=cSize]", diyType_div_obj)
						.val(diyCfg.cSize);
				// 加载分类的每页显示多少条
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
				// 开始加载列配置
				$(diyCfg.cols).each(function() {
					if (this.cEnable == 1) {
						var cTitle = this.cTitle;
						var cName = this.cName;
						var cEnable = this.cEnable;
						var cWidth = this.cWidth;
						var cSeq = this.cSeq;

						// add by yueliang 2013-9-5
						// 找到此项HTML列配置组
						// var colList =
						// $("input[name=cName][value="+cName+"]");
						var colList = diyType_div_obj
								.find("input[name='cName'][value='" + cName+ "']");

						// 选中选择框
						if (cEnable == 1)
							colList.parent()
									.find("input:checkbox[name=cEnable]").attr(
											"checked", 'true');
						else
							colList.parent()
									.find("input:checkbox[name=cEnable]")
									.removeAttr("checked");
						// 设置各项的数据
						colList.parent().parent().find("input[name=cTitle]").val(cTitle);
						colList.parent().parent().find("input[name=cWidth]").val(cWidth);
						colList.parent().parent().find("input[name=cSeq]").val(1);

						// // HTML中的列组合配置List
						// var colsList = $(".cols", diyType_div_obj);
						// $(colsList).each(function(){
						// var colList = $("input[name=cName][value="+cName+"]",
						// this);
						// // 找到此项HTML列配置组
						// if(colList.length>0){
						// // 选中选择框
						// $("input:checkbox[name=cEnable]",
						// this).each(function(){
						// if(cEnable==1)
						// $(this).attr("checked", 'true');
						// else
						// $(this).removeAttr("checked");
						// });
						// // 设置各项的数据
						// $("input[name=cTitle]", this).val(cTitle);
						// $("input[name=cWidth]", this).val(cWidth);
						// $("input[name=cSeq]", this).val(cSeq);
						// }
						// });
					}

				});
			}
			/* 2011-7-21 因为增加动态属性而从showCfgInDiyTable()函数转移进这里里 END */

		},
		error : function() {
			// alert("请求失败或超时，请稍后再试！");
			return;
		}
	});

};

// 提交表单时，先组装数据，入到Form中，再提交
function submitForm() {
	var tList = $("#ul-diy li");
	var cfgTxt = "[";
	if (tList.length > 0) {
		// 开始组装各分类
		tList.each(function(i) {
			if (cfgTxt.length > 1)
				cfgTxt = cfgTxt + ",";
			cfgTxt = cfgTxt + "{";

			// 组装diyType_head的数据
			var inputList = $(".diyType_head input", tList[i]);
			var diyType_head_data = "";
			var diyType_head_data_tProjectType = "";
			if (inputList.length > 0) {
				inputList.each(function(j) {
					if (j > 0)
						diyType_head_data = diyType_head_data + ",";
					// 如果交易方式、状态等选择是选定的，组装的值为“1”，否则为“0”
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
			// 组装各列配置的数据
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
										if ($(colsInputList[j]).attr("checked")) // 判断是否已经打勾
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

			// 将一个分类的数据组装到一起
			cfgTxt = cfgTxt + diyType_head_data + colsData;

			cfgTxt = cfgTxt + "}";
		});
	}
	cfgTxt = cfgTxt + "]";

	$('#screenDiy_name').val($('#screenDiy_name_tmp').val());
	$('#screenDiy_diyCfg').val(cfgTxt);
	if ($('#screenDiy_name').val() == "") {
		alert("大屏名称不能为空！");
		return false;
	}
	// return false;
}

function showCfgInDiyTable(diyCfg) {
	var newLiHtml = newLiHtml || liHtml;
	diyTable(newLiHtml, diyCfg.projectTypeCode, diyCfg.tradingType, diyCfg);
}

/**
 * 把配置中的排序内容进行排序,如果diyCfg不是Json对象，会自动先将diyCfg从String转成对象
 * 
 * @param {}
 *            diyCfgList
 * @return {}
 */
function sortCfg(diyCfgList) {
	diyCfgList = $.strToJson(diyCfgList);
	// if(diyCfgList.length<=1)
	// return diyCfgList;
	// 1:排序分类,从小到大排列
	for (i = 1; i < diyCfgList.length; i++) {
		for (j = 0; j < i; j++) {
			if (parseFloat(diyCfgList[i].tSeq) < parseFloat(diyCfgList[j].tSeq)) {
				var tmp = diyCfgList[i];
				diyCfgList[i] = diyCfgList[j];
				diyCfgList[j] = tmp;
			}
		}
	}
	// 2:排序分类下的列字段,从小到大排列
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
 * 将数据与配置文件组装成HTML；
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
	// 表头
	itemsHtml += "<thead>";
	itemsHtml += "<tr>";
	itemsHtml += "<th colspan='" + count + "'><div style='overflow:hidden;'>"
			+ diyCfgObj.tTitle + "</div></th>";
	itemsHtml += "</tr>";
	itemsHtml += "</thead>";
	// 表数据
	itemsHtml += "<tbody>";
	// 列头
	itemsHtml += "<tr>";
	for (i = 0; i < count; i++) {
		itemsHtml += "<th><div style='width:" + diyCfgObj.cols[i].cWidth
				+ "px;'>" + diyCfgObj.cols[i].cTitle + "</div></th>";
	}
	itemsHtml += "</tr>";
	// 数据
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

var nextTypeIndex = -1; // 用来记住当前显示的是哪个分类
var nextPage = 0; // 用来记住当前是显示的第几页
var dataList = [];// 要显示的数据列表
/**
 * 获取下一个类型的数据列表(全部取出，不分页，分页在Web端)
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
					// 以下两行代码都可能会带来无限循环（如果服务器没有数据的话就会出现）
					if (needShow == true)
						showNextData(); // Ajax结束后立刻去展示数据，会出现下面这种方法的后果
					// if(dataList.length<1) getNextDataList(); //
					// 如果此分类没有数据，再取下一个分类
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					// alert("请求失败或超时，请稍后再试！"+XMLHttpRequest+textStatus+errorThrown);
					return;
				}
			});
	// 造测试数据
	// var count = diyCfgJson[nextTypeIndex].cols.length;
	// for (i=0;i<50;i++){
	// var dataObj={};
	// for(j=0;j<count;j++){
	// eval("dataObj."+diyCfgJson[nextTypeIndex].cols[j].cName+"='"+"测试数据-"+j+"-"+i+"'");
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
		// 拿完数据后，会重新调showNextData()方法来显示数据，所以，在拿数据时，就不再继续显示数据了
		return;
	}
	// 先停掉定时器
	// $('body').stopTime ('showNextDataTime');
	// 取出要显示的数据
	var cPageNo = diyCfgJson[nextTypeIndex].cPageNo;
	var dataListTmp = [];
	var count = dataList.length;
	for (i = 0; i < cPageNo && i < count; i++) {
		dataListTmp.push(dataList[0]);
		dataList.remove(0);// 删除第一项
	}
	// 组装表格模板
	frameTable = makeFrameTable(diyCfgJson, nextTypeIndex, dataListTmp);
	$('#screenDiyDiv').html(frameTable);

	nextPage++;
	// 加载完数据后，再重启定时器
	// $('body').everyTime('5s','showNextDataTime',showNextData);
}

$(document).ready(function() {
			var diyCfgTmp = $.strToJson(diyCfgJson);
			// ## 修改时，解析配置信息
			if (doWhat == "edit" && screenDiy_id != "") {
				// 将配置信息解析成HTML显示出来
				if (diyCfgTmp.length > 0) {
					diyCfgTmp = sortCfg(diyCfgTmp);
					// $("#screenDiy_diyCfg_test").html($.jsonToStr(diyCfgJson));
					$(diyCfgTmp).each(function(i) {
								showCfgInDiyTable(diyCfgTmp[i]);
							})
				}
			}
			// 大屏显示
			if (doWhat == "show" && screenDiy_id != "") {
				// 将配置信息解析成HTML显示出来
				if (diyCfgTmp.length > 0) {
					diyCfgJson = sortCfg(diyCfgTmp);
					// $("#screenDiy_diyCfg_test").html($.jsonToStr(diyCfgJson));
					getNextDataList(true);
					// 启动一个定时器
					$('body').everyTime('5s', 'showNextDataTime', showNextData);
					// $('body').stopTime ('showNextDataTime');
				}
			}

		});