var YI = 10000000000;// ��
var WAN = 1000000;// ��
var YUAN = 100;// Ԫ
var clk, second;
var BIGE = 1000000000000; // ���ڼ��㸡��ʱ��������

/** ��ʼ�������˿������* */
function initBiderControlPanel() {
	resetIsPriority();
	rebuildBidBtns();
	changeStatus(latestBidData); // �޸�״̬
}
/** ��ʼ������ʦ�������* */
function initAuctioneerControlPanel() {
	var bid_range = latestBidData.bidRate;// �Ӽ۷���
	if (bid_range && bid_range > 0) {
		initBidRange(bid_range);// �Ӽ۷���
	}
	changeStatus(latestBidData);// �������ܰ�ť
}

/** ��ʼ������������Ч������Ա�б�* */
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
			_html_bider = _html_bider +"�ƺţ�"+ bider.bidderTrademark;
			if (bider.isPriority == "Y") {
				_html_bider = _html_bider + "<i class=\"xx\" title=\"����Ȩ������\"></i>";
			}
			_html_bider = _html_bider + "</span></li>";

			$("#biders").append(_html_bider);
		}
	} else {
		if (debug) {
			showMessage('��������ϢΪ��');
		}
	}
}
/** ��ʼ�������������������۰�ť����* */
function initBidBtns(data) {
	var _bid_direction = hallJson.auctionHallDTO.priceDirection;// ���۷���
	var _bid_range = data.bidRate;// ���۷���(��λ����)
	var _bid_range_unite;// ����Ǯ��λ����Ԫ����Ԫ��Ԫ���ı��۷���
	_bid_range_unite = transMoneyToUnite(_bid_range);
	var _bid_range_unite_direction = accMul(_bid_range_unite, _bid_direction);// �����۷���ķ���
	// ��ʼ����������ť
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
/** ���ļ۰�ť* */
function initStartPriceBtn() {
	cleanStartPriceBtn();
	var _html_bid_start_price = "<li id=\"bidStartPrice\"><input type=\"button\" value=\"���ļ۱���\" class=\"button-2\" onclick=\"dealStartPriceBid();\"/></li>"
	$("#baojia").prepend(_html_bid_start_price);
	//	$("#baojia").append(_html_bid_start_price);
}

/**
 * ������ļ۰�ť
 */
function cleanStartPriceBtn() {
	$("#bidStartPrice").remove();
}

/** ����Ȩ��ť* */
function initPriorityBtn() {
	cleanPriorityBtn();
	var _html_bid_priority = "<li id=\"bidPriorityPrice\"><input type=\"button\" value=\"����Ȩ����\" class=\"button-2\" onclick=\"dealPriorityBid();\"/></li>"
	$("#baojia").prepend(_html_bid_priority);
//	$("#baojia").append(_html_bid_priority);
}

/**
 * �������Ȩ��ť
 */
function cleanPriorityBtn() {
	$("#bidPriorityPrice").remove();
}

/** ��ʼ��������������������������* */
function initBidInput() {
	var _bid_range = hallJson.auctionLatestBidDTO.bidRate;
	if (!_bid_range) {
		$("#baojia").addClass("tc");
		clearBidBtns();
		var _html_bid_input = "<p class=\"clear-l\">"
				+ "<span style=\"color: #69707F;font-size:18px;font-weight:bold;height: 30px;\">���ۣ�&nbsp;</span>"
				+ "<input id=\"bidInput\" type=\"text\" style=\"font-size:18px;height:32px;width:160px;background-color:#E0E0E0\" />"
				+"<span style=\"color: #69707F;font-size:14px;\">"
				+ getUniteDesc()
				+ "</span>"
				+ "<span>&nbsp;&nbsp;</span><input type=\"button\" onclick=\"dealInputBid();\" class=\"button-8\" style=\"font-size:14px;\" value=\"�� ��\" />"
				+ "</p>";
		$("#baojia").append(_html_bid_input);
	}
}
/** ��ʼ����������������Ϣ�б�* */
function initBidRecordsList() {
	var _html_bide_records = "";
	var unite = hallJson.auctionHallDTO.valuationUnit;// ���۵�λ
	var bid_mark = hallJson.bidderTrademark;//��ǰ�û��ƺ�
	var bide_records = hallJson.auctionBidRecordDTOs;
	var bide_seq = bide_records.length;
	var money_desc = getUniteDesc();
	$("#bideUnite").text(money_desc);
	initBidMark();// ��ʼ����Ŀ�Ϸ����ƺ�
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

/** ��ʼ�����һ�α�����Ϣ* */
function initeLastBidPrice() {
	var html;
	if (latestBidData && latestBidData.latestBid > 0) {
		changeLastBidPrice(latestBidData);
	} else {
		var html = "���ļۣ�<strong>"
				+ getFormatPrice(hallJson.auctionHallDTO.bidStartPrice)
				+ "</strong>";
		$("#lastBidPrice").html(html);
	}
}
/** ��ʼ�������б��Ϸ����ƺ���ʾ* */
function initBidMark() {
	var user_type = hallJson.hallUserType;// �û�����
	if (user_type == "bidder") {
		$(".mark").empty();
		var bid_mark = hallJson.bidderTrademark;
		var _html_bid_mark = "�ҵ��ƺţ�<label ><strong>" + bid_mark
				+ "</strong></label>";
		var priority = hallJson.isPriority;// ����Ȩ
		if (priority == "Y") {
			_html_bid_mark = _html_bid_mark + "<i class=\"xx\" title=\"����Ȩ������\"></i>";
		}
		$(".mark").append(_html_bid_mark);
	}

}
/** ��ʼ���Ӽ۷�����������* */
function initBidRange(range) {
	var _bid_direction = hallJson.auctionHallDTO.priceDirection;// ���۷���
	var direct="����";
	if(_bid_direction){
		if(_bid_direction <= 0){
			direct = "����";
		}else if(_bid_direction > 0){
			direct = "�Ӽ�";
		}
	}
	var _html_bid_range = "<div style=\"text-align:center;\">"
			+ "<span style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">��ǰ"+direct+"���ȣ�</span>"
			+ "<span id=\"currentBidRange\" style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">"
			+ transMoneyToUnite(range) + getUniteDesc()+"</span><br />"
			+ "<span style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">����"+direct+"���ȣ�</span>"
			+ "<input id=\"textBidRange\" type=\"text\" maxlength=\"12\" style=\"font-weight:bold;height:40px;width:160px;font-size: 30px;\" />"
			+ "<span style=\"font-size: 18px;font-weight:bold;height: 50px; line-height: 50px;\">"+getUniteDesc()+"</span>"
			+ "&nbsp;&nbsp;<input type=\"button\" class=\"button-3\" value=\"ȷ ��\" onclick=\"dealBidRange();\" />"
			+ "</div><br /><br /><br /><br /><br />";
	$(".jp_btn").empty();
	$(".jp_btn").append(_html_bid_range);
}
/** ��ʼ��������ʼ��ť* */
function initBidStratBtn() {
	var showTitle = "��ʼ����";
	var biders = hallJson.auctionBidderDTOs;
	if (!biders || biders.length < 2) { // ����2��������
		showTitle = "����";
	}
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\""
			+ showTitle + "\" onclick=\"bulidAuctioneerDo(this,'start');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** ��ʼ����һ�γ��۰�ť* */
function initFirstBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"���۵�һ��\" onclick=\"bulidAuctioneerDo(this,'auction_one');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** ��ʼ���ڶ��γ��۰�ť* */
function initSecondBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"���۵ڶ���\" onclick=\"bulidAuctioneerDo(this,'auction_two');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** ��ʼ�������γ��۰�ť* */
function initThirdBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"���۵�����\" onclick=\"bulidAuctioneerDo(this,'auction_three');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** ��ʼ������Ȩ��ʼ��ť* */
function initPriorityStratBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"��ʼ����Ȩ\" onclick=\"bulidAuctioneerDo(this,'priority_start');\"  />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}

/** ��ʼ������Ȩ��һ�γ��۰�ť* */
function initPriorityFirstBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"���۵�һ��\" onclick=\"bulidAuctioneerDo(this,'priority_auction_one');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** ��ʼ������Ȩ�ڶ��γ��۰�ť* */
function initPrioritySecondBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"���۵ڶ���\" onclick=\"bulidAuctioneerDo(this,'priority_auction_two');\" />";
	$(".control").empty();
	$(".control").append(_html_bid_start);
}
/** ��ʼ������Ȩ�����γ��۰�ť* */
function initPriorityThirdBidBtn() {
	var _html_bid_start = "<input type=\"button\" class=\"button-1\" value=\"���۵�����\" onclick=\"bulidAuctioneerDo(this,'priority_auction_three');\" />";
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

/** ����ʱ������* */
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
	var t = _mm.substring(_mm.length - 2, _mm.length) + "��"
			+ _ss.substring(_ss.length - 2, _ss.length) + "��";
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

/** �����ô���* */
function beatHammer(cmd) {
	if (cmd == "auction_one" || cmd == "auction_two" || cmd == "auction_three"
			|| cmd == "priority_auction_one" || cmd == "priority_auction_two"
			|| cmd == "priority_auction_three") {
		$("#cz").attr("src", imageServer + "/images/auction/lp.gif");
	}
}
/** �ɽ���������* */
function bargain() {
	$("#cz").attr("src", imageServer + "/images/auction/cj.png");
}
/** ���Ĵ��Ӻ��* */
function flow() {
	$("#cz").attr("src", imageServer + "/images/auction/lp.png");
}

/**
 * ����Ϊ��λ�Ľ�Ǯת��Ϊ������λ��Ӧ������<br />
 * С�������ౣ����λ��ȡ����Ҫת���ɵĵ�λ�� ��10λ(yiyuan)����6λ(wanyuan)��Ԫ2λ(yuan)<br />
 * ������λ����0<br />
 * ��ȷ���֣��磺��(101)�������ǰ��Ŀ�ĵ�λ�ǡ�yuan��������1.01)
 */
function transMoneyToUnite(money) {
	var unite = hallJson.auctionHallDTO.valuationUnit;// ���۵�λ
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
 * ��ҳ�汨��ת���ɷ�Ϊ��λ������<br />
 * ������۵�λ������Ԫ(yiyuan)����Ԫ(wanyuan)��Ԫ(yuan)�е�һ���򷵻�0
 */
function transMoneyToCent(money) {
	var _money_cent;
	var _bid_unite = hallJson.auctionHallDTO.valuationUnit;// ���۵�λ
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
 * ��ȡ��Ǯ�ĵ�λ����<br />
 * ��Ǯ�ĵ�λ�Զ���ȡ��Ŀ���۵�λ
 */
function getUniteDesc() {
	var unite = hallJson.auctionHallDTO.valuationUnit;// ���۵�λ
	var desc = "";
	if (unite == "yiyuan") {
		desc = "��Ԫ";
	} else if (unite == "wanyuan") {
		desc = "��Ԫ";
	} else if (unite == "yuan") {
		desc = "Ԫ";
	}
	return desc;
}

/*
 * ��֤ҳ�������Ǯ�ַ����ĸ�ʽ ������С���㣬���ֵ��ܳ��Ȳ�����17λ
 */
function validateInputPrice(price) {
	var priceStr = "" + price;
	var result = true;
	if (priceStr.indexOf(".") != -1) {// ��С����
		if (priceStr.length > 18) {
			result = false;
		} else {
			var _bid_unite = hallJson.auctionHallDTO.valuationUnit;// ���۵�λ
			if ("yiyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;// С����С�����10λ
				result = reg.test(priceStr);
			} else if ("wanyuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;// С����С�����6λ
				result = reg.test(priceStr);
			} else if ("yuan" == _bid_unite) {
				var reg = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;// С����С�����2λ
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
/** �������ڸ�ʽ����ʽ* */
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

/** ��ʽ�õ��� begin* */
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

/** ��ʽ�õ��� end* */

// ҵ���õ���begin
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
	var html = '���±��ۣ�<span>' + data.bidderTrademark
			+ '��</span>����<span class="r">' + getFormatPrice(data.latestBid)
			+ '</span>';
	$("#flash p").html(html);
	changeLastBidPrice(data);
}

function showFlashData(html) {
	$("#flash p").html(html);
	jupai(); // ҳ��Ч��
}

function changeLastBidPrice(data) {
	var html = "���±��ۣ�<strong>" + getFormatPrice(data.latestBid) + "</strong>��"
			+ data.bidderTrademark + "�ţ�";
	$("#lastBidPrice").html(html);
}

/**
 * �޸�ҳ���״̬����
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
	if (isBidder) { // ������
		var rebuild = true;
		if (prevLatestBidData) {
			if (prevLatestBidData.bidRate == latestBidData.bidRate) {
				rebuild = false;
			}
		}
		if (rebuild) {
			var bid_range = latestBidData.bidRate;// �Ӽ۷���
			if (bid_range && bid_range > 0) {
				initBidBtns(latestBidData);// ��ʼ�����۰�ť��
			} else {
				initBidInput();// ��ʼ������������
			}
		}
		if (!latestBidData || latestBidData.latestBid <= 0) {
			initStartPriceBtn(); // ��ʼ�����ļ۰�ť
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
	if ("N" == hallJson.auctionHallDTO.haveAuctioneer) { // ֻ��������ʦ����²���ʾʱ��
		timeCountDown(latestBidData.nextEndMilliSeconds);
	}
}

function clearTimeWair() {
	cleanClock();
}

/**
 * ��ȡ��󱨼��ַ���
 * 
 * @return {}
 */
function getLatestBidDesc() {
	var desc = "���˱���";
	if (latestBidData && latestBidData.latestBid > 0) {
		desc = getFormatPrice(latestBidData.latestBid)
	}
	return desc;
}

/**
 * ״̬�仯 /** ��������״̬�� A: �ȴ�ʱ�俪ʼ��
 * <p>
 * C: �ȴ�����ʦ��ʼ
 * <p>
 * E: �����ѿ�ʼ,�������˱���
 * <p>
 * G: ���Ҿ�����.
 * <p>
 * G1:���۵�1��.
 * <p>
 * G2:���۵�2��
 * <p>
 * K: �ȴ�����ʦ��ʼ����Ȩ�׶�
 * <p>
 * L: ����Ȩ�׶����˳���
 * <p>
 * M:����Ȩ�׶μ��Ҿ�����
 * <p>
 * M1:����Ȩ�׶γ��۵�1��.
 * <p>
 * M2:����Ȩ�׶γ��۵�2��.
 * <p>
 * P: �ȴ����뱣����
 * <p>
 * Z: ��������
 * 
 * @param {}
 *            data
 */
function changeStatus(data) {
	switch (data.latestStatus) {
		case "A" : // �ȴ���ʼ
			showTimeWait();
			changeStatusTitle("�ȴ���ʼ");
			changeBidButton(false);
			if (isAuctioneer) {
				initBidStratBtn();// ������ʼ��ť
			}
			break;
		// case "C" : // �ȴ�����ʦ��ʼ
		// showTimeWait();
		// changeStatusTitle("�ȴ�����ʦ��ʼ");
		// changeBidButton(false);
		// if (isAuctioneer) {
		// initBidStratBtn();// ������ʼ��ť
		// }
		// break;
		case "E" : // �����ѿ�ʼ,�������˱���
			showTimeWait();
			changeStatusTitle("�����ѿ�ʼ,�������˱���");
			changeBidButton(true);
			if (isAuctioneer) {
				initFirstBidBtn();
			}
			break;
		case "G" : // ���Ҿ�����
			showTimeWait();
			changeStatusTitle("���Ҿ�����");
			changeBidButton(true);
			if (isAuctioneer) {
				initFirstBidBtn();
			}
			break;
		case "G1" : // ���۵�1��
			showTimeWait();
			changeStatusTitle("���۵�1��");
			changeBidButton(true);
			if (isAuctioneer) {
				initSecondBidBtn();
			}
			showFlashData(getLatestBidDesc() + "��1��");
			break;
		case "G2" : // ���۵�2��
			showTimeWait();
			changeStatusTitle("���۵�2��");
			changeBidButton(true);
			if (isAuctioneer) {
				initThirdBidBtn();
			}
			showFlashData(getLatestBidDesc() + "��2��");
			break;
		case "K" : // �ȴ�����ʦ��ʼ����Ȩ�׶�
			showTimeWait();
			changeStatusTitle("�ȴ���ʼ����Ȩ�׶�");
			changeBidButton(false);
			if (isAuctioneer) {
				initPriorityStratBtn();
			}
			break;
		case "L" : // ����Ȩ�׶����˳���
			showTimeWait();
			changeStatusTitle("����Ȩ�׶����˳���");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPriorityFirstBidBtn();
			}
			break;
		case "M" : // ����Ȩ�׶μ��Ҿ�����
			showTimeWait();
			changeStatusTitle("����Ȩ�׶μ��Ҿ�����");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPriorityFirstBidBtn();
			}
			break;
		case "M1" : // ����Ȩ�׶γ��۵�1��
			showTimeWait();
			changeStatusTitle("����Ȩ�׶γ��۵�1��");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPrioritySecondBidBtn();
			}
			showFlashData(getLatestBidDesc() + "����Ȩ�׶ε�1��");
			break;
		case "M2" : // ����Ȩ�׶γ��۵�2��
			showTimeWait();
			changeStatusTitle("����Ȩ�׶γ��۵�2��");
			if (isPriority) {
				changeBidButton(true);
			} else {
				changeBidButton(false);
			}
			if (isAuctioneer) {
				initPriorityThirdBidBtn();
			}
			showFlashData(getLatestBidDesc() + "����Ȩ�׶ε�2��");
			break;
		case "P" : // �ȴ����뱣����
			showTimeWait();
			changeStatusTitle("�ȴ����뱣����");
			changeBidButton(false);
			if (isAuctioneer) {
				inputReservePrice();
			}
			cleanAuctioneerBtn();
			break;
		case "Z" : // ��������
			clearTimeWair();
			changeStatusTitle("��������");
			changeBidButton(false);
			cleanAuctioneerBtn();
			break;
		default : // δ֪״̬
			changeStatusTitle("δ֪״̬:" + data.latestStatus);

	}
}

/**
 * ���������ݸ���
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
				refreshData = false; // ����ˢ������
			}

			if (data.auctionLatestBidDTO.latestStatus == latestBidData.latestStatus) {
				refreshStatus = false; // ����ˢ��״̬
			}
		}
		dealHallStatus();
		prevLatestBidData = latestBidData; // ����ǰһ�����һ�α�����Ϣ
		latestBidData = data.auctionLatestBidDTO;
		resetIsPriority();
		rebuildBidBtns(); // �ؽ��Ӽ۰�ť��
		if (refreshData) {
			showTimeWait(); // ������ʾ����
			addBidList(latestBidData); // �����б��Ҳ�˵�
			changeFlashData(latestBidData); // �޸�flash��ʾ������
			jupai(); // ҳ��Ч��
		}
		if (refreshStatus) {
			changeStatus(latestBidData);
		}

	}
}

/**
 * ��ʾ���dialog
 * 
 * @param {}
 *            data
 */
function showResultDialog(data) {

	var content = "<table width=\"100%\" class=\"tb2\">"
			+ "<tr><th>�ɽ��ƺţ�</th><td>" + data.bidderTrademark + "</td></tr>"
			+ "<tr><th>�ɽ��۸�</th><td>" + getFormatPrice(data.price)
			+ "</td></tr>";
	if (data.bidderTrademark == hallJson.bidderTrademark) {
		content += "<tr><th>�����ţ�</th><td><a target='_blank' href='"
				+ fengshanAppServer + "/order/detail.htm?orderNo="
				+ data.orderNo + "' >" + data.orderNo + "</a></td></tr>";
	}
	content += "</table>";
	var op = {
		id : "bidResult",
		title : '�ɽ���ʾ',
		drag : true,
		lock : true,
		content : content,
		yesFn : true,
		noFn : true
	};
	art.dialog(op);
}
/**
 * �����ȡ�������
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
				changeStatusTitle("��������,�ɽ�");
				showFlashData("�ɽ�");
				break;
			case "N" :
				changeStatusTitle("��������,����");
				flow();
				break;
			case "C" :
				changeStatusTitle("��������,��������");
				flow();
				break;
		}
	}
}

/**
 * ������֤
 * 
 * @param {}
 *            price
 * @return {Boolean}
 */
function validateBid(price) {
	// �жϵ�ǰ����״̬�Ƿ�������
	if (!isNum(price)) {
		showMessage("���۽������");
		return false;
	}
	if (latestBidData) {
		if (latestBidData.latestStatus == "A"
				|| latestBidData.latestStatus == "P"
				|| latestBidData.latestStatus == "C"
				|| latestBidData.latestStatus == "K"
				|| latestBidData.latestStatus == "Z") {
			showMessage("��ǰ״̬�²������ۣ�");
			return false;
		}
	}
	// �ж��Ƿ�Ϊ�����۵��û�����
	if (!isBidder) { // ֻ�о����˲�������
		showMessage("ֻ�о����˲�������");
		return false;
	}
	if (latestBidData.latestStatus == "L" || latestBidData.latestStatus == "M"
			|| latestBidData.latestStatus == "M1"
			|| latestBidData.latestStatus == "M2") {
		if (!isPriority) { // ������ȨҲ����󱨼���
			showMessage("�Բ�������Ȩ�ڴ˽׶α���");
			return false;
		}
	}
	// �۸��Ƿ���ڵ�ǰ��߼۸�
	var priority = $("#dealBidConfirmDialog").data("priority");
	if (latestBidData && latestBidData.latestBid > 0) {
		if (hallJson.auctionHallDTO.priceDirection > 0) {
			if (price <= latestBidData.latestBid && "Y" != priority) {
				showMessage("���ļ۸���С�ڵ�ǰ���±���"
						+ getFormatPrice(latestBidData.latestBid));
				return false;
			}
		} else {
			if (price >= latestBidData.latestBid && "Y" != priority) {
				showMessage("���ļ۸��ܴ��ڵ�ǰ���±���"
						+ getFormatPrice(latestBidData.latestBid));
				return false;
			}
		}
	}
	if (price <= 0){
		showMessage("���ļ۸�������0");
		return false;
	}
	return true;
}

/**
 * ������
 * 
 * @param {}
 *            num ��Ϊ��λ�����ӽ��
 */
function dealBid(addNum) {
	if (typeof(addNum) != "number") {
		showMessage("���۽�����Ϊ����");
		return;
	}
	// ����
	var price = addNum;
	try {
		if (latestBidData && latestBidData.latestBid > 0) {
			price = accAdd(price,latestBidData.latestBid);
		} else { // �ޱ�����ȡ���ļ�
			price = accAdd(price,hallJson.auctionHallDTO.bidStartPrice);
		}
	} catch (e) {
		price = "";
	}
	if (!isNum(price)) {
		showMessage("�����󣬱���ʧ�ܣ�");
		return;
	}
	if (validateBid(price)) {
		openBidConfirmDialog(price);
	}
}

/**
 * ����Ȩ����
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
 * �������뱨��
 * 
 * @param {}
 *            num
 */
function dealInputBid() {
	var num = $("#bidInput").val();
	if (!isRealNumber(num)) {
		showMessage("���۽�����Ϊ����");
		return;
	}
	if (!validateInputPrice(num)) {
		showMessage("���۽����Ϲ淶,��ȷ�����ļ۸�λ��С�ڷ�");
		return;
	}
	var price = transMoneyToCent(num);
	if (validateBid(price)) {
		openBidConfirmDialog(price);
	}
}

/**
 * ���ļ۱���
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
 * ������ʾ
 * 
 * @param {}
 *            price
 */
function openBidConfirmDialog(price) {
	$("#dealBidConfirmDialog").data("price", price);
	var op = {
		id : "bidConfirm",
		title : '����ȷ��',
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
	html += '<th>���ۣ�</th>';
	html += '<td>' + price + '</td>';
	html += '</tr></table>';
	return html;
}

$(function() {
			if ($("#dealBidConfirmDialog").size() <= 0) {
				$("body").append("<div id='dealBidConfirmDialog'></div>");
			}
		});

/** ���뱣����* */
function inputReservePrice() {
	var op = {
		id : "reservePrice",
		title : '������',
		drag : true,
		lock : true,
		content : "<table width=\"100%\" class=\"tb2\">"
				+ "<tr><th>�����뱣���ۣ�</th><td>"
				+ "<input type=\"text\" id=\"reservePrice\" name=\"reservePrice\" />"
				+ getUniteDesc() + "</td></tr></table>",
		yesFn : function() {
			// ��������
			var price = $("#reservePrice").val();
			if (!isRealNumber(price)) {
				showMessage("��������ȷ�ı�����");
				return false;
			}
			if (!validateInputPrice(price)) {
				showMessage("���۽����Ϲ淶,��ȷ�����ļ۸�λ��С�ڷ�");
				return;
			}
			price = transMoneyToCent(price);
			return (setReservePriceAjax(price)); // ʧ�ܼ���������
		},
		noFn : function() {
			showMessage("�޷�ȡ������������,����Ŀ�������뱣���ۣ�");
			return false;
		}
	};
	art.dialog(op);
}

/**
 * �����޸ļӼ۷���
 * 
 * @return {Boolean}
 */
function dealBidRange() {
	var price = $("#textBidRange").val();
	if (!isRealNumber(price)) {
		showMessage("��������ȷ�ı��۷���");
		return false;
	}
	/**add by guowei 2012-3-9 begin**/
	if (!validateInputPrice(price)) {
				showMessage("���뱨�۷��Ȳ����Ϲ淶,�۸���ྫȷ���֣�");
				return;
	}
	/**end**/
	price = transMoneyToCent(price);
	price = Math.round(price);
	if (price <= 0){
		showMessage("�Ӽ۷��ȱ������0(��С��λ��)");
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
 * �Ƿ�ɹ���������
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
 * ����artDialog��ʾ�򣬷�ģʽ��������JS����
 * 
 * @param {}
 *            message
 */
function showMessage(message) {
	var op = {
		title : '��Ϣ��ʾ',
		drag : true,
		lock : true,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}

/**
 * ��ʾ���й������ӵ���ʾ
 * 
 * @param {}
 *            message
 */
function showMessageAddition(message) {
	var showMsg = message + '&nbsp;&nbsp;&nbsp;<a  target=\"_blank\"   href=\"'
			+ fengshanAppServer
			+ '/home/announcement/auctionAnnouncement/more.htm?projectId='
			+ projectId + '\">�鿴����</a>';
	showMessage(showMsg);
}

/**
 * ��������Ϣ
 * 
 * @param {}
 *            message
 */
function showUnlockMessage(message) {
	var op = {
		title : '��Ϣ��ʾ',
		drag : true,
		lock : false,
		content : message,
		yesFn : true
	};
	art.dialog(op);
}

/**
 * ����pushlet��Ϣ
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
		case "announcement":  //������Ϣ����
		    announcementFrame.location.reload();
			break;
	}
}

/**
 * �������״̬
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
 * ��ֹ��ʧ������ʦ�µĿ�ʼ������Ϣ
 */
$(function(){
 	self.setTimeout("tryGetStartMessage();", 1000);
});

/**
 * ������״̬���������³���ˢ��ҳ�棨������ʦ����£�
 */
function tryGetStartMessage(){
	if (hallJson && hallJson.auctionHallDTO){
		if ("N" == hallJson.auctionHallDTO.haveAuctioneer) { // ֻ��������ʦ����²Ŵ���
			if(null == latestBidData || latestBidData.latestStatus == "A"){ //��������״̬���ǵȴ�
				refreshIt();
			}
		}
	}
}
// ҵ���õ���end

