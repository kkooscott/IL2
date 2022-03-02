<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%
if(session.getAttribute("LOGUID")==null||session.getAttribute("LOGUID").equals("")){
	response.sendRedirect("il/timeoutmsg.html");
}
%>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    
	<script type="text/javascript">
	$(function() {	
		/**報表產生**/	
		$("#btnQuery").click(function(){
			var filename = $('input[name=RPT]:checked').val();
			
			if(filename=="" || filename==null){
			
			}else if(filename=="6"){
				//alert($("#RPT2").val());
					window.open("./report/"+$("#RPT2").val());
				}else if(filename=="10"){
				//alert($("#RPT3").val());
					window.open("./report/"+$("#RPT3").val());
				}else if(filename=="13"){
				//alert($("#RPT4").val());
					window.open("./report/"+$("#RPT4").val());
				}else{
				//alert($('input[name=RPT]:checked').val());
					window.open("./report/"+$('input[name=RPT]:checked').val());
				}				
		});
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	
	//開新視窗顯示
	function MM_openBrWindow(theURL,winName,width,height,ReportKind) { //v2.0
		if($('input[name=ReportKind]:checked').val()==1){//UI測試時使用
			$.alert.open("warning", "未執行");
			return;
		}else if($('input[name=ReportKind]:checked').val()==6){
			$.alert.open("warning", "執行中");
			return;
		}
	
		var features= "status=no,location=no,resizable=yes,scrollbars=yes,top=0,left=200,width="+width+",height="+height;
		theURL = theURL+"?ReportKind="+$('input[name=ReportKind]:checked').val();
		window.open(theURL,winName,features);
	}
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">線上報表管理作業-要求報表顯示畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢結果視窗 -->
<s:form action="" theme="simple" id='myForm'>
<div id="queryResult" style="width:100%;">
    <table cellspacing="0" width="90%" id="ListTable" align="center">
        <tr>
            <td>		
				<display:table id="resultList" name="queryList" pagesize="10" requestURI="IL04D01P01.action" decorator="tw.gov.npa.il.decorator.IL04D01P01Decorator" cellpadding="8" style="width:100%;border-collapse:collapse;">
					<display:column headerClass="First" class="Center sid id" property="id" title="" style='text-align:center'/>
					<display:column class="Center" property="ilRptnm" title="報表名稱" />
					<display:column style='text-align:center' class="Center" property="ilSnddt" title="要求日期時間" />
					<display:column style='text-align:center' class="Center" property="ilStatus" title="執行狀態" />
				</display:table>
            </td>
        </tr>
    </table>
</div>
<!--  
<div id="queryResult" style="width:100%;">
<table cellspacing="0" width="90%" id="ListTable"  align="center">
	<tr>
		<td>
        <div>
			<table class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
				<thead>
					<tr>
						<th class="First" scope="col">序號</th>
                        <th scope="col">報表名稱</th>
                        <th scope="col">要求日期時間</th>
                        <th scope="col">執行狀態</th>
                        <th scope="col">報表總數</th>						
					</tr>
				</thead>
				<tbody>
					<tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_01_20138.xls" checked>1</TD>
						<td>自由檢索報表－按國籍及職業分</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_02_20138.xls">2</TD>
						<td>自由檢索報表－按國籍及區域分</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_03_20138.xls">3</TD>
						<td>自由檢索報表－按職業及區域分</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_04_20138.xls">4</TD>
						<td>按居留目的及職業分</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_05_20138.xls">5</TD>
						<td>按居留目的及區域分</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_06_20138.xls">6</TD>
						<td>按國籍及居留目的分</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04B01_07_20138.xls">7</TD>
						<td>外僑持續居留年限統計報表</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>
			        <tr class="odd">
						<td><input type="radio" id="RPT" name="RPT" value="IL04C01_01_20138.txt">8</TD>
						<td>自由檢索報表(無固定欄項)</TD>
						<td><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
						<td>完成</td>
						<td>1</td>
			        </tr>									
				</tbody>				
			</table>
		</div>
		</td>
	</tr>
</table>
-->				
</div><!--<div id="queryResult" style="width:100%;">-->
	<center>
    <div class="FunctionArea">				 	
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" value="確定" />                    
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