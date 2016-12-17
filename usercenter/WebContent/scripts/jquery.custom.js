/*
 * jQuery�Զ���ű�
 * �ṩ����ϵͳ��ͨ��jQuery�Զ���ű�����
 * 
 * author: zhengdd
 * date: 2010-4-15
 */

/*
 * ��¼ҳ�浭��������򷽷�
 */
function JQ_login() {
	$(".login-box").hide();
	$(".login-box").fadeIn(1000);
	$(".inp").bind("focus", function() {
		$(this).addClass("inp2");
	});
	$(".inp").bind("blur", function() {
		$(this).removeClass("inp2");
	});
}
/*
 * ��¼ҳ�浭��������򷽷�
 */
function JQ_welcome() {
	$(".wel-bg").animate( {
		left : "150px",
		top : "60px",
		height : "250px",
		width : "500px"
	}, 800, function() {
		$(".wel-nr").show(400);
	});
}
/*
 * ���µ���idΪ"main"��iframe�Ĵ�С, ���ڽ����iframe�ڲ����ͨ��Javascript��̬����html�����, 
 * iframe�Ĵ�С�����˱仯���ⲿ�ĸ�iframeȴû�����µ�������С, ���¸�iframe�Ĳ������ݱ��ڵ�
 */
function resizeMainIframe() {
	var mainIframe = jQuery("#main", parent.document.body)[0];
	jQuery("#main", parent.document.body).attr("height",
			mainIframe.contentWindow.document.documentElement.scrollHeight);
}
/*
 * ��½ҳ������½
 */
jQuery(function(){
    jQuery("#logins").click(function() {
		jQuery("#loginForm").submit();
	});
});
/*
 * fromid:Դlist��id. toid:Ŀ��list��id. moveOrAppend����("move"������"append"): move --
 * Դlist��ѡ�е�option��ɾ��.Դlist��ѡ�е�option�ƶ���Ŀ��list��,��Ŀ��list���Ѵ������option�����. append --
 * Դlist��ѡ�е�option����ɾ��.Դlist��ѡ�е�option��ӵ�Ŀ��list�ĺ���,��Ŀ��list���Ѵ������option�����.
 * 
 * isAll����(true����false):�Ƿ�ȫ���ƶ������
 */
jQuery.listTolist = function(fromid, toid, moveOrAppend, isAll) {
	if (moveOrAppend.toLowerCase() == "move") { // �ƶ�
		if (isAll == true) { // ȫ���ƶ�
			$("#" + fromid + " option").each(function() {
				// ��Դlist�е�option��ӵ�Ŀ��list,��Ŀ��list�����и�optionʱ�����κβ���.
					$(this).appendTo(
							$("#" + toid + ":not(:has(option[value="
									+ $(this).val() + "]))"));
				});
			$("#" + fromid).empty(); // ���Դlist
		} else if (isAll == false) {
			$("#" + fromid + " option:selected")
					.each(function() {
						// ��Դlist�е�option��ӵ�Ŀ��list,��Ŀ��list�����и�optionʱ�����κβ���.
							$(this).appendTo(
									$("#" + toid + ":not(:has(option[value="
											+ $(this).val() + "]))"));
							// Ŀ��list���Ѿ����ڵ�option��û���ƶ�,�Ծ���Դlist��,�������.
							if ($("#" + fromid + " option[value="
									+ $(this).val() + "]").length > 0) {
								$("#" + fromid).get(0).removeChild(
										$(
												"#" + fromid + " option[value="
														+ $(this).val() + "]")
												.get(0));
							}
						});
		}
	} else if (moveOrAppend.toLowerCase() == "append") {
		if (isAll == true) {
			$("#" + fromid + " option").each(
					function() {
						$("<option></option>").val($(this).val()).text(
								$(this).text()).appendTo(
								$("#" + toid + ":not(:has(option[value="
										+ $(this).val() + "]))"));
					});
		} else if (isAll == false) {
			$("#" + fromid + " option:selected").each(
					function() {
						$("<option></option>").val($(this).val()).text(
								$(this).text()).appendTo(
								$("#" + toid + ":not(:has(option[value="
										+ $(this).val() + "]))"));
					});
		}
	}
};
/*
 * ���ܴ���ͬ��("move"). ��֮ͬ�����ڵ�Դlist�е�ѡ��option��Ŀ��list�д���ʱ,Դlist�е�option����ɾ��.
 * 
 * isAll����(true����false):�Ƿ�ȫ���ƶ������
 */
jQuery.list2list = function(fromid, toid, isAll) {
	if (isAll == true) {
		$("#" + fromid + " option").each(
				function() {
					$(this).appendTo(
							$("#" + toid + ":not(:has(option[value="
									+ $(this).val() + "]))"));
				});
	} else if (isAll == false) {
		$("#" + fromid + " option:selected").each(
				function() {
					$(this).appendTo(
							$("#" + toid + ":not(:has(option[value="
									+ $(this).val() + "]))"));
				});
	}
};
/*
 * ����ǰһҳ
 */
