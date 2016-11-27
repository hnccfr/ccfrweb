<#include "/include/head.ftl"/>
<script src="${appServer}/script/pony.js" type="text/javascript"></script>
<script src="${appServer}/script/ajaxfileupload.js" type="text/javascript"></script>
<script>
$(function() {
	//增加文件名验证	sunjin	2011-11-02
	 jQuery.validator.addMethod("stringCheck", function(value, element) {
	     return this.optional(element) || /^[\u0391-\uFFE5A-Za-z0-9_]+$/.test(value);
	 }, "只能包括中文字、英文字母、数字和下划线");
		$("#jvForm").validate({
			errorPlacement:function(error,element) {
				if (element.attr("name") == "dirName"){
				error.insertAfter("#dirButton");}
				}
			});
});

function ajaxUpload(objId) {
	var obj = jQuery("#" + objId);
	if(jQuery("#" + objId).val()==''){
	   alert("请选择文件");
	   return ;
	}
    objName=$(obj).attr("name");
	fileId= $(obj).attr("id");				
	id=$(obj).attr("id");
    show_id = $(obj).attr("id");+"_show";
	upload_id = $(obj).attr("id");+"_upload";
	fileObject  = $(obj).clone(true);
	var appServer = "${appServer}";
	var root = "${root}";
	var url = appServer+'/res/o_swfupload.htm?root='+root;
	jQuery.ajaxFileUpload({
        url: url,
        secureuri:false,//一般设置为false
        fileElementId:fileId,//文件上传空间的id属性  
        dataType: 'json',//返回值类型 一般设置为json
        success: function (data, status)  //服务器成功响应处理函数
        {   
		    if(data.error==false){
		    	alert("上传失败");
		    }else{
		    	alert("上传成功");
		    	location.href="list.htm?root=${root}";
		    }
        },
        error: function (data, status, e)//服务器响应失败处理函数
        {
          //  alert(e);
        }
    });
}

function getTableForm() {
	return document.getElementById('tableForm');
}

function optDelete() {
	if(Pn.checkedCount('names')<=0) {
		alert("<@s.m 'error.checkRecord'/>");
		return;
	}
	if(!confirm('您确定删除吗？')) {return false;}
	
	var f = getTableForm();
	f.action="delete.htm";
	f.submit();
}
	
</script>
<div class="main">
	<div class="rhead">
		<div class="rpos">
			<@s.m "global.position"/>: <@s.m "resource.function"/> - <@s.m "global.list"/><#if parentChannel??> - ${parentChannel.name!}</#if>
		</div>
		<form id="formadd" class="ropt">
		</form>
		<div class="clear"></div>
	</div>
	<div class="searchBox">
    <h5><span></span></h5>


	<form method="post" enctype="multipart/form-data">
	<input type="hidden" name="root" value="${root}"/>

	<table border="0" style="padding-top:3px">
	<tr>
		<td valign="top" width="60px"><@s.m "resource.currentDir"/>: </td>
		<td align="left">${root}</td>
	</tr>
	
	<tr>
		<td>
			选择文件:
		</td>
		<td>
		<input type="file" name="Filedata"   id="fileUpload"/>
		<input type="button" onclick="ajaxUpload('fileUpload')" value="上传" class="btn" >
		</td>
	</tr>
	</table>
	</form>
	<form id="jvForm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="root" value="${root}"/>
	<table border="0" style="padding-top:3px">
		<tr>
		<td>
			<@s.m "resource.addDir"/>:
		</td>
		<td>
			<input type="text" name="dirName"  class="required" stringCheck="true" size="20" maxlength="20" onkeypress="if(event.keyCode==13){this.form.method='post';this.form.action='create_dir.htm';}"/>
			<input id="dirButton" class="btn" type="submit" value="<@s.m "resource.createDir"/>" onclick="this.form.method='post';this.form.action='create_dir.htm';"/>
		</td>
	</tr>
	<tr><td colspan="2"><div id="fsUploadProgress"></div></td></tr>
	</table>
	</form>
	</div>

	<div class="tool">
    <span>
	<a href="#" hidefocus="true" class="bt_add"  onclick="optDelete();"> <@s.m "global.delete"/></a>
	</span> <span>
	<a href="v_add.htm?root=${root}" hidefocus="true" class="bt_add" ><@s.m "global.add"/></a>
	</span>
  </div>

  <div class="listBox">
	<h5><span></span></h5>
	<form id="tableForm" method="post">
	<input type="hidden" name="root" value="${root}"/>
	<table width="100%">
      <tr>
        <th width="20" style="overflow: hidden;">
		<input type='checkbox' name='' value='' onclick='listCheckBoxAll("names",this.checked)'/>
		</th>
        <th></th>
        <th><@s.m "resource.filename"/></th>
        <th width="80"><@s.m "resource.size"/></th>
		<th width="120"><@s.m "resource.lastModified"/></th>
        <th width="120"><@s.m "global.operate"/></th>
      </tr>
      <#if query?? && query.items??>
		<#list query.items as res>
		      <tr  onmouseover="changeTrColor(this)" class="bg" #end><!--#if($velocityCount%2 == 0)-->
		      	<td><input type='checkbox' name='names' value='${res.filename}' /><#t/></td>
		      	<td width="20" align="center"><img src="${appServer}/images/file/${res.ico}.gif"/></td>
		        <td>
		        	<#if res.directory>
		        		<a href="list.htm?root=${res.rootPath}">${res.filename}</a>
		        	<#else>
		        		${res.filename}
		        	</#if>
		        </td>
		        <td> ${res.size} KB</td>
		        <td>
					${res.lastModifiedDate?string('yyyy-MM-dd HH:mm:ss')}
				</td>
				<td>
					<!-- 重命名 -->
					<a href="v_rename.htm?root=${root?url('utf-8')}&name=${res.rootPath?url('utf-8')}" class="pn-opt"><@s.m "resource.rename"/></a> |
					<!-- 修改-->
						<#if res.editable>
							<a href="v_edit.htm?root=${root?url('utf-8')}&name=${res.filename?url('utf-8')}" class="pn-opt"><@s.m "global.edit"/></a> |
						<#else>
							<@s.m "global.edit"/> |
						</#if>
					
					<!--删除 -->
					<a href="del_single.htm?root=${root?url('utf-8')}&name=${res.filename?url('utf-8')}" onclick="if(!confirm('<@s.m "global.confirm.delete"/>')) {return false;}" class="pn-opt"><@s.m "global.delete"/></a>
				</td>
		      </tr>
		</#list>
	</#if>
	</table></form>
</div>
<#include "/include/alert_message.ftl"/>
<#include "/include/foot.ftl"/>