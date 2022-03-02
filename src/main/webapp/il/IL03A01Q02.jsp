<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@page 
language="java"
import="java.util.*,java.lang.*,java.net.*,java.text.*,java.net.*,java.sql.*,java.io.*,jxl.*,jxl.write.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <link rel="Stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/myValidator.js"></script>
	<script type="text/javascript" src="js/jquery.jqprint.js" ></script>
    <script type="text/javascript" src="js/watermark.js" ></script>
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
		setMask();

		/**列印事件**/
        $("#print").click(function() {
               //alert("test");//test
              $("#table").jqprint();
              
        });

	});

	

	
	//表單送出事件
	function onSubmit(){
		$('#myForm').attr("action", "IL03A01Q04.action");
		$('#pageType').val('');
		
		if($('input[name=ilArcid]:checked').val()==null){
			$.alert.open("warning", "選取項不可為空");
			return;
		}
		
		document.myForm.submit();
	}
	
	function doXls(){
		$('#pageType').val('print');
		$('#myForm').attr("action", "IL03A01Q02_2.action");
		$('#myForm').submit();
		
	}
	
	function doPdf(){
		$('#pageType').val('print');
		$('#myForm').attr("action", "IL03A01Q02_3.action");
		$('#myForm').submit();
		
	}
	
	window.onload = function() {
		
		var data={};
		var queryMethodStr = $("#queryStr").val();
		var str = "";
		var dataRowsString = "";

		data["main"] = $("#main").val();
		data["detail"] = $("#detail").val();
		data["logcn"] = $("#logcn").val();
		data["logpstname"] = $("#logpstname").val();
		data["oprPage"] = "外僑居留資料查詢-IL03A01Q02";
		data["queryMethodStr"] = queryMethodStr;
		data["name"] = $("#ilCnm").val();
		data["idno"] = "";
		data["birth"] = $("#txtBTHD").val();
		
		if($("tr.empty").val()==undefined){
					
			var cut = "%===%";
			var trIndex = 0;
			$("#queryList").find("tr").each(function(){
				if(trIndex==0){
					var thIndex = 0;
					$(this).find("th").each(function(){
						if(thIndex==0){
							thIndex++;
							return
						}
						str += ($(this).text().replace(/^\s*|\s*$/g,"") + "&");
					})
					str = str.substring(0,(str.length-1))
					str += cut;
					trIndex++;
					return
				}
				var tdIndex = 0;
				$(this).find("td").each(function(){
					if(tdIndex==0){
						tdIndex++;
						return
					}
					str += ($(this).text().replace(/^\s*|\s*$/g,"") + "&");
				})
				
				str += cut;
			})
			
			str = str.substring(0,(str.length-5))
			
		}
		data["dataRowsString"] = str;
		console.log(data);
		
		var url = "doLog.action";
        $.ajax({
            url: url,
            type: 'post',
            data: data,
            dataType: "json"
        });
	};
	
	</script>
 
</head>
<%
	
	//製表姓名
	String logcn=(String)session.getAttribute("LOGCN");
	//製表單位
	String logUnitNm=(String)session.getAttribute("LOGUNITNM");
	//登入時間
	String logtDt=(String)session.getAttribute("LOGTDT");
