<!-- 页头 -->
<div class="body-top">
	<a href="${bookingServer.get('/admin/index.htm')}"><img src="${appServer.get('/images/nbhy/logo_space.png')}" /></a>

    <ul class="tools">
    	<li class="name"><span>用户名:</span><a href="#">${settlerAgent.userAccount}</a></li>
        <!--<li class="help"><a href="#">帮助</a></li>-->
        <li class="exit"><a href="${bookingServer.get('/admin/exit.htm')}">注销</a></li>
    </ul>

    <div class="nav-div">
    	<div class="l"></div>
        <div class="r"></div>
        <ul id="current">
        	<li class="crumbs"><span>当前位置：</span></li>
        	<#--<#if path!=""><li><a href="#">${path}</a></li></#if>-->
        	<li><a href="#">资讯中心</a></li>
        	<#if curPath!="">
        	<li class="c"><a href="#">${curPath}</a></li>
        	</#if>
        </ul>
    </div>

</div>
<!-- 页头 END -->