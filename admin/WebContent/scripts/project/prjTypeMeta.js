var prjTypeUrl = {
	nodesURL : appServer + "/ajax/getProjectTypeTree.htm",
	prjTypeMetaFormURL : appServer + "/project/type/attri.htm",
	prjTradeTypeFormURL : appServer + "/project/tradeType/attri.htm?dd="
			+ new Date().getTime(),
	projectStandURL : appServer + "/project/standard.htm"
};
var metaErrors = "";
var metaSubmitValue = "";
$(function() {
	metaErrors = $("#metaErrors").val();
	metaSubmitValue = $("#metaSubmitValue").val();
	if (typeof (metaErrors) != 'undefined' && metaErrors && metaErrors != "") {
		metaErrors = eval('(' + metaErrors + ')'); // 动态属性的提示对象
	}
	if (typeof (metaSubmitValue) != 'undefined' && metaSubmitValue
			&& metaSubmitValue != "") {
		metaSubmitValue = eval('(' + metaSubmitValue + ')'); // 属性的上次提交的保存值
	}
});

// 类型动态属性表单缓存,以免切换类型时,造成已输数据丢失
var prjTypeMetaFormCache = {};
// 项目的交易属性表单缓存
var projectTradeFormCache = {};
var a = new Array();
// 类型树数据缓存
var prjTypeTree;
/**
 * 
 * @param followObj
 *            弹出层要跟随的按钮或输入框(元素对象,或元素ID)
 * @param yesFn
 *            选择后的回调函数,参数为选中的对象,
 *            结构为{code:value,name:value,parentcode:value,parentcodeShort:value}
 * @param valueClass
 *            默认处理时,将选择的数据code要放入的HTML标签Class,默认为:projectTypeCode
 * @param nameClass
 *            默认处理时,将选择的数据name要放入的HTML标签Class,默认为:projectTypeName
 * @param prjTypeMetaBoxId
 *            默认处理时,将根据选择的类型,动态请求服务器获取该类型的动态属性表单,请显示在prjTypeMetaBoxId容器中,默认为:prjTypeMetaBox
 */
function showPrjTypeSel(followObj, yesFn, valueClass, nameClass,
		prjTypeMetaBoxId) {
	showPrjTypeArtBox(followObj,
			'<span style="color:green;">正在加载项目类型,请稍候...</span>', function() {
			});
	var prjTypeTreeUL_Tmp = $("#prjTypeTreeUL");
	if (!prjTypeTreeUL_Tmp || prjTypeTreeUL_Tmp.length == 0) {
		prjTypeTreeUL_Tmp = $('<ul id="prjTypeTreeUL" class="tree" style="display:none;"></ul>');
		$("body").append(prjTypeTreeUL_Tmp);
		prjTypeTree = reloadPrjTypeTree('prjTypeTreeUL', null, function(event,
				treeId, treeNode, msg) {
			showPrjTypeArtBox(followObj, '', yesFn, valueClass, nameClass,
					prjTypeMetaBoxId);
		}, function(event, treeId, treeNode, XMLHttpRequest, textStatus,
				errorThrown) {
			prjTypeTreeUL_Tmp.remove();
			showPrjTypeArtBox(followObj,
					'<span style="color:red;">加载项目类型失败!请稍后再试!</span>',
					function() {
					});
		});
	} else {
		showPrjTypeArtBox(followObj, '', yesFn, valueClass, nameClass,
				prjTypeMetaBoxId);
	}
}
function showPrjTypeArtBox(followObj, content, yesFn, valueClass, nameClass,
		prjTypeMetaBoxId) {
	var op = {
		id : "prjTypeSelBox",
		title : "请选择项目类型!",
		drag : true,
		// lock : true,
		padding : 0,
		fixed : true,
		content : document.getElementById('prjTypeTreeUL'),
		yesFn : function() {
			var data = prjTypeTree.getSelectedNode()
			fn = yesFn || defaultPrjTypeSelYesFn;
			fn(data, valueClass, nameClass, prjTypeMetaBoxId);
			$("select").attr("disabled", "");// 业务需求：类型框关闭后标准属性可编辑
		return data;
	},
	noFn : function() {
		$("select").attr("disabled", "");// 业务需求：类型框关闭后标准属性可编辑
	}
	};
	if (content)
		op.content = content;
	if (typeof (followObj) == "object")
		op.follow = followObj;
	else if (typeof (followObj) == "string")
		op.follow = document.getElementById(followObj);
	try {
		art.dialog.list['prjTypeSelBox'].close();
	} catch (e) {
	}
	$("select").attr("disabled", "disabled");// 业务需求：在弹出动态类型框的时候不能选择标准属性
	art.dialog(op);
}

