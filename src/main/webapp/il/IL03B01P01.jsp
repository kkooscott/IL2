<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    
    <script type ="text/javascript" >
   	$(function() {	
		/**作業結果判斷(N:新增、E:修改、D:刪除、''為表單非執行結果、F:設定失敗)**/
		if("<s:property value='isFlag'/>"=="N"){
			$.alert.open("confirm", "新增成功");
		}else if("<s:property value='isFlag'/>"=="E"){
			$.alert.open("confirm", "修改完成");
		}else if("<s:property value='isFlag'/>"=="F"){
			$.alert.open("warning", "系統發生錯誤，請洽系統管理員");
		}
	});//$(function() {
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">轄區狀況統計資料-表冊選擇畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!--表格-->
<s:form action="IL03B01P02" cssClass='Form1'>
	<input type="hidden" id="ilPst" name="ilPst" value="${ilPst}" />
	<input type="hidden" id="ilZipCode" name="ilZipCode" value="${ilZipCode}" />
	<input type="hidden" id="ilZipCodeName" name="ilZipCodeName" value="${ilZipCodeName}" />
	<input type="hidden" id="ilPstext" name="ilPstext" value="${ilPstext}" />
	
	<input type="hidden" id="ilZipCodeList" name="ilZipCodeList" value="${ilZipCodeList}" />
	<input type="hidden" id="ilZipFullNameList" name="ilZipFullNameList" value="${ilZipFullNameList}" />
	
	<div id="queryResult" style="width:100%;">		 
	<table cellspacing="0" width="90%" id="ListTable"  align="center">
		<tr>
			<td>
	        <div>
			<TABLE class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
		    	<thead>
		    	<TR>
		    		<th class="First" scope="col" width="20%">序號</th>
		        	<th scope="col" width="80%">報表名稱</th>
		        </TR>
		        </thead>
		        <tbody>
			    	<tr class="odd">
			    		<td width="20%" style='text-align:center'><input type="radio" id="Choice" name="Choice" value="1" checked>1</td>
			        	<td width="80%">自由檢索</td>
			        </tr>
		        	<tr class="even">
			    		<td width="20%" style='text-align:center'><input type="radio" id="Choice" name="Choice" value="2">2</td>
			        	<td width="80%">居留外僑統計表(按國籍及職業分)</td>
			        </tr>
		        	<tr class="odd">
			    		<td width="20%" style='text-align:center'><input type="radio" id="Choice" name="Choice" value="3">3</td>
			        	<td width="80%">外籍男性幫傭名冊</td>
			        </tr>
		        	<tr class="even">
			    		<td width="20%" style='text-align:center'><input type="radio" id="Choice" name="Choice" value="4">4</td>
			        	<td width="80%">東南亞女子與國人結婚名冊</td>
			        </tr>
		        	<tr class="odd">
			    		<td width="20%" style='text-align:center'><input type="radio" id="Choice" name="Choice" value="5">5</td>
			        	<td width="80%">行方不明外勞協尋名冊</td>
			        </tr>
		        	<tr class="even">
			    		<td width="20%" style='text-align:center'><input type="radio" id="Choice" name="Choice" value="6">6</td>
			        	<td width="80%">逾期居留外僑名冊</td>
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
		<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />		
    </div>
    </center>
	<p></p>	
</s:form>   
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL03000M.action"><img border='0' height="36" src="./images/il/h-12.gif" width="36" alt='首頁'/></A>
			<A href="IL03B01P00.action"><img border='0' height='36' src="images/il/h-3.gif" width='36' Alt="上一層"/></A>				
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