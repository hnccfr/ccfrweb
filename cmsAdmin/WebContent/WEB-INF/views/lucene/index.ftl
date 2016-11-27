<#include "/include/head.ftl"/>
<script type="text/javascript">
function luceneSubmit(value) {
	if(!checkInput()){
		resetButton(value);
		return false;
	}
	$.post("${appServer.get('/lucene/create.htm')}", {
		"startDate" : $("#startDate").val(),
		"endDate" : $("#endDate").val(),
		"max" : $("#max").val(),
		//"siteId" : $("#siteId").val(),
		"channelId" : $("#channelId").val(),
		"startId" : $("#startId").val()
	}, function(data) {
		if(data.success) {
			if(data.lastId && $("#stop").val()=="") {
				$("#startId").val(data.lastId);
				luceneSubmit(value);
			} else {
				$("#startId").val("");
				alert("<@s.m "global.success"/>");
				$("#submitButton").val(value).removeAttr("disabled");
				$("#cancelButton").attr("disabled","disabled");
				$("#stop").val("");
			}
		} else {
			alert(data.msg);
			$("#submitButton").val(value).removeAttr("disabled");
			$("#cancelButton").attr("disabled","disabled");
			$("#stop").val("");
		}
	}, "json");
}

$(function() {
	$("#jvForm").validate( {
		submitHandler : function(form) {
			var button = $("#submitButton");
			var value = button.val();
			button.val("<@s.m "cmsStatic.wait"/>").attr("disabled","disabled");
			$("#cancelButton").removeAttr("disabled");
			$("#stop").val("");		
			luceneSubmit(value);
		}
	});
});

function resetButton(value){
	$("#submitButton").val(value).removeAttr("disabled");
	$("#cancelButton").attr("disabled","disabled");
}

function checkInput(){
	if($("#startDate").val()==""){
		alert("请输入开始时间！");
		return false;
	}
	if($("#endDate").val()==""){
		alert("请输入结束时间！");
		return false;
	}
	if($("#startDate").val() > $("#endDate").val() ){
		alert("输入开始时间不能大于结束时间！");
		return false;
	}
	if($("#max").val()<10|| $("#max").val()>1000){
		alert("请输入<@s.m "cmsLucene.max"/>[10-1000的数字]");
		return false;
	}
	return true;
}
function checkValue(obj){
	if(obj.value==null || obj.value=="" ){
		alert("请输入<@s.m "cmsLucene.max"/>[10-1000的数字]");
		obj.focus();
		return;
	}
	if(obj.value>1000){
		alert("请输入不大于1000的数字");
		return;
	}
	if(obj.value<10){
		alert("请输入大于10的数字");
		return;
	}
	
}
</script>
<div class="body-box">
<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>: <@s.m "cmsLucene.function"/></div>
	<form class="ropt">
	</form>
	<div class="clear"></div>
</div>
 <div class="formBox"><h3><i></i><span></span></h3>
 <form id="jvForm" action="${appServer.get('/lucene/create.htm')}" method="post">
 <div class="content">

<table class="c2">
		     		<tr>
<th><@s.m "cmsLucene.channelId"/>：</th>

<td><select id="channelId" name="channelId">
	<option value="">---全部---</option>
	<#if channelList??>
	<#list channelList as c>
		<option value="${c.id}" <#if channelId?? && c.id == channelId>selected="selected"</#if> >
		<#if c.level gt 1>
			<#list 2..c.level as i>&nbsp;</#list>
			>
		</#if>
		${c.channelName}
		</option>
	</#list>
	</#if>
</select></td>
</tr>
<tr><th><@s.m "cmsLucene.startDate"/>：</th><td><input id="startDate" name="startDate"  class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></td></tr>
<tr><th><@s.m "cmsLucene.endDate"/>：</th><td><input id="endDate" name="endDate" class="Wdate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td></tr>
<tr><th><@s.m "cmsLucene.max"/>：</th><td><input id="max" name="max" type="text" class="required digits" onblur="checkValue(this)"/>
<p>
	<#--<input type="hidden" id="siteId" name="siteId" value="${site.id}"/>-->
	<input type="hidden" id="startId" name="startId"/>
	<input type="hidden" id="stop" value=""/>
	
</p></table>
</div>
<div class="form-but"><!-- 表单按钮区 -->
	<input type="submit" class="button-s4"  id="submitButton" value="<@s.m "cmsLucene.createIndex"/>"/>
&nbsp; <input type="button" class="button-s4"  id="cancelButton" value="<@s.m "global.cancel"/>" disabled="disabled" onclick="$('#stop').val('1')"/>
</div>
</form></div>
</div>

<#include "/include/foot.ftl"/>