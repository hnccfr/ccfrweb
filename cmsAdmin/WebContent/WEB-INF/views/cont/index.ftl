<#if accessType=="eclp">
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>hseccms-main</title>
	</head>
	<frameset cols="240,*" frameborder="0" border="0" framespacing="0">
		<frame src="${appServer}/cont/tree.htm" name="leftFrame" noresize="noresize" id="leftFrame" />
		<frame src="${appServer}/cont/list.htm" name="rightFrame" id="rightFrame" />
	</frameset>
	<noframes>
	<body></body>
	</noframes>
	</html>
<#else>
	<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="文章管理" path="/cont/index.htm" curPath="文章管理">
	<#--
	<iframe src="${appServer}/cont/tree.htm" name="leftFrame" scrolling="auto"  id="leftFrame"  width="200"  height="600" frameborder="0"></iframe>
	-->
	<iframe src="${appServer}/cont/list.htm" name="rightFrame" scrolling="auto"  id="rightFrame" height="800" width="832"  frameborder="0"></iframe>
	</@noeclp.layout>
</#if>