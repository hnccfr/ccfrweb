/**
 * �����ύ
 * 
 * @param {}
 *            price
 */
function bidPriceAjax(price, priority) {
	jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/bid.htm",
				data : "price=" + price + "&priority=" + priority
						+ "&projectCode=" + hallJson.auctionHallDTO.projectCode
						+ "&bidderTrademark=" + hallJson.bidderTrademark,
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						showMessageAddition(result.errorInfo);
					} else {
						showMessage("���۳ɹ�");
					}
				},
				error : function() {
					showMessage('������æ�����Ժ�����');
				}
			});
}

/**
 * 
 * ����ʦ����
 * 
 * @param {}
 *            cmd
 */
function auctioneerDoAjax(obj, cmd, status) {
	jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/auctioneer/do.htm",
				data : "cmd=" + cmd + "&status=" + status + "&projectCode="
						+ hallJson.auctionHallDTO.projectCode,
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						showMessageAddition(result.errorInfo);
						// $(obj).removeAttr("disabled");
						enabledBtn();
					} else {
						showMessage("�����ɹ�");
					}
				},
				error : function() {
					showMessage('������æ�����Ժ�����');
					// $(obj).removeAttr("disabled");
					enabledBtn();
				}
			});
}

/**
 * 
 * ����ʦ���ñ�����
 * 
 * @param {}
 *            cmd
 */
function setReservePriceAjax(reservePrice) {
	var ret = true;
	jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/auctioneer/setReservePrice.htm",
				data : "reservePrice=" + reservePrice + "&projectCode="
						+ hallJson.auctionHallDTO.projectCode,
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						ret = false;
						showMessageAddition(result.errorInfo);
					}
				},
				error : function() {
					ret = false;
					showMessage('������æ�����Ժ�����');

				}
			});
	return ret;
}

/**
 * 
 * ����ʦ���ñ��۷���
 * 
 * @param {}
 *            cmd
 */
function updateBidRateAjax(bidRate) {
	var ret = true;
	jQuery.ajax({
				type : "POST",
				url : appServer + "/auction/auctioneer/updateBidRate.htm",
				data : "bidRate=" + bidRate + "&projectCode="
						+ hallJson.auctionHallDTO.projectCode,
				dataType : "json",
				async : false,
				cache : false,
				success : function(result) {
					if (result.errorInfo && result.errorInfo.length > 0) {
						ret = false;
						showMessageAddition(result.errorInfo);
					} else {
						showMessage("�����ɹ�");
					}
				},
				error : function() {
					ret = false;
					showMessage('������æ�����Ժ�����');
				}
			});
	return ret;
}
