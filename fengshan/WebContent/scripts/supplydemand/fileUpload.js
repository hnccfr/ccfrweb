/**
 * @author tanhl 2012-02-28
 * @param imgId
 * @param newUrl
 */
function reflushImg(imgId, newUrl) {
	var parentObj = $("#" + imgId).parent(".imgObject");
	var imgHtml = "<img id='" + imgId + "' src='" + newUrl
			+ "' class='pic-hover-act-event' width='110' height='110' >";
	parentObj.empty();
	parentObj.append(imgHtml);
}

$(document).ready(function() {
	$("#fileChoose0").change(function() {
		reflushImg("img0", imageServer + "/images/choose.png");
	});
	$("#fileChoose1").change(function() {
		reflushImg("img1", imageServer + "/images/choose.png");
	});
	$("#fileChoose2").change(function() {
		reflushImg("img2", imageServer + "/images/choose.png");
	});
	$("#fileChoose3").change(function() {
		reflushImg("img3", imageServer + "/images/choose.png");
	});
	$("#fileChoose4").change(function() {
		reflushImg("img4", imageServer + "/images/choose.png");
	});
	$("#del0").click(function() {
		jQuery("#fileChoose0").attr("value", "");
		jQuery("#tempPath").attr("value", "");
		//$("#img0").hide();
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

