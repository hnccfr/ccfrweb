/**
 * �û�����js
 * @author xiejh
 * @email xiejh@hundsun
 * @version v0.1
 */

/**
 * �˺���������Ƶ�������ʱ�����Ķ���
 * @param obj
 * @return
 */
function sh(obj){	
	if($(obj).index()<3)
	{
		$(obj).prevAll().attr("src",imageServer+"/images/evaluate/pj3.png")
		$(obj).attr("src",imageServer+"/images/evaluate/pj3.png")
		$(obj).nextAll().attr("src",imageServer+"/images/evaluate/pj1.png")
	}
	else
	{
		$(obj).prevAll().attr("src",imageServer+"/images/evaluate/pj2.png")
		$(obj).attr("src",imageServer+"/images/evaluate/pj2.png")
		$(obj).nextAll().attr("src",imageServer+"/images/evaluate/pj1.png")
	}
}

/**
 * �˺���������뿪����ʱ������Ķ���
 * @param obj ������ڵ�Ԫ��
 * @return
 */
function normal(obj){
	var objId = $(obj).attr("name");//��ȡ��ǰimgԪ�ص�nameֵ
	var score = $("#"+objId).val();//��ȡid��ΪobjIdֵ��ֵ��Ҳ���ǻ�ȡ��Ӧ���û�����ķ�����
	/**
	 * ���������˷ֵģ���ô��������ߵ�ʱ������Ӧ�ûָ���ԭ����״̬��������Ӧ�ķ�ֵ��
	 * ���û�д�֣���ô������ߵ�ʱ������������ɫ����û�д�֡�
	 */
	if(score >= 1){
		$(obj).prevAll().attr("src",imageServer+"/images/evaluate/pj1.png");
		$(obj).attr("src",imageServer+"/images/evaluate/pj1.png");
		//����÷ֲ�����2�ֵĻ�ɫ���������ţ�������ɫ������2�ֵ�����Ӧ�����ɫ���ǣ�������ɫ
		if(score <= 2){
			for(var i=1; i<=score; i++){
				$("#"+objId+"Img"+i).attr("src",imageServer+"/images/evaluate/pj3.png");
			}
		}else{
			for(var i=1; i<=score; i++){
				$("#"+objId+"Img"+i).attr("src",imageServer+"/images/evaluate/pj2.png");
			}
		}
	}else{
		$(obj).prevAll().attr("src",imageServer+"/images/evaluate/pj1.png");
		$(obj).attr("src",imageServer+"/images/evaluate/pj1.png");
	}
}

/**
 * ҳ�����ǵ�չ��Ч������
 */
$(function(){
	$(".pinjia table tr td span img").hover(
	function(){sh(this)},
	function(){normal(this)}
	)
	$(".pinjia table tr td span img").click(function(){
		 sh(this);
		})
	}
)

/**
 * �˷����Ǹ���Ӧ������
 * @param score����ķ�ֵ
 * @param scoreType����Ӧ�������
 */
function setScore(score,scoreType){
	$("#"+scoreType).attr("value",score);
}

/**
 * js��֤
 */
$(document).ready(function(){    
	jQuery.validator.setDefaults({ 
		submitHandler: function(form) { 
			form.submit();
		} 
	});    
	$("#evaluateForm").validate({
		errorPlacement: function(error, element) {
			element.siblings("span[class='red']").text(error.text());
		},
		success: function(label) {
			label.text("");
		},
   		 rules: {
			integral:{
				required	:	true
			},
			remark: {    
            	 maxlength	:	80
            }
  		 },      
  		 messages: {
 			integral:{
				required	:	"��Ϊ�Է���һ���ۺ�����"
			},
  			remark: {    
             	 maxlength	:	"���������������̫���ˣ����Ϊ80���ַ�"
            }
  		 }
 		});  
 });

/**
 * ���ص��б�
 * @param type �������ͣ��������ۣ�������ۣ�
 * @return
 */
function goToList(type){
	window.location.href = appServer + "/order/" + type + "/list.htm";
}