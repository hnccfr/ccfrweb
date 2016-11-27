<#if accessType!="eclp">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
</#if>
<#include "/include/head.ftl"/>
<#import "/include/pager.ftl" as page>

<script>
function getTableForm() {
	return document.getElementById('listForm');
}
function optDelete() {
	if( !selCheckbox( "ids", "<@s.m 'error.checkRecord'/>" ) ){
		return;
	}
	if(!confirm("<@s.m 'global.confirm.delete'/>")) {
		return;
	}
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/delByList.htm";
	jQuery("#queryStr").attr("name","q");
	f.submit();
}
function optDeleteById( id ) {
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/del.htm";
	$("#id").val( id );
	jQuery("#queryStr").attr("name","q");
	f.submit();
}
function optDeleteSeculity(){
	if( !selCheckbox( "ids", "<@s.m 'error.checkRecord'/>" ) ){
		return;
	}
	if(!confirm("<@s.m 'global.confirm.deleteSeculity'/>")) {
		return;
	}
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/delSeculityByList.htm";
	jQuery("#queryStr").attr("name","q");
	f.submit();
}
function optDeleteSeculityById( id ) {
	if(!confirm("<@s.m 'global.confirm.deleteSeculity'/>")) {
		return;
	}
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/delSeculity.htm";
	$("#id").val( id );
	jQuery("#queryStr").attr("name","q");
	f.submit();
}
function optRestore( id ) {
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/restore.htm";
	$("#id").val( id );
	jQuery("#queryStr").attr("name","q");
	f.submit();
}

function batchPass(){//批量审核通过
	if( !selCheckbox( "ids", "<@s.m 'error.checkRecord'/>" ) ){
		return;
	}
	if(!confirm("确认批量通过选中的文章吗?")) {
		return;
	}
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/batchPass.htm";
	jQuery("#queryStr").attr("name","q");
	f.submit();
}

function batchReject(){//批量退回
	if(!selCheckbox( "ids", "<@s.m 'error.checkRecord'/>" )){
		return;
	}
	jQuery("#batchRejectDialog").dialog("open");
}

function batchRejectSubmit(){//批量退回提交
	var checkOpinion = jQuery("#batchCheckOpinion").val();
	checkOpinion = jQuery.trim(checkOpinion);
	if(checkOpinion == ''){
		jQuery("#batchCheckOpinionErr").empty();
		jQuery("#batchCheckOpinionErr").append("意见不能为空!");
		return false;
	}
	jQuery("#batchCheckOpinionFinal").val(checkOpinion);
	jQuery("#batchCheckOpinionFinal").attr("name","checkOpinion");	
	if(!confirm("确认批量退回选中的文章吗?")) {
		return;
	}
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/batchReject.htm";
	jQuery("#queryStr").attr("name","q");
	f.submit();
}

function batchRevocation(){//批量撤销
	if( !selCheckbox( "ids", "<@s.m 'error.checkRecord'/>" ) ){
		return;
	}
	if(!confirm("确认批量撤销选中的文章吗?")) {
		return;
	}
	var f = document.getElementById('listForm');
	f.action="${appServer}/contNoAudit/batchRevocation.htm";
	jQuery("#queryStr").attr("name","q");
	f.submit();
}

jQuery(function() {
	jQuery("#rejectDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 380,
		bgiframe:true,
		position: ["center",50],
		buttons: {
			"关闭": function(){
				jQuery(this).dialog("close");
			},
			"确定": function() {
				rejectSubmit();
			}
		}
	});
	
	jQuery("#batchRejectDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 380,
		bgiframe:true,
		position: ["center",50],
		buttons: {
			"关闭": function(){
				jQuery(this).dialog("close");
			},
			"确定": function() {
				batchRejectSubmit();
			}
		}
	});
	
});
function optReject(id) {
	jQuery("#rejectId").val(id);
	jQuery("#rejectDialog").dialog("open");
}
function rejectSubmit() {
	var checkOpinion = jQuery("#checkOpinion").val();
	checkOpinion = jQuery.trim(checkOpinion);
	if(checkOpinion == ''){
		jQuery("#checkOpinionErr").empty();
		jQuery("#checkOpinionErr").append("意见不能为空!");
		return false;
	}
	jQuery("input[name=checkOpinion]").val(checkOpinion);
	jQuery("#rejectDialog").dialog("close");
	jQuery("#rejectForm").attr("action","${appServer.get('/contNoAudit/reject.htm')}").submit();
}

