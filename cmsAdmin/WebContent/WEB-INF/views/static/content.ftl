<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function() {
	$("#jvForm").validate( {
		submitHandler : function(form) {
			var button = $("#createButton");
			var value = button.val();
			button.val("<@s.m "cmsStatic.wait"/>").attr("disabled","disabled");
			$(form).ajaxSubmit( {
				"success" : function(data) {
					button.val(value).removeAttr("disabled");
					if(data.success) {
						alert("<@s.m "cmsStatic.success"/>"+data.count);
					} else {
						alert(data.msg);
					}
				},
				"dataType" : "json"
			});
		}
	});
});
</script>
</head>
<body>
<div class="body-box">
<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>: <@s.m "cmsStatic.function"/> - <@s.m "cmsStatic.content"/></div>
	<div class="clear"></div>
</div>

 <div class="formBox"><h3><i></i><span></span></h3>
<form id="jvForm" action="creatcontent.htm">
<input type="hidden" name="siteId" value="${siteId!}"/>
<div class="content">
<table class="c2">
<tr>
<th><@s.m "cmsStatic.channel"/>：</th>
<td><select id="channelId" name="channelId" style="width:300px">
					<option value="">--所有栏目--</option>
	<#if wholeChannelList??>
	<#list wholeChannelList as c>
	<option value="${c.id}">
	<#if c.level gt 1>
	<#list 2..c.level as i>&nbsp;&nbsp;</#list>
	>
	</#if>
	${c.channelName}
	</option>
	</#list>
	</#if>
	</select>
</td>
</tr>
<tr>
<th><@s.m "cmsStatic.startDate"/>：</th><td><input  name="startDate"  type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate "/>
</td></tr>
</table>
</div>
<div class="form-but"><!-- 表单按钮区 -->
	<input id="createButton" class="button-s4"  type="submit" value="<@s.m "cmsStatic.contentStatic"/>"/>
	</div>

</form></div>
</div>
</body>
</html>