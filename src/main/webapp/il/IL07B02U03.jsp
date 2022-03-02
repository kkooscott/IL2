<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>居留外僑動態管理系統-共用代碼維護作業</title>
		<script type="text/javascript" src="js/jquery-1.10.0.min.js" />
		<script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/domtab.css" />
		<link rel="stylesheet" type="text/css" href="css/e8.css" />
		<script type="text/javascript">
		
	function toSubmit() {
		
		if (!validateNull($("#txtOPNM").val())) {
			$.alert.open("warning", "中文名稱未輸入");
			return;
		} else if (!validateNull($("#txtOPPRSQ").val())) {
			$.alert.open("warning", "列印順序未輸入");
			return;
		} else if (!validateNull($("#txtOPCS").val())) {
			$.alert.open("warning", "統計歸屬代碼未輸入");
			return;
		} else if (!validateFormat($("#txtOPPRSQ").val(), 0, 1) && !validateFormat($("#txtOPPRSQ").val(), 0, 2) ) {
			$.alert.open("warning", "列印順序為數字");
			return;
		}else if (!validateFormat($("#txtOPCS").val(), 0, 2)) {
			$.alert.open("warning", "統計歸屬代碼為二位數字，例如：01");
			return;
		} else {
			$.ajax({
		        url: 'IL07B00U.action',
		        type: 'post',
		        data: {
		        	txtOPCD : $('#txtOPCD').val(),
		        	txtOPNM : $('#txtOPNM').val(),
		        	txtOPPRSQ : $('#txtOPPRSQ').val(),
		        	txtOPCS : $('#txtOPCS').val()
			        },
			        async:false,
			        success: function(result) { 
				        if(result == 'true') {
				        	$.alert.open({
				        	    content: '更新成功',
				        	    callback: function() {
				        	    	window.location = "IL07B00M.action";
				        	    }
				        	});
				        }else {
				        	$.alert.open({
				        	    content: '更新失敗',
				        	    callback: function() {
				        	    	window.location = "IL07B00M.action";
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
							職業類別代碼修改-資料輸入畫面
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
										職業代碼：
									</td>
									<td width="40%">
										<input id="txtOPCD" name="txtOPCD" type="hidden" value="${ txtOPCD }" />${ txtOPCD }
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										中文名稱：
									</td>
									<td width="40%">
										<input id="txtOPNM" name="txtOPNM" type="text" class="InputText" size="30" maxLength="20" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										列印順序：
									</td>
									<td width="40%">
										<input id="txtOPPRSQ" name="txtOPPRSQ" type="text" class="InputText" size="1" maxLength="2" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										統計歸屬代碼：
									</td>
									<td width="40%">
										<input id="txtOPCS" name="txtOPCS" type="text" class="InputText" size="1" maxLength="2" />
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
							<input type="button" onclick="javascript:history.go(-1)" name="btnClear" value="回上頁" id="btnClear" class="InputButton" />
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>