$(document).ready(function() {
	var retailObj = $('#retail'); // ���۶���
		if (retailObj) {
			var retail = retailObj.val().trim();
			if ("N" == retail || "n" == retail) { // ����n
				$('#quantity').attr("readonly", "true");
				var leaveQuantityObj = $('#leaveQuantity'); // ��Ŀ�����
				if (leaveQuantityObj && leaveQuantityObj.length > 0) {
					var leaveQuantity = leaveQuantityObj.val();
					if (leaveQuantity > 0) {
						$('#quantity').val(leaveQuantity);
						calculateResult($('#quantity'));
						// alert($('#quantity').val));
					}
				}
			}
		}
		$('#quantity').bind('focusout', function() {
			calculateResult($(this));
			validateQuntity();
		});
	});
$(document).ready(function() {
	jQuery.validator.setDefaults( {
		submitHandler : function(form) {
			if (!validateForm()) {
				return false;
			}
			var msg = "ȷ���ύ����ô���ύ�ɹ����������Ľ��ױ�֤��"+$("#deposit").val()+$("#valuationUnitDesc").val();
			if (confirm(msg)){
				form.submit();
			}
		}
	});
	$('#tradeFrom').validate( {
		rules : {
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
			storehouse:{
				maxlength  : 30
			},
			area	:	{
				required	: true
			}
		},
		messages : {

			phone : {
				required : "��Ϊ������",
				maxlength : "���ܳ���20���ַ�����"
			},
			linkMan : {
				required : "��Ϊ������",
				maxlength : "���ܳ���30���ַ�����"
			},
			address : {
				required : "��Ϊ������",
				maxlength : "���ܳ���80���ַ�����"
			},
			storehouse:{
				maxlength  : "���Ȳ��ܳ���30"
			},
			area	:{
				required	: "��ַ����Ϊ��"
			}
		}
	});
});

function validateQuntity() {
	// ��֤�µ������Ƿ���Ϲ���
	var quantityObj = $('#quantity'); // �û�ʵ����д�µ���
	var maxQuantityObj = $('#maxQuantity'); // ����µ���
	var minQuantityObj = $('#minQuantity'); // ��С�µ���
	var multipleBaseObj = $('#multipleBase'); // �µ�����
	var leaveQuantityObj = $('#leaveQuantity'); // ��Ŀ�����
	var addressObj = $('#address'); // ��ϸ��ַ
	if (maxQuantityObj && quantityObj && minQuantityObj && multipleBaseObj) {
		var quantity = quantityObj.val();
		var maxQuantity = Number(maxQuantityObj.val());
		var minQuantity = Number(minQuantityObj.val());
		var multipleBase = Number(multipleBaseObj.val());
		var leaveQuantity = Number(leaveQuantityObj.val());
		if (!isNumber(quantity)) {
			showRemaindMessage('quantity_remind_show_message', '��������ȷ������');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // �����ʾ
		}
		quantity = Number(quantity);
		if (quantity < 0) {
			showRemaindMessage('quantity_remind_show_message', '����Ҫ����0��');
			return false;

		} else if (quantity < minQuantity) {
			showRemaindMessage('quantity_remind_show_message', '����Ҫ������С�µ�������');
			return false;
		} else if (quantity > maxQuantity) {
			showRemaindMessage('quantity_remind_show_message', '���ܳ�������µ�������');
			return false;
		} else if (quantity % multipleBase != 0) {
			showRemaindMessage('quantity_remind_show_message', '����Ϊ�µ�������������');
			return false;
		} else if (quantity > leaveQuantity) {
			showRemaindMessage('quantity_remind_show_message', '��������㣡');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // �����ʾ
		}

	}
	return true;

}

function validateAddress() {
	// ��֤�µ������Ƿ���Ϲ���
	var addressObj = $('#address'); // ��ϸ��ַ
	var commentsObj = $('#comments');
	if (addressObj) {
		var address = addressObj.val();
		if (address == "") {
			showRemaindMessage('address_remind_show_message', 'Ϊ�����');
			return false;
		} else {
			clearRemindMessage('address_remind_show_message'); // �����ʾ
		}
	}
	if (commentsObj) {
		var comments = commentsObj.val();
		if (comments.length > 100) {
			showRemaindMessage('comments_remind_show_message',
					'��ע̫�����������100���ַ��ڣ�');
			return false;
		} else {
			clearRemindMessage('comments_remind_show_message'); // �����ʾ
		}
	}
	return true;
}
function validateForm() {
	if (!validateQuntity())
		return false;
	if (!validateAddress())
		return false;
	return true;
}
/**
 * �����ܼ�
 * 
 * @return
 */
function calculateResult(thisObj) {
	// �����ܼ�
	var tempNum = 10000000000;
	var totalPayObj = $('#totalPay');
	var listingPriceDescObj = $('#listingPriceDesc');
	var tradeDepositObj = $('#tradeDeposit');
	var depositObj = $('#deposit');
	var valuationUnit = $('#ListingValuationUnit').val();
	if (totalPayObj.size() > 0 && listingPriceDescObj.size() > 0 && tradeDepositObj.size() > 0 && depositObj.size() > 0) {
		var listingPriceDesc = Number(listingPriceDescObj.val());
		var tradeDeposit = Number(tradeDepositObj.val());
//		totalPayObj.val(tempNum * Number(thisObj.val()) * listingPriceDesc
//				/ tempNum);
//		depositObj.val(tempNum * Number(thisObj.val()) * listingPriceDesc
//				* tradeDeposit / tempNum);
//		totalPayObj.val(accDiv(accMul(accMul(tempNum,Number(thisObj.val())),listingPriceDesc),tempNum));
//		depositObj.val(accDiv(accMul(accMul(accMul(tempNum,Number(thisObj.val())),listingPriceDesc),tradeDeposit),tempNum));
		totalPayObj.val(accMul(Number(thisObj.val()),listingPriceDesc));
		var depositNoUnit = accMul(accMul(Number(thisObj.val()),listingPriceDesc),tradeDeposit);
		var afterPoitNum = 0;
		try{
			afterPoitNum = depositNoUnit.toString().split(".")[1].length;
		}catch(e){
			afterPoitNum = 0;
		}
		if(valuationUnit == "yuan" && afterPoitNum > 2){
			depositObj.val(depositNoUnit.toString().substr(0,depositNoUnit.toString().length - afterPoitNum + 2));
		}else if(valuationUnit == "wanyuan" && afterPoitNum > 6){
			depositObj.val(depositNoUnit.toString().substr(0,depositNoUnit.toString().length - afterPoitNum + 6));
		}else if(valuationUnit == "yiyuan" && afterPoitNum > 10){
			depositObj.val(depositNoUnit.toString().substr(0,depositNoUnit.toString().length - afterPoitNum + 10));
		}else{
			depositObj.val(depositNoUnit);
		}
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

/**
 * ��д�����÷���
 */
function resetDo() {
	document.forms['tradeFrom'].reset();

	var retailObj = $('#retail'); // ���۶���
	if (retailObj) {
		var retail = retailObj.val().trim();
		if ("N" == retail || "n" == retail) { // ����n
			$('#quantity').attr("disabled", "disabled");
			$('#quantity').val($('#leaveQuantity').val());
			calculateResult($('#quantity'));
		}
	}
	area = new Area(appServer+"/ajax",orgProvince,orgCity,orgArea,'pe_province','pe_city','pe_area');
}