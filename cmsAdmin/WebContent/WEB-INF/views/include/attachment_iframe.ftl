<#include "/include/head.ftl"/>
<script type="text/javascript">
<#if error??>
alert('${error}');
<#else>
parent.document.getElementById('attachmentPaths${attachmentNum}').value='${attachmentPath}';
parent.document.getElementById('attachmentNames${attachmentNum}').value='${attachmentName}';
parent.document.getElementById('attachmentFilenames${attachmentNum}').value='${attachmentName}';
</#if>
</script>
</head>
<body>
</body>
</html>