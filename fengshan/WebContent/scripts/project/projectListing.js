$(document).ready(
		function() {
			var tType = jQuery("#tradingType").val();
			var projectId = jQuery("#projectId").val();
			var projectTypeCode = jQuery("#projectTypeCode").val();
			//loadPrjTradeTypeFormURL(tType, "prjTradeTypeBoxId", projectId);
			var bsType = $("#listingType").val();
			loadPrjTradeTypeDisByBsType(tType, "prjTradeTypeBoxId", projectId, bsType);// 加载交易动态属性,带挂牌方向参数
			
			var standardSelect = $("#breedStandardSelect");
			if(standardSelect.length != 0){//快速挂牌
				var selectObj =standardSelect.find("option:selected");
				if(selectObj.val() == "0" || selectObj.val() == "请选择" || selectObj.val() == ""){
					loadPrjTypeMetaFormURL(projectTypeCode, "", "", "prjTypeMetaBox",projectId);
				}
			}else{//编辑挂牌
				loadPrjTypeMetaFormURL(projectTypeCode, "", "", "prjTypeMetaBox",projectId);
			}
		});
$(document).ready(
		function() {
			$('#projectTypeName').click(
					function() {
						showPrjTypeSel(this, '', 'projectTypeCode',
								'projectTypeName', 'prjTypeMetaBox');
					});

		});
$(document).ready(
		function() {
			$('#breedStandardSelect').change(
					function() {
						var selectObj = $("#breedStandardSelect").find("option:selected");
						if (selectObj.val() == "0" || selectObj.val() == "请选择" || selectObj.val() == "") {
							// 展示动态属性
							var pTypeCode = jQuery("#projectTypeCode").val();
							var pTypeName = jQuery("#projectTypeName").val();
							if (pTypeName != "") {
								prjMetaFrom(pTypeCode, pTypeName);// 加载项目动态属性
							}
							$("#standShowId").empty();
							$('#breedStandard').val("");
							$('#breedStandardId').val("");
							$("#prjTypeMetaBox").show();
						} else {
							// 隐藏动态属性
							$("#prjTypeMetaBox").html('').hide();
							//$("#prjTypeMetaBox").hide();
							$('#breedStandard').val(selectObj.text());
							$('#breedStandardId').val(selectObj.val());
							$("#standShowId").empty().append(" <a href='" 
											+ appServer
											+ "/home/standard/show.htm?sid="
											+ selectObj.val()
											+ "' target='_blank'>"
											+ selectObj.text() + "</a>");
						}
					});
		});
