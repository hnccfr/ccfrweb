$(function() {
	$("#addressList")
			.dialog(
					{
						autoOpen : false,
						bgiframe : true,
						modal : true,
						position : [ 'center', 200 ],
						width : 700,
						title : "选择地址",
						buttons : {
							"确认" : function() {
								if (typeof ($("input[name='address']:checked")
										.val()) != "undefined"
										&& $("input[name='address']:checked")
												.val() != "") {
									$
											.ajax( {
												type : 'POST',
												url : appServer + '/user/select.htm',
												data : {
													id : $(
															"input[name='address']:checked")
															.val()
												},
												success : function(msn) {
													if (id1 != "") {
														var linkmanObj = $("#"
																+ id1);
														if (linkmanObj) {
															linkmanObj
																	.attr(
																			"value",
																			msn.linkman);
														}
													}
													if (id2 != "") {
														var phoneObj = $("#"
																+ id2);
														if (phoneObj) {
															phoneObj.attr(
																	"value",
																	msn.phone);
														}
													}
													if (id3 != "") {
														var provinceObj = $("#"
																+ id3);
														if (provinceObj) {
															provinceObj
																	.attr(
																			"value",
																			msn.province);
														}
													}
													if (id4 != ""
															&& $("#" + id4)) {
														$("#" + id4).attr(
																"value",
																msn.city);
													}
													if (id5 != ""
															&& $("#" + id5)) {
														$("#" + id5).attr(
																"value",
																msn.area);
													}
													if (id6 != ""
															&& $("#" + id6)) {
														$("#" + id6).attr(
																"value",
																msn.address);
													}
													if (id7 != ""
															&& $("#" + id7)) {
														$("#" + id7).attr(
																"value",
																msn.zipCode);
													}
													if (id8 != ""
															&& $("#" + id8)) {
														$("#" + id8).attr(
																"value",
																msn.storehouse);
													}
													new Area(appServer
															+ "/ajax",
															msn.province,
															msn.city, msn.area,
															'pe_province',
															'pe_city',
															'pe_area');

												}
											});
								}
								$(this).dialog("close");
							}
						}
					});
	$("#addressList").bind(
			"dialogopen",
			function(event, ui) {
				$("#addressList").load(
						appServer + "/user/addressDiv.htm?type=" + type
								+ "&account=" + account + "&dd="
								+ new Date().getTime());
			});
	$("#addressList").bind("dialogclose", function(event, ui) {
		this.type = "";
		$(this).empty();
	});
});

var account = "";// 用户账号
var type = "";// 地址类型（P:收货地址；S：仓库地址）
var id1 = "";// 存放联系人的标签id
var id2 = "";// 存放联系人电话的标签id
var id3 = "";// 存放省的标签id
var id4 = "";// 存放市的标签id
var id5 = "";// 存放地区/县的标签id
var id6 = "";// 存放详细地址的标签id
var id7 = "";// 存放所在地邮编的标签id
var id8 = "";// 存放仓库名称

function chooseAddress(account, type, id1, id2, id3, id4, id5, id6, id7, id8) {
	this.account = account;
	this.type = type;
	this.id1 = id1;
	this.id2 = id2;
	this.id3 = id3;
	this.id4 = id4;
	this.id5 = id5;
	this.id6 = id6;
	this.id7 = id7;
	this.id8 = id8;
	var addressListObj = $("#addressList");
	if (addressListObj.length > 0)
		addressListObj.dialog("open");
	else
		alert("弹出层的div没有配置！");
}

function chooseAddressArtDailog(account, type, id1, id2, id3, id4, id5, id6,
		id7, id8) {
	this.account = account;
	this.type = type;
	this.id1 = id1;
	this.id2 = id2;
	this.id3 = id3;
	this.id4 = id4;
	this.id5 = id5;
	this.id6 = id6;
	this.id7 = id7;
	this.id8 = id8;
	var addressListObj = $("#addressList");
	if (addressListObj.length > 0) {
		var option = {
			id : "addressList",
			title : '会员选择',
			drag : true,
			lock : true,
			padding : 3,
			width : 620,
			// height : 260,
			yesText : '确认',
			noText : '取消',
			yesFn : function() {
				if (typeof ($("input[name='address']:checked").val()) != "undefined"
						&& $("input[name='address']:checked").val() != "") {
					$.ajax( {
						type : 'POST',
						url : appServer + '/user/select.htm',
						data : {
							id : $("input[name='address']:checked").val()
						},
						success : function(msn) {
							if (id1 != "") {
								var linkmanObj = $("#" + id1);
								if (linkmanObj) {
									linkmanObj.attr("value", msn.linkman);
								}
							}
							if (id2 != "") {
								var phoneObj = $("#" + id2);
								if (phoneObj) {
									phoneObj.attr("value", msn.phone);
								}
							}
							if (id3 != "") {
								var provinceObj = $("#" + id3);
								if (provinceObj) {
									provinceObj.attr("value", msn.province);
								}
							}
							if (id4 != "" && $("#" + id4)) {
								$("#" + id4).attr("value", msn.city);
							}
							if (id5 != "" && $("#" + id5)) {
								$("#" + id5).attr("value", msn.area);
							}
							if (id6 != "" && $("#" + id6)) {
								$("#" + id6).attr("value", msn.address);
							}
							if (id7 != "" && $("#" + id7)) {
								$("#" + id7).attr("value", msn.zipCode);
							}
							if (id8 != "" && $("#" + id8)) {
								$("#" + id8).attr("value", msn.storehouse);
							}
							new Area(appServer + "/ajax", msn.province,
									msn.city, msn.area, 'pe_province',
									'pe_city', 'pe_area');

						}
					});
				}
				$(this).dialog("close");
			},
			noFn : true
		};
		art.dialog.load(appServer + "/user/addressDiv.htm?type=" + type
				+ "&account=" + account + "&dd=" + new Date().getTime(),
				option, false);

	} else {
		alert("弹出层的div没有配置！");
	}
}
