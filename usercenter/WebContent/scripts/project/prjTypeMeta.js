var prjTypeUrl = {
	nodesURL : appServer + "/ajax/getProjectTypeTree.htm",
	prjTypeMetaFormURL : appServer + "/project/type/attri.htm",
	prjTradeTypeFormURL : appServer + "/project/tradeType/attri.htm?dd="
			+ new Date().getTime(),
	projectStandURL : appServer + "/project/standard.htm"
};
var metaErrors = "";
var metaSubmitValue = "";
$(function() {
	metaErrors = $("#metaErrors").val();
	metaSubmitValue = $("#metaSubmitValue").val();
	if (typeof (metaErrors) != 'undefined' && metaErrors && metaErrors != "") {
		metaErrors = eval('(' + metaErrors + ')'); // ��̬���Ե���ʾ����
	}
	if (typeof (metaSubmitValue) != 'undefined' && metaSubmitValue
			&& metaSubmitValue != "") {
		metaSubmitValue = eval('(' + metaSubmitValue + ')'); // ���Ե��ϴ��ύ�ı���ֵ
	}
});

// ���Ͷ�̬���Ա�����,�����л�����ʱ,����������ݶ�ʧ
var prjTypeMetaFormCache = {};
// ��Ŀ�Ľ������Ա�����
var projectTradeFormCache = {};
var a = new Array();
// ���������ݻ���
var prjTypeTree;
/**
 * 
 * @param followObj
 *            ������Ҫ����İ�ť�������(Ԫ�ض���,��Ԫ��ID)
 * @param yesFn
 *            ѡ���Ļص�����,����Ϊѡ�еĶ���,
 *            �ṹΪ{code:value,name:value,parentcode:value,parentcodeShort:value}
 * @param valueClass
 *            Ĭ�ϴ���ʱ,��ѡ�������codeҪ�����HTML��ǩClass,Ĭ��Ϊ:projectTypeCode
 * @param nameClass
 *            Ĭ�ϴ���ʱ,��ѡ�������nameҪ�����HTML��ǩClass,Ĭ��Ϊ:projectTypeName
 * @param prjTypeMetaBoxId
 *            Ĭ�ϴ���ʱ,������ѡ�������,��̬�����������ȡ�����͵Ķ�̬���Ա�,����ʾ��prjTypeMetaBoxId������,Ĭ��Ϊ:prjTypeMetaBox
 */
function showPrjTypeSel(followObj, yesFn, valueClass, nameClass,
		prjTypeMetaBoxId) {
	showPrjTypeArtBox(followObj,
			'<span style="color:green;">���ڼ�����Ŀ����,���Ժ�...</span>', function() {
			});
	var prjTypeTreeUL_Tmp = $("#prjTypeTreeUL");
	if (!prjTypeTreeUL_Tmp || prjTypeTreeUL_Tmp.length == 0) {
		prjTypeTreeUL_Tmp = $('<ul id="prjTypeTreeUL" class="tree" style="display:none;"></ul>');
		$("body").append(prjTypeTreeUL_Tmp);
		prjTypeTree = reloadPrjTypeTree('prjTypeTreeUL', null, function(event,
				treeId, treeNode, msg) {
			showPrjTypeArtBox(followObj, '', yesFn, valueClass, nameClass,
					prjTypeMetaBoxId);
		}, function(event, treeId, treeNode, XMLHttpRequest, textStatus,
				errorThrown) {
			prjTypeTreeUL_Tmp.remove();
			showPrjTypeArtBox(followObj,
					'<span style="color:red;">������Ŀ����ʧ��!���Ժ�����!</span>',
					function() {
					});
		});
	} else {
		showPrjTypeArtBox(followObj, '', yesFn, valueClass, nameClass,
				prjTypeMetaBoxId);
	}
}
function showPrjTypeArtBox(followObj, content, yesFn, valueClass, nameClass,
		prjTypeMetaBoxId) {
	var op = {
		id : "prjTypeSelBox",
		title : "��ѡ����Ŀ����!",
		drag : true,
		// lock : true,
		padding : 0,
		fixed : true,
		content : document.getElementById('prjTypeTreeUL'),
		yesFn : function() {
			var data = prjTypeTree.getSelectedNode()
			fn = yesFn || defaultPrjTypeSelYesFn;
			fn(data, valueClass, nameClass, prjTypeMetaBoxId);
//			$("select").attr("disabled", "");// ҵ���������Ϳ�رպ��׼���Կɱ༭
		return data;
	},
	noFn : function() {
//		$("select").attr("disabled", "");// ҵ���������Ϳ�رպ��׼���Կɱ༭
	}
	};
	if (content)
		op.content = content;
	if (typeof (followObj) == "object")
		op.follow = followObj;
	else if (typeof (followObj) == "string")
		op.follow = document.getElementById(followObj);
	try {
		art.dialog.list['prjTypeSelBox'].close();
	} catch (e) {
	}
//	$("select").attr("disabled", "disabled");// ҵ�������ڵ�����̬���Ϳ��ʱ����ѡ���׼����
	art.dialog(op);
}

