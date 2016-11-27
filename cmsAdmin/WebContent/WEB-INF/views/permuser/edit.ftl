<#include "/include/head.ftl"/>
<script>
function clickOper(obj, idNum, channelId){
	var sort = jQuery("#sorts_"+idNum);
	if(obj.checked){
		sort.attr("name","sorts");			  
		jQuery.ajax({
			type: "post",
			url: "/permuser/getNextSort.htm",
			data:{"groupId":idNum,"channelId":channelId},
			dataType:"json",
			success:function(data){
				sort.val(data.nextSort);
			},
			error: function(){
				alert("服务器请求忙或已停止，请稍后再试");
			}
		});
		sort.show();
	}else{
		sort.removeAttr("name");
		sort.hide();
	}
}

function doSubmit(){
	var Regx = /^[0-9]*[1-9][0-9]*$/;
	var sorts = jQuery("input[name='sorts']");
	var sort,id,error;
	var flag = true;
	
	for(var i=0;i<sorts.length;i++){
		sort = sorts[i];
		id = sort.id;
		error = jQuery("#err_"+id)
		if(sort.value != '' && Regx.test(sort.value))
			continue;
		else{
			error.empty();
			error.append("必填且必须为正整数");
			flag = false;
		}
	}
	return flag;
}
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: 会员组权限 - <@s.m "global.edit"/>
 		</div>
		<div class="clear"></div>
	</div>
  	<div class="formBox mt10">
    	<h3><i></i><span>会员组权限<@s.m "global.edit"/></span></h3>
    	<form action="${appServer.get('/permuser/edit.htm')}" id="inputForm" onsubmit="return doSubmit();" method="POST">
	    	<div class="content">
	    	<input type="hidden" name="q" value="${q?default("")}"/>
	      	<input type="hidden" name="channelId" value="${channel.id}"/>
	      	<table class="c4" width="100%">
					<tr>
						<th >栏目：</th>
						<td>${channel.channelName}</td>
						<td></td>
					</tr>

					<#if cms2GroupList?size gt 0>
					<tr>
						<th width="80px">投稿权限：</th>
						<td>
							<TABLE>
							<TBODY>
							<#list cms2GroupList as cms2Group>
							<TR>
							<td>
							<input type="checkbox" name="uploadperms" onclick="clickOper(this, ${cms2Group.id}, ${channel.id})" value="${cms2Group.id}" <#if groupUploadList?size gt 0><#list groupUploadList as groupUpload><#if groupUpload.id=cms2Group.id>checked="true"</#if></#list></#if>>${cms2Group.groupName}
							</td>
							<td>
							<#assign i=0/>
							<#assign sort=0/>
							<#if groupUploadList?size gt 0>
								<#list groupUploadList as groupUpload>
									<#if groupUpload.id==cms2Group.id>
										<#assign i=1/>
										<#if groupUpload.sort??>
											<#assign sort=groupUpload.sort/>
										</#if>
										<#break>
									</#if>
								</#list>
							</#if>
							<input type="text" <#if i==1>name="sorts" value="<#if sort != 0>${sort}</#if>"</#if> id="sorts_${cms2Group.id}" maxlength="2" style="
							<#if i==0>display:none;</#if> width:50px;"/>
							<span id="err_sorts_${cms2Group.id}" style="color:red"/>
							</td>
							</TR>
							</#list>
							</TBODY></TABLE>
						</td>
					</tr>
					<#else>
					<tr>
						<th width="80px"></th>
						<td>无用户组</td>
					</tr>
					</#if>
					<tr style="display:none;">
						<th width="80px">查阅权限：</th>
						<td></td>
					</tr>
					<#if cms2GroupList?size gt 0>
					<#list cms2GroupList as cms2Group>

								<tr style="display:none;">
									<th width="80px"></th>
									<td><input type="checkbox" name="viewperms" value="${cms2Group.id}" <#if groupViewList?size gt 0><#list groupViewList as groupView><#if groupView.id=cms2Group.id>checked="true"</#if></#list></#if>>${cms2Group.groupName}</td>
								</tr>

					</#list>
					<#else>
					<tr style="display:none;">
						<th width="80px"></th>
						<td>无用户组</td>
					</tr>
					</#if>
			</table>
	   		</div>
    		<div class="form-but">
      			<input type="submit" class="button-s4" value="<@s.m "global.save"/>"/>
      			<#if channel.parentId??>
      			<input type="button" class="button-s4" value="<@s.m "global.backToList"/>" onclick="window.location.href='${appServer.get("/permuser/list.htm?parentId=${channel.parentId}")}'">
      			<#else>
      				<input type="button" class="button-s4" value="<@s.m "global.backToList"/>" onclick="window.location.href='${appServer.get("/permuser/list.htm")}'">
				</#if>
    		</div>
    	</form>
  	</div>
</div>


<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>