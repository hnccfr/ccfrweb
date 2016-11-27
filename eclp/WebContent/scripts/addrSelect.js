var isDistrictExist = false;
var isCityExist = false;

/**
 * 校验省市区，如果“省”下面没有“市”，则不校验“市”必填；<br/>
 * 如果“市”下面没有“区”，则不校验“区”必填
 * @returns {Boolean}
 * @author tanhl
 */
function checkRegion() {
	//省份信息为必填
	var res = false;
	res = checkProvince();
	if(res == false) {
		return res;
	}
	if(isCityExist) {
		res = checkCity();
		if(res == false) {
			return res;
		}
	}
	if(isDistrictExist) {
		res = checkDistrict();
		if(res == false) {
			return res;
		}
	}
	return res;
}

function checkProvince() {
	if(jQuery("#regProvinceCode").val() == "") {
		jQuery("#regDistrictCode_span").html("请选择省份");
		return false;
	} else {
		jQuery("#regDistrictCode_span").html("");
		return true;
	}
}

function checkCity() {
	if(jQuery("#regCityCode").val() == "") {
		jQuery("#regDistrictCode_span").html("请选择城市");
		return false;
	} else {
		jQuery("#regDistrictCode_span").html("");
		return true;
	}
}

function checkDistrict() {
	if(jQuery("#regDistrictCode").val() == "") {
		jQuery("#regDistrictCode_span").html("请选择地区");
		return false;
	} else {
		jQuery("#regDistrictCode_span").html("");
		return true;
	}
}

function getCityList(url) {
	removeOpions("regDistrictCode");
	removeOpions("regCityCode");
	jQuery("#regCity").val('');
	jQuery("#regDistrict").val('');
	//初始化城市、地区数据是否存在标志位
	isCityExist = false;
	isDistrictExist = false;
	jQuery("#regDistrictCode").hide();
	jQuery("#regCityCode").hide();
	var code = jQuery("#regProvinceCode").val();
	var item = jQuery('#regProvinceCode option:selected').html();
	jQuery("#regProvince").val(item);
	//如果取到city数据，显示city下拉框显示
	if(getRegionData("regCityCode", 2, code, url)) {
		jQuery("#regCityCode").show();
		//城市数据是否存在标志位
		isCityExist = true;
	}
}

function getDistrictList(url) {
	removeOpions("regDistrictCode");
	jQuery("#regDistrict").val('');
	isDistrictExist = false;
	jQuery("#regDistrictCode").hide();
	var code = jQuery("#regCityCode").val();
	var item = jQuery('#regCityCode option:selected').html();
	jQuery("#regCity").val(item);
	if(getRegionData("regDistrictCode", 3, code, url)) {
		jQuery("#regDistrictCode").show();
		setDistrict();
		//区域数据是否存在标志位
		isDistrictExist = true;
	}
}

function setDistrict() {
	var item = jQuery('#regDistrictCode option:selected').html();
	jQuery("#regDistrict").val(item);
}

function getRegionData(targetId, regionType, parentCode, reqUrl) {
	var url = reqUrl + "?regionType=" + regionType + "&code=" + parentCode;
	var res;
	jQuery.ajax({
		type : "GET",
		async : false,
		url : url,
		success : function(data) {
			res = renderSelectOption(targetId, data, true);
		}
	});
	return res;
}

/**
 * 渲染select框数据，如有，返回true，若没数据，返回false
 * @param targetId
 * @param data
 * @param haveInitOption
 * @returns {Boolean}
 */
function renderSelectOption(targetId, data, haveInitOption) {
	removeOpions(targetId);
	jQuery("#" + targetId).append("<option value=''>请选择</option>");
	if(null != data && data.length > 0) {
		for ( var i = 0; i < data.length; i++) {
			jQuery("#" + targetId).append(
					"<option value='" + data[i].code + "'>" + data[i].regionName
							+ "</option>");
		}
		return true;
	}
	return false;
}

function removeOpions(targetId) {
	//jQuery("#" + targetId).find('option').remove().end();
	jQuery("#" + targetId).empty();
}