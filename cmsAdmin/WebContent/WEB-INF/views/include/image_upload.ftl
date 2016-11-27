<#macro common num hiddenName fileType value inputName>
<div style="float:left;width:300px;">
   <input type="text" class="inp" id="uploadImgPath${num}" onblur="doBlur(this,'${num}','${fileType}')" name="${inputName}" style="width:220px" value="<#if value??>${value}</#if>"/>
                  <input type="button" value="预览" onclick="previewImg(${num});"/><br/>
                  <span id="ufc${num}"><input type="file" id="uploadFile${num}" style="width:180px" name="uploadFile"/></span>
                  <label style="display:none;"><input type="checkbox" onclick="$('#mark${num}').val(this.checked);"/>水印</label>
                  <input type="hidden" id="mark${num}" value="false"/>
                  <input type="button" value="上传" onclick="upload(${num},'${hiddenName}','${fileType}');"/><br/>
                  <#if value?? && value != "">
<#--
                  	<#if fileType=='image'>
                  		 <input type="hidden" id="hiddenName${num}" value="${value}" name="articleTitleImg.attachName" />
                  		<#else>
                  		 <input type="hidden" id="hiddenName${num}" value="${value}" name="articleMedia.attachName" />
                  	</#if>
-->
<input type="hidden" id="hiddenName${num}" value="${value}" name="${hiddenName}" />
                    
                  <#else>
                     <input type="hidden" id="hiddenName${num}" value="${hiddenName}"/>
                  </#if>
</div>
 <#if fileType=='image'>
   <div style="float:left;width:100px;">
      <img id="preImg${num}" alt="<@s.m "imageupload.preview"/>" style="width:100px;height:70px;background-color:#ccc;border:1px solid #333" 
      src="<#if value?? && value != ''>${value}</#if>"/>
   </div>
  </#if>   
</#macro>

<#macro attachment attachs>
	<!--附件集--><table id="attachTable" border="0">
			<tr>
				<td align="center"><input type="button" onclick="addAttachLine();" value="<@s.m "content.attachmentAddLine"/>"/></td>
				<td align="center"><@s.m "content.attachmentName"/></td>
				<td align="center"><@s.m "content.attachmentPath"/></td>
				<td align="center"><@s.m "content.fileUpload"/></td>
			</tr>
			<#if attachs?? && attachs?size gt 0>
				<#list attachs as attach>
					<tr id="attachTr${attach_index}">
						<td align="center"><a onclick="$('#attachTr${attach_index}').remove();" href="javascript:void(0);" class="pn-opt"><@s.m "content.attachmentDelLine"/></a></td>
						<td align="center"><input type="text" id="attachmentNames${attach_index}" name="attachmentNames" value="${attach.fileName!}" maxlength="100"/></td>
						<td align="center"><input type="text" id="attachmentPaths${attach_index}" name="paths" value="${attach.attachUrlAbsolute!}" readonly maxlength="255"/></td>
						<td align="center">
							<span id="afc${attach_index}"><input type="file" id="attachmentFile${attach_index}" style="display:none" name="attachmentFile" size="12" style="width:160px"/></span>
							<input type="button" value="<@s.m "content.fileUpload"/>" style="display:none" id="attachmentFileSubmit${attach_index}" onclick="uploadAttachment(${attach_index});"/>
							<input type="hidden" id="attachmentPaths${attach_index}" name="attachmentPaths" value="${attach.attachUrlAbsolute!}"/>
						</td>
					</tr>
				</#list>
			<#else>
				<#list 0..0 as i>
					<tr id="attachTr${i}">
						<td align="center"><a onclick="$('#attachTr${i}').remove();" href="javascript:void(0);" class="pn-opt"><@s.m "content.attachmentDelLine"/></a></td>
						<td align="center"><input type="text" id="attachmentNames${i}" name="attachmentNames"/></td>
						<td align="center"><input type="text" id="attachmentPaths${i}" name="attachmentPaths"/></td>
						<td align="center">
							<span id="afc${i}"><input type="file" id="attachmentFile${i}" name="attachmentFile" style="width:160px"/></span>
							<input type="button" value="<@s.m "content.fileUpload"/>" id="attachmentFileSubmit${i}" onclick="uploadAttachment(${i});"/>
							<input type="hidden" id="attachmentFilenames${i}" name="attachmentFilenames"/>
					</td>
					</tr>
				</#list>
			</#if>
			
		</table>
		<textarea id="attachTr" style="display:none">
		<tr id="attachTr{0}">
			<td align="center"><a onclick="$('#attachTr{0}').remove();" href="javascript:void(0);" class="pn-opt"><@s.m "content.attachmentDelLine"/></a></td>
			<td align="center"><input type="text" id="attachmentNames{0}" name="attachmentNames"/></td>
			<td align="center"><input type="text" id="attachmentPaths{0}" name="attachmentPaths"/></td>
			<td align="center">
				<span id="afc{0}"><input type="file" id="attachmentFile{0}" name="attachmentFile" style="width:160px"/></span>
				<input type="button" value="<@s.m "content.fileUpload"/>" id="attachmentFileSubmit{0}" onclick="uploadAttachment({0});"/>
				<input type="hidden" id="attachmentFilenames{0}" name="attachmentFilenames"/>
			</td>
		</tr>
		</textarea>
		<script type="text/javascript">
		<#if attachs?? && attachs?size gt 0>
			var attachIndex = ${attachs?size};
		<#else>
			var attachIndex = 1;
		</#if>
		var attachTpl = jQuery.format(jQuery("#attachTr").val());
		function addAttachLine() {
			jQuery('#attachTable').append(jQuery(attachTpl(attachIndex++)));
		}
		</script>	