/**
 * Ĭ�ϵ�ѡ���ȷ����ť����
 * 
 * @param data
 *            �ṹΪ{code:value,name:value,parentcode:value,parentcodeShort:value}
 * @param valueClassDefault
 *            Ĭ�ϴ���ʱ,��ѡ�������codeҪ�����HTML��ǩClass,Ĭ��Ϊ:projectTypeCode
 * @param nameClassDefault
 *            Ĭ�ϴ���ʱ,��ѡ�������nameҪ�����HTML��ǩClass,Ĭ��Ϊ:projectTypeName
 * @param prjTypeMetaBoxId
 *            Ĭ�ϴ���ʱ,������ѡ�������,��̬�����������ȡ�����͵Ķ�̬���Ա�,����ʾ��prjTypeMetaBoxId������,Ĭ��Ϊ:prjTypeMetaBox
 */
function defaultPrjTypeSelYesFn(data, valueClass, nameClass, prjTypeMetaBoxId) {
	if (!data)
		return;
	valueClass = valueClass || "projectTypeCode";
	nameClass = nameClass || "projectTypeName";
	prjTypeMetaBoxId = prjTypeMetaBoxId || "prjTypeMetaBox";

	var curType = "";
	if ($(":input." + valueClass).length > 0)
		curType = $($(":input." + valueClass)[0]).val();

	$("#" + valueClass).val(data.code);
	$("#" + nameClass).val(data.name);
	$("span." + valueClass).text(data.code);
	$("span." + nameClass).text(data.name);
	// ����ѡ�����Ŀ���ͱ��룬��ȥȡ��׼����
	$
			.ajax( {
				type : "GET",
				cache : false,
				url : prjTypeUrl.projectStandURL,
				dataType : "json",
				// drag : true,
				// lock : true,
				data : "projectTypeCode=" + data.code,
				async : false,
				success : function(projectStandObject) {
					if (projectStandObject && projectStandObject.length > 0) { // ��Ŀ���Ͱ�����̬����
						$("#breedStandardSelect").empty(); // ��ձ�׼���������б�ѡ��
						$("#breedStandardSelect").append(
								"<option value='0'>��ѡ��</option>");
						for ( var i = 0; i < projectStandObject.length; i++) {
							$("#breedStandardSelect").append(
									"<option value='"
											+ projectStandObject[i].id + "'>"
											+ projectStandObject[i].name
											+ "</option>");
						}

					} else { // �޶�̬����

					}
				}
			});
	$("#standShowId").empty();
	var breedStandard = $("#breedStandard");
	var breedStandardId = $("#breedStandardId");
	if (breedStandard && breedStandard != "undefined") {
		breedStandard.val("");
	}
	if (breedStandardId && breedStandardId != "undefined") {
		breedStandardId.val("");
	}
	// ��ǰ����
	var prjTypeMetaBox = $("#" + prjTypeMetaBoxId);
	if (!prjTypeMetaBox || prjTypeMetaBox.length == 0)
		return;

	if (curType) {
		prjTypeMetaFormCache[curType] = prjTypeMetaBox.html();
	}
	loadPrjTypeMetaFormURL(data.code, valueClass, nameClass, prjTypeMetaBoxId,
			""); // --���ض�̬����

	// $("#breedStandardSelect").empty(); // ��ձ�׼���������б�ѡ��
}
/**
 * ������Ŀ���Ͷ�̬����
 * 
 * @param typeCode
 * @param valueClass
 * @param nameClass
 * @param prjTypeMetaBoxId
 * @param projectId
 * @return
 */
function loadPrjTypeMetaFormURL(typeCode, valueClass, nameClass,
		prjTypeMetaBoxId, projectId) {

	valueClass = valueClass || "projectTypeCode";
	nameClass = nameClass || "projectTypeName";
	prjTypeMetaBoxId = prjTypeMetaBoxId || "prjTypeMetaBox";
	projectId = projectId || "";

	// ��װ��
	var prjTypeMetaBox = $("#" + prjTypeMetaBoxId);
	if (!prjTypeMetaBox || prjTypeMetaBox.length == 0)
		return;
	prjTypeMetaBox.show();//add by guowei 2012-3-13,ǿ�ƶ�̬���Բ���ʾ
	// ��������д��� , ��ȡ�����, ���������������װ��
	if (prjTypeMetaFormCache[typeCode]) {
		prjTypeMetaBox.html(prjTypeMetaFormCache[typeCode]);
	} else {
		prjTypeMetaBox.after("<div id='tmp_msg-tip'>���ڼ��ض�̬������,���Ժ�...</div>");
		prjTypeMetaBox.load(prjTypeUrl.prjTypeMetaFormURL, {
			typeCode : typeCode,
			projectId : projectId
		}, function(responseText, textStatus, XMLHttpRequest) {
			$("#tmp_msg-tip").remove()
			onCompleteValueSeting("dynamic");
		});
	}
}
/**
 * ������Ŀ�Ľ�������
 * 
 * @param tradeTypeStr
 * @param prjTradeTypeBoxId
 * @param pid
 * @return
 */