$(function() {
	$("#back").click(function() {
		history.back(-1);
		return false;
	});
});
/*
 * �˵�չ��������
 */
$(function() {
	$("div .menu :header").click(function() {
		$(this).next("ul").slideToggle("normal", function() {
			$(this).prev(" :header").toggleClass("menu-closed");
		});
		window.name = $(this).prevAll("#modules :header").length;
		if ($(this).hasClass("menu-closed")) {
			$(this).siblings(":header").each(function(i, e) {
				if (!$(e).hasClass("menu-closed")) {
					$(e).next("ul").slideUp("normal", function() {
						$(this).prev(" :header").toggleClass("menu-closed");
					});
				}
			});
		}
	});
});
/*
 * ���˵���ʾ
 */
$(function() {
	jQuery.loadMenu = function(tabnum, menunum) {
		$("div .menu").each(function(i, e) {
			if (tabnum == i) {
				$(e).show();
				$(e).find(":header").each(function(i2, e2) {
					if (i2 == menunum) {
						$(this).removeClass("menu-closed");
						$(this).next("ul").show();
					} else {
						$(this).addClass("menu-closed");
						$(this).next("ul").hide();
					}
				});
			} else {
				$(e).hide();
			}
		});
	};
});
/*
 * ȫѡ
 */
$(function() {
	$(".list-table .all-checkbox").click(function() {
		if ($(".list-table .all-checkbox").is(":checked")) {
			$(".list-table .row-checkbox").each(function() {
				$(this).attr("checked", "checked");
			});
		} else {
			$(".list-table input[type=checkbox]").each(function() {
				$(this).removeAttr("checked");
			});
		}
	});
});
/*
 * �����˵��л�
 */
$(function() {
	$(".body-top .nav a").click(function() {
		var curli = $(this).parent();
		curli.parent().find("li").remove(".front");
		var size = curli.parent().children("li").length;
		var num = curli.prevAll("li").length;
		curli.addClass("c");
		curli.siblings("li").each(function(i, e) {
			$(e).removeClass("c");
			if (num + 1 != size && i + 2 == size) {
				$(e).addClass("last");
			}
		});
		if (num + 1 == size) {
			curli.removeClass("last");
		}
		if (num > 0) {
			curli.parent().prepend("<li class='front'> </li>");
		}
		jQuery.loadMenu(num, 0);
	});
});
/*
 * �������
 */
$(function() {
	$("a[id=delDate]").click(function() {
		$(this).siblings("input").each(function(i, e) {
			$(e).val("");
		});
	});
});
var _form;
var _data;
var _action;
var _expression;
function paginate(p) {
	if (_form == "" && _action == "" && _expression == "") {
		var url = window.location.href;
		if (url.indexOf("?") != -1) {
			if (url.charAt(url.length - 1) != "&") {
				window.location.href = url + "&pageNo=" + p;
			} else {
				window.location.href = url + "pageNo=" + p;
			}
		} else {
			window.location.href = url + "?pageNo=" + p;
		}
	} else if (_form != "") {
		if (_action != "") {
			// TODO;
		}
		if (_expression != "") {
			$("#" + _form).append("<input type='hidden' name='" + _expression + "' value='" + p + "' />");
		} else {
			$("#" + _form + " input[type=hidden][name=pageNo]").remove();
			$("#" + _form).append("<input type='hidden' name='pageNo' value='" + p + "' />");
		}
		if (_data != "") {
			$("#" + _data).load(_action, $("#" + _form).serialize());
		} else {
			$("#" + _form).submit();
		}	
	}
}
function bindPager() {
	$("#_page a[id=_pre_page],#_page a[id=_next_page]").live("click", function() {
		paginate($.trim($(this).next().val()));
	});
	$("#_page a[id=_none_pre_page],#_page a[id=_none_next_page]").live("click", function() {
		return false;
	});
	$("#_page a[id=_page_no]").live("click", function() {
		paginate($.trim($(this).text()));
	});
	$("#_page a[id=_go]").live("click", function() {
		var p = $.trim($("#_page input[id=_go_page]").val());
		var pTotal = $.trim($("#_page input[id=_total_page]").val());
		if (p.isBlank()) {
			alert("������ҳ��");
			return;
		}
		if (isNaN(p)) {
			alert("��������ȷ��ҳ��");
			return;
		}
		if (parseInt(p) <= 0) {
			p = "1";
		} else if (parseInt(p) >= parseInt(pTotal) ) {
			p = pTotal;
		}
		paginate(p);
		return false;
	});
}
$(function() {
	bindPager();
});