/**
 * 默认的选择后确定按钮处理
 * 
 * @param data
 *            结构为{code:value,name:value,parentcode:value,parentcodeShort:value}
 * @param valueClassDefault
 *            默认处理时,将选择的数据code要放入的HTML标签Class,默认为:projectTypeCode
 * @param nameClassDefault
 *            默认处理时,将选择的数据name要放入的HTML标签Class,默认为:projectTypeName
 * @param prjTypeMetaBoxId
 *            默认处理时,将根据选择的类型,动态请求服务器获取该类型的动态属性表单,请显示在prjTypeMetaBoxId容器中,默认为:prjTypeMetaBox
 */
function defaultPrjTypeSelYesFn(data, valueClass, nameClass, prjTypeMetaBoxId) {
	if (!data)
		return;
	valueClass = valueClass || "projectTypeCode";
	nameClass = nameClass || "projectTypeName";
	prjTypeMetaBoxId = prjTypeMetaBoxId || "prjTypeMetaBox";

	var curType = "";
	if ($(":input." + valueClass).length > 0)
		curType = $($(":input." + valueClass)[0]).val();

	$("#" + valueClass).val(data.code);
	$("#" + nameClass).val(data.name);
	$("span." + valueClass).text(data.code);
	$("span." + nameClass).text(data.name);
	// 根据选择的项目类型编码，再去取标准属性
	$
			.ajax( {
				type : "GET",
				cache : false,
				url : prjTypeUrl.projectStandURL,
				dataType : "json",
				// drag : true,
				// lock : true,
				data : "projectTypeCode=" + data.code,
				async : false,
				success : function(projectStandObject) {
					if (projectStandObject && projectStandObject.length > 0) { // 项目类型包含动态属性
						$("#breedStandardSelect").empty(); // 清空标准属性下拉列表选项
						$("#breedStandardSelect").append(
								"<option value='0'>请选择</option>");
						for ( var i = 0; i < projectStandObject.length; i++) {
							$("#breedStandardSelect").append(
									"<option value='"
											+ projectStandObject[i].id + "'>"
											+ projectStandObject[i].name
											+ "</option>");
						}

					} else { // 无动态属性

					}
				}
			});
	$("#standShowId").empty();
	var breedStandard = $("#breedStandard");
	var breedStandardId = $("#breedStandardId");
	if (breedStandard && breedStandard != "undefined") {
		breedStandard.val("");
	}
	if (breedStandardId && breedStandardId != "undefined") {
		breedStandardId.val("");
	}
	// 当前类型
	var prjTypeMetaBox = $("#" + prjTypeMetaBoxId);
	if (!prjTypeMetaBox || prjTypeMetaBox.length == 0)
		return;

	if (curType) {
		prjTypeMetaFormCache[curType] = prjTypeMetaBox.html();
	}
	loadPrjTypeMetaFormURL(data.code, valueClass, nameClass, prjTypeMetaBoxId,
			""); // --加载动态属性
	
	// $("#breedStandardSelect").empty(); // 清空标准属性下拉列表选项
}
/**
 * 加载项目类型动态属性
 * 
 * @param typeCode
 * @param valueClass
 * @param nameClass
 * @param prjTypeMetaBoxId
 * @param projectId
 * @return
 */
function loadPrjTypeMetaFormURL(typeCode, valueClass, nameClass,
		prjTypeMetaBoxId, projectId) {

	valueClass = valueClass || "projectTypeCode";
	nameClass = nameClass || "projectTypeName";
	prjTypeMetaBoxId = prjTypeMetaBoxId || "prjTypeMetaBox";
	projectId = projectId || "";

	// 组装表单
	var prjTypeMetaBox = $("#" + prjTypeMetaBoxId);
	if (!prjTypeMetaBox || prjTypeMetaBox.length == 0)
		return;

	// 如果缓存中存在 , 就取缓冲表单, 否则请求服务器组装表单
	if (prjTypeMetaFormCache[typeCode]) {
		prjTypeMetaBox.html(prjTypeMetaFormCache[typeCode]);
	} else {
		prjTypeMetaBox.after("<div id='tmp_msg-tip'>正在加载动态属性中,请稍候...</div>");
		prjTypeMetaBox.load(prjTypeUrl.prjTypeMetaFormURL, {
			typeCode : typeCode,
			projectId : projectId
		}, function(responseText, textStatus, XMLHttpRequest) {
			$("#tmp_msg-tip").remove()
			onCompleteValueSeting("dynamic");
		});
	}
}
/**
 * 加载项目的交易属性
 * 
 * @param tradeTypeStr
 * @param prjTradeTypeBoxId
 * @param pid
 * @return
 */
