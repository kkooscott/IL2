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
		 $('#outputButton').click(function(){
		     

		     if($('#selectDate').val()=="")
				{
		    	 $.alert.open("warning", "日期不可為空白");
				}
			else
			{
				$.alert.open("warning", '已加入排程');
	         $('#queryForm').attr("action", "IL05B03U.action");
	         $('#queryForm').submit();	   
			}
		 });
	});
function IsValidYear(psYear)
{
var sYear = new String(psYear);
 
 
if(psYear==null)
{
return false;
}
 
 
if(isNaN(psYear)==true)
{
return false;
}
 
if(sYear == "")
{
return true;
}
 
if(sYear.match(/[^0-9]/g)!=null)
{
return false;
}
 
var nYear = parseInt(sYear, 10);
 
if((nYear < 0) || (9999 < nYear))
{
return false;
}
 
return true;
}
 
 
function IsValidMonth(psMonth)
{
var sMonth = new String(psMonth);
 
if(psMonth==null)
{
return false;
}
 
if(isNaN(psMonth)==true)
{
return false;
}
 
if(sMonth == "")
{
return true;
}
 
if(sMonth.match(/[^0-9]/g)!=null)
{
return false;
}
 
var nMonth = parseInt(sMonth,10);
 
if((nMonth < 0) || (12 < nMonth))
{
return false;
}
 
return true;
}
 
 
function IsValidDay(psDay)
{
var sDay = new String(psDay);
 
if(psDay==null)
{
return false;
}
 
if(isNaN(psDay)==true)
{
return false;
}
 
if(sDay == "")
{
return true;
}
 
if(sDay.match(/[^0-9]/g)!=null)
{
return false;
}
 
var nDay = parseInt(psDay, 10);
 
if((nDay < 0) || (31 < nDay))
{
return false;
}
 
return true;
}
 
 
function IsValidDate(psYear, psMonth, psDay)
{
if(psYear==null || psMonth==null || psDay==null)
{
return false;
}
 
var sYear = new String(psYear);
var sMonth = new String(psMonth);
var sDay = new String(psDay);
 
if(IsValidYear(sYear)==false)
{
return false;
}
 
if(IsValidMonth(sMonth)==false)
{
return false;
}
 
if(IsValidDay(sDay)==false)
{
return false;
}
 
var nYear = parseInt(sYear, 10);
var nMonth = parseInt(sMonth, 10);
var nDay = parseInt(sDay, 10);
 
if(sYear=="" && sMonth=="" && sDay=="")
{
return true;
}
 
if(sYear=="" || sMonth=="" || sDay=="")
{
return false;
}
 
if(nMonth < 1 || 12 < nMonth)
{
return false;
}
if(nDay < 1 || 31 < nDay)
{
return false;
}
 
if(nMonth == 2)
{
if((nYear % 400 == 0) || (nYear % 4 == 0) && (nYear % 100 != 0))
{
if((nDay < 1) || (nDay > 29))
{
return false;
}
}
else
{
if((nDay < 1) || (nDay > 28))
{
return false;
}
}
}
else if((nMonth == 1) ||
(nMonth == 3) ||
(nMonth == 5) ||
(nMonth == 7) ||
(nMonth == 8) ||
(nMonth == 10) ||
(nMonth == 12))
{
if((nDay < 1) || (31 < nDay))
{
return false;
}
}
else
{
if((nDay < 1) || (30 < nDay))
{
return false;
}
}
 
return true;
}

	//$(function() {
    
   	function onSubmit(url){		    
		document.queryForm.action=url;
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
						移民署轉出資料-條件輸入畫面
					</div>
				</td>
			</tr>
		</table>
		<p></p>

		<!--<hr id='Main2' width='758'></hr>-->

		<s:form id="queryForm" cssClass='Form1' name="queryForm" action="" theme="simple">

		
		
		<table width="90%" align="center">
				<tr><td><fieldset>
				<legend>轉出條件</legend>
					<table width="100%">               
					<tr><td>
					<INPUT id=DataType name=DataType type=radio value="T" checked>
				查察記事異動資料
				<BR>
				<BR>

				<LABEL id=lblFLDT>
					檔案日期：
				</LABEL>
				<s:textfield id="selectDate" name="selectDate" cssClass="InputText"
					size="10" theme="simple"
					onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
					onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
				&nbsp;
				<img onclick="WdatePicker({el:'selectDate',dateFmt:'yyyy/MM/dd'})"
					onfocus="WdatePicker({el:'selectDate',dateFmt:'yyyy/MM/dd'})"
					tabindex="2" src="./images/calendar.gif" align="absmiddle"
					alt="選擇日期" />
				<!--
				<INPUT id=FLDTYear name=FLDTYear maxlength=4 style="WIDTH: 30px"
					value="<s:date name='nowDate' format='yyyy' />">
				年
				<INPUT id=FLDTMonth name=FLDTMonth maxlength=2 style="WIDTH: 20px"
					value="<s:date name='nowDate' format='MM' />">
				月
				<INPUT id=FLDTDay name=FLDTDay maxlength=2 style="WIDTH: 20px"
					value="<s:date name='nowDate' format='dd' />">
				日
				-->
					
					
					</td></tr>
					</table>
				</fieldset>
			</td>
			</tr>
			</table>	
		
			<DIV style="margin-left: 270px">
				
			</DIV>

			<!--<hr id='Main7' width='758'></hr>-->

			<table id='Main8' border='0' cellPadding='0' cellSpacing='1'
				style='text-align:center' width='100%'>
				<tr>
					<!--<td align='left' width="33%">
						<A href="IL05B00M.action"><img border='0' height="36"
								src="images/il/h-12.gif" width="36" alt='首頁' /> </A>
						<A href="IL05B00M.action"><img border='0' height='36'
								src="images/il/h-3.gif" width='36' Alt="上一層" /> </A>
					</td>-->
					

					<td style='text-align:center' width="100%">
						<input type="button" id="outputButton" name="outputButton"
							id="importButton" class="InputButton" value="轉出" />

					</td>

					<!--<td align='right' width="33%">
						<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />
					</td>-->
				</tr>
			</table>
		</s:form>
	</body>
</html>