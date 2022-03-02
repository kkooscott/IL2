<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-排程管理作業</title>
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>   
    <script type="text/javascript" src="js/myValidator.js"></script>
    <style type="text/css">
		#resultList td.sid {
			text-align: center;
   			vertical-align: middle;
		}
		em {
			color: red;
		}
	</style>
    <script type="text/javascript">
	$(function() {	
		$('#btnQuery').click(function () { 
			if($('#startDate').val()=="" ||$('#endDate').val()==""){
				$.alert.open('warning', '日期區間不可為空白');
			}else{
				$('#reportForm').attr("action", "IL08B01U01.action");
				$('#reportForm').submit();
			}
           return false;
		});

       $('.btnRestart').click(function () {
           var sid = $(this).parent().parent().children('.id').text();
           $.alert.open('warning', sid);
           /* swal(sid); */
           $('#sid').attr("value", sid);

           $('#reportForm').attr("action", "CV08A02R.action");
           $('#reportForm').submit();

           return false;
       });

       $('.btnStop').click(function () {
           var sid = $(this).parent().parent().children('.id').text();
           $('#sid').attr("value", sid);

           $('#reportForm').attr("action", "CV08A02S.action");
           $('#reportForm').submit();

           return false;
       });

       $('.btnDetail').click(function () {
           return false;
       });
	});//$(function() {

	
	//表單送出事件
	function onSubmit(url){
		 $.alert.open('warning', url);
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
			<div class="FuncName">排程管理作業-排程狀態管理</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗-->
<s:form id="reportForm" theme="simple" cssClass="Form1">
<!-- 查詢條件視窗-->
<div id="queryDiv">
    <table width="90%" align="center">
        <tr>
            <td>
                <fieldset>
                    <legend>查詢條件</legend>
                    <table width="100%">
                        <tr>
                            <td width="10%" class="Label">
                                *排程種類
                            </td>
                            <td width="40%">
                                <select name="ddlKIND" id="ddlKIND" class="InputSelect" name="ddlKIND">
                                    <option selected="selected" value="1">影像資料匯入作業</option>                   
                                </select>
                            </td>
                            <td width="10%" class="Label">
                                *查詢時間
                            </td>
                            <td>
                                <s:textfield id="startDate" name="startDate" cssClass="InputText" size="10"
                                             theme="simple"
                                             onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
                                             onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})"/>
                                &nbsp;<img onclick="WdatePicker({el:'startDate',dateFmt:'yyyy/MM/dd'})"
                                           onfocus="WdatePicker({el:'startDate',dateFmt:'yyyy/MM/dd'})"
                                           tabindex="2" src="./images/calendar.gif" align="absmiddle" alt="選擇日期"/>&nbsp;至
                                <s:textfield id="endDate" name="endDate" cssClass="InputText" size="10" theme="simple"
                                             onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
                                             onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})"/>
                                &nbsp;<img style="cursor: hand"
                                           onclick="WdatePicker({el:'endDate',dateFmt:'yyyy/MM/dd'})"
                                           onfocus="WdatePicker({el:'endDate',dateFmt:'yyyy/MM/dd'})" tabindex="4"
                                           src="./images/calendar.gif"
                                           align="absmiddle" alt="選擇日期"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
    </table>
    <p>
    </p>
    <table align="center" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <div class="FunctionArea">
                    <input type="submit" name="btnQuery" value="查 詢" id="btnQuery" class="InputButton" />
                </div>
            </td>
        </tr>
    </table>
</div>
<p></p>



<s:if test='%{hasQuery}'>
<div id="queryResult" style="width:100%">
    <table cellspacing="0" width="90%" id="ListTable" align="center">
        <tr>
            <td>
                <div>
                	<form id="myForm" name="myForm" method="post" action="">	
                    <display:table id="queryList" name="queryList" pagesize="5" requestURI="IL08B01U01.action" cellpadding="8" 
                                   decorator="tw.gov.npa.il.decorator.IL08B01U01Decorator"
                                   style="width:100%;border-collapse:collapse;">
                        <display:column headerClass="First" class="Center id" title="#">${queryList_rowNum}</display:column>
                        <display:column class="Center" property="type" title="類別"/>
                        <display:column class="Center" property="sTime" title="排程啟動時間"/>
                        <display:column class="Center" property="eTime" title="排程完成時間"/>
                        <display:column class="Center" property="status" title="執行狀況"/>
                        <display:column class="Center" property="INFO" title="功能"/>
                    </display:table>
					</form>
                </div>
            </td>
        </tr>
    </table>
</div>
</s:if>
<s:hidden id="sid" name="sid"/>
</s:form>
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href=""><img border='0' height="36" src="./images/il/h-12.gif" width="36" alt='首頁'/></A>
			<A href=""><img border='0' height='36' src="images/il/h-3.gif" width='36' Alt="上一層"/></A>				
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