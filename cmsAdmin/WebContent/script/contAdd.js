function channelChange(n) {
	if(n==0) {
		return;
	}
	//0为请选择，所以必须减一。
	n--;
	var trc = $('#tr-contentImg');
	var trt = $('#tr-titleImg');
	trc.toggle(channels[n].hasContentImg);
	$('#zoomWidth1').val(channels[n].titleImgWidth);
	$('#zoomHeight1').val(channels[n].titleImgHeight);
	trt.toggle(channels[n].hasTitleImg);
	$('#zoomWidth2').val(channels[n].contentImgWidth);
	$('#zoomHeight2').val(channels[n].contentImgHeight);
	fetchTopics(channels[n].id);
}
$.validator.methods.leafChannel = function(value, element, param) {
	var i = element.selectedIndex;
	return $(element.options[i]).attr("class")!="sel-disabled";
}
function resetFckSize(){
	  if( $('#txt___Frame').attr( "width" ) == "100%" ){
		  $('#txt___Frame').attr( "width", "90%" );
	  }else{
		  $('#txt___Frame').attr( "width", "100%" );
	  }
}
$(function() {
//	new ColorPicker($("#titleColor"));

	jQuery.validator.addMethod(
			"linkValid",
			function(value, element) {
				if( $("#linkCheckBox").attr("checked") ){
					if( $("#link").val() == "" ){
						return false;
					}
				}
				return true;
				;
			},
			"不能为空"
	);

	$("#jvForm").validate({
//		  errorPlacement: function(error, element) {
//			$(error).attr("class","");
//	        $(error).attr("style","color:red");
//	        //$(element.parent()).find("label").remove();
//	        error.insertAfter(element);
//	        resetFckSize();
//		},
		 
		rules: {
			channelId: {
				required: true,
				leafChannel: true
			},
			title: {
				required: true,
				maxlength : 150
			},
			link: {
				linkValid: true,
				maxlength : 256
			},
			shortTitle: {
				maxlength : 150
			},
			titleColor: {
				maxlength : 10
			},
			author: {
				maxlength : 100
			},
			origin: {
				maxlength : 100
			},
			originUrl: {
				maxlength : 256
			},
			remark: {
				maxlength : 256
//			},
//			mediaType: {
//				required: function() {return $("#mediaPath").val()!=""}
			}
		},
		messages:{
			channelId: {
				leafChannel: "请选择同模型的末级栏目"
			},
			mediaType:$.validator.messages.required
		},
//		success: function(label) {
			 
//		}
		submitHandler:function(form){
			$('#buttonSave').attr('disabled','disabled');
			 $('#buttonSubmit').attr('disabled','disabled');
	        form.submit();
	    }
	});
	//副栏目对话框
//	$("#channelsDialog").dialog({
//		autoOpen: false,
//		modal: true,
//		width: 280,
//		height: 400,
//		position: ["center",20],
//		buttons: {
//			"关闭": function() {
//			$(this).dialog("close");
//		},
//			"确定": function() {
//				$("#channelsSelector input[name='channels']:checked").each(function(){
//					appendChannels(this);
//					$(this).removeAttr("checked");
//				});
//				$(this).dialog("close");
//			}
//		}
//	});
//	$('#channelsLink').click(function(){
//		$('#channelsDialog').dialog('open');
//		return false;
//	});
//	$("#channelsSelector").treeview({
//		url: "v_tree_channels.do"
//	});
});
/**
 * 颜色选择器

ColorPicker = function(input) {
	var obj = this;
	this.isShow = false;
	this.target = $(input);
	this.button = $("<input type='text' tabindex='10000'"
			+ " readonly='readonly' style='background-color:#fff;width:30px;"
			+ "border:1px solid #ccc;margin-left:2px;cursor:pointer'/>");
	this.target.after(this.button);
	this.over = function() {
		$(this).css("border", "1px solid #000");
	}
	this.out = function() {
		$(this).css("border", "1px solid #fff");
	}
	this.click = function() {
		var color = $(this).attr("title");
		obj.setColor(color);
		this.isShow = false;
		obj.picker.hide();
	}
	this.createPicker = function() {
		var c = ["#FF8080", "#FFFF80", "#80FF80", "#00FF80", "#80FFFF",
				"#0080FF", "#FF80C0", "#FF80FF", "#FF0000", "#FFFF00",
				"#80FF00", "#00FF40", "#00FFFF", "#0080C0", "#8080C0",
				"#FF00FF", "#804040", "#FF8040", "#00FF00", "#008080",
				"#004080", "#8080FF", "#800040", "#FF0080", "#800000",
				"#FF8000", "#008000", "#008040", "#0000FF", "#0000A0",
				"#800080", "#8000FF", "#400000", "#804000", "#004000",
				"#004040", "#000080", "#000040", "#400040", "#400080",
				"#000000", "#808000", "#808040", "#808080", "#408080",
				"#C0C0C0", "#400040", "#FFFFFF"];
		var s = "<table border='0' cellpadding='0' cellspacing='5' "
				+ "style='display:none;position:absolute;margin-top:0px;border:1px solid #ccc;background-color:#fff'>"
				+ "<tr height='15'>";
		// 列数
		var col = 8;
		for (var i = 0, len = c.length;i < len; i++) {
			s += "<td width='15'><div class='c' style='width:13px;height:13px;"
					+ "border:1px solid #fff;cursor:pointer;background-color:"
					+ c[i] + "' title='" + c[i] + "'>&nbsp;<div></td>";
			if ((i + 1) != c.length && (i + 1) % col == 0) {
				s += "</tr><tr height='15'>";
			}
		}
		// s += "</tr><tr><td colspan=" + col
		// + "><div class='c' style='width:153px;height:13px;text-align:center;"
		// + "border:1px solid #fff;cursor:pointer;background-color:#fff'"
		// + " title=''>clear<div></td>";
		s += "</tr></table>";
		var picker = $(s);
		picker.find(".c").each(function() {
			$(this).bind("mouseover", obj.over);
			$(this).bind("mouseout", obj.out);
			$(this).bind("click", obj.click);
		});
		$(document.body).append(picker);
		return picker;
	}
	this.setColor = function(color) {
		obj.target.val(color);
		if (color == "") {
			color = "#fff";
		}
		try {
			obj.button.css( {
				backgroundColor : color
			});
		} catch (e) {
			alert("color error: " + color);
			obj.target.focus().select();
		}
	}
	this.picker = this.createPicker();
	this.showPicker = function() {
		if (!obj.isShow) {
			obj.isShow = true;
			obj.picker.showBy(obj.target);
			$(document).bind("mousedown", function() {
				$(document).unbind("mousedown");
				setTimeout(function() {
					obj.isShow = false;
					obj.picker.hide();
					var val = obj.target.val();
					obj.setColor(obj.target.val());
				}, 200);
			});
		}
	}
	this.button.bind("click", obj.showPicker);
	this.target.bind("blur", function() {
		obj.setColor(obj.target.val());
	});
	var v = this.target.val();
	if (v != "") {
		this.setColor(v);
	}
};
 */
