function audit2(id) {
	var op = {
		title : '��ʾ',
		drag : false,
		content : 'ȷ��Ҫ������Ϣ�ύ���',
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
							content : '�����ɹ�',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '����Ŀ�Ѳ��ܽ��д˲�����',
							yesFn : true
						});
					} else if (msg == "userError") {
						art.dialog( {
							drag : false,
							content : '�û��Ѹı䣬������ˢ��ҳ�棡',
							yesFn : true
						});
					} else {
						art.dialog( {
							drag : false,
							content : '����ʧ��',
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
		title : '��ʾ',
		drag : false,
		content : 'ȷ���ύ��ˣ�',
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
							content : '�����ɹ�',
							yesFn : function() {
								window.location.href = reURL;
							}
						});

					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '����Ŀ�Ѳ��ܽ��д˲�����',
							yesFn : function() {
								jQuery("#auditDiv").hide();
								jQuery("#ajaxResponseDivRepeat").show();
							}
						});
					} else {
						art.dialog( {
							drag : false,
							content : '����ʧ�ܣ������ԣ�������ϵ����Ա',
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
		title : '��ʾ',
		drag : false,
		content : 'ȷ��Ҫ������Ϣ��ǹ��ڣ�',
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
							content : '�����ɹ�',
							yesFn : function() {
								window.location.reload();
							}
						});
					} else if (msg == "warning") {
						art.dialog( {
							drag : false,
							content : '������Ϣ���ٱ�����ȴ���̨����Ա��˺������Ӧ������',
							yesFn : true
						});
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '����Ŀ�Ѳ��ܽ��д˲�����',
							yesFn : true
						});
					} else {
						art.dialog( {
							drag : false,
							content : '����ʧ��',
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
		title : '��ʾ',
		drag : false,
		content : 'ȷ��ɾ������Ϣ��',
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
							content : 'ɾ���ɹ�',
							yesFn : true
						});
						document.getElementById(id).style.display = "none";
						//window.location.reload();
					} else if (msg == "logicError") {
						art.dialog( {
							drag : false,
							content : '����Ŀ�Ѳ��ܽ��д˲�����',
							yesFn : true
						});
					} else if (msg == "warning") {
						art.dialog( {
							drag : false,
							content : '������Ϣ���ٱ�����ȴ���̨����Ա��˺������Ӧ������',
							yesFn : true
						});
					}
					else {
						art.dialog( {
							drag : false,
							content : 'ɾ��ʧ��',
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
					content : "ԭ��" + data.typeDesc + "��" + (data.reason == null ? "" : data.reason),
					width : 300,
					yesFn : true
				});
			} else if (null != data.mark) {
				art.dialog( {
					drag : false,
					content : "ԭ��" + data.mark,
					width : 300,
					yesFn : true
				});
			}
			else {
				art.dialog( {
					drag : false,
					content : "δ�ҵ������õ������Ϣ",
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
				content : "ԭ��" + data.mark,
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