var YI = 10000000000;// 亿
var WAN = 1000000;// 万
var YUAN = 100;// 元
var clk, second;
var BIGE = 1000000000000; // 用于计算浮点时保留精度

/** 初始化竞价人控制面板* */
function initBiderControlPanel() {
	resetIsPriority();
	rebuildBidBtns();
	changeStatus(latestBidData); // 修改状态
}
/** 初始化拍卖师控制面板* */
function initAuctioneerControlPanel() {
	var bid_range = latestBidData.bidRate;// 加价幅度
	if (bid_range && bid_range > 0) {
		initBidRange(bid_range);// 加价幅度
	}
	changeStatus(latestBidData);// 其他功能按钮
}

/** 初始化拍卖大厅有效竞价人员列表* */
function initBiders() {
	var _html_bider;
	var bid_mark = hallJson.bidderTrademark;
	var biders = hallJson.auctionBidderDTOs;
	if (biders) {
		$("#biderNumber").text(biders.length);
		$("#biders").empty();
		for (var i in biders) {
			var bider = biders[i];
			if(bid_mark == bider.bidderTrademark){
				_html_bider = "<li class=\"hover\"><span>";
			}else{
				_html_bider = "<li><span>"
			}
			_html_bider = _html_bider +"牌号："+ bider.bidderTrademark;
			if (bider.isPriority == "Y") {
				_html_bider = _html_bider + "<i class=\"xx\" title=\"优先权竞价人\"></i>";
			}
			_html_bider = _html_bider + "</span></li>";

			$("#biders").append(_html_bider);
		}
	} else {
		if (debug) {
			showMessage('竞价人信息为空');
		}
	}
}
/** 初始化竞价人拍卖大厅报价按钮区域* */
function initBidBtns(data) {
	var _bid_direction = hallJson.auctionHallDTO.priceDirection;// 报价方向
	var _bid_range = data.bidRate;// 报价幅度(单位：分)
	var _bid_range_unite;// 带金钱单位（亿元、万元、元）的报价幅度
	_bid_range_unite = transMoneyToUnite(_bid_range);
	var _bid_range_unite_direction = accMul(_bid_range_unite, _bid_direction);// 带报价方向的幅度
	// 初始化报价区按钮
	clearBidBtns();
	var _html_bid_price;
	for (var i = 1; i < 11; i++) {
		_html_bid_price = "<li><input name=\"baojia_button\" type=\"button\" value=\"";
		if (_bid_range_unite_direction > 0) {
			_html_bid_price = _html_bid_price + "+"
			        + accMul(_bid_range_unite,i) + "\" class=\"button-2\" onclick=\"dealBid("
					+ accMul(accMul(_bid_range,_bid_direction), i)
					+ ");\" /></li>";
		} else {
			_html_bid_price = _html_bid_price + "-" + accMul( _bid_range_unite,i)
			+ "\" class=\"button-2\" onclick=\"dealBid("
					+ accMul(accMul(_bid_range,_bid_direction),i)
					+ ");\" /></li>";
		}
		$("#baojia").append(_html_bid_price);
	}
}

function clearBidBtns(){
	$("#baojia").empty();
}
/** 起拍价按钮* */
function initStartPriceBtn() {
	cleanStartPriceBtn();
	var _html_bid_start_price = "<li id=\"bidStartPrice\"><input type=\"button\" value=\"起拍价报价\" class=\"button-2\" onclick=\"dealStartPriceBid();\"/></li>"
	$("#baojia").prepend(_html_bid_start_price);
	//	$("#baojia").append(_html_bid_start_price);
}

/**
 * 清除起拍价按钮
 */
function cleanStartPriceBtn() {
	$("#bidStartPrice").remove();
}

/** 优先权按钮* */
function initPriorityBtn() {
	cleanPriorityBtn();
	var _html_bid_priority = "<li id=\"bidPriorityPrice\"><input type=\"button\" value=\"优先权报价\" class=\"button-2\" onclick=\"dealPriorityBid();\"/></li>"
	$("#baojia").prepend(_html_bid_priority);
//	$("#baojia").append(_html_bid_priority);
}

/**
 * 清除优先权按钮
 */
function cleanPriorityBtn() {
	$("#bidPriorityPrice").remove();
}

