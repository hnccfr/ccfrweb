<#macro layout>
<#if accessType=="eclp">
<#nested />
<#else>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>&#23425;&#27874;&#33322;&#36816;&#35746;&#33329;&#24179;&#21488;-&#28023;&#36816;&#35746;&#33329;,&#28023;&#36816;&#36153;&#26597;&#35810;,&#22312;&#32447;&#35746;&#33329;&#20132;&#26131;&#24179;&#21488;</title>
	<link href="${appServer.get('/css/nbhy/common.css')}" rel="stylesheet" />
	<script type="text/javascript" src="${appServer.get('script/jquery.js')}"></script>
</head>
	<body>
    <div class="body950">
        <#include "/layout/nbse/nbse_top.ftl"/>
        <!-- 内容 -->
    	<div class="body-main">
            <#include "/layout/nbse/nbse_menu.ftl"/>
            <div class="main-right">
    		<#nested />
    		</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>
</#if>
</#macro>

<#macro layout title="" path="" curPath="">
<#if accessType=="eclp">
<#nested />
<#else>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<title>&#23425;&#27874;&#33322;&#36816;&#35746;&#33329;&#24179;&#21488;-&#28023;&#36816;&#35746;&#33329;,&#28023;&#36816;&#36153;&#26597;&#35810;,&#22312;&#32447;&#35746;&#33329;&#20132;&#26131;&#24179;&#21488;<#if title??>-${title}</#if></title>
	<link href="${appServer.get('/css/nbhy/common.css')}" rel="stylesheet" />
	<script type="text/javascript" src="${appServer.get('script/jquery.js')}"></script>
</head>
	<body>
    <div class="body950">
        <#include "/layout/nbse/nbse_top.ftl"/>
        <!-- 内容 -->
    	<div class="body-main">
            <#include "/layout/nbse/nbse_menu.ftl"/>
            <div class="main-right">
    		<#nested />
    		</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>
</#if>
</#macro>