<#import "/include/pager.ftl" as page>
<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="定时任务管理" path="" curPath="定时任务管理">
<#include "/include/head.ftl"/>
<script>
	function getTableForm() {
		return document.getElementById('tableForm');
	} 
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsJobTiming.function"/> - <@s.m "global.list"/>
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
					<th width="10%"><@s.m "cmsJobTiming.type"/></th>
					<th width="10%"><@s.m "cmsJobTiming.obj"/></th>
		  			<th width="10%"><@s.m "cmsJobTiming.objOper"/></th>
		  			<th width="20%"><@s.m "cmsJobTiming.createTime"/></th>
		  			<th width="20%"><@s.m "cmsJobTiming.modifyTime"/></th>
		  			<th width="20%"><@s.m "cmsJobTiming.exeTime"/></th>
		  			<th width="10%"><@s.m "global.operate"/></th>
			  	</tr>
				<#if query?? && query.items??>
					<#list query.items as item>
				  		<tr onmouseover="changeTrColor(this)">
						  	<td><#if item.objType??>${EnumJobTimingObj["${item.objType}"]}</#if></td>
						  	<td><#if item.objId??>${item.objId}</#if></td>
						  	<td><#if item.objOper??>${EnumJobTimingType["${item.objOper}"]}</#if></td>
						  	<td><#if item.createTime??>${item.createTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
						  	<td><#if item.modifyTime??>${item.modifyTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
						  	<td><#if item.exeTime??>${item.exeTime?string('yyyy-MM-dd HH:mm:ss')}</#if></td>
						  	<td>
						  		
						  	</td>
				  		</tr>
					</#list>
				<#else>
					<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
				</#if>
			</table>
			<@page.simple query appServer.get('jobtiming/list.htm')/>
		</form>
	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>