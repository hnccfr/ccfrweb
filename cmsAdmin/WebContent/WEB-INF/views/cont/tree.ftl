<#include "/include/head.ftl"/>
<script type="text/javascript">
var setting = {
	isSimpleData : true,
	treeNodeKey : "id",//在isSimpleData格式下，当前节点id属性
	treeNodeParentKey : "pId",//在isSimpleData格式下，当前节点的父节点id属性
	showLine : true,
	checkable : false
};

var treeNodes = [
	{"id":"0", "pId":"-1", "name":"根目录", "url":"${appServer}/cont/list.htm", "open":"true", "target":"rightFrame"},
	<#list list as channel>
		{"id":${channel.id}, "pId":<#if channel.parentId??>${channel.parentId}<#else>0</#if>, "open":"true", "name":"${channel.channelName}", "url":"${appServer}/cont/list.htm?channelId=${channel.id}", "target":"rightFrame"}
		<#if channel_has_next>,</#if>
	</#list>
];

$(function(){
	zTree = $("#tree").zTree(setting, treeNodes);
});
</script>
<div class="main">
	<div class="lttop">
		<a href="javascript:location.href=location.href">刷新</a>
	</div>
	<hr/>
	<ul id="tree" class="tree" style="width:100%;height:100%overflow:auto;"></ul>
</div>
<#include "/include/foot.ftl"/>