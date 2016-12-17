/**
 * 用户评价js
 * @author xiejh
 * @email xiejh@hundsun
 * @version v0.1
 */

/**
 * 此函数是鼠标移到星星上时产生的动作
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
 * 此函数是鼠标离开星星时候产生的动作
 * @param obj 鼠标所在的元素
 * @return
 */
function normal(obj){
	var objId = $(obj).attr("name");//获取当前img元素的name值
	var score = $("#"+objId).val();//获取id名为objId值的值（也就是获取对应项用户打出的分数）
	/**
	 * 如果该项打了分的，那么当鼠标移走的时候，星星应该恢复到原来的状态，表明对应的分值；
	 * 如果没有打分，那么鼠标移走的时候，所有星星无色表明没有打分。
	 */
	if(score >= 1){
		$(obj).prevAll().attr("src",imageServer+"/images/evaluate/pj1.png");
		$(obj).attr("src",imageServer+"/images/evaluate/pj1.png");
		//如果得分不高于2分的灰色的星星亮着，其他无色；高于2分得亮对应多个黄色星星，其余无色
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
 * 页面星星的展现效果函数
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
 * 此方法是给对应的项打分
 * @param score：打的分值
 * @param scoreType：对应项的名称
 */
function setScore(score,scoreType){
	$("#"+scoreType).attr("value",score);
}

/**
 * js验证
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
				required	:	"请为对方做一个综合评价"
			},
  			remark: {    
             	 maxlength	:	"您输入的评价内容太长了，最多为80个字符"
            }
  		 }
 		});  
 });

/**
 * 返回到列表
 * @param type 评价类型（卖家评价，买家评价）
 * @return
 */
function goToList(type){
	window.location.href = appServer + "/order/" + type + "/list.htm";
}