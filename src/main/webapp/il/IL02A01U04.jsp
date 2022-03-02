<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>查察記事-明細內容顯示畫面</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>	
    <script type="text/javascript" src="js/myValidator.js"></script>
    <script type="text/javascript" src="js/jquery.jqprint.js" ></script>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
	<script type="text/javascript">
	$(function() {	
		/**新增事件**/
		$("#btnSave").click(function(){
			if(myBestTrim(document.myForm.ilPtrldt.value)==""){
				$.alert.open("warning", "查察日期不可為空");
				document.myForm.ilPtrldt.focus();
				return;
			}
			
			var url = "IL02A01U04New.action";
			document.myForm.isFlag.value="N";
			document.myForm.action=url;
        	document.myForm.submit();	
		});
		
		/**列印事件**/
        $("#print").click(function() {
              $("#ListTable").jqprint();
        });
		
		/**作業結果判斷(N:新增、E:修改、D:刪除、''為表單非執行結果、F:設定失敗)**/
		if("<s:property value='isFlag'/>"=="N"){
			$.alert.open("confirm", "新增成功");
		}else if("<s:property value='isFlag'/>"=="E"){
			$.alert.open("confirm", "修改成功");
		}else if("<s:property value='isFlag'/>"=="F"){
			$.alert.open("error", "系統發生錯誤，請洽系統管理員");
		}
	});
	
	//表單送出事件
	function onSubmit(){
		document.myForm.submit();
	}
	
	/**更新作業**/
	function doUpdate(url,id,count){	
		/**Ajax**/
		$.ajax({
			type: "POST",
			url: url,
			data: {isFlag:'E',ilArcid:id,ilPtrldt:$("#txtBEGIN_DT"+count).val(),ilPtrldtOri:$("#txtBEGIN_DTOri"+count).val(),ilPtrlst:$("#ilPtrlst"+count).val(),ilPtrlmrk:$("#ilPtrlmrk"+count).val(),ilUid:$("#ilUid").val(),ilUnm:$("#ilUnm").val(),ilMantype:$("#ilMantype"+count).val()},
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
			<div class="FuncName">查察記事-資料輸入畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗 -->

<!-- 表單區塊 -->
<s:form id="myForm" action="">
<!-- 日誌用開始 -->
<input type="hidden" id="logcn" name="logcn" value="${logcn}" />
<input type="hidden" id="logpstname" name="logpstname" value="${logpstname}" />
<input type="hidden" id="main" name="main" value="${main}" />
<input type="hidden" id="detail" name="detail" value="${detail}" />
<!-- 日誌結束 -->
<input type="hidden" id="ilArcid" name="ilArcid" value="${ilArcid}" />
<input type="hidden" id="ilEnm" name="ilEnm" value="${ilEnm}" />
<input type="hidden" id="ilArcno" name="ilArcno" value="${ilArcno}" />
<input type="hidden" id="ilUid" name="ilUid" value="T0001" /><!--註記者代號--><!-- 要再轉 -->
<input type="hidden" id="ilUnm" name="ilUnm" value="TestMan" /><!--註記者姓名--><!-- 要再轉 -->
<input type="hidden" id="isFlag" name="isFlag" value="" /><!--作業結果判斷 -->
<!-- 查詢結果視窗 -->
<div id="queryResult" style="width:100%;">

<table width="90%" align="center" >
	<tr>
		<td>
			<table class="ListTable" width="100%" style="align:center;">
				<tr>
					<td width="10%" class="Label">英文姓名：${ilEnm}</td>
					<td width="40%"></td> 
					<td width="10%" class="Label">外來人口統一證號：${ilArcno}</td>
					<td width="40%"></td>                     
				</tr>											
			</table>
		</td>
	</tr>
</table>

<table cellspacing="0" width="90%" id="ListTable"  align="center">
	<tr>
		<td>
        <div>
			<table class="ListTable" cellspacing="0" cellpadding='3' rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
				<thead>
					<tr>
						<th class="First" scope="col" style='width:3%;' ></th>
                        <th scope="col">查察日期</th>
                        <th scope="col">查察結果</th>
                        <th scope="col">人口分類</th>
                        <th scope="col" >查察記事</th>
                        <th scope="col">確定</th>	                       					
					</tr>
				</thead>
				<tbody>
				<tr id="trNew" class="even">		                
					<td class="Center" style='text-align:center'>1</td>
					<td class="Center">
					<table><tr><td>
						<input name="ilPtrldt" type="text" id="ilPtrldt" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
                        </td><td>
						&nbsp;<img onclick="WdatePicker({el:'ilPtrldt',dateFmt:'yyyy-MM-dd'})" onfocus="WdatePicker({el:'ilPtrldt',dateFmt:'yyyy-MM-dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />							
						</td></tr></table>
					</td>
					<td class="Center">
						<SELECT id="ilPtrlst" name="ilPtrlst" class="InputSelect">
							<OPTION value="1" selected>1 該僑確住該址</OPTION>
							<OPTION value="2">2 該僑未住該址</OPTION>
							<OPTION value="3">3 查無該址</OPTION>
							<OPTION value="4">4 其它</OPTION>
						</SELECT>
					</td>
					<td class="Center">
						<SELECT id="ilMantype" name="ilMantype" class="InputSelect">
							<OPTION value="0" selected></OPTION>
							<OPTION value="A">A 治安顧慮人口</OPTION>
							<OPTION value="B">B 注意訪查人口</OPTION>
							<OPTION value="C">C 無顧慮人口</OPTION>
							<OPTION value="D">D 可供諮詢友善人口</OPTION>
						</SELECT>
					</td>
					<td class="Center" >
						<input id='ilPtrlmrk' name='ilPtrlmrk' maxlength='200' class="InputText" style="width:98%;" value="" />
					</td>	
					<td class="Center">
						<input type="button" name="btnSave" id="btnSave" class="InputButton" value="新增"/>	
					</td>												
				</tr>
							
				<s:iterator value="iltb04InRecordList" var="result" status="count">	
					<tr id="tr${count.count+1}">		                
						<td class="Center"  style='text-align:center'>${count.count+1}</td>
						<td class="Center">
							<table><tr><td>
							<input id="txtBEGIN_DTOri${count.count+1}" name="txtBEGIN_DTOri${count.count+1}" type="hidden" value="<s:date name='#result.id.ilPtrldt' format='yyyy-MM-dd'/>" />
							</td><td>
							<input name="txtBEGIN_DT${count.count+1}" type="text" id="txtBEGIN_DT${count.count+1}" class="InputText" size="10" value="<s:date name='#result.id.ilPtrldt' format='yyyy-MM-dd'/>" disabled />                            
							</td></tr></table>
						</td>
						<td class="Center">
							<SELECT id="ilPtrlst${count.count+1}" name="ilPtrlst${count.count+1}" class="InputSelect">
								<OPTION value="1" selected>1 該僑確住該址</OPTION>
								<OPTION value="2">2 該僑未住該址</OPTION>
								<OPTION value="3">3 查無該址</OPTION>
								<OPTION value="4">4 其它</OPTION>
							</SELECT>
							<script type="text/javascript">				
							$("#ilPtrlst${count.count+1}").children().each(function() {
								if($(this).val()=='<s:property value ="#result.ilPtrlst"/>'){
									//jQuery給法
									$(this).attr("selected" ,"true" ); //或是給selected也可
								}
							});
							</script>
						</td>
						<td class="Center">
							<SELECT id="ilMantype${count.count+1}" name="ilMantype${count.count+1}" class="InputSelect">
								<OPTION value="0" selected></OPTION>
								<OPTION value="A">A 治安顧慮人口</OPTION>
								<OPTION value="B">B 注意訪查人口</OPTION>
								<OPTION value="C">C 無顧慮人口</OPTION>
								<OPTION value="D">D 可供諮詢友善人口</OPTION>
							</SELECT>
							<script type="text/javascript">				
							$("#ilMantype${count.count+1}").children().each(function() {
								if($(this).val()=='<s:property value ="#result.ilMantype"/>'){
									//jQuery給法
									$(this).attr("selected" ,"true" ); //或是給selected也可
								}
							});
							</script>
						</td>
						<td class="Center" width="55%">
							<input type="text" id="ilPtrlmrk${count.count+1}" class="InputText" name="ilPtrlmrk${count.count+1}" maxlength="200" style="width:98%;" value="<s:property value='#result.ilPtrlmrk.trim()'/>" />							
						</td>	
						<td class="Center">
							<input type="button" name="btnUpdate" id="btnUpdate" class="InputButton" onclick="doUpdate('IL02A01U04Update.action','<s:property value ='#result.id.ilArcid'/>','${count.count+1}');" value="更新"/>	
						</td>												
					</tr>							              
	                <!-- 表格隔行換色處理 -->	                
	                <s:if test="%{#count.count%2!=1}">
	                	<script type="text/javascript">$("#tr${count.count+1}").addClass("even");</script>
	                </s:if>
	                <s:if test="%{#count.count%2==1}">
	                	<script type="text/javascript">$("#tr${count.count+1}").addClass("odd");</script>
	                </s:if>
				</s:iterator>													
				</tbody>				
			</table>
		</div>
		</td>
	</tr>
</table>
<div class="FunctionArea">				 	
	<input type="button" name="print" id="print" class="InputButton" value="列印" />    
</div>
</div><!--<div id="queryResult" style="width:100%;">-->
</s:form>



<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL02000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL02A01U03.action?ilArcid=${ilArcid}"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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