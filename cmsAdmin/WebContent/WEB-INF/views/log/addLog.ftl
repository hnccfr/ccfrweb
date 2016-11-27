<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout>
<#include "/include/head.ftl"/>

此页面源文件在工程中的路径：/WEB-INF/views/log/addLog.ftl

	<br/>
	<br/>
<form name="logForm" action="${appServer.get('/log/addLog.htm')}" method="post">

	调用freemarker宏方法搞定表单的输入项
	id:<@s.formInput "log.id"/>
	
	<br/>
	
	按照velocity的方法处理
	<@s.bind "log.userId" />
	userid: <input type="text" name="${s.status.expression}" id="${s.status.expression}" value="${s.stringStatusValue}">
	
	<br/>
	这里的第一个参数是绑定的字段属性，第二个是input的属性，第三个是字段类型
	password:<@s.formInput "log.siteId" "class='css.class'" "password"/>
	<input type="hidden" name="q" value="${q?default("")}"/>
	<input type="submit" value="click">
</form>

<#include "/include/foot.ftl"/>
</@noeclp.layout>