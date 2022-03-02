<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ page import="java.util.*,java.text.*" %>
<html>
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
<% 
Date dateDate = new Date();
SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
String nowDate = df.format(dateDate);
%>
<div id="reportPosition" class="reportPosition">
<DIV><PRE>
                                                                            桃園縣政府警察局(郵遞區號320)01外責區　外籍男性幫傭名冊

製表單位：警政署資訊室作業設計科
製表日期：<%=nowDate%>                                                                                                                                                                                  頁次：1 頁

統一證號    英文姓名                                                       國籍                 性別 出生日期       職業             居留事由           服務處所/讀學校/依親對象
居留期限    護照號碼    居留地址                                           居留電話                  工作地址                                           工作電話        備  考
================================================================================================================================================================================================================
FC01393771  CLARIDAD NUMERIANO JR GOTIS                                    菲律賓               男   1977/09/21     家庭幫傭         外勞               安捷工業有限公司                            
2012/06/05  VV0401590   桃園縣中壢市義民路１７７號                                                  桃園縣中壢市義民路１７７號                                                                                 
                                                                                                   合計 1 人
</PRE></DIV>
</div>
</body>
</html>