/** 初始化竞价人拍卖大厅报价输入区* */
function initBidInput() {
	var _bid_range = hallJson.auctionLatestBidDTO.bidRate;
	if (!_bid_range) {
		$("#baojia").addClass("tc");
		clearBidBtns();
		var _html_bid_input = "<p class=\"clear-l\">"
				+ "<span style=\"color: #69707F;font-size:18px;font-weight:bold;height: 30px;\">报价：&nbsp;</span>"
				+ "<input id=\"bidInput\" type=\"text\" style=\"font-size:18px;height:32px;width:160px;background-color:#E0E0E0\" />"
				+"<span style=\"color: #69707F;font-size:14px;\">"
				+ getUniteDesc()
				+ "</span>"
				+ "<span>&nbsp;&nbsp;</span><input type=\"button\" onclick=\"dealInputBid();\" class=\"button-8\" style=\"font-size:14px;\" value=\"提 交\" />"
				+ "</p>";
		$("#baojia").append(_html_bid_input);
	}
}
/** 初始化拍卖大厅报价信息列表* */
function initBidRecordsList() {
	var _html_bide_records = "";
	var unite = hallJson.auctionHallDTO.valuationUnit;// 报价单位
	var bid_mark = hallJson.bidderTrademark;//当前用户牌号
	var bide_records = hallJson.auctionBidRecordDTOs;
	var bide_seq = bide_records.length;
	var money_desc = getUniteDesc();
	$("#bideUnite").text(money_desc);
	initBidMark();// 初始化栏目上方的牌号
	for (var i in bide_records) {
		var record = bide_records[i];
		if (i == 0) {
			_html_bide_records = "<tr class=\"latest\" ";
		} else {
			_html_bide_records = "<tr ";
		}
		if(bid_mark == record.bidderTrademark){
			_html_bide_records = _html_bide_records+ " style=\"background-color:#D3FF93\"";
		}
		
		_html_bide_records = _html_bide_records + " ><td>"
				+ bide_seq
				+ "</td><td class=\"ph\">" + record.bidderTrademark
				+ "</td><td class=\"bj\">" + transMoneyToUnite(record.price)
				+ "</td><td>" + new Date(record.gmtCreate).format("hh:mm:ss");
		+"</td></tr>";
		$("#bidList").append(_html_bide_records);
		bide_seq = bide_seq - 1;
	}
}

