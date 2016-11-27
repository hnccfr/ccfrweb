var suspensionConfirmText = 'ע�⣺<br/>ȷ��ͣ�ƺ󣬻�û���н��׵���Ŀ��ֹͣ���ף�<br/>�Ѿ��ɽ��Ľ�����Ч�� '
				+ '���ڽ��еĽ��׽�ֹͣ��<br/>���ڽ��еı������ݽ�ȫ�����ϣ�<br/>�����˵ı����ʸ���Ȼ������';
var withdrawalConfirmText = 'ע�⣺<br/>ȷ�����ƺ󣬽����м�δ���еĽ��׶�������ֹ��<br/>�Ѿ��ɽ��Ľ�����Ч�� '
	+ '<br/>���ڽ��еı������ݽ�ȫ�����ϣ�<br/>δ�ɽ���˫�����ױ�֤��ֱ�ӽⶳ��<br/>���Ʒ���Ա�ȼ���������Ӧ���֡�';

var art_title;//ͣ�������� �ƹ���ı���
var art_url;//ͣ�������� ���ύ��url

var editor;
/**
* ͣ�ƹ��������
*/
function suspension(projectListingId, projectListingtitle, flag){
	if(!(/^\d*$/.test(projectListingId)))return;//��ĿID�������ֿ϶����Ǵ��
	if(flag == 'suspension')art_title = 'ͣ�ƹ���';
	else if(flag == 'resumption')art_title = '���ƹ���';
	else if(flag == 'withdrawal')art_title = '���ƹ���';
	else return;
	art_url = flag;
	
	var ann_title = $("#announcementTitle").val() ||  projectListingtitle + ' ��Ŀ' + art_title;
	var ann_content = '<div>'+
		'<span class="red">*</span>�������<br/>' 
		+ '<input type="text" id="annTitle" value="' 
		+ ann_title
		+ '" style="width:480px;"/><br/>'
		+ '<span class="red">*</span>��������<br/>'
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
   		yesText : '�ύ',
   		noText  : 'ȡ��',
   		yesFn	: function(){
	   				return doSuspension($("#annTitle").val(), editor.html(), projectListingId);
				   },
		noFn : true
   	};
   art.dialog(op);
   editor = KindEditor.create('textarea[name="annContent"]');
}

/**
* �ύͣ��
*/
function doSuspension(annTitle, annContent, projectListingId) {
	$("#announcementTitle").val(annTitle);
	$("#announcementContent").val(annContent);
	$("#projectId").val(projectListingId);
	if(!annTitle || annTitle.length > 160){
		art.dialog.alert("������� ������160�����ַ�");
		return false;
	}
	else if(!annContent){
		art.dialog.alert("�������� Ϊ������");
		return false;
	}
	
	document.suspensionForm.action = appServer + '/project/' + art_url + '.htm';
	
	//�����ͣ��\���Ʋ�����������ʾȷ����Ϣ��������ֱ���ύ
	if(art_url == 'suspension')suspensionConfirm(suspensionConfirmText);
	else if(art_url == 'withdrawal')suspensionConfirm(withdrawalConfirmText);
	else document.suspensionForm.submit();
	return true;
}

/**
* ͣ��ǰȷ��
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