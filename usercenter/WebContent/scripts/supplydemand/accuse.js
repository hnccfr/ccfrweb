/**
 * 举报供求信息之前的一些相关检查
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
				alert("该信息已被禁用，无需举报！");
			} else if (msg == "reject") {
				alert("无需举报自己的供求信息！");
			} else if (msg == "overdue") {
				alert("该信息已经下架，无需举报。");
			} else {
				alert("操作失败！");
			}
		}
	});
}