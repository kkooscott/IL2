<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2013/8/16
  Time: 上午 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公告資料維護</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" />
    <script src="js/jquery-1.10.0.min.js" type="text/javascript"></script>
    <script src="js/DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="js/domtab.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(window).load(function () {

            if($('#msg').val() != ""){
                alert($('#msg').val());
                $('#msg').val('');
                window.location.href("IL10A002M.action");
            }


            $('#btnSave').click(function () {
                $('#reportForm').attr("action", "doAdd09B.action");
                $('#reportForm').submit();
                return false;
            });

            $('#btnCancel').click(function () {
                $('#reportForm').reset();
                return false;
            });
        });
    </script>
</head>
<body>
<form method="post" id="reportForm" class="Form1">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <div class="FuncName">
                    公告資料新增
                </div>
            </td>
        </tr>
    </table>
    <div id="queryResult">
        <table width="90%" align="center">
            <tr>
                <td>
                    <fieldset>
                        <legend>公告資料</legend>
                        <table width="100%">
                            <tr>
                                <td width="10%" class="Label">
                                    公告內容
                                </td>
                                <td width="40%">
                                    <s:textfield name="input.content" id="txtCONTENT"
                                                 class="InputText" style="width:300px;" theme="simple" cssClass='InputText'/>
                                </td>
                                <td width="10%" class="Label">
                                    公告種類
                                </td>
                                <td width="40%">
                                <s:select list="#{'1':'一般公告', '2':'系統公告'}"
                                          name="input.kind"
                                          value="1" theme="simple" cssClass='InputText'/>
                                </td>
                            </tr>
                            <tr>
                                <td class="Label">
                                    公告起始日期
                                </td>
                                <td>
                                    <s:textfield name="input.beginDate"  id="txtBEGIN_DT" class="InputText" size="10"
                                                 onclick="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                                 onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})" theme="simple" cssClass='InputText'/>

                                    &nbsp;<img onclick="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyy/MM/dd'})"
                                               onfocus="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyy/MM/dd'})"
                                               tabindex="2" src="images/calendar.gif" align="absmiddle" alt="選擇日期" />
                                    <s:select name="input.beginHour"  id="sHour" list="hours" theme="simple" cssClass='InputText'/>
                                    <s:select name="input.beginMinute"  id="sMinute" list="minutes" theme="simple" cssClass='InputText'/>
                                </td>
                                <td class="Label">
                                    公告結束日期
                                </td>
                                <td>
                                   <s:textfield name="input.endDate" id="txtEND_DT" class="InputText" size="10"
                                                onclick="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                                onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})" theme="simple" cssClass='InputText'/>
                                    &nbsp;<img style="cursor: hand"
                                               onclick="WdatePicker({el:'txtEND_DT',dateFmt:'yyy/MM/dd'})"
                                               onfocus="WdatePicker({el:'txtEND_DT',dateFmt:'yyy/MM/dd'})"
                                               tabindex="4" src="images/calendar.gif"
                                               align="absmiddle" alt="選擇日期" />
                                    <s:select name="input.endHour"  id="eHour" list="hours" theme="simple" cssClass='InputText'/>
                                    <s:select name="input.endMinute"  id="eMinute" list="minutes" theme="simple" cssClass='InputText'/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </table>
        <table align="center" cellspacing="0" cellpadding="0" width="90%">
            <tr>
                <td style="text-align: right;">
                    <div class="FunctionArea">
                        <input type="button" name="btnSave" value="儲 存" id="btnSave" class="InputButton" />
                        <input type="button" name="btnCancel" value="取 消" id="btnCancel" class="InputButton" />
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <s:hidden name="msg" id="msg"/>
</form>
</body>
</html>