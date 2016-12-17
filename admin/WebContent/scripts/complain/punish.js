$(function() {
	dochange();
	$("._dealType").change(function() {
		dochange();
	});
});

function dochange(){
	$("#deal_reason").show();
	$("#deal_btn").show();
	var $selectedvalue = $("input[name='dealType']:checked").val();
    if ($selectedvalue == "general") {
		$("#dealTypeDetail").text("不对被投诉方做任何处理，仅做投诉关闭！");
    }else if($selectedvalue == "palceUncheck"){
    	$("#dealTypeDetail").text("1.取消订单，关闭交易；" +
    			"2.扣除下单方的交易违约金赔偿给挂牌方；" +
    			"3.解冻挂牌方交收保证金；" +
    			"4.扣除下单方信用和积分。请谨慎操作！");
    }else if($selectedvalue == "listUncheck"){
    	$("#dealTypeDetail").text("1.取消订单，关闭交易；" +
    			"2.扣除挂牌方的交易违约金赔偿给下单方；" +
    			"3.解冻下单方交收保证金；" +
    			"4.扣除挂牌方信用和积分。请谨慎操作！");
    }else if($selectedvalue == "unPay"){
    	$("#dealTypeDetail").text("1.取消订单，关闭交易；" +
    			"2.扣除买家的交收违约金赔偿给卖家；" +
    			"3.解冻双方交收保证金；" +
    			"4.扣除买家买家信用和积分。请谨慎操作！");
    }else if($selectedvalue == "unDeliver"){
    	$("#dealTypeDetail").text("1.取消订单，关闭交易；" +
    			"2.扣除卖家的交收违约金赔偿给买家；" +
    			"3.解冻双方交收保证金；" +
    			"4.线上付款订单退还已收货款给买家；" +
    			"5.扣除卖家卖家信用和积分。请谨慎操作！");
    }
    //验货处理
    if($("#ccType").val() == "goodsUncheck"){
    	 $("#m_error").text("");
    	 $("#replay").hide();
   		 $("#general1").hide();
   		 $("#general2").hide();
		 if($selectedvalue == "goodsUncheck"){
		    	$("#dealTypeDetail").text("1.订单\"确认到货\"；2.【线上付款订单】将订单交割款打给卖家，【线下付款订单】将不会打款。请谨慎操作！");
		    	//$("#general1").show();
		 }else if($selectedvalue == "delayDeal"){
		    	$("#dealTypeDetail").text("1.货未到，延迟处理本投诉。请在投诉详情中回复延迟处理信息！");
		    	$("#replay").show();
		    	$("#deal_reason").hide();
		    	$("#deal_btn").hide();
		 }else if($selectedvalue == "refund"){
		    	$("#dealTypeDetail").text("1.买家退货，取消订单，关闭交易，【线上付款订单】将全额返还买家货款，【线下付款订单】将不会打款；操作前请确认卖家已收到退货。请谨慎操作！");
		    	$("#m_error").text("");
		 }else if($selectedvalue == "refundPenalty"){
		    	$("#dealTypeDetail").text("1.买家退货，取消订单，关闭交易，【线上付款订单】将全额返还买家货款，【线下付款订单】将不会打款；2.扣除卖家交收违约金补偿给买家，操作前请确认卖家已收到退货；3.扣除卖家信用和积分。请谨慎操作！");
		 }else if($selectedvalue == "amountOffset"){
		    	$("#dealTypeDetail").text("1.买家收货，订单完成，交易成功（如果有验票阶段，那么交易继续，订单进入验票阶段），【线上付款订单】将订单交割款一部分扣除补偿给买家，【线下付款订单】将不会打款。请谨慎操作！");
		    	$("#general1").show();
			   	$("#general2").show(); 
		    	$("#m_error").text("在此输入要扣除的货款金额");
		 }
	}
    //验票处理
    if($("#ccType").val() == "receiptUncheck"){
    	$("#m_error").text("");
    	$("#general1").hide();
		$("#general2").hide();
    	if($selectedvalue == "receiptUncheck"){
		    $("#dealTypeDetail").text("1.订单\"确认到票\";2.【线上付款订单】剩余的货款将全额打给卖家，【线下付款订单】将不会打款;3.订单完成，交易成功。请谨慎操作！");
		    $("#general1").show();
    	}else if($selectedvalue == "unBilling"){
		    $("#dealTypeDetail").text("1.【线上付款订单】将订单剩余货款的一部分扣除作为卖家违约处罚补偿给买家，另一部分打给卖家，【线下付款订单】将不打款；2.全额返还双方交收保证金;3.订单完成，交易成功。请谨慎操作！");
		    $("#general1").show();
	    	$("#general2").show();
		    $("#m_error").text("在此输入要扣除的货款金额");
		}else if($selectedvalue == "unBillingPenalty"){
		    $("#dealTypeDetail").text("1.【线上付款订单】将订单剩余货款的一部分扣除作为卖家违约处罚补偿给买家，另一部分打给卖家，【线下付款订单】将不打款；2.扣除卖家交收违约金补偿给买家，返还买家交收保证金；3.扣除卖家信用和积分;4.订单完成，交易成功。请谨慎操作！");
		    $("#general1").show();
	    	$("#general2").show();
		    $("#m_error").text("在此输入要扣除的货款金额");
		 }
    }
}
function validate(){
	//输入货款金额检查
	var $selectedvalue = $("input[name='dealType']:checked").val();
	if($selectedvalue == "unBilling" || $selectedvalue == "unBillingPenalty" || $selectedvalue == "amountOffset"){
		
		var $inp_amount = $("#dealMoney").val();
		var $amount = $("#money_amount").val();
		var $unite = $("#money_unite").val();
		var regn = /^[ ]+$/;
		if($inp_amount =="" || regn.test($inp_amount)){
			$("#m_error").text("请输入要扣除的货款金额");
			return false;
		}
		if($unite == "yuan"){
			var regYuan1 = /^[1-9][0-9]{0,16}$/;//正整数
			var regYuan2 = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;//小数，小数点后2位
			if(!(regYuan1.test($inp_amount) || regYuan2.test($inp_amount))){
				alert("输入金额不正确！");
				return false;
			}
			var amount_unite = $amount/100;
			if($inp_amount <=0 || $inp_amount>amount_unite){
				alert("请输入一个大于0并且不超过订单交割或剩余款的金额！");
				return false;
			}
		}else if($unite == "wanyuan"){
			var regYuan1 = /^[1-9][0-9]{0,16}$/;//正整数
			var regYuan2 = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;//小数，小数点后6位
			if(!(regYuan1.test($inp_amount) || regYuan2.test($inp_amount))){
				alert("输入金额不正确！");
				return false;
			}
			var amount_unite = $amount/1000000;
			if($inp_amount <=0 || $inp_amount>amount_unite){
				alert("请输入一个大于0并且不超过订单交割或剩余款的金额！");
				return false;
			}
			
		}else if($unite == "yiyuan"){
			var regYuan1 = /^[1-9][0-9]{0,16}$/;//正整数
			var regYuan2 = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;//小数，小数点后10位
			if(!(regYuan1.test($inp_amount) || regYuan2.test($inp_amount))){
				alert("输入金额不正确！");
				return false;
			}
			var amount_unite = $amount/10000000000;
			if($inp_amount <=0 || $inp_amount>amount_unite){
				alert("请输入一个大于0并且不超过订单交割或剩余款的金额！");
				return false;
			}
		}
	}
	//备注内容长度检查
	if($("#reason").val().length >340){
		alert("请输入一个长度最多是340的字符串！");
		return false;
	}
	return true;
}