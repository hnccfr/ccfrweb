function save(){
			$("#basephaseForm").submit();
	}
function reset(){
	$("#phaseCode").attr("value","");
	$("#phaseName").attr("value","");
	$("#state").attr("value","");
}

function del(url, id) {
	if(confirm('ȷ��Ҫɾ����')){
	jQuery.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				data : "id="+id,
				success : function(data) {
					if (data.errorInfo && data.errorInfo.length > 0) {
						alert(data.errorInfo);
					} else {
						alert("ɾ���ɹ�!");
						$("#basePhaseSearchForm").submit();
					}
				},
				error : function() {
					alert("������æ�����Ժ�����!");
				}
			});
	}
};

function disable(url, id) {
	if(confirm('ȷ��Ҫ���ã�')){
	jQuery.ajax({
				type : "POST",
				url : url,
				dataType : "json",
				data : "id="+id,
				success : function(data) {
					if (data.errorInfo && data.errorInfo.length > 0) {
						alert(data.errorInfo);
					} else {
						alert("���óɹ�!");
						if($("#whichPage").length !=0 && $("#whichPage").val() == "next"){//�¸������ս��׽�ҳ�����
							$("#basePhaseSearchForm").submit();
						}else{
							window.location.href = appServer + "/baseset/basephase/next.htm";//��ǰ�����ս��׽�ҳ�����
						}
					}
				},
				error : function() {
					alert("������æ�����Ժ�����!");
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
						alert("���óɹ�!");
						$("#basePhaseSearchForm").submit();
					}
				},
				error : function() {
					alert("������æ�����Ժ�����!");
				}
			});

}