/** 初始化最后一次报价信息* */
function initeLastBidPrice() {
	var html;
	if (latestBidData && latestBidData.latestBid > 0) {
		changeLastBidPrice(latestBidData);
	} else {
		var html = "起拍价：<strong>"
				+ getFormatPrice(hallJson.auctionHallDTO.bidStartPrice)
				+ "</strong>";
		$("#lastBidPrice").html(html);
	}
}
/** 初始化报价列表上方的牌号显示* */
function initBidMark() {
	var user_type = hallJson.hallUserType;// 用户类型
	if (user_type == "bidder") {
		$(".mark").empty();
		var bid_mark = hallJson.bidderTrademark;
		var _html_bid_mark = "我的牌号：<label ><strong>" + bid_mark
				+ "</strong></label>";
		var priority = hallJson.isPriority;// 优先权
		if (priority == "Y") {
			_html_bid_mark = _html_bid_mark + "<i class=\"xx\" title=\"优先权竞价人\"></i>";
		}
		$(".mark").append(_html_bid_mark);
	}

}
/** 初始化加价幅度设置区域* */
function initBidRange(range) {
	var _bid_direction = hallJson.auctionHallDTO.priceDirection;// 报价方向
	var direct="报价";
	if(_bid_direction){
		if(_bid_direction <= 0){
			direct = "减价";
		}else if(_bid_direction > 0){
			direct = "加价";
		}
	}
	var _html_bid_range = "<div style=\"text-align:center;\">"
			+ "<span style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">当前"+direct+"幅度：</span>"
			+ "<span id=\"currentBidRange\" style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">"
			+ transMoneyToUnite(range) + getUniteDesc()+"</span><br />"
			+ "<span style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">设置"+direct+"幅度：</span>"
			+ "<input id=\"textBidRange\" type=\"text\" maxlength=\"12\" style=\"font-weight:bold;height:40px;width:160px;font-size: 30px;\" />"
			+ "<span style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">"+getUniteDesc()+"</span>"
			+ "&nbsp;&nbsp;<input type=\"button\" class=\"button-3\" value=\"确 认\" onclick=\"dealBidRange();\" />"
			+ "</div><br /><br /><br /><br /><br />";
	$(".jp_btn").empty();
	$(".jp_btn").append(_html_bid_range);
}
/** 初始化拍卖开始按钮* */
function initBidStratBtn() {
	var showTitle = "开始拍卖";
	var biders = hallJson.auctionBidderDTOs;
	if (!biders || biders.length < 2) { // 少于2个报价人
		showTitle = "流拍";
	}
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\""
			+ showTitle + "\" onclick=\"bulidAuctioneerDo(this,'start');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** 初始化第一次唱价按钮* */
function initFirstBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"唱价第一次\" onclick=\"bulidAuctioneerDo(this,'auction_one');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** 初始化第二次唱价按钮* */
function initSecondBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"唱价第二次\" onclick=\"bulidAuctioneerDo(this,'auction_two');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** 初始化第三次唱价按钮* */
function initThirdBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"唱价第三次\" onclick=\"bulidAuctioneerDo(this,'auction_three');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** 初始化优先权开始按钮* */
function initPriorityStratBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"开始优先权\" onclick=\"bulidAuctioneerDo(this,'priority_start');\"  />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}

/** 初始化优先权第一次唱价按钮* */
function initPriorityFirstBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"唱价第一次\" onclick=\"bulidAuctioneerDo(this,'priority_auction_one');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** 初始化优先权第二次唱价按钮* */
function initPrioritySecondBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"唱价第二次\" onclick=\"bulidAuctioneerDo(this,'priority_auction_two');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** 初始化优先权第三次唱价按钮* */
function initPriorityThirdBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"唱价第三次\" onclick=\"bulidAuctioneerDo(this,'priority_auction_three');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}

function cleanAuctioneerBtn() {
	$(".control").empty();
}

function bulidAuctioneerDo(obj, cmd) {
	disableBtn(obj);
	auctioneerDoAjax(obj, cmd, latestBidData.latestStatus);

}
function disableBtn(obj) {
	$(obj).attr("disabled", "disabled").removeClass().addClass("button-6");
}

function enabledBtn(obj) {
	$(obj).removeAttr("disabled").removeClass().addClass("button-1");
}

/** 倒计时控制器* */
function timeCountDown(remainSeconds) {
	second = Math.floor(remainSeconds / 1000);
	if (second < 0) {
		second = 0;
	}
	clk = self.setInterval("clock()", 1000);
	$("#p_time #countDownImg").remove();
	$("#p_time")
			.append('<img id=\"countDownImg\" class=\"ml10\" width=\"36\" height=\"36\" src=\"'
					+ imageServer + '/images/auction/wait.gif\" />');
}
function clock() {
	var _mm = "00" + Math.floor(second / 60);
	var _ss = "00" + second % 60;
	var t = _mm.substring(_mm.length - 2, _mm.length) + "分"
			+ _ss.substring(_ss.length - 2, _ss.length) + "秒";
	$("#countDown").html("");
	$("#countDown").html(t);
	second = second - 1;
	if (second <= -1) {
		$("#p_time #countDownImg").remove();
		window.clearInterval(clk);
	}
}

function cleanClock() {
	if (clk) {
		window.clearInterval(clk);
		clk = null;
	}
	$("#countDown").html("");
	$("#p_time #countDownImg").remove();
}

/** 唱价敲锤子* */
function beatHammer(cmd) {
	if (cmd == "auction_one" || cmd == "auction_two" || cmd == "auction_three"
			|| cmd == "priority_auction_one" || cmd == "priority_auction_two"
			|| cmd == "priority_auction_three") {
		$("#cz").attr("src", imageServer + "/images/auction/lp.gif");
	}
}
/** 成交锤子落下* */
function bargain() {
	$("#cz").attr("src", imageServer + "/images/auction/cj.png");
}
/** 流拍锤子横放* */
function flow() {
	$("#cz").attr("src", imageServer + "/images/auction/lp.png");
}

/**
 * 将分为单位的金钱转换为其他单位对应的数额<br />
 * 小数点后最多保留的位数取决于要转换成的单位： 亿10位(yiyuan)、万6位(wanyuan)、元2位(yuan)<br />
 * 其他单位返回0<br />
 * 精确到分，如：传(101)，如果当前项目的单位是“yuan”，返回1.01)
 */
function transMoneyToUnite(money) {
	var unite = hallJson.auctionHallDTO.valuationUnit;// 报价单位
	var _money_unite;
	if (unite == "yiyuan") {
		_money_unite = accDiv(money,YI)+ "";
	} else if (unite == "wanyuan") {
		_money_unite = accDiv(money,WAN) + "";
	} else if (unite == "yuan") {
		_money_unite = accDiv(money,YUAN) + "";
	} else {
		_money_unite = 0;
		return _money_unite;
	}
	var point = _money_unite.indexOf(".");
	if (point > 0) {
		var partInt = _money_unite.substring(0, point);
		var partDecimal;
		if (unite == "yiyuan") {
			partDecimal = _money_unite.substr(point, 11);
		} else if (unite == "wanyuan") {
			partDecimal = _money_unite.substr(point, 7);
		} else if (unite == "yuan") {
			partDecimal = _money_unite.substr(point, 3);
		}
		_money_unite = partInt + partDecimal;
	}
	return _money_unite;
}
/**
 * 将页面报价转换成分为单位的数字<br />
 * 如果报价单位不是亿元(yiyuan)、万元(wanyuan)、元(yuan)中的一种则返回0
 */
function transMoneyToCent(money) {
	var _money_cent;
	var _bid_unite = hallJson.auctionHallDTO.valuationUnit;// 报价单位
	if (_bid_unite == "yiyuan") {
		_money_cent = accMul(money, YI);
	} else if (_bid_unite == "wanyuan") {
		_money_cent = accMul(money, WAN);
	} else if (_bid_unite == "yuan") {
		_money_cent = accMul(money, YUAN);
	} else {
		_money_cent = 0;
	}
	// _money_cent = Math.round(_money_cent);
	return _money_cent;
}

/**
 * 获取金钱的单位描述<br />
 * 金钱的单位自动获取项目报价单位
 */
function getUniteDesc() {
	var unite = hallJson.auctionHallDTO.valuationUnit;// 报价单位
	var desc = "";
	if (unite == "yiyuan") {
		desc = "亿元";
	} else if (unite == "wanyuan") {
		desc = "万元";
	} else if (unite == "yuan") {
		desc = "元";
	}
	return desc;
}

/*
 * 验证页面输入金钱字符串的格式 不考虑小数点，数字的总长度不超过17位
 */
function validateInputPrice(price) {
	var priceStr = "" + price;
	var result = true;
	if (priceStr.indexOf(".") != -1) {// 有小数点
		if (priceStr.length > 18) {
			result = false;
		} else {
			var _bid_unite = hallJson.auctionHallDTO.valuationUnit;// 报价单位
			if ("yiyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;// 小数，小数点后10位
				result = reg.test(priceStr);
			} else if ("wanyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;// 小数，小数点后6位
				result = reg.test(priceStr);
			} else if ("yuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;// 小数，小数点后2位
				result = reg.test(priceStr);
			}
		}
	} else {
		if (priceStr.length > 17) {
			result = false;
		}
	}
	return result;
}
/** 设置日期格式化方式* */
Date.prototype.format = function(format) {
	var o = {
		"M+" : this.getMonth() + 1, // month
		"d+" : this.getDate(), // day
		"h+" : this.getHours(), // hour
		"m+" : this.getMinutes(), // minute
		"s+" : this.getSeconds(), // second
		"q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
		"S" : this.getMilliseconds()
		// millisecond
	}
	if (/(y+)/.test(format)) {
		format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
						- RegExp.$1.length));
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(format)) {
			format = format.replace(RegExp.$1, RegExp.$1.length == 1
							? o[k]
							: ("00" + o[k]).substr(("" + o[k]).length));
		}
	}
	return format;
}

