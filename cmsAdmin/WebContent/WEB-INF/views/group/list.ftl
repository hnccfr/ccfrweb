<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="会员组管理" path="" curPath="会员组管理">
<#include "/include/head.ftl"/>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsGroup.function"/> - <@s.m "global.list"/>
 		</div>
		<div class="clear"></div>
	</div>


  	<!-- 工具栏 -->
  	<div class="tool">
	  	<span>
	  		<a href="${appServer.get('/group/add.htm')}" hidefocus="true" class="bt_add" onclick="optDelete();" ><@s.m "global.add"/></a>
	  	</span>
  	</div>
  	<div class="clear"></div>
  
  	<!-- 列表模块 -->
  	<div class="listBox">
	  	<h5><span>会员组列表</span></h5>
	  	<form id="tableForm" method="post">
		  	<table >
				<tr>
					<th width="15%"><@s.m "cmsGroup.name"/></th>
					<th width="15%"><@s.m "cmsGroup.code"/></th>
		  			<th width="10%"><@s.m "cmsGroup.priority"/></th>
		  			<th width="10%"><@s.m "cmsGroup.allowPerDay"/></th>
		  			<th width="10%"><@s.m "cmsGroup.allowMaxFile"/></th>
		  			<th width="10%"><@s.m "cmsGroup.needCheck"/></th>
		  			<th width="10%"><@s.m "cmsGroup.needCaptcha"/></th>
		  			<th width="20%"><@s.m "global.operate"/></th>
			  	</tr>
				<#if query?? && query.items??>
					<#list query.items as item>
				  		<tr onmouseover="changeTrColor(this)">
						  	<td><#if item.groupName??>${item.groupName}</#if></td>
						  	<td><#if item.code??>${item.code}</#if></td>
						  	<td><#if item.priority??>${item.priority}</#if></td>
						  	<td><#if item.allowPerDay??>${item.allowPerDay}</#if></td>
						  	<td><#if item.allowMaxFile??>${item.allowMaxFile}</#if></td>
						  	<td><#if item.needCheckName??>${item.needCheckName}</#if></td>
						  	<td><#if item.needCaptchaName??>${item.needCaptchaName}</#if></td>
						  	<td>
						  		<a href="${appServer.get('/group/edit.htm?id=${item.id}')}"><@s.m "global.edit"/></a>|
						  		<a href="${appServer.get('/group/delete.htm?id=${item.id}')}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" ><@s.m "global.delete"/></a>
						  	</td>
				  		</tr>
					</#list>
				<#else>
					<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
				</#if>
			</table>
		</form>
		<div class="pages-box" ></div>
	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>