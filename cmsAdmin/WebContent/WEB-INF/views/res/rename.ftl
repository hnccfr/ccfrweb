<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function() {
	$.validator.setDefaults( {
		submitHandler : function(form) {
			if( validatorSelf.cancelSubmit != null && !validatorSelf.cancelSubmit ){
				$('#jvForm').attr('action', 'v_list.do');
				$('#distName').val( "" );
			}
			form.submit();
		}
	} );
	//增加文件名验证	sunjin	2011-11-02
	 jQuery.validator.addMethod("stringCheck", function(value, element) {
	     return this.optional(element) || /^[\u0391-\uFFE5A-Za-z0-9_.]+$/.test(value);
	 }, "只能包括中文字、英文字母、数字、下划线和“.”");
});
$(function(){
	$("#browser").treeview({
		url: "v_tree.do"
	});
});

function checkname(){
	var rootVal = $('#rootDiv').val();
	var newVal = $('#newDiv').val();
	var oldNameVal = $('#oldNameDiv').val();
	var extensionNameVal = $('#extensionNameDiv').val();
	if(extensionNameVal == null)
		extensionNameVal = '';
	if(newVal == null || newVal == ''){
		$('#fileNameError').empty();
		$('#fileNameError').append("&nbsp;&nbsp;名称不能为空");
		fileNameVal[0].focus();
		return false;
	}else{
		if(!/^[\u0391-\uFFE5A-Za-z0-9_]+$/.test(newVal)){
			$('#fileNameError').empty();
			$('#fileNameError').append("&nbsp;&nbsp;只能包括中文字、英文字母、数字、下划线");
			return false;
		}
	}
	$('#jvForm').submit();
	
}
</script>
<body>
<div class="main">

<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>: <@s.m "resource.function"/> - <@s.m "resource.rename"/></div>

	<div class="clear"></div>
</div>
 
 	
<div class="formBox"><h3><i></i><span></span></h3>
<form id="jvForm" action="o_rename.htm" method="post">
<input type="text" style="display:none;">
<div class="content">
<table width="100%" cellspacing="1" cellpadding="2" border="0" class="c4">
<tbody>
	<tr>
		<th ><@s.m "resource.path"/>:</th>
		<td >${root}</td>
	</tr>
	<tr>
		<th ><@s.m "resource.origName"/>:</th>
		<td >${resourceName}</td>
	</tr>

<tr>
<th ><@s.m "resource.newName"/>:</th><td >
<input type="hidden" value="${root}" id="rootDiv">
<input type="hidden" value="${resourceName}" id="oldNameDiv">
<input type="text" style="float:left" size="20" class="required valid" name="fileName" value="${origName!}" id="newDiv" maxlength="20">
<#if extensionName??>
<input type="text" maxlength="20" id="extensionNameDiv" value="${extensionName!}" name="extensionName" class="required valid" size="4">
</#if>
<div style="color:red;float:left;" id="fileNameError">
</div></td></tr>
</tbody></table>
</div>
	<input type="hidden" name="origName" value="${resourceName}"/>
	<input type="hidden" name="root" value="${root}"/>
	

	<div class="form-but"><!-- 表单按钮区 -->
	<input type="button" onclick="return checkname();" value="<@s.m "global.submit"/>" class="button-s4">
		&nbsp;
		<input type="button" onclick="history.back();" value="<@s.m "global.backToList"/>" class="button-s4">
	</div>

</form>
</div>
</div>
</body>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>