<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/domtab.css" />
	<link rel="stylesheet" type="text/css" href="css/e8.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
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
			<div class="FuncName">
				居留外僑動態管理系統-居留資料查詢作業選單
			</div>
		</td>
	</tr>
</table>
<p></p>
	
	<TABLE align="center" border="0" cellPadding="5" cellSpacing="5" width="80%">
		<TR>
			<h4><IMG src="images/il/editicon.gif" width="12" height="12">
			<A href="IL03A01Q01.action" target="mainFrame">外僑居留資料查詢(一)依外來人口統一證號、護照號碼等條件查詢</A></h4>
		</TR>
		<TR>
			<h4><IMG src="images/il/editicon.gif" width="12" height="12">
			<A href="IL03A01Q01A.action" target="mainFrame">外僑居留資料查詢(二)依縮影編號與重入國許可證號查詢</A></h4>
		</TR>		
		<TR>
			<h4><IMG src="images/il/editicon.gif" width="12" height="12">
			<A href="IL03B01P00.action" target="mainFrame">轄區狀況統計資料</A></h4>
		</TR>
		<TR>
			<h4><IMG src="images/il/editicon.gif" width="12" height="12">
			<A href="IL03D01P01.action" target="mainFrame">線上報表管理作業</A></h4>
		</TR>
	</TABLE>
	
	<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
</body>
</html>