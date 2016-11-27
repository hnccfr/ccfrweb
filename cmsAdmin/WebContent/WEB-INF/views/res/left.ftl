<#include "/include/head.ftl"/>
<script type="text/javascript">
$(function(){
	
	$("#tree1").treeview({
		url: "tree.htm?root="
	});
});
</script>
</head>
<body class="main">
<div class="lttop">
	<a href="javascript:location.href=location.href"><@s.m "global.refresh"/></a>
</div>
<hr/>
<ul id="tree1" class="filetree"></ul>
<#include "/include/foot.ftl"/>