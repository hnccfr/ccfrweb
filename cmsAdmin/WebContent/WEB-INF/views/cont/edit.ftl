<#include "/include/head.ftl"/>
<#import "/include/image_upload.ftl" as upload>
<script type="text/javascript" src="${appServer.get('script/contAdd.js')}"></script>
<#if useFileSystem=="true">
<script src="${fileServerUrl}/uploadInit.htm?sysCode=${sysCode}&batchId=${batchId}&isAdd=false" type="text/javascript"></script>
</#if>
<script>
var channels = [];
<#if channelList??>
<#list channelList as c>
	<#if c??>
	channels[${c_index}] = {
		id:${c.id},
		hasTitleImg:'true',<#--${c.hasTitleImg?string('true','false')},-->
		titleImgWidth:100,<#--${c.titleImgWidth},-->
		titleImgHeight:100,<#--${c.titleImgHeight},-->
		hasContentImg:'true',<#--${c.hasContentImg?string('true','false')},-->
		contentImgWidth:100,<#--${c.contentImgWidth},-->
		contentImgHeight:100<#--${c.contentImgHeight}-->
	};
	</#if>
</#list>
</#if>

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
});

//退回提交操作
function rejectSubmit() {
	var checkOpinion = jQuery("#checkOpinion").val();
	checkOpinion = jQuery.trim(checkOpinion);
	if(checkOpinion == ''){
		jQuery("#checkOpinionErr").empty();
		jQuery("#checkOpinionErr").append("意见不能为空!");
		return false;
	}
	jQuery("#rejectDialog").dialog("close");
	jQuery("#rejectForm").submit();
}

//退回操作
function optReject() {
	jQuery("#rejectDialog").dialog("open");
}

//撤销操作
function optRevocation(){
	if(confirm('确认执行撤销操作吗？')) {
		window.location.href='${appServer.get('/cont/revocation.htm?id=${cont.id}&q=${q}')}'
	}
}

//上传图片
function upload(n,hiddenName,fileType) {
    var of = jQuery("#uploadFile"+n);
    //检查是否选择了图片
    if(of.val()=="") {
        alert("请选择文件！");
        return;
    }
    jQuery("#uploadForm input[type='file']").each(function(){
		jQuery(this).remove();
	});
    //将file移动至上传表单
    jQuery("#uploadForm").append(of);
    //复制一个file放至原处
    jQuery("#ufc"+n).append(of.clone().attr("value",""));
    //修改属性
    of.attr("id","");
    of.attr("name","uploadFile");
    	
    //其他表单
    jQuery("#ufFileName").val(jQuery("#fileName"+n).val());
    jQuery("#ufWidth").val(jQuery("#zoomWidth"+n).val());
    jQuery("#ufHeight").val(jQuery("#zoomHeight"+n).val());
    //先清除
    jQuery("#ufMark").val("");
    jQuery("#ufMark").val(jQuery("#mark"+n).val());
    jQuery("#uploadNum").val(n);
    jQuery("#hiddenName").val(hiddenName);
    jQuery("#fileType").val(fileType);
    jQuery("#uploadForm").submit();
}

//预览图片
function previewImg(n) {
	var img = jQuery("#uploadImgPath"+n).val();
	if(img!="") {
		if(img.indexOf("?")==-1) {
			jQuery("#preImg"+n).attr("src",img+"?d="+new Date()*1);
		} else {
			jQuery("#preImg"+n).attr("src",img+"&d="+new Date()*1);
		}
		if(!jQuery("#preImg"+n).attr("noResize")) {
			jQuery("#preImg"+n).css("width","100px");
			jQuery("#preImg"+n).css("height","70px");
		}
	} else {
		jQuery("#preImg"+n).removeAttr("src");		
		alert("请上传资源");
	}
}

//上传附件
function uploadAttachment(n) {
	var af = jQuery('#attachmentFile'+n);
	//检查是否选择了文件
	if(af.val()=='') {
	alert('请选择要上传的文件');
	return;
	}
	//将file移动至上传表单
	jQuery('#attachmentContent').empty();
	jQuery('#attachmentContent').append(af);
	//复制一个file放至原处
	jQuery('#afc'+n).append(af.clone().attr('value',''));
	//修改属性
	af.attr('id','');
	//其他表单
	jQuery('#attachmentNum').val(n);
	jQuery('#attachmentForm').submit();
	jQuery("#attachmentFile"+n).hide();
	jQuery("#attachmentFileSubmit"+n).hide();
}

