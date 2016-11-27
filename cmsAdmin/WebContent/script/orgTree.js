$(function() {
	$("input[name='showType']").change(function() {
		window.location.href = appServer + "/org/tree.htm?showType=" + this.value
			+ "&showUsing=" + $("input[name='showUsing']:checked").val();
   	});
	$("input[name='showUsing']").change(function() {
		window.location.href = appServer + "/org/tree.htm?showUsing=" + this.value 
			+ "&showType=" + $("input[name='showType']:checked").val();
   	});
});

$(document).ready(function(){
	refreshTree();
});

var IDMark_Switch = "_switch";
var IDMark_Icon = "_ico";
var IDMark_Span = "_span";
var IDMark_Input = "_input";
var IDMark_Check = "_check";
var IDMark_Edit = "_edit";
var IDMark_Remove = "_remove";
var IDMark_Ul = "_ul";
var IDMark_A = "_a";

var zTree1;
var setting;
//var zNodes =[];
setting = {
	rootPID : -1,
//	editable : true,
//	edit_renameBtn : setRenameBtn,
//	edit_removeBtn : false,
	checkable: true,
	checkType:{ "Y": "s", "N": "s" },
	async: true,
	asyncUrl: appServer + "/org/treeContent.htm",  //获取节点数据的URL地址
	asyncParam: ["pId","id"],  //获取节点数据时，必须的数据名称，例如：id、name
	asyncParamOther: ["showUsing", "$!{showUsing}" ],
	addHoverDom: addHoverDom,
	removeHoverDom: removeHoverDom,
	callback:{
//		beforeRename: zTreeBeforeRename,
		asyncSuccess: zTreeOnAsyncSuccess,
		asyncError: zTreeOnAsyncError
	},
	iconTypes: iconArray
};
var opreatePool = [];
var lastNode = null;
var poolCursor = -1;
var poolMax = 20;

function isParent( treeNode ){
	if( treeNode.type == "4" ){
		return false;
	}
	result = true;
	jQuery.ajax({
		async: false,
		type: "POST",
		url: appServer + "/org/isParent.htm",
		data: { subSystemId:treeNode.pId, id:treeNode.id },
		success: function( data ) {
			try {
				result = data;
			} catch(err) {
				result = false;
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			result = false;
		}
	});
	return result;
}

function zTreeOnAsyncSuccess(event, treeId, treeNode, msg) {
	if (treeNode) {
		$("#onAsyncSuccessNode").html( "[" + getTime() + "]  treeId=" + treeId + ";<br/>&nbsp;tId=" + treeNode.tId + "; Name=" + treeNode.name );
	} else {
		$("#onAsyncSuccessNode").html( "[" + getTime() + "]  treeNode is Root!");
	}
}

function zTreeOnAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
	if (treeNode) {
		$("#onAsyncErrorNode").html( "[" + getTime() + "]  treeId=" + treeId + ";<br/>&nbsp;tId=" + treeNode.tId + "; Name=" + treeNode.name );
	} else {
		$("#onAsyncErrorNode").html( "[" + getTime() + "]  treeNode is Root!");
	}
}

function refreshTree(asyncUrl) {
	$("#getUrl").html("");
	$("#onAsyncSuccessNode").html("<br/>");
	$("#onAsyncErrorNode").html("<br/>");
//	zNodes =[
// 		#direct($!{subSysList})
//	];
	zTree1 = $("#treeDemo").zTree(setting, zNodes);
}

function reloadAsync() {
	var treeNode = zTree1.getSelectedNode();
	if (!treeNode) {
		alert("请先选中一个节点");
		return;
	}
	zTree1.reAsyncChildNodes(treeNode, "add");
}

function refreshAsync( tId ) {
	var treeNode = zTree1.getNodeByParam( "id", tId );
	if( treeNode ){
   		var hasParent = isParent( treeNode );
   		treeNode.isParent = hasParent;
		zTree1.reAsyncChildNodes(treeNode, "refresh");
		if( !hasParent ){
			zTree1.updateNode(treeNode, true);
		}
	}
}