function changeTrColor(obj){
	$(obj).mouseover(function(){
		$(obj).children("td").addClass("bgco2");
	});
	$(obj).mouseleave(function(){
		$(obj).children("td").removeClass("bgco2")
	});
}
function appendChannels(channel) {
	var hasContain = false;
	$("input[name=channelIds]").each(function() {
		if($(this).val()==$(channel).val()) {
			hasContain = true;
		}
	});
	if(hasContain) {
		return;
	}
	var nodeList = eval($(channel).attr("nodeList"));
	var s = "<div style='padding-top:3px'>";
	for(var i=0,len=nodeList.length;i<len;i++) {
		s += nodeList[i];
		if(i<len-1) {
			s += " > ";
		}
	}
	s += " <a href='javascript:void(0);' onclick='$(this).parent().remove();' class='pn-opt'>删除</a>";
	s += "<input type='hidden' name='channelIds' value='"+$(channel).val()+"'/>";
	s += "</div>";
	$("#channelsContainer").append(s);
}

function checkUrl() {
	var url = $('#originUrl').val();
	var link = $('#link').val();
	if (url != undefined && url.length > 0) {
		if (url == 'http://') {
			$('#originUrl').attr("class", "");
			$('#originUrl').val('');
		} else {
			$('#originUrl').attr("class", "url");
		}
	} else {
		$('#originUrl').attr("class", "");
	}
	if (link != undefined && link.length > 0) {
		if (link == 'http://') {
			$('#link').attr("class", "");
			$('#link').val('');
		} else {
			$('#link').attr("class", "url");
		}
	} else {
		$('#link').attr("class", "");
	}
}

function doReset(){
	var oEditor1 = FCKeditorAPI.GetInstance('txt');
	if(oEditor1){
		oEditor1.SetHTML("",true);
	}
}