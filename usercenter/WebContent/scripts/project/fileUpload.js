$(document).ready(function() {
	FileReader = window.FileReader;
	$("#fileChoose0").bind('change', function() {
		// if (FileReader) {
			// var reader = new FileReader(), file = this.files[0];
			// reader.onload = function(e) {
			// // reflushImg("img0", e.target.result);
			// $("#picturePath").val(e.target.result);
			// };
			// reader.readAsDataURL(file);
			//
			// } else {
			// path = $(this).val();
			// if (/"\w\W"/.test(path)) {
			// path = path.slice(1, -1);
			// }
			// // reflushImg("img0", path);
			// $("#picturePath").val(path);
			reflushImg("img0", imageServer + "/images/choose.png");
			// }

		});
	$("#fileChoose1").bind('change', function() {
		// if (FileReader) {
			// var reader = new FileReader(), file = this.files[0];
			// reader.onload = function(e) {
			// // reflushImg("img1", e.target.result);
			// $("#picturePath1").val(e.target.result);
			// };
			// reader.readAsDataURL(file);
			// } else {
			// path = $(this).val();
			// if (/"\w\W"/.test(path)) {
			// path = path.slice(1, -1);
			// }
			// reflushImg("img1", path);
			// $("#picturePath1").val(path);
			reflushImg("img1", imageServer + "/images/choose.png");
			// }
		});
	$("#fileChoose2").bind('change', function() {
		// if (FileReader) {
			// var reader = new FileReader(), file = this.files[0];
			// reader.onload = function(e) {
			// // reflushImg("img2", e.target.result);
			// $("#picturePath2").val(e.target.result);
			// };
			// reader.readAsDataURL(file);
			// } else {
			// path = $(this).val();
			// if (/"\w\W"/.test(path)) {
			// path = path.slice(1, -1);
			// }
			// reflushImg("img2", path);
			// $("#picturePath2").val(path);
			reflushImg("img2", imageServer + "/images/choose.png");
			// }

		});
	$("#fileChoose3").bind('change', function() {
		// if (FileReader) {
			// var reader = new FileReader(), file = this.files[0];
			// reader.onload = function(e) {
			// // reflushImg("img3", e.target.result);
			// $("#picturePath3").val(e.target.result);
			// };
			// reader.readAsDataURL(file);
			// } else {
			// path = $(this).val();
			// if (/"\w\W"/.test(path)) {
			// path = path.slice(1, -1);
			// }
			// reflushImg("img3", path);
			// $("#picturePath3").val(path);
			reflushImg("img3", imageServer + "/images/choose.png");
			// }
		});
	$("#fileChoose4").bind('change', function() {
		// if (FileReader) {
			// var reader = new FileReader(), file = this.files[0];
			// reader.onload = function(e) {
			// // reflushImg("img4", e.target.result);
			// $("#picturePath4").val(e.target.result);
			// };
			// reader.readAsDataURL(file);
			// } else {
			// path = $(this).val();
			// if (/"\w\W"/.test(path)) {
			// path = path.slice(1, -1);
			// }
			// reflushImg("img4", path);
//			$("#picturePath4").val(path);
			reflushImg("img4", imageServer + "/images/choose.png");
			// }
		});
});

function reflushImg(imgId, newUrl) {
	var parentObj = $("#" + imgId).parent(".imgObject");
	var imgHtml = "<img id='" + imgId + "' src='" + newUrl
			+ "' class='pic-hover-act-event' width='110' height='110' >";
	parentObj.empty();
	parentObj.append(imgHtml);
	// alert($("#" + imgId).parent(".imgObject").text());
	// $("#" + imgId).attr("src", newUrl);
}
var count = 0;
var upcount = 0;
$(document).ready(function() {
	$("input[multiple='multiple']").live('click', function() {
		count = 0;
		upcount = 0;
	});
	$("#del0").click(function() {
		jQuery("#fileChoose0").attr("value", "");
		jQuery("#tempPath").attr("value", "");
		reflushImg("img0", imageServer + "/images/nophoto.jpg");
	});
	$("#del1").click(function() {
		jQuery("#fileChoose1").attr("value", "");
		jQuery("#tempPath1").attr("value", "");
		reflushImg("img1", imageServer + "/images/nophoto.jpg");
	});
	$("#del2").click(function() {
		jQuery("#fileChoose2").attr("value", "");
		jQuery("#tempPath2").attr("value", "");
		reflushImg("img2", imageServer + "/images/nophoto.jpg");
	});
	$("#del3").click(function() {
		jQuery("#fileChoose3").attr("value", "");
		jQuery("#tempPath3").attr("value", "");
		reflushImg("img3", imageServer + "/images/nophoto.jpg");
	});
	$("#del4").click(function() {
		jQuery("#fileChoose4").attr("value", "");
		jQuery("#tempPath4").attr("value", "");
		reflushImg("img4", imageServer + "/images/nophoto.jpg");
	});
});
$(".pic-hover-act-event").live("mouseout", function() {
	// $(this).next().hide();
	});
