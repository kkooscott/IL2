<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    
	<script type="text/javascript">
	$(function() {	
		
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	</script>
    
</head>

<body>
<div id="reportPosition" class="reportPosition">
<DIV><PRE>

                                                          行方不明外勞人數統計 (YYYY年MM月)
XXXXXXXXXXXXXXXXXXX印製
印表日期:YYYY/MM/DD
 

註:1.新增逃逸人數:以當月(報案日期)作為檢索統計內容
   2.當月查獲人數:以當月(查獲日期)作為檢索統計內容
   3.目前協尋人數:以資料檔內實際協尋人數作為檢索統計內容, 即(報案日期)有值, (查獲日期)為空白者 

</PRE></DIV>
</div>
</body>
</html>