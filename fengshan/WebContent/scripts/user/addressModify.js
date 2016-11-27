$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	});    
	
	jQuery.validator.addMethod("isZip", function(value,element) {       
		var reg = /^\d{6}$/;
		return this.optional(element) || reg.test(value);
	},"邮编必须是六位数字，请正确填写");
	
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
             	 required	: 	"请输入姓名" ,
             	 minlength	:	"姓名至少为2位" ,
             	 maxlength	:	"姓名最大长度不能超过32位"
            },			
            phone:{
				 required	:   "请输入电话号码" ,
             	 maxlength	:	"电话号码过长，请输入正确的电话号码"
			},
			area:{
				 required	:   "请选择您所在的区域"
			},
			address:{
				required	:	"请输入您的详细地址",
				maxlength	:	"您输入的详细地址信息太长，最多为80个字符"
			},
			storehouse:{
				maxlength	:	"您输入的仓库名称太长，最多为30个字符"
			}
 		 }
 		});  
 });

/** 设置isDefault的值，当被选中设为"Y"，否则设为"N" */
function setDefault(){
	var tv = $('#isDefault').val();
	if($('#isDefault').attr("checked") == true){
		$('#isDefault').val("Y");
	}else{
		$('#isDefault').val("N");
	}
}

/** 修改用户指定的地址信息时将该地址信息加载到对应项中 */
function modify(id){
	/**调用jQuery的load事件将修改的页面加载到整个页面中去，并且用load事件中的function将用户是否为默认地址的值也传过去设置好 */
	//$("#div_content").load(appServer+"/user/address/operate.htm?id="+id,"",function(){if(isDefault == "Y"){document.getElementById("isDefault").checked = true;}else{document.getElementById("isDefault").checked = false;}});
	location.href = appServer+"/user/address/operate.htm?id="+id;
}

/** 修改时候的返回按钮，直接返回到新增页面 */
function goBackToAdd(){
	window.location.href = appServer + "/user/address/operate.htm?_m_=1001&type=P";
}

/** 通过ajax异步删除用户指定的收货/仓库地址信息 */
function deleteById(id){
	if(confirm("确定要删除该地址吗？")){
     	jQuery.ajax({
      		type	:   'POST',
       	 	url     :   appServer+'/user/address/delete.htm',
        	data   	:   {id   :   id},
        	success :   function(msg){
							if(msg == "OK"){
								/** 后台返回的msg是OK的话说明删除成功，则提示用户删除成功，并且将页面中删除的那条信息隐藏 */
								document.getElementById(id).style.display = "none";
								document.getElementById("success").innerHTML = "删除成功！";
								//document.getElementById("success").style.display = "block";
								//document.getElementById("succ").style.display = "none";
								//document.getElementById("err").style.display = "none";
							}else{
								/** 后台返回的msg是error的话说明删除成功，则提示用户删除失败 */
								document.getElementById("error").innerHTML = "删除失败，请重试！";
								document.getElementById("error").style.display = "block";
								document.getElementById("succ").style.display = "none";
								document.getElementById("err").style.display = "none";
							}	
                 		}
     	});
	}
}