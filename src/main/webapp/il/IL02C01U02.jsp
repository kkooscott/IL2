<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-勤區查察作業</title>
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   	
    <script type="text/javascript" src="js/myValidator.js"></script>
    <style type="text/css">
	#resultList td.sid {
		text-align: center;
  		vertical-align: middle;
	}
	em{
		color: red;
	}
	</style>
    <script type ="text/javascript" >
   	$(function() {	
		/**作業結果判斷(N:新增、E:修改、D:刪除、''為表單非執行結果、F:設定失敗)**/
		if("<s:property value='isFlag'/>"=="N"){
			$.alert.open("confirm", "新增成功");
		}else if("<s:property value='isFlag'/>"=="E"){
			$.alert.open("confirm", "修改成功");
		}else if("<s:property value='isFlag'/>"=="F"){
			$.alert.open("error", "系統發生錯誤，請洽系統管理員");
		}
	});//$(function() {
	
	/**更新作業**/
	function doUpdate(id){
		url="IL02C01U02Update.action";	
		/**Ajax**/
		$.ajax({
			type: "POST",
			url: url,
			data: {isFlag:'E',ilArcid:id,ilPstext:$("#ilPstext"+id).val()},
			success: function(result){				
				if(result=="true"){
					$.alert.open("confirm", "修改成功");
				}else{
					$.alert.open("error", "系統發生錯誤，請洽系統管理員");
				}
			}//success
		});//$.ajax		
    }
	</script>    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">外責區註記-資料顯示及登錄畫面</div>
		</td>
	</tr>
</table>

<!-- 查詢條件視窗 -->
<table width="90%" align="center" >
	<tr>
		<td>
			
		</td>
	</tr>
</table>
<!-- 表單區塊 -->
<div id="queryResult" style="width:100%;">
<form id="myForm" name="myForm" method="post" action="IL02A01U03.action">
    <table cellspacing="0" width="100%" id="ListTable" align="center" border='0'>
		<tr>
			<td width="25%" class="Label" style='text-align:left'><font size='3'>
			<s:date name="beginDate" format="yyyy年MM月dd日"/>
			至
			<s:date name="endDate" format="yyyy年MM月dd日"/></font>
			</td>                     
		</tr>	
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
				<input type="hidden" id="isFlag" name="isFlag" value="" /><!--作業結果判斷 -->
				<display:table id="resultList" name="iltb01MainList" pagesize="10" requestURI="IL02C01U02.action" decorator="tw.gov.npa.il.decorator.IL02C01U02Decorator" cellpadding="8" style="width:100%;border-collapse:collapse;">
					<display:column headerClass="First" class="Center sid id" property="ilArcno" title="外來人口統一證號" />
					<display:column class="Center" property="ilArccs" title="識別" />
					<display:column class="Center" property="ilArpzone" title="郵遞區號" />
					<display:column class="Center" property="ilAraddr" title="居留地址" />
					<display:column class="Center" property="ilPstext" title="外責區註記" style='text-align:center'/>
					<display:column class="Center" property="ilArctp" title="更新"  style='text-align:center'/>
				</display:table>								
					
				</div>
            </td>
        </tr>
    </table>
	
	
	<table align="center" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<div class="FunctionArea">
							
							<input type="button"
								onclick="javascript:location.href='IL02C01U01.action'" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
							<!--<input type="button" onclick="document.location='IL07C00M.action'" name="btnExit" value="離 開" id="btnExit" class="InputButton" />-->
						</div>
					</td>
				</tr>
			</table></form>
</div>
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL02000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL02C01U01.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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