<#import "/include/spring.ftl" as s />
<#if accessType=="eclp">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</#if>
<#if accessType=="eclp">
	<link rel="stylesheet" href="${appServer.get('css/eclp/admin.css')}" />
    <link rel="stylesheet" href="${appServer.get('css/eclp/basic.css')}" />
	<script type="text/javascript" src="${appServer.get('script/eclp/common.js')}"></script>
<#else>
	
	<link rel="stylesheet" href="${appServer.get('css/nbhy/admin.css')}" />
    <link rel="stylesheet" href="${appServer.get('css/nbhy/basic.css')}" />
    <link rel="stylesheet" href="${appServer.get('css/nbhy/skin-one_1.css')}" />
    <script type="text/javascript" src="${appServer.get('script/nbhy/common.js')}"></script>
</#if>
<link rel="stylesheet" href="${appServer.get('css/zTreeStyle.css')}" />
<link rel="stylesheet" href="${appServer.get('css/themes/cupertino/jquery.ui.css')}" />

<script type="text/javascript" src="${appServer.get('script/My97DatePicker/WdatePicker.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/fckeditor/fckeditor.js')}"></script>


<script type="text/javascript" src="${appServer.get('script/jquery-1.4.2.min.js')}"></script>
<!--
<script type="text/javascript" src="${appServer.get('script/jquery.ext.js')}"></script>
-->
<script type="text/javascript" src="${appServer.get('script/jquery-show.js')}"></script>
<!--
<script type="text/javascript" src="${appServer.get('script/jquery-ui-1.6.custom.min.js')}"></script>
-->
<script type="text/javascript" src="${appServer.get('script/jquery.js')}"></script>

<script type="text/javascript" src="${appServer.get('script/jquery.bgiframe.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/jquery.form.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/jquery.metadata.js')}"></script>
<!--
<script type="text/javascript" src="${appServer.get('script/jquery.validate.js')}"></script>
-->
<script type="text/javascript" src="${appServer.get('script/jquery.validate.min.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/jquery.ztree-2.6.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/kvaTree.min.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/kvaTree.js')}"></script>

<!--增加百度编辑器的脚本-->
<script type="text/javascript" src="${appServer.get('script/ueditor/ueditor.config.js')}"></script>
<script type="text/javascript" src="${appServer.get('script/ueditor/ueditor.all.min.js')}"></script>

<script type="text/javascript" src="${appServer.get('script/hundsun.validate.js')}"></script>
<!--
<script type="text/javascript" src="${appServer.get('script/menuTree.js')}"></script>
-->
<script type="text/javascript" src="${appServer.get('script/list.js')}"></script>
