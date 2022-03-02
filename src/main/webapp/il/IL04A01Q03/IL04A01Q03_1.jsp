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

									永久居留外僑統計(按國籍及職業分)
XXXXXXXXXXXXXXXXXXX印製                                                    YYYY年MM月止                                                        頁次: 9999           
印表日期:YYYY/MM/DD
                                   合       計        無國籍            汶萊              緬甸              ##########       ##########         ##########
                     總   計       男       女        男       女       男       女       男       女       男       女      男       女       男       女
     
  合  計             999,999  999,999  999,999   999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999  999,999
公務人員
商務人員
工程師
會計師
律師
新聞記者
教師
醫師
護理人員
傳教士
技工技匠
   小  計
外 營建業技工
籍 製造業技工
勞 家庭幫傭
工 監護工
   船員
   其他
船員
其他(有業者)
失業
家務
學生
其他(無業者)
未滿十五足歲兒童

</PRE></DIV>
</div>
</body>
</html>