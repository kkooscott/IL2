<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
	<head>
		<title>居留外僑動態管理系統-共用代碼維護作業</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/domtab.css" />
		<link rel="stylesheet" type="text/css" href="css/e8.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />

		<script type="text/javascript">
	
</script>
<style>
#resultGrid td{
	padding:5px;
	position: relative;
  	z-index: 3;
}

#resultGrid tr:hover td{
	background-color:#cccccc;
	cursor:pointer;
	text-decoration:none;
}

#resultGrid a{
	text-decoration:none;
}


</style>
	</head>

	<body>
	<%@ include file="util/mask.jsp" %>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90%">
					<div class="FuncName">
						國籍代碼維護
					</div>
				</td>
			</tr>
		</table>
	<form id="form1" runat="server" class="Form1">
		
		
		
<!-- 查詢條件視窗-->
<table cellspacing="0" width="90%" id="ListTable"  align="center">
    <tr><td>
	<table class="ListTable" cellspacing='0' align="left" id="resultGrid" style="width:100%;">
	<tr><th colspan='5' class='First'><font size='3'><b>代碼操作</b></font></th></tr>
	
		
	<tr onclick='javascript:location.href="IL07A01A01.action"'><a ><td>國籍代碼新增</td></a></tr>
	<tr onclick='javascript:location.href="IL07A02U01.action"'><a><td>國籍代碼修改</td></a></tr>
	<tr onclick='javascript:location.href="IL07A03D01.action"'><a><td>國籍代碼刪除</td></a></tr>
	<tr onclick='javascript:location.href="IL07A04Q01.action"'><a><td>國籍代碼查詢列印</td></a></tr>
	
	<tr></tr>
    </table>
	
</td></tr>

</table>
		
		
</form>

		
		
		
<script type='text/javascript'>
$("#resultGrid tr:odd").addClass('even');
$("#resultGrid tr:even").addClass('odd');

</script>
		<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
	</body>
</html>