%>
<body>	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="90%">
				<div class="FuncName">
					外僑居留資料查詢-資料選取畫面
				</div>
			</td>
		</tr>
	</table>
	
	<form id="myForm" name="myForm" method="post" action="IL03A01Q04.action" class='Form1'>
		<!-- 日誌用開始 -->
		<input type="hidden" id="logcn" name="logcn" value="${logcn}" />
		<input type="hidden" id="logpstname" name="logpstname" value="${logpstname}" />
		<input type="hidden" id="main" name="main" value="${main}" />
		<input type="hidden" id="detail" name="detail" value="${detail}" />
		<!-- 日誌結束 -->
		<input id="ilArcno" name="ilArcno" type="hidden" value="${ilArcno}" />
		<input id="ilPspt" name="ilPspt" type="hidden" value="${ilPspt}" />
		<input id="ilEnm" name="ilEnm" type="hidden" value="${ilEnm}" />
		<input id="ilCnm" name="ilCnm" type="hidden" value="${ilCnm}" />
		<input id="txtBTHD" name="txtBTHD" type="hidden" value="${txtBTHD}" />
		<input id="ilOfnm" name="ilOfnm" type="hidden" value="${ilOfnm}" />
		<input id="ilPhq" name="ilPhq" type="hidden" value="${ilPhq}" />
		<input id="ilJbpmdt" name="ilJbpmdt" type="hidden" value="${ilJbpmdt}" />
		<input id="ilJbpmdc" name="ilJbpmdc" type="hidden" value="${ilJbpmdc}" />
		<input id="oriUrlFlag" name="oriUrlFlag" type="hidden" value="IL03A01Q02" />
		<input id="queryStr" name="queryStr" type="hidden" value="${queryStr}" />
		
		<!-- 浮水印 -->
		<div id="printPage">
		<table id="table" width="100%" border='0' cellpadding='1' cellspacing='0'>
            <tr>
                <td>
                <fieldset>
                <legend></legend>
                <div id="tableMask" class="dataTable-info-mask"
			style="display: none;">
		</div>
		<display:table id="queryList" name="queryList" pagesize="10" requestURI="IL03A01Q02.action" decorator="tw.gov.npa.il.decorator.IL03A01Q02Decorator" cellpadding="8" style="width:100%;border-collapse:collapse;">
		<display:column headerClass="First" class="Center sid id" property="function" title="" />
		<c:choose>
		<c:when test="${empty queryList}">
			無資料
		</c:when>
		<c:otherwise>
		<c:if test="${queryList.chkARCNO == 'ilArcno'}">
			<display:column class="Center" property="${queryList.chkARCNO}" title="外來人口統一證號" />
		</c:if>
		<c:if test="${queryList.chkPSPT == 'ilPspt'}">
			<display:column class="Center" property="${queryList.chkPSPT}" title="護照號碼" />
		</c:if>
		<c:if test="${queryList.chkENM == 'ilEnm'}">
			<display:column class="Center" property="${queryList.chkENM}" title="英文姓名" />
		</c:if>
		<c:if test="${queryList.chkilNTNM == 'ilNTNM'}">
			<display:column class="Center" property="${queryList.chkilNTNM}" title="國籍" />
		</c:if>
		<c:if test="${queryList.chkBTHDT == 'ilBthdt'}">
			<display:column class="Center" property="${queryList.chkBTHDT}" title="出生日期" />
		</c:if>
		<c:if test="${queryList.chkCNM == 'ilCnm'}">
			<display:column class="Center" property="${queryList.chkCNM}" title="中文姓名" />
		</c:if>
		<c:if test="${queryList.chkARCFM == 'ilArcfm'}">
			<display:column class="Center" property="${queryList.chkARCFM}" title="居留效期(起)" />
		</c:if>
		<c:if test="${queryList.chkARCTO == 'ilArcto'}">
			<display:column class="Center" property="${queryList.chkARCTO}" title="居留效期(迄)" />
		</c:if>
		<c:if test="${queryList.chkSEX == 'ilSex'}">
			<display:column class="Center" property="${queryList.chkSEX}" title="性別" />
		</c:if>
		<c:if test="${queryList.chkJBCD == 'ilJbcd'}">
			<display:column class="Center" property="${queryList.chkJBCD}" title="職業代碼" />
		</c:if>
		<c:if test="${queryList.chkARCST == 'ilArcst'}">
			<display:column class="Center" property="${queryList.chkARCST}" title="居留狀況" />
		</c:if>
		<c:if test="${queryList.chkARCRSN == 'ilArcrsn'}">
			<display:column class="Center" property="${queryList.chkARCRSN}" title="居留事由(居留目的)" />
		</c:if>
		<c:if test="${queryList.chkEDU == 'ilEdu'}">
			<display:column class="Center" property="${queryList.chkEDU}" title="教育程度" />
		</c:if>
		<c:if test="${queryList.chkOFCD == 'ilOfcd'}">
			<display:column class="Center" property="${queryList.chkOFCD}" title="服務處所(大專院校)代碼" />
		</c:if>
		<c:if test="${queryList.chkOFNM == 'ilOfnm'}">
			<display:column class="Center" property="${queryList.chkOFNM}" title="服務處所名稱" />
		</c:if>
		<c:if test="${queryList.chkOFTEL == 'ilOftel'}">
			<display:column class="Center" property="${queryList.chkOFTEL}" title="服務處所電話" />
		</c:if>
		<c:if test="${queryList.chkJBADDR == 'ilJbaddr'}">
			<display:column class="Center" property="${queryList.chkJBADDR}" title="工作地址" />
		</c:if>
		<c:if test="${queryList.chkJBTEL == 'ilJbtel'}">
			<display:column class="Center" property="${queryList.chkJBTEL}" title="工作電話" />
		</c:if>
		<c:if test="${queryList.chkARPZONE == 'ilArpzone'}">
			<display:column class="Center" property="${queryList.chkARPZONE}" title="居留地址郵遞區號" />
		</c:if>
		<c:if test="${queryList.chkARADDR == 'ilAraddr'}">
			<display:column class="Center" property="${queryList.chkARADDR}" title="居留地址" />
		</c:if>
		<c:if test="${queryList.chkARTEL == 'ilArtel'}">
			<display:column class="Center" property="${queryList.chkARTEL}" title="居留電話" />
		</c:if>
		<c:if test="${queryList.chkPHQ == 'ilPhq'}">
			<display:column class="Center" property="${queryList.chkPHQ}" title="管轄分局代碼" />
		</c:if>
		<c:if test="${queryList.chkPSTEXT == 'ilPstext'}">
			<display:column class="Center" property="${queryList.chkPSTEXT}" title="管轄外責區代碼" />
		</c:if>
		<c:if test="${queryList.chkFRSHP == 'ilFrshp'}">
			<display:column class="Center" property="${queryList.chkFRSHP}" title="在華親屬稱謂代碼" />
		</c:if>
		<c:if test="${queryList.chkFNTCD == 'ilFntcd'}">
			<display:column class="Center" property="${queryList.chkFNTCD}" title="在華親屬國籍代碼" />
		</c:if>	
		<c:if test="${queryList.chkMISSDT == 'ilMissdt'}">
			<display:column class="Center" property="${queryList.chkMISSDT}" title="逃逸日期" />
		</c:if>		
		<c:if test="${queryList.chkSBMTDT == 'ilSbmtdt'}">
			<display:column class="Center" property="${queryList.chkSBMTDT}" title="報案日期" />
		</c:if>	
		<c:if test="${queryList.chkFNDDT == 'ilFnddt'}">
			<display:column class="Center" property="${queryList.chkFNDDT}" title="查獲日期" />
		</c:if>
		<c:if test="${queryList.chkSRCHST == 'ilSrchst'}">
			<display:column class="Center" property="${queryList.chkSRCHST}" title="協尋處理情形(特殊身份)" />
		</c:if>
		<c:if test="${queryList.chkINDT == 'ilIndt'}">
			<display:column class="Center" property="${queryList.chkINDT}" title="抵台日期" />
		</c:if>
		<c:if test="${queryList.chkEXDT == 'ilExdt'}">
			<display:column class="Center" property="${queryList.chkEXDT}" title="離台日期" />
		</c:if>
		<c:if test="${queryList.chkFPID == 'ilFpid'}">
			<display:column class="Center" property="${queryList.chkFPID}" title="親屬身分(居留)證號" />
		</c:if>
		<c:if test="${queryList.chkFNM == 'ilFnm'}">
			<display:column class="Center" property="${queryList.chkFNM}" title="親屬姓名" />
		</c:if>
		<c:if test="${queryList.chkAPYDT == 'ilApydt'}">
			<display:column class="Center" property="${queryList.chkAPYDT}" title="申請日期" />
		</c:if>
		<c:if test="${queryList.chkARCRCP == 'ilArcrcp'}">
			<display:column class="Center" property="${queryList.chkARCRCP}" title="收據號碼" />
		</c:if>
		<c:if test="${queryList.chkMICRO == 'ilMicro'}">
			<display:column class="Center" property="${queryList.chkMICRO}" title="縮影編號" />
		</c:if>
		<c:if test="${queryList.chkMANTYPE == 'MANTYPE'}">
			<display:column class="Center" property="${queryList.chkMANTYPE}" title="人口分類" />
		</c:if>
		<c:if test="${queryList.chkOLDARCNO == 'ilOldarc'}">
			<display:column class="Center" property="${queryList.chkOLDARCNO}" title="舊式居留證號" />
		</c:if>
		
		</c:otherwise>
		</c:choose>
		</display:table>
		</fieldset>
				</td>
            </tr>
        </table>
        </div>
		
		<div class="FunctionArea">				 	
	    	
			<input type="button" name="btnQuery" id="btnQuery" class="InputButton" onclick="onSubmit();" value="確定" />                  
			
			<input type="button" name="exportXls" id="exportXls" class="InputButton" onclick="doXls();" value="匯出清單成Excel" />   
			
			<input type="button" name="exportPdf" id="exportPdf" class='InputButton' onclick="doPdf();" value="匯出清單成PDF" />
			
			<input type="button" class='InputButton' id="print" name="print" value="列印"  />               
			
			<input type="button" class="InputButton" onclick="javascript:location.href='${QueryFrom}.action';" value="回查詢" />                  
	    </div>
	</form>
</body>
<script type="text/javascript">

//浮水印


/* 依照畫面解析度，動態生成浮水印 */
function setMask() {
	<%-- watermark.load({ watermark_txt: "<%=logUnitNm%>-<%=logcn%>-<%=logtDt%>" }) --%>
	var height = $('#table').height();//table body的高
	var endNumber = 0;
	if($(window).width() <= 1024){
		endNumber = height/220;
	}else{
		endNumber = height/200;
	}

	//製表單位-製表姓名-登入時間
    var str = '';
    for(var i=0 ; i < endNumber ; i ++){
	    str += '<p class="info-text-left"><%=logUnitNm%>-<%=logcn%>-<%=logtDt%></p>';
	    str += '<p class="info-text-center"><%=logUnitNm%>-<%=logcn%>-<%=logtDt%></p>';
	    str += '<p class="info-text-right"><%=logUnitNm%>-<%=logcn%>-<%=logtDt%></p>';
    }
    $('#tableMask').html('');
    $('#tableMask').html(str);
    $('#tableMask').show();
    
}
</script>
</html>