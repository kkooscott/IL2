<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
	<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
	<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
	
	<script type="text/javascript" src="js/jquery-1.10.0.min.js" />
	<script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/domtab.js"></script>
	<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/alert.min.js"></script>
	<script type="text/javascript">

	function toSubmit() {
		if (!validateNull($("#txtNTCD").val())) {
			$.alert.open("warning", "國籍代碼未輸入");
			return;
		} else if (!validateNull($("#txtNTNM").val())) {
			$.alert.open("warning", "中文名稱未輸入");
			return;
		} else if (!validateFormat($("#txtNTCD").val(), 0, 3)) {
			$.alert.open("warning", "國籍代碼為三位數字，例如：001");
			return;
		} else {
			if( checkID() == "0" ) {
				$.ajax({
			        url: 'IL07A00A.action',
			        type: 'post',
			        data: {
			        	txtNTCD : $('#txtNTCD').val(),
			        	txtNTNM : $('#txtNTNM').val(),
			        	chkNTLBR : $('#chkNTLBR').val()
				        },
			        async:false,
			        success: function(result) { 
				        if(result == 'true') {
				        	$.alert.open({
				        	    content: '新增成功',
				        	    callback: function() {
				        	    	window.location = "IL07D00M.action";
				        	    }
				        	});
				        }else {
				        	$.alert.open({
				        	    content: '新增失敗',
				        	    callback: function() {
				        	    	window.location = "IL07D00M.action";
				        	    }
				        	});
				        }
			        }
			    });
			}else {
				$.alert.open("Warning","國籍代碼已存在");
				return;
			}
		}
	}
	function checkID() {
	    var url = "IL07A01A02.action";
	    var id = $("#txtNTCD").val();
	    var output;
	    $.ajax({
	        url: url,
	        type: 'post',
	        data: {'txtNTCD': id},
	        async:false,
	        success: function(result){ output = result; }
	    });
	    return output;
	}
	</script>
</head>
<body>
<%@ include file="util/mask.jsp" %>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="90%">
				<div class="FuncName">
					國籍代碼維護-新增資料輸入畫面
				</div>
			</td>
		</tr>
	</table>
	<form id="form1" name="form1" method="post" class="Form1">
		<table width="90%" align="center">
			<tr>
				<td>
					<fieldset>
						<legend>新增資料</legend>
						<table width="100%">
							<tr>
								<td width="10%" class="Label">國籍代碼：</td>
								<td width="40%"><input id="txtNTCD" name="txtNTCD" type="text" class="InputText" size="4" maxLength="3" /></td>
							</tr>
							<tr>
								<td width="10%" class="Label">中文名稱：</td>
								<td width="40%"><input id="txtNTNM" name="txtNTNM" type="text" class="InputText" size="30" maxLength="20" /></td>
							</tr>
							<tr>
								<td width="10%" class="Label">限定外勞旗標：</td>
								<td width="40%"><input id="chkNTLBR" name="chkNTLBR" type="checkbox" value="1" /></td>
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
						<input type="button" onclick="document.location='IL07A01A01.action'" name="btnClear" value="清 除" id="btnClear" class="InputButton" />
						<input type="button" onclick="javascript:history.go(-1)" name="btnClear" value="回上頁" id="btnClear" class="InputButton" />
					</div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>