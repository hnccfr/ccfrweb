function save(){
			$("#basephaseForm").submit();
	}
function reset(){
	$("#phaseCode").attr("value","");
	$("#phaseName").attr("value","");
	$("#state").attr("value","");
}

function del(url, id) {
	if(confirm('确认要删除？')){
	jQuery.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				data : "id="+id,
				success : function(data) {
					if (data.errorInfo && data.errorInfo.length > 0) {
						alert(data.errorInfo);
					} else {
						alert("删除成功!");
						$("#basePhaseSearchForm").submit();
					}
				},
				error : function() {
					alert("服务器忙，请稍后再试!");
				}
			});
	}
};

function disable(url, id) {
	if(confirm('确认要禁用？')){
	jQuery.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				data : "id="+id,
				success : function(data) {
					if (data.errorInfo && data.errorInfo.length > 0) {
						alert(data.errorInfo);
					} else {
						alert("禁用成功!");
						if($("#whichPage").length !=0 && $("#whichPage").val() == "next"){//下个交易日交易节页面禁用
							$("#basePhaseSearchForm").submit();
						}else{
							window.location.href = appServer + "/baseset/basephase/next.htm";//当前交易日交易节页面禁用
						}
					}
				},
				error : function() {
					alert("服务器忙，请稍后再试!");
				}
			});
	}
}

function enable(url, id) {
	jQuery.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				data : "id="+id,
				success : function(data) {
					if (data.errorInfo && data.errorInfo.length > 0) {
						alert(data.errorInfo);
					} else {
						alert("启用成功!");
						$("#basePhaseSearchForm").submit();
					}
				},
				error : function() {
					alert("服务器忙，请稍后再试!");
				}
			});

}