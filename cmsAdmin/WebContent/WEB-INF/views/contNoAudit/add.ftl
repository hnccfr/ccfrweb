<#include "/include/head.ftl"/>
<#import "/include/image_upload.ftl" as upload>

<script type="text/javascript" src="${appServer.get('script/contAdd.js')}"></script>
<#if useFileSystem=="true">
<script src="${fileServerUrl}/uploadInit.htm?sysCode=${sysCode}&batchId=${batchId}&isAdd=true" type="text/javascript"></script>
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
	var img = $("#uploadImgPath"+n).val();
	if(img!="") {
		if(img.indexOf("?")==-1) {
			$("#preImg"+n).attr("src",img+"?d="+new Date()*1);
		} else {
			$("#preImg"+n).attr("src",img+"&d="+new Date()*1);
		}
		if(!$("#preImg"+n).attr("noResize")) {
			$("#preImg"+n).css("width","100px");
			$("#preImg"+n).css("height","70px");
		}
	} else {
		$("#preImg"+n).removeAttr("src");		
		alert("请上传资源");
	}
}

//上传附件
function uploadAttachment(n) {
	var af = $('#attachmentFile'+n);
	//检查是否选择了文件
	if(af.val()=='') {
	alert('请选择要上传的文件');
	return;
	}
	//将file移动至上传表单
	$('#attachmentContent').empty();
	$('#attachmentContent').append(af);
	//复制一个file放至原处
	$('#afc'+n).append(af.clone().attr('value',''));
	//修改属性
	af.attr('id','');
	//其他表单
	$('#attachmentNum').val(n);
	$('#attachmentForm').submit();
	$("#attachmentFile"+n).hide();
	$("#attachmentFileSubmit"+n).hide();
}

