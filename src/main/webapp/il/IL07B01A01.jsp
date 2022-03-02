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
		<script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
		<script type="text/javascript">
		
		function toSubmit() {
			if (!validateNull($("#txtOPCD").val())) {
				$.alert.open("warning", "職業代碼未輸入");
				return;
			} else if (!validateNull($("#txtOPNM").val())) {
				$.alert.open("warning", "中文名稱未輸入");
				return;
			} else if (!validateNull($("#txtOPPRSQ").val())) {
				$.alert.open("warning", "列印順序未輸入");
				return;
			} else if (!validateNull($("#txtOPCS").val())) {
				$.alert.open("warning", "統計歸屬代碼未輸入");
				return;
			} else if (!validateFormat($("#txtOPCD").val(), 0, 2)) {
				$.alert.open("warning", "職業代碼為二位數字，例如：01");
				return;
			} else if ( !validateFormat($("#txtOPPRSQ").val(), 0, 1) && !validateFormat($("#txtOPPRSQ").val(), 0, 2) ) {
				$.alert.open("warning", "列印順序為數字");
				return;
			} else if (!validateFormat($("#txtOPCS").val(), 0, 2)) {
				$.alert.open("warning", "統計歸屬代碼為二位數字，例如：01");
				return;
			} else {
				if( checkID() == "0" ) {
					$.ajax({
				        url: 'IL07B00A.action',
				        type: 'post',
				        data: {
				        	txtOPCD : $('#txtOPCD').val(),
				        	txtOPNM : $('#txtOPNM').val(),
				        	txtOPPRSQ : $('#txtOPPRSQ').val(),
				        	txtOPCS : $('#txtOPCS').val(),
					        },
				        async:false,
				        success: function(result) { 
					        if(result == 'true') {
					        	$.alert.open({
					        	    content: '新增成功',
					        	    callback: function() {
					        	    	window.location = "IL07B00M.action";
					        	    }
					        	});
					        }else {
					        	$.alert.open({
					        	    content: '新增失敗',
					        	    callback: function() {
					        	    	window.location = "IL07B00M.action";
					        	    }
					        	});
					        }
				        }
				    });
				}else {
					$.alert.open("warning", "職業代碼已存在");
				}
			}
		}
		
		function checkID() {
		    var url = "IL07B01A02.action";
		    var id = $("#txtOPCD").val();
		    var output;
		    $.ajax({
		        url: url,
		        type: 'post',
		        data: {
			        'txtOPCD': id
		        },
		        async:false,
		        success: function(result){ output = result; }
		    });
		    return output;
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
							職業類別代碼新增-資料輸入畫面
						</div>
					</td>
				</tr>
			</table>

			<table width="90%" align="center">
				<tr>
					<td>
						<fieldset>
							<legend>
								新增資料
							</legend>
							<table width="100%">
								<tr>
									<td width="10%" class="Label">
										職業代碼：
									</td>
									<td width="40%">
										<input id="txtOPCD" name="txtOPCD" type="text"
											class="InputText" size="1" maxLength="2" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										中文名稱：
									</td>
									<td width="40%">
										<input id="txtOPNM" name="txtOPNM" type="text"
											class="InputText" size="30" maxLength="20" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										列印順序：
									</td>
									<td width="40%">
										<input id="txtOPPRSQ" name="txtOPPRSQ" type="text"
											class="InputText" size="1" maxLength="2" />
									</td>
								</tr>
								<tr>
									<td width="10%" class="Label">
										統計歸屬代碼：
									</td>
									<td width="40%">
										<input id="txtOPCS" name="txtOPCS" type="text"
											class="InputText" size="1" maxLength="2" />
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
								onclick="document.location='IL07B01A01.action'" name="btnClear"
								value="清 除" id="btnClear" class="InputButton" />
								<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
							<!--<input type="button" onclick="document.location='IL07000M.action'"
								name="btnExit" value="離 開" id="btnExit" class="InputButton" />-->
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
					<A href="IL07B00M.action"><img border='0' height='36'
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