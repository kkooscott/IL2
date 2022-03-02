<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="jQuery/development-bundle/themes/custom-theme_2012/jquery.ui.all.css">
    <script type="text/javascript" src="js/domtab.js"></script>  
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
	<script type="text/javascript">
	$(function() {	
		
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	
	//開新視窗顯示
	function MM_openBrWindow(theURL,winName,width,height,ReportKind) { //v2.0
		var features= "status=no,location=no,resizable=yes,scrollbars=yes,top=0,left=200,width="+width+",height="+height;
		theURL = theURL+"?ReportKind="+$('input[name=ReportKind]:checked').val();
		window.open(theURL,winName,features);
	}
	
	/**測試Radio選取值寫法
	function testing(){
		alert($('input[name=ReportKind]:checked').val());//test
		//alert($("#ReportKind").val());//test
	}
	**/
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr><td width="90%"><div class="FuncName">自由檢索報表-報表選取畫面</div></td></tr>
</table>
<p></p>
	 
	
<s:form action="IL04B01Q03" cssClass='Form1'>

<div id="queryResult" style="width:100%;">		 
<table cellspacing="0" width="90%" id="ListTable"  align="center">
<tr><td><div>
	<TABLE class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
	    <thead>
		    <TR>
		        <TH class="First" scope="col" width="20%">序號</TH>
			    <TH scope="col" width="80%">報表名稱</TH>
		    </TR>
	    </thead>
	    <tbody>
		    <TR class="odd">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="1" checked>1</td>
		        <TD>按國籍及職業分</TD>
		    </TR>
		    <TR class="even">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="2" >2</td>
		        <TD>按國籍及區域分</TD>
		    </TR>
		    <TR class="odd">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="3" >3</td>
		        <TD>按職業及區域分</TD>
		    </TR>
		    <TR class="odd">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="4" >4</td>
		        <TD>按居留目的及職業分</TD>
		    </TR>
		    <TR class="even">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="5" >5</td>
		        <TD>按居留目的及區域分</TD>
		    </TR>
		    <TR class="odd">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="6" >6</td>
		        <TD>按國籍及居留目的分</TD>
		    </TR>
		    <TR class="even">
		    	<td style='text-align:center'><input type="radio" id="ReportKind" name="ReportKind" value="7" >7</td>
		        <TD>臺閩地區外僑持續居留年限統計報表</TD>
			</TR>
		</tbody>
	</TABLE>
</div></td></tr></table>
</div>	
	
	<TABLE id=Main5 border=0 cellPadding=0 cellSpacing=0 align=center width=758>
		<TR>
			<TD align=left width="33%">
				<!--<A href="IL04000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>-->
				<!--<A href="IL04B01Q01.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>-->
			</TD>
			<TD align="center" width="33%">
				<!--<input id="test" type="button" value="測試" title="測試" onclick="testing()" />-->
				<input id="FormSubmit" type="submit" value="確定" title="確定" class='InputButton'/>				
				<!--<input id="FormClear" type="button" value="離開" title="離開" class='InputClass' onclick="location.href='IL04B01Q01'" />-->
				<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
			</TD>
			<!--<TD align=right width="33%"><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>-->
		</TR>
	</TABLE>
	
	</s:form>	
	<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
</body>
</html>