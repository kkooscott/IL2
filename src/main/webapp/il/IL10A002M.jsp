<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>公告維護</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"/>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript">
        $(window).load(function () {
            $('#btnDelete').click(function () {
                $('#reportForm').attr("action", "IL10A02D.action");
                $('#reportForm').submit();
                return false;
            });

            $('#btnUpdate').click(function () {
                $('#reportForm').attr("action", "IL10A02M.action");
                $('#reportForm').submit();
                return false;
            });

            $('#btnAdd').click(function () {
                $('#reportForm').attr("action", "IL10A02A.action");
                $('#reportForm').submit();
                return false;
            });


        });
    </script>
</head>

<body>
<%@ include file="util/mask.jsp" %>
<s:form id="reportForm">
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color:#ACB8C6;">
    <tr>
        <td width="120" align="center"><img src="images/arrow.jpg" border="0" align="absmiddle"/></td>
        <td width="98%" class="pageTitle">公告維護</td>
    </tr>
</table>
<p></p>
<!-- 查詢條件視窗-->
<div id="queryDiv">
    <table class="queryOuterTable">
        <tr>
            <td width="80%">
                <table>
                    <tr>
                        <th>查詢條件</th>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table class="queryTable">
                    <tr>
                        <td width="20%" class="labelField">公告時間</td>
                        <td class="dataField">
                            <input name="txtDeadLine3" type="text" id="txtDeadLine3" size="10"
                                   onclick="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                   onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})" tabindex="1" class='InputText'/>
                            &nbsp;<img onclick="WdatePicker({el:'txtDeadLine3',dateFmt:'yyy/MM/dd'})"
                                       onfocus="WdatePicker({el:'txtDeadLine3',dateFmt:'yyy/MM/dd'})" tabindex="2"
                                       src="./images/calendar.gif" align="absmiddle" alt="選擇日期"/>&nbsp;至
                            <input name="txtDeadLine3" type="text" id="txtDeadLine4" size="10"
                                   onclick="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                   onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})" tabindex="3" class='InputText'/>
                            &nbsp;<img style="CURSOR: hand"
                                       onclick="WdatePicker({el:'txtDeadLine4',dateFmt:'yyy/MM/dd'})"
                                       onfocus="WdatePicker({el:'txtDeadLine4',dateFmt:'yyy/MM/dd'})" tabindex="4"
                                       src="./images/calendar.gif" align="absmiddle" alt="選擇日期"/>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <p></p>
    <table align="center" cellspacing="0" cellpadding="0">
        <tr>
            <td><span class="buttonS">查 詢</span></td>
            <td><span id="btnAdd" class="buttonS">新 增</span></td>
        </tr>
    </table>
</div>

<div id="queryResult">
    <table class="queryTable">
        <thead>
            <tr>
                <th class="plaintext">公告種類</th>
                <th class="plaintext">公告內容</th>
                <th class="plaintext">公告起迄</th>
                <th class="plaintext">公告人員</th>
                <th class="plaintext">功能</th>
            </tr>
        </thead>
        <tr>
            <td class="plaintext">維護公告</td>
            <td class="plaintext">居留系統將於103/04/01 10~12時更新</td>
            <td class="plaintext">103/04/01 10:00~12:00</td>
            <td class="plaintext">林阿鑫</td>
            <td class="plaintext">
                <input id="btnModify" type="button" value="修改">
                <input id="btnDelete" type="button" value="刪除">
            </td>
        </tr>
    </table>
</div>

</s:form>
</body>
</html>