/** 样式用到的 begin* */
var flashTimeId1, flashTimeId2, flashTimeId3;
function jupai() {
	if (flashTimeId1) {
		clearTimeout(flashTimeId1);
	}
	if (flashTimeId2) {
		clearTimeout(flashTimeId2);
	}
	if (flashTimeId3) {
		clearTimeout(flashTimeId3);
	}
	$("#flash p").stop(true, false);
	$("#flash p").css("opacity", "0").show().animate({
				top : "155px",
				opacity : "1"
			}, 800).animate({
				top : "155px",
				opacity : "1"
			}, 3000).animate({
				top : "100px",
				opacity : "0"
			}, 800).animate({
				top : "200px",
				opacity : "0"
			}, 10);
	$("#flash").addClass("flash2");
	flashTimeId1 = setTimeout("callFlashTimeId1()", 800);
	flashTimeId2 = setTimeout("callFlashTimeId2()", 4000);
	flashTimeId3 = setTimeout("callFlashTimeId3()", 4000);
}

function callFlashTimeId1() {
	$('#flash').addClass('flash3');
	flashTimeId1 = null;
}

function callFlashTimeId2() {
	$('#flash').removeClass('flash2');
	flashTimeId2 = null;
}

function callFlashTimeId3() {
	$('#flash').removeClass('flash3');
	flashTimeId3 = null;
}

/** 样式用到的 end* */

// 业务用到的begin
function getFormatPrice(price) {
	try {
		return transMoneyToUnite(price) + getUniteDesc();
	} catch (e) {
		return price;
	}
}

function addBidList(bindData) {
	if (bindData) {
		$("#bidList .latest").removeClass("latest");
		var dataHTML = '<tr class="latest"';
		if(hallJson.bidderTrademark == bindData.bidderTrademark){
			dataHTML = dataHTML+ " style=\"background-color:#D3FF93\"";
		}
		dataHTML += ' ><td>' + $("#bidList tr").size();
		dataHTML += '</td><td class="ph">' + bindData.bidderTrademark;
		dataHTML += '</td><td class="bj">'
				+ transMoneyToUnite(bindData.latestBid);
		dataHTML += '</td><td>'
				+ new Date(bindData.latestBidTime).format("hh:mm:ss")
				+ '</td></tr>';
		$("#bidListHead").after(dataHTML);
	}
}

function changeFlashData(data) {
	var html = '最新报价：<span>' + data.bidderTrademark
			+ '号</span>出价<span class="r">' + getFormatPrice(data.latestBid)
			+ '</span>';
	$("#flash p").html(html);
	changeLastBidPrice(data);
}