function getTime() {
	var now= new Date();
	var hour=now.getHours();
	var minute=now.getMinutes();
	var second=now.getSeconds();
	return (hour+":"+minute+":"+second);	
}

function expandAll(expandSign) {
	zTree1.expandAll(expandSign);
}

function moveTreeNode(move) {
	var srcNode = zTree1.getSelectedNode();
	if (!srcNode) {
		alert("请先选中一个节点");
		return;
	}
	var moveType = "inner";
	var targetNode = "";
	if (move == "up") {
		moveType = "before";
		targetNode = getPreTreeNode(srcNode);
	} else if (move == "down") {
		moveType = "after";
		targetNode = getNextTreeNode(srcNode);
	}
	if (srcNode && targetNode) {
		setOperatePool();
		zTree1.moveNode(targetNode, srcNode, moveType);
	}	
	getNodes();
	zTree1.selectNode(srcNode);
}

function getPreTreeNode(treeNode) {
	if (treeNode.isFirstNode) return null;
	var nodes = treeNode.parentNode ? treeNode.parentNode.nodes : zTree1.getNodes();
	var preNode;
	for (var i=0; i<nodes.length; i++) {
		if (nodes[i] == treeNode) {
			return preNode;
		}
		preNode = nodes[i];
	}
}

function getNextTreeNode(treeNode) {
	if (treeNode.isLastNode) return null;
	var nodes = treeNode.parentNode ? treeNode.parentNode.nodes : zTree1.getNodes();
	for (var i=0; i<nodes.length; i++) {
		if (nodes[i] == treeNode) {
			return nodes[i+1];
		}
	}
}

function setOperatePool(nodes) {
	var n = nodes ? nodes : clone(zTree1.getNodes());
	opreatePool.splice(poolCursor+1, (opreatePool.length-poolCursor-1), n);
	if (opreatePool.length>poolMax) {
		opreatePool.splice(0,1);
	}
	poolCursor = opreatePool.length-1;
	refreshOperatePool();
	lastNode = null;
}

function refreshOperatePool() {
	if (poolCursor>=0) {
		$("#jRollback").attr("class","able");
	} else {
		$("#jRollback").attr("class","disabled");
	}
	if (poolCursor<(opreatePool.length-1)) {
		$("#jRedo").attr("class","able");
	} else {
		$("#jRedo").attr("class","disabled");
	}
	$("#jOperatePool").html("操作记录: " + opreatePool.length + ", 游标位置: " + (poolCursor+1));
}

function getNodes() {
	var a = zTree1.transformToArray(zTree1.getNodes());
	$("#allNum").html(a.length);
	a = zTree1.getCheckedNodes();
	$("#allCheckNum").html(a.length);
}

function addHoverDom(treeId, treeNode) {
	var aObj = $("#" + treeNode.tId + IDMark_A);
	if (treeNode.define == 2 ) {
		if ($("#diyBtn_"+treeNode.id).length>0) return;
		var editStr = "<span id='diyBtn_space_" +treeNode.id+ "' >&nbsp;</span><button type='button' class='diyBtn1' id='diyBtn_" +treeNode.id+ "' title='"+treeNode.name+"' onfocus='this.blur();'></button>";
		aObj.append(editStr);
		var btn = $("#diyBtn_"+treeNode.id);
		if (btn) btn.bind("click", function(){parent.authMainIframe.location.href = appServer + "/org/edit.htm?id=" + treeNode.id;});
	}
}
	
function removeHoverDom(treeId, treeNode) {
	$("#diyBtn_"+treeNode.id).unbind().remove();
	$("#diyBtn_space_" +treeNode.id).unbind().remove();
}



function doAdd(){
	parent.authMainIframe.location.href = appServer + "/org/add.htm";
}

function refresh(){
	window.location.href = appServer + "/org/tree.htm?showType=" + $("input[name='showType']:checked").val()
	 	 + "&showUsing=" + $("input[name='showUsing']:checked").val();
}
function doHelp(){
	parent.authMainIframe.location.href = appServer + "/org/help.htm";
}