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
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    
	<script type="text/javascript">
	$(function() {	
		/**報表產生**/	
		$("#btnQuery").click(function(){
			var filename = $('input[name=RPT]:checked').val();
			if(filename=="" || filename==null){
			
			}else{
				//window.open("./report/IL03/"+$('input[name=RPT]:checked').val());				
				if($('input[name=RPT]:checked').val().indexOf("01")==0){
					window.open("./report/"+$('input[name=RPT]:checked').val());				
				}else{
					window.open("./report/IL03/"+$('input[name=RPT]:checked').val());				
				}
			}			
		});
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	
	//開新視窗顯示
	function MM_openBrWindow(theURL,winName,width,height,ReportKind) { //v2.0
		/**
		if($('input[name=RPT]:checked').val()==1){//UI測試時使用
			alert("未執行");
			return;
		}else if($('input[name=RPT]:checked').val()==2){
			alert("執行中");
			return;
		}
		**/
		var features= "status=no,location=no,resizable=yes,scrollbars=yes,top=0,left=200,width="+width+",height="+height;
		theURL = theURL+"?RPT="+$('input[name=RPT]:checked').val();
		window.open(theURL,winName,features);
	}
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">轄區狀況統計資料-線上報表管理作業</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢結果視窗 -->
<s:form action="" theme="simple" id='myForm'>
<div id="queryResult" style="width:100%;">
<table cellspacing="0" width="90%" id="ListTable" align="center">
    <tr>
        <td>		
		<display:table id="resultList" name="queryList" pagesize="10" requestURI="IL03D01P01.action" decorator="tw.gov.npa.il.decorator.IL04D01P01Decorator" cellpadding="8" style="width:100%;border-collapse:collapse;">
			<display:column headerClass="First" class="Center sid id" property="id" title="" />
			<display:column class="Center" property="ilRptnm" title="報表名稱" />
			<display:column class="Center" property="ilSnddt" title="要求日期時間" />
			<display:column class="Center" property="ilStatus" title="執行狀態" />
		</display:table>
        </td>
    </tr>
</table>				
</div><!--<div id="queryResult" style="width:100%;">-->
	<center>
    <div class="FunctionArea">				 	
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" value="確定" />   	
    </div>
    </center>
	<p></p>	
</s:form>
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL03000M.action"><img border='0' height="36" src="./images/il/h-12.gif" width="36" alt='首頁'/></A>
			<A href="IL03000M.action"><img border='0' height='36' src="images/il/h-3.gif" width='36' Alt="上一層"/></A>				
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