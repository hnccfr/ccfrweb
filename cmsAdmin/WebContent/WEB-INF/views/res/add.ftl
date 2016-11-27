<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function() {
	$("#jvForm").validate(
	{
	submitHandler:function(form){
			$('#buttonSave').attr('disabled','disabled');
	        form.submit();
	   }
	 });
});
</script>
<script type="text/javascript">
$(function(){
	$("#browser").treeview({
		url: "v_tree.do"
	});
	//Cms.lmenu("lmenu");//add by zhoujb 2011-12-31:  屏蔽在IE6下的js错误
});
</script>

</head>
<body>
<div class="main">


<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>: <@s.m "resource.function"/> - <@s.m "global.add"/></div>
	<form id="formback" class="ropt" action="list.htm">
		<input type="hidden" name="root" value="${root}"/>
	</form>
	<div class="clear"></div>
</div>


<div class="formBox"><h3><i></i><span></span></h3>
<form id="jvForm" action="o_save.htm" method="post">
<div class="content">
<table width="100%" cellspacing="1" cellpadding="2" border="0" class="c5">
<tbody><tr>
<td width="15%" class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>文件名:</td><td width="85%" class="pn-fcontent"><input type="text" size="40" class="required" name="filename" maxlength="20"></td></tr><tr><td class="pn-fbutton" colspan="2">
<textarea style="width:90%;height:350px" name="source"></textarea>
</td></tr>
</tbody></table>
</div>
	<input type="hidden" value="${root}" name="root">
	<div class="form-but"><!-- 表单按钮区 -->
	<input id="buttonSave" type="button" class="button-s4" value="提交" onclick="$('#jvForm').submit();"> &nbsp; <input type="reset" class="button-s4" value="重置">
<input type="button" onclick="$('#formback').submit()" class="button-s4" value="返回列表">	</div>


</form>
</div>

</div>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>