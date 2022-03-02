<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <link href="./css/e8.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="./js/include/jquery-ui-1.8.14.custom.css" type="text/css"/>
    <link rel="stylesheet" href="./css/jquery-ui-timepicker.css?v=0.2.9" type="text/css"/>
    <link rel="stylesheet" href="./js/themes/hot-sneaks/jquery.ui.all.css">
    <script type="text/javascript" src="./js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="./js/json2.js"></script>
    <script type="text/javascript" src="./js/jquery.validate.js"></script>
    <script type="text/javascript" src="./js/jquery.validate.unobtrusive.js"></script>
    <script type="text/javascript" src="./js/ui/jquery.ui.core.js"></script>
    <script type="text/javascript" src="./js/ui/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="./js/ui/jquery.ui.datepicker.js"></script>
    <script type="text/javascript" src="./js/ui/i18n/jquery.ui.datepicker-zh-TW-big5.js"></script>
    <script type="text/javascript" src="./js/include/jquery.ui.tabs.min.js"></script>
    <script type="text/javascript" src="./js/include/jquery.ui.position.min.js"></script>
    <script type="text/javascript" src="./js/jquery.ui.timepicker.js?v=0.2.9"></script>
    <script type="text/javascript" src="./js/aa.js"></script>
    <script>
        jQuery(document).ready(function () {
        	var dates = $("#fromDate, #toDate").datepicker({
	            changeMonth:true,
	            numberOfMonths:1
	        });

	        $('#fromTime').timepicker({
	            minutes:{
	                starts:0,
	                ends:59,
	                interval:1
	            },
	            defaultTime:'',
	            rows:6
	        });

	        $('#toTime').timepicker({
	            minutes:{
	                starts:0,
	                ends:59,
	                interval:1
	            },
	            defaultTime:'',
	            rows:6
	        });

            $('#btnQuery').click(function () {
                $('#reportForm').attr("action", "doLogQuery");
                $('#reportForm').submit();
                return false;
            });

            $('#btnExcel').click(function () {
            	$('#reportForm').attr("action", "doDownloadLogExcel");
                $('#reportForm').submit();
                return false;
            });
        });
    </script>
    <title>
        �U���O���d��
    </title>
</head>
<body>
<div class="FuncName">
    �U���O���d��
</div>
<s:if test="hasActionErrors()">
    <div id="errorDiv"  class="alert" style="width: 390px; background: lightyellow; margin-left: 10px; border-color: #ffddcc">
        <table border="0">
            <tr>
                <td width="130px"><img src="img/warn.png"/></td>
                <td>
                    <div id="errorDivMsg" align="left"><s:actionerror/></div>
                </td>
            </tr>
        </table>
    </div>
</s:if>
<form id="reportForm" name="reportForm" class="Form1" action="" method="post">
    <table width="100%" border="0">
        <tr>
            <td colspan="3">
                <fieldset>
                    <legend>�d�߱���</legend>
                    <table>
                        <tr>
                            <td class="Label c1" style="color: red">*�ɶ��_��</td>
                            <td>
                                <s:textfield id="fromDate"
                                             name="fromDate"
                                             size="10"
                                             maxlength="10"
                                             cssClass="InputText"
                                             theme="simple"/>
                                <s:textfield id="fromTime"
                                             name="fromTime"
                                             size="5"
                                             maxlength="5"
                                             cssClass="InputText"
                                             theme="simple"/> ��
                                <s:textfield id="toDate"
                                             name="toDate"
                                             size="10"
                                             maxlength="10"
                                             cssClass="InputText"
                                             theme="simple"/>
                                <s:textfield id="toTime"
                                             name="toTime"
                                             size="5"
                                             maxlength="5"
                                             cssClass="InputText"
                                             theme="simple"/>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="Label c1">�U�����
                            <td>
                            
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="Label c1">���Υ��x
                            <td>
								<s:checkbox id="android" name="android" theme="simple"/>Android
                                <s:checkbox id="ios" name="ios" theme="simple"/>iOS
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="Label c1">Apps�W��
                            <td>
                            <s:textfield id="appName"
                                         name="appName"
                                         size="10"
                                         maxlength="10"
                                         cssClass="InputText"
                                         theme="simple"/>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="Label c1">�ϥΪ̩m�W
                            <td>
                                <s:textfield id="loginEid"
                                             name="loginEid"
                                             size="10"
                                             maxlength="10"
                                             cssClass="InputText"
                                             theme="simple"/>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td class="Label c1">����W��
                            <td>
                                <s:textfield id="deviceName"
                                             name="deviceName"
                                             size="10"
                                             maxlength="10"
                                             cssClass="InputText"
                                             theme="simple"/>
                            </td>
                            <td></td>
                        </tr>
                    </table>
                    <div class="FunctionArea" id="divFunctions">
                        <input id="btnQuery" name="btnQuery" type="button" value="�d��" class="InputButton">
                        <input id="btnExcel" name="btnQuery" type="button" value="Excel�U��" class="InputButton">
                    </div>
                </fieldset>
            </td>
        </tr>
    </table>

</form>

<s:if test='%{hasQuery}'>
<display:table id="row" cellpadding="8" 
	           name="queryList"
	           pagesize="10"
	           requestURI="doLogQuery"
	           decorator="tw.gov.npa.store.decorator.LogDecorator">
    <display:column title="����">${row_rowNum}</display:column>
    <display:column property="unitName" title="���"/>
    <display:column property="userName" title="�ϥΪ̩m�W"/>
    <!-- display:column property="loginEid" title="�b��"/ -->
    <display:column property="deviceName" title="����W��"/>
    <display:column property="softwareName" title="Apps�W��"/>
    <display:column property="platform" title="���Υ��x"/>
    <display:column property="version" title="������"/>
    <display:column property="modified" title="�ɶ�"/>
</display:table>
</s:if>

</body>
</html>
