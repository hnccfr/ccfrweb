$(function() {
	dochange();
	$("._dealType").change(function() {
		dochange();
	});
});

function dochange(){
	$("#deal_reason").show();
	$("#deal_btn").show();
	var $selectedvalue = $("input[name='dealType']:checked").val();
    if ($selectedvalue == "general") {
		$("#dealTypeDetail").text("���Ա�Ͷ�߷����κδ�������Ͷ�߹رգ�");
    }else if($selectedvalue == "palceUncheck"){
    	$("#dealTypeDetail").text("1.ȡ���������رս��ף�" +
    			"2.�۳��µ����Ľ���ΥԼ���⳥�����Ʒ���" +
    			"3.�ⶳ���Ʒ����ձ�֤��" +
    			"4.�۳��µ������úͻ��֡������������");
    }else if($selectedvalue == "listUncheck"){
    	$("#dealTypeDetail").text("1.ȡ���������رս��ף�" +
    			"2.�۳����Ʒ��Ľ���ΥԼ���⳥���µ�����" +
    			"3.�ⶳ�µ������ձ�֤��" +
    			"4.�۳����Ʒ����úͻ��֡������������");
    }else if($selectedvalue == "unPay"){
    	$("#dealTypeDetail").text("1.ȡ���������رս��ף�" +
    			"2.�۳���ҵĽ���ΥԼ���⳥�����ң�" +
    			"3.�ⶳ˫�����ձ�֤��" +
    			"4.�۳����������úͻ��֡������������");
    }else if($selectedvalue == "unDeliver"){
    	$("#dealTypeDetail").text("1.ȡ���������رս��ף�" +
    			"2.�۳����ҵĽ���ΥԼ���⳥����ң�" +
    			"3.�ⶳ˫�����ձ�֤��" +
    			"4.���ϸ�����˻����ջ������ң�" +
    			"5.�۳������������úͻ��֡������������");
    }
    //�������
    if($("#ccType").val() == "goodsUncheck"){
    	 $("#m_error").text("");
    	 $("#replay").hide();
   		 $("#general1").hide();
   		 $("#general2").hide();
		 if($selectedvalue == "goodsUncheck"){
		    	$("#dealTypeDetail").text("1.����\"ȷ�ϵ���\"��2.�����ϸ����������������������ң������¸������������������������");
		    	//$("#general1").show();
		 }else if($selectedvalue == "delayDeal"){
		    	$("#dealTypeDetail").text("1.��δ�����ӳٴ���Ͷ�ߡ�����Ͷ�������лظ��ӳٴ�����Ϣ��");
		    	$("#replay").show();
		    	$("#deal_reason").hide();
		    	$("#deal_btn").hide();
		 }else if($selectedvalue == "refund"){
		    	$("#dealTypeDetail").text("1.����˻���ȡ���������رս��ף������ϸ��������ȫ�����һ�������¸�����������������ǰ��ȷ���������յ��˻��������������");
		    	$("#m_error").text("");
		 }else if($selectedvalue == "refundPenalty"){
		    	$("#dealTypeDetail").text("1.����˻���ȡ���������رս��ף������ϸ��������ȫ�����һ�������¸�������������2.�۳����ҽ���ΥԼ�𲹳�����ң�����ǰ��ȷ���������յ��˻���3.�۳��������úͻ��֡������������");
		 }else if($selectedvalue == "amountOffset"){
		    	$("#dealTypeDetail").text("1.����ջ���������ɣ����׳ɹ����������Ʊ�׶Σ���ô���׼���������������Ʊ�׶Σ��������ϸ�����������������һ���ֿ۳���������ң������¸������������������������");
		    	$("#general1").show();
			   	$("#general2").show(); 
		    	$("#m_error").text("�ڴ�����Ҫ�۳��Ļ�����");
		 }
	}
    //��Ʊ����
    if($("#ccType").val() == "receiptUncheck"){
    	$("#m_error").text("");
    	$("#general1").hide();
		$("#general2").hide();
    	if($selectedvalue == "receiptUncheck"){
		    $("#dealTypeDetail").text("1.����\"ȷ�ϵ�Ʊ\";2.�����ϸ������ʣ��Ļ��ȫ�������ң������¸��������������;3.������ɣ����׳ɹ��������������");
		    $("#general1").show();
    	}else if($selectedvalue == "unBilling"){
		    $("#dealTypeDetail").text("1.�����ϸ������������ʣ������һ���ֿ۳���Ϊ����ΥԼ������������ң���һ���ִ�����ң������¸������������2.ȫ���˫�����ձ�֤��;3.������ɣ����׳ɹ��������������");
		    $("#general1").show();
	    	$("#general2").show();
		    $("#m_error").text("�ڴ�����Ҫ�۳��Ļ�����");
		}else if($selectedvalue == "unBillingPenalty"){
		    $("#dealTypeDetail").text("1.�����ϸ������������ʣ������һ���ֿ۳���Ϊ����ΥԼ������������ң���һ���ִ�����ң������¸������������2.�۳����ҽ���ΥԼ�𲹳�����ң�������ҽ��ձ�֤��3.�۳��������úͻ���;4.������ɣ����׳ɹ��������������");
		    $("#general1").show();
	    	$("#general2").show();
		    $("#m_error").text("�ڴ�����Ҫ�۳��Ļ�����");
		 }
    }
}
function validate(){
	//�����������
	var $selectedvalue = $("input[name='dealType']:checked").val();
	if($selectedvalue == "unBilling" || $selectedvalue == "unBillingPenalty" || $selectedvalue == "amountOffset"){
		
		var $inp_amount = $("#dealMoney").val();
		var $amount = $("#money_amount").val();
		var $unite = $("#money_unite").val();
		var regn = /^[ ]+$/;
		if($inp_amount =="" || regn.test($inp_amount)){
			$("#m_error").text("������Ҫ�۳��Ļ�����");
			return false;
		}
		if($unite == "yuan"){
			var regYuan1 = /^[1-9][0-9]{0,16}$/;//������
			var regYuan2 = /^(0|([1-9][0-9]{0,14}))\.[0-9]{1,2}$/;//С����С�����2λ
			if(!(regYuan1.test($inp_amount) || regYuan2.test($inp_amount))){
				alert("�������ȷ��");
				return false;
			}
			var amount_unite = $amount/100;
			if($inp_amount <=0 || $inp_amount>amount_unite){
				alert("������һ������0���Ҳ��������������ʣ���Ľ�");
				return false;
			}
		}else if($unite == "wanyuan"){
			var regYuan1 = /^[1-9][0-9]{0,16}$/;//������
			var regYuan2 = /^(0|([1-9][0-9]{0,10}))\.[0-9]{1,6}$/;//С����С�����6λ
			if(!(regYuan1.test($inp_amount) || regYuan2.test($inp_amount))){
				alert("�������ȷ��");
				return false;
			}
			var amount_unite = $amount/1000000;
			if($inp_amount <=0 || $inp_amount>amount_unite){
				alert("������һ������0���Ҳ��������������ʣ���Ľ�");
				return false;
			}
			
		}else if($unite == "yiyuan"){
			var regYuan1 = /^[1-9][0-9]{0,16}$/;//������
			var regYuan2 = /^(0|([1-9][0-9]{0,6}))\.[0-9]{1,10}$/;//С����С�����10λ
			if(!(regYuan1.test($inp_amount) || regYuan2.test($inp_amount))){
				alert("�������ȷ��");
				return false;
			}
			var amount_unite = $amount/10000000000;
			if($inp_amount <=0 || $inp_amount>amount_unite){
				alert("������һ������0���Ҳ��������������ʣ���Ľ�");
				return false;
			}
		}
	}
	//��ע���ݳ��ȼ��
	if($("#reason").val().length >340){
		alert("������һ�����������340���ַ�����");
		return false;
	}
	return true;
}