<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"/>
    <script type="text/javascript">
    $(function() {
		
    });

    </script>

</head>
<body>
<div class="row">
    <div class="span12">
        <form id="reportForm" class="form-horizontal" action="downloadAddress.action" method="post">
            <div class="control-group">
                <label class="control-label" for="idno">身分證號</label>

                <div class="controls">
                    <s:textfield id="idno" name="idno" cssClass="input-medium"/>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label"></label>

                <div class="controls">
                    <input type="submit" id="btnQueryAddress" name="btnQueryAddress" value="門牌整編查詢" />
                </div>
            </div>
        </form>
        <form id="reportForm1" class="form-horizontal" action="doDownloadLogExcel.action" method="post">        
            <div class="control-group">
                <label class="control-label"></label>

                <div class="controls">
                    <input type="submit" id="btnDownloadLogExcel" name="btnDownloadLogExcel" value="紀錄報表" />
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>