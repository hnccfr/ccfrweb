(function($){
	/**
	 * @param {Object} options
	 *  <li>errorElement <String> 默认 font</li>
	 *  <li>labelElement <String> 默认 label</li>
	 *
	 *  @since jquery.validate.js
	 */
	$.fn.validateForm = function(options){
		if(!options){
			options = {};
		}
		
		options.submitHandler = function(f) {
			$('input[type=submit]',$(f)).attr('disabled','disabled');
			//alert("admin.validate");
			f.submit();
		};

		options.errorElement = options.errorElement ? options.errorElement : 'font';
		options.labelElement = options.labelElement ? options.labelElement : 'label';
		options.ignore = options.ignore ? options.ignore : ':hidden';
		options.onkeyup = options.onkeyup ?  options.onkeyup : false;	

		this.validate(options);

	    //将有必填标记的表单项，加上必填规则
//	    $("input,select,textarea",this).each(function(){
//	    	var op = $(this).parent();
//	    	if(op.is("li") && op.is(':visible')){
//	    		var span = op.find('em.requiredTag')
//	    		if(span.size() > 0 && span.is(":visible")){
//	    			addRequired(op,'input',options.labelElement);
//	    			addRequired(op,'select',options.labelElement);
//	    			addRequired(op,'textarea',options.labelElement);
//	    		}
//	    	}
//	    });

	    return this;
	}

//	function addRequired(op,tagName,labelElement){
//		if(op.find(tagName).size() > 0){
//			op.find(tagName).rules('add',{
//				//required: [true,'[' + $.trim(op.find(labelElement).text().replace('：','').replace('*','')) + ']']
//				required:true
//			})
//		}
//	}
})(jQuery);


//自定义校验规则
// 验证值必须大于特定值(不能等于)
//<input class="a b" greaterThan="0"/> 
//<input class="{greaterThan:0}"/>
jQuery.validator.addMethod("greaterThan", function(value, element, param) {
    return value > param;
}, $.validator.format("该数据项必须大于{0}"));

//只能包括中文字、英文字母、数字和下划线
 jQuery.validator.addMethod("stringCheck", function(value, element) {
     return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
 }, "只能包括中文字、英文字母、数字和下划线");

 // 中文字两个字节
 jQuery.validator.addMethod("byteRangeLength", function(value, element, param) {
     var length = value.length;
     for(var i = 0; i < value.length; i++){
         if(value.charCodeAt(i) > 127){
         length++;
        }
    }
    return this.optional(element) || ( length >= param[0] && length <= param[1] );
 }, "请确保输入的值在{1}-{2}个字节之间(一个中文字算2个字节)");

 // 身份证号码验证
 jQuery.validator.addMethod("idCardNo", function(value, element) {
     //return this.optional(element) || isIdCardNo(value);
 	var length = value.length;
 	var reg = /^\d{15}(\d{2}(\d|[A-Z]))?$/;
 	return this.optional(element) ||(length > 0 && reg.test(value));;
 }, "身份证号码不正确");

 // 手机号码验证
 jQuery.validator.addMethod("mobile", function(value, element) {
     var length = value.length;
     var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(189)|(188))+\d{8})$/;
     return this.optional(element) || (length == 11 && reg.test(value));
 }, "手机号码不正确");

 // 电话号码验证
 jQuery.validator.addMethod("phone", function(value, element) {
     var reg = /^([0-9]{2}-)?(0?[0-9]{2,3}\-)?[1-9]?[0-9]{7}$/;
     return this.optional(element) || (reg.test(value));
 }, "电话号码不正确");

 // 联系电话(手机/电话皆可)验证
 jQuery.validator.addMethod("phoneOrMobile", function(value,element) {
     var length = value.length;
     var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(189)|(188))+\d{8})$/;
     var tel = /^([0-9]{2}-)?(0?[0-9]{2,3}\-)?[1-9]?[0-9]{7}$/;
     return this.optional(element) || (tel.test(value) || mobile.test(value));

 }, "联系电话不正确");

 // 邮政编码验证
 jQuery.validator.addMethod("postCode", function(value, element) {
    var reg = /^[0-9]{6}$/;
    return this.optional(element) || (reg.test(value));
 }, "邮政编码格式不正确");
 
  //附件
 jQuery.validator.addMethod("accessory", function(value, element) {
    var reg = /\.(doc|docx|xls|xlsx|ppt|pdf|txt|rar|zip|jpg|jpeg|gif|bmp|png)$/i;
    return this.optional(element) || (reg.test(value));
 }, "禁止上传该格式的附件");
 
  //图片
 jQuery.validator.addMethod("image", function(value, element) {
    var reg = /\.(jpg|jpeg|gif|png)$/i;
    return this.optional(element) || (reg.test(value));
 }, "请上传正确的图片文件,格式为:(jpg|jpeg|gif|png)");
 
  //正则
 jQuery.validator.addMethod("regex", function(value, element, param) {
    return this.optional(element) || (param.test(value));
 }, "格式不正确");
 
  //中文姓名
 jQuery.validator.addMethod("username", function(value, element) {
    var reg = /^[\u4e00-\u9fa5]{2,4}$/;
    return this.optional(element) || (reg.test(value)); 
 }, "格式不正确,必须是由2-4为中文组成");
 
  //企业名称
 jQuery.validator.addMethod("companyname", function(value, element) {
    var reg = /[\u4E00-\u9FA5]{4,40}/;
    return this.optional(element) || (reg.test(value)); 
 }, "格式不正确,至少包含4个中文字符");
 
 