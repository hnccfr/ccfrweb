<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="友情链接管理" path="" curPath="友情链接管理">
	<#include "/include/head.ftl"/>
	<script>
		function toAddChannelPage(){
			jQuery("#addChannelForm").submit();
		}
		function getTableForm() {
			return document.getElementById('listForm');
		} 
	</script>
	<div class="main">
		<div class="rhead">
			<!-- 当前位置 -->
	 		<div class="rpos">
	 			<@s.m "global.position"/>: <@s.m "cmsFriendlink.function"/> - <@s.m "global.list"/>
	 		</div>
			<div class="clear"></div>
		</div>
	
		<div class="searchBox">
	    	<h5><span>搜索友情链接</span></h5>
			<form id="searchForm" action="${appServer.get('link/list.htm')}" method="post" style="padding-top:5px;" >
				&nbsp;&nbsp;&nbsp;&nbsp;
				<@s.m "cmsFriendlink.category"/>: 
				<@s.bind "query.ctgId" />
				&nbsp;&nbsp;
				<select name="${s.status.expression}">
					<option value=""><@s.m "global.pleaseSelect"/></option>
					<#if ctgList??>
		          		<#list ctgList as ctg>
							<option value="${ctg.id}" <#if s.stringStatusValue?? && "${s.stringStatusValue}" == "${ctg.id}">selected</#if> >${ctg.name}</option>
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
		  		<#if settlerAgent.access("PermissionEnum.LINK_ADD")>
		  			<a href="${appServer.get('/link/add.htm?q=${q}')}" hidefocus="true" class="bt_add" ><@s.m "global.add"/></a>
		  		</#if>
		  	</span>
	  	</div>
	  	<div class="clear"></div>
	  
	  	<!-- 列表模块 -->
	  	<div class="listBox">
		  	<h5><span>友情链接列表</span></h5>
		  	<form id="listForm" method="post">
		  	<@s.formInput "query.currentPage" "" "hidden"/>
			  	<table >
					<tr>
						<th width="15%"><@s.m "cmsFriendlink.name"/></th>
						<th width="15%"><@s.m "cmsFriendlink.domain"/></th>
			  			<th width="10%"><@s.m "cmsFriendlink.logo"/></th>
			  			<th width="10%"><@s.m "cmsFriendlink.enabled"/></th>
			  			<th width="15%"><@s.m "cmsFriendlink.priority"/></th>
			  			<th width="15%"><@s.m "cmsFriendlink.views"/></th>
			  			<th width="20%"><@s.m "global.operate"/></th>
				  	</tr>
					<#if query?? && query.items??>
						<#list query.items as item>
					  		<tr onmouseover="changeTrColor(this)">
							  	<td style="word-break:break-all"><#if item.name??>${item.name}</#if></td>
							  	<td style="word-break:break-all"><#if item.url??>${item.url}</#if></td>
							  	<td><img style="width:200px;height:100px" src="<#if item.logoAbsolute??>${item.logoAbsolute}</#if>" /></td>
							  	<td><#if item.isEnableName??>${item.isEnableName}</#if></td>
							  	<td><#if item.priority??>${item.priority}</#if></td>
							  	<td><#if item.viewCount??>${item.viewCount}</#if></td>
							  	<td>
							  		<#if settlerAgent.access("PermissionEnum.LINK_EDIT")>
							  			<a href="${appServer.get('/link/edit.htm?id=${item.id}&q=${q}')}">修改</a>
							  			<#if settlerAgent.access("PermissionEnum.LINK_DEL") || settlerAgent.access("PermissionEnum.LINK_SWITCH")>|</#if>
							  		</#if>
							  		<#if settlerAgent.access("PermissionEnum.LINK_DEL")>
							  			<a href="${appServer.get('/link/delete.htm?id=${item.id}&q=${q}')}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" ><@s.m "global.delete"/></a>
							  			<#if settlerAgent.access("PermissionEnum.LINK_SWITCH")>|</#if>
							  		</#if>
							  		<#if settlerAgent.access("PermissionEnum.LINK_SWITCH")>
							  			<a href="${appServer.get('/link/isEnableChange.htm?id=${item.id}&q=${q}')}">${item.isEnbaleOprateName}</a>
							  		</#if>
							  	</td>
					  		</tr>
						</#list>
					<#else>
						<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
					</#if>
				</table>
				<@page.simple query appServer.get('link/list.htm')/>
			</form>
			
		</div>
	</div>
	<#include "/include/foot.ftl"/>
	</@noeclp.layout>