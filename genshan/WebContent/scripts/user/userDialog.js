/**
 * 
 */

$.ajaxSetup( {
	contentType : "application/x-www-form-urlencoded; charset=utf-8"
})

var accounts = ''; // 选中的用户账号
var isRadio; // 是否是单选 Y：是 N：否
var type; // 取值类型: userAccount,fundAccount
var id; // 欲赋值的标签的id,页面显示使用
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
		title : '会员选择',
		drag : true,
		lock : true,
		padding : 3,
		// width : 620,
		// height : 260,
		yesText : '确认',
		noText : '取消',
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
 * 将选中的用户账号添加到收件人中，当收件人一栏中已经存在收件人则添加新的收件人的时候前面加一个“;”，如果 没有则直接添加选中的收件人
 * 
 * @param account
 * @param id
 *            欲赋值的标签id
 * @return
 */
function addAccount(userAccount, fundAccount) {
	this.accounts = $("#" + id).val().trim();// 获取当前收件人并去除首尾空格
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
