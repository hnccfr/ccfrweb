<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="友情链接类别管理" path="" curPath="友情链接类别管理">
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
					url : "${appServer}/linkctg/ajax/checkCtgNameUnique.htm",
					dataType: "json",
					data : {
						id : function() {
							return $("input[name='id']").val();
						},
						ctgName : function() {
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
					url : "${appServer}/linkctg/ajax/checkCtgCodeUnique.htm",
					dataType: "json",
					data : {
						id : function() {
							return $("input[name='id']").val();
						},
						ctgCode : function() {
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
 			<@s.m "global.position"/>: <@s.m "cmsFriendlinkCtg.function"/> - <@s.m "global.edit"/>
 		</div>
		<div class="clear"></div>
	</div>
  	<div class="formBox mt10">
    	<h3><i></i><span><@s.m "cmsFriendlinkCtg.function"/><@s.m "global.edit"/></span></h3>
    	<form action="${appServer.get('/linkctg/edit.htm')}" id="inputForm" method="POST">
    		<input name="id" type="hidden" value="<#if cms2FlinkCtg.id??>${cms2FlinkCtg.id}</#if>"/>
	    	<input type="hidden" name="q" value="<#if q??>${q}</#if>" />
	    	<div class="content">
	      		<table class="c2">
		     		<tr>
			      		<th><@s.m "cmsFriendlinkCtg.name"/>：</th>
			      		<td>
			      			<input name="name" type="text" maxlength="20" class="inpt" value="<#if cms2FlinkCtg.name??>${cms2FlinkCtg.name}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
		     		<tr>
			      		<th><@s.m "cmsFriendlinkCtg.code"/>：</th>
			      		<td>
			      			<input name="code" type="text" maxlength="20" class="inpt" value="<#if cms2FlinkCtg.code??>${cms2FlinkCtg.code}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
					<tr>
				      	<th>类型：</th>
				      	<td>
		      				<#if flinkTypeList??>
		          				<#list flinkTypeList as item>
									<input type="radio" class="radio" name="type" value="${item.code}"  <#if cms2FlinkCtg.type?? && "${cms2FlinkCtg.type}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
				      	</td>
			     	</tr>
		    		<tr>
		      			<th>是否启用：</th>
		      			<td>
		      				<#if isEnableList??>
		          				<#list isEnableList as item>
									<input type="radio" class="radio" name="isEnable" value="${item.code}"  <#if cms2FlinkCtg.isEnable?? && "${cms2FlinkCtg.isEnable}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsFriendlinkCtg.priority"/>：</th>
		      			<td>
		      				<input name="priority" type="text" maxlength="3" class="inpt" value="<#if cms2FlinkCtg.priority??>${cms2FlinkCtg.priority}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>排序类型：</th>
		      			<td>
		      				<#if sortTypeList??>
		          				<#list sortTypeList as item>
									<input type="radio" class="radio" name="sortType" value="${item.code}" <#if cms2FlinkCtg.sortType?? && "${cms2FlinkCtg.sortType}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>描述：</th>
		      			<td>
		      				<textarea cols="10" rows="3" name="remark" maxlength="20" class="w200"><#if cms2FlinkCtg.remark??>${cms2FlinkCtg.remark}</#if></textarea>
							<span class="error"></span>
		      			</td>
		     		</tr>
	      		</table>
	   		</div>
    		<div class="form-but">
    			<#if settlerAgent.access("PermissionEnum.LINK_CTG_EDIT")>
      			<button id="buttonSave" type="button" class="button-s4" onclick="$('#inputForm').submit();">修改</button>
      			</#if>
      			<button type="button" class="button-s4" onclick="window.location.href='${appServer.get("/linkctg/list.htm?q=${q}")}'">返回</button>
    		</div>
    	</form>
  	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>

