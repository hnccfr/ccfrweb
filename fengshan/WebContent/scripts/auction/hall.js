// 样式用到的JS begin

var debug = true;
$(function() {
			// 拍卖现场begin
			try {
				if (isSuccessLoad()) {
					initBiders();// 初始化报价人列表
					initBidRecordsList();// 初始化报价信息区
					initeLastBidPrice(); // 初始化最后一次报价
					var user_type = hallJson.hallUserType;// 用户类型
					if (user_type == "auctioneer") {// 拍卖师
						initAuctioneerControlPanel();
					} else if (user_type == "bidder") {// 竞价人
						initBiderControlPanel();
					} else if (user_type == "viewer") {// 观众
						changeStatus(latestBidData); // 修改状态
					} else if (user_type == "listinger") {// 挂牌人
						changeStatus(latestBidData); // 修改状态
					} else{
						changeStatus(latestBidData); // 修改状态
					}
				} else {
					showMessage("载入大厅数据失败," + hallJson.errorInfo);
				}
			} catch (e) {
				showMessage('初始化大厅失败,' + e);
			}

			$(".modules h5").toggle(function() {
						$(this).addClass("hover");
						$(".modules ul").eq($(".modules h5").index(this))
								.show();
					}, function() {
						$(this).removeClass("hover");
						$(".modules ul").eq($(".modules h5").index(this))
								.hide();
					});
			$(".modules ul li").click(function() {
						$(".modules ul li").removeClass("hover");
						$(this).addClass("hover");
					});

//			$(".hall-center .jupai input").click(function() {
//						$(".hall-center .jupai input").removeClass("button-3");
//						//$(this).addClass("button-3");
//						$(".hall-center .jupai-confirm input")
//								.removeAttr("disabled");
//						var butValue = ($(this).attr("value") + " 确定出价")
//						$(".hall-center .jupai-confirm input").attr("value",
//								butValue);
//					});
			$("#projectTitle").text(hallJson.projectTitle); // 修改项目名称
		});

// 样式用到的JS end

// Pushlet 用到的 begin

window.onload = function() {
	if (isSuccessLoad()) {
		PL._init();
		PL.joinListen("/refreshHallData");
		self.setInterval("tryRejoin()", 5000);
	}
}

function tryRejoin(){
	if (PL.state == -2){
		try{
			PL._init();
			PL.joinListen("/refreshHallData");
		}catch(e){}
	}
}

function onData(event) {
	try {
		if (hallJson.auctionHallDTO.projectCode
				&& hallJson.auctionHallDTO.projectCode.length > 0) {
			var bidData = eval('('
					+ event.get(hallJson.auctionHallDTO.projectCode + "_data")
					+ ')'); // 得到数据json
			dealFlashBid(bidData); // 刷新页面价格
			var resultData = eval('('
					+ event
							.get(hallJson.auctionHallDTO.projectCode
									+ "_result") + ')'); // 得到拍卖结果json
			dealResult(resultData); // 处理拍卖结果
			var messageData =  eval('('
					+ event
							.get(hallJson.auctionHallDTO.projectCode
									+ "_message") + ')'); // 得到信息json
			dealMessage(messageData); // 处理信息
		}
	} catch (e) {
		if (debug) {
			showMessage(e);
		}
	}
}
// Pushlet 用到的end
