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
    <title>居留外僑動態管理系統-勤區查察作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>  
    <script type="text/javascript" src="js/myValidator.js"></script>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <script type ="text/javascript" >
   	$(function() {
   		/**根據單位代碼代入**/
		getZipCode("<s:property value='e0UnitCd'/>");
		
		/**所屬警局改變時，重新變更郵遞區號**/
		$("#ilPst").change(function(){
			getZipCode($(this).val());
		});
	});//$(function() {
	
	/**取得郵遞區號內容 **/
	function getZipCode(e0UnitCd){	
		var url = "IL02C01U01G.action";
		/**Ajax**/
		$.ajax({
			type: "POST",
			url: url,
			//dataType: "text",
    		//contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {e0UnitCd:e0UnitCd, flag:"IL02C01U01"},
			success: function(result){	
				$("#zipCode").html(result);
			}//success
		});//$.ajax		
    }
	
	//表單送出事件
	function onSubmit(){	


		if($("#main")[0].selectedIndex==0){
			$.alert.open("warning", "請輸入查詢用途");
			return;
		}

		if($("#main")[0].selectedIndex==6&&$("#other").val()==""){
			$.alert.open("warning", "請輸入查詢用途");
			return;
		}
	
		if(myBestTrim(document.myForm.ilPst.value)==""){
			$.alert.open("warning", "管轄警局該欄 不可為空");
			document.myForm.ilPst.focus();
			return;
		}
		if(myBestTrim(document.myForm.ilZipCode.value)==""){
			$.alert.open("warning", "郵遞區號該欄 不可為空");
			document.myForm.ilZipCode.focus();
			return;
		}
		if(myBestTrim(document.myForm.txtBEGIN_DT.value)==""){
			$.alert.open("warning", "申請日期範圍起 不可為空");
			document.myForm.txtBEGIN_DT.focus();
			return;
		}
		if(myBestTrim(document.myForm.txtBEGIN_DF.value)==""){
			$.alert.open("warning", "申請日期範圍迄 不可為空");
			document.myForm.txtBEGIN_DF.focus();
			return;
		}

		document.myForm.submit();
	}
	</script>
    
</head>

<body onload='javascript:$("#main")[0].selectedIndex=0'>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">外責區註記-條件輸入畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗 -->  
<s:form id="myForm" action="IL02C01U02">
<input type="hidden" id="ilNtnm" name="ilNtnm" value="" />
<!-- -----------------委託查詢人-------------------------  -->
<s:action name="searcher" executeResult="true" namespace="/"></s:action>
<!-- -------------------------------------------------  -->
<div id="queryDiv">
	<table width="90%" align="center" >
		<tr>
			<td>
				<fieldset>
					<legend>查詢條件</legend>
					<s:if test="#session.usrFlagInfo==90||#session.usrFlagInfo==91||#session.usrFlagInfo==92||#session.usrFlagInfo==10||#session.usrFlagInfo==21||#session.usrFlagInfo==22">
						<table width="100%" style="align:center;">
							<tr>
								<td width="10%" class="Label">*管轄警局：</td>
								<td width="40%">
									<select id="ilPst" name="ilPst" class="InputSelect" >
										<s:iterator value="e0dtNpaunitList" var="result" status="count">							
											<option value="${result.e0UnitCd}">${result.e0UnitCd}${result.e0UnitSNm}</option>			
										</s:iterator>
									</select>			
								</td>
								<td width="10%" class="Label">*郵遞區號:</td>
								<td width="40%">
									<div id="zipCode"></div>			
								</td>                       
							</tr>					
							<tr>
								<td width="10%" class="Label">*申請日期範圍：</td>
								<td width="90%" colspan="3">
									<input name="txtBEGIN_DT" type="text" id="txtBEGIN_DT" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
	                                &nbsp;<img onclick="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
	                                	至
	                                <input name="txtBEGIN_DF" type="text" id="txtBEGIN_DF" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
	                                &nbsp;<img onclick="WdatePicker({el:'txtBEGIN_DF',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtBEGIN_DF',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
								</td>							                         
							</tr>
							<tr>
								<td width="10%" class="Label">外責區註記：</td>
								<td width="40%">
									<input id='ilPstext' name='ilPstext' maxlength='2' class="InputText" style="width:50px;" />
								</td>
								<td width="10%" class="Label"></td>
								<td width="40%">
									<input type="checkbox" id="ilArccs0" name="ilArccs" checked="checked" value="0" />外僑
									<input type="checkbox" id="ilArccs1" name="ilArccs" value="1" />外勞
								</td>                         
							</tr>		
						</table><br>
						
						
						
					</s:if>
					<s:else><br>　　單位代碼:${session.HTTP_LOGDID} 無使用權限！</s:else><br><br>
				</fieldset>
			</td>
		</tr>
	</table>
	<p></p>
	<div class="FunctionArea">				 	
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" onclick="onSubmit();" value="確 定" />
        <input type="reset" name="btnClear" id="btnClear" class="InputButton" value="清 除" />                   
    </div>	
</div>
<p></p>	
</s:form>
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL02000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL02000M.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
		</TD>
		<TD align="center" width="53%">	
		</TD>	
		<TD align=right width="33%">
			<s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />
		</TD>
	</TR>
</table> 
-->
	<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
</body>
</html>