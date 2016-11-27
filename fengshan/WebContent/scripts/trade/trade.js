$(document).ready(function() {
	var retailObj = $('#retail'); // 零售对象
		if (retailObj) {
			var retail = retailObj.val().trim();
			if ("N" == retail || "n" == retail) { // 整售n
				$('#quantity').attr("readonly", "true");
				var leaveQuantityObj = $('#leaveQuantity'); // 项目库存量
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
			var msg = "确定提交订单么？提交成功将冻结您的交易保证金"+$("#deposit").val()+$("#valuationUnitDesc").val();
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
			storehouse:{
				maxlength  : "长度不能超过30"
			},
			area	:{
				required	: "地址不能为空"
			}
		}
	});
});

function validateQuntity() {
	// 验证下单数量是否符合规则
	var quantityObj = $('#quantity'); // 用户实际填写下单量
	var maxQuantityObj = $('#maxQuantity'); // 最大下单量
	var minQuantityObj = $('#minQuantity'); // 最小下单量
	var multipleBaseObj = $('#multipleBase'); // 下单基数
	var leaveQuantityObj = $('#leaveQuantity'); // 项目库存量
	var addressObj = $('#address'); // 详细地址
	if (maxQuantityObj && quantityObj && minQuantityObj && multipleBaseObj) {
		var quantity = quantityObj.val();
		var maxQuantity = Number(maxQuantityObj.val());
		var minQuantity = Number(minQuantityObj.val());
		var multipleBase = Number(multipleBaseObj.val());
		var leaveQuantity = Number(leaveQuantityObj.val());
		if (!isNumber(quantity)) {
			showRemaindMessage('quantity_remind_show_message', '请输入正确的数量');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // 清除提示
		}
		quantity = Number(quantity);
		if (quantity < 0) {
			showRemaindMessage('quantity_remind_show_message', '必须要大于0！');
			return false;

		} else if (quantity < minQuantity) {
			showRemaindMessage('quantity_remind_show_message', '必须要大于最小下单数量！');
			return false;
		} else if (quantity > maxQuantity) {
			showRemaindMessage('quantity_remind_show_message', '不能超过最大下单数量！');
			return false;
		} else if (quantity % multipleBase != 0) {
			showRemaindMessage('quantity_remind_show_message', '必须为下单基数的整数倍');
			return false;
		} else if (quantity > leaveQuantity) {
			showRemaindMessage('quantity_remind_show_message', '库存量不足！');
			return false;
		} else {
			clearRemindMessage('quantity_remind_show_message'); // 清除提示
		}

	}
	return true;

}

function validateAddress() {
	// 验证下单数量是否符合规则
	var addressObj = $('#address'); // 详细地址
	var commentsObj = $('#comments');
	if (addressObj) {
		var address = addressObj.val();
		if (address == "") {
			showRemaindMessage('address_remind_show_message', '为必填项！');
			return false;
		} else {
			clearRemindMessage('address_remind_show_message'); // 清除提示
		}
	}
	if (commentsObj) {
		var comments = commentsObj.val();
		if (comments.length > 100) {
			showRemaindMessage('comments_remind_show_message',
					'备注太长，请控制在100个字符内！');
			return false;
		} else {
			clearRemindMessage('comments_remind_show_message'); // 清除提示
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
 * 计算总价
 * 
 * @return
 */
function calculateResult(thisObj) {
	// 计算总价
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
 * 重写表单重置方法
 */
function resetDo() {
	document.forms['tradeFrom'].reset();

	var retailObj = $('#retail'); // 零售对象
	if (retailObj) {
		var retail = retailObj.val().trim();
		if ("N" == retail || "n" == retail) { // 整售n
			$('#quantity').attr("disabled", "disabled");
			$('#quantity').val($('#leaveQuantity').val());
			calculateResult($('#quantity'));
		}
	}
	area = new Area(appServer+"/ajax",orgProvince,orgCity,orgArea,'pe_province','pe_city','pe_area');
}