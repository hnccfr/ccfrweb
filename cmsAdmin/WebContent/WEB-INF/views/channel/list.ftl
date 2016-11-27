<#include "/include/head.ftl"/>
<script>
	function toAddChannelPage(){
		jQuery("#addChannelForm").submit();
	}
</script>
<div class="main">
	<div class="rhead">

 		<div class="rpos">当前位置: 栏目管理 - 列表</div>
 	
 		<div class="ropt">
 		<#if settlerAgent.access("PermissionEnum.CHANNEL_ADD")>
			<form id="addChannelForm" action="${appServer.get('/channel/add.htm')}" method="post">
				<input type="hidden" name="parentId" value="<#if parentId??>${parentId}</#if>">
				<input type="hidden" name="q" value="${query.lieDown()}"/>
				<select name="modelId" onchange="toAddChannelPage();">
					<option>--添加子栏目--</option>
					<#list modelList as model>
						<option value="${model.id}">${model.modelName}</option>
					</#list>
				</select>
			</form>
		</#if>
		</div>
		<div class="clear"></div>
	</div>

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
		  <th width="25%" class="tc">访问路径</th>
		  <th width="5%" class="tc">显示</th>
		  <th width="10%" class="tc">排序</th>
		  <th width="15%" class="tc">操作选项</th>
	  </tr>
	  <#if channelList?? && channelList?size gt 0>
	  <#list channelList as channel>
		  <tr onmouseover="changeTrColor(this)" <#if channel_index%2 == 1>class="bg"</#if> >
			  <td class="tc">${channel.id}</td>
			  <td>${channel.channelName}<span style="color:red">[${channel.modelName}]</span></td>
			  <td>${channel.code}</td>
			  <td class="tc">
			  	<#if channel.isDisplay == 1>是<#else>否</#if>
			  </td>
			  <td class="tc">
			  	<!-- 当栏目数量超过一个，且最上面栏目只允许向下移动，最下面栏目只允许向上移动 -->
			  	<#if settlerAgent.access("PermissionEnum.CHANNEL_SORT")>
				  	<#if channelList?size gt 1>
				  		<#if channel_index+1 lt channelList?size>
							<a href="down.htm?channelId=${channel.id}<#if parentId??>&parentId=${parentId}</#if>" title="下移"><img src="${appServer.get('images/admin/dw.gif')}"/></a>
						</#if>
				  		<#if channel_index gt 0>
							<a href="up.htm?channelId=${channel.id}<#if parentId??>&parentId=${parentId}</#if>" title="上移"><img src="${appServer.get('images/admin/up.gif')}"/></a>
						</#if>
				  	</#if>
			  	</#if>
			  </td>
			  <td>
			  	<#--<a href="">预览</a>|-->
			  	<#if settlerAgent.access("PermissionEnum.CHANNEL_EDIT")>
			  		<a href="${appServer.get('/channel/modify.htm?channelId=${channel.id}&q=${query.lieDown()}')}">修改</a>|
			  	</#if>
			  	<#if settlerAgent.access("PermissionEnum.CHANNEL_DEL")>
			  		<a href="${appServer.get('/channel/delete.htm?channelId=${channel.id}&q=${query.lieDown()}')}"  onclick="if(!confirm('删除栏目必须保证该栏目下不存在子栏目及内容，确认删除该栏目吗？')) {return false;}">删除</a>
			  	</#if>
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
	  <div class="pages-box" ></div>
	</div>
</div>
<#include "/include/foot.ftl"/>