$(document).ready(function() {
	jQuery.validator.setDefaults( {
		submitHandler : function(form) {
				if (!validateForm()) {
					return false;
				}
				// 拼装交收地址
				var pe_province = $("#pe_province").find("option:selected");
				var pe_city = $("#pe_city").find("option:selected");
				var pe_area = $("#pe_area").find("option:selected");
				var strAddress = pe_province.text()
							+ (pe_city.text() != "请选择" ? pe_city.text() : "") 
							+ (pe_area.text() != "请选择" ? pe_area.text() : "")
							+ $("#address").val();
				$("#deliveryPlace").val(strAddress);
				form.submit();
		}
	});	
	
	$('#listingFrom').validate( {
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
							listingStartTime : {
								required : true
							},
							listingEndTime : {
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
							area : {
								required : true
							},
							address : {
								required : true,
								maxlength : 80
							},
							storehouse : {
								maxlength : 30
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
							listingStartTime : {
								required : "此为必填项"
							},
							listingEndTime : {
								required : "此为必填项"
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
							area : {
								required : "此为必填项"
							},
							address : {
								required : "此为必填项",
								maxlength : "不能超过80个字符长度"
							},
							storehouse : {
								maxlength : "不能超过30个字符长度"
							}
						}
					});

});
/**
 * 下单交易属性校验
 * 
 * @return
 */
function placeOrderValidate() {
	var result = true;
	var retailObj = $("input:[id='retail']:radio:checked");
	var maxQuantityObj = $('#maxQuantity'); // 最大下单量
	var minQuantityObj = $('#minQuantity'); // 最小下单量
	var multipleBaseObj = $('#multipleBase'); // 下单基数
	var quantityObj = $('#quantity'); // 挂牌数量
	if(retailObj.length ==0){
		multipleBaseObj.focus();
		showRemaindMessage('retail_remind_show_message', '方式必选');
		return false;
	}else {
			clearRemindMessage('retail_remind_show_message'); // 清除提示
	}
	var q_temp;
	if (quantityObj.length != 0) {
		var quantity = quantityObj.val();
		if (quantity == "") {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '挂牌数量必填');
			return false;
		} else if (!isDigitPositive(quantity)) {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '数量不正确');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // 清除提示
		}
		q_temp = Number(quantity);
	}
	var mul_temp;
	if (multipleBaseObj.length != 0) {
		var multipleBase = multipleBaseObj.val();
		if (multipleBase == "") {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message','下单基数必填');
			return false;
		} else if (!isDigitPositive(multipleBase)) {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '数量不正确');
			return false;
		} else if (multipleBase > q_temp) {
			minQuantityObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '下单基数必须小于挂牌数量!');
			return false;
		} else {
			clearRemindMessage('multipleBase_remind_show_message'); // 清除提示
		}
		mul_temp = Number(multipleBase);
	}
	var min_temp;
	if (minQuantityObj.length != 0) {
		var minQuantity = minQuantityObj.val();
		if (minQuantity == "") {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message', '最小下单量必填');
			return false;
		} else if (!isDigitPositive(minQuantity)) {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message', '数量不正确');
			return false;
		} else {
			clearRemindMessage('minQuantity_remind_show_message'); // 清除提示
		}
		min_temp = Number(minQuantity);
	}
	var max_temp;
	if (maxQuantityObj.length != 0) {
		var maxQuantity = maxQuantityObj.val();
		if (maxQuantity == "") {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message', '最大下单量必填');
			return false;
		} else if (!isDigitPositive(maxQuantity)) {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message', '数量不正确');
			return false;
		} else {
			clearRemindMessage('maxQuantity_remind_show_message'); // 清除提示
		}
		max_temp = Number(maxQuantity);

	}
	if (q_temp % mul_temp != 0) {
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '挂牌数量必须为下单基数的整数倍');
		return false;
	}else {
		clearRemindMessage('multipleBase_remind_show_message'); 
	}

	if (min_temp > q_temp) { 
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '最小下单量必须要小于挂牌数量!');
		return false;
	} else if (min_temp % mul_temp != 0) { 
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '最小下单量必须为下单基数的整数倍');
		return false;
	} else {
		clearRemindMessage('minQuantity_remind_show_message'); 
	}

	if (max_temp > q_temp) { 
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '最大下单量必须要小于挂牌数量!');
		return false;
	} else if (max_temp % mul_temp != 0) { // 最大下单量必须为下单基数的整数倍
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '最大下单量必须为下单基数的整数倍');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); 
	}

	if (min_temp > max_temp) { // 最大下单量必须要大于等于最小小单量
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message','最大下单量必须大于等于最小小单量');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); 
	}
	return true;
}
/**
 * 拍卖交易（包括多次报价转拍卖）属性的校验
 * 
 * @return
 */
