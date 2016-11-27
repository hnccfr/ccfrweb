<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<#--
没有iframe
-->
<#if noiframe??&&noiframe>
<#import "/layout/layout.ftl" as noeclp>
<@noeclp.layout>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script type="text/javascript" src="${appServer.get('script/jquery.js')}"></script>
<#include "/include/head.ftl"/>
</head>
<body>
	<div class="tishi mt5">
		<div class="r-success">
			<h3><#if message??>${message}<#else>操作成功</#if></h3>
			<button class="button-s10" type="button" onclick="<#if url??>window.location.href=decodeURI('${appServer.get(url).addQueryData("q",q?default(''))}')<#else>history.go(-1);return false;</#if>">返回</button>
		</div>
	</div>
</body>
</html>
</@noeclp.layout>
<#else>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script type="text/javascript" src="${appServer.get('script/jquery.js')}"></script>
<#include "/include/head.ftl"/>
</head>
<body>
	<div class="tishi mt5">
		<div class="r-success">
			<h3><#if message??>${message}<#else>操作成功</#if></h3>
			<button class="button-s10" type="button" onclick="<#if url??>window.location.href=decodeURI('${appServer.get(url).addQueryData("q",q?default(''))}')<#else>history.go(-1);return false;</#if>">返回</button>
		</div>
	</div>
</body>
</html>
</#if>