$(".pic-hover-act-event").live("mouseover", function() {
	// $(this).next().show();
	});

$("span[data-act='moveLeft']")
		.live(
				"click",
				function() {
					var tempObj = $(this).parent(".act").parent().prev()
							.children(".imgObject"); // œ‡¡⁄Õº∆¨∏∏div
					var preImageHtml = $(this).parent(".act").parent().prev()
							.children(".imgObject").html(); // œ‡¡⁄Õº∆¨html¥˙¬Î
					var thisImageHtml = $(this).parent(".act").prev().html();
					if (tempObj && preImageHtml && thisImageHtml
							&& preImageHtml != "") {
						var idstr = tempObj.children(".pic-hover-act-event")
								.attr("id");

						if ("img0" == idstr) {
							var tempPath = $("#fileChoose").val();
							$("#fileChoose").val($("#fileChoose1").val());
							$("#fileChoose1").val(tempPath);
							var tempPathValue = $("#picturePath").val();
							$("#picturePath").val($("#picturePath1").val());
							$("#picturePath1").val(tempPathValue);
							preImageHtml = preImageHtml.replace("img0", "img1");
							thisImageHtml = thisImageHtml.replace("img1",
									"img0");
						} else if ("img1" == idstr) {
							var tempPath = $("#fileChoose1").val();
							$("#fileChoose1").val($("#fileChoose2").val());
							$("#fileChoose2").val(tempPath);
							var tempPathValue = $("#picturePath1").val();
							$("#picturePath1").val($("#picturePath2").val());
							$("#picturePath2").val(tempPathValue);
							preImageHtml = preImageHtml.replace("img1", "img2");
							thisImageHtml = thisImageHtml.replace("img2",
									"img1");
						} else if ("img2" == idstr) {
							var tempPath = $("#fileChoose2").val();
							$("#fileChoose2").val($("#fileChoose3").val());
							$("#fileChoose3").val(tempPath);
							var tempPathValue = $("#picturePath2").val();
							$("#picturePath2").val($("#picturePath3").val());
							$("#picturePath3").val(tempPathValue);
							preImageHtml = preImageHtml.replace("img2", "img3");
							thisImageHtml = thisImageHtml.replace("img3",
									"img2");
						} else if ("img3" == idstr) {
							var tempPath = $("#fileChoose3").val();
							$("#fileChoose3").val($("#fileChoose4").val());
							$("#fileChoose4").val(tempPath);
							var tempPathValue = $("#picturePath3").val();
							$("#picturePath3").val($("#picturePath4").val());
							$("#picturePath4").val(tempPathValue);
							preImageHtml = preImageHtml.replace("img3", "img4");
							thisImageHtml = thisImageHtml.replace("img4",
									"img3");
						} else if ("img4" == idstr) {

						} else {

						}
						tempObj.empty(); // Õº∆¨«Âø’£ª
						tempObj.append(thisImageHtml);// Õº∆¨÷ÿ–¬ÃÓ≥‰
						$(this).parent(".act").prev().empty(); //  Û±ÍÀ˘‘⁄Õº∆¨«¯”Ú«Âø’
						$(this).parent(".act").prev().html(preImageHtml); //
					}
				});
