<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#if accessType=="eclp">
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>hseccms-main</title>
	</head>
	<frameset cols="240,*" frameborder="0" border="0" framespacing="0">
		<frame src="${appServer}/res/tree.htm?root=source" name="leftFrame" noresize="noresize" id="leftFrame" />
		<frame src="${appServer}/res/list.htm?root=" name="rightFrame" id="rightFrame" />
	</frameset>
	<noframes>
	<body></body>
	</noframes>
	</html>
<#else>
<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="资源管理" path="" curPath="资源管理">
	<iframe src="${appServer}/res/tree.htm?root=source" name="leftFrame" scrolling="auto"  id="leftFrame"  width="189"  height="600" frameborder="0" style="border-right:1px solid #A7B9D1;"></iframe>
	<iframe src="${appServer}/res/list.htm?root=" name="rightFrame" scrolling="auto"  id="rightFrame" height="600" width="627"  frameborder="0"></iframe>
	</@noeclp.layout>
</#if>

