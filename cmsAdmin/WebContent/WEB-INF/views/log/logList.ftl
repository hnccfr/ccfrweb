	<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="操作日志" path="" curPath="操作日志">
	<#include "/include/head.ftl">
	<#import "/include/pager.ftl" as page>
<script type="text/javascript">
function getTableForm() {
	return document.getElementById('tableForm');
}
function checkedCount(name) {
	var batchChecks = document.getElementsByName(name);
	var count = 0;
	for (var i = 0;i < batchChecks.length; i++) {
		if (batchChecks[i].checked) {
			count++;
		}
	}
	return count;
}
function optDelete() {
	if(checkedCount('ids')<=0) {
		alert("<@s.m 'error.checkRecord'/>");
		return;
	}
	if(!confirm("<@s.m 'global.confirm.delete'/>")) {
		return;
	}
	var f = getTableForm();
	f.action="${appServer.get('log/delSingle.htm')}";
	f.submit();
}

//未选提示任何查询站点时，提示将默认搜所有有权限的站点 zhuhao 2013-1-5
function optSearch() {
	//if(checkedCount('siteIds')<=0) {
	//	if(!confirm("<@s.m 'cmsLog.sitecheck'/>")) {
	//		return;
	//	}
	//}
	var f = document.getElementById('searchForm');
	f.submit();
}

//全选所有有权限站点按钮 zhuhao 2013-1-5
//function selectAll() {
//	var s = document.getElementsByName('siteIds');
//	var g = document.getElementById('siteIdAll');
//	if(g.checked==true){
//		for(var i=0;i<s.length;i++){
//				s[i].checked=true;
//		}
//	}else{
//		for(var i=0;i<s.length;i++){
//			s[i].checked=false;
//		}
//	}
//}

function deleteSingle(id){
	var s = document.getElementsByName('ids');
	for(var i=0;i<s.length;i++){
		if(s[i].value==id){
			s[i].checked=true;
			break;
		}
	}
	var f = getTableForm();
	f.action="${appServer.get('log/delSingle.htm')}";
	f.submit();
}