/*标题是否重复查询*/
function ajaxTitleSwitch(title){
	var titleTemp = jQuery.trim(title);
	if(titleTemp == ""){
		jQuery("#titleSwitchError").empty();
		jQuery("#titleSwitchError").append("*");
		return;
	}
	jQuery.ajax({
		type: "post",
		url: "/contNoAudit/ajaxTitleSwitch.htm",
		data:{"title":titleTemp},
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
	style="display:none;margin: 0px; padding: 0px; border: 0px none; background-color: transparent; background-image: none;position: absolute; z-index: 10000;">
		<span id="fileContent"></span>
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
		<div class="rpos"><@s.m "global.position"/>: <@s.m "content.function"/> - <@s.m "global.add"/></div>
		<div class="clear"></div>
	</div>
	-->
	<form id="formback" class="ropt" action="${appServer}/contNoAudit/list.htm">
		<input type="hidden" name="q" value="${q?default("")}"/>
	</form>

	<div class="formBox">
		<h3><i></i><span>文章<#if cont.id??>修改<#else>增加</#if></span></h3>
		<div class="content">
		<form id="jvForm" action="${appServer}/contNoAudit/save.htm" method="post">
		<input type="hidden" name="q" value="${q?default("")}"/>
		<table class="c4" width="100%">
		<#list itemList as item>
				<tr>
					<th width="100%">${item.itemLabel}：</th>
					<td>
			<#if !item.isCustomBoolean()>
				<#if item.field=="channelId">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<select id="${item.field}" name="${item.field}" onchange="channelChange(this.selectedIndex)" style="width:300px">
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
							<input type="checkbox" onclick="$('#linkDiv').toggle(this.checked);if(this.checked){$('#link').attr('class','required');$('#linkDiv').show();}if(!this.checked){$('#link').val('');$('#link').removeAttr('class');;}"/><@s.m "content.link"/>
							</div>
							<div id="linkDiv" style="display:none;float:left">
							url: <#--<input class="inp url" type="text" id="link" name="link" maxlength="256" value="http://"/></div>-->
							<@s.formInput "cont.link" "class='inp url' style='width:150px;' maxlength='256'" "text"/>
							</div>
						</div>
				<#elseif item.field=="shortTitle">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp" id="${item.field}" name="${item.field}" value="${item.defValue!}" maxlength="150" style="width:300px;"/>
				<#elseif item.field=="titleColor">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp" id="${item.field}" name="${item.field}" maxlength="10" value="${item.defValue!}" style="width:70px" />
					<label>
					<input type="checkbox" onclick="$('#bold').val(this.checked);"/><@s.m "content.bold"/>
					<input type="hidden" id="bold" name="bold" value="false"/>
					</label>
				<#elseif item.field=="tagStr">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp" id="${item.field}" name="${item.field}" value="${item.defValue!}" style="width:300px"/>
				<#elseif item.field=="remark">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<textarea id="${item.field}" name="${item.field}" maxlength="256" value="${item.defValue!}" cols="${item.cols!60}" rows="${item.rows!3}"></textarea>
				<#elseif item.field=="author">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp" id="${item.field}" maxlength="100" name="${item.field}" value="${item.defValue!}" style="width:150px"/>
				<#elseif item.field=="origin">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp required" id="${item.field}" maxlength="100" name="${item.field}" value="${item.defValue!}" style="width:200px"/>
					<span style="color:red">*</span>
					</td>
				</tr>
				<tr>
					<th><@s.m "content.originUrl"/>：</th>
					<td>
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp url" id="originUrl" maxlength="256" name="originUrl" value="" style="width:300px"/>
				<#elseif item.field=="topLevel">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<select type="text" class="inp" id="${item.field}" name="${item.field}" style="width:80px">
						<option value="0">不固顶</option>
						<option value="1">固顶1</option>
						<option value="2">固顶2</option>
						<option value="3">固顶3</option>
						<option value="4">固顶4</option>
						<option value="5">固顶5</option>
					</select>
					<@s.m "content.sortDate"/>: 
					<#--<input type="text" class="inp" name="sortDate" style="width:140px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="Wdate"/>-->
					<input type="text" class="inp valid Wdate" id="sortDate" name="sortDate" style="width:140px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					<input type="hidden" name="sortDateStr" id="sortDateStr"/>
				<#elseif item.field=="releaseDate">
					<#assign h><#if item.help??>${item.help}<#else><@s.m "content."+item.field+".help"/></#if></#assign>
					<input type="text" class="inp" name="releaseDate" style="width:140px" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate"/>
				<#elseif item.field=="titleImg">
					<!-- 标题图-->
						<@upload.common num="1" inputName="titleImg" hiddenName="articleTitleImg.attachName" fileType="image" value=""/>
				<#elseif item.field=="contentImg">
					<#-- articleContImg.attachName -->
						<@upload.common num="2" inputName="contentImg" hiddenName="articleContImg.attachName" fileType="image" value=""/>
					<!--多媒体 articleMedia.attachName-->
					<#elseif item.field=="media">
						<@upload.common num="3" inputName="mediaPath" hiddenName="articleMedia.attachName" fileType="media" value=""/>
						
<#elseif item.field=="attachments">
    		
	  		<@upload.attachment cont.articleAttachs/>
					
			<#elseif item.field=="txt">
				<textarea name="${item.field}" id="myEditor"></textarea>
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
					//var txt = new FCKeditor("${item.field}");
					//txt.BasePath = "${appServer}/script/fckeditor/";
					//txt.Config["CustomConfigurationsPath"]="${appServer}/script/fckeditor/myconfig.js";
					//txt.Config["LinkBrowser"] = false ;
					//txt.Config["ImageBrowser"] = false ;
					//txt.Config["FlashBrowser"] = false ;
					//txt.Config["MediaBrowser"] = false ;
					
					//txt.Config["LinkBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Connector=${appServer}/fck/connector.do" ;
					//txt.Config["ImageBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Type=Image&Connector=${appServer}/fck/connector.do" ;
					//txt.Config["FlashBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Type=Flash&Connector=${appServer}/fck/connector.do" ;
					//txt.Config["MediaBrowserURL"] = "${appServer}/script/fckeditor/editor/filemanager/browser/default/browser.html?Type=Media&Connector=${appServer}/fck/connector.do" ;
					
					//txt.Config["LinkUpload"] = true ;
					//txt.Config["ImageUpload"] = true ;
					//txt.Config["FlashUpload"] = true ;
					//txt.Config["MediaUpload"] = true ;
					
					//txt.Config["LinkUploadURL"] = "${appServer}/fck/fUp.htm" ;
					//txt.Config["ImageUploadURL"] = "${appServer}/fck/fUp.htm?Type=Image" ;
					//txt.Config["FlashUploadURL"] = "${appServer}/fck/fUp.htm?Type=Flash" ;
					//txt.Config["MediaUploadURL"] = "${appServer}/fck/fUp.htm?Type=Media" ;
					
					//txt.ToolbarSet="My";
					//txt.Height="230px";
					//txt.Value="";
					//txt.Create();
					</script>
				<#elseif item.field=="txt1">
				<#elseif item.field=="txt2">
				<#elseif item.field=="txt3">
				<#elseif item.field=="pictures">
					<@upload.pictures cont.articlePics/>
				</#if>
			<#else>
					<input type="text" class="inp" id="${item.field}" name="${item.field}" value=""class="url" style="width:100px"/>
			</#if>
					</td>
				</tr>
			<#--
			<tr
			<#if item_has_next><#assign f=itemList[item_index+1].field/> 
				id="tr-${f}"
				<#if (f=="typeImg" && !typeList[0].hasImage) || (f=="titleImg" && (!channel?? || !channel.hasTitleImg) || (f=="contentImg" && (!channel?? || !channel.hasContentImg)))>
					cc
				</#if>
				
			</#if>>
			-->
		</#list>
		<#--
				<tr>
					<th><@s.m "content.draft"/>：</th>
					<td>
						<label>
						<input type="checkbox" onclick="$('#draft').val(this.checked)"/>
						<input type="hidden" id="draft" name="draft" value="false"/>
						</label>
					</td>
				</tr>
		-->
		<input type="hidden" id="draft" name="draft" value="true"/>
				<tr>
					<td colspan="2">
					<div class="form-but"><!-- 表单按钮区 -->
					<#if useFileSystem=="true">
						<input type="hidden" id="batchId" name="batchId" value="${batchId}"/>
					</#if>
					<input type="button" id="buttonSave" class="button-s4" value='保存' onclick="$('#sortDateStr').val($('#sortDate').val());$('#draft').val('true');$('#jvForm').submit();"/> &nbsp;
					<input type="button" id="buttonSubmit" class="button-s4" value='保存并发布' onclick="$('#sortDateStr').val($('#sortDate').val());$('#draft').val('false');$('#jvForm').submit();"/> &nbsp;
					<input type="reset" class="button-s4" value='<@s.m "global.reset"/>' onclick="doReset()"/>
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
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>