<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="友情链接类别管理" path="" curPath="友情链接类别管理">
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
	 			<@s.m "global.position"/>: <@s.m "cmsFriendlinkCtg.function"/> - <@s.m "global.list"/>
	 		</div>
			<div class="clear"></div>
		</div>
	
	
	  	<!-- 工具栏 -->
	  	<div class="tool">
		  	<span>
		  		<#if settlerAgent.access("PermissionEnum.LINK_CTG_ADD")>
		  		<a href="${appServer.get('/linkctg/add.htm?q=${q}')}" hidefocus="true" class="bt_add" ><@s.m "global.add"/></a>
		  		</#if>
		  	</span>
	  	</div>
	  	<div class="clear"></div>
	  
	  	<!-- 列表模块 -->
	  	<div class="listBox">
		  	<h5><span>友情链接类别列表</span></h5>
		  	<form id="tableForm" method="post">
		  	<@s.formInput "query.currentPage" "" "hidden"/>
			  	<table >
					<tr>
						<th width="25%"><@s.m "cmsFriendlinkCtg.name"/></th>
						<th width="25%"><@s.m "cmsFriendlinkCtg.code"/></th>
			  			<th width="20%">类型</th>
			  			<th width="10%">是否启用</th>
			  			<th width="20%"><@s.m "global.operate"/></th>
				  	</tr>
					<#if query?? && query.items??>
						<#list query.items as item>
					  		<tr onmouseover="changeTrColor(this)">
							  	<td><#if item.name??>${item.name}</#if></td>
							  	<td><#if item.code??>${item.code}</#if></td>
							  	<td><#if item.typeName??>${item.typeName}</#if></td>
							  	<td><#if item.isEnableName??>${item.isEnableName}</#if></td>
							  	<td>
							  		<#if settlerAgent.access("PermissionEnum.LINK_CTG_EDIT")>
							  			<a href="${appServer.get('/linkctg/edit.htm?id=${item.id}&q=${q}')}">修改</a>
							  			<#if settlerAgent.access("PermissionEnum.LINK_CTG_DEL")>|</#if>
							  		</#if>
							  		<#if settlerAgent.access("PermissionEnum.LINK_CTG_DEL")>
							  			<a href="${appServer.get('/linkctg/delete.htm?id=${item.id}&q=${q}')}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" ><@s.m "global.delete"/></a>
							  		</#if>
							  	</td>
					  		</tr>
						</#list>
					<#else>
						<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
					</#if>
				</table>
				<@page.simple query appServer.get('linkctg/list.htm')/>
			</form>
		</div>
	</div>
	<#include "/include/foot.ftl"/>
	</@noeclp.layout>