function loadPrjTradeTypeFormURL(tradeTypeStr, prjTradeTypeBoxId, pid) {

	prjTradeTypeBoxId = prjTradeTypeBoxId || "prjTradeTypeBoxId";
	pid = pid || "";

	// 组装表单
	var prjTradeTypeBox = $("#" + prjTradeTypeBoxId);
	if (!prjTradeTypeBox || prjTradeTypeBox.length == 0)
		return;

	// 如果缓存中存在 , 就取缓冲表单, 否则请求服务器组装表单
	if (typeof (projectTradeFormCache) != "undefined"
			&& projectTradeFormCache[tradeTypeStr]) {
		if ("placeOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[0]);
		if ("bidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[1]);
		if ("dynamic" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[2]);
		if ("mulitBidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[3]);
		if ("transferOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[4]);
		if ("tenderOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[5]);

		prjTradeTypeBox.html(projectTradeFormCache[tradeTypeStr]);
	} else {
		prjTradeTypeBox.after("<div id='tmp_msg-tip'>正在加载交易属性中,请稍候...</div>");
		prjTradeTypeBox.load(prjTypeUrl.prjTradeTypeFormURL, {
			tradeType : tradeTypeStr,
			projectId : pid
		}, function(responseText, textStatus, XMLHttpRequest) {
			$("#tmp_msg-tip").remove();
			onCompleteErrorShow(tradeTypeStr);
			onCompleteValueSeting(tradeTypeStr);
			// onCompleteEventBinder(tradeTypeStr);
				if (tradeTypeStr) {
					projectTradeFormCache[tradeTypeStr] = prjTradeTypeBox
							.html();
				}
			});
	}

}
/**
 * <重写>加载项目的交易属性
 * 下单交易的情况下需要根据买卖方向加载属性的显示
 *	增加买卖类型的参数bsType
 * @param tradeTypeStr
 * @param prjTradeTypeBoxId
 * @param pid
 * add by guowei 2012-3-19
 */
function loadPrjTradeTypeDisByBsType(tradeTypeStr, prjTradeTypeBoxId, pid, bsType) {

	prjTradeTypeBoxId = prjTradeTypeBoxId || "prjTradeTypeBoxId";
	pid = pid || "";

	// 组装表单
	var prjTradeTypeBox = $("#" + prjTradeTypeBoxId);
	if (!prjTradeTypeBox || prjTradeTypeBox.length == 0)
		return;

	// 如果缓存中存在 , 就取缓冲表单, 否则请求服务器组装表单
	if (typeof (projectTradeFormCache) != "undefined"
			&& projectTradeFormCache[tradeTypeStr]) {
		if ("placeOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[0]);
		if ("bidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[1]);
		if ("dynamic" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[2]);
		if ("mulitBidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[3]);
		if ("transferOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[4]);
		if ("tenderOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[5]);

		prjTradeTypeBox.html(projectTradeFormCache[tradeTypeStr]);
	} else {
		//var url = appServer + "/project/tradeType/attri.htm";
		prjTradeTypeBox.after("<div id='tmp_msg-tip'>正在加载交易属性中,请稍候...</div>");
		prjTradeTypeBox.load(prjTypeUrl.prjTradeTypeFormURL, {
			tradeType : tradeTypeStr,
			projectId : pid,
			bsType : bsType
		}, function(responseText, textStatus, XMLHttpRequest) {
				$("#tmp_msg-tip").remove();
				onCompleteErrorShow(tradeTypeStr);
				onCompleteValueSeting(tradeTypeStr);
				// onCompleteEventBinder(tradeTypeStr);
				if (tradeTypeStr) {
						projectTradeFormCache[tradeTypeStr] = prjTradeTypeBox
								.html();
				}
				if(tradeTypeStr == "placeOrder"){
					renderPlaceOrderTradeMeta(tradeTypeStr);
				}
			});
	}

}

/**下单交易属性加载完成后，渲染下单交易属性的样式
 * add by guowei 2012-3-22
 * **/
function renderPlaceOrderTradeMeta(tradeType){
	if(tradeType =="placeOrder"){
		var bsTypeObj = $("input[id='retail']:checked");
		if (bsTypeObj.length !=0){
			var bsType = bsTypeObj.val();
			if( bsType == "N" ){
					$("#multipleBase").attr("readonly", "readonly")
							.css({"background":"none repeat scroll 0 0 #D3D3D3"});
					$("#minQuantity").attr("readonly", "readonly")
							.css({"background":"none repeat scroll 0 0 #D3D3D3"});
					$("#maxQuantity").attr("readonly", "readonly")
							.css({"background":"none repeat scroll 0 0 #D3D3D3"});
			}
		}
	}
}

// 动态属性加载完调用
function onCompleteErrorShow(tradeType) {
	if (tradeType && "placeOrder" == tradeType) {// 下单交易的交易属性服务错误提示
		placeOrderErrorShow()
	} else if (tradeType && ("bidOrder" == tradeType)) { // 拍卖交易的交易属性服务错误提示
		bidOrderErrorShow()
	} else if (tradeType && "mulitBidOrder" == tradeType) { // 拍卖交易的交易属性服务错误提示
		mulitBidOrderErrorShow()
	} else if (tradeType && "dynamic" == tradeType) {// 动态属性服务错误提示
		dynamicErrorShow()
	} else if (tradeType && "transferOrder" == tradeType) { // 协议转让交易的交易属性服务错误提示
		transferOrderErrorShow()
	} else if (tradeType && "tenderOrder" == tradeType) { // 招标转让交易的交易属性服务错误提示
		tenderOrderErrorShow()
	}
	commonErrorShow();// 通用模块的错误提示
}
function commonErrorShow() {
	if (metaErrors.fileErrorDiv) {
		$("#fileErrorDiv_remind_show_message").html(// 上传图片错误
				metaErrors.fileErrorDiv);
	}
	if (metaErrors.listingEndTime) {
		$("#listingEndTime_remind_show_message").html(// 挂结束时间错误
				metaErrors.listingEndTime);
	}
	if (metaErrors.auditMemo) {
		$("#auditMemo_remind_show_message").html(// 审核说明错误
				metaErrors.auditMemo);
	}
}
/**
 * 交易属性加载完，为动态生成的部分交易属性属性，添加事件
 * 
 * @param tradeType
 * @return
 */
function onCompleteEventBinder(tradeType) {
	if (tradeType && "placeOrder" == tradeType) {// 下单交易的交易属性服务错误提示
	} else if (tradeType && ("bidOrder" == tradeType)) { // 拍卖交易的交易属性服务错误提示
	} else if (tradeType && "dynamic" == tradeType) {// 动态属性服务错误提示
	} else if (tradeType && "mulitBidOrder" == tradeType) {
	} else if (tradeType && ("transferOrder" == tradeType)) { // 拍卖交易的交易属性服务错误提示
	} else if (tradeType && ("tenderOrder" == tradeType)) { // 拍卖交易的交易属性服务错误提示
	}

}
/**
 * 下单交易的后台验证错误提示
 * 
 * @return
 */
function placeOrderErrorShow() {
	if (metaErrors) {
		if (metaErrors.retail) {
			$("#retail_remind_show_message").html( // 是否零售
					metaErrors.retail);
		}
		if (metaErrors.multipleBase) {
			$("#multipleBase_remind_show_message").html( // 下单数量基数
					metaErrors.multipleBase);
		}
		if (metaErrors.minQuantity) {
			$("#minQuantity_remind_show_message").html( // 每用户最小下单量
					metaErrors.minQuantity);
		}
		if (metaErrors.maxQuantity) {
			$("#maxQuantity_remind_show_message").html( // 每用户最大下单量
					metaErrors.maxQuantity);
		}
	}
}
/**
 * 拍卖交易的后台验证错误提示
 * 
 * @return
 */
function bidOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.haveAuctioneer) {
			$("#haveAuctioneer_remind_show_message").html( // 是否有拍卖师
					metaErrors.haveAuctioneer);
		}
		if (metaErrors.bidStartPrice) {
			$("#bidStartPrice_remind_show_message").html(// 起拍价格
					metaErrors.bidStartPrice);
		}
		if (metaErrors.priceDirection) {
			$("#priceDirection_remind_show_message").html(// 报价方向
					metaErrors.priceDirection);
		}
		if (metaErrors.bidRate) {
			$("#bidRate_remind_show_message").html(// 出价幅度
					metaErrors.bidRate);
		}
		if (metaErrors.supportPriority) {
			$("#supportPriority_remind_show_message").html(// 优先权
					metaErrors.supportPriority);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html(// 竞价开始时间
					metaErrors.bidStartTime);
		}
		if (metaErrors.bidLimitedPeriod) {
			$("#bidLimitedPeriod_remind_show_message").html(// 报价限时周期
					metaErrors.bidLimitedPeriod);
		}
		if (metaErrors.haveReservePrice) {
			$("#haveReservePrice_remind_show_message").html(// 是否有保留价
					metaErrors.haveReservePrice);
		}
		if (metaErrors.reservePrice) {
			$("#reservePrice_remind_show_message").html(// 保留价
					metaErrors.reservePrice);
		}

		if (metaErrors.allowWatch) {
			$("#allowWatch_remind_show_message").html(// 是否允许观看
					metaErrors.allowWatch);
		}
		if (metaErrors.watchPassword) {
			$("#watchPassword_remind_show_message").html(// 观看授权码
					metaErrors.watchPassword);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html(// 报名开始时间
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html(// 报名结束时间
					metaErrors.applyEndTime);
		}
		if (metaErrors.firstWaitTime) {
			$("#firstWaitTime_remind_show_message").html(// 首次报价等待时长
					metaErrors.firstWaitTime);
		}
		if (metaErrors.auctioneerAccount) {
			$("#auctioneerAccount_remind_show_message").html(// 拍卖师账号
					metaErrors.auctioneerAccount);
		}

	}
}

/**
 * 多次报价转拍卖
 * 
 * @return
 */
function mulitBidOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.haveAuctioneer) {
			$("#haveAuctioneer_remind_show_message").html( // 是否有拍卖师
					metaErrors.haveAuctioneer);
		}
		if (metaErrors.bidStartPrice) {
			$("#bidStartPrice_remind_show_message").html(// 起拍价格
					metaErrors.bidStartPrice);
		}
		if (metaErrors.priceDirection) {
			$("#priceDirection_remind_show_message").html(// 报价方向
					metaErrors.priceDirection);
		}
		if (metaErrors.bidRate) {
			$("#bidRate_remind_show_message").html(// 出价幅度
					metaErrors.bidRate);
		}
		if (metaErrors.supportPriority) {
			$("#supportPriority_remind_show_message").html(// 优先权
					metaErrors.supportPriority);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html(// 竞价开始时间
					metaErrors.bidStartTime);
		}
		if (metaErrors.bidLimitedPeriod) {
			$("#bidLimitedPeriod_remind_show_message").html(// 报价限时周期
					metaErrors.bidLimitedPeriod);
		}
		if (metaErrors.haveReservePrice) {
			$("#haveReservePrice_remind_show_message").html(// 是否有保留价
					metaErrors.haveReservePrice);
		}
		if (metaErrors.reservePrice) {
			$("#reservePrice_remind_show_message").html(// 保留价
					metaErrors.reservePrice);
		}

		if (metaErrors.allowWatch) {
			$("#allowWatch_remind_show_message").html(// 是否允许观看
					metaErrors.allowWatch);
		}
		if (metaErrors.watchPassword) {
			$("#watchPassword_remind_show_message").html(// 观看授权码
					metaErrors.watchPassword);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html(// 报名开始时间
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html(// 报名结束时间
					metaErrors.applyEndTime);
		}
		if (metaErrors.firstWaitTime) {
			$("#firstWaitTime_remind_show_message").html(// 首次报价等待时长
					metaErrors.firstWaitTime);
		}
		if (metaErrors.auctioneerAccount) {
			$("#auctioneerAccount_remind_show_message").html(// 拍卖师账号
					metaErrors.auctioneerAccount);
		}
		if (metaErrors.reviewerAccount) {
			$("#reviewerAccount_remind_show_message").html(// 审核员账号
					metaErrors.reviewerAccount);
		}
	}
}

/**
 * 协议转让交易的后台验证错误提示
 * @return
 */
function transferOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.startPrice) {
			$("#startPrice_remind_show_message").html( // 转让价格
					metaErrors.startPrice);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html( // 报名开始时间
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html( // 报名结束时间
					metaErrors.applyEndTime);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html( // 协议转让开始时间
					metaErrors.bidStartTime);
		}
	}
}

/**
 * 招标转让交易的后台验证错误提示
 * @return
 */
function tenderOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.evaluation) {
			$("#evaluation_remind_show_message").html( // 评估价
					metaErrors.evaluation);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html( // 报名开始时间
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html( // 报名结束时间
					metaErrors.applyEndTime);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html( // 招标转让开始时间
					metaErrors.bidStartTime);
		}
	}
}

/**
 * 动态属性的后台验证错误提示
 * 
 * @return
 */
function dynamicErrorShow() {
	if (metaErrors) {

	}
}
/**
 * 显示类型树
 * 
 * @param boxID
 *            树容器的ID
 * @param {}
 *            beforeAsyncFn 在请求数据前的回调
 * @param {}
 *            asyncSuccessFn 加载数据成功后的回调
 * @param {}
 *            asyncErrorFn 请求出错时的回调
 * @param curValue
 *            当前值,方便在树中高亮当前值
 */
function reloadPrjTypeTree(boxID, beforeAsyncFn, asyncSuccessFn, asyncErrorFn,
		curValue) {
	var treeBox = $("#" + boxID);
	var curLi;// 根据curValue设置当前值样式
	if (!treeBox)
		return;
	if (curLi)
		curLi.removeClass("focus");
	var setting = {
		expandSpeed : "",
		async : true,
		asyncUrl : prjTypeUrl.nodesURL, // 获取节点数据的URL地址
		asyncParam : [ "name", "code" ], // 获取节点数据时，必须的数据名称，例如：id、name
		showLine : true,
		isSimpleData : true,
		treeNodeKey : "code",
		treeNodeParentKey : "parentcodeShort",
		callback : {
			// beforeAsync : beforeAsyncFn,//好像无效
			asyncSuccess : asyncSuccessFn,
			asyncError : asyncErrorFn
		}
	};
	if (curLi)
		curLi.addClass("focus");
	/**
	 * 类型树JSON数据
	 */
	var prjTypeTreeNodes = [];
	var prjTypeTree = treeBox.zTree(setting, prjTypeTreeNodes);
	return prjTypeTree;
}

/**
 * 复制数据 treeBox.zTree(setting, clone(prjTypeTreeNodes));
 * 
 * @param jsonObj
 * @param newName
 * @return newName
 */
function clone(jsonObj, newName) {
	var buf;
	if (jsonObj instanceof Array) {
		buf = [];
		var i = jsonObj.length;
		while (i--) {
			buf[i] = clone(jsonObj[i], newName);
		}
		return buf;
	} else if (typeof jsonObj == "function") {
		return jsonObj;
	} else if (jsonObj instanceof Object) {
		buf = {};
		for ( var k in jsonObj) {
			if (k != "parentNode") {
				buf[k] = clone(jsonObj[k], newName);
				if (newName && k == "name")
					buf[k] += newName;
			}
		}
		return buf;
	} else {
		return jsonObj;
	}
}
/**
 * 
 * @param tradeType
 *            交易方式：palseorder下单交易 洽谈交易chat 竞价交易bid
 */
function prjTradeForm(tradeType, prjTradeTypeBoxId) {
	loadPrjTradeTypeFormURL(tradeType, prjTradeTypeBoxId, "");
}

function prjMetaFrom(projectTypeCode, projectTypeName) {
	loadPrjTypeMetaFormURL(projectTypeCode, projectTypeName, "");
}
/**
 * 属性加载完以后，将上次的属性值显示
 * 
 * @return
 */
function onCompleteValueSeting(tradeType) {
	if (typeof (metaSubmitValue) != 'undefined' && metaSubmitValue
			&& metaSubmitValue != "") {
		setCommonValue();
		if ("bidOrder" == tradeType) {
			setBidOrderValue();
		} else if ("dynamic" == tradeType) {
			setDynamicValue();
		} else if ("placeOrder" == tradeType) {
			setPlaceOrderValue();
		} else if ("mulitBidOrder" == tradeType) {
			setMulitBidOrderValue();
		} else if ("transferOrder" == tradeType) {
			setTransferOrderValue();
		} else if ("tenderOrder" == tradeType) {
			setTenderOrderValue();
		}

	}
}
function setPlaceOrderValue() {

}
/**
 * 设置动态属性的上次值
 * 
 * @return
 */
function setDynamicValue() {
	$("input")
			.each(
					function() {
						if ($(this).attr("id") != ""
								&& $(this).attr("showtype") != "") {
							if (($(this).attr("showtype") == "text" || $(this)
									.attr("showtype") == "TEXT")) {
								$(this)
										.val(
												metaSubmitValue[$(this).attr(
														"id")]);
							} else if (($(this).attr("showtype") == "checkbox" || $(
									this).attr("showtype") == "CHECKBOX")) {
								var checkId = $(this).attr("id");
								$("input[id='" + checkId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[checkId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues

															.indexOf(itemValue) > -1) {
														$(this).attr("checked",
																true);
													}
												});
							} else if (($(this).attr("showtype") == "radio" || $(
									this).attr("showtype") == "RADIO")) {
								var radioId = $(this).attr("id");
								$("input[id='" + radioId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[radioId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues == itemValue) {
														$(this).attr("checked",
																true);
													}
												});
							}
						}
					});

	$("select").each(function() {
		if ($(this).attr("id") != "" && $(this).attr("showtype") != "") {
			var selectId = $(this).attr("id");
			$("#" + selectId + " option").each(function() {
				if (metaSubmitValue[selectId] == $(this).val()) {
					$(this).attr("selected", true);
				}
			});
		}
	});
}
/**
 * 设置下单交易属性的上次值
 * 
 * @return
 */
