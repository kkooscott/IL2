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

								永久居留外僑統計(按國籍及區域分)
XXXXXXXXXXXXXXXXXXX印製                                                 YYYY年MM月止                                                          頁次: 9999
印表日期:YYYY/MM/DD    
                                   合       計        無國籍            汶萊              緬甸              ##########       ##########         ##########
                     總   計       男       女        男       女       男       女       男       女       男       女      男       女       男       女
     
  合  計             999,999  999,999  999,999   999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999
臺 灣 地 區
   臺 灣 省
     臺北縣
     宜蘭縣
     桃園縣
     新竹縣
     苗栗縣
     臺中縣
     彰化縣
     南投縣
     雲林縣
     嘉義縣
     臺南縣
     高雄縣
     屏東縣
     臺東縣
     花蓮縣
     澎湖縣
     基隆市
     新竹市
     臺中市
     嘉義市
     臺南市
   臺 北 市
   高 雄 市
   福 建 省
     金門縣
     連江縣

</PRE></DIV>
</div>
</body>
</html>