$("span[data-act='moveRight']")
		.live(
				"click",
				function() {
					var tempObj = $(this).parent(".act").prev().parent().next()
							.children(".imgObject"); // œ‡¡⁄Õº∆¨∏∏div
					var nextImageHtml = $(this).parent(".act").prev().parent()
							.next().children(".imgObject").html(); // œ‡¡⁄Õº∆¨html¥˙¬Î
					var thisImageHtml = $(this).parent(".act").prev().html();
					if (tempObj && nextImageHtml && thisImageHtml
							&& nextImageHtml != "") {
						var idstr = tempObj.children(".pic-hover-act-event")
								.attr("id");

						if ("img0" == idstr) {

						} else if ("img1" == idstr) {

							var tempPath = $("#fileChoose1").val();
							$("#fileChoose1").val($("#fileChoose").val());
							$("#fileChoose").val(tempPath);
							var tempPathValue = $("#picturePath1").val();
							$("#picturePath1").val($("#picturePath").val());
							$("#picturePath").val(tempPathValue);
							nextImageHtml = nextImageHtml.replace("img1",
									"img0");
							thisImageHtml = thisImageHtml.replace("img0",
									"img1");

						} else if ("img2" == idstr) {
							var tempPath = $("#fileChoose2").val();
							$("#fileChoose2").val($("#fileChoose1").val());
							$("#fileChoose1").val(tempPath);
							var tempPathValue = $("#picturePath2").val();
							$("#picturePath2").val($("#picturePath1").val());
							$("#picturePath1").val(tempPathValue);
							nextImageHtml = nextImageHtml.replace("img2",
									"img1");
							thisImageHtml = thisImageHtml.replace("img1",
									"img2");
						} else if ("img3" == idstr) {

							var tempPath = $("#fileChoose3").val();
							$("#fileChoose3").val($("#fileChoose2").val());
							$("#fileChoose2").val(tempPath);
							var tempPathValue = $("#picturePath3").val();
							$("#picturePath3").val($("#picturePath2").val());
							$("#picturePath2").val(tempPathValue);
							nextImageHtml = nextImageHtml.replace("img3",
									"img2");
							thisImageHtml = thisImageHtml.replace("img2",
									"img3");
						} else if ("img4" == idstr) {
							var tempPath = $("#fileChoose4").val();
							$("#fileChoose4").val($("#uploadFile3").val());
							$("#uploadFile3").val(tempPath);
							var tempPathValue = $("#picturePath4").val();
							$("#picturePath3").val($("#picturePath3").val());
							$("#picturePath4").val(tempPathValue);
							nextImageHtml = nextImageHtml.replace("img4",
									"img3");
							thisImageHtml = thisImageHtml.replace("img3",
									"img4");
						} else {

						}
						tempObj.empty(); // Õº∆¨«Âø’£ª
						tempObj.append(thisImageHtml);// Õº∆¨÷ÿ–¬ÃÓ≥‰
						$(this).parent(".act").prev().empty(); //  Û±ÍÀ˘‘⁄Õº∆¨«¯”Ú«Âø’
						$(this).parent(".act").prev().html(nextImageHtml); //
					}
				});
//$("span[data-act='del']").live("click", function() {
	// alert($(this).text());
//	});

function refreshImgAdd(count, imgObj, url) {
	if (count == 0)
		$("#qq-upload-drop-area").empty();

	$("#qq-upload-drop-area")
			.append(
					'&nbsp;<div id="imgList" class="shangchuan in_block mr10" style="width:110px; height:130px;"><div class="imgObject"><img width=110 height=110 id="'
							+ imgObj
							+ '" class="pic-hover-act-event" src="'
							+ uploadServer
							+ url
							+ '" width="100" height="100" /></div>'
							// + '<div class="act" style="display: none; ">'
							+ '<div class="act">'
							+ '<span data-act="moveLeft"><img title="◊Û“∆" src="'
							+ imageServer
							+ '/images/left.gif" /></span>'
							+ '<span data-act="moveRight"><img title="”““∆" src="'
							+ imageServer
							+ '/images/right.gif" /></span>'
							+ '<span data-act="del"><img title="…æ≥˝" src="'
							+ imageServer
							+ '/images/ico_cancel.png" /></span></div></div>')
}

function clearFile(){
	jQuery("#attachedFile").attr("value", "");
}