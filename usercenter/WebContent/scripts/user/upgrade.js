function upGrade(roleName){
	jQuery.ajax({
      		type	:   'POST',
       	 	url     :   appServer+'/user/upgrade/apply.htm',
        	data   	:   {roleName   :   roleName},
        	success :   function(msn){
							if(msn > 0){
								document.getElementById("success").innerHTML = "申请提交成功，您的申请将会尽快被处理！";
								document.getElementById("success").style.display = "block";
								document.getElementById("fail").style.display = "none";
								//alert("申请提交成功，您的申请将会尽快被处理！");
								//window.location.href = appServer+'/user/upgrade/apply.htm';
							}else if(msn == 0){
								document.getElementById("fail").innerHTML = "服务器异常，申请提交失败，请重试！";
								document.getElementById("fail").style.display = "block";
								document.getElementById("success").style.display = "none";
							}else if(msn == -1){
								document.getElementById("fail").innerHTML = "您的升级申请正在审核中，不能再次提交申请";
								document.getElementById("fail").style.display = "block";
								document.getElementById("success").style.display = "none";
							}else{
								document.getElementById("fail").innerHTML = "对不起，您申请的角色低于当前您的角色";
								document.getElementById("fail").style.display = "block";
								document.getElementById("success").style.display = "none";
							}
						}
	});
}