function doReset(){
	var oEditor1 = FCKeditorAPI.GetInstance('txt');
	if(oEditor1){
		oEditor1.SetHTML($("#txt_1").val(),true);
	} else{
		return ;
	}
}

/*标题是否重复查询*/
function ajaxTitleSwitch(title){
	var titleTemp = jQuery.trim(title);
	var contId = jQuery("#id").val();
	if(titleTemp == ""){
		jQuery("#titleSwitchError").empty();
		jQuery("#titleSwitchError").append("*");
		return;
	}
	jQuery.ajax({
		type: "post",
		url: "/cont/ajaxTitleSwitch.htm",
		data:{"contId":contId,"title":titleTemp},
		dataType:"json",
		success:function(data){
			jQuery("#titleSwitchError").empty();
			if(data.message)
				jQuery("#titleSwitchError").append("该标题已经存在*");
			else
				jQuery("#titleSwitchError").append("*");
		},
		error: function(){
			alert("服务器请求忙或已停止，请稍后再试");
		}
	});
}

function doBlur(obj, num, fileType){
	jQuery("#hiddenName"+num).val(obj.value);
	if(fileType == 'image'){
		jQuery("#hiddenName"+num).attr("name","articleTitleImg.attachName");
		jQuery("#preImg"+num).attr("src",obj.value);
	}else{
		jQuery("#hiddenName"+num).attr("name","articleMedia.attachName");
	}
}
</script>
<div class="main">
	<form id="uploadForm" action="${appServer}/fUp/common.htm" method="post" enctype="multipart/form-data" target="hiddenIframe" 
	style="display:none;margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none; height: 0px; width: 0px; position: absolute; z-index: 10000;">
		<input id="fileContent" type="hidden"/>
		<input id="ufWidth" type="hidden" name="zoomWidth"/>
		<input id="ufHeight" type="hidden" name="zoomHeight"/>
		<input id="ufFileName" type="hidden" name="fileName"/>
		<input id="ufMark" type="hidden" name="mark"/>
		<input id="uploadNum" type="hidden" name="uploadNum"/>
		<input id="hiddenName" type="hidden" name="hiddenName"/>
		<input id="fileType" type="hidden" name="fileType"/>
	</form>
	<iframe name="hiddenIframe" frameborder="0" border="0" style="display:none;width:0px;height:0px;"></iframe>

	<form id="attachmentForm" action="${appServer}/fUp/attachment.htm" method="post" enctype="multipart/form-data" target="attachment_iframe" style="display:none;width:0px;height:0px;">
	<span id="attachmentContent"></span>
	<input type="hidden" id="attachmentNum" name="attachmentNum"/>
	</form>
	<iframe name="attachment_iframe" frameborder="0" border="0" style="display:none;width:0px;height:0px;"></iframe>
	
	<#--
	<div class="rhead">
		<div class="rpos"><@s.m "global.position"/>: <@s.m "content.function"/> - <@s.m "global.edit"/></div>
		<div class="clear"></div>
	</div>
	-->
	<form id="formback" class="ropt" action="${appServer}/cont/list.htm">
		<input type="hidden" name="channelId" value="<#if cont.channelId?? >${cont.channelId}</#if>"/>
		<input type="hidden" name="q" value="${q?default("")}"/>
	</form>
	<#--
	<#include "/include/image_upload.html"/>
	<#include "attachment_upload.html"/>
	<#include "media_upload.html"/>
	-->

	<div class="formBox">
		<h3><i></i><span>文章<#if cont.id??>修改<#else>增加</#if></span></h3>
		<div class="content">
		<form id="jvForm" action="${appServer}/cont/save.htm" method="post">
		<@s.formInput "cont.id" "id='contentId'" "hidden"/>
		<@s.formInput "cont.extId" "" "hidden"/>
		<input type="hidden" name="q" value="${q?default("")}"/>
		<table class="c4" width="100%">
		<#list itemList as item>
				<tr>
					<th width="120px">${item.itemLabel}：</th>
					<td>
			<#if !item.isCustomBoolean()>
				<#if item.field=="channelId">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<select id="${item.field}" name="${item.field}" onchange="channelChange(this.selectedIndex)" style="width:300px;">
					<#if channel??>
					<#if channelList?size gt 0>
						<#assign origDeep=1/><#--channelList[0].deep+-->
						<#assign childNum = 0/>
						<#list channelList as c>
						    <#--
						      <#list c.child as child>
						       <#if !child.status?if_exists>
						         <#assign childNum = childNum+1/>
						       </#if>
						       <#if child.status?? && !child.status>
						        <#assign childNum = childNum+1/>
						       </#if>
						      </#list>
						    -->
						    <#--  <#if c.hasContent lt 2 || childNum?number gt 0> -->
							  <option value="${c.id}" ><#--<#if c.model.id != cmsModel.id || childNum?number gt 0> class="sel-disabled"</#if>-->
							  <#--
							  <#if c.deep gte origDeep>
							  	<#list origDeep..c.deep as i>&nbsp;&nbsp;</#list>>
							  </#if>
							  -->
							  ${c.channelName}[<@s.m "channel.model"/>：${cmsModel.modelName}]
							  </option>
							  <#assign childNum = 0/>
							<#--  </#if> -->
						</#list>
					</#if>
					<#else>
						<option value="" class="sel-disabled"><@s.m "global.pleaseSelect"/></option>
					</#if>
					</select>
					<input id="channelsLink" type="button" value="<@s.m "content.channels"/>" style="display:none;"/>
					<span class="pn-fhelp" style="display:none;">${h}</span>
					</div>
					<div><label for="channelId" class="error" generated="true"></label></div>
					<div id="channelsContainer"></div>
					</div>
				<#elseif item.field=="title">
						<@s.formInput "cont.title" "class='inp' style='width:300px' maxlength='150' onblur='ajaxTitleSwitch(this.value)'" "text"/>
						<span style="color:red" id="titleSwitchError">*</span>
						<div>
							<div class="pn-fhelp" style="float:left">
							<input id="linkCheckBox" type="checkbox" <#if cont.link??>checked</#if>
								onclick="$('#linkDiv').toggle(this.checked);if(this.checked){$('#link').attr('class','required');$('#linkDiv').show();}if(!this.checked){$('#link').val('');$('#link').removeAttr('class');;}"/><@s.m "content.link"/>
							</div>
							<div id="linkDiv" <#if cont.link??><#else>style="display:none;"</#if>>
							url:<@s.formInput "cont.link" "class='inp url' style='width:300px;' maxlength='256'" "text"/>
							</div>
							</div>
						</div>
				<#elseif item.field=="shortTitle">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.shortTitle" "class='inp' style='width:300px;' maxlength='150'" "text"/>
				<#elseif item.field=="titleColor">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.titleColor" "class='inp' style='width:70px;' maxlength='10'" "text"/>
					<label>
					<input type="checkbox" <#if cont.getIsBoldBoolean()>checked</#if> onclick="$('#bold').val(this.checked);"/><@s.m "content.bold"/>
					<input type="hidden" id="bold" name="bold" value="<#if cont.getIsBoldBoolean()>true<#else>false</#if>"/>
					</label>
				<#elseif item.field=="tagStr">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.tagStr" "class='inp' style='width:300px;'" "text"/>
				<#elseif item.field=="remark">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formTextarea "cont.remark" "cols='${item.cols!60}' maxlength='256' rows='{item.rows!3}'"/>
				<#elseif item.field=="author">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.author" "class='inp' style='width:150px;' maxlength='100'" "text"/>
				<#elseif item.field=="origin">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.origin" "class='inp required' style='width:200px;' maxlength='100'" "text"/>
					<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<th><@s.m "content.originUrl"/>：</th>
					<td>
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.originUrl" "class='inp url' style='width:300px;' maxlength='256'" "text"/>
				<#elseif item.field=="topLevel">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<select type="text" class="inp" id="${item.field}" name="${item.field}" style="width:80px">
						<option value="0" <#if cont.topLevel == 0>selected</#if> >不固顶</option>
						<option value="1" <#if cont.topLevel == 1>selected</#if> >固顶1</option>
						<option value="2" <#if cont.topLevel == 2>selected</#if> >固顶2</option>
						<option value="3" <#if cont.topLevel == 3>selected</#if> >固顶3</option>
						<option value="4" <#if cont.topLevel == 4>selected</#if> >固顶4</option>
						<option value="5" <#if cont.topLevel == 5>selected</#if> >固顶5</option>
					</select>
					<@s.m "content.sortDate"/>:
					<#--<@s.formInput "cont.sortDate" "class='inp Wdate' style='width:140px;' onclick='WdatePicker({dateFmt:&quot;yyyy-MM-dd HH:mm:ss&quot;})'" "text"/>-->
					<input type="text" id="sortDate" name="sortDate" value="<#if cont.sortDate??>${cont.sortDate?string('yyyy-MM-dd HH:mm:ss')}</#if>" class="inp Wdate valid" style="width:140px;" onclick="WdatePicker({dateFmt:&quot;yyyy-MM-dd HH:mm:ss&quot;})">
					<input type="hidden" name="sortDateStr" id="sortDateStr"/>
				<#elseif item.field=="releaseDate">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<@s.formInput "cont.releaseDate" "class='inp Wdate' style='width:140px;' onclick='WdatePicker({dateFmt:&quot;yyyy-MM-dd&quot;})'" "text"/>
				<#elseif item.field=="titleImg">
					    <#if cont.articleTitleImg??>
					    	<@upload.common num="1" inputName="titleImg" hiddenName="articleTitleImg.attachName" fileType="image" value="${cont.articleTitleImg.attachUrlAbsolute}"/>
					    <#else>
					    	<@upload.common num="1" inputName="titleImg" hiddenName="articleTitleImg.attachName" fileType="image" value="" />
					    </#if>
						
				<#elseif item.field=="contentImg">
					 <#if cont.articleContImg??>
					 	<@upload.common num="2" inputName="contentImg" hiddenName="articleContImg.attachName" fileType="image" value="${cont.articleContImg.attachUrlAbsolute}"/>
					 <#else>
					 	<@upload.common num="2" inputName="contentImg" hiddenName="articleContImg.attachName" fileType="image" value=""/>
					 </#if>
						
