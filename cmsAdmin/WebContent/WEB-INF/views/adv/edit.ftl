<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout title="广告管理" path="" curPath="广告管理">
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
		    	$("input[name='image']").val(data.fileUrl);
		    	$("#preImg").attr("src", "${imageServer}${resSys}" + data.fileUrl);
		    }
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
          //  alert(e);
        }
	});
}

var advSpaceStatus = function() {
	$("#spaceType").html($("select[name='spaceId'] option:selected").attr("name").split(",")[1]);
	if ($("select[name='spaceId'] option:selected").attr("name").split(",")[0] == "1") {
		$("#attachRes").show();
		$("#attachResView").show();
		$("input[name='image']").addClass("required");
		$("#preImgDiv").show();
		$("#typeNameDiv").html("图片：");
	}else if($("select[name='spaceId'] option:selected").attr("name").split(",")[0] == "3"){
		$("#attachRes").show();
		$("#attachResView").show();
		$("input[name='image']").addClass("required");
		$("#preImgDiv").hide();
		$("#typeNameDiv").html("flash：");
	}else if($("select[name='spaceId'] option:selected").attr("name").split(",")[0] == "4"){
		$("#attachRes").show();
		$("#attachResView").show();
		$("input[name='image']").addClass("required");
		$("#preImgDiv").hide();
		$("#typeNameDiv").html("多媒体：");
	}else if($("select[name='spaceId'] option:selected").attr("name").split(",")[0] == "5"){
		$("#attachRes").show();
		$("#attachResView").show();
		$("input[name='image']").addClass("required");
		$("#preImgDiv").hide();
		$("#typeNameDiv").html("代码：");
	}else {
		$("input[name='image']").removeClass("required");
		$("#attachRes").hide();
		$("#attachResView").hide();
	}
}

