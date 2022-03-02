<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html>
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

										居留外僑統計(按國籍及居留目的分)
XXXXXXXXXXXXXXXXXXX印製                                                         YYYY年MM月止                                                  頁次: 9999 
印表日期:YYYY/MM/DD
                                   合       計        無國籍            汶萊              緬甸              ##########       ##########         ##########
                     總   計       男       女        男       女       男       女       男       女       男       女      男       女       男       女
     
合            計     999,999  999,999  999,999   999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999
小    計       C=A+B
依 依   計         A=A1+A2+A3+A4
 本 依配偶           A1
   國 依子女           A2
   人 依父母           A3
      其他             A4

   依   計         B=B1+B2+B3+B4
   外 依配偶           B1
   國 依子女           B2
親 人 依父母           B3
    其他             B4
就學      
應聘
投資
傳教
外勞
其他
永 小   計
久 居留七年
居 依親五年配偶
留 依親五年子女
居留十五年

</PRE></DIV>
</div>
</body>
</html>