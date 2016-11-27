// ��ʽ�õ���JS begin

var debug = true;
$(function() {
			// �����ֳ�begin
			try {
				if (isSuccessLoad()) {
					initBiders();// ��ʼ���������б�
					initBidRecordsList();// ��ʼ��������Ϣ��
					initeLastBidPrice(); // ��ʼ�����һ�α���
					var user_type = hallJson.hallUserType;// �û�����
					if (user_type == "auctioneer") {// ����ʦ
						initAuctioneerControlPanel();
					} else if (user_type == "bidder") {// ������
						initBiderControlPanel();
					} else if (user_type == "viewer") {// ����
						changeStatus(latestBidData); // �޸�״̬
					} else if (user_type == "listinger") {// ������
						changeStatus(latestBidData); // �޸�״̬
					} else{
						changeStatus(latestBidData); // �޸�״̬
					}
				} else {
					showMessage("�����������ʧ��," + hallJson.errorInfo);
				}
			} catch (e) {
				showMessage('��ʼ������ʧ��,' + e);
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
//						var butValue = ($(this).attr("value") + " ȷ������")
//						$(".hall-center .jupai-confirm input").attr("value",
//								butValue);
//					});
			$("#projectTitle").text(hallJson.projectTitle); // �޸���Ŀ����
		});

// ��ʽ�õ���JS end

// Pushlet �õ��� begin

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
					+ ')'); // �õ�����json
			dealFlashBid(bidData); // ˢ��ҳ��۸�
			var resultData = eval('('
					+ event
							.get(hallJson.auctionHallDTO.projectCode
									+ "_result") + ')'); // �õ��������json
			dealResult(resultData); // �����������
			var messageData =  eval('('
					+ event
							.get(hallJson.auctionHallDTO.projectCode
									+ "_message") + ')'); // �õ���Ϣjson
			dealMessage(messageData); // ������Ϣ
		}
	} catch (e) {
		if (debug) {
			showMessage(e);
		}
	}
}
// Pushlet �õ���end