function add(){
	var channelId=jQuery.trim(jQuery("#channelSwitch").val());
	if(channelId==""){
		alert("请选择栏目");
		return;
	}
	jQuery("#channelId_add").val(channelId);
	jQuery("#formadd").submit();
}
</script>
<div class="main">
	<div class="rhead">
		<div class="rpos">
			<@s.m "global.position"/>: <@s.m "content.function"/> - <@s.m "global.list"/><#if parentChannel??> - ${parentChannel.name!}</#if>
		</div>
		<div class="clear"></div>
	</div>
	<div class="searchBox">
	<form id="formadd" action="${appServer}/contNoAudit/add.htm">
			<input type="hidden" name="channelId" id="channelId_add" value="${query.channelId!}"/>
			<input type="hidden" name="q" value="${query.lieDown()}"/>
		</form>
		<div style="margin-left:30px">
		<form action="${appServer}/contNoAudit/list.htm" method="post" style="padding-top:5px;">
			<@s.m "content.title"/>: <input type="text" name="title" value="${query.title!}" style="width:100px"/>
			<#--
			发布人: <input type="text" name="adminName" value="${query.adminName!}" style="width:70px"/>
			-->			
		    发布时间: <input type="text" id="releaseDateStart" value="<#if query.releaseDateStart??>${query.releaseDateStart}</#if>" name="releaseDateStart" class="Wdate" style="width:100px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
			-<input type="text" id="releaseDateEnd" value="<#if query.releaseDateEnd?? && query.releaseDateEnd?length gte 10>${query.releaseDateEnd?substring(0,10)}</#if>" name="releaseDateEnd"  class="Wdate" style="width:100px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">
			<br/>
			<@s.m "content.status"/>:
			<select name="currentStatus">
				<option value="0">--全部--</option>
				<#if statusList??>
				<#list statusList as status>
					<#if status.code != 3>
						<#if status.code != 5>
						<option value="${status.code}" <#if query.currentStatus?? && query.currentStatus==status.code?string>selected</#if>>${status.description}</option>
						<#else>
						<option value="${status.code}" <#if query.currentStatus?? && query.currentStatus==status.code?string>selected</#if>>已发布</option>
						</#if>
					</#if>
				</#list>
				</#if>
			</select>
			栏目:
			<select name="channelId" id="channelSwitch" style="width:120px;">
		      	<option value="">--全部--</option>
		      	<#if wholeChannelList??>
		      		<#list wholeChannelList as c>
		      			<option value="${c.id}" <#if query.channelId?? && c.id?string == query.channelId>selected="selected"</#if> >
		      				<#if c.level gt 1>
			      				<#list 2..c.level as i>&nbsp;</#list>
			      				>
		      				</#if>
		      				${c.channelName}
		      			</option>
		      		</#list>
		      	</#if>
		     </select>
		     <#--
		     排序条件:
		     <select name="orderCondition">
			     <#list orderCondition as order>
			     	<option value="${order.contAttrName}" <#if query.orderCondition?? && order.contAttrName?string == query.orderCondition>selected="selected"</#if>>${order.message}</option>
			     </#list>
		     </select>
		     排序方式:
		     <select name="orderMethod">
		     	<#list orderMethod as order>
			     	<option value="${order.value}" <#if query.orderMethod?? && order.value?string == query.orderMethod>selected="selected"</#if>>${order.message}</option>
			    </#list>
		     </select>
		     -->
			<#if settlerAgent.access("PermissionEnum.CONT_MANAGE_NOAUDIT")>
			<input class="btn" type="submit" value="<@s.m "global.query"/>"/>
			</#if>
			</form>
		</div>
	</div>

	<div class="tool">
	<#if query.currentStatus?? && query.currentStatus!='4'>
		<#if settlerAgent.access("PermissionEnum.CONT_MANAGE_NOAUDIT")>
			<#if !isCycle >
		    <span><a href="#" hidefocus="true" class="bt_del"    onclick="optDelete();"><@s.m "global.delete"/></a></span>
		    <#else>
		    <span><a href="#" hidefocus="true" class="bt_add"    onclick="optDeleteSeculity();"><@s.m "global.deleteSecurity"/></a></span>
		    </#if>
		 </#if>
	</#if>
		<#if settlerAgent.access("PermissionEnum.CONT_MANAGE_NOAUDIT")>
			<span>
				<a href="#" hidefocus="true" class="bt_add" onclick="add()"><@s.m "global.add"/></a>
			</span>
		</#if>
				<span>
					<a href="#" hidefocus="true" onclick="batchPass()" class="bt_edit">通过</a>
				</span>
				<span>
					<a href="#" hidefocus="true" onclick="batchReject()" class="bt_del">退回</a>
				</span>
	</div>
	<div class="clear"></div>
	<div class="listBox">
	<h5><span>文章列表</span></h5>
	<form id="listForm" name="listForm" action="" method="post" style="padding-top:5px;">
	<@s.formInput "query.currentPage" "" "hidden"/>
	<@s.formInput "query.title" "" "hidden"/>
	<@s.formInput "query.adminName" "" "hidden"/>
	<@s.formInput "query.currentStatus" "" "hidden"/>
	<@s.formInput "query.channelId" "" "hidden"/>
	<@s.formInput "query.releaseDateStart" "" "hidden"/>
	<@s.formInput "query.releaseDateEnd" "" "hidden"/>
	
	<@s.formInput "query.orderCondition" "" "hidden"/>
	<@s.formInput "query.orderMethod" "" "hidden"/>
	
	<input type="hidden" id="id" name="id"/>
	<input type="hidden" id="queryStr" value="${query.lieDown()}"/>
	<input type="hidden" id="batchCheckOpinionFinal" />
    <table width="100%">
      <tr>
        <th width="20px"><input type='checkbox' name='' value='' onclick='listCheckBoxAll("ids",this.checked)'/></th>
        <th width="30px">ID</th>
        <th><@s.m "content.title"/></th>
        <th width="60">发布人</th>
		<#--<th width="70"><@s.m "content.views"/></th>-->
		<th width="70">发布时间</th>
        <th width="50"><@s.m "content.status"/></th><#--<@s.m "content.status.listName"/>-->
        <#-- 编辑中与回收站不显示审核列 -->
        <#if query.currentStatus?? && query.currentStatus!='0' && query.currentStatus!='1' && query.currentStatus!='5' && query.currentStatus!='7'>
        	<th width="60">审核</th>
        </#if>
        <th width="150px"><@s.m "global.operate"/></th>
      </tr>
      <#if query?? && query.items??>
		<#list query.items as cont>
		      <tr  onmouseover="changeTrColor(this)" class="bg" #end><!--#if($velocityCount%2 == 0)-->
		      	<td><input type='checkbox' name='ids' value='${cont.id}'/><#t/></td>
		        <td>${cont.id}</td>
		        <td>
					<#if cont.topLevel gt 0><span style="color:red">[<@s.m "content.topLevel.short"/>${cont.topLevel}]</span></#if>
					<#if cont.getIsRecommendBoolean()><span style="color:red">[<@s.m "content.recommend.short"/>]</span></#if>
					<#if channelList??>
					<#list channelList as channel>
						<#if channel.id == cont.channelId>
						<strong>[${channel.channelName}]</strong>
						</#if>
					</#list>
					</#if>
					<a href="view.htm?id=${cont.id}" target="_blank">
					<#if cont.title?length lt 20>${cont.title}<#else>${cont.title[0..19]}...</#if>
					</a>
					<#--
					<@text_cut s=cont.title?html len=25 append="..."/>
					-->
					<#if cont.checkOpinion??>
					<br/><span style="color:red">${cont.checkOpinion}</span>
					</#if>
		        </td>
		        <td>
					<#if cont.adminName??> ${cont.adminName}<#elseif cont.memberName??>${cont.memberName}</#if>
				</td>
		        <#--
		        <td>
					${cont.views}
				</td>
				-->
				<td><#if cont.releaseDate??>${cont.releaseDate?string("yyyy-MM-dd")}</#if></td>
				<td>
					<#if cont.status==3>
						已发布
					<#elseif cont.status==4>
						回收站
					<#elseif  cont.status==1>
						<#if cont.rejectedInfo()??>
							<span title="退回意见：${cont.rejectedInfo()!}">退回</span>
						<#else>
							<@s.m "content.status.draft"/>
						</#if>
					</#if>
				</td>
				<#-- 编辑中与回收站不显示审核列 -->
				<#if query.currentStatus?? && query.currentStatus!='0' && query.currentStatus!='1' && query.currentStatus!='5' && query.currentStatus!='7'>
					<td>
							<#if cont.hasPassRight()>
								<a href="${appServer.get('/contNoAudit/pass.htm?id=${cont.id}&q=${query.lieDown()}')}" class="pn-opt" onclick="if(!confirm('确认该文章通过审核吗？')) {return false;}">通过</a>
							</#if>
							<#if cont.hasRejectRight()>
								<a href="javascript:void(0);" class="pn-opt" onclick="optReject(${cont.id})">退回</a>
							</#if>
					</td>
				</#if>
				
				<td>
					<a href="view.htm?id=${cont.id}" target="_blank" class="pn-opt"><@s.m "content.opt.view"/></a>
						<#if cont.getOperNormal()>
								 | <a href="edit.htm?id=${cont.id}&q=${query.lieDown()}" class="pn-opt"><@s.m "global.edit"/></a>
								 | <a href="javascript:void(0);" onclick="if(confirm('<@s.m "global.confirm.delete"/>')) {optDeleteById('${cont.id}');}" class="pn-opt"><@s.m "global.delete"/></a>
						<#else>
								| <a href="javascript:void(0);" onclick="optRestore('${cont.id}')" class="pn-opt"><@s.m "contentCycle.recycle"/></a>
								| <a href="javascript:void(0);" onclick="optDeleteSeculityById('${cont.id}')" class="pn-opt"><@s.m "global.deleteSecurity"/></a>
						</#if>
				</td>
		      </tr>
		</#list>
	</#if>
	</table>
	<@page.simple query appServer.get('contNoAudit/list.htm')/>
	</form>
	</div>
	</div>
<!-- 退回dialog -->
<div id="rejectDialog" title="文章退回" style="display:none">
	<p>退回意见:<textarea id="checkOpinion" name="checkOpinion" maxlength="256" cols="60" rows="3"></textarea>
	<p><span style="color:red" id="checkOpinionErr"></span></p>
</div>
<form method="post" id="rejectForm">
<input type="hidden" name="checkOpinion"/>
<input type="hidden" name="q" value="${query.lieDown()}"/>
<input type="hidden" name="id" id="rejectId"/> 
</form>

<!-- 文章批量退回 -->
<div id="batchRejectDialog" title="文章退回" style="display:none">
	<p>退回意见:<textarea id="batchCheckOpinion" maxlength="256" cols="60" rows="3"></textarea>
	<p><span style="color:red" id="batchCheckOpinionErr"></span></p>
</div>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>