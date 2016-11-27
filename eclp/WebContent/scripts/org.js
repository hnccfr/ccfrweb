$(function() {
	$.validator.setDefaults({
		submitHandler: function(form){
    		if( validatorSelf.cancelSubmit != null && !validatorSelf.cancelSubmit ){
    			$("#editForm").attr('action', $("#editForm").attr('action').replace( '/save.htm', '/help.htm') );
    		}
    		form.submit();
    	}
    });


	
	var validatorSelf = $("#editForm").validate( {
		rules : {
			remark : {
				required : false,
				maxlength : 85
			},
			name : {
				required : true,
				maxlength : 15
			}
		}
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

function getParent( ){
	var srcNode = parent.authTreeIframe.zTree1.getSelectedNode();
	if (!srcNode) {
		alert("请点击左侧树中“名称”进行选择！");
		return;
	}
	$("#parentId").val( srcNode.id );
	jQuery.ajax({
		async: false,
		type: "POST",
		url: $("#editForm").attr('action').replace( '/save.htm', '/getParentAll.htm' ),
		data: { id:srcNode.id },
		success: function( data ) {
			try {
				if(data.fullName!='')				
				   $("#parentAllName").val( data.fullName );
				else
				  $("#parentAllName").val( "/"+ srcNode.name );
				end
				
				
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
