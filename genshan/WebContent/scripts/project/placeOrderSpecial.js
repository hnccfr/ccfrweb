$(function(){
	/** 下单交易整售相关的更改：选择“整售”后下单基数、最大下单量、最小下单量和挂牌数量保持一致* */
	$("#quantity").live("change", function() {
		var tType = $("input:[name=tradingType]:radio:checked").val();
		if (tType == "placeOrder") {
			if ($("input[id='retail']:checked").length > 0) {
				if ($("input[id='retail']:checked").val() == "N") {
					$("#multipleBase").attr("readonly", "readonly")
							.val($("#quantity").val()).css({"background":"none repeat scroll 0 0 #D3D3D3"});
					$("#minQuantity").attr("readonly", "readonly")
							.val($("#quantity").val()).css({"background":"none repeat scroll 0 0 #D3D3D3"});
					$("#maxQuantity").attr("readonly", "readonly")
							.val($("#quantity").val()).css({"background":"none repeat scroll 0 0 #D3D3D3"});
				}
			}
		}
	});

	$("input[id='retail']").live("click", function() {
		if ($(this).val() == "Y") {
			$("#multipleBase").attr("readonly", "").val("").css({"background":""});
			$("#minQuantity").attr("readonly", "").val("").css({"background":""});
			$("#maxQuantity").attr("readonly", "").val("").css({"background":""});
		}
		if ($(this).val() == "N") {
			if (!$("#quantity") || $("#quantity").val() == "") {
				showMessage("请输入挂牌数量！");
				$(this).attr("checked", "");
			} else {
				$("#multipleBase").attr("readonly", "readonly")
						.val($("#quantity").val()).css({"background":"none repeat scroll 0 0 #D3D3D3"});
				$("#minQuantity").attr("readonly", "readonly")
						.val($("#quantity").val()).css({"background":"none repeat scroll 0 0 #D3D3D3"});
				$("#maxQuantity").attr("readonly", "readonly")
						.val($("#quantity").val()).css({"background":"none repeat scroll 0 0 #D3D3D3"});
			}
		}
	});
});
function showMessage(message) {
	var op = {
		title : '信息提示',
		drag : true,
		lock : true,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}