$(document).ready(
		function() {
			var tType = $("#tradingType").val();
			var projectId = $("#projectId").val();
			var projectTypeCode = jQuery("#projectTypeCode").val();
			//loadPrjTradeTypeFormURL(tType, "prjTradeTypeBoxId", projectId);
			var bsType = $("#listingType").val();
			loadPrjTradeTypeDisByBsType(tType, "prjTradeTypeBoxId", projectId, bsType);// 加载交易动态属性,带挂牌方向参数
			loadPrjTypeMetaFormURL(projectTypeCode, "", "", "prjTypeMetaBox",
					projectId);
		});

$(function() {
	$.validator.setDefaults( {
		submitHandler : function(form) {
			// 拼装交收地址
			var pe_province = $("#pe_province").find("option:selected");
			var pe_city = $("#pe_city").find("option:selected");
			var pe_area = $("#pe_area").find("option:selected");
			var strAddress = pe_province.text()
						+ (pe_city.text() != "请选择" ? pe_city.text() : "") 
						+ (pe_area.text() != "请选择" ? pe_area.text() : "")
						+ $("#address").val();
			$("#deliveryPlace").val(strAddress);
			
			if (!validateForm()) {
				return false;
			} else {
				// 拼装交收地址
//				var pe_province = $("#pe_province").find("option:selected");
//				var pe_city = $("#pe_city").find("option:selected");
//				var pe_area = $("#pe_area").find("option:selected");
//				var strAddress = pe_province.text()
//							+ (pe_city.text() != "请选择" ? pe_city.text() : "") 
//							+ (pe_area.text() != "请选择" ? pe_area.text() : "")
//							+ $("#address").val();
//				$("#deliveryPlace").val(strAddress);
				form.submit();
			}
		}
	});
	$("#projectListingEdit").validate( {
		rules : {
			title : {
				required : true,
				maxlength : 100
			},
			quantity : {
				required : true,
				digits : true
			},
			listingPriceDesc : {
				required : true,
				number : true
			},
			projectTypeCode : {
				required : true
			},
			tradeTypeValue : {
				required : true
			},
			paymentType : {
				required : true,
				minlength : 1
			},
			deliveryType : {
				required : true,
				minlength : 1
			},
			invoice : {
				required : true,
				minlength : 1
			},
			phone : {
				required : true,
				maxlength : 20
			},
			linkMan : {
				required : true,
				maxlength : 30
			},
			address : {
				required : true,
				maxlength : 80
			},
			storehouse : {
				maxlength : 30
			},
			area : {
				required : true
			}
		},
		messages : {
			title : {
				required : "此为必填项",
				maxlength : "输入长度最多是100的字符串"
			},
			quantity : {
				required : "此为必填项",
				digits : "必须输入整数"
			},
			listingPriceDesc : {
				required : "此为必填项",
				number : "请输入合法的数字"
			},
			projectTypeCode : {
				required : "此项为必填项"
			},
			tradeTypeValue : {
				required : "请选交易方式"
			},
			paymentType : {
				required : "此为必填项",
				minlength : "至少要选择1项"
			},
			deliveryType : {
				required : "此为必填项",
				minlength : "至少要选择1项"
			},
			invoice : {
				required : "此为必填项",
				minlength : "至少要选择1项"
			},
			phone : {
				required : "此为必填项",
				maxlength : "不能超过20个字符长度"
			},
			linkMan : {
				required : "此为必填项",
				maxlength : "不能超过30个字符长度"
			},
			address : {
				required : "此为必填项",
				maxlength : "不能超过80个字符长度"
			},
			storehouse : {
				maxlength : "不能超过30个字符长度"
			},
			area : {
				required : "请填写所在区域"
			}
		}
	});

	// $("#projectListingEdit").validate();
});
/**
 * 下单交易属性校验
 * 
 * @return
 */