function showFlashData(html) {
	$("#flash p").html(html);
	jupai(); // 页面效果
}

function changeLastBidPrice(data) {
	var html = "最新报价：<strong>" + getFormatPrice(data.latestBid) + "</strong>（"
			+ data.bidderTrademark + "号）";
	$("#lastBidPrice").html(html);
}

/**
 * 修改页面的状态文字
 * 
 * @param {}
 *            statusDesc
 */
function changeStatusTitle(statusDesc) {
	$("#hallStatus").text(statusDesc);
}

function changeBidButton(enabled) {
	if (!enabled) {
		var buttons = $("#baojia .button-2");
		buttons.attr("disabled", "disabled");
		buttons.removeClass("button-2");
		buttons.addClass("button-5");
		
	} else {
		var buttons = $("#baojia .button-5");
		buttons.removeAttr("disabled");
		buttons.removeClass("button-5");
		buttons.addClass("button-2");
	}
}

function rebuildBidBtns() {
	if (isBidder) { // 竞价人
		var rebuild = true;
		if (prevLatestBidData) {
			if (prevLatestBidData.bidRate == latestBidData.bidRate) {
				rebuild = false;
			}
		}
		if (rebuild) {
			var bid_range = latestBidData.bidRate;// 加价幅度
			if (bid_range && bid_range > 0) {
				initBidBtns(latestBidData);// 初始化报价按钮区
			} else {
				initBidInput();// 初始化报价输入区
			}
		}
		if (!latestBidData || latestBidData.latestBid <= 0) {
			initStartPriceBtn(); // 初始化起拍价按钮
		}
		if ((!prevLatestBidData || prevLatestBidData.latestBid <= 0)
				&& (latestBidData && latestBidData.latestBid > 0)) {
			cleanStartPriceBtn();
		}
		if ("Y" == hallJson.isPriority
				&& isBidder
				&& (latestBidData.latestStatus == "L"
						|| latestBidData.latestStatus == "M"
						|| latestBidData.latestStatus == "M1" || latestBidData.latestStatus == "M2")) {
			initPriorityBtn();
		}
	}
}

function resetIsPriority() {
	if (hallJson.bidderTrademark == latestBidData.lastBidTrademark) {
		isPriority = true;
	}
}

function showTimeWait() {
	clearTimeWair();
	if ("N" == hallJson.auctionHallDTO.haveAuctioneer) { // 只有无拍卖师情况下才显示时间
		timeCountDown(latestBidData.nextEndMilliSeconds);
	}
}

function clearTimeWair() {
	cleanClock();
}

/**
 * 获取最后报价字符串
 * 
 * @return {}
 */
function getLatestBidDesc() {
	var desc = "无人报价";
	if (latestBidData && latestBidData.latestBid > 0) {
		desc = getFormatPrice(latestBidData.latestBid)
	}
	return desc;
}

/**
 * 状态变化 /** 拍卖最新状态， A: 等待时间开始，
 * <p>
 * C: 等待拍卖师开始
 * <p>
 * E: 拍卖已开始,但是无人报价
 * <p>
 * G: 激烈竞价中.
 * <p>
 * G1:唱价第1次.
 * <p>
 * G2:唱价第2次
 * <p>
 * K: 等待拍卖师开始优先权阶段
 * <p>
 * L: 优先权阶段无人出价
 * <p>
 * M:优先权阶段激烈竞价中
 * <p>
 * M1:优先权阶段唱价第1次.
 * <p>
 * M2:优先权阶段唱价第2次.
 * <p>
 * P: 等待输入保留价
 * <p>
 * Z: 拍卖结束
 * 
 * @param {}
 *            data
 */
