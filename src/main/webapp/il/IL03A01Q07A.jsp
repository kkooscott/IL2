<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-勤區查察作業</title>
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <link id="total" type="text/css" href="js/pager/jquery.tablesorter.pager.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="js/pager/jquery.tablesorter.pager.js"></script>
	<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />

	<script type="text/javascript">
	$(function() {	

	});//$(function() {
	
	//表單送出事件
	function onSubmit(){
		document.queryForm.submit();
	}
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">外僑居留資料查詢-移民署查察記事資料畫面</div>
		</td>
	</tr>
</table>
<p></p>	
<s:form action="" theme="simple" id='myForm'>
<div id="queryResult" style="width:100%;">
	<TABLE align="center" width="90%">
		<TR>
			<TD align=left>英文姓名：${ilEnm}</TD>
		</TR>
		<TR>
			<TD align=left>外來人口統一證號：${ilArcno}</TD>			
		</TR>
	</TABLE>
    <table cellspacing="0" width="90%" id="ListTable" align="center">
        <tr>
            <td>
                <div>	
					<display:table id="resultList" name="queryList" pagesize="10" requestURI="IL03A01Q07A.action" decorator="tw.gov.npa.il.decorator.IL03A01Q07ADecorator" cellpadding="8" style="width:100%;border-collapse:collapse;">
						<display:column headerClass="First" class="Center" title="序號">${resultList_rowNum}</display:column>
						<display:column class="Center" property="ilPtrldt" title="查察日期" />
						<display:column class="Center" property="ilPtrlst" title="查察結果" />
						<display:column class="Center" property="ilPtrlmrk" title="查察記事" />
						<display:column class="Center" property="ilUnm" title="註記者姓名" />
					</display:table>
				</div>
            </td>
        </tr>
    </table>
		<table align="center" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<div class="FunctionArea">
							
							<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
							<!--<input type="button" onclick="document.location='IL07000M.action'"
								name="btnExit" value="離 開" id="btnExit" class="InputButton" />-->
						</div>
					</td>
				</tr>
			</table>
</div>
</s:form>
<!--<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL03A01Q04.action?ilArcid=${ilArcid}"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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