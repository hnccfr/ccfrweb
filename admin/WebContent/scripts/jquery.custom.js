/*
 * jQuery�Զ���ű���
 * �ṩ����ϵͳ��ͨ��jQuery�Զ���ű����롣
 * 
 * author: zhengdd
 * date: 2010-4-15
 */

//  =================================================================================
// ~ ͨ�ú���
/*
 * ��¼ҳ�浭��������򷽷���
 * author: zhengdd
 * date: 2010-4-15
 */
function login() {
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
 * ��¼ҳ�浭��������򷽷��� author: zhengdd date: 2010-4-15
 */
function welcome() {
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
 * ���µ���idΪ"main"��iframe�Ĵ�С�����ڽ����iframe�ڲ����ͨ��Javascript��̬����html�����
 * iframe�Ĵ�С�����˱仯���ⲿ�ĸ�iframeȴû�����µ�������С�����¸�iframe�Ĳ������ݱ��ڵ��� 
 * author: zhengdd 
 * date:2010-4-15
 */
function resizeMainIframe() {
	var mainIframe = jQuery("#main", parent.document.body)[0];
	jQuery("#main", parent.document.body).attr("height",
			mainIframe.contentWindow.document.documentElement.scrollHeight);
}

//=================================================================================
//~ ͨ�ü��ؽű�
/*
 * ����ǰһҳ�� 
 * ע�����ذ�ť��id����Ϊ��back����
 * author: zhengdd 
 * date: 2010-4-15
 */
$(function() {
	$("#back").click(function() {
		history.back(-1);
		return false;
	});
});
/*
 * �˵�չ���������� 
 * author: zhengdd 
 * date: 2010-4-15
 */
$(function() {
	$("div .menu :header").click(function() {
		$(this).next("ul").slideToggle("normal", function() {
			$(this).prev(":header").toggleClass("menu-closed");
		});
		window.name = $(this).prevAll("#modules :header").length;
		if ($(this).hasClass("menu-closed")) {
			$(this).siblings(":header").each(function(i, e) {
				if (!$(e).hasClass("menu-closed")) {
					$(e).next("ul").slideUp("normal", function() {
						$(this).prev(":header").toggleClass("menu-closed");
					});
				}
			});
		}
	});
});
/*
 * ���˵���ʾ�� 
 * author: zhengdd 
 * date: 2010-4-15
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
 * ȫѡcheckbox��ȫѡ���ܡ� 
 * author: zhengdd 
 * date: 2010-4-15
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