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
			    	$(this).dialog("close");
			}
		}

	});
	})

	function optView(id) {
	$.get("${appServer.get('/permuser/view.htm')}",{"id":id},function(s) {
		$("#viewWindow").empty().append(s);
	});
	$("#viewDialog").dialog("open");
	$("#viewWindow").empty();
	isSame=false;
	}

</script>
<div class="main">
	<#if accessType=="eclp">
		<div class="rhead">
	 		<div class="rpos">当前位置: 会员组权限 - 列表</div>
			<div class="clear"></div>
		</div>
	<#else>
		<#-- nothing...-->
	</#if>
	

  <!-- 工具栏 -->
  <div class="tool">
  </div>
  <div class="clear"></div>

  <!-- 列表模块 -->
  <div class="listBox">
  <h5><span>栏目列表</span></h5>
  <table >
	  <tr style="text-align:center;">
		  <th width="5%" class="tc">ID</th>
		  <th class="tc">栏目名称</th>
		  <th width="20%" class="tc">访问路径</th>
		  <th width="30%" class="tc">有撰稿权限会员组</th>
		  <th width="5%" class="tc">显示</th>
		  <th width="15%" class="tc">操作</th>
	  </tr>
	  <#if channelList?? && channelList?size gt 0>
	  <#list channelList as channel>
		  <tr onmouseover="changeTrColor(this)" <#if channel_index%2 == 1>class="bg"</#if> >
			  <td class="tc">${channel.id}</td>
			  <td>${channel.channelName}<span style="color:red">[${channel.modelName}]</span></td>
			  <td class="tc">${channel.code}</td>
			  <td class="tc">${channelGroupMap["${channel.id}"]}</td>
			  <td class="tc">
			  	<#if channel.isDisplay == 1>是<#else>否</#if>
			  </td>
			  <td class="tc">
			  		<a onclick="optView(${channel.id})">查看</a>|
			  		<a href="${appServer.get('/permuser/edit.htm?channelId=${channel.id}&q=${query.lieDown()}')}">修改</a>
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
	  <div id="viewDialog" style="display:none" title="查看拥有此栏目的权限">
		<div id="viewWindow"></div>
	  </div>
	  <div class="pages-box" ></div>
	</div>
</div>
<#include "/include/foot.ftl"/>