function checkAll(name, checked) {
	$("input[type=checkbox][name=" + name + "]").each(function() {
		$(this).attr("checked", checked);
	});
}
</script>
		<div class="main">
		<div class="rhead">
			<div class="rpos"><@s.m "global.position"/>: <@s.m "cmsLog.function.operating"/> - <@s.m "global.list"/></div>
			<form class="ropt" action="${appServer.get('log/delBatch.htm')}" method="post">
			<span><@s.m "cmsLog.deleteBatch"/>: </span>
			<#--增加站点选项
				<select name="deletesiteId">
						<option  value=""><@s.m "cmsLog.deleteallsite"/></option>
					<#list siteList as sitelist_item>
						<option <#if deletesiteId??&deletesiteId==sitelist_item.id> selected</#if> value="${sitelist_item.id}">${sitelist_item.name}</option>
					</#list>
				</select>-->
				<select name="days">
					<#--<#list timeMap?keys as key>
						<option <#if days?default("0")==key> selected</#if> value="${key}">${timeMap[key]}</option>
					</#list>-->
					<option <#if days?default("0")=="0"> selected</#if> value="0">所有日志</option>
					<option <#if days?default("0")=="7"> selected</#if> value="7">一周内日志</option>
					<option <#if days?default("0")=="30"> selected</#if> value="30">一月内日志</option>
					<option <#if days?default("0")=="90"> selected</#if> value="90">一季内日志</option>
					<option <#if days?default("0")=="365"> selected</#if> value="365">一年内日志</option>
				</select>
				<input type="submit" class="btn" value="<@s.m "global.submit"/>"/>
			</form>
			<div class="clear"></div>
		</div>

		 <div class="searchBox">
		    <h5><span>搜索后台操作日志</span></h5>
		<form id="searchForm" action="${appServer.get('log/list.htm')}" method="post" style="padding-top:5px;" >
			<table>
		<tr>
			<th><@s.m "cmsLog.user"/>:</th>
			<td><@s.bind "query.userName" />
			&nbsp;&nbsp;<input type="text" name="${s.status.expression}" value="${s.stringStatusValue}" style="width:100px" maxlength="30" /></td>
			<th><@s.m "cmsLog.title"/>:</th>
			<td><@s.bind "query.title" />
			&nbsp;&nbsp; <input type="text" name="${s.status.expression}" value="${s.stringStatusValue}" style="width:150px" maxlength="200" /></td>
			<th><@s.m "cmsLog.ip"/>:</th>
			<td><@s.bind "query.ip" />
			&nbsp;&nbsp;<input type="text" name="${s.status.expression}" value="${s.stringStatusValue}" style="width:70px" maxlength="15" /></td>
		</tr>
		<tr>
			<th>开始时间:</th>
			<td><@s.bind "query.startTime" />
			 <input type="text" id="${s.status.expression}" <#if s.stringStatusValue?exists>value="${s.stringStatusValue}"</#if> name="${s.status.expression}" class="Wdate" style="width:150px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
			<th>结束时间:</th>
			<td><@s.bind "query.endTime" />
			 <input type="text" id="${s.status.expression}" name="${s.status.expression}" <#if s.stringStatusValue?exists>value="${s.stringStatusValue}"</#if> class="Wdate" style="width:150px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"></td>
			<th></th><td><input type="button" class="btn" value="<@s.m "global.query"/>" onclick="optSearch()"/></td>
		</tr>
		</table>
			<#--<@p.checkboxlist  colspan="2" label="cmsLog.site" name="siteIds" valueList=selectedSiteIds list=siteList listKey="id" listValue="name"/><@p.tr/>
			<br/>-->
			<#--增加站点选项-->
			<#--&nbsp;&nbsp;&nbsp;&nbsp;<table style="margin:0px 25px 0px"><tr><td><@s.m "cmsLog.site"/><input type="checkbox" id="siteIdAll" onchange="selectAll()"/>:
			<#list siteList as sitelist_item>
			&nbsp;&nbsp;<input type="checkbox" name="siteIds" value="${sitelist_item.id}" <#list selectedSiteIds as selectedSiteId><#if selectedSiteId=sitelist_item.id>  checked="checked"</#if></#list>>
					${sitelist_item.name}
			</#list></td><td>
			&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="btn" value="<@s.m "global.query"/>" onclick="optSearch()"/></td></tr></table>-->
		</form></div>

		<div class="tool">
		    <span>
			<a href="#" hidefocus="true" class="bt_add" onclick="optDelete();" ><@s.m "global.delete"/></a>
		</span>
		<!--删除演示代码	sunjin	20130822
		<span>
			<a href="${appServer.get("/log/addLog.htm?q=")}${query.lieDown()}" hidefocus="true" class="bt_del">去另一個地方</a>
		</span>
		-->
		  </div>
		  <div class="clear"></div>

		    <div class="listBox">
		<h5><span></span></h5>
		<form id="tableForm" method="post">
		<@s.formInput "query.currentPage" "" "hidden"/>
		<@s.formInput "query.userName" "" "hidden"/>
		<@s.formInput "query.title" "" "hidden"/>
		<@s.formInput "query.ip" "" "hidden"/>
		<@s.formInput "query.startTime" "" "hidden"/>
		<@s.formInput "query.endTime" "" "hidden"/>
		<#--<#list selectedSiteIds as selectedSiteId>
					<input type="hidden" name="siteIds" value="${selectedSiteId!}"/>
		</#list>-->

		<table class="pn-ltable" style="table-layout: fixed;" width="100%" cellspacing="1" cellpadding="0" border="0">
			<tr>
				<th width="20"><input type='checkbox' onclick='checkAll("ids",this.checked)'/></th>
				<th width="30">ID</th>
				<th align="left" width="80"><@s.m"cmsLog.user"/></th>
				<th align="left" width="120"><@s.m "cmsLog.time"/></th>
				<th align="left" width="120"><@s.m "cmsLog.ip"/></th>
				<th align="left" width="120"><@s.m "cmsLog.title"/></th>
				<th><@s.m "cmsLog.content"/></th>
				<th width="60"><@s.m "global.operate"/></th>
			</tr>
		<#if (query.items?exists) && (query.items?size > 0)>
			<#list query.items as item>
			<tr onmouseover="changeTrColor(this)">
				<td><input type='checkbox' name='ids' value='${item.id}'/></td>
				<td>${item.id}</td>
				<td><#if item.userName?exists>${item.userName}<#else>该用户已删除</#if></td>
				<td>${item.logTime?string("yyyy-MM-dd HH:mm:ss")}</td>
				<td>${item.ip!}</td>
				<td>${item.title}</td>
				<td>${item.content!?html}</td>
				<td><a href="#" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}else{deleteSingle('${item.id}')}" class="pn-opt"><@s.m "global.delete"/></a></td>
			</tr>
			</#list>
		<#else>
			<tr><td colspan="7" class="pn-fhelp"><@s.m "global.noRecord"/></td></tr>
		</#if>
		</table>
		<@page.simple query appServer.get('log/list.htm')/>
		</div>
		</form>
		</div>
		</div>
		<#include "/include/alert_message.ftl"/>
		<#include "/include/foot.ftl">
</@noeclp.layout>
