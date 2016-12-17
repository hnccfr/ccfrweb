<html>
	<head>
		<title>Welcome!</title>
	</head>
	<body>
		<h1>Welcome ${user} !</h1>
		<@cms_tag_list count='8'>
			<#list tag_list as tag>
			<a href="http://www.cms2.com:8080/tag/<#if tag?exists>${tag.id?default(1)}.jspx<#else>unexists.htm</#if>"><#if tag?exists>${tag.tagName}<#else>unknow</#if></a>
			</#list>
		</@cms_tag_list>
		<h1>ip ${ip} !</h1>
		<h4>id：${settlerAgent.getUserId()}</h4>
		<h4>帐号：${settlerAgent.getAccount()}</h4>
		<h4>类型：${settlerAgent.getUserType()}</h4>
		<h4>电子邮件：${settlerAgent.getEmail()}</h4>
		<h4>姓名：${settlerAgent.getUserName()}</h4>
		<h4>手机：${settlerAgent.getMobile()}</h4>
		<h4>会员组（类型）：${settlerAgent.getMemberType()}</h4>
	</body>
</html>