<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="广告版位管理" path="" curPath="广告版位管理">
<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function() {
	//代码
	$.validator.addMethod("code", function(value, element) {
		return this.optional(element) || /^[A-Za-z0-9]+$/.test(value);
	}, "只允许英文+数字");
	
	$("#inputForm").validate({
		rules : {
			name : {
				required : true,
				maxlength : 20,
				remote : {
					url : "${appServer}/advspace/ajax/checkSpaceNameUnique.htm",
					dataType: "json",
					data : {
						id : function() {
							return $("input[name='id']").val();
						},
						spaceName : function() {
							return $("input[name='name']").val();
						}
					}
				}
			},
			code : {
				required : true,
				maxlength : 20,
				code : true,
				remote : {
					url : "${appServer}/advspace/ajax/checkSpaceCodeUnique.htm",
					dataType: "json",
					data : {
						id : function() {
							return $("input[name='id']").val();
						},
						spaceCode : function() {
							return $("input[name='code']").val();
						}
					}
				}
			},
			priority : {
				required : true,
				maxlength : 3,
				digits:true
			},
			width : {
				maxlength : 4,
				digits:true
			},
			height : {
				maxlength : 4,
				digits:true
			},
			remark : {
				maxlength : 20
			}
		},
		messages : {
			name : {
				remote : "本站点该名称已经存在，请重新输入"
			},
			code: {
				remote : "本站点该代码已经存在，请重新输入"
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
 			<@s.m "global.position"/>: <@s.m "cmsAdvertisingSpace.function"/> - <@s.m "global.edit"/>
 		</div>
		<div class="clear"></div>
	</div>
  	<div class="formBox mt10">
    	<h3><i></i><span>广告版位修改</span></h3>
    	<form action="${appServer.get('/advspace/edit.htm')}" id="inputForm" method="POST">
    		<input type="hidden" name="q" value="<#if q??>${q}</#if>" />
    		<input name="id" type="hidden" value="<#if space.id??>${space.id}</#if>"/>
    		<input name="isParent" type="hidden" value="${space.isParent}"/>
    		<input name="status" type="hidden" value="${space.status}"/>
    		<input name="isDefault" type="hidden" value="${space.isDefault}"/>
	    	<div class="content">
	      		<table class="c2">
		     		<tr>
			      		<th><@s.m "cmsAdvertisingSpace.name"/>：</th>
			      		<td>
			      			<input name="name" type="text" maxlength="20" class="inpt" value="<#if space.name??>${space.name}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertisingSpace.code"/>：</th>
		      			<td>
		      				<input name="code" type="text" maxlength="20" class="inpt" value="<#if space.code??>${space.code}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
		    		<tr>
		      			<th><@s.m "cmsAdvertisingSpace.category"/>：</th>
		      			<td>
							<#if advTypeList??>
		          				<#list advTypeList as item>
									<input type="radio" class="radio" name="type" value="${item.code}" <#if space.type?? && "${space.type}" == "${item.code}">checked</#if>  >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		    		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertisingSpace.priority"/>：</th>
		      			<td>
		      				<input name="priority" type="text" maxlength="3" class="inpt" value="<#if space.priority??>${space.priority}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertisingSpace.enabled"/>：</th>
		      			<td>
		      				<#if isEnableList??>
		          				<#list isEnableList as item>
									<input type="radio" class="radio" name="isEnable" value="${item.code}"  <#if space.isEnable?? && "${space.isEnable}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
				    <tr>
			      		<th><@s.m "cmsAdvertisingSpace.width"/>：</th>
				      	<td>
				      		<input name="width" type="text" maxlength="4" class="inpt" value="<#if space.width??>${space.width}</#if>" />
							<span class="error"></span>
				      	</td>
			     	</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertisingSpace.height"/>：</th>
		      			<td>
		      				<input name="height" type="text" maxlength="4" class="inpt" value="<#if space.height??>${space.height}</#if>" />
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertisingSpace.description"/>：</th>
		      			<td>
		      				<textarea cols="10" rows="3" name="remark" maxlength="20" class="w200"><#if space.remark??>${space.remark}</#if></textarea>
							<span class="error"></span>
		      			</td>
		     		</tr>
	      		</table>
	   		</div>
    		<div class="form-but">
    			<#if settlerAgent.access("PermissionEnum.ADV_SPACE_EDIT")>
      			<button id="buttonSave" type="button" class="button-s4" onclick="$('#inputForm').submit();">修改</button>
      			</#if>
      			<button type="button" class="button-s4" onclick="window.location.href='${appServer.get("/advspace/list.htm?q=${q}")}'">返回</button>
    		</div>
    	</form>
  	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>