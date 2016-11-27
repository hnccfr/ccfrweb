<#include "/include/head.ftl"/>
<script>

function isDisplayFunc(val){
	if(val == 2){//不显示
		jQuery("#isDisplay").hide();
		jQuery("#isBlank").attr("checked",false);
		jQuery("#blank").val(2);
	}
	if(val == 1){//显示
		jQuery("#isDisplay").show();
		jQuery("#isBlank").attr("checked",false);
		jQuery("#blank").val(2);
	}
}
function checkBlank(val){
	if(val){
		jQuery("#blank").val(1);
	}else{
		jQuery("#blank").val(2);
	}
}

function titleImgSize(val){
	if(val){//内容包含标题图
		jQuery("#hasTitleImg").val(2);
		jQuery("#titleImgSize").show();
	}else{//内容不包含
		jQuery("#hasTitleImg").val(1);
		jQuery("#titleImgSize").hide();
	}
}

function contentImgSize(val){
	if(val){//内容包含标题图
		jQuery("#hasContImg").val(2);
		jQuery("#contentImgSize").show();
	}else{//内容不包含
		jQuery("#hasContImg").val(1);
		jQuery("#contentImgSize").hide();
	}
}

function doSubmit(){
	var flag = true;
	var channelName = jQuery("#channelName");
	var code = jQuery("#code");
	var hasTitleImg = jQuery("#hasTitleImg");
	var hasContImg = jQuery("#hasContImg");
	
	jQuery("#code_err").empty();
	jQuery("#channelName_err").empty();
	jQuery("#link_err").empty();
	jQuery("#hasTitleImg_err").empty();
	jQuery("#hasContImg_err").empty();
	
	if(channelName.length > 0){
		var name = jQuery.trim(channelName.val());
		if(name == ''){
			jQuery("#channelName_err").append("栏目名称不能为空");
			flag = false;
		}
	}
	
	if(code.length > 0){
		var codeVal = jQuery.trim(code.val());
		if(codeVal == ''){
			jQuery("#code_err").append("访问路径不能为空");
			flag = false;
		}else{
			var chrnum = /^([a-zA-Z0-9]+)$/;
			if(!chrnum.test(codeVal)){
				jQuery("#code_err").append("访问路径只能由数字与字母组成");
				flag = false;
			}
		}
	}
	
	if(hasTitleImg.length > 0){
		if(!testHasImg("hasTitleImg","titleImgHeight","titleImgWidth","hasTitleImg_err","标题图"))
			flag = false;
	}
	
	if(hasContImg.length > 0){
		if(!testHasImg("hasContImg","contImgHeight","contImgWidth","hasContImg_err","标题图"))
			flag = false;
	}
	
	var link = jQuery("#link");
	if(link.length > 0){
		var linkVal = jQuery("#link").val()
		linkVal = jQuery.trim(linkVal);
		if(linkVal == ''){
			jQuery("#link_err").append("外部链接不能为空");
			flag = false;
		}
	}
	if(flag){
		$('#buttonSave').attr('disabled','disabled');
		jQuery("#addForm").submit();
	}
}

//判断是否包含图片宽、高参数为数字
function testHasImg(targetId,imgHeightId,imgWidthId,errorId,targetName){
	var hasImgVal = jQuery.trim(jQuery("#"+targetId).val());
	var flag = true;
	var r = /^\+?[1-9][0-9]*$/;
	if(hasImgVal == '2'){//包含图
		var imgWidth = jQuery("#"+imgWidthId).val();
		if(imgWidth != ''){
			if(!r.test(imgWidth)){
				jQuery("#"+errorId).append(targetName + "宽只能为数字");
				flag = false;
			}
		}
		if(flag){
			var imgHeight = jQuery("#"+imgHeightId).val();
			if(imgHeight != ''){
				if(!r.test(imgHeight)){
					jQuery("#"+errorId).append(targetName + "高只能为数字");
					flag = false;
				}
			}
		}
	}
	return flag;
}
</script>
<div class="main">
<#--
	<div class="rhead">
		<div class="rpos">当前位置: 栏目管理 - 添加</div>
		<div class="clear"></div>
	</div>