function placeOrderValidate() {
	var maxQuantityObj = $('#maxQuantity'); // 最大下单量
	var minQuantityObj = $('#minQuantity'); // 最小下单量
	var multipleBaseObj = $('#multipleBase'); // 下单基数
	var quantityObj = $('#quantity'); // 用户实际填写下单量
	if (maxQuantityObj) {
		var maxQuantity = maxQuantityObj.val();
		if (maxQuantity == "") {
			showRemaindMessage('maxQuantity_remind_show_message', '最大下单量为必填项！');
			return false;
		} else if (!isDigitPositive(maxQuantity)) {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message', '请输入正确的数量!');
			return false;
		} else {
			clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
		}
		maxQuantity = Number(maxQuantity);

	}
	if (minQuantityObj) {
		var minQuantity = minQuantityObj.val();

		if (minQuantity == "") {
			showRemaindMessage('minQuantity_remind_show_message', '最小下单量为必填项！');
			return false;
		} else if (!isDigitPositive(minQuantity)) {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message', '请输入正确的数量!');
			return false;
		} else {
			clearRemindMessage('minQuantity_remind_show_message'); // 清除提示
		}
		minQuantity = Number(minQuantity);
	}
	if (multipleBaseObj) {
		var multipleBase = multipleBaseObj.val();
		if (multipleBase == "") {
			showRemaindMessage('multipleBase_remind_show_message',
					'下单数量基数为必填项！');
			return false;
		} else if (!isDigitPositive(multipleBase)) {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '请输入正确的数量!');
			return false;
		} else if (multipleBase > quantity) { // 最大下单量大于库存量
			minQuantityObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '必须要小于挂牌数量!');
			return false;
		} else {
			clearRemindMessage('multipleBase_remind_show_message'); // 清除提示
		}
		multipleBase = Number(multipleBase);
	}
	if (quantityObj) {
		var quantity = quantityObj.val();
		if (quantity == "") {
			showRemaindMessage('quantity_remind_show_message', '挂牌数量为必填项！');
			return false;
		} else if (!isDigitPositive(quantity)) {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '请输入正确的数量!');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // 清除提示
		}
		quantity = Number(quantity);
	}

	if (quantity % multipleBase != 0) { // 下单基数必须为挂牌数量的整数倍
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '必须能被挂牌数量的整除');
		return false;
	} else if (multipleBase > quantity) {
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '下单基数必须要小于挂牌数量!');
	} else {
		clearRemindMessage('multipleBase_remind_show_message'); // 清除提示
	}

	if (minQuantity > quantity) { // 最大下单量大于库存量
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '最小下单量必须要小于挂牌数量!');
		return false;
	} else if (minQuantity % multipleBase != 0) { // 最大下单量必须为下单基数的整数倍
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '必须为下单基数的整数倍!');
		return false;
	} else {
		clearRemindMessage('minQuantity_remind_show_message'); // 清除提示
	}

	if (maxQuantity > quantity) { // 最大下单量大于库存量
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '最大下单量必须要小于挂牌数量!');
		return false;
	} else if (maxQuantity % multipleBase != 0) { // 最大下单量必须为下单基数的整数倍
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '必须为下单基数的整数倍!');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
	}

	if (minQuantity > maxQuantity) { // 最大下单量必须要大于等于最小小单量
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message',
				'最大下单量必须要大于等于最小小单量!');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
	}
	return true;
}
/**
 * 拍卖交易属性的校验
 * 
 * @return
 */
