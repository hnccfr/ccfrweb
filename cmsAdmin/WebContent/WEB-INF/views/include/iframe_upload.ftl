<#include "/include/head.ftl"/>
<script type="text/javascript">


<#if error??>
alert('${error}');
<#else>
parent.document.getElementById("uploadImgPath${uploadNum}").value="${uploadPath}";
var imgSrc = parent.document.getElementById("preImg${uploadNum}");
if(!$(imgSrc).attr("noResize")) {
	$(imgSrc).css("width","100px");
	$(imgSrc).css("height","70px");
}
var path = '${uploadPath}';
if(path.indexOf("?")==-1) {
	$(imgSrc).attr("src",path+"?d="+new Date()*1);
} else {
	$(imgSrc).attr("src",path+"&d="+new Date()*1);
}
parent.document.getElementById("hiddenName${uploadNum}").name="${hiddenName}";
parent.document.getElementById("hiddenName${uploadNum}").value="${uploadPath}";
</#if>
</script>
</head>
<body>
</body>
</html>