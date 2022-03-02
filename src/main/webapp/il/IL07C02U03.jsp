<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>居留外僑動態管理系統-共用代碼維護作業</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/domtab.css" />
		<link rel="stylesheet" type="text/css" href="css/e8.css" />
		<script type="text/javascript" src="js/jquery-1.10.0.min.js" />
		<script language="javascript" type="text/javascript"
			src="js/DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<script type="text/javascript">
	function toSubmit() {

		if (!validateNull($("#txtUVCNM").val())) {
			$.alert.open("warning", "中文名稱未輸入");
		} else if (!validateNull($("#txtUVCPNM").val())) {
			$.alert.open("warning", "列印名稱未輸入");
		} else {
			$.ajax({
		        url: 'IL07C00U.action',
		        type: 'post',
		        data: {
		        	txtUVCD : $('#txtUVCD').val(),
		        	txtUVCNM : $('#txtUVCNM').val(),
		        	txtUVCPNM : $('#txtUVCPNM').val(),
		        	txtUVPZONE : $('#txtUVPZONE').val(),
		        	txtUVADDR : $('#txtUVADDR').val(),
		        	txtUVTEL : $('#txtUVTEL').val()
			        },
			        async:false,
			        success: function(result) { 
				        if(result == 'true') {
				        	$.alert.open({
				        	    content: '更新成功',
				        	    callback: function() {
				        	    	window.location = "IL07C00M.action";
				        	    }
				        	});
				        }else {
				        	$.alert.open({
				        	    content: '更新失敗',
				        	    callback: function() {
				        	    	window.location = "IL07C00M.action";
				        	    }
				        	});
				        }
			        }
		    });
		}

	}
</script>

	</head>

	<body>
	<%@ include file="util/mask.jsp" %>

		<form id="form1" name="form1" method="post" class="Form1">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="90%">
						<div class="FuncName">
							大專院校代碼修改-資料輸入畫面
						</div>
					</td>
				</tr>
			</table>

			<table width="90%" align="center">
				<tr>
					<td>
						<fieldset>
							<legend>
								更新資料
							</legend>
							<table width="100%">
								<tr>
									<td width="10%" class="Label">
										院校代碼：
									</td>
									<td width="40%">
										<input id="txtUVCD" name="txtUVCD" type="hidden"
											value="${ txtUVCD }" />${ txtUVCD }
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										中文名稱：
									</td>
									<td width="40%">
										<input id="txtUVCNM" name="txtUVCNM" type="text"
											class="InputText" size="30" maxLength="20" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										列印名稱：
									</td>
									<td width="40%">
										<input id="txtUVCPNM" name="txtUVCPNM" type="text"
											class="InputText" size="30" maxLength="20" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										郵遞區號：
									</td>
									<td width="40%">
										<input id="txtUVPZONE" name="txtUVPZONE" type="text"
											class="InputText" size="1" maxLength="3" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										院校地址：
									</td>
									<td width="40%">
										<input id="txtUVADDR" name="txtUVADDR" type="text"
											class="InputText" size="70" maxLength="100" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										院校電話：
									</td>
									<td width="40%">
										<input id="txtUVTEL" name="txtUVTEL" type="text"
											class="InputText" size="20" maxLength="15" />
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
							<input type="button" onclick="toSubmit()" name="btnAddNew"
								value="確 定" id="btnAddNew" class="InputButton" />
							<input type="button"
								onclick="document.location='IL07000M.action'" name="btnExit"
								value="離 開" id="btnExit" class="InputButton" />
						</div>
					</td>
				</tr>
			</table>
		</form>
		<!--
		<hr />
		<table border=0 cellPadding=0 cellSpacing=0 align=center>
			<TR>
				<TD align=left width="33%">
					<A href="IL07000M.action"><img border='0' height="36"
							src="./images/il/h-12.gif" width="36" alt='首頁' /> </A>
					<A href="IL07C02U01.action"><img border='0' height='36'
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