<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <link id="total" type="text/css" href="js/pager/jquery.tablesorter.pager.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
	<script type="text/javascript" src="js/pager/jquery.tablesorter.pager.js"></script>
	<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />

	<script type="text/javascript">
	$(function() {	
		if(<s:property value ="allSize"/> >0){//若有資料, 才執行排序與分頁功能			
			$("#myTable").tablesorter({//-將回傳的table 排序與分頁
				widthFixed : true,
				widgets : ['zebra']
			}).tablesorterPager( {
				container : $("#pager"),
				positionFixed : false,
				size : 10
			});
		}	

	});//$(function() {
	
	//表單送出事件
	function onSubmit(){
		document.queryForm.submit();
	}
	</script>
 
</head>

<body>
<%@ include file="util/mask.jsp" %>
	<s:include value="util/actualSearchers.jsp"></s:include>
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color:#ACB8C6;">
	    <tr>
	        <td width="120" align="center"><img src="images/arrow.jpg" border="0" align="middle"/></td>
	        <td width="98%" class="pageTitle">外僑居留資料查詢(二)-資料選取畫面</td>
	    </tr>
	</table>
	<p></p>
	
	<HR width=758 />
	
	<s:form id="queryForm" action="IL03A01Q04">
		<!-- 日誌用開始 -->
		<input type="hidden" id="logcn" name="logcn" value="${logcn}" />
		<input type="hidden" id="logpstname" name="logpstname" value="${logpstname}" />
		<input type="hidden" id="main" name="main" value="${main}" />
		<input type="hidden" id="detail" name="detail" value="${detail}" />
		<!-- 日誌結束 -->
		<input type="hidden" id="oriUrlFlag" name="oriUrlFlag" value="IL03A01Q02A" />
	<table class="table table-striped" id="myTable" border=1 cellPadding=0 cellSpacing=0 align=center width=758 bgcolor=aqua style="border-bottom:none">
	  	<thead>
		    <tr>
		      <th align="center" width=60></th>
		      <th width=100>國籍</th>
		      <th width=90>護照號碼</th>
		      <th>英文姓名</th>
		      <th width=90>出生日期</th>
		    </tr>
	  	</thead>
	  	<tbody>
	  		<!-- 
		    <tr bgcolor=lightyellow>
		      <td><input name="ARCID" type="radio" value="">1</td>
		      <td>印尼</td>
		      <td>G299082</td>
		      <td>JAIDIN</td>
		      <td>1953/01/03</td>
		    </tr>
		    <tr bgcolor=lightcyan>
		      <td><input name="ARCID" type="radio" value="">2</td>
		      <td>印尼</td>
		      <td>A1844525</td>
		      <td>JAIDIN</td>
		      <td>1990/04/03</td>
		    </tr>
		     -->
		     
		     <s:iterator value="il02A01U02BeanList" id="il02A01U02Bean" status="count">
		     	<tr bgcolor=lightcyan>
			      <td>
			      	<s:if test="#count.count == 1">
			      		<input name="ARCID" type="radio" value="${il02A01U02Bean.IL_ARCID}" checked>${count.count}
			      	</s:if>
			      	<s:else>
			      		<input name="ARCID" type="radio" value="${il02A01U02Bean.IL_ARCID}">${count.count}
			      	</s:else>
			      	
			      </td>
			      <td>${il02A01U02Bean.NTNM}</td>
			      <td>${il02A01U02Bean.IL_PSPT}</td>
			      <td>${il02A01U02Bean.IL_ENM}</td>
			      <td>${il02A01U02Bean.IL_BTHDT}</td>
			    </tr>
			</s:iterator>
	  	</tbody>
	</table>	
	</s:form>
	
	<HR width=758 />

	<table border=0 cellPadding=0 cellSpacing=0 align=center width=758>
		<TR>
			<TD align=left width="33%">
				<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
				<A href="IL03A01Q01A.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A></TD>
			<TD align="center" width="53%">
				<div id="pager" class="pager">
					<form>
						<img src="images/btn_backward_01.gif" class="first" />
						<img src="images/btn_backward_02.gif" class="prev" /> 
						<input type="text" class="pagedisplay" style="width:65px;" readonly /> 
						<img src="images/btn_forward_02.gif" class="next" /> 
						<img src="images/btn_forward_01.gif" class="last" /> 
						<select id="pager_select" class="pagesize">
							<option value="10" selected="selected">10</option>
							<option value="20">20</option>
							<option value="50">50</option>
							<option value="100">100</option>
							<option value="${allSize}">所有資料</option>
						</select>
						<input id="Confirm" type="button" value="確定" title="確定" onclick="onSubmit();">
					</form>
				</div>	
			</TD>	
			<TD align=right width="33%">
				<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />
			</TD>
		</TR>
	</table>

</body>
</html>