function bidOrderValidate() {
	var haveAuctioneerObj = $("input:[id='haveAuctioneer']:radio:checked"); // 是否有拍卖师
	var haveAuctioneerTemp = "";
	if (haveAuctioneerObj) {
		var haveAuctioneer = haveAuctioneerObj.val();
		if (typeof (haveAuctioneer) == "undefined" || haveAuctioneer == "") {
			haveAuctioneerObj.focus();
			showRemaindMessage('haveAuctioneer_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('haveAuctioneer_remind_show_message'); // 清除提示
		}
		haveAuctioneerTemp = haveAuctioneer;
	}
	var auctioneerAccountObj = $("#auctioneerAccount"); // 拍卖师账号
	if (auctioneerAccountObj) {
		var auctioneerAccount = auctioneerAccountObj.val();
		if (haveAuctioneerTemp == "Y"
				&& (typeof (auctioneerAccount) == "undefined" || auctioneerAccount == "")) {
			auctioneerAccountObj.focus();
			showRemaindMessage('auctioneerAccount_remind_show_message',
					'此项为必填项!');
			return false;
		} else {
			clearRemindMessage('auctioneerAccount_remind_show_message');
		}
	}
	var watchPasswordObj = $("#watchPassword"); // 观看授权码
	if (watchPasswordObj) {
		var watchPassword = watchPasswordObj.val();
		if (typeof (watchPassword) != "undefined" && watchPassword != ""
				&& watchPassword.length > 16) {
			watchPasswordObj.focus();
			showRemaindMessage('watchPassword_remind_show_message',
					'不能超过16字符长度!');
			return false;
		} else {
			clearRemindMessage('watchPassword_remind_show_message');
		}
	}

	var supportPriorityObj = $("input:[id='supportPriority']:radio:checked")// 优先权
	if (supportPriorityObj) {
		var supportPriority = supportPriorityObj.val();
		if (typeof (supportPriority) == "undefined" || supportPriority == "") {
			supportPriorityObj.focus();
			showRemaindMessage('supportPriority_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('supportPriority_remind_show_message');
		}
	}
	var bidStartPriceObj = $("#bidStartPrice"); // 起拍价格
	if (bidStartPriceObj) {
		var bidStartPrice = bidStartPriceObj.val();
		if (typeof (bidStartPrice) == "undefined" || bidStartPrice == "") {
			bidStartPriceObj.focus();
			showRemaindMessage('bidStartPrice_remind_show_message', '此项为必填项!');
			return false;
		} else if (!isMoneyInput(bidStartPrice)) {
			showRemaindMessage('bidStartPrice_remind_show_message', '请输入正确的金额!');
			return false;
		} else {
			clearRemindMessage('bidStartPrice_remind_show_message');
		}
		if (!validateMoney("bidStartPrice", "valuationUnit")) {
			return false;
		}
	}
	var allowWatchObj = $("input:[id='allowWatch']:radio:checked")// 是否允许观看
	if (allowWatchObj) {
		var allowWatch = allowWatchObj.val();
		if (typeof (allowWatch) == "undefined" || allowWatch == "") {
			allowWatchObj.focus();
			showRemaindMessage('allowWatch_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('allowWatch_remind_show_message');
		}
	}
	var priceDirectionObj = $("input:[id='priceDirection']:radio:checked")// 报价方向
	if (priceDirectionObj) {
		var priceDirection = priceDirectionObj.val();
		if (typeof (priceDirection) == "undefined" || priceDirection == "") {
			priceDirection.focus();
			showRemaindMessage('priceDirection_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('priceDirection_remind_show_message');
		}
	}
	var bidRateObj = $("#bidRate"); // 出价幅度
	if (bidRateObj) {
		var bidRate = bidRateObj.val();
		if (typeof (bidRate) != "undefined" && bidRate != ""
				&& !isMoneyInput(bidRate)) {
			bidRateObj.focus();
			showRemaindMessage('bidRate_remind_show_message', '请输入正确的金额!');
			return false;
		} else {
			clearRemindMessage('bidRate_remind_show_message');
		}
		if (bidRate != "" && !validateMoney("bidRate", "valuationUnit")) {
			return false;
		}
	}
	var haveReservePriceObj = $("input:[id='haveReservePrice']:radio:checked")// 是否有保留价
	var haveReservePriceTemp = "";
	if (haveReservePriceObj) {
		var haveReservePrice = haveReservePriceObj.val();
		if (typeof (haveReservePrice) == "undefined" || haveReservePrice == "") {
			haveReservePriceObj.focus();
			showRemaindMessage('haveReservePrice_remind_show_message',
					'此项为必填项!');
			return false;
		} else {
			clearRemindMessage('haveReservePrice_remind_show_message');
		}
		haveReservePriceTemp = haveReservePrice;
	}
	var reservePriceObj = $("#reservePrice"); // 保留价
	if (reservePriceObj) {
		var reservePrice = reservePriceObj.val();
		if (haveReservePriceTemp == "Y"
				&& (typeof (reservePrice) == "undefined" || reservePrice == "")) {
			reservePriceObj.focus();
			showRemaindMessage('reservePrice_remind_show_message', '此项为必填项!');
			return false;
		} else if (typeof (reservePrice) != "undefined" && reservePrice != ""
				&& !isMoneyInput(reservePrice)) {
			reservePriceObj.focus();
			showRemaindMessage('reservePrice_remind_show_message', '请输入正确的金额!');
			return false;
		} else {
			clearRemindMessage('reservePrice_remind_show_message');
		}
		if (reservePrice != ""
				&& !validateMoney("reservePrice", "valuationUnit")) {
			return false;
		}

	}
	var firstWaitTimeObj = $("#firstWaitTime"); // 首次报价时长(秒)
	if (firstWaitTimeObj) {
		var firstWaitTime = firstWaitTimeObj.val();
		if (typeof (firstWaitTime) == "undefined" || firstWaitTime == "") {
			firstWaitTimeObj.focus();
			showRemaindMessage('firstWaitTime_remind_show_message', '此项为必填项!');
			return false;
		} else if (!isDigitPositive(firstWaitTime)) {
			showRemaindMessage('firstWaitTime_remind_show_message', '请输入正整数!');
			return false;
		} else {
			clearRemindMessage('firstWaitTime_remind_show_message');
		}
	}
	var bidLimitedPeriodObj = $("#bidLimitedPeriod"); // 报价限时周期(秒)
	if (firstWaitTimeObj) {
		var bidLimitedPeriod = bidLimitedPeriodObj.val();
		if (typeof (bidLimitedPeriod) == "undefined" || bidLimitedPeriod == "") {
			bidLimitedPeriodObj.focus();
			showRemaindMessage('bidLimitedPeriod_remind_show_message',
					'此项为必填项!');
			return false;
		} else if (!isDigitPositive(bidLimitedPeriod)) {
			showRemaindMessage('bidLimitedPeriod_remind_show_message',
					'请输入正整数!');
			return false;
		} else {
			clearRemindMessage('bidLimitedPeriod_remind_show_message');
		}
	}
	var applyStartTimeObj = $("#applyStartTime"); // 报名开始时间
	var applyStartTimeTmp = "";
	if (applyStartTimeObj) {
		var applyStartTime = applyStartTimeObj.val();
		if (typeof (applyStartTime) == "undefined" || applyStartTime == "") {
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		// var sTime = millisecondBetween(applyStartTime, listingStartTimeTemp);
		// var eTime = millisecondBetween(listingEndTimeTemp, applyStartTime);
		if (!(comptime(listingStartTimeTemp, applyStartTime) && comptime(
				applyStartTime, listingEndTimeTemp))) {
			// if (!(sTime >= 0 && eTime >= 0)) {
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message',
					'必须在挂牌的有效时间范围内!');
			return false;
		} else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		applyStartTimeTmp = applyStartTime;
	}
	var applyEndTimeObj = $("#applyEndTime"); // 报名结束时间
	var applyEndTimeTemp = "";
	if (applyEndTimeObj) {
		var applyEndTime = applyEndTimeObj.val();
		if (typeof (applyEndTime) == "undefined" || applyEndTime == "") {
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		// var applyMlsd = millisecondBetween(applyEndTime, applyStartTimeTmp);
		// if (applyMlsd <= 0) {
		if (!comptime(applyStartTimeTmp, applyEndTime)) {
			showRemaindMessage('applyEndTime_remind_show_message',
					'报名结束时间要晚于报名开始时间!');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		// var sTime = millisecondBetween(applyEndTime, listingStartTimeTemp);
		// var eTime = millisecondBetween(listingEndTimeTemp, applyEndTime);
		// if (!(sTime >= 0 && eTime >= 0)) {
		if (!(comptime(listingStartTimeTemp, applyEndTime) && comptime(
				applyEndTime, listingEndTimeTemp))) {
			// if (!(applyEndTime >= listingStartTimeTemp && listingEndTimeTemp
			// >= applyEndTime)) {
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message',
					'必须在挂牌的有效时间范围内!');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		applyEndTimeTemp = applyEndTime;
	}

	var bidStartTimeObj = $("#bidStartTime"); // 竞价开始时间
	if (bidStartTimeObj) {
		var bidStartTime = bidStartTimeObj.val();
		if (typeof (bidStartTime) == "undefined" || bidStartTime == "") {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message', '此项为必填项!');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
		// var bidMlsd = millisecondBetween(bidStartTime, applyEndTimeTemp);
		// if (bidMlsd <= 0) {
		if (!comptime(applyEndTimeTemp, bidStartTime)) {
			showRemaindMessage('bidStartTime_remind_show_message',
					'竞价开始时间要晚于报名结束时间!');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}

		// var sTime = millisecondBetween(bidStartTime, listingStartTimeTemp);
		// var eTime = millisecondBetween(listingEndTimeTemp, bidStartTime);
		// if (!(sTime >= 0 && eTime >= 0)) {
		if (!(comptime(listingStartTimeTemp, bidStartTime) && comptime(
				bidStartTime, listingEndTimeTemp))) {
			// if (!(bidStartTime >= listingStartTimeTemp && listingEndTimeTemp
			// >= bidStartTime)) {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message',
					'必须在挂牌的有效时间范围内!');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
	}
	return true;
}

/**
 * 验证新建挂牌数据
 * 
 * @return
 */
function validateForm() {
	var listingStartTimeObj = $("#listingStartTime");
	var listingEndTimeObj = $("#listingEndTime");
	var tradingTypeObj = $("input[name='tradingType']:radio:checked"); // 交易方式
	tradingType = tradingTypeObj.val();
	if (typeof (tradingType) == "undefined" || tradingType == "") {
		tradingType = $("#tradingType").val();
	}
	if ("placeOrder" == tradingType) {
		if (!placeOrderValidate()) {
			return false;
		}
	} else if ("bidOrder" == tradingType || "mulitBidOrder" == tradingType) {
		if (!bidOrderValidate()) {
			return false;
		}
	}
	var leaveQuantityObj = $('#leaveQuantity'); // 项目库存量
	var breedStandardObj = $("#breedStandard");
	var breedStandardIdObj = $("#breedStandardId");
	if (!validatePrice()) {
		return false;
	}

	if (listingStartTimeObj && listingEndTimeObj) {
		var listingStartTime = listingStartTimeObj.val();
		var listingEndTime = listingEndTimeObj.val();
		if (listingStartTime == "") {
			showRemaindMessage('listingStartTime_remind_show_message',
					'挂牌开始时间为必填项！');
			return false;
		} else {
			clearRemindMessage('listingStartTime_remind_show_message');
		}
		if (listingEndTime == "") {
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌结束时间为必填项');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		var days = daysBetween(listingEndTime, listingStartTime);
		var today = new Date();
		var day = today.getDate();
		var month = today.getMonth() + 1;
		var year = today.getYear();
		if (daysBetween(listingEndTime, year + "-" + month + "-" + day) < 0) {
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌结束时间必须要大于等于今天！');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		if (days <= 0) {
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌开始时间必须要早于结束时间');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		return true;
	} else {
		showRemaindMessage('listingEndTime_remind_show_message', '输入的日期格式不正确！');
		return false;
	}

	return true;

}
function validateMoney(priceObj, valuationUnitObj) {
	if (priceObj && valuationUnitObj && valuationUnitObj != ""
			&& priceObj != "") {
		var listingPrice = $("#" + priceObj).val();
		var valuationUnit = $("#" + valuationUnitObj).val();
		/*
		 * if (listingPrice == "") { showRemaindMessage(priceObj +
		 * '_remind_show_message', '此项必填项！'); return false; } else {
		 * clearRemindMessage(priceObj + '_remind_show_message'); } if
		 * (valuationUnit == "") {
		 * showRemaindMessage('valuationUnit_remind_show_message', '计价单位为必选项！');
		 * return false; } else {
		 * clearRemindMessage('valuationUnit_remind_show_message'); }
		 */
		if ("fen" == valuationUnit) { // 如果计价单位为分，则挂牌单价只能输入整数
			if (!isNumber(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'以分为单位只能输入正整数!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'以角为单位只能输入不超过带1位小数的值!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(1);
				// listingPriceObj.val(listingPrice);
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'以元为单位只能输入不超过带2位小数的值!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(2);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'以万元为单位只能输入不超过带6位小数的值!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(7);
				// $("#" + priceObj).val(listingPrice);
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(listingPrice)) {
				$("#" + priceObj).focus();
				showRemaindMessage(priceObj + '_remind_show_message',
						'以亿元为单位只能输入不超过带10位小数的值!');
				return false;
			} else {
				clearRemindMessage(priceObj + '_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(10);
				// $("#" + priceObj).val(listingPrice);
			}
		}
		return true;
	} else {
		alert("请检查计价单位和价格元素是否存在！");
		return false;
	}

}
function validatePrice() {
	var listingPriceObj = $("#listingPrice"); // 挂牌单价
	var valuationUnitObj = $("#valuationUnit"); // 计价单位
	if (listingPriceObj && valuationUnitObj) {
		var listingPrice = listingPriceObj.val();
		var valuationUnit = valuationUnitObj.val();
		if (listingPrice == "") {
			showRemaindMessage('listingPrice_remind_show_message', '挂牌单价为必填项！');
			return false;
		} else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		if (valuationUnit == "") {
			showRemaindMessage('valuationUnit_remind_show_message', '计价单位为必选项！');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		if ("fen" == valuationUnit) { // 如果计价单位为分，则挂牌单价只能输入整数
			if (!isNumber(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以分为单位只能输入正整数!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message');
			}
		} else if ("jiao" == valuationUnit) {
			if (!isDecimal1(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以角为单位只能输入不超过带1位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(1);
				// listingPriceObj.val(listingPrice);
			}

		} else if ("yuan" == valuationUnit) {
			if (!isDecimal2(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以元为单位只能输入不超过带2位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(2);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("wanyuan" == valuationUnit) {
			if (!isDecimal6(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以万元为单位只能输入不超过带6位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(7);
				// listingPriceObj.val(listingPrice);
			}
		} else if ("yiyuan" == valuationUnit) {
			if (!isDecimal10(listingPrice)) {
				listingPriceObj.focus();
				showRemaindMessage('listingPrice_remind_show_message',
						'以亿元为单位只能输入不超过带10位小数的值!');
				return false;
			} else {
				clearRemindMessage('listingPrice_remind_show_message');
				// listingPrice = listingPrice.toString().movePoint(10);
				// listingPriceObj.val(listingPrice);
			}
		}
		return true;
	} else {
		alert("请检查计价单位和价格元素是否存在！");
		return false;
	}

}
function doUploadImage(imgUrlObj) {
	if (imgUrlObj) {
		var imgUrl = imgUrlObj.value;
		// $.ajax( {
		// url : "",
		// context : document.body,
		// success : function() {
		// $(this).addClass("done");
		// }
		// });
		$("#pictureMain").attr("src", imgUrl);
	}
}
$(document).ready(function() {
	$("#measureUnit").bind('change', function() {
		var selectValue = $(this).val();
		if ("zong" == selectValue) {
			$("tr[name='choose']").attr("style", "display:none;");
		} else {
			$("tr[name='choose']").attr("style", "display:;");
		}
	});

});

/**
 * 清除提示内容信息
 * 
 * @param Object
 * @return
 */
function clearRemindMessage(Object) {
	$('#' + Object).html('');
}
/**
 * 显示页面提示信息
 * 
 * @param Object
 * @param message
 * @return
 */
function showRemaindMessage(Object, message) {
	$('#' + Object).html(message);
}
