<#if accessType=="eclp">
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
		<frameset cols="240,*" frameborder="0" border="0" framespacing="0">
			<frame src="${appServer.get('/permuser/tree.htm')}" name="leftFrame" noresize="noresize" id="leftFrame" />
			<frame src="${appServer.get('/permuser/list.htm')}" name="rightFrame" id="rightFrame" />
		</frameset>
		<noframes>
			<body>
				您的浏览器不支持框架结构，请使用IE等支持框架结构的浏览器！
			</body>
		</noframes>
	</html>
<#else>
	<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="会员投稿权限" path="" curPath="会员投稿权限">
	<iframe src="${appServer}/permuser/tree.htm" name="leftFrame" scrolling="auto"  id="leftFrame"  width="200"  height="600" frameborder="0"></iframe>
	<iframe src="${appServer}/permuser/list.htm" name="rightFrame" scrolling="auto"  id="rightFrame" height="600" width="625"  frameborder="0"></iframe>
	</@noeclp.layout>
</#if>