function bidOrderValidate() {
	var listingStartTime = $("#listingStartTime").val();// 挂牌开始时间
	var listingEndTime = $("#listingEndTime").val(); // 挂牌结束时间
	
	var haveAuctioneerObj = $("input:[id='haveAuctioneer']:radio:checked")// 拍卖师
	if (haveAuctioneerObj.length == 0) {
			haveAuctioneerObj.focus();
			showRemaindMessage('haveAuctioneer_remind_show_message', '选择是否有拍卖师');
			return false;
	} else {
			clearRemindMessage('haveAuctioneer_remind_show_message');
	}
	
	var supportPriorityObj = $("input:[id='supportPriority']:radio:checked")// 优先权
	if (supportPriorityObj.length == 0) {
			supportPriorityObj.focus();
			showRemaindMessage('supportPriority_remind_show_message', '选择是否支持优先权');
			return false;
	} else {
			clearRemindMessage('supportPriority_remind_show_message');
	}
	var bidStartPriceObj = $("#bidStartPrice"); // 起拍价格
	if (bidStartPriceObj.length != 0) {
		var bidStartPrice = bidStartPriceObj.val();
		if (typeof (bidStartPrice) == "undefined" || bidStartPrice == "") {
			bidStartPriceObj.focus();
			showRemaindMessage('bidStartPrice_remind_show_message', '起拍价必填');
			return false;
		}else {
			clearRemindMessage('bidStartPrice_remind_show_message');
		} 
		var price_unit = $("#valuationUnit").val();
		if(!validateInputPrice(bidStartPrice,price_unit)){
			bidStartPriceObj.focus();
			showRemaindMessage('bidStartPrice_remind_show_message', '价格不合规范');
			return false;
		}else {
			clearRemindMessage('bidStartPrice_remind_show_message');
		} 
	}
	var allowWatchObj = $("input:[id='allowWatch']:radio:checked")// 是否允许观看
	if (allowWatchObj.length == 0) {
			allowWatchObj.focus();
			showRemaindMessage('allowWatch_remind_show_message', '选择是否允许观看');
	}else {
			clearRemindMessage('allowWatch_remind_show_message');
	}
	var priceDirectionObj = $("input:[id='priceDirection']:radio:checked")// 报价方向
	if (priceDirectionObj.length == 0) {
			priceDirectionObj.focus();
			showRemaindMessage('priceDirection_remind_show_message', '选择报价方向');
			return false;
	} else {
			clearRemindMessage('priceDirection_remind_show_message');
	}
	
	var bidRateObj = $("#bidRate"); // 出价幅度
	if (bidRateObj.length != 0) {
		var bidRate = bidRateObj.val();
		if (typeof (bidRate) != "undefined" && bidRate != "") {
			var price_unit = $("#valuationUnit").val();
			if(!validateInputPrice(bidRate,price_unit)){
				bidStartPriceObj.focus();
				showRemaindMessage('bidRate_remind_show_message', '价格不合规范');
				return false;
			}else {
			clearRemindMessage('bidRate_remind_show_message');
		}
		} else {
			clearRemindMessage('bidRate_remind_show_message');
		}
	}
	
	var haveReservePriceObj = $("input:[id='haveReservePrice']:radio:checked")// 是否有保留价
	if (haveReservePriceObj.length == 0) {
			haveReservePriceObj.focus();
			showRemaindMessage('haveReservePrice_remind_show_message','选择是否有保留价');
			return false;
	} else {
			clearRemindMessage('haveReservePrice_remind_show_message');
	}
	var haveReservePriceTemp = "";
	if (haveReservePriceObj.length != 0) {
		var haveReservePrice = haveReservePriceObj.val();
		if (typeof (haveReservePrice) == "undefined" || haveReservePrice == "") {
			haveReservePriceObj.focus();
			showRemaindMessage('haveReservePrice_remind_show_message','选择是否有保留价');
			return false;
		} else {
			clearRemindMessage('haveReservePrice_remind_show_message');
		}
		haveReservePriceTemp = haveReservePrice;
	}
	
	var reservePriceObj = $("#reservePrice"); // 保留价
	if (reservePriceObj.length != 0 ) {
		var reservePrice = reservePriceObj.val();
		if (haveReservePriceTemp == "Y"){
				var price_unit = $("#valuationUnit").val();
				if(typeof (reservePrice) == "undefined" || reservePrice == "") {
					reservePriceObj.focus();
					showRemaindMessage('reservePrice_remind_show_message', '保留价必填');
					return false;
				}else if(!validateInputPrice(reservePrice,price_unit)){
					bidStartPriceObj.focus();
					showRemaindMessage('reservePrice_remind_show_message', '价格不合规范');
					return false;
				}else{
					clearRemindMessage('reservePrice_remind_show_message');
				}
		} else {
			clearRemindMessage('reservePrice_remind_show_message');
		}
	}
	var firstWaitTimeObj = $("#firstWaitTime"); // 首次报价时长(秒)
	if (firstWaitTimeObj.length != 0 ) {
		var firstWaitTime = firstWaitTimeObj.val();
		if (typeof (firstWaitTime) == "undefined" || firstWaitTime == "") {
			firstWaitTimeObj.focus();
			showRemaindMessage('firstWaitTime_remind_show_message', '首次报价时长为必填');
			return false;
		} else if (!isDigitPositive(firstWaitTime)) {
			firstWaitTimeObj.focus();
			showRemaindMessage('firstWaitTime_remind_show_message', '输入不正确');
			return false;
		} else {
			clearRemindMessage('firstWaitTime_remind_show_message');
		}
	}
	var bidLimitedPeriodObj = $("#bidLimitedPeriod"); // 报价限时周期(秒)
	if (firstWaitTimeObj.length !=0) {
		var bidLimitedPeriod = bidLimitedPeriodObj.val();
		if (typeof (bidLimitedPeriod) == "undefined" || bidLimitedPeriod == "") {
			bidLimitedPeriodObj.focus();
			showRemaindMessage('bidLimitedPeriod_remind_show_message','限时周期为必填');
			return false;
		} else if (!isDigitPositive(bidLimitedPeriod)) {
			bidLimitedPeriodObj.focus();
			showRemaindMessage('bidLimitedPeriod_remind_show_message','输入不正确');
			return false;
		} else {
			clearRemindMessage('bidLimitedPeriod_remind_show_message');
		}
	}
	var applyStartTimeObj = $("#applyStartTime"); // 报名开始时间
	var applyStartTimeTmp = "";
	if (applyStartTimeObj.length !=0) {
		var applyStartTime = applyStartTimeObj.val();
		if (typeof (applyStartTime) == "undefined" || applyStartTime == "") {
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message', '报名开始时间为必填');
			return false;
		} else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		if(!contrastDate(listingStartTime,applyStartTime) || !contrastDate(applyStartTime,listingEndTime)){//报名开始时间
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message','必须在挂牌的有效时间范围内');
			return false;
		}else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		applyStartTimeTmp = applyStartTime;
	}
	
	var applyEndTimeObj = $("#applyEndTime"); // 报名结束时间
	var applyEndTimeTemp = "";
	if (applyEndTimeObj.length !=0) {
		var applyEndTime = applyEndTimeObj.val();
		if (typeof (applyEndTime) == "undefined" || applyEndTime == "") {
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message', '报名结束时间为必填');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		if(!contrastDate(applyStartTimeTmp,applyEndTime)){
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message','报名结束时间要晚于报名开始时间');
			return false;
		}else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		if(!contrastDate(listingStartTime,applyEndTime) || !contrastDate(applyEndTime,listingEndTime)){//报名开始时间
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message','必须在挂牌的有效时间范围内');
			return false;
		}else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		applyEndTimeTemp = applyEndTime;
	}

	var bidStartTimeObj = $("#bidStartTime"); // 竞价开始时间
	if (bidStartTimeObj.length !=0) {
		var bidStartTime = bidStartTimeObj.val();
		if (typeof (bidStartTime) == "undefined" || bidStartTime == "") {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message', '竞价开始时间为必填');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
		if (!contrastDate(applyEndTimeTemp, bidStartTime)) {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message','竞价开始时间要晚于报名结束时间');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
		if (!contrastDate(listingStartTime,bidStartTime) || !contrastDate(bidStartTime,listingEndTime)) {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message','必须在挂牌的有效时间范围内');
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
	var zipCodeObj = $("#zipCode");
	var tradingTypeObj = $("input[name='tradingType']:radio:checked"); // 交易方式[添加挂牌]
	if(tradingTypeObj.length == 0){
		tradingTypeObj = $("input[name='tradingType']");//交易方式[修改挂牌]
		
	}
	var quantityObj = $("#quantity");
	
	/**不知道这块是干嘛的？**/
	var leaveQuantityObj = $('#leaveQuantity'); // 项目库存量
	var breedStandardObj = $("#breedStandard");
	var breedStandardIdObj = $("#breedStandardId");
	
	/**挂牌数量、计量单位检查**/
	if(quantityObj.length != 0){
		var q = quantityObj.val();
		if(q == "" || q == "0"){
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message','挂牌数量为必填且不能为0');
			return false;
		}
	}
	
	/**挂牌价格、挂牌单位检查**/
	if (!validatePrice()) {
		return false;
	}

	
	/**挂牌开始时间、挂牌结束时间检查**/
	if (listingStartTimeObj.length != 0 && listingEndTimeObj.length != 0) {
		var listingStartTime = listingStartTimeObj.val();
		var listingEndTime = listingEndTimeObj.val();
		if (listingStartTime == "") {
			listingStartTimeObj.focus();
			showRemaindMessage('listingStartTime_remind_show_message','挂牌开始时间为必填');
			//return false;
		} else {
			clearRemindMessage('listingStartTime_remind_show_message');
		}
		if (listingEndTime == "") {
			listingEndTimeObj.focus()
			showRemaindMessage('listingEndTime_remind_show_message','挂牌结束时间为必填');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		/*var days = daysBetween(listingEndTime, listingStartTime);
		var today = new Date();
		var day = today.getDate();
		var month = today.getMonth() + 1;
		var year = today.getYear();
		if (daysBetween(listingEndTime, year + "-" + month + "-" + day) < 0) {
			listingEndTimeObj.focus();
			showRemaindMessage('listingEndTime_remind_show_message',
					'挂牌结束时间必须要大于等于今天');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}*/

		/*var end_time_str = changeDateFormat(listingEndTime);
		var start_time_str = changeDateFormat(listingStartTime);
		var mil_sec = new Date(end_time_str) - new Date(start_time_str);
		if(mil_sec <= 0){*/
		if(!contrastDate(listingStartTime,listingEndTime)){
			listingEndTimeObj.focus()
			showRemaindMessage('listingEndTime_remind_show_message','挂牌结束时间必须晚于开始时间');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		
	} else {
		showRemaindMessage('listingEndTime_remind_show_message', '输入的日期格式不正确');
		return false;
	}
	
	/**不同交易方式下的数据检查**/
	if (tradingTypeObj) {
		var tradingType = tradingTypeObj.val();
		if ("placeOrder" == tradingType) {
			if (!placeOrderValidate()) {
				return false;
			}
		} else if ("bidOrder" == tradingType || "mulitBidOrder" == tradingType) {
			if (!bidOrderValidate()) {
				return false;
			}
		}
	}
	
	/**附件检查**/
	var attachedFileObj = $("#attachedFile");
	var attachedFileValue = attachedFileObj.val();
	if(attachedFileValue){
		if(!/.(doc|docx|xls|xlsx|zip|rar|ppt|pptx|txt|wps|pdf|csv|DOC|DOCX|XLS|XLSX|ZIP|RAR|PPT|PPTX|TXT|WPS|PDF|CSV)$/.test(attachedFileValue)){
			attachedFileObj.focus();
			showRemaindMessage('attachedFile_remind_show_message','附件格式不正确');
			return false;
		}else{
			clearRemindMessage('attachedFile_remind_show_message');
		}
	}
	
	/**邮编检查..**/
	if (zipCodeObj) {
		var zipCode = zipCodeObj.val();
		var re = /^[0-9]{6}$/;
		if (zipCode != "" && !(re.test(zipCode)) ){
			zipCodeObj.focus();
			showRemaindMessage('zipCode_remind_show_message', '格式不正确');
			return false;
		} else {
			clearRemindMessage('zipCode_remind_show_message'); // 清除提示
		}
	}
	return true;
}

/**
 * 资金价格方面检查
 * **/
function validatePrice() {
//	var listingPriceObj = $("#listingPrice"); // 挂牌单价
	var listingPriceObj = $("#listingPriceDesc"); // 挂牌单价
	var valuationUnitObj = $("#valuationUnit"); // 计价单位
	if (listingPriceObj && valuationUnitObj) {
		var listingPrice = listingPriceObj.val();
		var valuationUnit = valuationUnitObj.val();
		//必填检查
		if (listingPrice == "") {
			listingPriceObj.focus();
			showRemaindMessage('listingPrice_remind_show_message', '挂牌价格必填');
			return false;
		} else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		if (valuationUnit == "") {
			valuationUnitObj.focus();
			showRemaindMessage('valuationUnit_remind_show_message', '计价单位必选');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		//格式检查
		if(!validateInputPrice(listingPrice,valuationUnit))
		{
			listingPriceObj.focus();
			showRemaindMessage('listingPrice_remind_show_message','价格不合规范');
			return false;
		}else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		return true;
	} else {
		alert("请检查计价单位和价格元素是否存在");
		return false;
	}

}
function doUploadImage(imgUrlObj) {
	if (imgUrlObj) {
		var imgUrl = imgUrlObj.value;
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
/**
 * 验证页面输入（如果有输入）金钱字符串的格式 不考虑小数点，
 * 数字的总长度不超过17位
 * 空字符串返回true
 */
function validateInputPrice(price,unit) {
	var result = true;
	var price_unit = unit;
	var price_str = "" + price;
	if(price_str != ""){
		if(price_unit == ""){
			return false;
		}
		if (price_str.indexOf(".") != -1) {// 有小数点
			if (price_str.length > 18) {
				result = false;
			} else {
				//var _bid_unite = hallJson.auctionHallDTO.valuationUnit;// 报价单位
				if ("yiyuan" == price_unit) {
					var reg = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;// 小数，小数点后10位
					result = reg.test(price_str);
				} else if ("wanyuan" == price_unit) {
					var reg = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;// 小数，小数点后6位
					result = reg.test(price_str);
				} else if ("yuan" == price_unit) {
					var reg = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;// 小数，小数点后2位
					result = reg.test(price_str);
				}
			}
		} else {
			if (price_str.length > 17) {
				result = false;
			}
			if ("yiyuan" == price_unit) {
					var reg = /^[0-9]{1,7}$/;// 7
					result = reg.test(price_str);
			} else if ("wanyuan" == price_unit) {
					var reg = /^[0-9]{1,11}$/;//11 
					result = reg.test(price_str);
			} else if ("yuan" == price_unit) {
					var reg = /^[0-9]{1,15}$/;// 15
					result = reg.test(price_str);
			}
		}
	}
	return result;
}

/**
 * 将空间得到的时间字符串"YYYY-MM-DD HH:mm:ss"转换为可以
 * 用于创建日期的"MM DD,YYYY HH:mm:ss"
 * @param {} dateStr
 */
function changeDateFormat(dateStr){
	var oldStr = dateStr;//YYYY-MM-DD HH:mm:ss格式
	if(oldStr != ""){
		var arrayTmp = oldStr.split(" ");
		var date = arrayTmp[0];
		var arrayDate = date.split("-");
		var y = arrayDate[0];
		var m = parseInt(arrayDate[1]) - 1;//月份从0-11
		var d = arrayDate[2];
		var t = arrayTmp[1];
		var newStr = m+" "+d+","+y+" "+t;
		return newStr;
	}
	return "";
}
/**
 * 比较两个时间字符串代表的时间的先后
 * 返回：如果dateStr1<dateStr2,true,其他false
 * **/
function contrastDate(dateStr1,dateStr2){
	/*var d_str1 = changeDateFormat(dateStr1);
	var d_str2 = changeDateFormat(dateStr2);
	var date1_millisecond = new Date(d_str1).getTime();
	var date2_millisecond = new Date(d_str2).getTime();*/
	if(dateStr1 < dateStr2){
		return true;
	}
	return false;
}
