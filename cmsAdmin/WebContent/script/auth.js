$(function() {
	
//	jQuery.validator.addMethod("urlStyle", 
//			function(value, element) {
//		     if($('#type').val()=='3'){
//				var urlStyle = /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i;
//				return this.optional(element) || (urlStyle.test(value));
//	         }
//		     else 
//		    	 return true;
//			},"请输入合法的网址");

	
	var validatorSelf = $("#editForm").validate( {
		rules : {
			code : {
				required : true,
				digits : true,
				max : 999999
			},
			name : {
				required : true,
				maxlength : 20
			},
			parentAllNameExt : {
				required : true
			},
			urlAll : {
				required : function() { 
					if( $("#type").val( ) == "3" ) return true;
					else return false;
				},
//				urlStyle : true,
				maxlength : 100
			},
			sort : {
				required : true,
				digits : true,
				min : 1,
				max : 999
			}
		}
	});
	
	$("#type").change(function(){
		showDetail(  );
	});
	
	$("#openType").change(function(){
		showDetailUrl(  );
	});
	
	showDetail( );
	
});

function showDetail( ){
	if( $("#type").val() == "2" ){
		$( "#trOpenType" ).hide();
		$( "#trUrl" ).hide();
	}else if( $("#type").val() == "3" ){
		$( "#trOpenType" ).show();
		$( "#trUrl" ).show();
		showDetailUrl();
	}else if( $("#type").val() == "4" ){
		$( "#trOpenType" ).hide();
		$( "#trUrl" ).hide();
		$( "#urlPrefix" ).hide();
	}
}
function showDetailUrl(  ){
	if( $("#openType").val() == "1" ){
		$( "#urlPrefix" ).hide();
	} else{
		$( "#urlPrefix" ).show();
	}
}
function getParent( ){
	var srcNode = parent.authTreeIframe.zTree1.getSelectedNode();
	if (!srcNode) {
		alert("请点击左侧树中“名称”进行选择！");
		return;
	}
	if( $("#id").val() == srcNode.id ){
		alert("父权限不能是自己！");
		return;
	}
	if( $("#type").val() == '2' ){
		if( srcNode.type != '1' &&  srcNode.type != '2' ){
			alert( "类型为“菜单组”的权限，父权限只能是“菜单组”或“子系统”！" );
			return;
		}
	}else if( $("#type").val() == '3' ){
		if( srcNode.type != '1' &&  srcNode.type != '2' ){
			alert( "类型为“菜单”的权限，父权限只能是“菜单组”或“子系统”！" );
			return;
		}
	}else if( $("#type").val() == '4' ){
		if( srcNode.type != '3' ){
			alert( "类型为“操作”的权限，父权限只能是“菜单”！" );
			return;
		}
	}
	$("#parentId").val( srcNode.id );
	jQuery.ajax({
		async: false,
		type: "POST",
		url: $("#editForm").attr('action').replace( '/save.htm', '/getParentAll.htm' ),
		data: { id:srcNode.id },
		success: function( data ) {
			try {
				if( data.openType == 2 ){
					alert( "父权限的打开方式为“弹出”，无法在弹出的权限下建子权限！" );
					return;
				}else if( data.openType == 3 ){
					alert( "父权限的打开方式为“页面跳转”，无法在页面跳转的权限下建子权限！" );
					return;
				}
				$("#parentAllName").val( data.parentAllName + "/" + srcNode.name );
				$("#parentAllNameExt").val( $("#parentAllName").val() );
			} catch(err) {
				result = false;
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			result = false;
		}
	});
}
