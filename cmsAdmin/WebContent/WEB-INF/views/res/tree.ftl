<#include "/include/head.ftl"/>
<script type="text/javascript">
var setting = {
	isSimpleData : true,
	treeNodeKey : "id",//在isSimpleData格式下，当前节点id属性
	treeNodeParentKey : "pId",//在isSimpleData格式下，当前节点的父节点id属性
	showLine : true,
	checkable : false
};
var treeNodes;
<#if resList??>
	treeNodes = [${resList}];
<#else>
	treeNodes = [];
</#if>

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