function changeStatus(data) {
	switch (data.latestStatus) {
		case "A" : // 等待开始
			showTimeWait();
			changeStatusTitle("等待开始");
			changeBidButton(false);
			if (isAuctioneer) {
				initBidStratBtn();// 拍卖开始按钮
			}
			break;
		// case "C" : // 等待拍卖师开始
		// showTimeWait();
		// changeStatusTitle("等待拍卖师开始");
		// changeBidButton(false);
		// if (isAuctioneer) {
		// initBidStratBtn();// 拍卖开始按钮
		// }
		// break;
		case "E" : // 拍卖已开始,但是无人报价
			showTimeWait();
			changeStatusTitle("拍卖已开始,但是无人报价");
			changeBidButton(true);
			if (isAuctioneer) {
				initFirstBidBtn();
			}
			break;
		case "G" : // 激烈竞价中
			showTimeWait();
			changeStatusTitle("激烈竞价中");
			changeBidButton(true);
			if (isAuctioneer) {
				initFirstBidBtn();
			}
			break;
		case "G1" : // 唱价第1次
			showTimeWait();
			changeStatusTitle("唱价第1次");
			changeBidButton(true);
			if (isAuctioneer) {
				initSecondBidBtn();
			}
			showFlashData(getLatestBidDesc() + "第1次");
			break;
		case "G2" : // 唱价第2次
			showTimeWait();
			changeStatusTitle("唱价第2次");
			changeBidButton(true);
			if (isAuctioneer) {
				initThirdBidBtn();
			}
			showFlashData(getLatestBidDesc() + "第2次");
			break;
		case "K" : // 等待拍卖师开始优先权阶段
			showTimeWait();
			changeStatusTitle("等待开始优先权阶段");
			changeBidButton(false);
			if (isAuctioneer) {
				initPriorityStratBtn();
			}
			break;
		case "L" : // 优先权阶段无人出价
			showTimeWait();
			changeStatusTitle("优先权阶段无人出价");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPriorityFirstBidBtn();
			}
			break;
		case "M" : // 优先权阶段激烈竞价中
			showTimeWait();
			changeStatusTitle("优先权阶段激烈竞价中");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPriorityFirstBidBtn();
			}
			break;
		case "M1" : // 优先权阶段唱价第1次
			showTimeWait();
			changeStatusTitle("优先权阶段唱价第1次");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPrioritySecondBidBtn();
			}
			showFlashData(getLatestBidDesc() + "优先权阶段第1次");
			break;
		case "M2" : // 优先权阶段唱价第2次
			showTimeWait();
			changeStatusTitle("优先权阶段唱价第2次");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPriorityThirdBidBtn();
			}
			showFlashData(getLatestBidDesc() + "优先权阶段第2次");
			break;
		case "P" : // 等待输入保留价
			showTimeWait();
			changeStatusTitle("等待输入保留价");
			changeBidButton(false);
			if (isAuctioneer) {
				inputReservePrice();
			}
			cleanAuctioneerBtn();
			break;
		case "Z" : // 拍卖结束
			clearTimeWair();
			changeStatusTitle("拍卖结束");
			changeBidButton(false);
			cleanAuctioneerBtn();
			break;
		default : // 未知状态
			changeStatusTitle("未知状态:" + data.latestStatus);

	}
}

/**
 * 处理报价数据更新
 * 
 * @param {}
 *            data
 */
function dealFlashBid(data) {
	if (data && data.auctionLatestBidDTO) {
		var refreshData = true;
		var refreshStatus = true;
		if (latestBidData) {
			if (data.auctionLatestBidDTO.codeDF == latestBidData.codeDF) {
				return;
			}
			if (data.auctionLatestBidDTO.bidderTrademark == latestBidData.bidderTrademark
					&& data.auctionLatestBidDTO.latestBid == latestBidData.latestBid) {
				refreshData = false; // 无需刷新数据
			}

			if (data.auctionLatestBidDTO.latestStatus == latestBidData.latestStatus) {
				refreshStatus = false; // 无需刷新状态
			}
		}
		dealHallStatus();
		prevLatestBidData = latestBidData; // 保存前一个最后一次报价信息
		latestBidData = data.auctionLatestBidDTO;
		resetIsPriority();
		rebuildBidBtns(); // 重建加价按钮区
		if (refreshData) {
			showTimeWait(); // 重新显示秒数
			addBidList(latestBidData); // 加入列表右侧菜单
			changeFlashData(latestBidData); // 修改flash显示的数据
			jupai(); // 页面效果
		}
		if (refreshStatus) {
			changeStatus(latestBidData);
		}

	}
}

/**
 * 显示结果dialog
 * 
 * @param {}
 *            data
 */
function showResultDialog(data) {

	var content = "<table width=\"100%\" class=\"tb2\">"
			+ "<tr><th>成交牌号：</th><td>" + data.bidderTrademark + "</td></tr>"
			+ "<tr><th>成交价格：</th><td>" + getFormatPrice(data.price)
			+ "</td></tr>";
	if (data.bidderTrademark == hallJson.bidderTrademark) {
		content += "<tr><th>订单号：</th><td><a target='_blank' href='"
				+ fengshanAppServer + "/order/detail.htm?orderNo="
				+ data.orderNo + "' >" + data.orderNo + "</a></td></tr>";
	}
	content += "</table>";
	var op = {
		id : "bidResult",
		title : '成交提示',
		drag : true,
		lock : true,
		content : content,
		yesFn : true,
		noFn : true
	};
	art.dialog(op);
}
/**
 * 处理获取拍卖结果
 * 
 * @param {}
 *            data
 */
function dealResult(data) {
	if (data) {
		switch (data.tranResult) {
			case "Y" :
				showResultDialog(data);
				bargain();
				changeStatusTitle("拍卖结束,成交");
				showFlashData("成交");
				break;
			case "N" :
				changeStatusTitle("拍卖结束,流拍");
				flow();
				break;
			case "C" :
				changeStatusTitle("拍卖结束,撤牌流拍");
				flow();
				break;
		}
	}
}