<#elseif item.field=="attachments">
	<@upload.attachment cont.articleAttachs/>
				<#elseif item.field=="media">
					<#if cont.articleMedia??>
						<@upload.common num="3" inputName="mediaPath" hiddenName="articleMedia.attachName" fileType="media" value="${cont.articleMedia.attachUrlAbsolute}"/>
					<#else>
						<@upload.common num="3" inputName="mediaPath" hiddenName="articleMedia.attachName" fileType="media" value=""/>
					</#if>
				<#elseif item.field=="txt">				
				<textarea name="${item.field}" id="myEditor">${cont.txt!}</textarea>
				<script type="text/javascript">
				    UE.getEditor('myEditor',{
				        initialFrameWidth : 600
				        ,initialFrameHeight : 300
				        
				        ,imageUrl:"${appServer}/Ueditor/fUp.htm?Type=Image"
				        ,imageManagerUrl:"${appServer}/res/ueditor/image_manager.htm"
				        }
				        )
				</script> 
				<!--屏蔽FCK编辑器，相较fck Ueditor 无法上传附件，flash 和影视-->
					<script type="text/javascript">
//						var txt = new FCKeditor("${item.field}");
//						txt.BasePath = "${appServer}/script/fckeditor/";
//						txt.Config["CustomConfigurationsPath"]="${appServer}/script/fckeditor/myconfig.js";
//						txt.Config["LinkBrowser"] = false ;
//						txt.Config["ImageBrowser"] = false ;
//						txt.Config["FlashBrowser"] = false ;
//						txt.Config["MediaBrowser"] = false ;
						
