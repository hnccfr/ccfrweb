<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="友情链接管理" path="" curPath="友情链接管理">
<#include "/include/head.ftl"/>
<script src="${appServer}/script/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript">
function ajaxUpload(objId) {
	var obj = jQuery("#" + objId);
	if(jQuery("#" + objId).val() == ''){
		alert("请选择文件");
		return ;
	}
	fileId= $(obj).attr("id");
	var appServer = "${appServer}";
	var url = appServer+'/fUp/json.htm';
	var resSys = "${resSys}"
	jQuery.ajaxFileUpload({
		url: url,
        secureuri:false,//一般设置为false
        fileElementId:fileId,//文件上传空间的id属性
        dataType: 'json',//返回值类型 一般设置为json
        success: function (data, status)  //服务器成功响应处理函数
        {
		    if(data.error == 'false'){
		    	alert("上传失败");
		    	alert(data.msg);
		    }else{
		    	alert("上传成功");
		    	$("input[name='logo']").val(data.fileUrl);
		    	$("#preImg").attr("src","${imageServer}${resSys}" + data.fileUrl);
		    }
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
          //  alert(e);
        }
	});
}

var categoryTypeStatus = function() {
	$("#categoryType").html($("select[name='ctgId'] option:selected").attr("name").split(",")[1]);
	if ($("select[name='ctgId'] option:selected").attr("name").split(",")[0] == "1" || $("select[name='ctgId'] option:selected").attr("name").split(",")[0] == "3" ) {
		$("input[name='logo']").addClass("required");
	} else {
		$("input[name='logo']").removeClass("required");
	}
}

$(function() {

	new categoryTypeStatus();
	$("select[name='ctgId']").change(function() {
		new categoryTypeStatus();
	});

	$("#inputForm").validate({
		rules : {
			name : {
				required : true,
				maxlength : 20
			},
			url : {
				required : true,
				maxlength : 200
			},
			remark : {
				maxlength : 20
			},
			priority : {
				required : true,
				maxlength : 3,
				digits:true
			},
			viewCount : {
				maxlength : 10,
				digits:true
			}
		},
		messages : {
			logo : {
				required : "友链为图片类型时此项必填"
			}
		},
		errorPlacement : function(error, element) {
			(element.parent().find("span.error")).replaceWith(error);
		},
		errorElement : "span",
		submitHandler:function(form){
			$('#buttonSave').attr('disabled','disabled');
	        form.submit();
	    }
	});
});

function doClean(){
	jQuery("input[name='logo']").val("");
	jQuery("#preImg").attr("src","");
}
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsFriendlink.function"/> - <@s.m "global.add"/>
 		</div>
		<div class="clear"></div>
	</div>
  	<div class="formBox mt10">
    	<h3><i></i><span>友情链接添加</span></h3>
    	<form action="${appServer.get('/link/add.htm')}" id="inputForm" method="POST">
    		<input type="hidden" name="q" value="<#if q??>${q}</#if>" />
	    	<div class="content">
	      		<table class="c2">
		     		<tr>
			      		<th><@s.m "cmsFriendlink.name"/>：</th>
			      		<td>
			      			<input name="name" type="text" maxlength="20" class="inpt" />
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsFriendlink.domain"/>：</th>
		      			<td>
		      				<input name="url" type="text" maxlength="200" class="inpt" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsFriendlink.enabled"/>：</th>
		      			<td>
				      		<#if isEnableList??>
		          				<#list isEnableList as item>
									<input type="radio" class="radio" name="isEnable" value="${item.code}"  <#if link.isEnable?? && "${link.isEnable}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
					<tr>
				      	<th><@s.m "cmsFriendlink.category"/>：</th>
				      	<td>
				      		<select name="ctgId">
				      			<#if ctgList??>
				      			<#list ctgList as c>
				      				<option value="${c.id}" name="${c.type},${c.typeName}" <#if link.ctgId?? && "${link.ctgId}" == "${c.id}">selected</#if>>
				      				<#if c.parentId?? && c.parentId gt 1>
					      				<#list 2..c.level as i>&nbsp;</#list>
				      				</#if>
				      				${c.name}
				      				</option>
				      			</#list>
				      			</#if>
				      		</select>
				      	</td>
			     	</tr>
			     	<tr>
				      	<th>友链类型：</th>
				      	<td>
				      		<span style="color:black;" id="categoryType"></span>
				      	</td>
			     	</tr>
		     		<tr>
		      			<th><@s.m "cmsFriendlink.logo"/>：</th>
		      			<td>
		      				<input name="logo" type="hidden" value="<#if link.logo??>${link.logo}</#if>" />
		      				<input type="file" name="uploadFile" id="fileUpload"/>
							<input type="button" onclick="ajaxUpload('fileUpload')" value="上传" class="btn" id="dirButton" />
							<input type="button" onclick="doClean()" value="清空" class="btn"/>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		     			<th colspan="2">
			     			<img noresize="noresize"
			     				style="width:150px;height:150px;background-color:#ccc;border:1px solid #333 ;"
			     				alt="预览"
			     				src="<#if link.logo??>${link.logo}</#if>"
			     				id="preImg" />
		     			</th>
		     		</tr>
		     		<tr>
		      			<th>简介：</th>
		      			<td>
		      				<textarea cols="10" rows="3" name="remark" maxlength="20" class="w200"></textarea>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsFriendlink.priority"/>：</th>
		      			<td>
		      				<input name="priority" type="text" maxlength="3" class="inpt" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
			      		<th><@s.m "cmsFriendlink.views"/>：</th>
			      		<td>
			      			<input name="viewCount" type="text" maxlength="10" class="inpt" value="<#if link.viewCount??>${link.viewCount}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
	      		</table>
	   		</div>
    		<div class="form-but">
    			<#if settlerAgent.access("PermissionEnum.LINK_ADD")>
      			<button id="buttonSave" type="button" class="button-s4" onclick="$('#inputForm').submit();">添加</button>
      			</#if>
      			<button type="button" class="button-s4" onclick="window.location.href='${appServer.get("/link/list.htm?q=${q}")}'">返回</button>
    		</div>
    	</form>
  	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>
