/**
 * �ٱ�������Ϣ֮ǰ��һЩ��ؼ��
 * added by tanhl
 * @param id
 */
function checkAccuse(id) {
	var prjId = id;
	jQuery.ajax( {
		type : 'POST',
		url : appServer + '/home/supplydemand/checkAccuse.htm',
		data : {
			infoId : prjId
		},
		success : function(msg) {
			var reURL = appServer + jQuery("#reURL").val();
			if (msg == "success") {
				window.location.href = reURL;
			} else if (msg == "forbidden") {
				alert("����Ϣ�ѱ����ã�����ٱ���");
			} else if (msg == "reject") {
				alert("����ٱ��Լ��Ĺ�����Ϣ��");
			} else if (msg == "overdue") {
				alert("����Ϣ�Ѿ��¼ܣ�����ٱ���");
			} else {
				alert("����ʧ�ܣ�");
			}
		}
	});
}