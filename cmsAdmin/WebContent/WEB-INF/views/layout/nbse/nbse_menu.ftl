<div class="main-left">
  <div class="modules" id="modules">
	<h4>提醒管理</h4>
        <ul>
    		<li><a href="${bookingServer.get('/admin/notify/notify_list.htm')}">提醒管理</a></li>
        </ul>
	<#if settlerAgent.access('CRM_MEMBER')>
		<h4>会员管理</h4>
        <ul>
    		<li><a href="${bookingServer.get('/admin/member/list_members.htm')}">会员管理</a></li>
			<li><a href="${bookingServer.get('/admin/member/list_memberAuth.htm')}">会员权限管理</a></li>
        </ul>
     </#if>

	<#if settlerAgent.access('CRM_TRADE')>
		<h4>客服中心</h4>
        <ul>
        	<#if settlerAgent.access('LIST_TRADE')>
        		<li><a href="${bookingServer.get('/admin/order/list.htm')}">订单查询</a></li>
        	</#if>
        </ul>
     </#if>

	<#if settlerAgent.access('CRM_USER') || settlerAgent.access('CRM_ROLE') || settlerAgent.access('WORKLOG')
		|| settlerAgent.access('SYS_CONFIG')||settlerAgent.access('BILL_MANAGER')>
        <h4>运价管理</h4>
		<ul >
			<#if settlerAgent.access('CRM_USER')>
        		<li><a href="${bookingServer.get('/admin/yunjia/list.htm')}">运价管理</a></li>
        	</#if>
        </ul>
		<h4>结算中心</h4>
		<ul >
			<#if settlerAgent.access('BILL_MANAGER')>
        		<li><a href="${bookingServer.get('/admin/account/bill_list.htm')}">账单管理</a></li>
        	</#if>
        </ul>
		<h4>系统管理</h4>
        <ul>
        	<#if settlerAgent.access('CRM_USER')>
        		<li><a href="${bookingServer.get('/admin/system/user/list_user.htm')}">系统用户管理</a></li>
        	</#if>
        	<#if settlerAgent.access('CRM_ROLE')>
        		<li><a href="${bookingServer.get('/admin/system/role/list_role.htm')}">系统角色管理</a></li>
        	</#if>
        	<#if settlerAgent.access('WORKLOG')>
        		<li><a href="${bookingServer.get('/admin/system/worklog/list_worklog.htm')}">操作日志管理</a></li>
        	</#if>
        	<#if settlerAgent.access('SYS_CONFIG')>
        		<li><a href="${bookingServer.get('/admin/system/config/list_config.htm')}">系统配置管理</a></li>
        	</#if>
        	<#if settlerAgent.access('SYS_CONFIG')>
        		<li><a href="${bookingServer.get('/admin/system/config/up_logo.htm')}">上传系统LOGO图片</a></li>
        	</#if>
        </ul>
	</#if>
	<#if settlerAgent.access('CONT_MANAGE') || settlerAgent.access('RES_MANAGE')
		|| settlerAgent.access('CHANNEL_MANAGE') || settlerAgent.access('TPL_MANAGE')
		||settlerAgent.access('MEMBER_CONTRIBUTE') || settlerAgent.access('LINK_MANAGE')
		||settlerAgent.access('LINK_CTG_MANAGE') || settlerAgent.access('SITE_MODIFY')
		||settlerAgent.access('LOG_LIST') || settlerAgent.access('SET_USER_SETP')
		>
        <h4>资讯中心</h4>
        <ul>
       		<#if settlerAgent.access('CONT_MANAGE')>
        		<li><a href="${appServer.get('/cont/index.htm')}">文章管理</a></li>
        	</#if>
        	<#if settlerAgent.access('RES_MANAGE')>
        		<li><a href="${appServer.get('/res/index.htm')}">资源管理</a></li>
        	</#if>
        	<#if settlerAgent.access('CHANNEL_MANAGE')>
        		<li><a href="${appServer.get('/channel/index.htm')}">栏目管理</a></li>
        	</#if>
        	<#if settlerAgent.access('TPL_MANAGE')>
        		<li><a href="${appServer.get('/tpl/index.htm')}">模板管理</a></li>
        	</#if>
        	<#if settlerAgent.access('MEMBER_CONTRIBUTE')>
        		<li><a href="${appServer.get('/permuser/index.htm')}">会员投稿权限</a></li>
        	</#if>
        	<#if settlerAgent.access('LINK_MANAGE')>
        		<li><a href="${appServer.get('/link/list.htm')}">友情链接管理</a></li>
        	</#if>
        	<#if settlerAgent.access('LINK_CTG_MANAGE')>
        		<li><a href="${appServer.get('/linkctg/list.htm')}">友情链接类别管理</a></li>
        	</#if>
        	<#if settlerAgent.access('SITE_MODIFY')>
        		<li><a href="${appServer.get('/siteConfig/modify.htm')}">站点设置</a></li>
        	</#if>
        	<#if settlerAgent.access('LOG_LIST')>
        		<li><a href="${appServer.get('/log/list.htm')}">操作日志</a></li>
        	</#if>
			<#if settlerAgent.access('SET_USER_SETP')>
        		<li><a href="${appServer.get('/userstep/list.htm')}">用户权限管理</a></li>
        	</#if>
        </ul>
	</#if>
	</div>
</div>
<script >
$('#modules ul li a').each(function(){
	var href = $(this).attr('href');
	var url = '$!request.getRequestURI()';
	if(href.indexOf(url)!=-1) {
		var parentText = $(this).parent().parent().prev().text();
		var text = $(this).text();
        var str = "<li class='crumbs'><span>当前位置：</span></li>";
        str += "<li><a href='#'>"+parentText+"</a>";
        str += "<li class='c'><a href='"+href+"'>"+text+"</a>";
		$('#current').html(str);
	}
});

$('#modules ul').each(function(){
	if($(this).html().indexOf('<li') == -1 && $(this).html().indexOf('<LI') == -1) {
		$(this).attr('style','display:none');
		$(this).prev().attr('style','display:none')
	}
});
</script>