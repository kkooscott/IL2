<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>功能清單維護</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" />
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" /> 
    <script type="text/javascript" src="js/jquery-1.8.3.js"/>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript" src="js/myValidator.js"></script>
    <script type="text/javascript">
	$(function() {
		/**取消事件**/
		$("#btnCancel").click(function(){
			var url = "IL09B01Query.action";
			document.queryForm.action=url;
        	document.queryForm.submit();	
		});
		
		/**新增事件**/
		$("#btnSave").click(function(){
			if(myBestTrim(document.myForm.ilFunc.value)==""){
				window.alert("功能代號不可為空 !!!");
				document.myForm.ilFunc.focus();
				return;
			}
			if(myBestTrim(document.myForm.ilStepname.value)==""){
				window.alert("功能名稱不可為空 !!!");
				document.myForm.ilStepname.focus();
				return;
			}
			if(myBestTrim(document.myForm.ilStepurl.value)==""){
				window.alert("功能網址不可為空 !!!");
				document.myForm.ilStepurl.focus();
				return;
			}
			
			var url = "IL09B01New.action";
			document.myForm.isFlag.value="N";
			document.myForm.action=url;
        	document.myForm.submit();	
		});
		
		/**作業結果判斷(N:新增、E:修改、D:刪除、''為表單非執行結果、F:設定失敗)**/
		if("<s:property value='isFlag'/>"=="N"){
			alert("新增完成");
		}else if("<s:property value='isFlag'/>"=="E"){
			alert("修改成功");
		}else if("<s:property value='isFlag'/>"=="F"){
			alert("系統發生錯誤，請洽系統管理員");
		}else{
			//alert("正常執行");//test
		}
	});//$(function() {	   
    </script>
</head>

<body>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">功能清單維護-新增</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 表單區塊 -->
<s:form id="myForm" action="">
<input type="hidden" id="ilModuid" name="ilModuid" value="" /><!--異動人員帳號-->
<input type="hidden" id="isFlag" name="isFlag" value="" /><!--作業結果判斷 -->
<div id="queryResult">
	<table width="90%" align="center">
		<tr>
			<td>
			<fieldset>
				<legend>公告資料</legend>
				<table width="100%">			
					<tr>
						<td width="10%" class="Label">功能代號</td>
						<td width="40%">
							<input type="text" name="ilFunc" id="ilFunc" class="InputText" style="width:300px;" />
						</td>
						<td width="10%" class="Label">功能名稱</td>
                        <td width="40%">
							<input type="text" name="ilStepname" id="ilStepname" class="InputText" style="width:300px;" />
						</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">功能網址</td>
						<td width="40%">
							<input type="text" name="ilStepurl" id="ilStepurl" class="InputText" style="width:300px;" />
						</td>
						<td width="10%" class="Label">功能群組</td>
                        <td width="40%">
                        	<select name="ilIndexid" id="ilIndexid" class="InputSelect">
                        	<s:iterator value="iltbSystemFlowStepConfigList" id="set" status="count">                       		
								<option value="${set.ilIndexid}">${set.ilStepname}</option>
                        	</s:iterator>
                        	</select>                      
						</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">功能停用</td>
						<td width="40%">
							<select name="ilFuncDisable" id="ilFuncDisable" class="InputSelect">
								<option value="1">啟用</option>
								<option value="0">停用</option>							
							</select>
						</td>
						<td width="10%" class="Label"></td>
                        <td width="40%">				
						</td>							
					</tr>						
				</table>
			</fieldset>
			</td>
		</tr>
	</table>
    <table align="center" cellspacing="0" cellpadding="0" width="90%">
        <tr>
            <td style="text-align: right;">
                <div class="FunctionArea">
                    <input type="button" name="btnSave" id="btnSave" class="InputButton" value="儲 存" />
                    <input type="button" name="btnCancel" id="btnCancel" class="InputButton" value="取 消" />
                </div>
            </td>
        </tr>
    </table>
</div>
</s:form>

<s:form id="queryForm" action="">
<!-- 看要塞啥Hidden值吧~ 
	<input type="hidden" id="ilFuncNo" name="ilFuncNo" value="" />
	<input type="hidden" id="ilFuncDisable" name="ilFuncDisable" value="" />
-->
</s:form>
</body>
</html>
