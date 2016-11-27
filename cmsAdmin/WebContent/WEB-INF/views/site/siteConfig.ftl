	<#import "/layout/layout.ftl" as noeclp>
	<@noeclp.layout title="站点设置" path="" curPath="站点设置">
<#include "/include/head.ftl"/>
<script>
function doSubmit(){
	jQuery("#updateForm").submit();
}
</script>
<div class="main">
  <div class="formBox">
    <h3><i></i><span>本站设置</span></h3>
    <form action="${appServer.get('/siteConfig/update.htm')}" id="updateForm" method="POST">
    	<input type="hidden" name="id" value="<#if cms2Site.id??>${cms2Site.id}</#if>"/>
	    <div class="content">
	      <table class="c2">
	        <tr>
	          <th>站点名称：</th>
	          <td>
	          	<input type="text" class="inp" maxlength="30" name="siteName" value="<#if cms2Site.siteName??>${cms2Site.siteName}</#if>"/>
	          	<span class="red" id="siteNameError"><#if siteNameError??>${siteNameError}<#else>*</#if></span>
	          </td>
	        </tr>
	        <tr>
	          <th>站点简称：</th>
	          <td>
	          	<input type="text" class="inp" maxlength="20" name="shortName" value="<#if cms2Site.shortName??>${cms2Site.shortName}</#if>"/>
		          <span class="red" id="shortNameError"><#if shortNameError??>${shortNameError}<#else>*</#if></span>
	          </td>
	        </tr>
	        <tr>
	          <th>域名：</th>
	          <td>
	          	<input type="text" class="inp" maxlength="30" name="domain" value="<#if cms2Site.domain??>${cms2Site.domain}</#if>"/>
	            <span class="red" id="domainError"><#if domainError??>${domainError}<#else>*</#if></span>
	          </td>
	        </tr>
	        <tr>
	          <th>路径：</th>
	          <td>
		          <#if cms2Site.sitePath??>
		          	<input type="hidden" name="sitePath" value="${cms2Site.sitePath}"/>
		          	${cms2Site.sitePath}
		          </#if>
	          </td>
	        </tr>
	        
	         <tr style="display:none;">
	          <th>静态网页相对路径 ：</th>
	          <td>
		          <#if cms2Site.staticDir??>
		          	<input type="hidden" name="staticDir" value="<#if cms2Site.staticDir??>${cms2Site.staticDir}</#if>"/><!-- 静态网页相对路径 -->
		          	${cms2Site.staticDir}
		          </#if>
	          </td>
	        </tr>
	        <tr>
	          <th>静态地址后缀：</th>
	          <td>
		          <#if cms2Site.staticSuffix??>
		          	<input type="hidden" name="staticSuffix" value="<#if cms2Site.staticSuffix??>${cms2Site.staticSuffix}</#if>"/><!-- 静态页后缀 -->
		          	${cms2Site.staticSuffix}
		          </#if>
	          </td>
	        </tr>
	       
	        <tr >
		        <th>静态化设置：</th>
		        <td>
		        <select name="staticRange" class="select" style="width:105px;">
		          	<#if siteStaticRangeMap??>
		          		<#list siteStaticRangeMap?keys as key>
							<option value="${key}" <#if cms2Site.staticRange?? && "${cms2Site.staticRange}" == "${key}">selected</#if> >${siteStaticRangeMap[key]}</option>
						</#list>
					</#if>
	          	</select>
		       </td>
	        </tr>
	        <tr >
		        <th>开启静态首页：</th>
		        <td>
		          	<#if SiteIsStaticIndexMap??>
		          		<#list SiteIsStaticIndexMap?keys as key>
		          		<input name="isStaticIndex" type="radio" class="radio" value="${key}" <#if cms2Site.isStaticIndex?? && "${cms2Site.isStaticIndex}" == "${key}">checked</#if> />${SiteIsStaticIndexMap[key]}
		    				&nbsp;&nbsp;
						
						</#list>
					</#if>
		       </td>
	        </tr>
	        <!--<tr >
		        <th>使用相对路径：</th>
		        <td>
		          	<#if SiteIsRelativePathMap??>
		          		<#list SiteIsRelativePathMap?keys as key>
		          		<input name="isRelativePath" type="radio" class="radio" value="${key}" <#if cms2Site.isRelativePath?? && "${cms2Site.isRelativePath}" == "${key}">checked</#if> />${SiteIsRelativePathMap[key]}
		    				&nbsp;&nbsp;
						
						</#list>
					</#if>
		       </td>
		       
	        </tr>-->
	        <!--<tr >
		        <th>静态文件存放在根目录下：</th>
		        <td>
		          	<#if SiteIsIndexToRootMap??>
		          		<#list SiteIsIndexToRootMap?keys as key>
		          		<input name="isIndexToRoot" type="radio" class="radio" value="${key}" <#if cms2Site.isIndexToRoot?? && "${cms2Site.isIndexToRoot}" == "${key}">checked</#if> />${SiteIsIndexToRootMap[key]}
		    				&nbsp;&nbsp;
						
						</#list>
					</#if>
		       </td>
		       
	        </tr>-->
	        <tr >
		        <th>栏目列表页静态页数：</th>
		        <td><input type="text" class="inp" name="staticPage" value="<#if cms2Site.staticPage??>${cms2Site.staticPage}</#if>"/></td>
	        </tr>
	        <tr>
	          <th>栏目文章列表每页记录数：</th>
	          <td>
	          	<input type="text" class="inp" maxlength="2" style="width:50px" name="pageSize" value="<#if cms2Site.pageSize??>${cms2Site.pageSize}</#if>" />
	            <span class="red" id="pageSizeError"><#if pageSizeError??>${pageSizeError}<#else>*</#if></span>
	          </td>
	        </tr> 
	        <tr>
	          <th>开启回收站：</th>
	          <td>
	          	<input type="radio" value="1" <#if cms2Site.isRecycleOn?? && cms2Site.isRecycleOn == 1>checked="checked" </#if> name="isRecycleOn">是
	          	<input type="radio" value="2" <#if cms2Site.isRecycleOn?? && cms2Site.isRecycleOn == 2>checked="checked" </#if> name="isRecycleOn">否
	            <span class="red">*</span>
	          </td>
	        </tr>
	        
	        <!-- 隐藏值end -->
	        
	        <!-- 默认值start -->
	        
	        <input type="hidden" name="protocol" value="<#if cms2Site.protocol??>${cms2Site.protocol}</#if>"/><!-- 访问协议 -->
	        <input type="hidden" name="dynamicSuffix" value="<#if cms2Site.dynamicSuffix??>${cms2Site.dynamicSuffix}</#if>"/><!-- 动态页后缀 -->
	        <input type="hidden" name="localeAdmin" value="<#if cms2Site.localeAdmin??>${cms2Site.localeAdmin}</#if>"/><!-- 后台本地化 -->
	        <input type="hidden" name="localeFront" value="<#if cms2Site.localeFront??>${cms2Site.localeFront}</#if>"/><!-- 前台本地化 -->
	        <input type="hidden" name="isIndexToRoot" value="<#if cms2Site.isIndexToRoot??>${cms2Site.isIndexToRoot}</#if>"/><!-- 静态文件存放在根目录下 -->
	        <input type="hidden" name="isRelativePath" value="<#if cms2Site.isRelativePath??>${cms2Site.isRelativePath}</#if>"/><!-- 使用相对路径 -->
	       <input type="hidden" name="finalStep" value="<#if cms2Site.finalStep??>${cms2Site.finalStep}</#if>"/><!-- 使用相对路径 -->
	       <input type="hidden" name="afterCheck" value="<#if cms2Site.afterCheck??>${cms2Site.afterCheck}</#if>"/><!-- 使用相对路径 --> 
	        <!-- 默认值end -->
	      </table>
	    </div>
    </form>
    <div class="form-but">
      <!-- 表单按钮区 -->
      <#if settlerAgent.access("PermissionEnum.SITE_MODIFY")>
      	<button type="button" class="button-s4" onclick="doSubmit()">修改</button>
      </#if>
    </div>
    <!-- 表单按钮区 END -->
  </div>
  <!-- 表单模块 END -->
</div>
<#include "/include/foot.ftl"/>
</@noeclp.layout>