/**
 * 报价验证
 * 
 * @param {}
 *            price
 * @return {Boolean}
 */
function validateBid(price) {
	// 判断当前大厅状态是否允许报价
	if (!isNum(price)) {
		showMessage("报价金额有误");
		return false;
	}
	if (latestBidData) {
		if (latestBidData.latestStatus == "A"
				|| latestBidData.latestStatus == "P"
				|| latestBidData.latestStatus == "C"
				|| latestBidData.latestStatus == "K"
				|| latestBidData.latestStatus == "Z") {
			showMessage("当前状态下不允许报价！");
			return false;
		}
	}
	// 判断是否为允许报价的用户类型
	if (!isBidder) { // 只有竞拍人才允许报价
		showMessage("只有竞拍人才允许报价");
		return false;
	}
	if (latestBidData.latestStatus == "L" || latestBidData.latestStatus == "M"
			|| latestBidData.latestStatus == "M1"
			|| latestBidData.latestStatus == "M2") {
		if (!isPriority) { // 无优先权也非最后报价人
			showMessage("对不起，您无权在此阶段报价");
			return false;
		}
	}
	// 价格是否大于当前最高价格
	var priority = $("#dealBidConfirmDialog").data("priority");
	if (latestBidData && latestBidData.latestBid > 0) {
		if (hallJson.auctionHallDTO.priceDirection > 0) {
			if (price <= latestBidData.latestBid && "Y" != priority) {
				showMessage("竞拍价格不能小于当前最新报价"
						+ getFormatPrice(latestBidData.latestBid));
				return false;
			}
		} else {
			if (price >= latestBidData.latestBid && "Y" != priority) {
				showMessage("竞拍价格不能大于当前最新报价"
						+ getFormatPrice(latestBidData.latestBid));
				return false;
			}
		}
	}
	if (price <= 0){
		showMessage("竞拍价格必须大于0");
		return false;
	}
	return true;
}

/**
 * 处理报价
 * 
 * @param {}
 *            num 分为单位的增加金额
 */
function dealBid(addNum) {
	if (typeof(addNum) != "number") {
		showMessage("报价金额必须为数字");
		return;
	}
	// 金额换算
	var price = addNum;
	try {
		if (latestBidData && latestBidData.latestBid > 0) {
			price = accAdd(price,latestBidData.latestBid);
		} else { // 无报价则取起拍价
			price = accAdd(price,hallJson.auctionHallDTO.bidStartPrice);
		}
	} catch (e) {
		price = "";
	}
	if (!isNum(price)) {
		showMessage("金额错误，报价失败！");
		return;
	}
	if (validateBid(price)) {
		openBidConfirmDialog(price);
	}
}

/**
 * 优先权报价
 */
function dealPriorityBid() {
	var price = latestBidData.latestBid;
	if (isPriority) {
		$("#dealBidConfirmDialog").data("priority", "Y");
		if (validateBid(price)) {
			openBidConfirmDialog(price);
		}
	}
}

/**
 * 处理输入报价
 * 
 * @param {}
 *            num
 */
function dealInputBid() {
	var num = $("#bidInput").val();
	if (!isRealNumber(num)) {
		showMessage("报价金额必须为数字");
		return;
	}
	if (!validateInputPrice(num)) {
		showMessage("报价金额不符合规范,请确保您的价格单位不小于分");
		return;
	}
	var price = transMoneyToCent(num);
	if (validateBid(price)) {
		openBidConfirmDialog(price);
	}
}

/**
 * 起拍价报价
 * 
 * @param {}
 *            price
 */
function dealStartPriceBid() {
	var price = hallJson.auctionHallDTO.bidStartPrice;
	if (validateBid(price)) {
		openBidConfirmDialog(price);
	}
}

/**
 * 报价提示
 * 
 * @param {}
 *            price
 */
function openBidConfirmDialog(price) {
	$("#dealBidConfirmDialog").data("price", price);
	var op = {
		id : "bidConfirm",
		title : '报价确认',
		drag : true,
		lock : true,
		content : getNoteHtml(),
		yesFn : function() {
			var priority = $("#dealBidConfirmDialog").data("priority");
			if (!priority) {
				priority = "N";
			}
			$("#dealBidConfirmDialog").removeData("priority");
			bidPriceAjax($("#dealBidConfirmDialog").data("price"), priority);
			$("#dealBidConfirmDialog").removeData("price");
		},
		noFn : true
	};
	art.dialog(op);
}
function getNoteHtml() {
	var price = $("#dealBidConfirmDialog").data("price");
	if (price) {
		price = transMoneyToUnite(price) + getUniteDesc();
	}
	var html = '<table width="100%" class="tb2"><tr>';
	html += '<th>报价：</th>';
	html += '<td>' + price + '</td>';
	html += '</tr></table>';
	return html;
}