//						txt.Config["LinkBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Connector=${appServer}/fck/connector.do" ;
//						txt.Config["ImageBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=${appServer}/fck/connector.do" ;
//						txt.Config["FlashBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=${appServer}/fck/connector.do" ;
//						txt.Config["MediaBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Type=Media&Connector=${appServer}/fck/connector.do" ;
						
//						txt.Config["LinkUpload"] = true ;
//						txt.Config["ImageUpload"] = true ;
//						txt.Config["FlashUpload"] = true ;
//						txt.Config["MediaUpload"] = true ;
	
//						txt.Config["LinkUploadURL"] = "${appServer}/fck/fUp.htm" ;
//						txt.Config["ImageUploadURL"] = "${appServer}/fck/fUp.htm?Type=Image" ;
//						txt.Config["FlashUploadURL"] = "${appServer}/fck/fUp.htm?Type=Flash" ;
//						txt.Config["MediaUploadURL"] = "${appServer}/fck/fUp.htm?Type=Media" ;
	
//						txt.ToolbarSet="My";
//						txt.Height="230px";
//						txt.Value="${cont.txt!?js_string}";
//						txt.Create();
					</script>
				<#elseif item.field=="txt1">
				<#elseif item.field=="txt2">
				<#elseif item.field=="txt3">
				<#elseif item.field=="pictures">
					<!-- 图片集 -->
					<@upload.pictures cont.articlePics/>
				</#if>
			<#else>
					<input type="text" class="inp" id="${item.field}" name="${item.field}" value=""class="url" style="width:100px"/>
			</#if>
					</td>
				</tr>
			<#--
			<tr<#if item_has_next><#assign f=itemList[item_index+1].field/> id="tr-${f}"<#if (f=="typeImg" && !typeList[0].hasImage) || (f=="titleImg" && (!channel?? || !channel.hasTitleImg) || (f=="contentImg" && (!channel?? || !channel.hasContentImg)))></#if></#if>>
			-->
		</#list>
				<#--
				<tr <#if cont.status != 1>style="display:none"</#if>>
					<th><@s.m "content.draft"/>：</th>
					<td>
						<label>
						<input type="checkbox" <#if cont.getStatusIsDraft()>checked</#if> onclick="$('#draft').val(this.checked)"/>
						<input type="hidden" id="draft" name="draft" value="<#if cont.getStatusIsDraft()>true<#else>false</#if>"/>
						</label>
					</td>
				</tr>
				-->
				<input type="hidden" name="status" value="${cont.status}" />
				<input type="hidden" id="draft" name="draft" value="true"/>
				<tr>
					<td colspan="2">
					<div class="form-but"><!-- 表单按钮区 -->
					<#if useFileSystem=="true">
					<input type="hidden" id="batchId" name="batchId" value="${batchId}"/>
					</#if>
					<#if settlerAgent.access("PermissionEnum.CONT_EDIT")>
						<#if userFinalStep gte contCurrentStep>
							<input id="buttonSave" type="button" class="button-s4" value='保存' onclick="$('#sortDateStr').val($('#sortDate').val());$('#draft').val('true');$('#jvForm').submit();"/> &nbsp;
						</#if>
					</#if>
					
					<#-- 待审核，不是已退回且文章状态不是编辑中的文章 -->
					<#-- 增加当编辑状态即可以提交，解决终审人员保存后无法提交	sunjin	20130715 -->
					<#if (cont.status == 1) || 
						(userFinalStep == 0 && contCurrentStep == 0) || (userFinalStep gt contCurrentStep && cms2ContCheck.isRejected == 1 && cont.status != 1)>
						<input id="buttonSubmit" type="button" class="button-s4" value='保存并提交' onclick="$('#sortDateStr').val($('#sortDate').val());$('#draft').val('false');$('#jvForm').submit();"/> &nbsp;
					</#if>
					<#if userFinalStep gt contCurrentStep && cms2ContCheck.isRejected == 1 && cont.status != 1>
						<input id="buttonReject" type="button" onclick="optReject()" class="button-s4" value="退回"/>
					</#if>
					
					<#-- 撤销针对已终审或已提交，与退回的文章-->
					<#if (userFinalStep != 0) && (userFinalStep == contCurrentStep || (userFinalStep gt contCurrentStep && cms2ContCheck.isRejected == 2))>
						<input id="buttonRevocation" type="button" onclick="$('#buttonRevocation').attr('disabled','disabled');optRevocation()" class="button-s4" value="撤销"/>
					</#if>
					
					<input type="reset" onclick="doReset()" class="button-s4" value='<@s.m "global.reset"/>' onclick="doReset()"/>
					<input type="button" class="button-s4" value='<@s.m "global.backToList"/>' onclick="$('#formback').submit()"/>
					</div>
					</td>
				</tr>
		</table>
		</form>
		</div>
		<div id="channelsDialog" title="<@s.m "content.selectChannels"/>" style="display:none;">
		<ul id="channelsSelector" class="filetree"></ul>
	</div>
</div>

<div id="rejectDialog" title="文章退回">
	<form method="post" id="rejectForm" action="${appServer.get('/cont/reject.htm')}">
		<input type="hidden" name="q" value="${q}"/>
		<input type="hidden" name="id" value="${cont.id}"/> 
		<p>退回意见:<textarea id="checkOpinion" name="checkOpinion" maxlength="256" cols="60" rows="3"></textarea>
		<p><span style="color:red" id="checkOpinionErr"></span></p>
	</form>
</div>

<textarea id="txt_1" style="display:none"><#if cont.txt??>${cont.txt!?js_string}</#if></textarea>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>