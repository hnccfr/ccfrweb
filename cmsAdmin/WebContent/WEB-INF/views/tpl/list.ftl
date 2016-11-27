<#if accessType!="eclp">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
</#if>
<#include "/include/head.ftl"/>
<#import "/include/pager.ftl" as page>
<script src="${appServer}/script/pony.js" type="text/javascript"></script>
<script>
	$(function() {
	 jQuery.validator.addMethod("stringCheck", function(value, element) {
	     return this.optional(element) || /^[\u0391-\uFFE5A-Za-z0-9_]+$/.test(value);
	 }, "只能包括中文字、英文字母、数字和下划线");
		$("#jvForm").validate({
			errorPlacement:function(error,element) {
			if (element.attr("name") == "dirName"){
			error.insertAfter("#dirButton");}
			}
			});
	});
	
	function getTableForm() {
		return document.getElementById('tableForm');
	}
	
	function optDelete() {
		if(Pn.checkedCount('ids')<=0) {
			alert("<@s.m 'error.checkRecord'/>");
			return;
		}
		if(!confirm("<@s.m 'global.confirm.delete'/>")) {
			return;
		}
		var f = getTableForm();
		f.action="delete.htm?dirType=${dirType}&q=${query.lieDown()}";
		f.submit();
	}
	
	function optAdd(){
		var f = document.getElementById('formadd');
		f.submit();
	}
</script>
<div class="main">
<form action="v_add.htm" class="ropt" id="formadd">
	<input type="hidden" value="${dirType}" name="dirType">
	<input type="hidden" name="q" value="${query.lieDown()}"/>
	</form>
<div class="rhead">
	<div class="rpos">当前位置: 模板管理 - 列表</div>
	<div class="clear"></div>
</div>
 <div class="searchBox">
    <h5><span></span></h5>
<form  method="post" id="jvForm">
<input type="hidden" value="/cms/www" name="root">
<table border="0" style="padding-top:3px">
<tbody><tr>
	<td width="60px" valign="top">当前目录: </td>
	<td align="left">${currentPath!}</td>
</tr>

<!--
<tr>
	<td>
		新建目录
	</td>
	<td>
<input type="text" onkeypress="if(event.keyCode==13){this.form.method='post';this.form.action='${appServer}/tpl/o_create_dir.htm?dirType=${dirType}';}" maxlength="20" size="20" stringcheck="true" class="required" name="dirName">
		<input type="submit" onclick="this.form.method='post';this.form.action='${appServer}/tpl/o_create_dir.htm?dirType=${dirType}';" value="新建" class="btn" id="dirButton">
	</td>
</tr>
-->
<tr><td colspan="2"><div id="fsUploadProgress"></div></td></tr>
</tbody></table>
</form>
</div>

<div class="tool"> 
	<#if dirType??&&dirType!="">
    	<span>
		<a onclick="optDelete();" class="bt_add" hidefocus="true" href="#"> 删除</a>
		</span> 
		<span>
		<a onclick="optAdd();" class="bt_add" hidefocus="true" href="#">添加</a>
		</span>
	</#if>
	
  </div>
  <div class="clear"></div>
  
  <div class="listBox">
<h5><span></span></h5>

<form method="post" id="tableForm">
<@s.formInput "query.currentPage" "" "hidden"/>

<!--<input type="hidden" value="" name="pageNo">-->
<table width="100%" cellspacing="1" cellpadding="0" border="0" style="table-layout: fixed;" class="">
<thead class="pn-lthead"><tr>

	<th width="20" style="overflow: hidden;"><input type="checkbox" onclick="Pn.checkbox(&quot;ids&quot;,this.checked)"></th>
	<th width="20" style="overflow: hidden;"> </th>
	<th style="overflow: hidden;">文件名</th>
	<th width="120" style="overflow: hidden;">最后修改时间</th>
	<th width="140" style="overflow: hidden;">操作选项</th></tr></thead>
	<tbody class="pn-ltbody">
	  <#if query?? && query.items??>
		<#list query.items as tpl>
		<tr onmouseover="changeTrColor(this)" <#if tpl_index%2 == 1>class="bg"</#if>>
			<td style="overflow: hidden;"><input type="checkbox" value="${tpl.id}" name="ids"></td>
			<td align="center" style="overflow: hidden;">
				<#if tpl.isDirectory == 1>
					<img src="${appServer}/images/file/folder.gif">
					<#else>
						<img src="${appServer}/images/file/html.gif">
				</#if>
			</td>
			
			<td style="overflow: hidden;">
				<#if tpl.isDirectory == 1>
					<a href="list.htm?dirType=${tpl.id}">${tpl.tplName}</a>
					<#else>
						${tpl.tplName}
				</#if>
			</td>
			
			<td align="left" style="overflow: hidden;">
				<#if tpl.gmtModify??>
					${tpl.gmtModify?string('yyyy-MM-dd')}
				</#if>
			</td>
			<td align="left" style="overflow: hidden;">	
			    <#if tpl.tplDirType>
			    	重命名 | 修改 | 删除
			    	<#else>
			    	 <a class="pn-opt" href="v_rename.htm?dirType=${dirType}&id=${tpl.id}&q=${query.lieDown()}">重命名</a> | 
						<#if tpl.isDirectory == 2>
							<a href="v_edit.htm?dirType=${dirType}&id=${tpl.id}&q=${query.lieDown()}">修改</a> | 
							<#else>
								<a disabled="disabled">修改</a> | 
						</#if>		
					
				<a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="del_single.htm?dirType=${dirType}&id=${tpl.id}&q=${query.lieDown()}">删除</a>
			    </#if>
				
			</td>
		</tr>
		</#list>
		  <#else>
			  <tr class="bg">
			  	<td colspan="5">
			  	暂无数据
			  	</td>
			  </tr>
		  </#if>
</tbody>
</table>
<#if dirType??&&dirType!=""><@page.simple query appServer.get('tpl/list.htm?dirType=${dirType}')/></#if>
</form>
</div>

</div>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>