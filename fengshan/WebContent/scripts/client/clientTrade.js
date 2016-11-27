$(function() {
	$("#clientTradeDiv").dialog( {
		autoOpen : false,
		bgiframe : true,
		modal : true,
		position : [ 'center', 200 ],
		width : 700,
		title : "选择地址",
		buttons : {
			"确认" : function() {
				$(this).dialog("close");
			}
		}
	});
	$("#clientTradeDiv").bind("dialogopen", function(event, ui) {
		// $("#clientTradeDiv").load(
			// clientServer + "/placeOrder/trade.htm?projectCode="
			// + proejctCode);
			$("#clientTradeDiv")
					.load("http://gates.igoldcane.com:8044/success.htm?rnd="+Math.random());
		});
	$("#clientTradeDiv").bind("dialogclose", function(event, ui) {
		this.proejctCode = "";
		$(this).empty();
	});

});
var proejctCode = "";
function showClientTrade(proejctCode) {
	alert(Math.random());
	this.proejctCode = proejctCode;
	if ($("#clientTradeDiv")) {
		alert("exit");
	} else {
		alert("not define");
	}

	$("#clientTradeDiv").dialog("open");

}