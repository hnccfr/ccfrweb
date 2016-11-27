function validate() {
	var re = true;
	if ($("#reason").val() == "请输入您认为的具体原因") {
		$("#reason").val("");
	}
	if ($("#reason").val().length >= 340) {
		alert("请不要超过340个字")
		re = false;
	}
	return re;
}

$(function() {
	$("#reason").focus(function() {
		if ($("#reason").val() == "请输入您认为的具体原因") {
			$("#reason").val("");
		}
	});

	$("#reason").blur(function() {
		if ($("#reason").val() == "") {
			$("#reason").val("请输入您认为的具体原因");
		}
	});
});