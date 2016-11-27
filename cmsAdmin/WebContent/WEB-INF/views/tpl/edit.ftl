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
	function ajaxSubmit() {
		$("#jvForm").submit();
	}
	
	 $(function() {
		 $("#jvForm").validate();
		 companyView= $("#viewDialog").dialog({
			autoOpen: false,
			modal: true,
			width: 580,
			bgiframe:true,
			position: ["center",50]
			});
	 })
	 
	 function formBack(){
	 	$('#formback').submit();
	 }

	function tplBak() {
		var url = "${appServer.get('tpl/bak/list.htm?tplId=${tplId}&dirType=${dirType}')}&d="+new Date().getTime();
		$.get(url,function(s) {
			$("#viewWindow").empty();
			$("#viewWindow").append(s);
		});
		$("#viewDialog").dialog("open");
		$("#viewWindow").empty();
	}
	function del_tplBak(id){
		if(!confirm('您确定删除吗？')) {return false;}
		jQuery.ajax({
				type : 'POST',
				async : false,
				url :  "bak/del.htm?tplBakId="+id,
				success : function(data) {
				if(data.error==false){
				    alert("删除失败");
				}else{
					alert("删除成功");
					var url = "${appServer.get('tpl/bak/list.htm?tplId=${tplId}&dirType=${dirType}')}&d="+new Date().getTime();
					$.get(url,function(s) {
						$("#viewWindow").empty().append(s);
					});
					$("#viewDialog").dialog("open");
					$("#viewWindow").empty();
				}
				}
			});
	}
</script>

</head>
<body>
<div class="main">


<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>:  <@s.m "template.function"/> - <@s.m "global.edit"/></div>
	<form id="formback" class="ropt" action="/tpl/list.htm">
		<input type="hidden" name="dirType" value="${dirType}"/>
		<input type="hidden" name="q" value="<#if q??>${q}</#if>"/>
	</form>
	<div class="clear"></div>
</div>
 <div class="formBox"><h3><i></i><span></span></h3>

<form  id="jvForm" action="${appServer.get('/tpl/o_edit.htm')}" method="post">
<div class="content">
<table width="100%" cellspacing="1" cellpadding="2" border="0" class="c5">
<tbody>
<tr>
<td width="15%" class="pn-flabel pn-flabel-h">文件名:</td><td width="85%" class="pn-fcontent">
<input type="text" size="40" class="disabled" readonly="readonly" value="${tpl.tplName}"> <span class="pn-fhelp">按 ctrl+s 保存</span> | <a href="#" onclick="tplBak()">历史记录</a></td></tr>
<tr>

<td class="pn-fbutton" colspan="2">
<textarea onkeydown="if((event.keyCode==115||event.keyCode==83)&amp;&amp;event.ctrlKey){ajaxSubmit();return false;}" maxlength="1232896" style="width:90%;height:350px;" name="source" wrap="off" id="source" class="valid"><#if tpl.cont??>${tpl.cont?html}</#if></textarea>
</td></tr>
<tr>
<td width="15%" class="pn-flabel pn-flabel-h">备注:</td><td width="85%" class="pn-fcontent">
<input type="text" size="40" name="remark"> </td></tr>
</td></tr>
</tbody></table></div>
<input type="hidden" value="${tpl.id}" name="id" id="id">
<input type="hidden" value="${dirType}" name="dirType" id="dirType">
<input type="hidden" name="q" value="<#if q??>${q}</#if>"/>
	<div class="form-but"><!-- 表单按钮区 -->
	<input type="submit" class="button-s4" value="提交"> &nbsp; <input type="reset" class="button-s4" value="重置">
	<input type="button" onclick="formBack()" class="button-s4" id="btnBack" value="返回列表"></div>


</form>
	  <div id="viewDialog" style="display:none;height: 280px;" title="历史修改记录">
		<div id="viewWindow"></div>
	  </div>

</div>

<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>