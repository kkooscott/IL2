<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-勤區查察作業</title>
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script type="text/javascript" src="js/domtab.js"></script>
    <script src="jQuery/development-bundle/jquery-1.9.1.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.core.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.widget.js"></script>
    <script type="text/javascript" src="js/myValidator.js"></script>
    <script type="text/javascript" src="js/alert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
	<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
	<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
  	<style type="text/css">
		#resultList td.sid {
			text-align: center;
   			vertical-align: middle;
		}
		em {
			color: red;
		}
	</style>
	
	<script type="text/javascript">
	$(function() {	
		
	});//$(function() {
	
	//表單送出事件
	function onSubmit(){
		if($('input[name=ilArcid]:checked').val()==null){
			$.alert.open("warning", "選取項不可為空");
			return;
		}
	
		document.myForm.submit();
	}
	</script>
 
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">查察記事-資料選取畫面</div>
		</td>
	</tr>
</table>
<p></p>



<div id="queryResult" style="width:100%;">
<form id="myForm" name="myForm" method="post" action="IL02A01U03.action">
    <table cellspacing="0" width="90%" id="ListTable" align="center">
        <tr>
            <td>
                <div>
				
				<!-- 日誌用開始 -->
				<input type="hidden" id="logcn" name="logcn" value="${logcn}" />
				<input type="hidden" id="logpstname" name="logpstname" value="${logpstname}" />
				<input type="hidden" id="main" name="main" value="${main}" />
				<input type="hidden" id="detail" name="detail" value="${detail}" />
				<input type="hidden" id="other" name="other" value="${other}" />
				<!-- 日誌結束 -->					
				<input type="hidden" id="ilNtnm" name="ilNtnm" value="${ilNtnm}" />
				<input type="hidden" id="ilEnm" name="ilEnm" value="${ilEnm}" />
				<input type="hidden" id="ilNtcd" name="ilNtcd" value="${ilNtcd}" />
				<input type="hidden" id="ilPspt" name="ilPspt" value="${ilPspt}" />	
				<input type="hidden" id="txtBEGIN_DT" name="txtBEGIN_DT" value="${txtBEGIN_DT}" />	
				<input type="hidden" id="ilArcno" name="ilArcno" value="${ilArcno}" />		
				<display:table id="resultList" name="il02A01U02BeanList" pagesize="10" requestURI="IL02A01U02.action" decorator="tw.gov.npa.il.decorator.IL02A01U02Decorator" cellpadding="8" style="width:100%;border-collapse:collapse;">
					<display:column headerClass="First" class="Center sid id" property="function" title="" />
					<display:column class="Center" property="ilNTNM" title="國籍" />
					<display:column class="Center" property="ilPspt" title="護照號碼" />
					<display:column class="Center" property="ilEnm" title="英文姓名" />
					<display:column class="Center" property="ilBthdt" title="出生日期" />
				</display:table>
				<div class="FunctionArea">				 	
			    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" onclick="onSubmit();" value="確定" />                  
					<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
				</div>					
				
				</div>
            </td>
        </tr>
    </table></form>	
</div>

<!--<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL02000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL02A01U01.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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