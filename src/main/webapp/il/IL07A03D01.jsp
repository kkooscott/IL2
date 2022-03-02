<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
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
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<script type="text/javascript">
	function toSubmit() {
		if( !validateNull( $("#txtNTCDBegin").val()) ){ $.alert.open("warning", "國籍代碼未輸入"); }
		else if( !validateNull( $("#txtNTCDEnd").val()) ){ $.alert.open("warning", "國籍代碼未輸入"); }
		else if( !validateFormat( $("#txtNTCDBegin").val(), 0, 3) ){ $.alert.open("warning", "國籍代碼為三位數字，例如：001"); }
		else if( !validateFormat( $("#txtNTCDEnd").val(), 0, 3) ){ $.alert.open("warning", "國籍代碼為三位數字，例如：001"); }
		else if( $("#txtNTCDBegin").val() > $("#txtNTCDEnd").val() ){ $.alert.open("warning", "國籍代碼範圍輸入錯誤"); }
		else{
			document.form1.action = "IL07A03D02.action";
			document.form1.submit();
		}		
	}
</script>

	</head>

	<body>
	<%@ include file="util/mask.jsp" %>
		<!--<s:include value="util/actualSearchers.jsp"></s:include>-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90%">
						<div class="FuncName">
							國籍代碼刪除-條件輸入畫面
						</div>
					</td>
				</tr>
			</table>
		<form id="form1" name="form1" method="post" class="Form1">
			

			<table width="90%" align="center">
				<tr>
					<td>
						<fieldset>
							<legend>
								搜尋資料
							</legend>
							<table width="100%" style="align:center;">
								<tr>
									<td width="50%" class="Label">
										國 籍 代 碼 ：
									</td>
									<td width="50%">
										<input id="txtNTCDBegin" name="txtNTCDBegin" type="text"
											class="InputText" size="1" maxLength="3" /> ~ 
										<input id="txtNTCDEnd" name="txtNTCDEnd" type="text"
											class="InputText" size="1" maxLength="3" />
									</td>
								</tr>
							</table>
						</fieldset>
					</td>
				</tr>
			</table>

			<table align="center" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<div class="FunctionArea">
							<input type="button" onclick="toSubmit()" name="btnAddNew" value="確 定" id="btnAddNew" class="InputButton" />
							<input type="button" onclick="document.location='IL07A03D01.action'" name="btnClear" value="清 除" id="btnClear" class="InputButton" />
							<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
							<!--<input type="button" onclick="document.location='IL07A00M.action'" name="btnExit" value="離 開" id="btnExit" class="InputButton" />-->
						</div>
					</td>
				</tr>
			</table>
		</form>
		<!--
		<hr/>
		<table border=0 cellPadding=0 cellSpacing=0 align=center>
			<TR>
				<TD align=left width="33%">
					<A href="IL07000M.action"><img border='0' height="36"
							src="./images/il/h-12.gif" width="36" alt='首頁' />
					</A>
					<A href="IL07A00M.action"><img border='0' height='36'
							src="images/il/h-3.gif" width='36' Alt="上一層" />
					</A>
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