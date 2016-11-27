<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="广告管理" path="" curPath="广告管理">
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
 			<@s.m "global.position"/>: <@s.m "cmsAdvertising.function"/> - <@s.m "global.list"/>
 		</div>
		<div class="clear"></div>
	</div>

	<div class="searchBox">
    	<h5><span>搜索广告</span></h5>
		<form id="searchForm" action="${appServer.get('adv/list.htm')}" method="post" style="padding-top:5px;" >
			&nbsp;&nbsp;&nbsp;&nbsp;
			<@s.m "cmsAdvertising.adspace"/>: 
			<@s.bind "query.spaceId" />
			&nbsp;&nbsp;
			<select name="${s.status.expression}">
				<option value=""><@s.m "global.pleaseSelect"/></option>
				<#if spaceList??>
	          		<#list spaceList as space>
						<option value="${space.id}" <#if s.stringStatusValue?? && "${s.stringStatusValue}" == "${space.id}">selected</#if> >${space.name}</option>
					</#list>
				</#if>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="submit" class="btn" value="<@s.m 'global.query'/>" />
		</form>
	</div>
	<input type="hidden" name="q" value="<#if q??>${q}</#if>" />

  	<!-- 工具栏 -->
  	<div class="tool">
	  	<span>
	  		<#if settlerAgent.access("PermissionEnum.ADV_ADD")>
	  			<a href="${appServer.get('/adv/add.htm?q=${q}')}" hidefocus="true" class="bt_add" ><@s.m "global.add"/></a>
	  		</#if>
	  	</span>
  	</div>
  	<div class="clear"></div>
  
  	<!-- 列表模块 -->
  	<div class="listBox">
	  	<h5><span>广告列表</span></h5>
	  	<form id="tableForm" method="post">
	  	<@s.formInput "query.currentPage" "" "hidden"/>
	  	<@s.formInput "query.spaceId" "" "hidden"/>
		  	<table >
				<tr>
					<th width="15%"><@s.m "cmsAdvertising.name"/></th>
					<th width="15%"><@s.m "cmsAdvertising.adspace"/></th>
		  			<th width="10%"><@s.m "cmsAdvertising.category"/></th>
		  			<th width="10%"><@s.m "cmsAdvertising.enabled"/></th>
		  			<th width="5%"><@s.m "cmsAdvertising.priority"/></th>
		  			<th width="10%"><@s.m "cmsAdvertising.displayCount"/></th>
		  			<th width="10%"><@s.m "cmsAdvertising.clickCount"/></th>
		  			<th width="20%"><@s.m "global.operate"/></th>
			  	</tr>
				<#if query?? && query.items??>
					<#list query.items as item>
				  		<tr onmouseover="changeTrColor(this)">
						  	<td><#if item.name??>${item.name}</#if></td>
						  	<td><#if item.spaceName??>${item.spaceName}</#if></td>
						  	<td><#if item.typeName??>${item.typeName}</#if></td>
						  	<td><#if item.isEnableName??>${item.isEnableName}</#if></td>
						  	<td><#if item.priority??>${item.priority}</#if></td>
						  	<td><#if item.displayCount??>${item.displayCount}</#if></td>
						  	<td><#if item.clickCount??>${item.clickCount}</#if></td>
						  	<td>
						  		<#if settlerAgent.access("PermissionEnum.ADV_EDIT")>
						  			<a href="${appServer.get('/adv/edit.htm?id=${item.id}&q=${q}')}">修改</a>
						  			<#if settlerAgent.access("PermissionEnum.ADV_DEL") || settlerAgent.access("PermissionEnum.ADV_SWITCH")>|</#if>
						  		</#if>
						  		<#if settlerAgent.access("PermissionEnum.ADV_DEL")>
						  			<a href="${appServer.get('/adv/delete.htm?id=${item.id}&q=${q}')}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" ><@s.m "global.delete"/></a>
						  			<#if settlerAgent.access("PermissionEnum.ADV_SWITCH")>|</#if>
						  		</#if>
						  		<#if settlerAgent.access("PermissionEnum.ADV_SWITCH")>
						  			<a href="${appServer.get('/adv/isEnableChange.htm?id=${item.id}&q=${q}')}">${item.isEnbaleOprateName}</a>
						  		</#if>
						  	</td>
				  		</tr>
					</#list>
				<#else>
					<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
				</#if>
			</table>
			<@page.simple query appServer.get('adv/list.htm')/>
		</form>
	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>