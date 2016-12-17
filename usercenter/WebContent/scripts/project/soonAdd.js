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

	/**��ʼ�����ٹ���ҳ��ʱ����Ҫ���ݲο���Ŀ���͵�code��ø����͵����б�׼�����Ⱦ��׼����б�
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
					if (projectStandObject && projectStandObject.length > 0) { // ��Ŀ���Ͱ�����̬����
						var option;
						$("#breedStandardSelect").empty(); // ��ձ�׼���������б�ѡ��
						$("#breedStandardSelect").append("<option value='0'>��ѡ��</option>");
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
						// �޶�̬����
					}
				}
			});
	}
	
});

/**
 * ���ٹ��ƹ���art Dailogʵ��
 * 
 * @param btnSign
 * @return
 */
function easyAddFn1(btnSign) {
	var option = {
		id : "projectListingChooseBox",
		title : '���ٹ���',
		drag : true,
		lock : true,
		padding : 3,
		width : 700,
		yesText : 'ȷ��',
		noText : 'ȡ��',
		yesFn : function() {
			var projectId = $("input[name='sqn']:checked").val();
			if (typeof(projectId) == "undefined" || !projectId
					|| projectId == "") {
				art.dialog({
							content : '��ѡ��һ���ο���Ŀ��',
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
