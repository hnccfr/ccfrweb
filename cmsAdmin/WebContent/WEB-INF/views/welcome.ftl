<#include "/include/head.ftl"/>

    <div class="welcome">
    	<ul>
    		<li><h5>系统属性-<@s.m "cms.function.home" /></h5></li>
    		<li>程序版本：${version!}</li>
            <li><h5>JVM内存使用情况</h5></li>
            <li>最大内存：${(maxMemory/1024/1024)?string("0.##")} MB</li>
            <li>已用内存：${(usedMemory/1024/1024)?string("0.##")} MB</li>
            <li>剩余内存：${(useableMemory/1024/1024)?string("0.##")} MB</li>
            <#if settlerAgent.access("PermissionEnum.TEST_ENUM")>
            <li>这里访问开发的例子：<a href="${appServer.get('log/addLog.htm')}">表单开发</a></li>
            </#if>
        </ul>
    </div>
</div>
<#include "/include/foot.ftl"/>