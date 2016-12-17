/**
 * ʡ�ݳ�������JS��
 * 
 * @param {}
 *            baseUrl ��ȡjson�ṹ�� ��ȡʡ�ݳ��е�Ajax��������
 * @param {}
 *            orgProvince Ĭ��ʡ��
 * @param {}
 *            orgcity Ĭ�ϳ���
 * @param {}
 *            provinceId ʡ�ݰ�select id
 * @param {}
 *            cityId ���а�select id
 */
function Area(baseUrl, orgProvince, orgCity, orgArea, provinceId, cityId, areaId )
{
	var _this = this;
	this._baseUrl = baseUrl;
	this._orgProvince = orgProvince;
	this._orgCity = orgCity;
	this._orgArea = orgArea;
	this._provinceId = "#" + provinceId;
	this._cityId = "#" + cityId;
	this._areaId = "#" + areaId;
	this.provinceList;
	this.cityList = new Array();
	this.areaList = new Array();

	/**
	 * ��ȡʡ����Ϣ
	 */
	this.getProvince = function() {
		if (!_this.provinceList) {
			jQuery.ajax( {
				type : "GET",
				url : _this._baseUrl + "/queryProvince.htm",
				dataType : "json",
				async : false,
				success : function(list) {
					_this.provinceList = list;
				}
			});
		}
		return _this.provinceList;
	}

	/**
	 * ��ȡ������Ϣ
	 */
	this.getCity = function(province) {
		if (province && province.length > 0){
			if (!_this.cityList || !_this.cityList[province]) {
				jQuery.ajax( {
					type : "GET",
					url : _this._baseUrl + "/queryCity.htm",
					dataType : "json",
					data : "province="+province,
					async : false,
					success : function(list) {
						if (list){
							_this.cityList[province] = list;
						}
					}
				});
			}
			if (_this.cityList && _this.cityList[province]){
				return _this.cityList[province];
			}
		}

	}

	/**
	 * ��ȡ������Ϣ
	 */
	this.getArea = function(city) {
		if (city && city.length > 0){
			if (!_this.areaList || !_this.areaList[city]) {
				jQuery.ajax( {
					type : "GET",
					url : _this._baseUrl + "/queryArea.htm",
					dataType : "json",
					data : "city="+city,
					async : false,
					success : function(list) {
						if (list){
							_this.areaList[city] = list;
						}
					}
				});
			}
			if (_this.areaList && _this.areaList[city]){
				return _this.areaList[city];
			}
		}
	}

	/**
	 * ����ʡ���б�
	 */
	this.buildProvince = function() {
		var option = "";
		$(_this._provinceId).empty();
		$(_this._provinceId).append(
				'<option value="">&#35831;&#36873;&#25321;</option>');
		var list = _this.getProvince();
		if (list){
			for ( var i in list) {
				var item = list[i];
				if (_this._orgProvince == item.value) {
					option = '<option selected value="' + item.value + '">'
							+ item.name + '</option>';
				} else {
					option = '<option  value="' + item.value + '">'
					+ item.name + '</option>';
				}
				$(_this._provinceId).append(option);
			}
		}
	}
	
	/**
	 * ���������б�
	 */
	this.buildCity = function(province) {
		var option = "";
		$(_this._cityId).empty();
		$(_this._cityId).append(
				'<option value="">&#35831;&#36873;&#25321;</option>');
		var list = _this.getCity(province);
		if (list){
			for ( var i in list) {
				var item = list[i];
				if (_this._orgCity == item.value) {
					option = '<option selected value="' + item.value + '">'
							+ item.name + '</option>';
				} else {
					option = '<option  value="' + item.value + '">'
					+ item.name + '</option>';
				}
				$(_this._cityId).append(option);
			}
		}
	}
	
	/**
	 * ���������б�
	 */
	this.buildArea = function(city) {
		var option = "";
		$(_this._areaId).empty();
		$(_this._areaId).append(
				'<option value="">&#35831;&#36873;&#25321;</option>');
		var list = _this.getArea(city);
		if (list){
			for ( var i in list) {
				var item = list[i];
				if (_this._orgArea == item.value) {
					option = '<option selected value="' + item.value + '">'
							+ item.name + '</option>';
				} else {
					option = '<option  value="' + item.value + '">'
					+ item.name + '</option>';
				}
				$(_this._areaId).append(option);
			}
		}
	}

	
	this.provinceChange = function() {
		_this.buildCity($(_this._provinceId).val());
		_this.buildArea($(_this._cityId).val());
	}
	
	this.cityChange = function() {
		_this.buildArea($(_this._cityId).val());
	}
	
	/**
	 * ���к���
	 */
	this.run = function() {
		_this.buildProvince();
		_this.buildCity($(_this._provinceId).val());
		_this.buildArea($(_this._cityId).val());
	}

	$(function() {
		$(_this._provinceId).change(function() {
			_this.provinceChange();
		});
		$(_this._cityId).change(function() {
			_this.cityChange();
		});
		_this.run();
	});
}
