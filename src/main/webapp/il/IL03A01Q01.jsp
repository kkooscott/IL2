<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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
    <link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/domtab.css" />
	<link rel="stylesheet" type="text/css" href="css/e8.css" />
	<style type="text/css">
		.inputTB .Label{
			width:10%;
		}
		.inputTB .dateDesc{
			vertical-align: middle;
		}
	</style>
	
    <script src="js/jquery-1.8.3.js"></script>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />	
    
    
    <script type ="text/javascript" >
	
	$.ajax({
			type: "POST",
			url: "il/util/clearCond.jsp",	
			success: function(text){				
			},
			error:function(){
				$.alert.open("warning", "系統發生錯誤，請洽系統管理員");
			}
		});//$.ajax	
	
	
	function toSubmit() {
		
		
		
    	var errMsg = "";

 		var counts = 0;
	     
		$("table.inputTB input").each(function() {
		     if($(this).val() !== "") {
		      counts += 1;
		     }
		});

		// 特殊身份為行方不明時不限制，特殊身份為其它時自動增加管轄警局條件
		var ilphq = $('#ilphq').val();
		// 怕value值會改變改抓text
		var srchst = $("#SRCHST option:selected").text();
	
		// 用途未輸入
	    if($("#main")[0].selectedIndex == 0 || $("#main")[0].selectedIndex == 6 && $("#other").val() == "") {
	    	errMsg+="請輸入查詢用途及";
	    }
	
	    // 主要查詢條件未輸入
		if($("#ilArcno").val()=="" && $("#ilPspt").val()=="" && $("#ilEnm").val()=="" && $("#ilCnm").val()=="" && $("#ilOfnm").val()=="" && $("#ilRepmdc").val()=="" && $("#ilMicro").val()=="" && $("#txtBTHD").val()=="" && $("#ilRepmdcNic").val()=="" && $("#ilPhq").val()==""){
	  	  errMsg+="至少輸入一項主要查詢條件及";
		}
	
		if($("#ilArcno").val()=="" && $("#ilPspt").val()=="" && $("#ilEnm").val()=="" && $("#ilCnm").val()=="" && $("#ilOfnm").val()=="" && $("#ilRepmdc").val()=="" && $("#ilMicro").val()=="" && $("#txtBTHD").val()=="" && $("#ilRepmdcNic").val()=="" && $("#ilPhq").val()!="") {
		   	if(srchst != "行方不明" && srchst != "" && ($("#ilPhq").val() != $("#LOGPHQ").val())) {
	     		errMsg+="警分局代碼請填入自身機關代碼及";
		   }
		}
	  
		if(errMsg != "") {
	 		errMsg = errMsg.substr(0, (errMsg.length-1));
		    $.alert.open('warning', errMsg);
		 	return;
		}else {
		 mergeSelectedARCST();
		 mergeSelectedOP();
		 mergeSelectedNT();
		 mergeSelectedEDU();
		$('#queryBtn').prop('disabled', true);   
		 document.form1.action = "IL03A01Q02.action";
		 document.form1.submit();
		}
	}
		
	
	function mergeSelectedARCST() {
		for (i = 0; i < document.form1.ARCST.options.length; i++) {
			if (document.form1.ARCST.options[i].selected == true) {

				$("#ARCST_LIST")
						.val(
								$("#ARCST_LIST").val()
										+ "'"
										+ document.form1.ARCST.options[i].value
										+ "',");

			}

		}

		$("#ARCST_LIST").val(
				$("#ARCST_LIST").val().substring(0,
						$("#ARCST_LIST").val().length - 1));


	}

	function mergeSelectedOP() {
		for (i = 0; i < document.form1.OP.options.length; i++) {
			if (document.form1.OP.options[i].selected == true) {

				$("#OP_LIST").val(
						$("#OP_LIST").val() + "'"
								+ document.form1.OP.options[i].value + "',");

			}

		}

		$("#OP_LIST").val(
				$("#OP_LIST").val()
						.substring(0, $("#OP_LIST").val().length - 1));


	}

	function mergeSelectedNT() {
		for (i = 0; i < document.form1.NT.options.length; i++) {
			if (document.form1.NT.options[i].selected == true) {

				$("#NT_LIST").val(
						$("#NT_LIST").val() + "'"
								+ document.form1.NT.options[i].value + "',");

			}

		}

		$("#NT_LIST").val(
				$("#NT_LIST").val()
						.substring(0, $("#NT_LIST").val().length - 1));

	}

	function mergeSelectedEDU() {
		for (i = 0; i < document.form1.EDU.options.length; i++) {
			if (document.form1.EDU.options[i].selected == true) {

				$("#EDU_LIST").val(
						$("#EDU_LIST").val() + "'"
								+ document.form1.EDU.options[i].value + "',");

			}

		}

		$("#EDU_LIST").val(
				$("#EDU_LIST").val().substring(0,
						$("#EDU_LIST").val().length - 1));
	}
	</script>
