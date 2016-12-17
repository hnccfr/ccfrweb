$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	});    
	
	jQuery.validator.addMethod("isZip", function(value,element) {       
		var reg = /^\d{6}$/;
		return this.optional(element) || reg.test(value);
	},"�ʱ��������λ���֣�����ȷ��д");
	
	$("#addressOperateForm").validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		 rules: {    
			linkman: {    
            	 required	:	true,
            	 minlength	: 	2,
            	 maxlength	:	32
            },			
            phone:{
	           	 required	:	true,
	        	 maxlength	:	20
			},
			area:{
	           	 required	:	true
			},
			address:{
				required	:	true,
				maxlength	:	80
			},
			zipCode:{
				isZip		:	true
			},
			storehouse:{
				maxlength	:	30
			}
  		 },      
  		 messages: {    
  			linkman: {    
             	 required	: 	"����������" ,
             	 minlength	:	"��������Ϊ2λ" ,
             	 maxlength	:	"������󳤶Ȳ��ܳ���32λ"
            },			
            phone:{
				 required	:   "������绰����" ,
             	 maxlength	:	"�绰�����������������ȷ�ĵ绰����"
			},
			area:{
				 required	:   "��ѡ�������ڵ�����"
			},
			address:{
				required	:	"������������ϸ��ַ",
				maxlength	:	"���������ϸ��ַ��Ϣ̫�������Ϊ80���ַ�"
			},
			storehouse:{
				maxlength	:	"������Ĳֿ�����̫�������Ϊ30���ַ�"
			}
 		 }
 		});  
 });

/** ����isDefault��ֵ������ѡ����Ϊ"Y"��������Ϊ"N" */
function setDefault(){
	var tv = $('#isDefault').val();
	if($('#isDefault').attr("checked") == true){
		$('#isDefault').val("Y");
	}else{
		$('#isDefault').val("N");
	}
}

/** �޸��û�ָ���ĵ�ַ��Ϣʱ���õ�ַ��Ϣ���ص���Ӧ���� */
function modify(id){
	/**����jQuery��load�¼����޸ĵ�ҳ����ص�����ҳ����ȥ��������load�¼��е�function���û��Ƿ�ΪĬ�ϵ�ַ��ֵҲ����ȥ���ú� */
	//$("#div_content").load(appServer+"/user/address/operate.htm?id="+id,"",function(){if(isDefault == "Y"){document.getElementById("isDefault").checked = true;}else{document.getElementById("isDefault").checked = false;}});
	location.href = appServer+"/user/address/operate.htm?id="+id;
}

/** �޸�ʱ��ķ��ذ�ť��ֱ�ӷ��ص�����ҳ�� */
function goBackToAdd(){
	window.location.href = appServer + "/user/address/operate.htm?_m_=1001&type=P";
}

/** ͨ��ajax�첽ɾ���û�ָ�����ջ�/�ֿ��ַ��Ϣ */
function deleteById(id){
	if(confirm("ȷ��Ҫɾ���õ�ַ��")){
     	jQuery.ajax({
      		type	:   'POST',
       	 	url     :   appServer+'/user/address/delete.htm',
        	data   	:   {id   :   id},
        	success :   function(msg){
							if(msg == "OK"){
								/** ��̨���ص�msg��OK�Ļ�˵��ɾ���ɹ�������ʾ�û�ɾ���ɹ������ҽ�ҳ����ɾ����������Ϣ���� */
								document.getElementById(id).style.display = "none";
								document.getElementById("success").innerHTML = "ɾ���ɹ���";
								//document.getElementById("success").style.display = "block";
								//document.getElementById("succ").style.display = "none";
								//document.getElementById("err").style.display = "none";
							}else{
								/** ��̨���ص�msg��error�Ļ�˵��ɾ���ɹ�������ʾ�û�ɾ��ʧ�� */
								document.getElementById("error").innerHTML = "ɾ��ʧ�ܣ������ԣ�";
								document.getElementById("error").style.display = "block";
								document.getElementById("succ").style.display = "none";
								document.getElementById("err").style.display = "none";
							}	
                 		}
     	});
	}
}