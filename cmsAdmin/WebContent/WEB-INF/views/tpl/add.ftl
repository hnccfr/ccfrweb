<#if accessType!="eclp">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>&#23425;&#27874;&#33322;&#36816;&#35746;&#33329;&#24179;&#21488;-&#28023;&#36816;&#35746;&#33329;,&#28023;&#36816;&#36153;&#26597;&#35810;,&#22312;&#32447;&#35746;&#33329;&#20132;&#26131;&#24179;&#21488;<#if title??>-${title}</#if></title>
	<link href="${appServer.get('/css/nbhy/common.css')}" rel="stylesheet" />
	<script type="text/javascript" src="${appServer.get('script/jquery.js')}"></script>
</head>
</#if>
<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function() {
	$("#jvForm").validate({
		rules : {
			filename : {
				remote : {
					url : "${appServer}/tpl/ajax/checkNameUnique.htm",
					dataType: "json",
					data : {
						dirType : function() {
							return $("input[name='dirType']").val();
						},
						filename : function() {
							return $("input[name='filename']").val();
						}
					}
				}
			}
		},
		messages : {
			filename : {
				remote : "当前路径下该名称已经存在，请重新输入"
			}
		}
	});
});

function ajaxSubmit() {
	$("#jvForm").submit();
}
</script>
<script type="text/javascript">
</script>
<body>
<div class="main">


<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>: <@s.m "template.function"/> - <@s.m "global.add"/></div>
	<form id="formback" class="ropt" action="list.htm">
		<input type="hidden" value="${dirType}" name="dirType">
		<input type="hidden" name="q" value="<#if q??>${q}</#if>"/>
	</form>
	<div class="clear"></div>
</div>


<div class="formBox"><h3><i></i><span></span></h3>
<form id="jvForm" action="o_save.htm" method="post">
   <div class="content">
<table width="100%" cellspacing="1" cellpadding="2" border="0" class="c5">
<tbody>

	<tr>
		<td width="15%" class="pn-flabel pn-flabel-h"><span class="pn-frequired">*</span>文件名:</td>
		<td width="85%" class="pn-fcontent"><input type="text" size="40" class="required stringCheck" name="filename" maxlength="20"> <span class="pn-fhelp">按 ctrl+s 保存</span></td>
	</tr>
	
	<tr>
			<td class="pn-fbutton" colspan="2">
				<textarea onkeydown="if((event.keyCode==115||event.keyCode==83)&amp;&amp;event.ctrlKey){ajaxSubmit();return false;}" maxlength="1232896" style="width:90%;height:350px" name="source" wrap="off"></textarea>
			</td>
	</tr>
	</tbody>
</table>
	</div>
	<input type="hidden" name="q" value="<#if q??>${q}</#if>"/>
			<input type="hidden" value="<#if currentPath??>${currentPath}</#if>" name="currentPath"/>
			<input type="hidden" value="<#if dirType??>${dirType}</#if>" name="dirType"/><div class="form-but"><!-- 表单按钮区 -->
			<input type="submit" class="button-s4" value="提交"> &nbsp; <input type="reset" class="button-s4" value="重置">
		<input type="button" onclick="$('#formback').submit()" class="button-s4" value="返回列表">	</div>
		


</form>
</div>

</div>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>