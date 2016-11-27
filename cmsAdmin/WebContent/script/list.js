
//增加列复选框功能	sunjin	20130219
function listCheckBoxAll( name, checked ) {
	$("input[type=checkbox][name='" + name + "']").each(function(){
		$(this).attr("checked", checked );
	});
}
//获取列复选框选中功能	sunjin	20130219
function selCheckbox( name, prompt ){
	var notSel = true;
	$("input[type=checkbox][name='" + name + "']").each(
		function(){
			if( $(this).attr("checked") ){
				notSel = false;
			}
		}
	);
	if( notSel ){
		if( prompt != null && prompt != '' ){
			alert( prompt );
		}else{
			alert( '请选择欲操作项！' );
		}
		return false;
	}
	return true;
}
