function validate() {
	var re = true;
	if ($("#reason").val() == "����������Ϊ�ľ���ԭ��") {
		$("#reason").val("");
	}
	if ($("#reason").val().length >= 340) {
		alert("�벻Ҫ����340����")
		re = false;
	}
	return re;
}

$(function() {
	$("#reason").focus(function() {
		if ($("#reason").val() == "����������Ϊ�ľ���ԭ��") {
			$("#reason").val("");
		}
	});

	$("#reason").blur(function() {
		if ($("#reason").val() == "") {
			$("#reason").val("����������Ϊ�ľ���ԭ��");
		}
	});
});