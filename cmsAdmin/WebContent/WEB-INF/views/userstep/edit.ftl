<form action="/userstep/edit.htm" id="dialog_form">
<input type="hidden" name="userId" value="${userId}">
<input type="hidden" name="allChannels" id="allChannels" value="${allChannels?string}">
<input type="hidden" id="siteFinalStep" value="${siteFinalStep}" />

<div id="channels">
<table>
	<tr>
		<td>
			<label><input type="checkbox"  onclick="disChannels(this.checked)"<#if allChannels> checked="checked"</#if>/>对所有栏目审核步骤相同</label>
		</td>
		<td></td>
		<td>
			<select name="steps" id="steps" style="width:70px;">
					<#list 0..maxSiteFinalSetp as i>
						<option value="${i}" <#if userSite?? && userSite.checkStep == i>selected</#if>>${i}</option>
					</#list>
			</select>
		</td>
	</tr>
<@childChannel channels=channelList deep=0/>
</table>
</div>
</form>
<#-- 定义了个宏  -->
<#macro childChannel channels deep>
<#list channels as c>
		<tr>
			<td>  
				 	<#if c.isParent?? && c.isParent==1>
				 		<#list 1..c.level-1 as i>
				 			->
				 		</#list>
				 	</#if>
				<#if deep gt 0><#list 1..deep as i>&nbsp; &nbsp;</#list>></#if>${c.channelName}</td>
			<td></td>
			<td>
				<select name="channelCheckSetp" id="channelCheckSetp${c.id}" style="width:70px;" >
				<#if c.finalStepExtends??>
		<#list 0..c.finalStepExtends as i>
			<option value="${i}" 
			<#list userChannels as userChannel>
				<#if c.id == userChannel.channel.id>
					<#if i == userChannel.checkStep>selected</#if>
				</#if>
			</#list>
			 >${i}</option>
		</#list>
				<#else>
		<#list 0..maxSiteFinalSetp as i>
			<option value="${i}" 
			<#list userChannels as userChannel>
				<#if c.id == userChannel.channelId>
					<#if i == userChannel.checkStep>selected</#if>
				</#if>
			</#list>
			>${i}</option>
		</#list>
				</#if>
				</select>
			</td>
		</tr>
</#list>

</#macro>
