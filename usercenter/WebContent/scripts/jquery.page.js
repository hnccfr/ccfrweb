

/*
 * 分页相关的jQuery脚本。 author: zhengdd date: 2010-12-7
 */

function pager(form, data, action, expression, orderStr) {
	this._form = form;
	this._data = data;
	this._action = action;
	this._expression = expression;
	this._orderStr = orderStr;
	var _this = this;

	/**
	 * 增加排序串(add by peng) 使用样式为 list-order-field 的作为排序结点
	 * 结点的ID作为排序的数据库字段(注意字段设置，后台不验证字段的可靠性，如果字段没有后台sql会直接报错)
	 * 
	 * @param {}
	 *            p
	 */
	this.paginate = function(p) {
		jQuery.ajaxSetup({
					contentType : "application/x-www-form-urlencoded; charset=utf-8"
				})
		if (_this._form == "" && _this._action == "" && _this._expression == "") {
			var url = window.location.href;
			if (url.indexOf("?") != -1) {
				if (url.charAt(url.length - 1) != "&") {
					var goUrl = url + "&pageNo=" + p;
					if (_this._orderStr && _this._orderStr.length > 0) {
						goUrl += "&orderStr="
								+ encodeURIComponent(_this._orderStr);
					}
					window.location.href = goUrl;
				} else {
					var goUrl = url + "pageNo=" + p;
					if (_this._orderStr && _this._orderStr.length > 0) {
						goUrl += "&orderStr="
								+ encodeURIComponent(_this._orderStr);
					}
					window.location.href = goUrl;
				}
			} else {
				var goUrl = url + "?pageNo=" + p;
				if (_this._orderStr && _this._orderStr.length > 0) {
					goUrl += "&orderStr=" + encodeURIComponent(_this._orderStr);
				}
				window.location.href = goUrl;
			}
		} else if (_this._form != "") {
			if (_this._action != "") {
				// TODO;
			}
			if (_this._expression != "") {
				$("#" + _this._form).append("<input type='hidden' name='"
						+ _this._expression + "' value='" + p + "' />");
			} else {
				$("#" + _this._form + " input[type=hidden][name=pageNo]")
						.remove();
				$("#" + _this._form)
						.append("<input type='hidden' name='pageNo' value='"
								+ p + "' />");
			}
			if (_this._orderStr && _this._orderStr.length > 0) {
				$("#" + _this._form)
						.append("<input type='hidden' name='orderStr' value='"
								+ _this._orderStr + "' />");
			}
			if (_this._data != "") {
				$("#" + _this._data).load(_this._action,
						$("#" + _this._form).serializeArray());
			} else {
				$("#" + _this._form).submit();
			}
		}
	}

	$("a[id=_pre_page],a[id=_next_page]").bind("click", function() {
				_this.paginate($.trim($(this).next().val()));
			});
	$("a[id=_none_pre_page],a[id=_none_next_page]").bind("click", function() {
				return false;
			});
	$("a[id=_page_no]").bind("click", function() {
				_this.paginate($.trim($(this).text()));
			});
	$("a[id=_go]").bind("click", function() {
		var p = $.trim($("input[id=_go_page_" + _this._form + "]").val());
		var pTotal = $.trim($("input[id=_total_page_" + _this._form + "]")
				.val());
		if (p.isBlank()) {
			alert("\u8bf7\u8f93\u5165\u9875\u6570");
			return;
		}
		if (!/^[0-9]*[1-9][0-9]*$/.test(p)) {
			alert("\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u9875\u6570");
			return;
		}
		if (parseInt(p) <= 0) {
			p = "1";
		} else if (parseInt(p) >= parseInt(pTotal)) {
			p = pTotal;
		}
		_this.paginate(p);
		return false;
	});
	$("input[id=_go_page_" + _this._form + "]").die("keydown");
	$("input[id=_go_page_" + _this._form + "]").live("keydown",
			function(event) {
				if (event.keyCode == 13) {
					if ($("input[id=_go_page_" + _this._form + "]").next("a")
							.size() > 0) {
						$($("input[id=_go_page_" + _this._form + "]").next("a")[0])
								.click();
					}
					return false;
				}
			});

	// //排序处理
	$(".list-order-field").bind("click", function() {
				var orderField = $(this).attr("id");
				var order = "asc"
				if (orderField && orderField.length > 0) {
					if (_this._orderStr && _this._orderStr.length > 0) {
						var parts = _this._orderStr.split(" ");
						if (orderField == parts[0]) {
							if (parts[parts.length - 1] == "asc") {
								order = "desc";
							} else {
								order = "asc";
							}
						} else {
							order = "asc";
						}
					} else {
						order = "asc";
					}
					_this._orderStr = orderField + " " + order;
					_this.paginate("1"); // 排序返回到第一页
				}
			});

	if (_this._orderStr && _this._orderStr.length > 0) { // 处理样式
		var parts = _this._orderStr.split(" ");
		if (parts.length > 1) {
			$(".list-order-field[id=" + parts[0] + "]")
					.addClass("list-order-field-on-" + parts[1]);
		}
	}

	$("a[id=_pre_page]").attr("id", "_pre_page_already");
	$("a[id=_next_page]").attr("id", "_next_page_already");
	$("a[id=_none_pre_page]").attr("id", "_none_pre_page_already");
	$("a[id=_none_next_page]").attr("id", "_none_next_page_already");
	$("a[id=_page_no]").attr("id", "_page_no_already");
	$("a[id=_go]").attr("id", "_go_already");
	$("input[id=_go_page]").attr("id", "_go_page_" + _this._form);
	$("input[id=_total_page]").attr("id", "_total_page_" + _this._form);

}

$(function() {
			try {

				if ($("#_page_orderStr_" + _form).size() > 0) {
					_orderStr = $("#_page_orderStr_" + _form).val();
				} else {
					_orderStr = $("#_page_orderStr").val();
					$("#_page_orderStr").attr("id", "_page_orderStr_" + _form);
				}
				new pager(_form, _data, _action, _expression, _orderStr);
			} catch (e) {
			}
		});