/**�������Ͷ�̬���ԡ����׶�̬����**/
$(document).ready(function() {
	var tType = $("input:[name=tradingType]:radio:checked").val();
	
	var bsType = $("#bsType").val();
	//loadPrjTradeTypeFormURL(tType, "prjTradeTypeBoxId", "");// ���ؽ��׶�̬����
	loadPrjTradeTypeDisByBsType(tType, "prjTradeTypeBoxId", "",bsType);// ���ؽ��׶�̬����,�����Ʒ������
		var pTypeCode = jQuery("#projectTypeCode").val();
		var pTypeName = jQuery("#projectTypeName").val();
		var sId = $("#breedStandard").val();
		if (pTypeName != "" && sId == "") {
			prjMetaFrom(pTypeCode, pTypeName);// ������Ŀ��̬����
		}
	});
/**��׼���**/
$(document).ready(
		function() {
			$('#breedStandardSelect').change(
					function() {
						var selectObj = $("#breedStandardSelect").find("option:selected");
						if (selectObj.val() == "0" || selectObj.val() == "��ѡ��" || selectObj.val() == "") {
							// չʾ��̬����
							var pTypeCode = jQuery("#projectTypeCode").val();
							var pTypeName = jQuery("#projectTypeName").val();
							if (pTypeName != "") {
								prjMetaFrom(pTypeCode, pTypeName);// ������Ŀ��̬����
							}
							$("#standShowId").empty();
							$('#breedStandard').val("");
							$('#breedStandardId').val("");
							$("#prjTypeMetaBox").show();
						} else {
							// ���ض�̬����
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
/**
 * �µ���������У��
 * 
 * @return
 */
function placeOrderValidate() {
	var result = true;
	var retailObj = $("input:[id='retail']:radio:checked");
	var maxQuantityObj = $('#maxQuantity'); // ����µ���
	var minQuantityObj = $('#minQuantity'); // ��С�µ���
	var multipleBaseObj = $('#multipleBase'); // �µ�����
	var quantityObj = $('#quantity'); // ��������
	if(retailObj.length ==0){
		multipleBaseObj.focus();
		showRemaindMessage('retail_remind_show_message', '��ʽ��ѡ');
		return false;
	}else {
			clearRemindMessage('retail_remind_show_message'); // �����ʾ
	}
	var q_temp;
	if (quantityObj.length != 0) {
		var quantity = quantityObj.val();
		if (quantity == "") {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '������������');
			return false;
		} else if (!isDigitPositive(quantity)) {
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message', '��������ȷ');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // �����ʾ
		}
		q_temp = Number(quantity);
	}
	var mul_temp;
	if (multipleBaseObj.length != 0) {
		var multipleBase = multipleBaseObj.val();
		if (multipleBase == "") {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message','�µ���������');
			return false;
		} else if (!isDigitPositive(multipleBase)) {
			multipleBaseObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '��������ȷ');
			return false;
		} else if (multipleBase > q_temp) {
			minQuantityObj.focus();
			showRemaindMessage('multipleBase_remind_show_message', '�µ���������С�ڹ�������!');
			return false;
		} else {
			clearRemindMessage('multipleBase_remind_show_message'); // �����ʾ
		}
		mul_temp = Number(multipleBase);
	}
	var min_temp;
	if (minQuantityObj.length != 0) {
		var minQuantity = minQuantityObj.val();
		if (minQuantity == "") {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message', '��С�µ�������');
			return false;
		} else if (!isDigitPositive(minQuantity)) {
			minQuantityObj.focus();
			showRemaindMessage('minQuantity_remind_show_message', '��������ȷ');
			return false;
		} else {
			clearRemindMessage('minQuantity_remind_show_message'); // �����ʾ
		}
		min_temp = Number(minQuantity);
	}
	var max_temp;
	if (maxQuantityObj.length != 0) {
		var maxQuantity = maxQuantityObj.val();
		if (maxQuantity == "") {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message', '����µ�������');
			return false;
		} else if (!isDigitPositive(maxQuantity)) {
			maxQuantityObj.focus();
			showRemaindMessage('maxQuantity_remind_show_message', '��������ȷ');
			return false;
		} else {
			clearRemindMessage('maxQuantity_remind_show_message'); // �����ʾ
		}
		max_temp = Number(maxQuantity);

	}
	if (q_temp % mul_temp != 0) {
		multipleBaseObj.focus();
		showRemaindMessage('multipleBase_remind_show_message', '������������Ϊ�µ�������������');
		return false;
	}else {
		clearRemindMessage('multipleBase_remind_show_message'); 
	}

	if (min_temp > q_temp) { 
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '��С�µ�������ҪС�ڹ�������!');
		return false;
	} else if (min_temp % mul_temp != 0) { 
		minQuantityObj.focus();
		showRemaindMessage('minQuantity_remind_show_message', '��С�µ�������Ϊ�µ�������������');
		return false;
	} else {
		clearRemindMessage('minQuantity_remind_show_message'); 
	}

	if (max_temp > q_temp) { 
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '����µ�������ҪС�ڹ�������!');
		return false;
	} else if (max_temp % mul_temp != 0) { // ����µ�������Ϊ�µ�������������
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message', '����µ�������Ϊ�µ�������������');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); 
	}

	if (min_temp > max_temp) { // ����µ�������Ҫ���ڵ�����СС����
		maxQuantityObj.focus();
		showRemaindMessage('maxQuantity_remind_show_message','����µ���������ڵ�����СС����');
		return false;
	} else {
		clearRemindMessage('maxQuantity_remind_show_message'); 
	}
	return true;
}
/**
 * �������ף�������α���ת���������Ե�У��
 * 
 * @return
 */
function bidOrderValidate() {
	var listingStartTime = $("#listingStartTime").val();// ���ƿ�ʼʱ��
	var listingEndTime = $("#listingEndTime").val(); // ���ƽ���ʱ��
	
	var haveAuctioneerObj = $("input:[id='haveAuctioneer']:radio:checked")// ����ʦ
	if (haveAuctioneerObj.length == 0) {
			haveAuctioneerObj.focus();
			showRemaindMessage('haveAuctioneer_remind_show_message', 'ѡ���Ƿ�������ʦ');
			return false;
	} else {
			clearRemindMessage('haveAuctioneer_remind_show_message');
	}
	
	var supportPriorityObj = $("input:[id='supportPriority']:radio:checked")// ����Ȩ
	if (supportPriorityObj.length == 0) {
			supportPriorityObj.focus();
			showRemaindMessage('supportPriority_remind_show_message', 'ѡ���Ƿ�֧������Ȩ');
			return false;
	} else {
			clearRemindMessage('supportPriority_remind_show_message');
	}
	var bidStartPriceObj = $("#bidStartPrice"); // ���ļ۸�
	if (bidStartPriceObj.length != 0) {
		var bidStartPrice = bidStartPriceObj.val();
		if (typeof (bidStartPrice) == "undefined" || bidStartPrice == "") {
			bidStartPriceObj.focus();
			showRemaindMessage('bidStartPrice_remind_show_message', '���ļ۱���');
			return false;
		}else {
			clearRemindMessage('bidStartPrice_remind_show_message');
		} 
		var price_unit = $("#valuationUnit").val();
		if(!validateInputPrice(bidStartPrice,price_unit)){
			bidStartPriceObj.focus();
			showRemaindMessage('bidStartPrice_remind_show_message', '�۸񲻺Ϲ淶');
			return false;
		}else {
			clearRemindMessage('bidStartPrice_remind_show_message');
		} 
	}
	var allowWatchObj = $("input:[id='allowWatch']:radio:checked")// �Ƿ�����ۿ�
	if (allowWatchObj.length == 0) {
			allowWatchObj.focus();
			showRemaindMessage('allowWatch_remind_show_message', 'ѡ���Ƿ�����ۿ�');
	}else {
			clearRemindMessage('allowWatch_remind_show_message');
	}
	var priceDirectionObj = $("input:[id='priceDirection']:radio:checked")// ���۷���
	if (priceDirectionObj.length == 0) {
			priceDirectionObj.focus();
			showRemaindMessage('priceDirection_remind_show_message', 'ѡ�񱨼۷���');
			return false;
	} else {
			clearRemindMessage('priceDirection_remind_show_message');
	}
	
	var bidRateObj = $("#bidRate"); // ���۷���
	if (bidRateObj.length != 0) {
		var bidRate = bidRateObj.val();
		if (typeof (bidRate) != "undefined" && bidRate != "") {
			var price_unit = $("#valuationUnit").val();
			if(!validateInputPrice(bidRate,price_unit)){
				bidStartPriceObj.focus();
				showRemaindMessage('bidRate_remind_show_message', '�۸񲻺Ϲ淶');
				return false;
			}else {
			clearRemindMessage('bidRate_remind_show_message');
		}
		} else {
			clearRemindMessage('bidRate_remind_show_message');
		}
	}
	
	var haveReservePriceObj = $("input:[id='haveReservePrice']:radio:checked")// �Ƿ��б�����
	if (haveReservePriceObj.length == 0) {
			haveReservePriceObj.focus();
			showRemaindMessage('haveReservePrice_remind_show_message','ѡ���Ƿ��б�����');
			return false;
	} else {
			clearRemindMessage('haveReservePrice_remind_show_message');
	}
	var haveReservePriceTemp = "";
	if (haveReservePriceObj.length != 0) {
		var haveReservePrice = haveReservePriceObj.val();
		if (typeof (haveReservePrice) == "undefined" || haveReservePrice == "") {
			haveReservePriceObj.focus();
			showRemaindMessage('haveReservePrice_remind_show_message','ѡ���Ƿ��б�����');
			return false;
		} else {
			clearRemindMessage('haveReservePrice_remind_show_message');
		}
		haveReservePriceTemp = haveReservePrice;
	}
	
	var reservePriceObj = $("#reservePrice"); // ������
	if (reservePriceObj.length != 0 ) {
		var reservePrice = reservePriceObj.val();
		if (haveReservePriceTemp == "Y"){
				var price_unit = $("#valuationUnit").val();
				if(typeof (reservePrice) == "undefined" || reservePrice == "") {
					reservePriceObj.focus();
					showRemaindMessage('reservePrice_remind_show_message', '�����۱���');
					return false;
				}else if(!validateInputPrice(reservePrice,price_unit)){
					bidStartPriceObj.focus();
					showRemaindMessage('reservePrice_remind_show_message', '�۸񲻺Ϲ淶');
					return false;
				}else{
					clearRemindMessage('reservePrice_remind_show_message');
				}
		} else {
			clearRemindMessage('reservePrice_remind_show_message');
		}
	}
	var firstWaitTimeObj = $("#firstWaitTime"); // �״α���ʱ��(��)
	if (firstWaitTimeObj.length != 0 ) {
		var firstWaitTime = firstWaitTimeObj.val();
		if (typeof (firstWaitTime) == "undefined" || firstWaitTime == "") {
			firstWaitTimeObj.focus();
			showRemaindMessage('firstWaitTime_remind_show_message', '�״α���ʱ��Ϊ����');
			return false;
		} else if (!isDigitPositive(firstWaitTime)) {
			firstWaitTimeObj.focus();
			showRemaindMessage('firstWaitTime_remind_show_message', '���벻��ȷ');
			return false;
		} else {
			clearRemindMessage('firstWaitTime_remind_show_message');
		}
	}
	var bidLimitedPeriodObj = $("#bidLimitedPeriod"); // ������ʱ����(��)
	if (firstWaitTimeObj.length !=0) {
		var bidLimitedPeriod = bidLimitedPeriodObj.val();
		if (typeof (bidLimitedPeriod) == "undefined" || bidLimitedPeriod == "") {
			bidLimitedPeriodObj.focus();
			showRemaindMessage('bidLimitedPeriod_remind_show_message','��ʱ����Ϊ����');
			return false;
		} else if (!isDigitPositive(bidLimitedPeriod)) {
			bidLimitedPeriodObj.focus();
			showRemaindMessage('bidLimitedPeriod_remind_show_message','���벻��ȷ');
			return false;
		} else {
			clearRemindMessage('bidLimitedPeriod_remind_show_message');
		}
	}
	var applyStartTimeObj = $("#applyStartTime"); // ������ʼʱ��
	var applyStartTimeTmp = "";
	if (applyStartTimeObj.length !=0) {
		var applyStartTime = applyStartTimeObj.val();
		if (typeof (applyStartTime) == "undefined" || applyStartTime == "") {
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message', '������ʼʱ��Ϊ����');
			return false;
		} else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		if(!contrastDate(listingStartTime,applyStartTime) || !contrastDate(applyStartTime,listingEndTime)){//������ʼʱ��
			applyStartTimeObj.focus();
			showRemaindMessage('applyStartTime_remind_show_message','�����ڹ��Ƶ���Чʱ�䷶Χ��');
			return false;
		}else {
			clearRemindMessage('applyStartTime_remind_show_message');
		}
		applyStartTimeTmp = applyStartTime;
	}
	
	var applyEndTimeObj = $("#applyEndTime"); // ��������ʱ��
	var applyEndTimeTemp = "";
	if (applyEndTimeObj.length !=0) {
		var applyEndTime = applyEndTimeObj.val();
		if (typeof (applyEndTime) == "undefined" || applyEndTime == "") {
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message', '��������ʱ��Ϊ����');
			return false;
		} else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		if(!contrastDate(applyStartTimeTmp,applyEndTime)){
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message','��������ʱ��Ҫ���ڱ�����ʼʱ��');
			return false;
		}else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		if(!contrastDate(listingStartTime,applyEndTime) || !contrastDate(applyEndTime,listingEndTime)){//������ʼʱ��
			applyEndTimeObj.focus();
			showRemaindMessage('applyEndTime_remind_show_message','�����ڹ��Ƶ���Чʱ�䷶Χ��');
			return false;
		}else {
			clearRemindMessage('applyEndTime_remind_show_message');
		}
		applyEndTimeTemp = applyEndTime;
	}

	var bidStartTimeObj = $("#bidStartTime"); // ���ۿ�ʼʱ��
	if (bidStartTimeObj.length !=0) {
		var bidStartTime = bidStartTimeObj.val();
		if (typeof (bidStartTime) == "undefined" || bidStartTime == "") {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message', '���ۿ�ʼʱ��Ϊ����');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
		if (!contrastDate(applyEndTimeTemp, bidStartTime)) {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message','���ۿ�ʼʱ��Ҫ���ڱ�������ʱ��');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
		if (!contrastDate(listingStartTime,bidStartTime) || !contrastDate(bidStartTime,listingEndTime)) {
			bidStartTimeObj.focus();
			showRemaindMessage('bidStartTime_remind_show_message','�����ڹ��Ƶ���Чʱ�䷶Χ��');
			return false;
		} else {
			clearRemindMessage('bidStartTime_remind_show_message');
		}
	}
	
	return true;
}
/**
 * ҳ��̶�������֤
 * 
 * @return
 */
function validateForm() {
	var listingStartTimeObj = $("#listingStartTime");
	var listingEndTimeObj = $("#listingEndTime");
	var zipCodeObj = $("#zipCode");
	var tradingTypeObj = $("input[name='tradingType']:radio:checked"); // ���׷�ʽ[��ӹ���]
	if(tradingTypeObj.length == 0){
		tradingTypeObj = $("input[name='tradingType']");//���׷�ʽ[�޸Ĺ���]
		
	}
	var quantityObj = $("#quantity");
	
	/**��֪������Ǹ���ģ�**/
	var leaveQuantityObj = $('#leaveQuantity'); // ��Ŀ�����
	var breedStandardObj = $("#breedStandard");

	/**����������������λ���**/
	if(quantityObj.length != 0){
		var q = quantityObj.val();
		if(q == "" || q == "0"){
			quantityObj.focus();
			showRemaindMessage('quantity_remind_show_message','��������Ϊ�����Ҳ���Ϊ0');
			return false;
		}
	}
	
	/**���Ƽ۸񡢹��Ƶ�λ���**/
	if (!validatePrice()) {
		return false;
	}

	
	/**���ƿ�ʼʱ�䡢���ƽ���ʱ����**/
	if (listingStartTimeObj.length != 0 && listingEndTimeObj.length != 0) {
		var listingStartTime = listingStartTimeObj.val();
		var listingEndTime = listingEndTimeObj.val();
		if (listingStartTime == "") {
			listingStartTimeObj.focus();
			showRemaindMessage('listingStartTime_remind_show_message','���ƿ�ʼʱ��Ϊ����');
			//return false;
		} else {
			clearRemindMessage('listingStartTime_remind_show_message');
		}
		if (listingEndTime == "") {
			listingEndTimeObj.focus()
			showRemaindMessage('listingEndTime_remind_show_message','���ƽ���ʱ��Ϊ����');
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
					'���ƽ���ʱ�����Ҫ���ڵ��ڽ���');
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
			showRemaindMessage('listingEndTime_remind_show_message','���ƽ���ʱ��������ڿ�ʼʱ��');
			return false;
		} else {
			clearRemindMessage('listingEndTime_remind_show_message');
		}
		
	} else {
		showRemaindMessage('listingEndTime_remind_show_message', '��������ڸ�ʽ����ȷ');
		return false;
	}
	
	/**��ͬ���׷�ʽ�µ����ݼ��**/
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
	
	/**�������**/
	var attachedFileObj = $("#attachedFile");
	var attachedFileValue = attachedFileObj.val();
	if(attachedFileValue){
		if(!/.(doc|docx|xls|xlsx|zip|rar|ppt|pptx|txt|wps|pdf|csv|DOC|DOCX|XLS|XLSX|ZIP|RAR|PPT|PPTX|TXT|WPS|PDF|CSV)$/.test(attachedFileValue)){
			attachedFileObj.focus();
			showRemaindMessage('attachedFile_remind_show_message','������ʽ����ȷ');
			return false;
		}else{
			clearRemindMessage('attachedFile_remind_show_message');
		}
	}
	
	/**�ʱ���..**/
	if (zipCodeObj) {
		var zipCode = zipCodeObj.val();
		var re = /^[0-9]{6}$/;
		if (zipCode != "" && !(re.test(zipCode)) ){
			zipCodeObj.focus();
			showRemaindMessage('zipCode_remind_show_message', '��ʽ����ȷ');
			return false;
		} else {
			clearRemindMessage('zipCode_remind_show_message'); // �����ʾ
		}
	}
	return true;
}


/**�ʽ�۸�����**/
function validatePrice() {
	var listingPriceObj = $("#listingPrice"); // ���Ƶ���
	var valuationUnitObj = $("#valuationUnit"); // �Ƽ۵�λ
	if (listingPriceObj && valuationUnitObj) {
		var listingPrice = listingPriceObj.val();
		var valuationUnit = valuationUnitObj.val();
		//������
		if (listingPrice == "") {
			listingPriceObj.focus();
			showRemaindMessage('listingPrice_remind_show_message', '���Ƽ۸����');
			return false;
		} else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		if (valuationUnit == "") {
			valuationUnitObj.focus();
			showRemaindMessage('valuationUnit_remind_show_message', '�Ƽ۵�λ��ѡ');
			return false;
		} else {
			clearRemindMessage('valuationUnit_remind_show_message');
		}
		//��ʽ���
		if(!validateInputPrice(listingPrice,valuationUnit))
		{
			listingPriceObj.focus();
			showRemaindMessage('listingPrice_remind_show_message','�۸񲻺Ϲ淶');
			return false;
		}else {
			clearRemindMessage('listingPrice_remind_show_message');
		}
		return true;
	} else {
		alert("����Ƽ۵�λ�ͼ۸�Ԫ���Ƿ����");
		return false;
	}

}

/**
 * �����ʾ������Ϣ
 * 
 * @param Object
 * @return
 */
function clearRemindMessage(Object) {
	$('#' + Object).html('');
}
/**
 * ��ʾҳ����ʾ��Ϣ
 * 
 * @param Object
 * @param message
 * @return
 */
function showRemaindMessage(Object, message) {
	$('#' + Object).html(message);
}
$(document)
		.ready(
				function() {
					jQuery.validator.setDefaults( {
						submitHandler : function(form) {
							if (!validateForm()) {
								return false;
							}
							// ƴװ���յ�ַ
							var pe_province = $("#pe_province").find(
									"option:selected");
							var pe_city = $("#pe_city").find("option:selected");
							var pe_area = $("#area").find("option:selected");
							//var strAddress = pe_province.text()
							//		+ pe_city.text() + pe_area.text()
							//		+ $("#address").val();
							var strAddress = pe_province.text()
							+ (pe_city.text() != "��ѡ��" ? pe_city.text() : "") + (pe_area.text() != "��ѡ��" ? pe_area.text() : "")
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
							substationId : {
								required : true
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
								required : "��Ϊ������",
								maxlength : "���볤�������100���ַ���"
							},
							substationId : {
								required : "��Ϊ������"
							},
							quantity : {
								required : "��Ϊ������",
								digits : "������������"
							},
							listingPriceDesc : {
								required : "��Ϊ������",
								number : "������Ϸ�������"
							},
							projectTypeCode : {
								required : "����Ϊ������"
							},
							listingStartTime : {
								required : "��Ϊ������"
							},
							listingEndTime : {
								required : "��Ϊ������"
							},
							tradeTypeValue : {
								required : "��ѡ���׷�ʽ"
							},
							paymentType : {
								required : "��Ϊ������",
								minlength : "����Ҫѡ��1��"
							},
							deliveryType : {
								required : "��Ϊ������",
								minlength : "����Ҫѡ��1��"
							},
							invoice : {
								required : "��Ϊ������",
								minlength : "����Ҫѡ��1��"
							},
							phone : {
								required : "��Ϊ������",
								maxlength : "���ܳ���20���ַ�����"
							},
							linkMan : {
								required : "��Ϊ������",
								maxlength : "���ܳ���30���ַ�����"
							},
							area : {
								required : "��Ϊ������"
							},
							address : {
								required : "��Ϊ������",
								maxlength : "���ܳ���80���ַ�����"
							},
							storehouse : {
								maxlength : "���ܳ���30���ַ�����"
							}
						}
					});
				});

$(document).ready(function() {
	$('#quantity').bind('focusout', function() {
		$('#totalPay').val($(this).val() * $('#listingPrice').val());
	});
});
function checkTypeAndStandard() {

	return false;
	if ($("#breedStandardSelect").val() == ""
			&& $("#projectTypeName").val() == "") {
		$("#standardAndType").text("��׼������Ŀ����ѡ��һ��");
		return false;
	} else {
		$("#standardAndType").text("");
		return true;
	}
}
$(document).ready(
		function() {
			$('#projectTypeName').click(
					function() {
						showPrjTypeSel(this, '', 'projectTypeCode',
								'projectTypeName', 'prjTypeMetaBox');
					});

		});
function chooseProjectType(data) {
	jQuery("#projectTypeCode").val(data.code);
	jQuery("#projectTypeName").val(data.name);
}

function setStandProp(prjTypeMetaBox, htmContent) {
	jQuery("#" + prjTypeMetaBox).html(htmContent);
	jQuery("#projectTypeName").attr('disabled', 'disabled');
}

/**
 * �������׵��¼���
 */
$(document).ready(function() {
	// �Ƿ��б������۵�ѡ��
		$("input[id='haveReservePrice']").live("click", function() {
			if ($(this).val() == "Y") { // �б�����
					// �������������Ч
				$("#reservePrice").show();
				// attr("disabled", "enabled");
			} else { // �ޱ�����
				// ���ۼ������disable
				$("#reservePrice").hide();
				// attr("disabled", "disabled");
			}
		});
	});

/**
 * ajaxɾ��֮ǰ�ϴ��ĸ���
 * @param projectId ������ĿId
 * @param attachedFilePath ������Ŀ����·��
 * @return
 */
function deleteOrginalFile(projectId,attachedFilePath){
	if((projectId == null || projectId == "") && (attachedFilePath == null || attachedFilePath == "")){
		alert("ȱ�ٲ������޷�����ɾ����");
	}else{
		if(confirm("�ò�������ɾ��ԭ�еĸ�����ȷ��ɾ����")){
			jQuery.ajax({
				type	:	'POST',
				url		:	appServer + '/project/deleteFile.htm',
				dataType:	"json",
				data	:	{projectId : projectId,attachedFilePath : attachedFilePath},
				success	:	function(result){
								if(result > 0){
									alert("ɾ���ɹ���");
									$("#deleteFileButton").hide();
								}else{
									alert("ɾ��ʧ�ܣ�");
								}
							},
				error	:	function(){
								alert("������æ�����Ժ����ԣ�");
							}
			});
		}
	}
}

function clearPic(){
	jQuery("#fileChoose0").attr("value", "");
}

function clearPic1(){
	jQuery("#fileChoose1").attr("value", "");
}

function clearPic2(){
	jQuery("#fileChoose2").attr("value", "");
}

function clearPic3(){
	jQuery("#fileChoose3").attr("value", "");
}

function clearPic4(){
	jQuery("#fileChoose4").attr("value", "");
}

function clearFile(){
	jQuery("#attachedFile").attr("value", "");
}

/**
 * ��֤ҳ�����루��������룩��Ǯ�ַ����ĸ�ʽ ������С���㣬
 * ���ֵ��ܳ��Ȳ�����17λ
 * ���ַ�������true
 */
function validateInputPrice(price,unit) {
	var result = true;
	var price_unit = unit;
	var price_str = "" + price;
	if(price_str != ""){
		if(price_unit == ""){
			return false;
		}
		if (price_str.indexOf(".") != -1) {// ��С����
			if (price_str.length > 18) {
				result = false;
			} else {
				//var _bid_unite = hallJson.auctionHallDTO.valuationUnit;// ���۵�λ
				if ("yiyuan" == price_unit) {
					var reg = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;// С����С�����10λ
					result = reg.test(price_str);
				} else if ("wanyuan" == price_unit) {
					var reg = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;// С����С�����6λ
					result = reg.test(price_str);
				} else if ("yuan" == price_unit) {
					var reg = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;// С����С�����2λ
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
 * ���ռ�õ���ʱ���ַ���"YYYY-MM-DD HH:mm:ss"ת��Ϊ����
 * ���ڴ������ڵ�"MM DD,YYYY HH:mm:ss"
 * @param {} dateStr
 */
function changeDateFormat(dateStr){
	var oldStr = dateStr;//YYYY-MM-DD HH:mm:ss��ʽ
	if(oldStr != ""){
		var arrayTmp = oldStr.split(" ");
		var date = arrayTmp[0];
		var arrayDate = date.split("-");
		var y = arrayDate[0];
		var m = parseInt(arrayDate[1]) - 1;//�·ݴ�0-11
		var d = arrayDate[2];
		var t = arrayTmp[1];
		var newStr = m+" "+d+","+y+" "+t;
		return newStr;
	}
	return "";
}
/**
 * �Ƚ�����ʱ���ַ��������ʱ����Ⱥ�
 * ���أ����dateStr1<dateStr2,true,����false
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

/**
 * ѡ���������бꡢЭ�����������̶�Ϊ1��������λ�̶�Ϊ�ڣ�
 * ֻ��ѡ���µ�����ʱ�ſ��Ը������͵�λ��
 */
function lockQuantity(tradingType) {
	if("placeOrder" == tradingType){
		$('#quantity').attr("readonly", false);
		$('#measureUnit').attr("disabled", false);
	} else {
		$('#quantity').val("1");
		$('#quantity').attr("readonly", true);
		$('#measureUnit').val("zong");
		$('#measureUnitHidden').val("zong");
		$('#measureUnit').attr("disabled", true);
	}
}
function isLockQuantity(measureUnit) {
	$('#measureUnitHidden').val(measureUnit);
}