$(function() {
			if ($("#dealBidConfirmDialog").size() <= 0) {
				$("body").append("<div id='dealBidConfirmDialog'></div>");
			}
		});

/** 输入保留价* */
function inputReservePrice() {
	var op = {
		id : "reservePrice",
		title : '保留价',
		drag : true,
		lock : true,
		content : "<table width=\"100%\" class=\"tb2\">"
				+ "<tr><th>请输入保留价：</th><td>"
				+ "<input type=\"text\" id=\"reservePrice\" name=\"reservePrice\" />"
				+ getUniteDesc() + "</td></tr></table>",
		yesFn : function() {
			// 处理保留价
			var price = $("#reservePrice").val();
			if (!isRealNumber(price)) {
				showMessage("请输入正确的保留价");
				return false;
			}
			if (!validateInputPrice(price)) {
				showMessage("报价金额不符合规范,请确保您的价格单位不小于分");
				return;
			}
			price = transMoneyToCent(price);
			return (setReservePriceAjax(price)); // 失败继续让输入
		},
		noFn : function() {
			showMessage("无法取消保留价输入,此项目必须输入保留价！");
			return false;
		}
	};
	art.dialog(op);
}

/**
 * 处理修改加价幅度
 * 
 * @return {Boolean}
 */
function dealBidRange() {
	var price = $("#textBidRange").val();
	if (!isRealNumber(price)) {
		showMessage("请输入正确的报价幅度");
		return false;
	}
	/**add by guowei 2012-3-9 begin**/
	if (!validateInputPrice(price)) {
				showMessage("输入报价幅度不符合规范,价格最多精确到分！");
				return;
	}
	/**end**/
	price = transMoneyToCent(price);
	price = Math.round(price);
	if (price <= 0){
		showMessage("加价幅度必须大于0(最小单位分)");
		return false;
	}
	if(updateBidRateAjax(price)){
		var cur_bid_range = transMoneyToUnite(price) + getUniteDesc();
		$("#currentBidRange").text("");
		$("#currentBidRange").text(cur_bid_range);
		$("#textBidRange").val("");
	}
}

/**
 * 是否成功载入数据
 * 
 * @return {Boolean}
 */
function isSuccessLoad() {
	if (hallJson.errorNO == null) {
		return true;
	}
	return false;
}

/**
 * 弹出artDialog提示框，非模式不会阻塞JS运行
 * 
 * @param {}
 *            message
 */
function showMessage(message) {
	var op = {
		title : '信息提示',
		drag : true,
		lock : true,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}

/**
 * 显示带有公告连接的提示
 * 
 * @param {}
 *            message
 */
function showMessageAddition(message) {
	var showMsg = message + '&nbsp;&nbsp;&nbsp;<a  target=\"_blank\"   href=\"'
			+ fengshanAppServer
			+ '/home/announcement/auctionAnnouncement/more.htm?projectId='
			+ projectId + '\">查看公告</a>';
	showMessage(showMsg);
}

/**
 * 不锁屏消息
 * 
 * @param {}
 *            message
 */
function showUnlockMessage(message) {
	var op = {
		title : '信息提示',
		drag : true,
		lock : false,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}

/**
 * 处理pushlet消息
 * 
 * @param {}
 *            data
 */
function dealMessage(data) {
//	if (data) {
//		for (var item in data) {
//			if (data[item] && data[item].message) {
//					if(data[item].showIt == "Y"){
//						showUnlockMessage(data[item].message);
//					}
//					dealMessageCMD(data[item]);
//			}
//		}
//	}
	if (data) {
		if(data.showIt == "Y"){
			showUnlockMessage(data.message);
		}
		dealMessageCMD(data);
	}
}

function dealMessageCMD(data){
	switch(data.messageCode){
		case "close":
			hallStatus = "waitRefresh";
			break;
		case "announcement":  //公告消息处理
		    announcementFrame.location.reload();
			break;
	}
}

/**
 * 处理大厅状态
 */
function dealHallStatus() {
	if (hallStatus == "waitRefresh"){
		refreshIt();
	}
}

function refreshIt(){
	var url = appServer+"/auction/join.htm?projectCode="+hallJson.auctionHallDTO.projectCode;
	window.location.href = url;
}

/**
 * 防止丢失无拍卖师下的开始拍卖消息
 */
$(function(){
 	self.setTimeout("tryGetStartMessage();", 1000);
});

/**
 * 在启动状态有误的情况下尝试刷新页面（无拍卖师情况下）
 */
function tryGetStartMessage(){
	if (hallJson && hallJson.auctionHallDTO){
		if ("N" == hallJson.auctionHallDTO.haveAuctioneer) { // 只有无拍卖师情况下才处理
			if(null == latestBidData || latestBidData.latestStatus == "A"){ //当启动是状态还是等待
				refreshIt();
			}
		}
	}
}
// 业务用到的end