function loadPrjTradeTypeFormURL(tradeTypeStr, prjTradeTypeBoxId, pid) {

	prjTradeTypeBoxId = prjTradeTypeBoxId || "prjTradeTypeBoxId";
	pid = pid || "";

	// ��װ��
	var prjTradeTypeBox = $("#" + prjTradeTypeBoxId);
	if (!prjTradeTypeBox || prjTradeTypeBox.length == 0)
		return;

	// ��������д��� , ��ȡ�����, ���������������װ��
	if (typeof (projectTradeFormCache) != "undefined"
			&& projectTradeFormCache[tradeTypeStr]) {
		if ("placeOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[0]);
		if ("bidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[1]);
		if ("dynamic" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[2]);
		if ("mulitBidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[3]);
		if ("transferOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[4]);
		if ("tenderOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[5]);

		prjTradeTypeBox.html(projectTradeFormCache[tradeTypeStr]);
	} else {
		prjTradeTypeBox.after("<div id='tmp_msg-tip'>���ڼ��ؽ���������,���Ժ�...</div>");
		prjTradeTypeBox.load(prjTypeUrl.prjTradeTypeFormURL, {
			tradeType : tradeTypeStr,
			projectId : pid
		}, function(responseText, textStatus, XMLHttpRequest) {
			$("#tmp_msg-tip").remove();
			onCompleteErrorShow(tradeTypeStr);
			onCompleteValueSeting(tradeTypeStr);
			// onCompleteEventBinder(tradeTypeStr);
			if (tradeTypeStr) {
				projectTradeFormCache[tradeTypeStr] = prjTradeTypeBox
							.html();
			}
			});
	}

}


/**
 * <��д>������Ŀ�Ľ�������
 * �µ����׵��������Ҫ������������������Ե���ʾ
 *	�����������͵Ĳ���bsType
 * @param tradeTypeStr
 * @param prjTradeTypeBoxId
 * @param pid
 * add by guowei 2012-3-19
 */
function loadPrjTradeTypeDisByBsType(tradeTypeStr, prjTradeTypeBoxId, pid, bsType) {

	prjTradeTypeBoxId = prjTradeTypeBoxId || "prjTradeTypeBoxId";
	pid = pid || "";

	// ��װ��
	var prjTradeTypeBox = $("#" + prjTradeTypeBoxId);
	if (!prjTradeTypeBox || prjTradeTypeBox.length == 0)
		return;

	// ��������д��� , ��ȡ�����, ���������������װ��
	if (typeof (projectTradeFormCache) != "undefined"
			&& projectTradeFormCache[tradeTypeStr]) {
		if ("placeOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[0]);
		if ("bidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[1]);
		if ("dynamic" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[2]);
		if ("mulitBidOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[3]);
		if ("transferOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[4]);
		if ("tenderOrder" == tradeTypeStr)
			prjTradeTypeBox.html(projectTradeFormCache[5]);

		prjTradeTypeBox.html(projectTradeFormCache[tradeTypeStr]);
	} else {
		//var url = appServer + "/project/tradeType/attri.htm";
		prjTradeTypeBox.after("<div id='tmp_msg-tip'>���ڼ��ؽ���������,���Ժ�...</div>");
		prjTradeTypeBox.load(prjTypeUrl.prjTradeTypeFormURL, {
			tradeType : tradeTypeStr,
			projectId : pid,
			bsType : bsType
		}, function(responseText, textStatus, XMLHttpRequest) {
				$("#tmp_msg-tip").remove();
				onCompleteErrorShow(tradeTypeStr);
				onCompleteValueSeting(tradeTypeStr);
				// onCompleteEventBinder(tradeTypeStr);
				if (tradeTypeStr) {
						projectTradeFormCache[tradeTypeStr] = prjTradeTypeBox
								.html();
				}
				if(tradeTypeStr == "placeOrder"){
					renderPlaceOrderTradeMeta(tradeTypeStr);
				}
			});
	}

}

/**�µ��������Լ�����ɺ���Ⱦ�µ��������Ե���ʽ
 * add by guowei 2012-3-22
 * **/
function renderPlaceOrderTradeMeta(tradeType){
	if(tradeType =="placeOrder"){
		var bsTypeObj = $("input[id='retail']:checked");
		if (bsTypeObj.length !=0){
			var bsType = bsTypeObj.val();
			if( bsType == "N" ){
					$("#multipleBase").attr("readonly", "readonly")
							.css({"background":"none repeat scroll 0 0 #D3D3D3"});
					$("#minQuantity").attr("readonly", "readonly")
							.css({"background":"none repeat scroll 0 0 #D3D3D3"});
					$("#maxQuantity").attr("readonly", "readonly")
							.css({"background":"none repeat scroll 0 0 #D3D3D3"});
			}
		}
	}
}



// ��̬���Լ��������
function onCompleteErrorShow(tradeType) {
	if (tradeType && "placeOrder" == tradeType) {// �µ����׵Ľ������Է��������ʾ
		placeOrderErrorShow()
	} else if (tradeType && ("bidOrder" == tradeType)) { // �������׵Ľ������Է��������ʾ
		bidOrderErrorShow()
	} else if (tradeType && "mulitBidOrder" == tradeType) { // �������׵Ľ������Է��������ʾ
		mulitBidOrderErrorShow()
	} else if (tradeType && "transferOrder" == tradeType) { // Э��ת�ý��׵Ľ������Է��������ʾ
		transferOrderErrorShow()
	} else if (tradeType && "tenderOrder" == tradeType) { // �б�ת�ý��׵Ľ������Է��������ʾ
		tenderOrderErrorShow()
	} else if (tradeType && "dynamic" == tradeType) {// ��̬���Է��������ʾ
		dynamicErrorShow()
	}
	commonErrorShow();// ͨ��ģ��Ĵ�����ʾ
}
function commonErrorShow() {
	// �ϴ�ͼƬ����
	if (metaErrors.fileErrorDiv) {
		$("#fileErrorDiv_remind_show_message").html(metaErrors.fileErrorDiv);
	}
	if(metaErrors.attachedFile){
		$("#attachedFile_remind_show_message").html(metaErrors.attachedFile);
	}
}
/**
 * �������Լ����꣬Ϊ��̬���ɵĲ��ֽ����������ԣ�����¼�
 * 
 * @param tradeType
 * @return
 */
function onCompleteEventBinder(tradeType) {
	if (tradeType && "placeOrder" == tradeType) {// �µ����׵Ľ������Է��������ʾ
	} else if (tradeType && ("bidOrder" == tradeType)) { // �������׵Ľ������Է��������ʾ
	} else if (tradeType && ("transferOrder" == tradeType)) { // �������׵Ľ������Է��������ʾ
	} else if (tradeType && ("tenderOrder" == tradeType)) { // �������׵Ľ������Է��������ʾ
	} else if (tradeType && "dynamic" == tradeType) {// ��̬���Է��������ʾ
	} else if (tradeType && "mulitBidOrder" == tradeType) {
	}

}
/**
 * �µ����׵ĺ�̨��֤������ʾ
 * 
 * @return
 */
function placeOrderErrorShow() {
	if (metaErrors) {
		if (metaErrors.retail) {
			$("#retail_remind_show_message").html( // �Ƿ�����
					metaErrors.retail);
		}
		if (metaErrors.multipleBase) {
			$("#multipleBase_remind_show_message").html( // �µ���������
					metaErrors.multipleBase);
		}
		if (metaErrors.minQuantity) {
			$("#minQuantity_remind_show_message").html( // ÿ�û���С�µ���
					metaErrors.minQuantity);
		}
		if (metaErrors.maxQuantity) {
			$("#maxQuantity_remind_show_message").html( // ÿ�û�����µ���
					metaErrors.maxQuantity);
		}
	}
}
/**
 * �������׵ĺ�̨��֤������ʾ
 * 
 * @return
 */
function bidOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.haveAuctioneer) {
			$("#haveAuctioneer_remind_show_message").html( // �Ƿ�������ʦ
					metaErrors.haveAuctioneer);
		}
		if (metaErrors.bidStartPrice) {
			$("#bidStartPrice_remind_show_message").html(// ���ļ۸�
					metaErrors.bidStartPrice);
		}
		if (metaErrors.priceDirection) {
			$("#priceDirection_remind_show_message").html(// ���۷���
					metaErrors.priceDirection);
		}
		if (metaErrors.bidRate) {
			$("#bidRate_remind_show_message").html(// ���۷���
					metaErrors.bidRate);
		}
		if (metaErrors.supportPriority) {
			$("#supportPriority_remind_show_message").html(// ����Ȩ
					metaErrors.supportPriority);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html(// ���ۿ�ʼʱ��
					metaErrors.bidStartTime);
		}
		if (metaErrors.bidLimitedPeriod) {
			$("#bidLimitedPeriod_remind_show_message").html(// ������ʱ����
					metaErrors.bidLimitedPeriod);
		}
		if (metaErrors.haveReservePrice) {
			$("#haveReservePrice_remind_show_message").html(// �Ƿ��б�����
					metaErrors.haveReservePrice);
		}
		if (metaErrors.reservePrice) {
			$("#reservePrice_remind_show_message").html(// ������
					metaErrors.reservePrice);
		}

		if (metaErrors.allowWatch) {
			$("#allowWatch_remind_show_message").html(// �Ƿ�����ۿ�
					metaErrors.allowWatch);
		}
		if (metaErrors.watchPassword) {
			$("#watchPassword_remind_show_message").html(// �ۿ���Ȩ��
					metaErrors.watchPassword);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html(// ������ʼʱ��
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html(// ��������ʱ��
					metaErrors.applyEndTime);
		}
		if (metaErrors.firstWaitTime) {
			$("#firstWaitTime_remind_show_message").html(// �״α��۵ȴ�ʱ��
					metaErrors.firstWaitTime);
		}
		if (metaErrors.auctioneerAccount) {
			$("#auctioneerAccount_remind_show_message").html(// ����ʦ�˺�
					metaErrors.auctioneerAccount);
		}

	}
}

/**
 * ��α���ת����
 * 
 * @return
 */
function mulitBidOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.haveAuctioneer) {
			$("#haveAuctioneer_remind_show_message").html( // �Ƿ�������ʦ
					metaErrors.haveAuctioneer);
		}
		if (metaErrors.bidStartPrice) {
			$("#bidStartPrice_remind_show_message").html(// ���ļ۸�
					metaErrors.bidStartPrice);
		}
		if (metaErrors.priceDirection) {
			$("#priceDirection_remind_show_message").html(// ���۷���
					metaErrors.priceDirection);
		}
		if (metaErrors.bidRate) {
			$("#bidRate_remind_show_message").html(// ���۷���
					metaErrors.bidRate);
		}
		if (metaErrors.supportPriority) {
			$("#supportPriority_remind_show_message").html(// ����Ȩ
					metaErrors.supportPriority);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html(// ���ۿ�ʼʱ��
					metaErrors.bidStartTime);
		}
		if (metaErrors.bidLimitedPeriod) {
			$("#bidLimitedPeriod_remind_show_message").html(// ������ʱ����
					metaErrors.bidLimitedPeriod);
		}
		if (metaErrors.haveReservePrice) {
			$("#haveReservePrice_remind_show_message").html(// �Ƿ��б�����
					metaErrors.haveReservePrice);
		}
		if (metaErrors.reservePrice) {
			$("#reservePrice_remind_show_message").html(// ������
					metaErrors.reservePrice);
		}

		if (metaErrors.allowWatch) {
			$("#allowWatch_remind_show_message").html(// �Ƿ�����ۿ�
					metaErrors.allowWatch);
		}
		if (metaErrors.watchPassword) {
			$("#watchPassword_remind_show_message").html(// �ۿ���Ȩ��
					metaErrors.watchPassword);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html(// ������ʼʱ��
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html(// ��������ʱ��
					metaErrors.applyEndTime);
		}
		if (metaErrors.firstWaitTime) {
			$("#firstWaitTime_remind_show_message").html(// �״α��۵ȴ�ʱ��
					metaErrors.firstWaitTime);
		}
		if (metaErrors.auctioneerAccount) {
			$("#auctioneerAccount_remind_show_message").html(// ����ʦ�˺�
					metaErrors.auctioneerAccount);
		}
		if (metaErrors.reviewerAccount) {
			$("#reviewerAccount_remind_show_message").html(// ���Ա�˺�
					metaErrors.reviewerAccount);
		}
	}
}

/**
 * Э��ת�ý��׵ĺ�̨��֤������ʾ
 * @return
 */
function transferOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.startPrice) {
			$("#startPrice_remind_show_message").html( // ת�ü۸�
					metaErrors.startPrice);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html( // ������ʼʱ��
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html( // ��������ʱ��
					metaErrors.applyEndTime);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html( // Э��ת�ÿ�ʼʱ��
					metaErrors.bidStartTime);
		}
	}
}

/**
 * �б�ת�ý��׵ĺ�̨��֤������ʾ
 * @return
 */
function tenderOrderErrorShow() {
	if (metaErrors && metaErrors != "") {
		if (metaErrors.evaluation) {
			$("#evaluation_remind_show_message").html( // ������
					metaErrors.evaluation);
		}
		if (metaErrors.applyStartTime) {
			$("#applyStartTime_remind_show_message").html( // ������ʼʱ��
					metaErrors.applyStartTime);
		}
		if (metaErrors.applyEndTime) {
			$("#applyEndTime_remind_show_message").html( // ��������ʱ��
					metaErrors.applyEndTime);
		}
		if (metaErrors.bidStartTime) {
			$("#bidStartTime_remind_show_message").html( // �б�ת�ÿ�ʼʱ��
					metaErrors.bidStartTime);
		}
	}
}

/**
 * ��̬���Եĺ�̨��֤������ʾ
 * 
 * @return
 */
function dynamicErrorShow() {
	if (metaErrors) {

	}
}
/**
 * ��ʾ������
 * 
 * @param boxID
 *            ��������ID
 * @param {}
 *            beforeAsyncFn ����������ǰ�Ļص�
 * @param {}
 *            asyncSuccessFn �������ݳɹ���Ļص�
 * @param {}
 *            asyncErrorFn �������ʱ�Ļص�
 * @param curValue
 *            ��ǰֵ,���������и�����ǰֵ
 */
function reloadPrjTypeTree(boxID, beforeAsyncFn, asyncSuccessFn, asyncErrorFn,
		curValue) {
	var treeBox = $("#" + boxID);
	var curLi;// ����curValue���õ�ǰֵ��ʽ
	if (!treeBox)
		return;
	if (curLi)
		curLi.removeClass("focus");
	var setting = {
		expandSpeed : "",
		async : true,
		asyncUrl : prjTypeUrl.nodesURL, // ��ȡ�ڵ����ݵ�URL��ַ
		asyncParam : [ "name", "code" ], // ��ȡ�ڵ�����ʱ��������������ƣ����磺id��name
		showLine : true,
		isSimpleData : true,
		treeNodeKey : "code",
		treeNodeParentKey : "parentcodeShort",
		callback : {
			// beforeAsync : beforeAsyncFn,//������Ч
			asyncSuccess : asyncSuccessFn,
			asyncError : asyncErrorFn
		}
	};
	if (curLi)
		curLi.addClass("focus");
	/**
	 * ������JSON����
	 */
	var prjTypeTreeNodes = [];
	var prjTypeTree = treeBox.zTree(setting, prjTypeTreeNodes);
	return prjTypeTree;
}

/**
 * �������� treeBox.zTree(setting, clone(prjTypeTreeNodes));
 * 
 * @param jsonObj
 * @param newName
 * @return newName
 */
function clone(jsonObj, newName) {
	var buf;
	if (jsonObj instanceof Array) {
		buf = [];
		var i = jsonObj.length;
		while (i--) {
			buf[i] = clone(jsonObj[i], newName);
		}
		return buf;
	} else if (typeof jsonObj == "function") {
		return jsonObj;
	} else if (jsonObj instanceof Object) {
		buf = {};
		for ( var k in jsonObj) {
			if (k != "parentNode") {
				buf[k] = clone(jsonObj[k], newName);
				if (newName && k == "name")
					buf[k] += newName;
			}
		}
		return buf;
	} else {
		return jsonObj;
	}
}
/**
 * 
 * @param tradeType
 *            ���׷�ʽ��palseorder�µ����� Ǣ̸����chat ���۽���bid
 */
function prjTradeForm(tradeType, prjTradeTypeBoxId) {
	loadPrjTradeTypeFormURL(tradeType, prjTradeTypeBoxId, "");
}

function prjMetaFrom(projectTypeCode, projectTypeName) {
	loadPrjTypeMetaFormURL(projectTypeCode, projectTypeName, "");
}
/**
 * ���Լ������Ժ󣬽��ϴε�����ֵ��ʾ
 * 
 * @return
 */
function onCompleteValueSeting(tradeType) {
	if (typeof (metaSubmitValue) != 'undefined' && metaSubmitValue
			&& metaSubmitValue != "") {
		setCommonValue();
		if ("bidOrder" == tradeType) {
			setBidOrderValue();
		} else if ("dynamic" == tradeType) {
			setDynamicValue();
		} else if ("placeOrder" == tradeType) {
			setPlaceOrderValue();
		} else if ("transferOrder" == tradeType) {
			setTransferOrderValue();
		} else if ("tenderOrder" == tradeType) {
			setTenderOrderValue();
		} else if ("mulitBidOrder" == tradeType) {
			setMulitBidOrderValue();
		}

	}
}
function setPlaceOrderValue() {

}
/**
 * ���ö�̬���Ե��ϴ�ֵ
 * 
 * @return
 */
function setDynamicValue() {
	$("input")
			.each(
					function() {
						if ($(this).attr("id") != ""
								&& $(this).attr("showtype") != "") {
							if (($(this).attr("showtype") == "text" || $(this)
									.attr("showtype") == "TEXT")) {
								$(this)
										.val(
												metaSubmitValue[$(this).attr(
														"id")]);
							} else if (($(this).attr("showtype") == "checkbox" || $(
									this).attr("showtype") == "CHECKBOX")) {
								var checkId = $(this).attr("id");
								$("input[id='" + checkId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[checkId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues

															.indexOf(itemValue) > -1) {
														$(this).attr("checked",
																true);
													}
												});
							} else if (($(this).attr("showtype") == "radio" || $(
									this).attr("showtype") == "RADIO")) {
								var radioId = $(this).attr("id");
								$("input[id='" + radioId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[radioId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues == itemValue) {
														$(this).attr("checked",
																true);
													}
												});
							}
						}
					});

	$("select").each(function() {
		if ($(this).attr("id") != "" && $(this).attr("showtype") != "") {
			var selectId = $(this).attr("id");
			$("#" + selectId + " option").each(function() {
				if (metaSubmitValue[selectId] == $(this).val()) {
					$(this).attr("selected", true);
				}
			});
		}
	});
}
/**
 * �����µ��������Ե��ϴ�ֵ
 * 
 * @return
 */
function setCommonValue() {
	$("input")
			.each(
					function() {
						if ($(this).attr("id") != ""
								&& $(this).attr("showtype") != "") {
							if (($(this).attr("showtype") == "text" || $(this)
									.attr("showtype") == "TEXT")) {
								$(this)
										.val(
												metaSubmitValue[$(this).attr(
														"id")]);
							} else if (($(this).attr("showtype") == "checkbox" || $(
									this).attr("showtype") == "CHECKBOX")) {
								var checkId = $(this).attr("id");
								$("input[id='" + checkId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[checkId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues

															.indexOf(itemValue) > -1) {
														$(this).attr("checked",
																true);
													}
												});
							} else if (($(this).attr("showtype") == "radio" || $(
									this).attr("showtype") == "RADIO")) {
								var radioId = $(this).attr("id");
								$("input[id='" + radioId + "']")
										.each(
												function() {
													var checkValues = metaSubmitValue[radioId];
													var itemValue = $(this)
															.val();
													if (checkValues
															&& itemValue
															&& checkValues != ""
															&& itemValue != ""
															&& checkValues == itemValue) {
														$(this).attr("checked",
																true);
													}
												});
							}
						}
					});

	$("select").each(function() {
		if ($(this).attr("id") != "" && $(this).attr("showtype") != "") {
			var selectId = $(this).attr("id");
			$("#" + selectId + " option").each(function() {
				if (metaSubmitValue[selectId] == $(this).val()) {
					$(this).attr("selected", true);
				}
			});
		}
	});
}
/**
 * ���������������Ե��ϴ�ֵ
 * 
 * @return
 */
function setBidOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.haveAuctioneer) {
		$("input[id='haveAuctioneer']").each(function() {
			if (metaSubmitValue.haveAuctioneer == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.bidStartPrice) {
		$("#bidStartPrice").val(metaSubmitValue.bidStartPrice);// ���ļ۸�
	}
	if (metaSubmitValue.priceDirection) {
		// $("#priceDirection").val(metaSubmitValue.priceDirection);// ���۷���
		$("input[id='priceDirection']").each(function() {
			if (metaSubmitValue.priceDirection == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.bidRate) {
		$("#bidRate").val(metaSubmitValue.bidRate);// ���۷���
	}
	if (metaSubmitValue.supportPriority) {
		// $("#supportPriority").val(metaSubmitValue.supportPriority);// ����Ȩ
		$("input[id='supportPriority']").each(function() {
			if (metaSubmitValue.supportPriority == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// ���ۿ�ʼʱ��
	}
	if (metaSubmitValue.bidLimitedPeriod) {
		$("#bidLimitedPeriod").val(metaSubmitValue.bidLimitedPeriod);// ������ʱ����
	}
	if (metaSubmitValue.haveReservePrice) {
		// $("#haveReservePrice").val(metaSubmitValue.haveReservePrice);//
		// �Ƿ��б�����
		$("input[id='haveReservePrice']").each(function() {
			if (metaSubmitValue.haveReservePrice == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.reservePrice) {
		$("#reservePrice").val(metaSubmitValue.reservePrice);// ������
	}
	if (metaSubmitValue.allowWatch) {
		// $("#allowWatch").val(metaSubmitValue.allowWatch);// �Ƿ�����ۿ�
		$("input[id='allowWatch']").each(function() {
			if (metaSubmitValue.allowWatch == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.watchPassword) {
		$("#watchPassword").val(metaSubmitValue.watchPassword);// �ۿ���Ȩ��
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// ������ʼʱ��
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// ��������ʱ��
	}
	if (metaSubmitValue.firstWaitTime) {
		$("#firstWaitTime").val(metaSubmitValue.firstWaitTime);// �״α��۵ȴ�ʱ��
	}
	if (metaSubmitValue.auctioneerAccount) {
		$("#auctioneerAccount").val(metaSubmitValue.auctioneerAccount);// ����ʦ�˺�
	}

}
function setMulitBidOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.haveAuctioneer) {
		$("input[id='haveAuctioneer']").each(function() {
			if (metaSubmitValue.haveAuctioneer == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.bidStartPrice) {
		$("#bidStartPrice").val(metaSubmitValue.bidStartPrice);// ���ļ۸�
	}
	if (metaSubmitValue.priceDirection) {
		// $("#priceDirection").val(metaSubmitValue.priceDirection);// ���۷���
		$("input[id='priceDirection']").each(function() {
			if (metaSubmitValue.priceDirection == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.bidRate) {
		$("#bidRate").val(metaSubmitValue.bidRate);// ���۷���
	}
	if (metaSubmitValue.supportPriority) {
		// $("#supportPriority").val(metaSubmitValue.supportPriority);// ����Ȩ
		$("input[id='supportPriority']").each(function() {
			if (metaSubmitValue.supportPriority == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// ���ۿ�ʼʱ��
	}
	if (metaSubmitValue.bidLimitedPeriod) {
		$("#bidLimitedPeriod").val(metaSubmitValue.bidLimitedPeriod);// ������ʱ����
	}
	if (metaSubmitValue.haveReservePrice) {
		// $("#haveReservePrice").val(metaSubmitValue.haveReservePrice);//
		// �Ƿ��б�����
		$("input[id='haveReservePrice']").each(function() {
			if (metaSubmitValue.haveReservePrice == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.reservePrice) {
		$("#reservePrice").val(metaSubmitValue.reservePrice);// ������
	}
	if (metaSubmitValue.allowWatch) {
		// $("#allowWatch").val(metaSubmitValue.allowWatch);// �Ƿ�����ۿ�
		$("input[id='allowWatch']").each(function() {
			if (metaSubmitValue.allowWatch == $(this).val()) {
				$(this).attr("checked", true); // �Ƿ�������ʦ
			}
		});
	}
	if (metaSubmitValue.watchPassword) {
		$("#watchPassword").val(metaSubmitValue.watchPassword);// �ۿ���Ȩ��
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// ������ʼʱ��
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// ��������ʱ��
	}
	if (metaSubmitValue.firstWaitTime) {
		$("#firstWaitTime").val(metaSubmitValue.firstWaitTime);// �״α��۵ȴ�ʱ��
	}
	if (metaSubmitValue.auctioneerAccount) {
		$("#auctioneerAccount").val(metaSubmitValue.auctioneerAccount);// ����ʦ�˺�
	}
	if (metaSubmitValue.reviewerAccount) {
		$("#reviewerAccount").val(metaSubmitValue.reviewerAccount);// ����Ա�˺�
	}
}

/**
 * ����Э��ת�ý������Ե��ϴ�ֵ
 * 
 * @return
 */
function setTransferOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.startPrice) {
		$("#startPrice").val(metaSubmitValue.startPrice);// ת�ü۸�
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// ������ʼʱ��
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// ��������ʱ��
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// Э��ת�ÿ�ʼʱ��
	}
}

/**
 * �����б�ת�ý������Ե��ϴ�ֵ
 * 
 * @return
 */
function setTenderOrderValue() {
	/*
	 * $(":input").each(function() { name = $(this).attr("name"); nameValue =
	 * "metaSubmitValue." + name; nameValue = eval(nameValue); if (typeof
	 * (nameValue) != 'undefined' && nameValue && nameValue!="" && ) {
	 * $(this).val(nameValue); } });
	 */

	if (metaSubmitValue.evaluation) {
		$("#evaluation").val(metaSubmitValue.evaluation);// ������
	}
	if (metaSubmitValue.applyStartTime) {
		$("#applyStartTime").val(metaSubmitValue.applyStartTime);// ������ʼʱ��
	}
	if (metaSubmitValue.applyEndTime) {
		$("#applyEndTime").val(metaSubmitValue.applyEndTime);// ��������ʱ��
	}
	if (metaSubmitValue.bidStartTime) {
		$("#bidStartTime").val(metaSubmitValue.bidStartTime);// �б�ת�ÿ�ʼʱ��
	}
}