<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
	<%@page 
language="java"
import="java.util.*,java.lang.*,java.net.*,java.text.*,java.net.*,java.sql.*,java.io.*,jxl.*,jxl.write.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
	<head>
		<title>居留外僑動態管理系統-共用代碼維護作業</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/domtab.css" />
		<link rel="stylesheet" type="text/css" href="css/e8.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<script type="text/javascript" src="js/domtab.js"></script>
		<link id="total" type="text/css"
			href="js/pager/jquery.tablesorter.pager.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
		<script type="text/javascript"
			src="js/pager/jquery.tablesorter.pager.js"></script>
		<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
		<script type="text/javascript">
	function onSubmit() {

		$('#pageType').val('print');
		$('#form1').attr("action", "IL07C04Q02_2.action");
		$('#form1').submit();
	}
</script>
<style type="text/css">
	#resultList td.sid {
		text-align: center;
		vertical-align: middle;
	}
	
	em {
		color: red;
	}
</style>
	</head>
<%
	String pageType=(String)request.getParameter("pageType");
	String startId=(String)request.getParameter("txtUVCDBegin");
	String endId=(String)request.getParameter("txtUVCDEnd");
%>
	
	<body>
	<%@ include file="util/mask.jsp" %>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90%">
					<div class="FuncName">
						大專院校代碼查詢-資料顯示畫面
					</div>
				</td>
			</tr>
		</table>

		<form id="form1" name="form1" method="post" class='Form1'>

			<input id="txtInput" name="txtInput" type="hidden"
				value="${ txtInput }" />
			<display:table id="resultList" name="queryList" pagesize="5" cellpadding="8" 
				requestURI="IL07C04Q02.action"
				decorator="tw.gov.npa.il.decorator.IL07CDecorator"
				style="width:100%;border-collapse:collapse;">
				
				<display:column class="Center" title="筆次">${resultList_rowNum}</display:column>
				<display:column class="sid" property="UVCD" title="院校代碼" />
				<display:column class="Center" property="UVCNM" title="中文名稱" />
				<display:column class="Center" property="UVPZONE" title="郵遞區號" />
				<display:column class="Center" property="UVTEL" title="院校電話" />
			</display:table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align='cenetr'>
			<tr>
				<td style="text-align: center;">
					<div class="FunctionArea">
						<input type="button" class='InputButton' value="列　印" onclick="onSubmit();" />
						<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
					</div>
				</td>
			</tr>
		</table>
		
		<input id="txtUVCDBegin" name="txtUVCDBegin" type="hidden" value='<%=request.getParameter("txtUVCDBegin")%>'/>
		<input id="txtUVCDEnd" name="txtUVCDEnd" type="hidden" value='<%=request.getParameter("txtUVCDEnd")%>'/>
		<input id="pageType" name="pageType" type="hidden" value=''/>
		
		</form>

		
<!--
		<hr />
		<table border=0 cellPadding=0 cellSpacing=0 align=center>
			<TR>
				<TD align=left width="33%">
					<A href="IL07000M.action"><img border='0' height="36"
							src="./images/il/h-12.gif" width="36" alt='首頁' /> </A>
					<A href="IL07C04Q01.action"><img border='0' height='36'
							src="images/il/h-3.gif" width='36' Alt="上一層" /> </A>
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