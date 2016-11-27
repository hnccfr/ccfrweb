<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="用户权限管理" path="" curPath="用户权限管理">
<#include "/include/head.ftl"/>
<script>
	$(function() {
	 companyView=  $("#viewDialog").dialog({
		autoOpen: false,
		modal: true,
		width: 380,
		height: 280,
		bgiframe:true,
		position: ["center",50],
		buttons: {
			"确定": function() {
					$("#dialog_form").submit();
			    	//$(this).dialog("close");
			    	//$("#viewWindow").empty();
			    	// $("#viewDialog").remove().dialog("destroy");
			    	//$(this).dialog("destroy");
			}
		}
	});
	});

function toSave( i, channelId ){
	var url="/userstep/edit.htm";
	jQuery.ajax (
	{
		type		: 'GET',
		url			: url,
		data		: {
			channelId	: channelId,
			copyMain	: $('#copyMain' + i ).attr("checked"),
			copyCopy	: $('#copyCopy' + i ).attr("checked"),
			channelCopyIds:	$('#copyMainToCopy' + i ).val()
		},
		timeout		: 5000,
		success		: function(data,textStatus, xhr) {
			if( data != "success" ){
				alert( data );
			}else{
				alert('操作成功！');
				$('#divMainShow' + i ).show();
				$('#divCopyShow' + i ).show();
				$('#divMain' + i ).hide();
				$('#divCopy' + i ).hide();
				$('#divAEdit' + i ).show();
				$('#divASave' + i ).hide();
				if( $('#copyMainToCopy' + i ).val() != "" ){
					toGetChannelTreeAllPath( i );
				}else{
					$('#divMainShow' + i ).html( "" );
				}
				$('#copyMainToCopyBack' + i ).val( $('#copyMainToCopy' + i ).val() );
			}
		},
		error		: function(xhr, textStatus, errorThrown) {
			alert('操作失败，请重试!');
		}
	});
}

	function optEdit(id) {
		//第一次打开，需要获取数据。	
		var selected = $("#steps").val();//获取内容审核步骤的最终值
		var siteFinalStep = $("#siteFinalStep").val();//站点的最终审核步骤数
		if(selected > siteFinalStep){//当超过站点设置的步骤数则选中站点步骤数
			selected = siteFinalStep;
		}
		var timstamp = new Date().valueOf();  
		var url = "${appServer.get('/userstep/editView.htm')}?d="+new Date().getTime();
		$.get(url,{"userId":id,"siteId":${siteId}},function(s) {
			$("#viewWindow").empty().append(s);
			if( $("#allChannels").val() == "true" ) {
					$("select").each(function(){
						if( this.name == 'channelCheckSetp'){
							$('#'+this.id).attr('disabled',true);
							$('#'+this.id).val(selected);//当被选中时初始化checkbox中的值
						}
					});
				}
		});
		$("#viewDialog").dialog("open");
		$("#viewWindow").empty();
		isSame=false;
	}

	 function disChannels(chk) {
		$("#allChannels").val(chk);
		if(chk) {
			var selected = $("#steps").val();//获取内容审核步骤的最终值
			var siteFinalStep = $("#siteFinalStep").val();//站点的最终审核步骤数
			if(selected > siteFinalStep){//当超过站点设置的步骤数则选中站点设置步骤数
				selected = siteFinalStep;
			}
			$("select").each(function(){
				if( this.name == 'channelCheckSetp'){
					$('#'+this.id).attr('disabled',true);
					$('#'+this.id).val(selected);//当被选中时初始化checkbox中的值
				}
			});
		} else {
			$("select").each(function(){
				if( this.name == 'channelCheckSetp'){
					$('#'+this.id).attr('disabled',false);
				}
			 });
		}
		}
</script>
<div class="main">
	<div class="rhead">
 		<div class="rpos">当前位置: 用户 - 列表</div>
		<div class="clear"></div>
	</div>

  <!-- 工具栏 -->
  <div class="tool">
  </div>
  <div class="clear"></div>

  <!-- 列表模块 -->
  <div class="listBox">
  <h5><span>用户列表</span></h5>
  <table >
	  <tr style="text-align:center;">
		  <th width="5%"  class="tc">ID</th>
		  <th width="25%" class="tc">账号</th>
		  <th width="25%" class="tc">姓名</th>
		  <th width="25%"  class="tc">性别</th>
		  <th width="15%" class="tc">操作</th>
	  </tr>
	  <#if userList?? && userList?size gt 0>
	  <#list userList as user>
		  <tr onmouseover="changeTrColor(this)" <#if user_index%2 == 1>class="bg"</#if> >
			  <td class="tc">${user.id}</td>
			  <td class="tc"><#if user.account??>${user.account}</#if></td>
			  <td class="tc"><#if user.name??>${user.name}</#if></td>
			  <td class="tc"><#if user.sex??>${sexTypeMap["${user.sex}"]}</#if></td>
			  <td class="tc">
			  <a onclick="optEdit('${user.id}')">设置权限</a>
			  </td>
		  </tr>
	  </#list>
	  <#else>
		  <tr class="bg">
		  	<td colspan="6">
		  	暂无数据
		  	</td>
		  </tr>
	  </#if>
	  </table>
	  <div id="viewDialog" style="display:none" title="设置权限">
	  
		<div id="viewWindow"></div>
	  </div>
	  <div class="pages-box" ></div>
	</div>
	 <#-- start-->
	 	<div id="channelDialog" title="<@s.m "cmsUser.channels"/>(site.name)" style="display:none;">
		<label><input type="checkbox" onclick="disChannels(this.checked)"/><@s.m "cmsUser.channels.allChannel"/></label>
		<div id="channels"></div>
		
	</div>
	 <#--end-->
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>

