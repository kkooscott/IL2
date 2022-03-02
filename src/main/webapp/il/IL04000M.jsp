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
    <script type="text/javascript" src="js/domtab.js"></script>   
    
    <script type ="text/javascript" >
   	
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">居留外僑動態管理系統-統計報表作業選單</div>
		</td>
	</tr>
</table>
<p></p>
	
	<TABLE align="center" border="0" cellPadding="5" cellSpacing="5" width="80%">
		<TR>
			<TD noWrap>
				<IMG src="images/il/editicon.gif" width="12" height="12">
				<A href="IL04A01Q01.action" target="mainFrame">月統計報表下載</A>
			</TD>
			<TD noWrap>
				<IMG src="images/il/editicon.gif" width="12" height="12">
				<A href="IL04B01Q01.action" target="mainFrame">自由檢索報表</A>
			</TD>
		</TR>
		<TR>
			<TD noWrap>
				<IMG src="images/il/editicon.gif" width="12" height="12">
				<A href="IL04D01P01.action" target="mainFrame">線上報表管理作業</A>
			</TD>
		</TR>
	</TABLE>
	
	<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
</body>
</html>