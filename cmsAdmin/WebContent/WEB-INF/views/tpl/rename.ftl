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
			fileName : {
				remote : {
					url : "${appServer}/tpl/ajax/checkNameUnique.htm",
					dataType: "json",
					data : {
						dirType : function() {
							return $("input[name='dirType']").val();
						},
						id : function() {
							return $("#id").val();
						},
						filename : function() {
							return $("input[name='fileName']").val();
						}

					}
				}
			}
		},
		messages : {
			fileName : {
				remote : "当前路径下该名称已经存在，请重新输入"
			}
		}
	});
});

function ajaxSubmit() {
	$("#jvForm").submit();
}

</script>
</head>
<body>
<div class="main">

<div class="rhead">
	<form id="formback" class="ropt" action="list.htm">
		<input type="hidden" name="dirType" value="${dirType}"/>
		<input type="hidden" name="q" value="<#if q??>${q}</#if>"/>
	</form>
	<div class="rpos"><@s.m "global.position"/>: <@s.m "template.function"/> - <@s.m "template.rename"/></div>

	<div class="clear"></div>
</div>
 
<div class="formBox"><h3><i></i><span></span></h3>

<form id="jvForm" action="o_rename.htm?dirType=${dirType}&id=${tpl.id}" method="post">
<input type="text" style="display:none;">
<div class="content">
<table width="100%" cellspacing="1" cellpadding="2" border="0" class="c4">
<tbody>
	<tr>
		<th width="" ><@s.m "resource.path"/>:</td><td width="80%">${currentPath}</th>
		<td width=""></td>
	</tr>
	<tr>
		<th width="" ><@s.m "resource.origName"/>:</td><td width="80%" >${tpl.tplName!}
		<#if tpl.isDirectory == 2>
			
		</#if>
		</th>
		<td width="" ></td>
	</tr>

<tr>
<th width="" ><@s.m "resource.newName"/>:</th><td width="" >
<input type="hidden" value="${dirType}" id="dirType">
<input type="hidden" value="${tpl.id}" id="id">
<input type="hidden" name="q" value="<#if q??>${q}</#if>"/>
<input type="text" style="float:left" size="20" class="required valid stringCheck" name="fileName" value="${tpl.tplName!}" id="newDiv" maxlength="20">
		<#if tpl.isDirectory == 2>
			
		</#if>
<div style="color:red;float:left;" id="fileNameError">
</div></td></tr>
</tbody></table>
</div>
	<div class="form-but"><!-- 表单按钮区 -->
		<input type="submit" class="button-s4" value="<@s.m "global.submit"/>">&nbsp;
		<input type="button" onclick="$('#formback').submit()" value="<@s.m "global.backToList"/>" class="button-s4">
	</div>


</form>

</div>
</div>
</body>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>