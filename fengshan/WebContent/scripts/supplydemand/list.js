function audit2(id) {
	var op = {
		title : '提示',
		drag : false,
		content : '确定要将本信息提交审核',
		yesFn : function() {
			var prjId = id;
			jQuery.ajax( {
				type : 'POST',
				url : appServer + '/supplydemand/subAudit.htm',
				data : {
					projectId : prjId
				},
				success : function(msg) {
					if (msg == "success") {
						art.dialog( {
							drag : false,
							content : '操作成功',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '本项目已不能进行此操作！',
							yesFn : true
						});
					} else if (msg == "userError") {
						art.dialog( {
							drag : false,
							content : '用户已改变，请重新刷新页面！',
							yesFn : true
						});
					} else {
						art.dialog( {
							drag : false,
							content : '操作失败',
							yesFn : true
						});
					} //end of else
				} //end of success : function(msg)
			}); //end of jQuery.ajax
		}, //end of yesFn : function()
		noFn : true
	};
	art.dialog(op);
}

function audit3() {
	var op = {
		title : '提示',
		drag : false,
		content : '确认提交审核？',
		yesFn : function() {
			var reURL = appServer + jQuery("#reURL").val();
			var prjId = jQuery("#supplyDemandInfoId").val();
			jQuery.ajax( {
				type : 'POST',
				url : appServer + '/supplydemand/subAudit.htm',
				data : {
					projectId : prjId
				},
				success : function(msg) {
					if (msg == "success") {
						art.dialog( {
							drag : false,
							content : '操作成功',
							yesFn : function() {
								window.location.href = reURL;
							}
						});

					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '本项目已不能进行此操作！',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else {
						art.dialog( {
							drag : false,
							content : '操作失败！请重试，或者联系管理员',
							yesFn : true
						});
					}
				}
			});
		},
		noFn : true
	};
	art.dialog(op);
}

function overdue(id) {
	var op = {
		title : '提示',
		drag : false,
		content : '确定要将本信息标记过期？',
		yesFn : function() {
			var prjId = id;
			jQuery.ajax( {
				type : 'POST',
				url : appServer + '/supplydemand/markOverdue.htm',
				data : {
					projectId : prjId
				},
				success : function(msg) {
					if (msg == "success") {
						art.dialog( {
							drag : false,
							content : '操作成功',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "warning") {
						art.dialog( {
							drag : false,
							content : '您的信息被举报，请等待后台管理员审核后进行相应操作！',
							yesFn : true
						});
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '本项目已不能进行此操作！',
							yesFn : true
						});
					} else {
						art.dialog( {
							drag : false,
							content : '操作失败',
							yesFn : true
						});
					} //end of else
				} //end of success : function(msg)
			}); //end of jQuery.ajax
		}, //end of yesFn : function()
		noFn : true
	};
	art.dialog(op);
}

function deletePro1(id) {
	var op = {
		title : '提示',
		drag : false,
		content : '确认删除本信息吗？',
		yesFn : function() {
			var prjId = id;
			jQuery.ajax( {
				type : 'POST',
				url : appServer + '/supplydemand/deleteInfo.htm',
				data : {
					projectId : prjId
				},
				success : function(msg) {
					if (msg == "success") {
						art.dialog( {
							drag : false,
							content : '删除成功',
							yesFn : true
						});
						document.getElementById(id).style.display = "none";
						//window.location.reload();
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '本项目已不能进行此操作！',
							yesFn : true
						});
					} else if (msg == "warning") {
						art.dialog( {
							drag : false,
							content : '您的信息被举报，请等待后台管理员审核后进行相应操作！',
							yesFn : true
						});
					}
					else {
						art.dialog( {
							drag : false,
							content : '删除失败',
							yesFn : true
						});
					}
				}
			});
		},
		noFn : true
	};
	art.dialog(op);
}

function viewAccuseInfo(id) {
	var prjId = id;
	jQuery.ajax( {
		type : 'POST',
		url : appServer + '/supplydemand/viewAccuseInfo.htm',
		data : {
			projectId : prjId
		},
		success : function(data) {
			if (null != data.typeDesc) {
				art.dialog( {
					drag : false,
					content : "原因：" + data.typeDesc + "。" + (data.reason == null ? "" : data.reason),
					width : 300,
					yesFn : true
				});
			} else if (null != data.mark) {
				art.dialog( {
					drag : false,
					content : "原因：" + data.mark,
					width : 300,
					yesFn : true
				});
			}
			else {
				art.dialog( {
					drag : false,
					content : "未找到被禁用的相关信息",
					yesFn : true
				});
			}
		}
	});
}

function viewAuditInfo(id) {
	var prjId = id;
	jQuery.ajax( {
		type : 'POST',
		url : appServer + '/supplydemand/viewAuditInfo.htm',
		data : {
			projectId : prjId
		},
		success : function(data) {
			art.dialog( {
				drag : false,
				content : "原因：" + data.mark,
				width : 300,
				yesFn : true
			});
		}
	});
}

function clearMsg() {
	jQuery("#projectTypeName").attr("value", "");
	jQuery("#projectTypeCode").attr("value", "");
	jQuery("#title").attr("value", "");
	jQuery("#status").attr("value", "");
	jQuery("#projectCode").attr("value", "");
	jQuery("#infoType").attr("value", "");
	jQuery("#effectiveStartDateFrom").attr("value", "");
	jQuery("#effectiveStartDateTo").attr("value", "");
	jQuery("#effectiveEndDateFrom").attr("value", "");
	jQuery("#effectiveEndDateTo").attr("value", "");
}