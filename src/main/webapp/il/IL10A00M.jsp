<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>功能清單維護</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <script rel="stylesheet" type="text/css">

    </script>
    <script type="text/javascript" src="js/jquery-1.10.0.min.js"/>
    <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>

    <script type="text/javascript">
        $(window).load(function () {
            $('.btnDelete').click(function () {
                var _id = $(this).parent().parent().find('.id').text();
                document.reportForm.cvId.value = _id;

                $('#reportForm').attr("action", "doCV10Remove.action");
                $('#reportForm').submit();
                return false;
            });

            $('.btnUpdate').click(function () {
                var _id = $(this).parent().parent().find('.id').text();
                var _parent = $(this).parent().parent().find('.parent').val();
                var _name = $(this).parent().parent().find('.name').val();
                var _rank = $(this).parent().parent().find('.rank').val();
                var _url = $(this).parent().parent().find('.url').val();

                document.reportForm.cvId.value = _id;
                document.reportForm.cvParent.value = _parent;
                document.reportForm.cvName.value = _name;
                document.reportForm.cvRank.value = _rank;
                document.reportForm.cvUrl.value = _url;

                $('#reportForm').attr("action", "doCV10Update.action");
                $('#reportForm').submit();
                return false;
            });

            $('.btnInsert').click(function () {
                console.log('btnInsert');
            });


            $('.btnAdd').click(function () {
                var _id = $(this).parent().parent().find('.id').text();
                var _parent = $(this).parent().parent().find('.parent').val();
                var _name = $(this).parent().parent().find('.name').val();
                var _rank = $(this).parent().parent().find('.rank').val();
                var _url = $(this).parent().parent().find('.url').val();

                document.reportForm.cvId.value = _id;
                document.reportForm.cvParent.value = _parent;
                document.reportForm.cvName.value = _name;
                document.reportForm.cvRank.value = _rank;
                document.reportForm.cvUrl.value = _url;

                $('#reportForm').attr("action", "doCV10Add.action");
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
            <td width="98%" class="pageTitle">功能清單維護</td>
        </tr>
    </table>
    <p></p>

    <!-- 查詢條件視窗-->
    <table class="queryTable">
        <tr>
            <td>
                <span class="buttonS btnInsert">新增功能</span>
            </td>
        </tr>
        <tr>
            <td>
            	
            	<!-- 
                <display:table id="row" name="queryList" pagesize="50" requestURI="doCV10Query"
                               decorator="tw.gov.npa.cv.decorator.CV10Decorator">
                    <display:column headerClass="gridHeader" property="id" title="流水號"/>
                    <display:column headerClass="gridHeader" property="parent" title="父節點"/>
                    <display:column headerClass="gridHeader" property="name" title="功能名稱"/>
                    <display:column headerClass="gridHeader" property="rank" title="順序"/>
                    <display:column headerClass="gridHeader" property="url" title="連結位置"/>
                    <display:column headerClass="gridHeader" property="function" title="功能"/>
                </display:table>
                 -->
            </td>
        </tr>
    </table>
    </div>
    <input type="hidden" name="cvId">
    <input type="hidden" name="cvParent">
    <input type="hidden" name="cvName">
    <input type="hidden" name="cvRank">
    <input type="hidden" name="cvUrl">
</s:form>
</body>
</html>