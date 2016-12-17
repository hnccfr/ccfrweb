function joinPro(announcementId){
	var option = {
    		id : "projectListBox",
    		title   : '��Ŀѡ��',
    		drag    : true,
    		lock 	: true,
    		padding : 3,
//    		width   : 660,
//    		height  : 260,
    		yesText : 'ȷ��',
    		noText  : 'ȡ��',
    		yesFn	: function() { 
						var isChecked = false;
						$(".list-table .radio").each(function(i, e) {
							if ($(e).is(":checked")) {
								isChecked = true;
								var proId = $.trim($(e).parent().siblings("td:eq(0)").text());
								var proTitle = $.trim($(e).parent().siblings("td:eq(1)").text());
								if(announcementId){//������Ŀʱ
									if(confirm('ȷ��������' + proTitle + '��Ŀ�ϣ�')){
//									if(art.dialog.confirm('ȷ��������' + proTitle + '��Ŀ�ϣ�', function() {return true;}, function() {return false;}){
										isChecked = true;
										window.location.href = appServer + '/operation/announcement/join.htm'
											+ '?announcementId=' + announcementId + '&projectId=' + proId;
									}else return;
								}else{//��ѯʱ
									$("#projectId").val(proId);
									$("#projectTitle").val(proTitle);
								}
								return true;
							}
						});
						if (isChecked) {
							art.dialog.close();
						} else {
							art.dialog.alert("��ѡ����Ŀ");
						}	
					},
    		noFn	: true
    	};
	
    art.dialog.load(appServer + "/project/dialog.htm", option, false);
    
	$("#projectListQuery").live("click", function() {
//		$("#dialogProjectTitle").val(encodeURIComponent($("#dialogProjectTitle").val()));
//      $("#project").load(appServer + "/project/dialog.htm", $("#projectDialogForm").serializeArray());
        var data = {
		        		title : encodeURIComponent($("#dialogProjectTitle").val()),
		        		code : $("#dialogProjectCode").val(),
		        		status : $("#dialogProjectStatus").val()
        		   }
		$("#project").load(appServer + "/project/dialog.htm", data);
	});
};

function pageReset(){
	$("#pageTitle").val('');
	$("#projectId").val('');
	$("#projectTitle").val('');
	$("#pageStatus").val('');
}