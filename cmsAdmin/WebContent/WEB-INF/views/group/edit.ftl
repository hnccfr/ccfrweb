<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="会员组管理" path="" curPath="会员组管理">
<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function() {
	//代码
	$.validator.addMethod("code", function(value, element) {
		return this.optional(element) || /^[A-Za-z0-9]+$/.test(value);
	}, "只允许英文+数字");

	$("#inputForm").validate({
		rules : {
			groupName : {
				required : true,
				maxlength : 20,
				remote : {
					url : "${appServer}/group/ajax/checkGroupNameUnique.htm",
					dataType: "json",
					data : {
						id : function() {
							return $("input[name='id']").val();
						},
						groupName : function() {
							return $("input[name='groupName']").val();
						}
					}
				}
			},
			code : {
				required : true,
				maxlength : 20,
				code : true,
				remote : {
					url : "${appServer}/group/ajax/checkGroupCodeUnique.htm",
					dataType: "json",
					data : {
						id : function() {
							return $("input[name='id']").val();
						},
						code : function() {
							return $("input[name='code']").val();
						}
					}
				}
			},
			priority : {
				required : true,
				maxlength : 9,
				digits:true
			},
			allowPerDay : {
				required : true,
				maxlength : 9,
				digits:true
			},
			allowMaxFile : {
				required : true,
				maxlength : 9,
				digits:true
			},
		},
		messages : {
			groupName : {
				remote : "本站点该名称已经存在，请重新输入"
			},
			code : {
				remote : "本站点该code已经存在，请重新输入"
			}
		},
		errorPlacement : function(error, element) {
			(element.parent().find("span.error")).replaceWith(error);
		},
		errorElement : "span",
		onkeyup : false,
		submitHandler:function(form){
			$('#buttonSave').attr('disabled','disabled');
	        form.submit();
	    }
	});
})
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsGroup.function"/> - <@s.m "global.edit"/>
 		</div>
		<div class="clear"></div>
	</div>
  	<div class="formBox mt10">
    	<h3><i></i><span><@s.m "cmsGroup.function"/><@s.m "global.edit"/></span></h3>
    	<form action="${appServer.get('/group/edit.htm')}" id="inputForm" method="POST">
    		<input name="id" type="hidden" value="<#if cms2Group.id??>${cms2Group.id}</#if>"/>
	    	<div class="content">
	      		<table class="c2">
		     		<tr>
			      		<th><@s.m "cmsGroup.name"/>：</th>
			      		<td>
			      			<input name="groupName" type="text" maxlength="20" class="inpt" value="<#if cms2Group.groupName??>${cms2Group.groupName}</#if>"/>
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
			      	</tr>
			      	<tr>
			      		<th><@s.m "cmsGroup.code"/>：</th>
			      		<td>
			      			<input name="code" type="text" maxlength="20" class="inpt" value="<#if cms2Group.code??>${cms2Group.code}</#if>"/>
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
			      	</tr>
		     		<tr>
			      		<th><@s.m "cmsGroup.priority"/>：</th>
			      		<td>
			      			<input name="priority" type="text" maxlength="20" class="inpt" value="<#if cms2Group.priority??>${cms2Group.priority}</#if>"/>
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
		     		<tr>
			      		<th><@s.m "cmsGroup.allowPerDay"/>：</th>
			      		<td>
			      			<input name="allowPerDay" type="text" maxlength="20" class="inpt" value="<#if cms2Group.allowPerDay??>${cms2Group.allowPerDay}</#if>"/>
		      				<span class="red">*</span>
		      				<span class="pn-fhelp"><@s.m "cmsGroup.allowPerDay.help"/></span>
							<span class="error"></span>
			      		</td>
			      	</tr>
		     		<tr>
			      		<th><@s.m "cmsGroup.allowMaxFile"/>：</th>
				      	<td>
		      				<input name="allowMaxFile" type="text" maxlength="20" class="inpt" value="<#if cms2Group.allowMaxFile??>${cms2Group.allowMaxFile}</#if>"/>
		      				<span class="red">*</span>
		      				<span class="pn-fhelp"><@s.m "cmsGroup.allowMaxFile.help"/></span>
							<span class="error"></span>
							
				      	</td>
		     		</tr>
		     		<!--
		    		<tr>
		      			<th><@s.m "cmsGroup.allowSuffix"/>：</th>
		      			<td>
		      				<input name="allowSuffix"  type="text" maxlength="20" class="inpt" value="<#if cms2Group.allowSuffix??>${cms2Group.allowSuffix}</#if>"/>
		      				<span class="red">*</span>
		      				<span class="pn-fhelp"><@s.m "cmsGroup.allowSuffix.help"/></span>
							<span class="error"></span>
		      			</td>
		     		</tr>-->
		     		<tr>
		      			<th><@s.m "cmsGroup.needCheck"/>：</th>
		      			<td>
		      				<#if groupNeedCheckList??>
		          				<#list groupNeedCheckList as item>
									<input type="radio" class="radio" name="needCheck" value="${item.code}"  <#if cms2Group.needCheck?? && "${cms2Group.needCheck}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		      		</tr>
		     		<tr>
		      			<th><@s.m "cmsGroup.needCaptcha"/>：</th>
		      			<td>
		      				<#if groupNeedCaptchaList??>
		          				<#list groupNeedCaptchaList as item>
									<input type="radio" class="radio" name="needCaptcha" value="${item.code}"  <#if cms2Group.needCaptcha?? && "${cms2Group.needCaptcha}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
	      		</table>
	   		</div>
    		<div class="form-but">
    			<#--<#if settlerAgent.access("PermissionEnum.GROUP_ADD")>-->
      			<button id="buttonSave" type="button" class="button-s4" onclick="$('#inputForm').submit();"><@s.m "global.save"/></button>
      			<#--</#if>-->
      			<button type="button" class="button-s4" onclick="window.location.href='${appServer.get("/group/list.htm")}'"><@s.m "global.backToList"/></button>
    		</div>
    	</form>
  	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>