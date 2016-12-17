function joinPro(announcementId){
	var option = {
    		id : "projectListBox",
    		title   : '项目选择',
    		drag    : true,
    		lock 	: true,
    		padding : 3,
//    		width   : 660,
//    		height  : 260,
    		yesText : '确认',
    		noText  : '取消',
    		yesFn	: function() { 
						var isChecked = false;
						$(".list-table .radio").each(function(i, e) {
							if ($(e).is(":checked")) {
								isChecked = true;
								var proId = $.trim($(e).parent().siblings("td:eq(0)").text());
								var proTitle = $.trim($(e).parent().siblings("td:eq(1)").text());
								if(announcementId){//关联项目时
									if(confirm('确定关联到' + proTitle + '项目上？')){
//									if(art.dialog.confirm('确定关联到' + proTitle + '项目上？', function() {return true;}, function() {return false;}){
										isChecked = true;
										window.location.href = appServer + '/operation/announcement/join.htm'
											+ '?announcementId=' + announcementId + '&projectId=' + proId;
									}else return;
								}else{//查询时
									$("#projectId").val(proId);
									$("#projectTitle").val(proTitle);
								}
								return true;
							}
						});
						if (isChecked) {
							art.dialog.close();
						} else {
							art.dialog.alert("请选择项目");
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