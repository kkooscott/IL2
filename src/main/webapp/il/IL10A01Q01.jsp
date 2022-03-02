<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公告顯示</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
</head>

<body>
<%@ include file="util/mask.jsp" %>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color:#ACB8C6;">
    <tr>
        <td width="120" align="center"><img src="images/arrow.jpg" border="0" align="absmiddle" /></td>
        <td width="98%" class="pageTitle">公告顯示</td>
    </tr>
</table>
<p></p>
<!-- 查詢條件視窗-->

<table class="queryOuterTable">
    <tr><td width="80%">
        <table><tr><th>一般性公告</th></tr></table>
    </td></tr>
    <tr><td>
        <table class="queryTable">
            <tr>
                <td width="20%"></td>
                <td>1.本日無一般性公告</td>
            </tr>
        </table>
    </td></tr>
</table>
<p></p>

<table class="queryOuterTable">
    <tr><td width="80%">
        <table><tr><th>系統維護公告</th></tr></table>
    </td></tr>
    <tr><td>
        <table class="queryTable">
            <tr>
                <td width="20%"></td>
                <td>1.居留系統將於103/07/01 10~12時更新</td>
            </tr>
        </table>
    </td></tr>
</table>

</body>
</html>
