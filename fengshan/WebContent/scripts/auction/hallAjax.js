/**
 * 报价提交
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
						showMessage("报价成功");
					}
				},
				error : function() {
					showMessage('服务器忙，请稍后再试');
				}
			});
}

/**
 * 
 * 拍卖师操作
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
						showMessage("操作成功");
					}
				},
				error : function() {
					showMessage('服务器忙，请稍后再试');
					// $(obj).removeAttr("disabled");
					enabledBtn();
				}
			});
}

/**
 * 
 * 拍卖师设置保留价
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
					showMessage('服务器忙，请稍后再试');

				}
			});
	return ret;
}

/**
 * 
 * 拍卖师设置报价幅度
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
						showMessage("操作成功");
					}
				},
				error : function() {
					ret = false;
					showMessage('服务器忙，请稍后再试');
				}
			});
	return ret;
}
