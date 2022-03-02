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
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>  
    <script type="text/javascript" src="js/myValidator.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
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
		
		var e0UnitCd2=e0UnitCd;
		
		if(e0UnitCd2=='AE000'){
			e0UnitCd2='BE000';
		}
		
		var url = "IL02C01U01G.action";
		/**Ajax**/
		$.ajax({
			type: "POST",
			url: url,
			//dataType: "text",
    		//contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			data: {e0UnitCd:e0UnitCd2, flag:"IL03B01P00"},
			success: function(result){	
				$("#zipCode").html(result);
			}//success
		});//$.ajax		
    }
	
	//表單送出事件
	function onSubmit(){		
		if(myBestTrim(document.myForm.ilPst.value)==""){
			$.alert.open("warning", "警局名稱該欄 不可為空");
			document.myForm.ilPst.focus();
			return;
		}
		if(myBestTrim(document.myForm.ilZipCode.value)==""){
			$.alert.open("warning", "郵遞區號該欄 不可為空");
			//document.myForm.ilZipCode.focus();
			return;
		
		}
		
		
		
		for(i=0;i<document.myForm.ilZipCode.options.length;i++){
			if(document.myForm.ilZipCode.options[i].selected==true){
				
				$("#ilZipCodeList").val($("#ilZipCodeList").val()+"'"+document.myForm.ilZipCode.options[i].value+"',");
				$("#ilZipFullNameList").val($("#ilZipFullNameList").val()+document.myForm.ilZipCode.options[i].text+",");		
			}
			
		}
		
		$("#ilZipCodeList").val($("#ilZipCodeList").val().substring(0,$("#ilZipCodeList").val().length-1));
		$("#ilZipFullNameList").val($("#ilZipFullNameList").val().substring(0,$("#ilZipFullNameList").val().length-1));
		
		$('#ilZipCodeName').val(document.myForm.ilZipCode.options[document.myForm.ilZipCode.selectedIndex].text);
		
		
		
		
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
			<div class="FuncName">轄區狀況統計資料-條件輸入畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗 -->  
<s:form id="myForm" action="IL03B01P01">
<!-- -----------------委託查詢人-------------------------  -->
<!--<s:action name="searcher" executeResult="true" namespace="/"></s:action>-->
<!-- -------------------------------------------------  -->
<div id="queryDiv">
	<table width="90%" align="center" >
		<tr>
			<td>
				<fieldset>
					<legend>查詢條件</legend>
					<table width="100%" style="align:center;">
						<tr>
							<td width="10%" class="Label">*警局名稱︰</td>
							<td width="40%">
								<select id="ilPst" name="ilPst" class="InputSelect" >
									<s:iterator value="e0dtNpaunitList" var="result" status="count">							
										<option value="${result.e0UnitCd}">${result.e0UnitCd}${result.e0UnitSNm}</option>			
									</s:iterator>
								</select>			
							</td>
						</tr>
						<tr>
							<td width="10%" class="Label">*郵遞區號:</td>
							<td width="40%">
								<div id="zipCode"></div>			
							</td>                       
						</tr>					
						<tr>
							<td width="10%" class="Label">外責區註記：</td>
							<td width="40%">
								<input id='ilPstext' name='ilPstext' maxlength='2' class="InputText" style="width:50px;" />
							</td>                       
						</tr>		
					</table>					
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
<input type='hidden' name='ilZipCodeName' id='ilZipCodeName'>
<input type='hidden' name='ilZipCodeNameList' id='ilZipCodeNameList'>
<input type='hidden' name='ilZipCodeList' id='ilZipCodeList'>
<input type='hidden' name='ilZipFullNameList' id='ilZipFullNameList'>
</s:form>
<!--<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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