$(function() {

	new advSpaceStatus();
	$("select[name='spaceId']").change(function() {
		new advSpaceStatus();
	});

	$.validator.addMethod("endTime", function(value, element) {
		var startTime = $.trim($("input[name='startTime']").val());	
		if($.trim(value) != "" && startTime != ""){
			return startTime < $.trim(value);
		}else{
			return true;
		}
	}, "结束时间必须大于开始时间");

	$("#inputForm").validate({
		rules : {
			name : {
				required : true,
				maxlength : 20
			},
			title : {
				maxlength : 120
			},
			priority : {
				required : true,
				maxlength : 3,
				digits:true
			},
			link : {
				required : true,
				maxlength : 200
			},
			endTime : {
				endTime : true
			},
			width : {
				maxlength : 4,
				digits:true
			},
			height : {
				maxlength : 4,
				digits:true
			}
		},
		messages : {
			image : {
				required : "当前版位类型此项必填"
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
})
</script>
<div class="main">
	<div class="rhead">
		<!-- 当前位置 -->
 		<div class="rpos">
 			<@s.m "global.position"/>: <@s.m "cmsAdvertising.function"/> - <@s.m "global.edit"/>
 		</div>
		<div class="clear"></div>
	</div>
  	<div class="formBox mt10">
    	<h3><i></i><span>广告修改</span></h3>
    	<form action="${appServer.get('/adv/edit.htm')}" id="inputForm" method="POST">
    		<input type="hidden" name="q" value="<#if q??>${q}</#if>" />
    		<input name="id" type="hidden" value="<#if adv.id??>${adv.id}</#if>"/>
	    	<div class="content">
	      		<table class="c2">
					<tr>
				      	<th><@s.m "cmsAdvertising.adspace"/>：</th>
				      	<td>
				      		<select name="spaceId">
				      			<#if advSpaceList??>
				      			<#list advSpaceList as s>
				      				<option value="${s.id}" name="${s.type},${s.typeName}" <#if adv.spaceId?? && "${adv.spaceId}" == "${s.id}">selected</#if>>
				      				<#if s.parentId?? && s.parentId gt 1>
					      				<#list 2..s.level as i>&nbsp;</#list>
				      				</#if>
				      				${s.name}
				      				</option>
				      			</#list>
				      			</#if>
				      		</select>
				      	</td>
			     	</tr>
					<tr>
				      	<th>版位类型：</th>
				      	<td>
				      		<span style="color:black;" id="spaceType"></span>
				      	</td>
			     	</tr>
		     		<tr>
			      		<th><@s.m "cmsAdvertising.name"/>：</th>
			      		<td>
			      			<input name="name" type="text" maxlength="20" class="inpt" value="<#if adv.name??>${adv.name}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
			      		</td>
		     		</tr>
		    		<tr>
		      			<th>是否默认显示：</th>
		      			<td>
		    				<input name="isDefault" type="radio" class="radio" value="2" <#if adv.isDefault?? && "${adv.isDefault}" == "2">checked</#if> />默认显示
		    				&nbsp;&nbsp;
		    				<input name="isDefault" type="radio" class="radio" value="1" <#if adv.isDefault?? && "${adv.isDefault}" == "1">checked</#if> />非默认显示
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>排序：</th>
		      			<td>
		      				<input name="priority" type="text" maxlength="3" class="inpt" value="<#if adv.priority??>${adv.priority}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertising.startTime"/>：</th>
		      			<td>
		      				<input name="startTime" type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<#if adv.startTime??>${adv.startTime?string("yyyy-MM-dd")}</#if>" />
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertising.endTime"/>：</th>
		      			<td>
		      				<@s.bind "adv.endTime" />
		      				<input name="endTime" type="text" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<#if adv.endTime??>${adv.endTime?string("yyyy-MM-dd")}</#if>" />
		      				<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th><@s.m "cmsAdvertising.enabled"/>：</th>
		      			<td>
				      		<#if isEnableList??>
		          				<#list isEnableList as item>
									<input type="radio" class="radio" name="isEnable" value="${item.code}"  <#if adv.isEnable?? && "${adv.isEnable}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>打开方式：</th>
		      			<td>
		      				<#if targetList??>
		          				<#list targetList as item>
									<input type="radio" class="radio" name="target" value="${item.code}"  <#if adv.target?? && "${adv.target}" == "${item.code}">checked</#if> >${item.description}
									&nbsp;&nbsp;
								</#list>
							</#if>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>标题：</th>
		      			<td>
		      				<input name="title" type="text" maxlength="20" class="inpt" value="<#if adv.title??>${adv.title}</#if>" />
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>url：</th>
		      			<td>
		      				<input name="link" type="text" maxlength="200" class="inpt" value="<#if adv.link??>${adv.link}</#if>" />
		      				<span class="red">*</span>
							<span class="error"></span>
		      			</td>
		     		</tr>
				    <tr style="display:none;">
			      		<th><@s.m "cmsAdvertising.width"/>：</th>
				      	<td>
				      		<input name="width" type="text" maxlength="4" class="inpt" value="<#if adv.width??>${adv.width}</#if>" />
							<span class="error"></span>
				      	</td>
			     	</tr>
		     		<tr style="display:none;">
		      			<th><@s.m "cmsAdvertising.height"/>：</th>
		      			<td>
		      				<input name="height" type="text" maxlength="4" class="inpt" value="<#if adv.height??>${adv.height}</#if>" />
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>展示次数：</th>
		      			<td>
		      				<input name="displayCount" type="text" maxlength="120" class="inpt" value="<#if adv.displayCount??>${adv.displayCount}</#if>" />
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr>
		      			<th>点击次数：</th>
		      			<td>
		      				<input name="clickCount" type="text" maxlength="120" class="inpt" value="<#if adv.clickCount??>${adv.clickCount}</#if>" />
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr id="attachRes">
		      			<th><div id="typeNameDiv">图片：</div></th>
		      			<td>
		      				<input name="image" type="hidden" value="<#if adv.image??>${adv.image}</#if>" />
		      				<input type="file" name="uploadFile" id="fileUpload"/>
							<input type="button" onclick="ajaxUpload('fileUpload')" value="上传" class="btn" id="dirButton" />
							<span class="error"></span>
		      			</td>
		     		</tr>
		     		<tr id="attachResView">
		     			<div id="preImgDiv">
		     			<th colspan="2">
			     			<img noresize="noresize" 
			     				style="width:150px;height:150px;background-color:#ccc;border:1px solid #333 ;" 
			     				alt="预览"
			     				src="<#if adv.imageAbsolute??>${adv.imageAbsolute}</#if>" 
			     				id="preImg" />
		     			</th>
		     			</div>
		     		</tr>
	      		</table>
	   		</div>
    		<div class="form-but">
    			<#if settlerAgent.access("PermissionEnum.ADV_EDIT")>
      			<button id="buttonSave" type="button" class="button-s4" onclick="$('#inputForm').submit();">修改</button>
      			</#if>
      			<button type="button" class="button-s4" onclick="window.location.href='${appServer.get("/adv/list.htm?q=${q}")}'">返回</button>
    		</div>
    	</form>
  	</div>
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>