</head>

<body onload='javascript:$("#main")[0].selectedIndex=0'>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tbody>
			<tr>
				<td width="90%">
					<div class="FuncName">外僑居留資料查詢-條件輸入畫面</div>
				</td>
			</tr>
		</tbody>
	</table>

	<form id="form1" name="form1" method="post" class="Form1">
	
	<script type="text/javascript">
			$(function() {
				function getDetail(main) {
					if (main == '') {
						return false;
					}
					var url = "getDetails.action";
					$.ajax({
						url : url,
						type : 'post',
						data : {
							'main' : main
						},
						success : setDetails,
						dataType : "json"
					});
				}
				;

				function setDetails(json) {
					var str = "";

					$.each(json.details, function(i, detail) {
						str = str + "<option value=\"" + i + "\">" + detail
								+ "</value>"
					});

					$("select#detail").find('option').remove().end()
							.append(str);
				}

				$('#main').change(function() {
					var main = $("#main").val();
					if (main == '600') {
						$("#other").show();
						$("#detail").hide();
					} else if (main == '') {
						$("#other").hide();
						$("#detail").hide();
					} else {
						getDetail(main);
						$("#other").hide();
						$("#detail").show();
					}
				});
			});
		</script>
		
		
		<!-- -----------------委託查詢人-------------------------  -->
		<s:action name="searcher" executeResult="true" namespace="/"></s:action>
		<!-- -------------------------------------------------  -->
		<%@ include file="util/mask.jsp" %>
		<table class="inputTB" width="90%" align="center">
		<tbody>
			<tr>
				<td>
					<fieldset>
						<legend>
							主要查詢條件(多筆條件以逗號分隔)<font color='red'>*(擇一必填)</font>
						</legend>
						<table width="100%">
							<tbody>
								<tr>
										<td class="Label" width="5%">外來人口統一證號：</td>
										<td width="25%"><input id="ilArcno" name="ilArcno"
											tabindex="1" class="InputText" style="WIDTH: 200px" value="">(多筆輸入請以「,」隔開)
										</td>
										<td class="Label" width="5%">護照號碼：</td>
										<td width="25%"><input id="ilPspt" name="ilPspt"
											maxlength="250" tabindex="2" class="InputText"
											style="WIDTH: 150px" value="">(多筆輸入請以「,」隔開)</td>
									</tr>
									<tr>
										<td class="Label" width="5%">服務處所：</td>
										<td width="25%"><input id="ilOfnm" name="ilOfnm"
											maxlength="48" tabindex="5" class="InputText"
											style="WIDTH: 350px" value=""></td>
											<TD align="left" id=lblBTHDT class='Label'>出生日期：</TD>
										<TD width='350'><input name="txtBTHD" type="text"
											id="txtBTHD" class="InputText" size="10"
											onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
											onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" /> &nbsp;<img
											onclick="WdatePicker({el:'txtBTHD',dateFmt:'yyyy/MM/dd'})"
											onfocus="WdatePicker({el:'txtBTHD',dateFmt:'yyyy/MM/dd'})"
											tabindex="2" src="images/calendar.gif" alt="選擇日期" /></TD>
									</tr>
									<tr>
										<td class="Label">中文姓名：</td>
										<td><input id="ilCnm" name="ilCnm" maxlength="12"
											tabindex="4" class="InputText" style="WIDTH: 100px" value="">
										</td>
										<td class="Label">英文姓名：</td>
										<td><input id="ilEnm" name="ilEnm" maxlength="50"
											tabindex="3" class="InputText" style="WIDTH: 250px" value="">
										</td>
										<!--
										<td class="Label" width="5%">出生日期：</td>
										<td width="25%"><input id="ilBirth" name="ilBirth" 
											type="text" class="InputText" style="WIDTH: 100px" size="10"
											placeholder="(1900/01/XX)"> &nbsp;<img
											onclick="WdatePicker({el:'ilBirth',dateFmt:'yyyy/MM/dd'})"
											onfocus="WdatePicker({el:'ilBirth',dateFmt:'yyyy/MM/dd'})"
											tabindex="2" src="images/calendar.gif" alt="選擇日期"
											style="vertical-align: middle;"></td>
										-->
									</tr>
									<tr>
										
										<td width="5%" class="Label">重入國許可證號(6位)：</td>
										<td width="40%">
											<input id='ilRepmdc' name='ilRepmdc' maxlength='6' class="InputText" />
										</td> 
										<td width="5%" class="Label">重入國許可證號(10位)：</td>
										<td width="40%">
											<input id='ilRepmdcNic' name='ilRepmdcNic' maxlength='10' class="InputText" />
										</td>
									</tr>
									<tr>
										<td width="5%" class="Label">縮影編號：</td>
										<td width="40%">
											<input id='ilMicro' name='ilMicro' maxlength='10' class="InputText" />
										</td>
										<td class="Label">警局代碼：</td>
										<td>
											<!-- <input id="ilPhq" name="ilPhq" type="text" class="InputText" style="flex: 1 0 10%"/> -->
											<%-- <select id="e0dtUintSelect" name="e0dtUintSelect" tabindex=12 class='InputText' multiple size='5'> --%>	
											<input id="ilPhq" name="ilPhq" list="e0dtUints" class="InputText" /> 
											<datalist id="e0dtUints">
												<s:iterator value="e0dtUints" var="e0dtUint" status="count">
												<option value="${e0dtUint.e0UnitCd}">${e0dtUint.e0UnitCd} ${e0dtUint.e0UnitNm}</option>	
											</s:iterator>
											</datalist>
											
											
											<%-- </select> --%>
										<%-- <select id="ilPhq" name="ilPhq" tabindex="6">
												<option value="" selected=""></option>
												<option value="AB000">AB000-台中市</option>
												<option value="AC000">AC000-台南市</option>
												<option value="AD000">AD000-新北市</option>
												<option value="AV000">AV000-高雄市</option>
												<option value="AW000">AW000-台北市</option>
												<option value="AE000">AE000-桃園市</option>
												<option value="BA000">BA000-基隆市</option>

												<option value="BF000">BF000-新竹市</option>
												<option value="BG000">BG000-新竹縣</option>
												<option value="BH000">BH000-苗栗縣</option>
												<option value="BJ000">BJ000-彰化縣</option>
												<option value="BK000">BK000-南投縣</option>
												<option value="BL000">BL000-雲林縣</option>
												<option value="BM000">BM000-嘉義市</option>
												<option value="BN000">BN000-嘉義縣</option>
												<option value="BQ000">BQ000-屏東縣</option>
												<option value="BR000">BR000-台東縣</option>
												<option value="BS000">BS000-花蓮縣</option>
												<option value="BT000">BT000-宜蘭縣</option>
												<option value="BU000">BU000-澎湖縣</option>
												<option value="BY000">BY000-金門縣</option>
												<option value="BZ000">BZ000-連江縣</option>
										</select> --%></td>
									</tr>
									<!-- <tr>
										<TD align="left" width=160 class='Label'><font color='red'>*</font>管轄警局：</TD>
										<TD >
											<INPUT id=PHQPST name=PHQPST maxlength=5 tabindex=1 style="WIDTH:50px" value="" class='InputText'>
											<LABEL id=lblPHQPST></LABEL>
										</TD>
									</tr> -->
							</tbody>
						</table>
					</fieldset>
					<br>
					<fieldset>
						<legend>
							輔助查詢條件
						</legend>
						<table width="100%" style="align:center;">
								<tbody>
									<tr>
										<td width="5%" class="Label" align="left">特殊身份：</td>
										<td width="30%" colspan=3>
										<select id="SRCHST" name="SRCHST" tabindex=15 class='InputText'>					
										<option value=""></option>
										<s:iterator value="srchstCodes" var="srchstCode" status="count">
											<option value="${srchstCode.SRCHST}">${srchstCode.SRCHSTNM}</option>	
										</s:iterator>
										</select>
											<%-- <select id=SRCHST name=SRCHST class="InputText">
												<option value="" selected=""></option>
												<option value=00>無特殊身份</option>
												<option value=31>行方不明</option>
												<option value=32>取消協尋通報</option>
												<option value=33>查獲或收容</option>
												<option value=34>取消查獲通報</option>
												<option value=35>收容費預墊</option>
												<option value=36>取消預墊通報</option>
												<option value=37>外勞回原雇主撤銷協尋(勞委會)</option>
											</select> --%>
										</td>
								<td width="5%" class="Label" align="left">
									工作許可日期：
								</td>
								<td width="10%" colspan=1>
									<input id="ilJbpmdt" name="ilJbpmdt" type="text" class="InputText" style="WIDTH:100px" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
	                                &nbsp;<img onclick="WdatePicker({el:'ilJbpmdt',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'ilJbpmdt',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" style="vertical-align: middle;" />
									
								</td>
								<td width="3%" class="Label" align="left">
									文號：
								</td>
								<td width="45%" colspan=4>
									<input id="ilJbpmdc" name="ilJbpmdc" maxlength="10" tabindex="10" class="InputText" style="WIDTH:100px" value="">
								</td>
							</tr>
							<tr>
								<TD align="left" width="5%"  id=lblPSTEXT class='Label'>外責區：</TD>
								<TD  width="30%" colspan=3><INPUT id=PSTEXT name=PSTEXT maxlength=2 tabindex=2 style="WIDTH:38px" value="" class='InputText'></TD>
								<TD align="left" width="5%" class='Label'>性別：</TD>
								<TD width="10%" colspan=1>
									<SELECT id=SEX name=SEX tabindex=9 class='InputText'>
										<OPTION value=""></OPTION>
										<OPTION value=1 >男</OPTION>
										<OPTION value=2 >女</OPTION>
									</SELECT>
								</TD>
								<TD align="left" width="5%" valign=top class='Label'>就讀學校：</TD>
								<TD width="45%" colspan=4>
									<!-- <LABEL id=lblUV></LABEL>
									<INPUT id=btnUV type=button value=查詢 tabindex=15 title=查詢>-->
									<select id="UV" name="UV" tabindex=15 class='InputText'>					
										<option value=""></option>
										<s:iterator value="schoolCodes" var="schoolCode" status="count">
											<option value="${schoolCode.ilUvcd}">${schoolCode.ilUvcd} ${schoolCode.ilUvcnm}</option>	
										</s:iterator>									
									</select>
								</TD>
							</tr>
							<tr>
								<TD  width="5%" align="left" valign=top class='Label'>職業：<br>(可複選)&nbsp;&nbsp;&nbsp;&nbsp;</TD>
								<TD  width="30%" colspan=3>
									<!-- <LABEL id=lblOP></LABEL>
									<INPUT id=btnOP type=button value=查詢 tabindex=12 title=查詢 />-->
									<select id="OP" name="OP" tabindex=12 class='InputText' multiple size='5'>				
										<option value=""></option>
										<s:iterator value="jobCodes" var="jobCode" status="count">
											<option value="${jobCode.ilOpcd}">${jobCode.ilOpcd} ${jobCode.ilOpnm}</option>	
										</s:iterator>									
									</select>
									
									<script typr='text/javascript'>
									document.getElementById("OP").removeChild(document.getElementById("OP").options[0] )
									</script>
									
									<input type='hidden' id='OP_LIST' name='OP_LIST'> 
									
								</TD>
								<TD align="left" width="5%" valign=top class='Label'>國籍：<br>(可複選)&nbsp;&nbsp;&nbsp;&nbsp;</TD>
								<TD width="10%" colspan=1>
									<!-- <LABEL id=lblNT></LABEL>
									<INPUT id=btnNT type=button value=查詢 tabindex=13 title=查詢 /> -->
									<select id="NT" name="NT" tabindex=13 class='InputText' multiple size='5'>					
										<option value=""></option>
										<s:iterator value="countryCodes" var="countryCode" status="count">
											<option value="${countryCode.ilNtcd}">${countryCode.ilNtcd} ${countryCode.ilNtnm}</option>	
										</s:iterator>									
									</select>
									<script typr='text/javascript'>
										document.getElementById("NT").removeChild(document.getElementById("NT").options[0] )
									</script>
									<input type='hidden' id='NT_LIST' name='NT_LIST'> 
								</TD>
								<TD width="5%" align="left" valign=top class='Label'>居留狀況：<br>(可複選)&nbsp;&nbsp;&nbsp;&nbsp;</TD>
								<TD width="45%" colspan=4>
									<!-- <LABEL id=lblARCST></LABEL>
									<INPUT id=btnARCST type=button value=查詢 tabindex=10 title=查詢 >-->
									<SELECT id=ARCST name=ARCST  tabindex=10 class='InputText' multiple size='6'> 
										
										<OPTION value="1">改變國籍(原具我國籍者)</OPTION>
										<OPTION value="2">在台</OPTION>
										<OPTION value="3">離台</OPTION>
										<OPTION value="4">死亡</OPTION>
										<OPTION value="5">註銷居留證</OPTION>
										<OPTION value="6">棄原國籍取我國籍</OPTION>
									</SELECT>
									
									<input type='hidden' id='ARCST_LIST' name='ARCST_LIST'> 
									
								</TD>
								
							<tr>
								<TR>
			
			<!-- <TD id=lblARCTO></TD>
        	<TD></TD> -->
        	    
        	
			<TD width="5%" align="left" valign=top class='Label'>教育程度：<br>(可複選)&nbsp;&nbsp;&nbsp;&nbsp;</TD>
			<TD width="35%" colspan=3>
				<!-- <LABEL id=lblEDU></LABEL>
				<INPUT id=btnEDU type=button value=查詢 tabindex=27 title=查詢 > -->
				<SELECT id=EDU name=EDU tabindex=27 class='InputText' multiple size='5'> 
					<OPTION value="01">博士</OPTION>
					<OPTION value="02">碩士</OPTION>
					<OPTION value="03">大學畢業</OPTION>
					<OPTION value="04">大學肄業</OPTION>
					<OPTION value="05">專科畢業</OPTION>
					<OPTION value="06">專科肄業</OPTION>
					<OPTION value="07">高中畢業</OPTION>
					<OPTION value="08">高中肄業</OPTION>
					<OPTION value="09">初中畢業</OPTION>
					<OPTION value="10">初中肄業</OPTION>
					<OPTION value="11">小學畢業</OPTION>
					<OPTION value="12">小學肄業</OPTION>
					<OPTION value="13">識字</OPTION>
					<OPTION value="14">不識字</OPTION>
					<OPTION value="15">不明</OPTION>
				</SELECT>
				
				<input type='hidden' id='EDU_LIST' name='EDU_LIST'>
			</TD>
			<TD width="5%" align="left" class='Label'>婚姻狀況：</TD>	 
			<TD width="10%" colspan=1>
				<SELECT id=MST name=MST tabindex=28 class='InputText'>
					<OPTION value=""></OPTION>
					<OPTION value=1 >單身</OPTION>
					<OPTION value=2 >已婚</OPTION>
					<OPTION value=3 >其他</OPTION>
				</SELECT>
			</TD>
			<TD width="5%" align="left" id=lblBTHDTFM class='Label'>生日：</TD>
			<TD width="40%"colspan=3><input name="txtBTHD_FROM" type="text"
				id="txtBTHD_FROM" class="InputText" size="10"
				onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
				onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" /> &nbsp;<img
				onclick="WdatePicker({el:'txtBTHD_FROM',dateFmt:'yyyy/MM/dd'})"
				onfocus="WdatePicker({el:'txtBTHD_FROM',dateFmt:'yyyy/MM/dd'})"
				tabindex="2" src="images/calendar.gif" alt="選擇日期" /> ~ <input
				name="txtBTHD_TO" type="text" id="txtBTHD_TO"
				class="InputText" size="10"
				onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})"
				onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" /> &nbsp;<img
				onclick="WdatePicker({el:'txtBTHD_TO',dateFmt:'yyyy/MM/dd'})"
				onfocus="WdatePicker({el:'txtBTHD_TO',dateFmt:'yyyy/MM/dd'})"
				tabindex="2" src="images/calendar.gif" alt="選擇日期" /></TD>
			
			
		</TR>
		<TR>
		<TD width="5%" align="left" id=lblAPYDTFM class='Label'>申請日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtAPY_FROM" type="text" id="txtAPY_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtAPY_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtAPY_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtAPY_TO" type="text" id="txtAPY_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtAPY_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtAPY_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			<TD width="5%" align="left" class='Label'>限期離境：</TD>
			<TD width="5%" colspan=1>
				<SELECT id=FRCEXIT name=FRCEXIT tabindex=29 class='InputText'>
					<OPTION value=""></OPTION>
					<OPTION value=21 >違反就服法</OPTION>
					<OPTION value=22 >取消限期出境通報</OPTION>
					<OPTION value=23 >體檢不合格</OPTION>
					<OPTION value=24 >取消體檢通報</OPTION>
					<OPTION value=2A >列管</OPTION>
					<OPTION value=2B >取消列管通報</OPTION>
				</SELECT>
			</TD>
		<TD align="left" width="5%" id=lblARCFM class='Label'>居留期限：</TD>
        	<TD width="40%"colspan=3>
        	    <input name="txtARC_FROM" type="text" id="txtARC_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtARC_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtARC_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtARC_TO" type="text" id="txtARC_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtARC_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtARC_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			
			<!-- <TD id=lblAPYDTTO></TD>
        	<TD>
        	    
        	</TD> -->
		</TR>
		<TR>
			<TD align="left" width="5%" id=lblREAPYDTFM class='Label'>重入國申請日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtREAPY_FROM" type="text" id="txtREAPY_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtREAPY_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtREAPY_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtREAPY_TO" type="text" id="txtREAPY_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtREAPY_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtREAPY_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			
			<!-- <TD id=lblREAPYDTTO></TD>
        	<TD>
        	    
        	</TD> -->
			<TD width="5%" align="left" class='Label'>人口分類：</TD>		
			<TD width="5%" colspan=1>
				<SELECT id=MANTYPE name=MANTYPE tabindex=88 class='InputText'>
					<OPTION value=0 ></OPTION>
					<OPTION value=A>A 治安顧慮人口</OPTION>
					<OPTION value=B>B 注意訪查人口</OPTION>
					<OPTION value=C>C 無顧慮人口</OPTION>
					<OPTION value=D>D 可供諮詢之友善人士</OPTION>
				</SELECT>
			</TD>

			<TD width="5%" align="left" id=lblMISSDTFM class='Label'>逃逸日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtMISS_FROM" type="text" id="txtMISS_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtMISS_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtMISS_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtMISS_TO" type="text" id="txtMISS_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtMISS_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtMISS_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
		</TR>
		<TR>
			
			<!-- <TD id=lblMISSDTTO></TD>
        	<TD>
        	    
        	</TD> -->
			<TD width="5%" align="left" id=lblSBMTDTFM class='Label'>報案日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtSBMT_FROM" type="text" id="txtSBMT_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtSBMT_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtSBMT_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtSBMT_TO" type="text" id="txtSBMT_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtSBMT_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtSBMT_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			<!-- <TD id=lblSBMTDTTO></TD>
        	<TD>
        	    
        	</TD> -->
	   
			<TD width="5%" align="left" class='Label'>查獲單位：</TD>
			<TD width="5%" colspan=1>
				<INPUT id=FNDDID name=FNDDID maxlength=5 tabindex=66 style="WIDTH:50px" value="" class='InputText'>
				<LABEL id=lblFNDDID></LABEL>
			</TD>
			<TD width="5%" align="left" id=lblFNDDTFM class='Label'>查獲日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtFIND_FROM" type="text" id="txtFIND_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtFIND_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtFIND_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtFIND_TO" type="text" id="txtFIND_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtFIND_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtFIND_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			<!-- <TD id=lblFNDDTTO></TD>
        	<TD>
        	    
        	</TD> -->
	    </TR>
	    <TR>
			<TD width="5%" align="left" id=lblINDTFM class='Label'>抵台日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtIN_FROM" type="text" id="txtIN_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtIN_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtIN_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtIN_TO" type="text" id="txtIN_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtIN_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtIN_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			<!-- <TD id=lblARCTO></TD>
        	<TD>
        	    
        	</TD> -->
        	
	     	<TD width="5%" align="left" id=lblEXDTFM class='Label'>離台日期：</TD>
        	<TD width="40%" colspan=3>
        	    <input name="txtEXIT_FROM" type="text" id="txtEXIT_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtEXIT_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtEXIT_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
				~
				<input name="txtEXIT_TO" type="text" id="txtEXIT_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtEXIT_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtEXIT_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			</TD>
			<TD width="5%" align="left" valign=top class='Label'>撤銷居留原因：</TD>
			<TD width="5%" colspan=4>
			<!-- <LABEL id=lblFBDRSN></LABEL><INPUT id=btnFBDRSN type=button value=查詢 tabindex=38 title=查詢 > -->
				<SELECT id=FBDRSN name=FBDRSN tabindex=38 class='InputText'> 
					<OPTION value=""></OPTION>
					<OPTION value="1">申請資料係偽(變)造者</OPTION>
					<OPTION value="2">經判處一年以上刑期者</OPTION>
					<OPTION value="3">每年居住未達183天者</OPTION>
					<OPTION value="4">回復或取得我國國籍者</OPTION>
					<OPTION value="5">已取得外僑永久居留證者</OPTION>
					<OPTION value="6">經撤銷聘僱許可並限令出國者</OPTION>
					<OPTION value="7">其他</OPTION>
					<OPTION value="8">休學</OPTION>
					<OPTION value="9">退學</OPTION>
					<OPTION value="A">畢業</OPTION>
					<OPTION value="B">申請資料虛偽或不實</OPTION>
					<OPTION value="C">持用不法取得、偽造或變造之證件</OPTION>
					<OPTION value="D">回復我國籍</OPTION>
					<OPTION value="E">取得我國籍</OPTION>
					<OPTION value="F">兼具我國籍，以國民身分入出國、居留或定居</OPTION>
				    <OPTION value="G">受驅逐出國</OPTION>
					<OPTION value="H">經許可定居</OPTION>
					<OPTION value="I">離婚</OPTION>
					<OPTION value="J">離婚配偶喪失子女扶養權</OPTION>
					<OPTION value="K">依親對象居留事由消失者</OPTION>
					<OPTION value="L">當事人主動撤銷</OPTION>
					<OPTION value="M">經撤銷、廢止居留許可(居留原因消失)-中途解約</OPTION>
					<OPTION value="N">經撤銷、廢止居留許可(居留原因消失)-連續三日曠職</OPTION>
					<OPTION value="O">經撤銷、廢止居留許可(居留原因消失)-非法工作</OPTION>
					<OPTION value="P">經撤銷、廢止居留許可(居留原因消失)-健檢不合格</OPTION>
					<OPTION value="Q">經撤銷、廢止居留許可(居留原因消失)-轉換雇主不成功</OPTION>
					<OPTION value="R">經撤銷、廢止居留許可(居留原因消失)-投資</OPTION>
					<OPTION value="S">經撤銷、廢止居留許可(居留原因消失)-傳教</OPTION>
					<OPTION value="T">死亡</OPTION>
				</SELECT>
			</TD>
			<!-- <TD id=lblARCTO></TD>
        	<TD>
        	    
        	</TD> -->
	     	
		</TR>
			
							</tbody>
						</table>
					</fieldset><br>
						<fieldset>
							<legend>查詢結果清單顯示欄項</legend>
							<table width="100%">
								<tbody>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkARCNO" name="chkARCNO" type="checkbox" value="1">
											1</td>
										<td idth="15%">外來人口統一證號</td>
										<td width="5%" style="text-align: center"><input
											id="chkPSPT" name="chkPSPT" type="checkbox" value="1"
											checked> 2</td>
										<td idth="15%">護照號碼</td>
										<td width="5%" style="text-align: center"><input
											id="chkENM" name="chkENM" type="checkbox" value="1"
											checked> 3</td>
										<td idth="15%">英文姓名</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkilNTNM" name="chkilNTNM" type="checkbox" value="1"
											checked> 4</td>
										<td idth="15%">國籍</td>
										<td width="5%" style="text-align: center"><input
											id="chkBTHDT" name="chkBTHDT" type="checkbox" value="1"
											checked> 5</td>
										<td idth="15%">出生日期</td>
										<td width="5%" style="text-align: center"><input
											id="chkCNM" name="chkCNM" type="checkbox" value="1">
											6</td>
										<td idth="15%">中文姓名</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkARCFM" name="chkARCFM" type="checkbox" value="1">
											7</td>
										<td idth="15%">居留效期(起)</td>
										<td width="5%" style="text-align: center"><input
											id="chkARCTO" name="chkARCTO" type="checkbox" value="1">
											8</td>
										<td idth="15%">居留效期(迄)</td>
										<td width="5%" style="text-align: center"><input
											id="chkSEX" name="chkSEX" type="checkbox" value="1">
											9</td>
										<td idth="15%">性別</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkJBCD" name="chkJBCD" type="checkbox" value="1">
											10</td>
										<td idth="15%">職業代碼</td>
										<td width="5%" style="text-align: center"><input
											id="chkARCST" name="chkARCST" type="checkbox" value="1">
											11</td>
										<td idth="15%">居留狀況</td>
										<td width="5%" style="text-align: center"><input
											id="chkARCRSN" name="chkARCRSN" type="checkbox" value="1">
											12</td>
										<td idth="15%">居留事由(居留目的)</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkEDU" name="chkEDU" type="checkbox" value="1">
											13</td>
										<td idth="15%">教育程度</td>
										<td width="5%" style="text-align: center"><input
											id="chkOFCD" name="chkOFCD" type="checkbox" value="1">
											14</td>
										<td idth="15%">服務處所(大專院校)代碼</td>
										<td width="5%" style="text-align: center"><input
											id="chkOFNM" name="chkOFNM" type="checkbox" value="1">
											15</td>
										<td idth="15%">服務處所名稱</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkOFTEL" name="chkOFTEL" type="checkbox" value="1">
											16</td>
										<td idth="15%">服務處所電話</td>
										<td width="5%" style="text-align: center"><input
											id="chkJBADDR" name="chkJBADDR" type="checkbox" value="1">
											17</td>
										<td idth="15%">工作地址</td>
										<td width="5%" style="text-align: center"><input
											id="chkJBTEL" name="chkJBTEL" type="checkbox" value="1">
											18</td>
										<td idth="15%">工作電話</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkARPZONE" name="chkARPZONE" type="checkbox" value="1">
											19</td>
										<td idth="15%">居留地址郵遞區號</td>
										<td width="5%" style="text-align: center"><input
											id="chkARADDR" name="chkARADDR" type="checkbox" value="1">
											20</td>
										<td idth="15%">居留地址</td>
										<td width="5%" style="text-align: center"><input
											id="chkARTEL" name="chkARTEL" type="checkbox" value="1">
											21</td>
										<td idth="15%">居留電話</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkPHQ" name="chkPHQ" type="checkbox" value="1">
											22</td>
										<td idth="15%">管轄分局代碼</td>
										<td width="5%" style="text-align: center"><input
											id="chkPSTEXT" name="chkPSTEXT" type="checkbox" value="1">
											23</td>
										<td idth="15%">管轄外責區代碼</td>
										<td width="5%" style="text-align: center"><input
											id="chkFRSHP" name="chkFRSHP" type="checkbox" value="1">
											24</td>
										<td idth="15%">在華親屬稱謂代碼</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkFNTCD" name="chkFNTCD" type="checkbox" value="1">
											25</td>
										<td idth="15%">在華親屬國籍代碼</td>
										<td width="5%" style="text-align: center"><input
											id="chkMISSDT" name="chkMISSDT" type="checkbox" value="1">
											26</td>
										<td idth="15%">逃逸日期</td>
										<td width="5%" style="text-align: center"><input
											id="chkSBMTDT" name="chkSBMTDT" type="checkbox" value="1">
											27</td>
										<td idth="15%">報案日期</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkFNDDT" name="chkFNDDT" type="checkbox" value="1">
											28</td>
										<td idth="15%">查獲日期</td>
										<td width="5%" style="text-align: center"><input
											id="chkSRCHST" name="chkSRCHST" type="checkbox" value="1">
											29</td>
										<td idth="15%">協尋處理情形(特殊身份)</td>
										<td width="5%" style="text-align: center"><input
											id="chkINDT" name="chkINDT" type="checkbox" value="1">
											30</td>
										<td idth="15%">抵台日期</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkEXDT" name="chkEXDT" type="checkbox" value="1">
											31</td>
										<td idth="15%">離台日期</td>
										<td width="5%" style="text-align: center"><input
											id="chkFPID" name="chkFPID" type="checkbox" value="1">
											32</td>
										<td idth="15%">親屬身分(居留)證號</td>
										<td width="5%" style="text-align: center"><input
											id="chkFNM" name="chkFNM" type="checkbox" value="1">
											33</td>
										<td idth="15%">親屬姓名</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkAPYDT" name="chkAPYDT" type="checkbox" value="1">
											34</td>
										<td idth="15%">申請日期</td>
										<td width="5%" style="text-align: center"><input
											id="chkMANTYPE" name="chkMANTYPE" type="checkbox" value="1">
											35</td>
										<td idth="15%">人口分類</td>
										<td width="5%" style="text-align: center"><input
											id="chkARCRCP" name="chkARCRCP" type="checkbox" value="1">
											36</td>
										<td idth="15%">收據號碼</td>
									</tr>
									<tr>
										<td width="5%" style="text-align: center"><input
											id="chkMICRO" name="chkMICRO" type="checkbox" value="1">
											37</td>
										<td idth="15%">縮影編號</td>
										<td width="5%" style="text-align: center"><input
											id="chkOLDARCNO" name="chkOLDARCNO" type="checkbox" value="1">
											38</td>
										<td idth="15%">舊式居留證號</td>
									</tr>
								</tbody>
							</table>

						</fieldset>
				</td>
			</tr>
			<tbody>
		</table>

		<table align="center" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<div class="FunctionArea">
						<input type="button" class="InputButton" id="queryBtn" value="確 定" onclick="toSubmit();" />
						<input type="button" class="InputButton" value="清 除" onclick="location.replace(location.href);" />
					</div>
				</td>
			</tr>
		</table>
		<input id="QueryFrom" name="QueryFrom" type="hidden" value="IL03A01Q01" />
		<input id="LOGPHQ" name="LOGPHQ" type="hidden" value="${LOGPHQ}" />
	</form>
</body>
</html>