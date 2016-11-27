<#include "/include/head.ftl"/>
<script type="text/javascript">
function createIndex() {
	var button = $("#createButton");
	var value = button.val();
	var siteid = $("#siteId").val();
	button.val("<@s.m "cmsStatic.wait"/>").attr("disabled","disabled");
	$.getJSON("creatindex.htm",{siteId:siteid},function(data) {
		button.val(value).removeAttr("disabled");		
		if(data.success) {
			alert("<@s.m "global.success"/>");
		} else {
			alert(data.msg);			
		}
	});
}


function deleteIndex() {
	var button = $("#deleteButton");
	var siteid = $("#siteId").val();
	$.getJSON("deleteindex.htm",{siteId:siteid},function(data) {	
		if(data.success) {
			alert("<@s.m "global.success"/>");
		} else {
			alert("<@s.m "cmsStatic.fileNotExist"/>");			
		}
	});
}
</script>
</head>
<body>
<div class="body-box">
<div class="rhead">
	<div class="rpos"><@s.m "global.position"/>: <@s.m "cmsStatic.function"/> - <@s.m "cmsStatic.index"/></div>
	<div class="clear"></div>
</div>

 <div class="formBox"><h3><i></i><span></span></h3>
<form id="jvForm" method="post">
<input type="hidden" id="siteId" name="siteId" value="${siteId!}"/>
<div class="form-but"><!-- 表单按钮区 -->
	<input id="createButton"  class="button-s4" type="button" value="<@s.m "cmsStatic.indexStatic"/>" onclick="createIndex();"/>
&nbsp; <input id="deleteButton"  class="button-s4" type="button" value="<@s.m "cmsStatic.indexRemove"/>" onclick="deleteIndex();"/>
</div>
</form></div>
</div>
</body>
</html>