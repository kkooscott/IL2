<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>功能清單維護</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"/>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript">
	$(function() {
	
	});//$(function() {
	
	/**更新作業**/
	function doUpdate(url,id){
	 	var ilFuncDisable = $('input[name=btnRadio'+id+']:checked').val();//取得選擇值	 	
		//alert("url="+url+", id="+id+", ilFuncDisable="+ilFuncDisable);//test 
		/**Ajax*/
		$.ajax({
			type: "POST",
			url: url,
			data: {ilStepid: id, ilFuncDisable: ilFuncDisable},
			success: function(result){
				if(result=="true"){
					alert("修改成功");
				}else{
					alert("系統發生錯誤，請洽系統管理員\n錯誤訊息為：資料庫存取異常");
				}
			}//success
		});//$.ajax
    }
    
    /**新增作業**/
	function doNew(url){
        document.queryForm.action=url;
        document.queryForm.submit();
	}
    </script>
</head>

<body>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">功能清單維護</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗 -->  
<p></p>
<!-- 查詢結果視窗 -->
<!-- 查詢結果視窗 -->
<div id="queryResult" style="width:100%;">
<div class='Form1'>
<table align="center" cellspacing="0" cellpadding="0">
    <tr>
        <td>
            <div class="FunctionArea">
                <input type="button" name="btnInsert" id="btnInsert" class="InputButton" onclick="doNew('IL09B01New.action');" value="新 增" />
            </div>
        </td>
    </tr>
</table>

<table cellspacing="0" width="90%" id="ListTable"  align="center">
	<tr>
		<td>
        <div>
			<table class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
				<thead>
					<tr>
						<th class="First" scope="col">代號</th>
                        <th scope="col">名稱</th>
                        <th scope="col">網址</th>
                        <th scope="col">群組</th>
                        <th scope="col">狀態</th>
                        <th scope="col">更新</th>	                       					
					</tr>
				</thead>
				<tbody>
					<s:iterator value="iltbSystemFlowStepConfigList.{?#this.ilFunctag==1}" var="iltbFuncSet" status="count">		                
		                <tr id="tr${count.count}">		                
							<td class="Center">${iltbFuncSet.ilFunc}</td>
							<td class="Center">${iltbFuncSet.ilStepname}</td>
							<td class="Center">${iltbFuncSet.ilStepurl}</td>						
							<s:iterator value="iltbSystemFlowStepConfigList.{?#this.ilFunctag==0}" var="iltbFuncGroupSet" status="gCount">													
								<s:if test="%{#iltbFuncGroupSet.ilIndexid==#iltbFuncSet.ilIndexid.substring(0,1)}">
									<td class="Center">${iltbFuncGroupSet.ilStepname}</td>
								</s:if>																						
							</s:iterator>							
							<td class="Center">
								<s:if test="%{#iltbFuncSet.ilFuncDisable==1}">
									<input type="radio" name="btnRadio${iltbFuncSet.ilStepid}" id="btnRadioOpen${iltbFuncSet.ilStepid}" value="1" checked="checked" />啟用
									<input type="radio" name="btnRadio${iltbFuncSet.ilStepid}" id="btnRadioClose${iltbFuncSet.ilStepid}" value="0" />停用
								</s:if>
								<s:elseif test="%{#iltbFuncSet.ilFuncDisable==0}">
									<input type="radio" name="btnRadio${iltbFuncSet.ilStepid}" id="btnRadioOpen${iltbFuncSet.ilStepid}" value="1"  />啟用
									<input type="radio" name="btnRadio${iltbFuncSet.ilStepid}" id="btnRadioClose${iltbFuncSet.ilStepid}" value="0" checked="checked" />停用
								</s:elseif>		
							</td>
							<td class="Center"><input type="button" name="btnUpdate" id="btnUpdate" class="InputButton" onclick="doUpdate('IL09B01Update.action','${iltbFuncSet.ilStepid}');" value="更新"/></td>
		                </tr>
		                <!-- 表格隔行換色處理 -->
		                <s:if test="%{#count.count%2!=1}">
		                	<script type="text/javascript">$("#tr${count.count}").addClass("odd");</script>
		                </s:if>
		                <s:else>
		                	<script>$("#tr${count.count}").addClass("even");</script>
		                </s:else>
		            </s:iterator >					
				</tbody>				
			</table>
		</div>
		</td>
	</tr>
</table>
</div>
</div><!--<div id="queryResult" style="width:100%;">-->

<s:form id="queryForm" action="">
<!-- 看要塞啥Hidden值吧~ 
	<input type="hidden" id="ilFuncNo" name="ilFuncNo" value="" />
	<input type="hidden" id="ilFuncDisable" name="ilFuncDisable" value="" />
-->
</s:form>
</body>
</html>