</#macro>

<#macro pictures attachs>
	<div><input type="button" onclick="addPicLine();" value="<@s.m "content.picturesAdd"/>"/></div>
			<#if attachs?? && attachs?size gt 0 >
				<#list attachs as attach>
				<#assign picIndex=attach_index+5>
				<table id="picTable${ attach_index +4 }" border="0" style="float:left;width:310px;">
				<tr>
					<td>
						<div><input type="text" id="uploadImgPath${ attach_index +4 }" name="picPaths" style="width:170px" value="${attach.attachUrlAbsolute!}"/> <a href="javascript:void(0);" onclick="$('#picTable${ attach_index +4 }').remove();" class="pn-opt"><@s.m "content.picturesDel"/></a></div>
						<div><span id="ufc${ attach_index +4 }"><input type="file" id="uploadFile${ attach_index +4 }" size="10" style="width:150px"/></span> <input type="button" value="<@s.m "content.fileUpload"/>" onclick="upload(${ attach_index +4 },'','image');"/></div>
						<div><textarea style="width:200px;height:60px;" name="picDescs" maxlength="255">${attach.remark!}</textarea></div>
					</td>
					<td width="110px;" align="center"><img id="preImg${ attach_index +4 }" src="${attach.attachUrlAbsolute!}" alt="<@s.m "imageupload.preview"/>" noResize="true" style="width:110px;height:100px;background-color:#ccc;border:1px solid #333"/></td>
				</tr>
				</table>
					</#list>
			<#else>
				<#list 4..5 as i>
				<table id="picTable${i}" border="0" style="float:left;width:310px;">
				<tr>
					<td>
						<div><input type="text" id="uploadImgPath${i}" name="picPaths" style="width:170px"/> <a href="javascript:void(0);" onclick="$('#picTable${i}').remove();" class="pn-opt"><@s.m "content.picturesDel"/></a></div>
						<div><span id="ufc${i}"><input type="file" id="uploadFile${i}" size="10" style="width:150px"/></span> <input type="button" value="<@s.m "content.fileUpload"/>" onclick="upload(${i},'','image');"/></div>
						<div><textarea style="width:200px;height:60px;" name="picDescs" maxlength="255"></textarea></div>
					</td>
					<td width="110px;" align="center"><img id="preImg${i}" alt="<@s.m "imageupload.preview"/>" noResize="true" style="width:110px;height:100px;background-color:#ccc;border:1px solid #333"/></td>
				</tr>
				</table>
				</#list>
				<#assign picIndex=6>
			</#if>
		<div id="picBefore" style="clear:both"></div>
		<textarea id="picTable" style="display:none;">
		<table id="picTable{0}" border="0" style="float:left;width:310px;">
		<tr>
			<td>
				<div><input type="text" id="uploadImgPath{0}" name="picPaths" style="width:160px"/> <a href="javascript:void(0);" onclick="$('#picTable{0}').remove();" class="pn-opt"><@s.m "content.picturesDel"/></a></div>
				<div><span id="ufc{0}"><input type="file" id="uploadFile{0}" size="10" style="width:150px"/></span> <input type="button" value="<@s.m "content.fileUpload"/>" onclick="upload({0});"/></div>
				<div>&lt;textarea style="width:200px;height:60px;" name="picDescs" maxlength="255"&gt;&lt;/textarea&gt;</div>
			</td>
			<td width="110px;" align="center"><img id="preImg{0}" alt="<@s.m "imageupload.preview"/>" noResize="true" style="width:110px;height:110px;background-color:#ccc;border:1px solid #333"/></td>
		</tr>
		</table>
		</textarea>
		<script type="text/javascript">
		var picIndex = '${picIndex}';
		var picTpl = $.format($("#picTable").val());
		function addPicLine() {
			$('#picBefore').before(picTpl(picIndex++));
		}
		</script>
</#macro>