var suspensionConfirmText = '注意：<br/>确定停牌后，还没进行交易的项目会停止交易，<br/>已经成交的交易有效， '
				+ '正在进行的交易将停止。<br/>正在进行的报价数据将全部作废，<br/>竞价人的报名资格仍然保留。';
var withdrawalConfirmText = '注意：<br/>确定撤牌后，进行中及未进行的交易都将会终止，<br/>已经成交的交易有效， '
	+ '<br/>正在进行的报价数据将全部作废，<br/>未成交的双方交易保证金将直接解冻，<br/>挂牌方会员等级将减少相应积分。';

var art_title;//停、撤、复 牌公告的标题
var art_url;//停、撤、复 牌提交的url

var editor;
/**
* 停牌公告输入框
*/
function suspension(projectListingId, projectListingtitle, flag){
	if(!(/^\d*$/.test(projectListingId)))return;//项目ID不是数字肯定就是错的
	if(flag == 'suspension')art_title = '停牌公告';
	else if(flag == 'resumption')art_title = '复牌公告';
	else if(flag == 'withdrawal')art_title = '撤牌公告';
	else return;
	art_url = flag;
	
	var ann_title = $("#announcementTitle").val() ||  projectListingtitle + ' 项目' + art_title;
	var ann_content = '<div>'+
		'<span class="red">*</span>公告标题<br/>' 
		+ '<input type="text" id="annTitle" value="' 
		+ ann_title
		+ '" style="width:480px;"/><br/>'
		+ '<span class="red">*</span>公告内容<br/>'
		+ '<textarea style="width:560px;height:260px;" id="annContent" name="annContent">'
		+ $("#announcementContent").val()
		+ '</textarea></div>';
   var op = {
   		id : "suspensionDataBox",
   		title   : art_title,
   		drag    : true,
   		lock	: true,
   		padding : 3,
//   		width   : 450,
//   		height  : 320,
   		content : ann_content,
   		yesText : '提交',
   		noText  : '取消',
   		yesFn	: function(){
	   				return doSuspension($("#annTitle").val(), editor.html(), projectListingId);
				   },
		noFn : true
   	};
   art.dialog(op);
   editor = KindEditor.create('textarea[name="annContent"]');
}

/**
* 提交停牌
*/
function doSuspension(annTitle, annContent, projectListingId) {
	$("#announcementTitle").val(annTitle);
	$("#announcementContent").val(annContent);
	$("#projectId").val(projectListingId);
	if(!annTitle || annTitle.length > 160){
		art.dialog.alert("公告标题 请输入160以内字符");
		return false;
	}
	else if(!annContent){
		art.dialog.alert("公告内容 为必填项");
		return false;
	}
	
	document.suspensionForm.action = appServer + '/project/' + art_url + '.htm';
	
	//如果是停牌\撤牌操作，需先提示确认信息，复牌则直接提交
	if(art_url == 'suspension')suspensionConfirm(suspensionConfirmText);
	else if(art_url == 'withdrawal')suspensionConfirm(withdrawalConfirmText);
	else document.suspensionForm.submit();
	return true;
}

/**
* 停牌前确认
* @param {} jsonData
*/
function suspensionConfirm(confirmText){
	var content = '<span class="red"><font size="4px" weight="bold">'+confirmText+'</font></span>';
    art.dialog.confirm(
    		content,
    		function() {document.suspensionForm.submit();},
    		function() {return true;}
    	);
}

function cleanUrl(){
	art_title = '';
	art_url = '';
	document.suspensionForm.action = '';
}