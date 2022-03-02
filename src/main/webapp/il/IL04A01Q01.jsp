<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@page import="java.util.*"%>
<%

if(session.getAttribute("LOGUID")==null||session.getAttribute("LOGUID").equals("")){
	response.sendRedirect("il/timeoutmsg.html");
}
%>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    
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
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">月統計報表下載-選取畫面</div>
		</td>
	</tr>
</table>
<p></p>
<s:form action="IL04A01Q02" id='myForm'>
	<div id="queryResult" style="width:100%;">	
	  <TABLE border=1 cellPadding=1 cellSpacing=1 align="center">
   	   
	</TABLE>
	
	<table cellspacing="1" width="90%" id="ListTable"  align="center">
	
		<tr>
			<td>
	        <div>
			<!--
			<table class="ListTable"> 
			<tr><td width='40%' style='vertical-align:middle'>
			因應新系統上線，103年1~6月統計報表<br>
			請於右方打包下載
			</td>
			<td width='25%'>
			<br>
			<a href='/IL2/report/10301.zip'>103年1月</a><br><br>
			<a href='/IL2/report/10302.zip'>103年2月</a><br><br>
			<a href='/IL2/report/10303.zip'>103年3月</a><br><br>
			</td>
			<td width='35%'>
			<br>
			<a href='/IL2/report/10304.zip'>103年4月</a><br><br>
			<a href='/IL2/report/10305.zip'>103年5月</a><br><br>
			<a href='/IL2/report/10306.zip'>103年6月</a><br>
			</td>
			
			</tr>
			</table>
			-->
			<TABLE class="ListTable" cellspacing="0" cellpadding="8" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
		    	<thead>
				<TR class="even">
    		<TD colspan='2'><font size='3'>月份選擇
			
			<SELECT id="chooseDay" name="chooseDay" class='InputText'>
			
					<%
						Calendar now = Calendar.getInstance();
						int year = now.get(Calendar.YEAR);
						int month = now.get(Calendar.MONTH)+1; // Note: zero based!
						
						for(int i=1;i<=12;i++){
							
							if(month-i>0){
								out.println("<option value='"+year+""+(month-i)+"'>"+year+"年"+(month-i)+"月</option>");
								
							}else{
								if(month-i==0){
									out.println("<option value='"+(year-1)+"12'>"+(year-1)+"年12月</option>");
								}else{
									out.println("<option value='"+(year-1)+""+(12-(i-month))+"'>"+(year-1)+"年"+(12-(i-month))+"月</option>");

								}
								
							}
						}
					%>
			
					
				</SELECT></font>
			</TD>
			
	  </TR>
		    	<TR>
		    		<th class="First" scope="col" width="10%">序號</th>
		        	<th scope="col" width="80%">報表名稱</th>
		        </TR>
		        </thead>
		        <tbody>
			    	<tr class="odd">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="1" checked>1</td>
			        	<td width="80%">永久居留外僑統計</td>
			        </tr>
		        	<tr class="even">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="2">2</td>
			        	<td width="80%">現持有效居留證外僑統計</td>
			        </tr>
		        	<tr class="odd">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="3">3</td>
			        	<td width="80%">居留外僑統計</td>
			        </tr>
		        	<tr class="even">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="4">4</td>
			        	<td width="80%">行方不明外勞人數統計</td>
			        </tr>
		        	<tr class="odd">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="5">5</td>
			        	<td width="80%">現持有效外僑居留證之外籍配偶統計</td>
			        </tr>
		        	<tr class="even">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="6">6</td>
			        	<td width="80%">行方不明外僑人數統計</td>
			        </tr>
		        	<tr class="odd">
			    		<td width="10%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="7">7</td>
			        	<td width="80%">外籍配偶居留統計</td>
			        </tr>
		        </tbody>
		     </TABLE>
	     	</div>
			</td>
		</tr>
	</table>
    </div>
    <center>
    <div class="FunctionArea">				 	
    	<input type="submit" name="btnQuery" id="btnQuery" class="InputButton" value="確定" />                   
    </div>
    </center>
	<p></p>	
</s:form>   
<!--<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL04000M.action"><img border='0' height="36" src="./images/il/h-12.gif" width="36" alt='首頁'/></A>
			<A href="IL04000M.action"><img border='0' height='36' src="images/il/h-3.gif" width='36' Alt="上一層"/></A>				
		</TD>
		<TD align="center" width="53%">	
		</TD>	
		<TD align=right width="33%">
			<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />
		</TD>
	</TR>
</table>    
-->
</body>
</html>