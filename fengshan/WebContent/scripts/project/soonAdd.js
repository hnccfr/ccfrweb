$(document).ready(

function() {
	$("#projectListingQuery").live("click", function() {
		var data = {
			title : $("#chooseTitle").val(),
			code : $("#chooseCode").val(),
			status : $("#chooseStatus").find("option:selected").val(),
			listingEndTimeFrom : $("#li_end_form").val(),
			listingEndTimeTo : $("#li_end_to").val()
		};
		jQuery.ajaxSetup({
					contentType : "application/x-www-form-urlencoded; charset=utf-8"
				})
		$("#projectListChooseAreaId").load(
				appServer + "/project/" + $("#listingType").val()
						+ "er/chooseList.htm", data);
	});

	/**初始化快速挂牌页面时，需要根据参考项目类型的code获得该类型的所有标准规格渲染标准规格列表
	 * add by guowei 2012-3-13 begin **/
	if($("#projectTypeCode").length !=0 && $("#projectTypeCode").val() != ""){
		//alert("i am loading...");
		var code = $("#projectTypeCode").val();
		var stadardId = $("#breedStandardId").val();
		$.ajax( {
				type : "GET",
				cache : false,
				url : prjTypeUrl.projectStandURL,
				dataType : "json",
				data : "projectTypeCode=" + code,
				async : false,
				success : function(projectStandObject) {
					if (projectStandObject && projectStandObject.length > 0) { // 项目类型包含动态属性
						var option;
						$("#breedStandardSelect").empty(); // 清空标准属性下拉列表选项
						$("#breedStandardSelect").append("<option value='0'>请选择</option>");
						for ( var i = 0; i < projectStandObject.length; i++) {
							option = "";
							option = "<option value='"+ projectStandObject[i].id + "'";
							if(projectStandObject[i].id == stadardId){
								option = option + " selected='selected'";
							}
							option = option + ">"+ projectStandObject[i].name + "</option>"
							$("#breedStandardSelect").append(option);
						}

					} else { 
						// 无动态属性
					}
				}
			});
	}
	
});

/**
 * 快速挂牌功能art Dailog实现
 * 
 * @param btnSign
 * @return
 */
function easyAddFn1(btnSign) {
	var option = {
		id : "projectListingChooseBox",
		title : '快速挂牌',
		drag : true,
		lock : true,
		padding : 3,
		width : 700,
		yesText : '确认',
		noText : '取消',
		yesFn : function() {
			var projectId = $("input[name='sqn']:checked").val();
			if (typeof(projectId) == "undefined" || !projectId
					|| projectId == "") {
				art.dialog({
							content : '请选择一个参考项目！',
							lock : true,
							yesFn : true
						});
				return false;
			}
			window.location.href = appServer
					+ "/project/soonAdd.htm?projectId=" + projectId;
		},
		noFn : true
	};
	art.dialog.load(appServer + "/project/" + btnSign + "/chooseList.htm?dd="
					+ new Date().getTime(), option, false);

}

function resetSoonAddCondition(){
	$("#chooseTitle").attr("value","");
	$("#chooseCode").attr("value","");
	$("#chooseStatus").attr("value","");
	$("#li_end_form").attr("value","");
	$("#li_end_to").attr("value","");
}

function clearPic(){
	jQuery("#fileChoose0").attr("value", "");
	jQuery("#picturePath").attr("value", "");
}

function clearPic1(){
	jQuery("#fileChoose1").attr("value", "");
	jQuery("#picturePath1").attr("value", "");
}

function clearPic2(){
	jQuery("#fileChoose2").attr("value", "");
	jQuery("#picturePath2").attr("value", "");
}

function clearPic3(){
	jQuery("#fileChoose3").attr("value", "");
	jQuery("#picturePath3").attr("value", "");
}

function clearPic4(){
	jQuery("#fileChoose4").attr("value", "");
	jQuery("#picturePath4").attr("value", "");
}

function clearFile(){
	jQuery("#attachedFile").attr("value", "");
}
