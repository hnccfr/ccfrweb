$(function(){
	/** �µ�����������صĸ��ģ�ѡ�����ۡ����µ�����������µ�������С�µ����͹�����������һ��* */
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
				showMessage("���������������");
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
		title : '��Ϣ��ʾ',
		drag : true,
		lock : true,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}