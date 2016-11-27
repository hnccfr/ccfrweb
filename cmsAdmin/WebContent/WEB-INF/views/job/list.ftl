<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="实时任务管理" path="" curPath="实时任务管理">
<#include "/include/head.ftl"/>
<script>
$(function() {
	$("#errorLogDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 500,
		height: 200,
		position: ["center",20],
		buttons: {
			"关闭": function() {
				$(this).dialog("close");
			}
		},
		close: function(event, ui) {
		}
	});
});

function showErrorLog(id){
	$.get("showErrorLog.htm",{"id":id},function(s) {
		$("#resultInfo").empty().append(s);
	});
	$('#errorLogDialog').dialog('open');
	return false;
}

	function getTableForm() {
		return document.getElementById('tableForm');
	} 
	
	function recoverErrors(id) {
	var disabled = $("input[id^='recover']");
	for(var i=0;i<disabled.length;i++)
		disabled[i].disabled=true;
	$("#recover"+id).val("正在执行");
	$.getJSON("recoverErrors.htm?id="+id,function(data) {
		if(data.success) {
			alert("<@s.m "global.success"/>");
		} else {
			alert(data.msg);			
		}
		window.location.href="list.htm?q=${q!}"
	});
}
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsJob.function"/> - <@s.m "global.list"/>
 		</div>
		<div class="clear"></div>
	</div>

  	<div class="clear"></div>
  	
  <!-- 工具栏 -->
  	<div class="tool">
	  	<span>
	  			<a href="javascript:location.href=location.href" hidefocus="true" class="bt_add" >刷新</a>
	  	</span>
  	</div>
  	<div class="clear"></div>
  
  	<!-- 列表模块 -->
  	<div class="listBox">
	  	<h5><span>实时任务列表</span></h5>
	  	<form id="tableForm" method="post">
	  	<@s.formInput "query.currentPage" "" "hidden"/>
		  	<table >
				<tr>
					<th width="15%"><@s.m "cmsJob.type"/></th>
					<th width="5%"><@s.m "cmsJob.obj"/></th>
		  			<th width="5%"><@s.m "cmsJob.oper"/></th>
		  			<th width="5%"><@s.m "cmsJob.status"/></th>
		  			<th width="5%"><@s.m "cmsJob.error"/></th>
		  			<th width="15%"><@s.m "cmsJob.createTime"/></th>
		  			<th width="15%"><@s.m "cmsJob.modifyTime"/></th>
		  			<th width="15%"><@s.m "cmsJob.dealTime"/></th>
		  			<th width="20%"><@s.m "global.operate"/></th>
			  	</tr>
				<#if query?? && query.items??>
					<#list query.items as item>
				  		<tr onmouseover="changeTrColor(this)">
						  	<td><#if item.objType??>${EnumStaticType["${item.objType}"]}</#if></td>
						  	<td><#if item.objId??>${item.objId}</#if></td>
						  	<td><#if item.oper??>${EnumStaticOper["${item.oper}"]}</#if></td>
						  	<td><#if item.error??><#if item.error <= 0>等待<#elseif (item.error >= maxError)>失败<#else>进行中 </#if></#if></td>
						  	<td><#if item.error??>${item.error}</#if></td>
						  	<td><#if item.createTime??>${item.createTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
						  	<td><#if item.modifyTime??>${item.modifyTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
						  	<td><#if item.dealTime??>${item.dealTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
						  	<td>
						  		<a href="delete.htm?ids=${item.id}&q=${q!}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" class="pn-opt"><@s.m "global.delete"/></a>
								<#if item.error??>
									<#if (item.error > 0)>
										&nbsp;
										<input id="recover${item.id}" type="button" value="恢复" onclick="recoverErrors(${item.id});"/>
										&nbsp;
										<a href="#" onclick="showErrorLog(${item.id})" class="pn-opt"><@s.m "cmsJob.errorLog"/></a>
									</#if>
								</#if>
						  	</td>
				  		</tr>
					</#list>
				<#else>
					<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
				</#if>
			</table>
			<@page.simple query appServer.get('job/list.htm')/>
		</form>
	</div>
</div>
<div id="errorLogDialog" title="错误信息" style="display:none;">
<div id="resultInfo"/>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>