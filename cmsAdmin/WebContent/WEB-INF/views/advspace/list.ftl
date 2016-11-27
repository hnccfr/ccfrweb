<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="广告版位管理" path="" curPath="广告版位管理">
<#include "/include/head.ftl"/>
<script>
	function toAddChannelPage(){
		jQuery("#addChannelForm").submit();
	}
	function getTableForm() {
		return document.getElementById('tableForm');
	} 
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsAdvertisingSpace.function"/> - <@s.m "global.list"/>
 		</div>
		<div class="clear"></div>
	</div>

  	<!-- 工具栏 -->
  	<div class="tool">
	  	<span>
	  		<#if settlerAgent.access("PermissionEnum.ADV_SPACE_ADD")>
	  			<a href="${appServer.get('/advspace/add.htm?q=${q}')}" hidefocus="true" class="bt_add" ><@s.m "global.add"/></a>
	  		</#if>
	  	</span>
  	</div>
  	<div class="clear"></div>
  
  	<!-- 列表模块 -->
  	<div class="listBox">
	  	<h5><span>广告版位列表</span></h5>
	  	<form id="tableForm" method="post">
	  	<@s.formInput "query.currentPage" "" "hidden"/>
		  	<table >
				<tr>
					<th width="15%"><@s.m "cmsAdvertisingSpace.name"/></th>
		  			<th width="15%"><@s.m "cmsAdvertisingSpace.code"/></th>
		  			<th width="10%"><@s.m "cmsAdvertisingSpace.category"/></th>
		  			<th width="10%"><@s.m "cmsAdvertisingSpace.enabled"/></th>
		  			<th width="5%"><@s.m "cmsAdvertisingSpace.priority"/></th>
		  			<th width="10%"><@s.m "cmsAdvertisingSpace.width"/></th>
		  			<th width="10%"><@s.m "cmsAdvertisingSpace.height"/></th>
		  			<th width="20%"><@s.m "global.operate"/></th>
			  	</tr>
				<#if query?? && query.items??>
					<#list query.items as item>
				  		<tr onmouseover="changeTrColor(this)">
						  	<td><#if item.name??>${item.name}</#if></td>
						  	<td><#if item.code??>${item.getCode()}</#if></td>
						  	<td><#if item.typeName??>${item.typeName}</#if></td>
						  	<td><#if item.isEnableName??>${item.isEnableName}</#if></td>
						  	<td><#if item.priority??>${item.priority}</#if></td>
						  	<td><#if item.width??>${item.width}</#if></td>
						  	<td><#if item.height??>${item.height}</#if></td>
						  	<td>
						  		<#if settlerAgent.access("PermissionEnum.ADV_SPACE_EDIT")>
						  			<a href="${appServer.get('/advspace/edit.htm?id=${item.id}&q=${q}')}">修改</a>
						  			<#if settlerAgent.access("PermissionEnum.ADV_SPACE_DEL")>|</#if>
						  		</#if>
						  		<#if settlerAgent.access("PermissionEnum.ADV_SPACE_DEL")>
						  			<a href="${appServer.get('/advspace/delete.htm?id=${item.id}&q=${q}')}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" ><@s.m "global.delete"/></a>
						  		</#if>
						  	</td>
				  		</tr>
					</#list>
				<#else>
					<tr><td colspan="8" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
				</#if>
			</table>
			<@page.simple query appServer.get('advspace/list.htm')/>
		</form>
	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>