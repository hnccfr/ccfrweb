<div class="fb tc red">${channel.channelName}</div>

<div class="mt10">
<div class="tc" align="center" style="display:none;">投稿权限</div>
<table width="100%" border="1">
	<tbody>
	<#if groupUploadList?size gt 0>
	<tr>
		<td width="50%">会员组名</td>
		<td>
			<TABLE>
			<TBODY>
			<#list groupUploadList as groupUpload>
			<TR>
			<TD>${groupUpload.groupName}</TD>
			</TR>
			</#list>
			</TBODY></TABLE>
		</td>
	</tr>
	<#else>
	<tr><td class="tc" colspan="2" width="100%">无会员组拥有此权限</td></tr>
	</#if>
	
	</tbody>
</table>
</div>

<div style="float:right;width:50%;display:none;">
<div class="tc" align="center">查看权限</div>
<table width="100%" border="1">
	<tbody>
		<tr>
			<th width="50%">会员组名</th>
			<th width="50%">会员组code</th>
		</tr>
		<#if groupViewList?size gt 0>
		<#list groupViewList as groupView>
		<tr>
			<td width="50%">${groupView.groupName}</td>
			<td width="50%">${groupView.code}</td>
		</tr>
	</#list>
	<#else>
	<tr><td class="tc" colspan="2" width="100%">无会员组拥有此权限</td></tr>
	</#if>
	</tbody>
</table>
</div>