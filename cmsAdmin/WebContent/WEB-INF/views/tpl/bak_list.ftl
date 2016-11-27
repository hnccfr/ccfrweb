<script>
	
	function getTableForm() {
		return document.getElementById('tableForm');
	}
	
</script>
<div class="main">
<div class="listBox">
<h5><span></span></h5>
<#import "/include/pager.ftl" as page>
<form method="post" id="tableForm">
<input type="hidden" name="currentPage" value="${query.currentPage}">
<table width="100%" cellspacing="1" cellpadding="0" border="0" style="table-layout: fixed;" class="">
<thead class="pn-lthead"><tr>

	<th width="120" style="overflow: hidden;">操作时间</th>
	<th width="70" style="overflow: hidden;">操作人</th>
	<th width="140" style="overflow: hidden;">下一版本备注</th>
	<th width="70" style="overflow: hidden;">操作</th>
	</tr></thead>
	
	<tbody class="pn-ltbody">
	  <#if query?? && query.items??>
		<#list query.items as tBak>
		<tr id="${tBak.id}">
			<td align="left" style="overflow: hidden;">
			    <#-- 创建时间-->
				<#if tBak.gmtModify??>
					${tBak.gmtModify?string('yyyy-MM-dd HH:mm:ss')}
				</#if>
			</td>
			<td>
				<#if tBak.userName??>
					${tBak.userName}
				</#if>
			</td>
			<td>
				<#if tBak.remark??>
					${tBak.remark}
				</#if>
			</td>
			<td>
				<a  class="pn-opt" onclick="if(!confirm('您确定还原吗？')) {return false;}" href="${appServer.get('/tpl/bak/restore.htm?tplBakId=${tBak.id}&tplId=${tBak.tplId}&dirType=${dirType}')}">还原 | </a>
				<a class="pn-opt" onclick="del_tplBak('${tBak.id}')">删除 </a>
			</td>
		</tr>
		</#list>
		  <#else>
			  <tr class="bg">
			  	<td colspan="3">
			  	暂无数据
			  	</td>
			  </tr>
		  </#if>
</tbody>
</table>
<@page.ajax query  'viewWindow' 'viewDialog' 'tpl/bak/list.htm?tplId=${tplId}&dirType=${dirType}'/>
</form>
</div>

</div>