function setCommonValue() {
	$("input")
			.each(
					function() {
						if ($(this).attr("id") != ""
								&& $(this).attr("showtype") != "") {
							if (($(this).attr("showtype") == "text" || $(this)
									.attr("showtype") == "TEXT")) {
								$(this)
										.val(
												metaSubmitValue[$(this).attr(
														"id")]);
							} else if (($(this).attr("showtype") == "checkbox" || $(
									this).attr("showtype") == "CHECKBOX")) {
								var checkId = $(this).attr("id");
								$("input[id='" + checkId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[checkId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues

															.indexOf(itemValue) > -1) {
														$(this).attr("checked",
																true);
													}
												});
							} else if (($(this).attr("showtype") == "radio" || $(
									this).attr("showtype") == "RADIO")) {
								var radioId = $(this).attr("id");
								$("input[id='" + radioId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[radioId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues == itemValue) {
														$(this).attr("checked",
																true);
													}
												});
							}
						}
					});

	$("select").each(function() {
		if ($(this).attr("id") != "" && $(this).attr("showtype") != "") {
			var selectId = $(this).attr("id");
			$("#" + selectId + " option").each(function() {
				if (metaSubmitValue[selectId] == $(this).val()) {
					$(this).attr("selected", true);
				}
			});
		}
	});
}
/**
 * 设置拍卖交易属性的上次值
 * 
 * @return
 */
function setBidOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.haveAuctioneer) {
		$("input[id='haveAuctioneer']").each(function() {
			if (metaSubmitValue.haveAuctioneer == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.bidStartPrice) {
		$("#bidStartPrice").val(metaSubmitValue.bidStartPrice);// 起拍价格
	}
	if (metaSubmitValue.priceDirection) {
		// $("#priceDirection").val(metaSubmitValue.priceDirection);// 报价方向
		$("input[id='priceDirection']").each(function() {
			if (metaSubmitValue.priceDirection == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.bidRate) {
		$("#bidRate").val(metaSubmitValue.bidRate);// 出价幅度
	}
	if (metaSubmitValue.supportPriority) {
		// $("#supportPriority").val(metaSubmitValue.supportPriority);// 优先权
		$("input[id='supportPriority']").each(function() {
			if (metaSubmitValue.supportPriority == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// 竞价开始时间
	}
	if (metaSubmitValue.bidLimitedPeriod) {
		$("#bidLimitedPeriod").val(metaSubmitValue.bidLimitedPeriod);// 报价限时周期
	}
	if (metaSubmitValue.haveReservePrice) {
		// $("#haveReservePrice").val(metaSubmitValue.haveReservePrice);//
		// 是否有保留价
		$("input[id='haveReservePrice']").each(function() {
			if (metaSubmitValue.haveReservePrice == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.reservePrice) {
		$("#reservePrice").val(metaSubmitValue.reservePrice);// 保留价
	}
	if (metaSubmitValue.allowWatch) {
		// $("#allowWatch").val(metaSubmitValue.allowWatch);// 是否允许观看
		$("input[id='allowWatch']").each(function() {
			if (metaSubmitValue.allowWatch == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.watchPassword) {
		$("#watchPassword").val(metaSubmitValue.watchPassword);// 观看授权码
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// 报名开始时间
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// 报名结束时间
	}
	if (metaSubmitValue.firstWaitTime) {
		$("#firstWaitTime").val(metaSubmitValue.firstWaitTime);// 首次报价等待时长
	}
	if (metaSubmitValue.auctioneerAccount) {
		$("#auctioneerAccount").val(metaSubmitValue.auctioneerAccount);// 拍卖师账号
	}

}
function setMulitBidOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.haveAuctioneer) {
		$("input[id='haveAuctioneer']").each(function() {
			if (metaSubmitValue.haveAuctioneer == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.bidStartPrice) {
		$("#bidStartPrice").val(metaSubmitValue.bidStartPrice);// 起拍价格
	}
	if (metaSubmitValue.priceDirection) {
		// $("#priceDirection").val(metaSubmitValue.priceDirection);// 报价方向
		$("input[id='priceDirection']").each(function() {
			if (metaSubmitValue.priceDirection == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.bidRate) {
		$("#bidRate").val(metaSubmitValue.bidRate);// 出价幅度
	}
	if (metaSubmitValue.supportPriority) {
		// $("#supportPriority").val(metaSubmitValue.supportPriority);// 优先权
		$("input[id='supportPriority']").each(function() {
			if (metaSubmitValue.supportPriority == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// 竞价开始时间
	}
	if (metaSubmitValue.bidLimitedPeriod) {
		$("#bidLimitedPeriod").val(metaSubmitValue.bidLimitedPeriod);// 报价限时周期
	}
	if (metaSubmitValue.haveReservePrice) {
		// $("#haveReservePrice").val(metaSubmitValue.haveReservePrice);//
		// 是否有保留价
		$("input[id='haveReservePrice']").each(function() {
			if (metaSubmitValue.haveReservePrice == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.reservePrice) {
		$("#reservePrice").val(metaSubmitValue.reservePrice);// 保留价
	}
	if (metaSubmitValue.allowWatch) {
		// $("#allowWatch").val(metaSubmitValue.allowWatch);// 是否允许观看
		$("input[id='allowWatch']").each(function() {
			if (metaSubmitValue.allowWatch == $(this).val()) {
				$(this).attr("checked", true); // 是否有拍卖师
			}
		});
	}
	if (metaSubmitValue.watchPassword) {
		$("#watchPassword").val(metaSubmitValue.watchPassword);// 观看授权码
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// 报名开始时间
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// 报名结束时间
	}
	if (metaSubmitValue.firstWaitTime) {
		$("#firstWaitTime").val(metaSubmitValue.firstWaitTime);// 首次报价等待时长
	}
	if (metaSubmitValue.auctioneerAccount) {
		$("#auctioneerAccount").val(metaSubmitValue.auctioneerAccount);// 拍卖师账号
	}
	if (metaSubmitValue.reviewerAccount) {
		$("#reviewerAccount").val(metaSubmitValue.reviewerAccount);// 评审员账号
	}
}

/**
 * 设置协议转让交易属性的上次值
 * 
 * @return
 */
function setTransferOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.startPrice) {
		$("#startPrice").val(metaSubmitValue.startPrice);// 转让价格
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// 报名开始时间
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// 报名结束时间
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// 协议转让开始时间
	}
}

/**
 * 设置招标转让交易属性的上次值
 * 
 * @return
 */
function setTenderOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.evaluation) {
		$("#evaluation").val(metaSubmitValue.evaluation);// 评估价
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// 报名开始时间
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// 报名结束时间
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// 招标转让开始时间
	}
}