-->
  <div class="formBox mt10">
    <h3><i></i><span>栏目添加</span></h3>
    <form action="${appServer.get('/channel/save.htm')}" id="addForm" method="POST">
    <input type="hidden" name="q" value="${q?default("")}"/>
	    <div class="content">
	      <table class="c2">
	      	<tr>
		      	<th>模型：</th>
		      	<td>${cms2Model.modelName}</td>
		      	<input type="hidden" name="siteId" value="${currentSite.id}"/>
		      	<input type="hidden" name="modelId" value="${cms2Model.id}"/>
		     </tr>
		     <tr>
		      	<th>所属栏目：</th>
		      	<td>
		      		<select name="parentId">
		      			<option value="0">--顶级栏目--</option>
		      			<#if channelList??>
		      			<#list channelList as c>
		      				<option value="${c.id}" <#if parentId?? && c.id == parentId>selected="selected"</#if> >
		      				<#if c.level gt 1>
			      				<#list 2..c.level as i>&nbsp;</#list>
			      				>
		      				</#if>
		      				${c.channelName}
		      				</option>
		      			</#list>
		      			</#if>
		      		</select>
		      		<span class="red" id="parentId_err">
		      			<#if parentId_err??>${parentId_err}</#if>
		      		</span>
		      	</td>
		     </tr>
		      <#list modelItemList as item>
		      <tr <#if item.isDisplay?? && item.isDisplay==2> style="display:none;" </#if>>
		      	<th>${item.itemLabel}：</th>
		      	<td>
		      	<#if item.isCustom == 0><!-- 系统预定义字段 -->
			      	<#if item.field=="channelName"><!-- 栏目名称 -->
			      		<input type="text" maxlength="100" name="channelName" id="channelName" value="<#if channel.channelName??>${channel.channelName}</#if>" class="inp">
			      		<span class="red">*</span><span class="red" id="channelName_err"><#if channelName_err??>${channelName_err}</#if></span>
			      		
			      	<#elseif item.field="code"><!-- 访问路径 -->
			      		<input type="text" maxlength="30" name="code" id="code" value="<#if channel.code??>${channel.code}</#if>" class="inp">
			      		<span class="red">*</span><span class="red" id="code_err"><#if code_err??>${code_err}</#if></span>
			      		
			      	<#elseif item.field="title"><!-- meta标题 -->
			      		<input type="text" maxlength="255" name="title" value="<#if channelExt.title??>${channelExt.title}</#if>" class="inp">
			      		
			      	<#elseif item.field="keywords"><!-- meta关键字 -->
			      		<input type="text" maxlength="255" name="keywords" value="<#if channelExt.keywords??>${channelExt.keywords}</#if>" class="inp">
			      		
			      	<#elseif item.field="remark"><!-- meta描述 -->
			      		<textarea cols="70" rows="3" name="remark" maxlength="255" class="w200"><#if channelExt.remark??>${channelExt.remark}</#if></textarea>
			      		
			      	<#elseif item.field="tplChnlId"><!-- 栏目模板ID -->
			      		<select name="tplChnlId">
			      			<option value="" <#if channelExt.tplChnlId??><#else>selected="selected"</#if> >--默认--</option>
			      			<#if tplChnlList??>
				      			<#list tplChnlList as tpl>
				      				<option value="${tpl.id}" <#if channelExt.tplChnlId?? && channelExt.tplChnlId==tpl.id >selected="selected"</#if>>${tpl.tplName}</option>
				      			</#list>
			      			</#if>
			      		</select>
			      		
			      	<#elseif item.field="tplContId"><!-- 内容模板ID -->
			      		<select name="tplContId">
			      			<option value="" <#if channelExt.tplContId??><#else>selected="selected"</#if> >--默认--</option>
			      			<#if tplContList??>
				      			<#list tplContList as tpl>
				      				<option value="${tpl.id}" <#if channelExt.tplContId?? && channelExt.tplContId==tpl.id >selected="selected"</#if>>${tpl.tplName}</option>
				      			</#list>
			      			</#if>
			      		</select>
			      		
			      	<#elseif item.field="isDisplay"><!--显示-->
				      	<input type="radio" value="1"  name="isDisplay" onclick="isDisplayFunc(this.value)" checked="checked" <#if channel.isDisplay?? && channel.isDisplay==1>checked="checked"</#if> />是
				      	<input type="radio" value="2" name="isDisplay" onclick="isDisplayFunc(this.value)" <#if channel.isDisplay?? && channel.isDisplay==2>checked="checked"</#if> />否
				      	<span id="isDisplay" <#if channel.isDisplay?? && channel.isDisplay==2>style="display:none;"</#if>>
				      		<input type="checkbox" id="isBlank" <#if channelExt.isBlank?? && channelExt.isBlank==1>checked</#if> onclick="checkBlank(this.checked);" />新窗口打开
				      		<input type="hidden" id="blank" name="isBlank" value="<#if channelExt.isBlank??>${channelExt.isBlank}<#else>2</#if>" />
				      	</span>
				      	
			      	<#elseif item.field="titleImg"><!--标题图-->
			      		<input type="checkbox" <#if channelExt.hasTitleImg?? && channelExt.hasTitleImg==2>checked</#if> onclick="titleImgSize(this.checked)"/>有
			      		<input type="hidden" id="hasTitleImg" name="hasTitleImg" value="<#if channelExt.hasTitleImg??>${channelExt.hasTitleImg}<#else>1</#if>"/>
			      		<span id="titleImgSize" <#if channelExt.hasTitleImg?? && channelExt.hasTitleImg==2><#else>style="display:none;"</#if>>
			      			宽: <input type="text" name="titleImgWidth" id="titleImgWidth" value="<#if channelExt.titleImgWidth??>${channelExt.titleImgWidth}<#else>139</#if>" class="w50" maxlength="5"/>
			      			高: <input type="text" name="titleImgHeight" id="titleImgHeight" value="<#if channelExt.titleImgHeight??>${channelExt.titleImgHeight}<#else>139</#if>" class="w50" maxlength="5"/>
			      		</span>
			      		<span class="red" id="hasTitleImg_err"></span>
			      		
			      	<#elseif item.field="contentImg"><!--内容图-->
			      		<input type="checkbox" <#if channelExt.hasContImg?? && channelExt.hasContImg==2>checked</#if> onclick="contentImgSize(this.checked)"/>有
						<input type="hidden" id="hasContImg" name="hasContImg" value="<#if channelExt.hasContImg??>${channelExt.hasContImg}<#else>1</#if>"/>
						<span id="contentImgSize" <#if channelExt.hasContImg?? && channelExt.hasContImg==2><#else>style="display:none;"</#if>>
							宽: <input type="text" name="contImgWidth" id="contImgWidth" value="<#if channelExt.contImgWidth??>${channelExt.contImgWidth}<#else>310</#if>" class="w50" maxlength="5"/>
							高: <input type="text" name="contImgHeight" id="contImgHeight" value="<#if channelExt.contImgHeight??>${channelExt.contImgHeight}<#else>310</#if>" class="w50" maxlength="5"/>
						</span>
						<span class="red" id="hasContImg_err"></span>
						
			      	<#elseif item.field="finalStep"><!--内容审核步骤-->
			      		<select name="finalStep" style="width:50px;">
							<option value="" selected=""></option>
							<#if currentSite.finalStep??>
							<#list 0..currentSite.finalStep as i>
				          		<option value="${i}" <#if channelExt.finalStep?? && channelExt.finalStep == i>selected</#if> >${i}</option>
				          	</#list>
				          	</#if>
						</select>
						<span class="red">*</span>
						
			      	<#elseif item.field="afterCheck"><!--审核后-->
			      		<select name="afterCheck">				      		
				      		<#if afterCheckMap??>
				          		<#list afterCheckMap?keys as key>
									<option value="${key}" <#if channelExt.afterCheck?? && "${channelExt.afterCheck}" == "${key}">selected</#if> >${afterCheckMap[key]}</option>
								</#list>
							</#if>
			      		</select>
			      		
			      	<#elseif item.field="commentControl"><!--评论-->
			      		<#if commentTypeMap??>
			          		<#list commentTypeMap?keys as key>
			          			<input type="radio" value="${key}" <#if "${key_index}" == "0">checked="checked"</#if> <#if channelExt.commentControl?? && "${channelExt.commentControl}" == "${key}">checked="checked"</#if> name="commentControl">${commentTypeMap[key]}
							</#list>
						</#if>
						
			      	<#elseif item.field="allowUpdown"><!--顶踩-->
			      		<input type="radio" value="1" checked="checked" name="allowUpdown" <#if channelExt.allowUpdown?? && channelExt.allowUpdown==1>checked="checked"</#if>"/>允许
			      		<input type="radio" value="2" name="allowUpdown" <#if channelExt.allowUpdown?? && channelExt.allowUpdown==2>checked="checked"</#if>"/>不允许
			      		
			      	<#elseif item.field="link"><!--外部链接-->
			      		<input type="text" maxlength="255" name="link" id="link" class="inp" value="<#if channelExt.link??>${channelExt.link}</#if>"/>
			      		<span class="red">*</span><span class="red" id="link_err"><#if link_err??>${link_err}</#if></span>
			      	<#--
			      	<#elseif item.field="viewGroupIds">浏览权限--留着不使用
			      	<#elseif item.field="contriGroupIds">投稿权限--留着不使用
			      	-->
			      	</#if>
			    <#else><!-- 用户自定义字段 -->
		          	<#if item.dataType == 1><!-- 1.字符串文本 -->
		          		<input type="text" class="inp" <#if item.textSize??>maxlength="${item.textSize}"</#if> <#if item.field??>name="attr_${item.field}"</#if> value="<#if attr??><#if attr[item.field]??>${attr[item.field]}</#if><#elseif item.defValue??>${item.defValue}</#if>" />
		          		<span>${item.help}</span>
		          	<#elseif item.dataType == 2><!-- 2.整型文本 -->
		          		<input type="text" class="inp" <#if item.textSize??>maxlength="${item.textSize}"</#if> <#if item.field??>name="attr_${item.field}"</#if> <#if item.defValue??>value="${item.defValue}"</#if> />
		          		<span>${item.help}</span>
		          	<#elseif item.dataType == 3><!-- 3.浮点型文本 -->
		          		
		          	<#elseif item.dataType == 4><!-- 4.文本区 -->
		          		
		          	<#elseif item.dataType == 5><!-- 5.日期 -->
		          		
		          	<#elseif item.dataType == 6><!-- 6.下拉列表 -->
		          		
		          	<#elseif item.dataType == 7><!-- 7.复选框 -->
		          		
		          	<#elseif item.dataType == 8><!-- 8.单选框 -->
		          		
		          	</#if>
		      	</#if>
		      	</td>
		      	</tr>
		      </#list>
	      </table>
	    </div>
    </form>
    <div class="form-but">
    <#if settlerAgent.access("PermissionEnum.CHANNEL_ADD")>
      <button id="buttonSave" type="button" class="button-s4" onclick="doSubmit()">添加</button>
      </#if>
      <button type="button" class="button-s4" onclick="window.location.href='${appServer.get("/channel/list.htm?q=")}${q?default("")}'">返回</button>
    </div>
  </div>
</div>
<#include "/include/foot.ftl"/>