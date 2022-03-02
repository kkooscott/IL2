<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%
if(session.getAttribute("LOGUID")==null||session.getAttribute("LOGUID").equals("")){
	response.sendRedirect("il/timeoutmsg.html");
}
%>
<head>
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
	<link rel="stylesheet" type="text/css" href="css/domtab.css"/>
	<script type="text/javascript" src="js/domtab.js"></script>   
	<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    
    <script type ="text/javascript" >
	
		$.ajax({
			type: "POST",
			url: "il/util/clearCond.jsp",	
			success: function(text){				
			},
			error:function(){
				$.alert.open("warning", "系統發生錯誤，請洽系統管理員");
			}
		});//$.ajax	
	
   	$(function() {

	});//$(function() {
	
	//表單送出事件
	function onSubmit(){	
	
		if($("#main")[0].selectedIndex==0){
			$.alert.open("warning", "請輸入查詢用途");
			return;
		}

		if($("#main")[0].selectedIndex==6&&$("#other").val()==""){
			$.alert.open("warning", "請輸入查詢用途");
			return;
		}
	
		if((document.myForm.ilMicro.value)==""&&(document.myForm.ilRepmdc.value)==""&&(document.myForm.ilRepmdcNic.value)==""){
			$.alert.open("warning", "至少輸入一項查詢條件");
			document.myForm.ilMicro.focus();
			return;
		}
		/**	
		if(myBestTrim(document.myForm.ilMicro.value)==""){
			window.alert("縮影編號該欄 不可為空 !!!");
			document.myForm.ilMicro.focus();
			return;
		}
		if(myBestTrim(document.myForm.ilRepmdc.value)==""){
			window.alert("重入國許可證號(6位)該欄 不可為空 !!!");
			document.myForm.ilRepmdc.focus();
			return;
		}
		if(myBestTrim(document.myForm.ilRepmdcNic.value)==""){
			window.alert("重入國許可證號(10位)該欄不可為空 !!!");
			document.myForm.ilRepmdcNic.focus();
			return;
		}
		**/
		document.myForm.submit();
	}
	</script>
    
</head>

<body onload='javascript:$("#main")[0].selectedIndex=0'>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">外僑居留資料查詢(二)-條件輸入畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗 -->  
<s:form id="myForm" action="IL03A01Q02A">
<!-- -----------------委託查詢人-------------------------  -->
<s:action name="searcher" executeResult="true" namespace="/"></s:action>
<!-- -------------------------------------------------  -->
<div id="queryDiv">
	<table width="90%" align="center" >
		<tr>
			<td>
				<fieldset>
					<legend>查詢條件</legend>
					<table width="100%" style="align:center;">
							<tr>								
								<td width="10%" class="Label">縮影編號：</td>
								<td width="40%">
									<input id='ilMicro' name='ilMicro' maxlength='10' class="InputText" />
								</td>                      
							</tr>	
							<tr>								
								<td width="10%" class="Label">重入國許可證號(6位)：</td>
								<td width="40%">
									<input id='ilRepmdc' name='ilRepmdc' maxlength='6' class="InputText" />
								</td>                      
							</tr>
							<tr>								
								<td width="10%" class="Label">重入國許可證號(10位)：</td>
								<td width="40%">
									<input id='ilRepmdcNic' name='ilRepmdcNic' maxlength='10' class="InputText" />
								</td>                      
							</tr>								
						</table>
				</fieldset>
			</td>
		</tr>
	</table>
	<p></p>
	<div class="FunctionArea">				 	
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" onclick="onSubmit();" value="確 定" />
        <input type="reset" name="btnClear" id="btnClear" class="InputButton" value="清 除" />                   
    </div>	
</div>
<p></p>	
<input id="QueryFrom" name="QueryFrom" type="hidden" value="IL03A01Q01A" />
</s:form>



<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
		</TD>
		<TD align="center" width="53%">	
		</TD>	
		<TD align=right width="33%">
			<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />
		</TD>
	</TR>
</table> 
-->
</body>
</html>