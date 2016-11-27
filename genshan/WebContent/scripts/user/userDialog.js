/**
 * 
 */

$.ajaxSetup( {
	contentType : "application/x-www-form-urlencoded; charset=utf-8"
})

var accounts = ''; // ѡ�е��û��˺�
var isRadio; // �Ƿ��ǵ�ѡ Y���� N����
var type; // ȡֵ����: userAccount,fundAccount
var id; // ����ֵ�ı�ǩ��id,ҳ����ʾʹ��
var roleName; //
function chooseUsers(id, type, isRadio, roleName) {
	if (typeof (roleName) == "undefined" || !roleName) {
		this.roleName = "";
	}
	this.id = id;
	this.type = type;
	this.isRadio = isRadio;
	this.roleName = roleName;
	var userRole = roleName;
	var option = {
		id : "projectListBox",
		title : '��Աѡ��',
		drag : true,
		lock : true,
		padding : 3,
		// width : 620,
		// height : 260,
		yesText : 'ȷ��',
		noText : 'ȡ��',
		yesFn : function() {
			$("#" + id).attr("value", accounts);
		},
		noFn : true
	// initFn :function(){
	// if(isRadio == '1'){
	// $("input:checkbox").css("display","block");
	// }else if(isRadio == '0'){
	// $("input:radio").css("display","block");
	// }
	// }
	};
	art.dialog.load(appServer + "/user/dialog.htm?isRadio=" + this.isRadio
			+ "&roleName=" + roleName, option, false);

	$("#userListQuery").live(
			"click",
			function() {
				$("#user").load(appServer + "/user/dialog.htm",
						$("#userDialogForm").serializeArray());
			});

}

/**
 * ��ѡ�е��û��˺���ӵ��ռ����У����ռ���һ�����Ѿ������ռ���������µ��ռ��˵�ʱ��ǰ���һ����;������� û����ֱ�����ѡ�е��ռ���
 * 
 * @param account
 * @param id
 *            ����ֵ�ı�ǩid
 * @return
 */
function addAccount(userAccount, fundAccount) {
	this.accounts = $("#" + id).val().trim();// ��ȡ��ǰ�ռ��˲�ȥ����β�ո�
	if (this.type == 'fundAccount') {
		if (isRadio == 'N') {
			if (accounts != '') {
				accounts = accounts + ";" + fundAccount;
			} else {
				accounts = fundAccount;
			}
		} else if (isRadio == 'Y') {
			accounts = fundAccount;
		}
	} else if (this.type == 'userAccount') {
		if (isRadio == 'N') {
			if (accounts != '') {
				if (roleName == "reviewer") {
					accounts = accounts + "," + userAccount;
				} else {
					accounts = accounts + ";" + userAccount;
				}
			} else {
				accounts = userAccount;
			}
			$("#" + id).attr("value",accounts);
		} else if (isRadio == 'Y') {
			accounts = userAccount;
		}
	}
}
