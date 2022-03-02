<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>

<html>
	<head>
		<title>居留外僑動態管理系統-排程管理作業</title>
		<link rel="Stylesheet" type="text/css" href="css/e8.css" />
		<link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
	<script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>   
    <script type="text/javascript" src="js/myValidator.js"></script>
		<script type="text/javascript">
		$(function() {	
			 $('#importButton').click(function(){		
				  if(	$('#dataFileMonth').val()=="" || 	$('#dataFileYear').val()=="")
				  {
				  $.alert.open('warning', '年月不可空白');
				  }
				  else if(parseInt($('#dataFileMonth').val()) >12 ||parseInt($('#dataFileMonth').val())<1)
				  {
					  $.alert.open('warning', '請輸入正確月份');
				  }
				  else if($('#dataFilePassword').val()=="")
				  {
					  $.alert.open('warning', '密碼不可為空白');
				  }
				  else
				  {$.alert.open('warning', '已加入匯入排程');
				  $('#form1').attr("action", "IL08A01U01.action");
				  $('#form1').submit();
			  	  }
			 });
	   	});//$(function() {
	   	
	   	function isDate(str){
        	//如果是正确的日期格式返回true,否则返回false
        	var regExp;
        	regExp = /d{4}-d{1,2}-d{1,2}/;
			//判断整体格式yyyy-mm-dd
			if (str!=str.match(/d{4}-d{2}-d{2}/ig))	{
				$.alert.open('warning', '請輸入日期格式為：yyyy-mm-dd!');
				return false;
			}
		}
		</script>
	<style>
	#importButton {
	font-size: 12px;
	background: url('images/btn2.jpg') repeat-x;
	padding-top: 3px;
	color: #233054;/*#2B4723;*/
	border-top: 1px solid #BBBBBB;
	border-right: 1px solid #888888;
	border-bottom: 1px solid #888888;
	border-left: 1px solid #BBBBBB;
	}
	</style>
	
	</head>
	
	<body>
	<%@ include file="util/mask.jsp" %>
		<!--標頭-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90%">
					<div class="FuncName">
						排程管理作業-影像資料匯入
					</div>
				</td>
			</tr>
		</table>
		<p></p>

		<!--<hr id='Main2' width='758'></hr>-->

		<s:form name="form1" id="form1" action="" cssClass="Form1">
			<div id="queryDiv">
    <table width="90%" align="center">
        <tr>
            <td>
			<fieldset>
            <legend>匯入條件</legend>
					
					
			<TABLE border=0 cellPadding=1 cellSpacing=1 width='70%' align="center">
				<TR style="HEIGHT: 30px">
					<TD  class='Label' width='40%'>
						<FONT id=lblFLDT>輸入日期︰</FONT>
						<input type="text" id="dataFileYear" name="dataFileYear" value=""
							size="4" maxlength="4" class='InputText'/>
						年
						<input type="text" id="dataFileMonth" name="dataFileMonth"
							value="" size="2" maxlength="2"  class='InputText'/>
						月
					<TD class='Label'>
						密碼:
						<input type="password" id="dataFilePassword"
							name="dataFilePassword" value="" size="20"  class='InputText' />
					</TD>
				</TR>
			</TABLE>
			
			</fieldset>
			
			</td></tr></table></div>
			
			
			
			<!--<hr id='Main2' width='758'></hr>-->

			<TABLE id=Main5 border=0 cellPadding=0 cellSpacing=0 align=center
				width=758>
				<TR>
					<!--<TD align=left width="33%">
						<A href="">
							<IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁">
						</A>
						<A href="">
							<IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層">
						</A>
					</TD>-->
					<TD align="center" width="33%">
						
						<!-- <input type="submit" name="importSubmit" value="匯入" id="importSubmit" >  -->
						<!--   <INPUT id=Confirm type=button tabindex=6 value="匯入" title="匯入" onclick="alert('已加入匯入排程')">-->
					</TD>
					<!--<TD align=right width="33%">
						<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />
					</TD>-->
				</TR>
			</TABLE>
			
			<table align="center" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<div class="FunctionArea">
							<input type="button" name="importButton" id="importButton" value="匯入" style='width:50px'/>
						</div>
					</td>
				</tr>
			</table>
			
		</s:form>
		
		
		
		
		
		
		
		
		<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
	</body>
</html>