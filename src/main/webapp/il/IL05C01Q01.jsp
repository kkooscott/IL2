<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
	<head>
		<title>居留外僑動態管理系統-轉出入資料處理作業</title>
		<link rel="Stylesheet" type="text/css" href="css/e8.css" />
		<link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script language="javascript" type="text/javascript"
			src="js/DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/myValidator.js"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<script type="text/javascript">
	$(function() {
		$(function() {
			$('#Confirm').click(
					function() {

						if ($('#selectDate').val() == "") {
							$.alert.open("warning", "日期不可為空白");
						} else if (!($('input[name="dataType"]').is(":checked") )
								) {
							$.alert.open("warning", "請選擇查詢種類");
						} else {
							$('#querylist').empty();
							$('#form1').attr("action", "IL05C01Q01.action");
							$('#form1').submit();
						}
					});
		});
		function IsValidYear(psYear) {
			var sYear = new String(psYear);

			if (psYear == null) {
				return false;
			}

			if (isNaN(psYear) == true) {
				return false;
			}

			if (sYear == "") {
				return true;
			}

			if (sYear.match(/[^0-9]/g) != null) {
				return false;
			}

			var nYear = parseInt(sYear, 10);

			if ((nYear < 0) || (9999 < nYear)) {
				return false;
			}

			return true;
		}

		function IsValidMonth(psMonth) {
			var sMonth = new String(psMonth);

			if (psMonth == null) {
				return false;
			}

			if (isNaN(psMonth) == true) {
				return false;
			}

			if (sMonth == "") {
				return true;
			}

			if (sMonth.match(/[^0-9]/g) != null) {
				return false;
			}

			var nMonth = parseInt(sMonth, 10);

			if ((nMonth < 0) || (12 < nMonth)) {
				return false;
			}

			return true;
		}

		function IsValidDay(psDay) {
			var sDay = new String(psDay);

			if (psDay == null) {
				return false;
			}

			if (isNaN(psDay) == true) {
				return false;
			}

			if (sDay == "") {
				return true;
			}

			if (sDay.match(/[^0-9]/g) != null) {
				return false;
			}

			var nDay = parseInt(psDay, 10);

			if ((nDay < 0) || (31 < nDay)) {
				return false;
			}

			return true;
		}

		function IsValidDate(psYear, psMonth, psDay) {
			if (psYear == null || psMonth == null || psDay == null) {
				return false;
			}

			var sYear = new String(psYear);
			var sMonth = new String(psMonth);
			var sDay = new String(psDay);

			if (IsValidYear(sYear) == false) {
				return false;
			}

			if (IsValidMonth(sMonth) == false) {
				return false;
			}

			if (IsValidDay(sDay) == false) {
				return false;
			}

			var nYear = parseInt(sYear, 10);
			var nMonth = parseInt(sMonth, 10);
			var nDay = parseInt(sDay, 10);

			if (sYear == "" && sMonth == "" && sDay == "") {
				return true;
			}

			if (sYear == "" || sMonth == "" || sDay == "") {
				return false;
			}

			if (nMonth < 1 || 12 < nMonth) {
				return false;
			}
			if (nDay < 1 || 31 < nDay) {
				return false;
			}

			if (nMonth == 2) {
				if ((nYear % 400 == 0) || (nYear % 4 == 0)
						&& (nYear % 100 != 0)) {
					if ((nDay < 1) || (nDay > 29)) {
						return false;
					}
				} else {
					if ((nDay < 1) || (nDay > 28)) {
						return false;
					}
				}
			} else if ((nMonth == 1) || (nMonth == 3) || (nMonth == 5)
					|| (nMonth == 7) || (nMonth == 8) || (nMonth == 10)
					|| (nMonth == 12)) {
				if ((nDay < 1) || (31 < nDay)) {
					return false;
				}
			} else {
				if ((nDay < 1) || (30 < nDay)) {
					return false;
				}
			}

			return true;
		}
		$("#tranceIn").hide();
		$("#tranceOut").hide();

		//控制查詢按鈕點擊後顯示畫面
		$("#Confirm1").click(function() {
			if ($('input[name=DataType]:checked').val() == "I") {
				$("#tranceOut").hide();
				$("#tranceIn").slideDown(800);
			} else if ($('input[name=DataType]:checked').val() == "O") {
				$("#tranceIn").hide();
				$("#tranceOut").slideDown(800);
			}
		});
	});//$(function() {

	//表單送出事件
	function onSubmit(url) {
		document.queryForm.action = url;
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
					<div class="FuncName">
						轉出入結果查詢畫面
					</div>
				</td>
			</tr>
		</table>
		<p></p>

		<!--<hr id='Main2' width='758'></hr>-->

		<s:form id="form1" name="form1" cssClass='Form1' action="">

		
		<table width="90%" align="center">
        <tr><td><fieldset>
		<legend>查詢條件</legend>
			<TABLE border=0 cellPadding=1 cellSpacing=1 width=730 align="center">
				<TR style="HEIGHT: 30px">
					<TD colspan=5>
						<FONT id=lblFLDT>排程執行日期︰</FONT>
						<s:textfield id="selectDate" name="selectDate"
							cssClass="InputText" size="10" theme="simple"
							onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
							onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
						&nbsp;
						<img onclick="WdatePicker({el:'selectDate',dateFmt:'yyyy/MM/dd'})"
							onfocus="WdatePicker({el:'selectDate',dateFmt:'yyyy/MM/dd'})"
							tabindex="2" src="./images/calendar.gif" align="absmiddle"
							alt="選擇日期" />
						<!-- 
						<INPUT id=FLDTYear name=FLDTYear tabindex=1 maxlength=4
							style="WIDTH: 30px"
							value="<s:date name='nowDate' format='yyyy' />" />
						年
						<INPUT id=FLDTMonth name=FLDTMonth tabindex=2 maxlength=2
							style="WIDTH: 20px" value="<s:date name='nowDate' format='MM' />" />
						月
						<INPUT id=FLDTDay name=FLDTDay tabindex=3 maxlength=2
							style="WIDTH: 20px" value="<s:date name='nowDate' format='dd' />" />
						日 -->
						<FONT style="WIDTH: 80px"></FONT>
						<INPUT id=dataType name=dataType type=radio tabindex=4 value="3" checked>
						轉入
						<FONT style="WIDTH: 60px"></FONT>
						<INPUT id=dataType name=dataType type=radio tabindex=5 value="4">
						轉出
						<FONT style="WIDTH: 60px">&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT id="Confirm" name="Confirm" type=button tabindex=6 value=查詢 title=查詢 style="WIDTH: 50px" class='InputButton'>
					</TD>
				</TR>
			</TABLE>
		</fieldset>
	</td>
	</tr>
	</table>	

		
			<s:if test='%{hasQuery}'>
				<display:table id="querylist" name="queryList" pagesize="10" cellpadding="6" 
					requestURI="IL05C01Q01.action"
					decorator="tw.gov.npa.il.decorator.IL05C01Q01Decorator"
					style="width:100%;border-collapse:collapse;">
					<display:column class="Center" property="IMPDT" title="排程建立時間" />
					<display:column class="Center" property="JOB_NAME" title="作業項目" />
					<display:column class="Center" property="TOTAL_COUNT" title="資料總筆數" />
					<display:column class="Center" property="SUCCESS_COUNT"
						title="成功筆數" />
					<display:column class="Center" property="FAIL_COUNT" title="失敗筆數" />
					<display:column class="Center" property="STATUS" title="執行結果" />
					<display:column class="Center" property="FILENAME" title="執行檔案名稱" />
					<display:column class="Center" property="INFO" title="明細內容" />
				</display:table>
			</s:if>



			<TABLE id=Main5 border=0 cellPadding=0 cellSpacing=0 align=center
				width=758>
				<TR>
					<!--<TD align=left width="33%">
						<A href="IL05000M.action"><IMG border=0 height=36
								src="images/il/h-12.gif" width=36 Alt="回首頁"> </A>
						<A href="IL05000M.action"><IMG border=0 height=36
								src="images/il/h-3.gif" width=36 Alt="上一層"> </A>
					</TD>-->
					<TD align="center" width="33%">

					</TD>
					<TD align=right width="33%">
						<!--  		<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /> -->
					</TD>
				</TR>
			</TABLE>
		</s:form>
		<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
	</body>
</html>