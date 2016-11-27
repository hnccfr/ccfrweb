<#macro simple value listAction="v_list.do">
<div class="pages-box" >
<div class="pages">
 
 							共 ${value.totalItem} 条&nbsp;
 							每页<input type="text" id="_goPageSize" name="pageSize" value="${value.pageSize}" style="width:30px" maxlength="3" onfocus="this.select();" onblur="$.cookie('_cookie_page_size',this.value,{expires:3650});" onkeypress="if(event.keyCode==13){$.cookie('_cookie_page_size',this.value,{expires:3650});$('#_goPage').click();return false;}"/>条&nbsp;
                            <#if value.isFirstPage() && (value.currentPage lte 1)> <span class="nopint">首页</span> <span class="nopint">上一页</span> 
                            <#else>
                             <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'1');">首 页</a>
                            </#if>
                            <#if !value.isFirstPage() && (value.currentPage gt 1)>
                               <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'${value.previousPage}');">上一页</a>
                            </#if>
                            <#if !value.isLastPage() && (value.currentPage lt value.totalPage)>
                               <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'${value.nextPage}');">下一页</a>
                            </#if> 
                              
                             <#if value.isLastPage() || (value.currentPage gt value.totalPage)> 
                              <span class="nopint">下一页</span> 
                              <span class="nopint">尾页</span> 
                            <#else>
                             <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'${value.totalPage}');">尾 页</a>
                             </#if>
                            	当前 ${value.currentPage}/${value.totalPage} 页 &nbsp;转到第<input  size="2" title="输入页码按回车" maxlength="9" type="text" id="_goPs" value="${value.currentPage!}" style="width:50px" onfocus="this.select();" onkeypress="if(event.keyCode==13){$('#_goPage').click();return false;}"/>页
                            <a href="#" id="_goPage" style="color:#000" onclick="_gotoPage($('#_goPageSize').val(),$('#_goPs').val());"<#if value.totalPage==1> disabled="disabled"</#if>>GO</a>
                           
    </div> 
          </div>
<script type="text/javascript">
function _gotoPage(pageSize,pageNo) {
	if(!(/^(\|-)?\d+$/.test( pageNo )) || pageNo <= 0){
    	alert("必须是正整数！");   
    	return ;  
	}
	if(!(/^(\|-)?\d+$/.test( pageSize )) || pageSize <= 0){
    	alert("必须是正整数！");   
    	return ;  
	}
	try{
		var tableForm = getTableForm();
		$("input[name=currentPage]").val(pageNo);
		tableForm.action="${listAction}";
		tableForm.onsubmit=null;
		tableForm.submit();
	} catch(e) {
		alert('_gotoPage(pageNo)方法出错');
	}
}
</script>
</#macro>


<#macro ajax value contentDiv titleDiv listAction="v_list.do" >
<div class="pages-box" >
<div class="pages">
 
 							共 ${value.totalItem} 条&nbsp;
 							每页<input type="text" id="_goPageSize" name="pageSize" value="${value.pageSize}" style="width:30px" maxlength="3" onfocus="this.select();" onblur="$.cookie('_cookie_page_size',this.value,{expires:3650});" onkeypress="if(event.keyCode==13){$.cookie('_cookie_page_size',this.value,{expires:3650});$('#_goPage').click();return false;}"/>条&nbsp;
                            <#if value.isFirstPage() && (value.currentPage lte 1)> <span class="nopint">首页</span> <span class="nopint">上一页</span> 
                            <#else>
                             <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'1');">首 页</a>
                            </#if>
                            <#if !value.isFirstPage() && (value.currentPage gt 1)>
                               <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'${value.previousPage}');">上一页</a>
                            </#if>
                            <#if !value.isLastPage() && (value.currentPage lt value.totalPage)>
                               <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'${value.nextPage}');">下一页</a>
                            </#if> 
                              
                             <#if value.isLastPage() || (value.currentPage gt value.totalPage)> 
                              <span class="nopint">下一页</span> 
                              <span class="nopint">尾页</span> 
                            <#else>
                             <a href="#" onclick="_gotoPage($('#_goPageSize').val(),'${value.totalPage}');">尾 页</a>
                             </#if>
                            	当前 ${value.currentPage}/${value.totalPage} 页 &nbsp;转到第<input  size="2" title="输入页码按回车" maxlength="9" type="text" id="_goPs" value="${value.currentPage!}" style="width:50px" onfocus="this.select();" onkeypress="if(event.keyCode==13){$('#_goPage').click();return false;}"/>页
                            <a href="#" id="_goPage" style="color:#000" onclick="_gotoPage($('#_goPageSize').val(),$('#_goPs').val());"<#if value.totalPage==1> disabled="disabled"</#if>>GO</a>
                           
    </div> 
          </div>
<script type="text/javascript">
function _gotoPage(pageSize,pageNo) {
	if(!(/^(\|-)?\d+$/.test( pageNo )) || pageNo <= 0){
    	alert("必须是正整数！");   
    	return ;  
	}
	if(!(/^(\|-)?\d+$/.test( pageSize )) || pageSize <= 0){
    	alert("必须是正整数！");   
    	return ;  
	}
	try{
		var tableForm = getTableForm();
		$("input[name=currentPage]").val(pageNo);
		var url = "${appServer.get(listAction)}";
		$.get(url,$("#tableForm").serialize(),function(s) {
			$("#${contentDiv}").empty();
			$("#${contentDiv}").append(s);
		});
		$("#${titleDiv}").dialog("open");
		$("#${contentDiv}").empty();

	} catch(e) {	
		alert('_gotoPage(pageNo)方法出错');
	}
}
</script>
</#macro>