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

	</head>

	<body>
	<%@ include file="util/mask.jsp" %>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90%">
					<div class="FuncName">
						共用代碼維護作業
					</div>
				</td>
			</tr>
		</table>


		<TABLE align="center" border="0" cellPadding="5" cellSpacing="5"
			width="80%">
			<TR>
				<TD noWrap>
					<IMG src="images/il/editicon.gif" width="12" height="12">
					<A href="IL07A00M.action" target="mainFrame">國籍代碼維護</A>
				</TD>
				<TD noWrap>
					<IMG src="images/il/editicon.gif" width="12" height="12">
					<A href="IL07B00M.action" target="mainFrame">職業類別代碼維護</A>
				</TD>
			</TR>
			<TR>
				<TD noWrap>
					<IMG src="images/il/editicon.gif" width="12" height="12">
					<A href="IL07C00M.action" target="mainFrame">大專院校代碼維護</A>
				</TD>
				<TD noWrap>
					<IMG src="images/il/editicon.gif" width="12" height="12">
					<A href="IL07D00M.action" target="mainFrame">特殊身份代碼維護</A>
				</TD>
			</TR>
		</TABLE>

		<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
	</body>
</html>