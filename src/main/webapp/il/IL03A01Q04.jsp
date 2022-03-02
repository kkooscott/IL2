<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <title>居留外僑動態管理系統-居留資料查詢作業</title>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    <script type="text/javascript" src="js/jquery.jqprint.js" ></script>
    <script type="text/javascript" src="js/watermark.js" ></script>
    <script type="text/javascript" src="js/jquery-ui.min.js" ></script>
    <script src="../js/jspdf.customfonts.debug.js"></script>
	<script src="../js/jspdf.customfonts.min.js"></script>
	<script src="../js/default_vfs.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" />
   	<link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
	<link rel="Stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript">
	$(function() {
		//隱藏dialog
		$("#dialog").hide();
		$("#arcnoHistoryList").hide();
		//設浮水印
		setMask();
		arcnoHistoryListAjax();
		//實際查詢人送出按鈕動作
   		$('#btnSend').click(function(){
   			$("#SpanImg").css({
   				position:"absolute", 
   				left:"550px",
   				top:"50px"
   			});
            $('.opr').hide();
        });	
        
        /**列印事件**/
        $("#print").click(function() {
               //alert("test");//test
              $("#tableBox").jqprint();
              
        });
	});//$(function() {

	
	/* function toPdf(){

		var doc = new jsPDF();          
		var elementHandler = {
		  '#ignorePDF': function (element, renderer) {
		    return true;
		  }
		};
		var source = window.document.getElementsByTagName("body")[0];
		doc.fromHTML(
		    source,
		    15,
		    15,
		    {
		      'width': 180,'elementHandlers': elementHandler
		    });

		doc.output("dataurlnewwindow");
		} */
	 //表單送/* 出事件
	function toPdf(){
			 var doc = new jsPDF();
			

		    doc.fromHTML($('#ignorePDF').html());
		    doc.save('list.pdf');
	} 
		
	function showDialog(){
		$("#dialog").show();
		$("#dialog").dialog({"width":"400px"});
	}
	
	function arcnoHistoryListAjax(){
		
		var data={}
		data["ilIlId"] = $("#ilIlId").val();
		data["ilArcid"] = $("#ilArcid").val();
		
		var url = "arcnoHistoryAjax.action";
        $.ajax({
            url: url,
            type: 'post',
            data: data,
            success: setArcnoHistory,
            dataType: "json"
        });
	}
	
    function setArcnoHistory(json){
        var str = "";

        $.each(json.arcnoHistory, function (time, arcno) {
            str = str + "<tr><td align='center'>" + time.split(' ')[0] + "</td><td align='center'>" + arcno + "</td></tr>"
        });

        $("#arcnoHistoryListTbody").html(str);
        
       	$("#arcnoHistoryList").show();
   		$("#searchArcnoHistory").hide();
/*
        setTimeout(function(){

        	$("#arcnoHistoryList").show();
    		$("#searchArcnoHistory").hide();
	    }, 30000);
*/
    }

	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	
	function prevPage(){
		
		history.go(-1);
		
	}
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
<body id="pdf">
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">外僑居留資料查詢-外僑明細內容顯示畫面</div>
		</td>
	</tr>
</table>
<p></p>
<div id="ignorePDF">
	<s:form id="queryForm" action="">
		<!-- 日誌用開始 -->
		<input type="hidden" id="logcn" name="logcn" value="${logcn}" />
		<input type="hidden" id="logpstname" name="logpstname" value="${logpstname}" />
		<input type="hidden" id="main" name="main" value="${main}" />
		<input type="hidden" id="detail" name="detail" value="${detail}" />
		<!-- 日誌結束 -->
		<input type="hidden" id="ilArcid" name="ilArcid" value="${iltb01Main.ilArcid}" /><!-- 居留資料關聯ID -->
		<input type="hidden" id="ilEnm" name="ilEnm" value="${iltb01Main.ilEnm}" /><!-- 英文姓名 -->
		<input type="hidden" id="ilPspt" name="ilPspt" value="${iltb01Main.ilPspt}" /><!-- 護照號碼 -->
		<input type="hidden" id="ilArcno" name="ilArcno" value="${iltb01Main.ilArcno}" /><!-- 居留證號 -->
		
		<input type="hidden" id="arcnoPath" name="arcnoPath" value="${arcnoPath}" /><!-- 照片路徑 -->
		<input type="hidden" name="iltb01Main.ilEnm" value="${iltb01Main.ilEnm}" /><!-- 英文姓名 -->
		<input type="hidden" id="ilOriEnm" name="ilOriEnm" value="${ilOriEnm}" /><!-- 原名 -->
		<input type="hidden" name="iltb01Main.ilCnm" value="${iltb01Main.ilCnm}" /><!-- 中文姓名 -->
		<input type="hidden" name="iltb01Main.ilSex" value="${iltb01Main.ilSex}" /><!-- 性別 -->
		<input type="hidden" name="iltb01Main.ilBthdt" value='${iltb01Main.ilBthdt}' /><!-- 出生日期 -->
		 
		<input type="hidden" name="iltb01Main.ilPspt" value="${iltb01Main.ilPspt}" /><!-- 護照號碼 -->
		<input type="hidden" name="ilPsdt" value='<s:date name="iltb01Main.ilPsdt" format="yyyy年MM月dd日" />' /><!-- 護照期限 -->
		<input type="hidden" name="iltb01Main.ilEdu" value="${iltb01Main.ilEdu}" /><!-- 教育程度 -->
		<input type="hidden" name="ilIndt" value='<s:date name="iltb01Main.ilIndt" format="yyyy年MM月dd日" />' /><!-- 抵台日期 -->
		<input type="hidden" name="ilExdt" value='<s:date name="iltb01Main.ilExdt" format="yyyy年MM月dd日" />' /><!-- 離台日期 -->
		<input type="hidden" name="iltb01Main.ilArcrsn" value="${iltb01Main.ilArcrsn}" /><!-- 居留事由 -->
		<input type="hidden" name="iltb01Main.ilArcst" value="${iltb01Main.ilArcst}" /><!-- 居留狀況 -->
		<input type="hidden" name="iltb01Main.ilMicro" value="${iltb01Main.ilMicro}" /><!-- 縮影編號 -->
		<input type="hidden" name="iltb01Main.ilOfnm" value="${iltb01Main.ilOfnm}" /><!-- 服務處所 -->
		<input type="hidden" name="iltb01Main.ilOftel" value="${iltb01Main.ilOftel}" /><!-- 服務處所電話 -->
		<input type="hidden" name="iltb01Main.ilJbpzone" value="${iltb01Main.ilJbpzone}" /><!-- 工作地址區號 -->
		<input type="hidden" name="iltb01Main.ilJbaddr" value="${iltb01Main.ilJbaddr}" /><!-- 工作地址 -->
		<input type="hidden" name="iltb01Main.ilJbtel" value="${iltb01Main.ilJbtel}" /><!-- 工作電話 -->
		<input type="hidden" name="iltb01Main.ilArpzone" value="${iltb01Main.ilArpzone}" /><!-- 居留區號 -->
		<input type="hidden" name="iltb01Main.ilAraddr" value="${iltb01Main.ilAraddr}" /><!-- 居留地址 -->
		<input type="hidden" name="iltb01Main.ilArtel" value="${iltb01Main.ilArtel}" /><!-- 居留電話 -->
		<input type="hidden" name="iltb01Main.ilAgnco" value="${iltb01Main.ilAgnco}" /><!-- 仲介 -->
		<input type="hidden" name="iltb01Main.ilAgntel" value="${iltb01Main.ilAgntel}" /><!-- 仲介電話 -->
		
		<input type="hidden" name="ilNTNM" value="${ilNTNM}" /><!--國籍 -->
		<input type="hidden" name="ilOpnm" value="${ilOpnm}" /><!-- 職業 -->
		<input type="hidden" name="ilRemrk" value="${ilRemrk}" /><!-- 備註 -->
		<input type="hidden" name="iltb01Main.ilJbpsn" value="${iltb01Main.ilJbpsn}" /><!-- 職位 -->
		<input type="hidden" name="iltb01Main.ilJbpmcd" value="${iltb01Main.ilJbpmcd}" /><!-- 機關 -->
		<input type="hidden" name="ilJbpmdt" value='<s:date name="iltb01Main.ilJbpmdt" format="yyyy年MM月dd日" />' /><!-- 許可日期 -->
		<input type="hidden" name="iltb01Main.ilJbpmdc" value="${iltb01Main.ilJbpmdc}" /><!-- 文號 -->
		<input type="hidden" name="ilJbpmfm" value='<s:date name="iltb01Main.ilJbpmfm" format="yyyy年MM月dd日" />' /><!-- 許可效期起 -->
		<input type="hidden" name="ilJbpmto" value='<s:date name="iltb01Main.ilJbpmto" format="yyyy年MM月dd日" />' /><!-- 許可效期迄 -->
		<input type="hidden" name="ilApydt" value='<s:date name="iltb01Main.ilApydt" format="yyyy年MM月dd日" />' /><!-- 申請日期 -->
		<input type="hidden" name="iltb01Main.ilArcrcp" value="${iltb01Main.ilArcrcp}" /><!-- 收據號碼 -->
		<input type="hidden" name="iltb01Main.ilArcno" value="${iltb01Main.ilArcno}" /><!-- 居留證號 -->
		<input type="hidden" name="ilArcfm" value='<s:date name="iltb01Main.ilArcfm" format="yyyy年MM月dd日" />' /><!-- 居留效期起 -->
		<input type="hidden" name="ilArcto" value='<s:date name="iltb01Main.ilArcto" format="yyyy年MM月dd日" />' /><!-- 居留效期迄 -->
		<input type="hidden" name="e0UnitSNm" value="${e0UnitSNm}" /><!-- 管轄分局 -->
		<input type="hidden" name="iltb01Main.ilPstext" value="${iltb01Main.ilPstext}" /><!-- 外責區 -->
		
		<input type="hidden" name="iltb01Main.ilFrshp" value="${iltb01Main.ilFrshp}" /><!-- 在華親屬稱謂 -->
		<input type="hidden" name="iltb01Main.ilFnm" value="${iltb01Main.ilFnm}" /><!-- 在華親屬姓名 -->
		<input type="hidden" name="ilNTNMFnt" value="${ilNTNMFnt}" /><!-- 在華親屬國籍 -->
		<input type="hidden" name="iltb01Main.ilFpid" value="${iltb01Main.ilFpid}" /><!-- 在華親屬身分(居留)證號 -->
		
		<input type="hidden" name="ilReapydt" value='<s:date name="iltb01Main.ilReapydt" format="yyyy年MM月dd日" />' /><!-- 重入國申請日期 -->
		<input type="hidden" name="iltb01Main.ilRetp" value="${iltb01Main.ilRetp}" /><!-- 重入國類別 -->
		<input type="hidden" name="ilRepmdt" value='<s:date name="iltb01Main.ilRepmdt" format="yyyy年MM月dd日" />' /><!-- 重入國核准期限 -->
		<input type="hidden" name="iltb01Main.ilRrnote" value="${iltb01Main.ilRrnote}" /><!-- 重入國備考 -->
		<input type="hidden" name="iltb01Main.ilRepmdc" value="${iltb01Main.ilRepmdc}" /><!-- 重入國原許可證號(6位) -->
		<input type="hidden" name="iltb01Main.ilRepmdcNic" value="${iltb01Main.ilRepmdcNic}" /><!-- 重入國新許可證號(10位) -->
		
		<input type="hidden" name="iltb01Main.ilSrchst" value="${iltb01Main.ilSrchst}" /><!-- 協尋處理情形 -->
		<input type="hidden" name="ilMissdt" value='<s:date name="iltb01Main.ilMissdt" format="yyyy年MM月dd日" />' /><!-- 協尋行方不明日期 -->
		<input type="hidden" name="ilSbmtdt" value='<s:date name="iltb01Main.ilSbmtdt" format="yyyy年MM月dd日" />' /><!-- 協尋報案日期 -->
		<input type="hidden" name="iltb01Main.ilSbmttp" value="${iltb01Main.ilSbmttp}" /><!-- 協尋報案方式 -->
		<input type="hidden" name="ilFnddNm" value="${ilFnddNm}" /><!-- 協尋尋獲單位 -->
		<input type="hidden" name="ilFnddt" value='<s:date name="iltb01Main.ilFnddt" format="yyyy年MM月dd日" />' /><!-- 協尋尋獲日期 -->
		
		<input type="hidden" name="iltb01Main.ilFbdrsn" value="${iltb01Main.ilFbdrsn}" /><!-- 撤(註)銷居留/出國報備原因 -->
		<input type="hidden" name="ilMrkdt" value='<s:date name="iltb01Main.ilMrkdt" format="yyyy年MM月dd日" />' /><!-- 撤(註)銷居留/出國報備日期 -->
		<input type="hidden" name="iltb01Main.ilMrkdc" value="${iltb01Main.ilMrkdc}" /><!-- 撤(註)銷居留/出國報備文號 -->
		<input type="hidden" id="ilIlId" name="iltb01Main.ilIlId" value="${iltb01Main.ilIlId}" /><!-- 撤(註)銷居留/出國報備文號 -->
		
	</s:form>
<!-- 表單區塊 -->
<s:form id="myForm" action="">
<div id="content">
	<div id="printPage">
	<!-- 居留影像索引檔 
	<div id="SpanImg" style="position:absolute; left:550px;top:120px">
		<img src="../PICTURES/photo_1.jpg" alt="照片" width="120" height="145">
		<img src="../PICTURES/photo_2.jpg" alt="照片" width="120" height="145">
	</div>
	-->
	<table id="tableBox" width="100%" align="center" border='0' cellpadding='0' cellspacing='0'>
		<tr>
			<td>
			<fieldset>
  			<legend></legend>
  			
				<div id="tableMask" class="dataTable-info-mask"
					style="display: none;">
				</div>
				<div id="tableMask1" class="dataTable-info-mask"
					style="display: none;">
				</div>
				<table id="table" width="100%" border='0' cellpadding='1' cellspacing='0'>			
					<tr>
						<td width="15%" class="Label">英文姓名：</td>
						<td width="15%">${iltb01Main.ilEnm}</td>
						
						<td colspan="4" rowspan="9" class="Label" style='text-align:right'>
						<img align='right' src="${arcnoPath}" alt="照片" width="120" height="145">
						<%-- <img align='right' src="${arcnoPath}1-0.JPG" alt="照片" width="120" height="145">
						<img align='right' src="${arcnoPath}0-0.JPG" alt="照片" width="120" height="145"> --%></td>
                        
                    </tr>
					<tr>
						<td class="Label">原名：</td>
						<td width="20%">${ilOriEnm}</td>
					</tr>					
					<tr>
						<td  class="Label">中文姓名：</td>
						<td width="20%">${iltb01Main.ilCnm}</td>
						</tr>					
					<tr>
						<td  class="Label">性別：</td>
						<td width="20%">
                        	<s:if test="iltb01Main.ilSex==1">男</s:if>
							<s:elseif test="iltb01Main.ilSex==2">女</s:elseif>
                        </td>
					</tr>					
					<tr>
						<td  class="Label">國籍：</td>
						<td width="20%">${ilNTNM}</td>
					</tr>					
					<tr>
						<td  class="Label">出生日期：</td>
						<td width="20%">
                        	<s:property value="iltb01Main.ilBthdt.substring(0,4)"/>年
                            <s:property value="iltb01Main.ilBthdt.substring(4,6)"/>月
                            <s:property value="iltb01Main.ilBthdt.substring(6,8)"/>日
                        </td>
					</tr>					
					<tr>
						<td  class="Label">護照號碼：</td>
						<td width="20%">${iltb01Main.ilPspt}</td>
					</tr>					
					<tr>
						<td  class="Label">護照期限：</td>
						<td width="20%">
                       		<s:date name="iltb01Main.ilPsdt" format="yyyy年MM月dd日"/>
                        </td>
					</tr>					
					<tr>
						<td  class="Label">教育程度：</td>
						<td width="20%">
                        	    <s:if test="iltb01Main.ilEdu.equals(\"00\")"></s:if>
							<s:elseif test="iltb01Main.ilEdu.equals(\"01\")">博士</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"02\")">碩士</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"03\")">大學畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"04\")">大學肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"05\")">專科畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"06\")">專科肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"07\")">高中畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"08\")">高中肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"09\")">初中畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"10\")">初中肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"11\")">小學畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"12\")">小學肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"13\")">識字</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"14\")">不識字</s:elseif>
							<s:elseif test="iltb01Main.ilEdu.equals(\"15\")">不明</s:elseif>
                        </td>
					</tr>					
					<tr>
						<td  class="Label">抵台日期：</td>
						<td width="15%">
                        	<s:date name="iltb01Main.ilIndt" format="yyyy年MM月dd日"/>
                        </td>
						<td width="15%" class="Label"></td>
                        <td width="15%">
                        </td>
						<td width="15%" class="Label">職業：</td>
                        <td width="20%">${ilOpnm}</td>							
					</tr>	
					<tr>
					<td width="16%" class="Label">離台日期：</td>
					<td width="15%">
						<s:date name="iltb01Main.ilExdt" format="yyyy年MM月dd日"/>
					</td>
					</tr>					
					<tr>
						<td  class="Label">居留事由：</td>
						<td width="20%">
                        	<s:if test="iltb01Main.ilArcrsn==0"></s:if>
							<s:elseif test="iltb01Main.ilArcrsn==1">依親</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==2">就學</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==3">應聘</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==4">投資</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==5">傳教</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==6">其他</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==7">外勞</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==8">永居(連續居留七年)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn==9">永居(依親五年配偶)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='A'.toString()">永居(依親五年子女)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='B'.toString()">永居(依親居住十五年)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='C'.toString()">永居(依親居住十年)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='D'.toString()">永居(居住二十年者)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='E'.toString()">永居(高科技人士)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='F'.toString()">永居(特殊貢獻者)</s:elseif>
							<s:elseif test="iltb01Main.ilArcrsn=='G'.toString()">永居(其他)</s:elseif>
                        </td>
						<td width='20%' class="Label">居留狀況：</td>
                        <td>
                        	<s:if test="iltb01Main.ilArcst==1">改變國籍(原具我國籍者)</s:if>
							<s:elseif test="iltb01Main.ilArcst==2">在台</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==3">離台</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==4">死亡</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==5">註銷居留證</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==6">棄原國籍取我國籍</s:elseif>
                        </td>
						<td class="Label">縮影編號：</td>
                        <td width="20%">${iltb01Main.ilMicro}</td>							
					</tr>					
					<tr>
						<td  class="Label">服務處所：</td>
						<td colspan="3">${iltb01Main.ilOfnm}</td>
						<td class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilOftel}</td>							
						
					</tr>					
					<tr>
						<td  class="Label">工作地址：</td>
						<td colspan="3">${iltb01Main.ilJbpzone} ${iltb01Main.ilJbaddr}</td>
						<td  class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilJbtel}</td>							
					</tr>					
					<tr>
						<td  class="Label">居留地址：</td>
						<td colspan="3">${iltb01Main.ilArpzone} ${iltb01Main.ilAraddr}</td>
						<td  class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilArtel}</td>							
					</tr>
					<tr>
						<td  class="Label">仲介：</td>
						<td colspan="3">${iltb01Main.ilAgnco}</td>
						<td  class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilAgntel}</td>							
					</tr>						
					<tr>
						<td class="Label">備註：</td>
						<td colspan="3">${ilRemrk}</td>
						<td class="Label">職位：</td>
                        <td width="20%">${iltb01Main.ilJbpsn}</td>							
					</tr>		<tr><td>&nbsp;</td><tr>			
					<tr>
						<td  class="LabelCenter"><b>工作許可<b></td>
						<td width="50%" colspan="5"></td>
					</tr>					
					<tr>
						<td class="Label">機關：</td>
						<td width="20%">
                        	<s:if test="iltb01Main.ilJbpmcd==1">勞動部</s:if>
							<s:elseif test="iltb01Main.ilJbpmcd==2">內政部</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==3">經濟部</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==4">經濟部投審會</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==5">科學園區管理局</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==6">教育部</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==7">交通部</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==8">國防部</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==9">新聞局</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd==-">衛生署</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='A'.toString()">台北市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='B'.toString()">台中市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='C'.toString()">基隆市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='D'.toString()">台南市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='E'.toString()">高雄市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='F'.toString()">台北縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='G'.toString()">宜蘭縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='H'.toString()">桃園縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='I'.toString()">嘉義市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='J'.toString()">新竹縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='K'.toString()">苗栗縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='L'.toString()">台中縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='M'.toString()">南投縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='N'.toString()">彰化縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='O'.toString()">新竹市政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='P'.toString()">雲林縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='Q'.toString()">嘉義縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='R'.toString()">台南縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='S'.toString()">高雄縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='T'.toString()">屏東縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='U'.toString()">花蓮縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='V'.toString()">台東縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='W'.toString()">金門縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='X'.toString()">澎湖縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='Y'.toString()">連江縣政府</s:elseif>
							<s:elseif test="iltb01Main.ilJbpmcd=='Z'.toString()">其他</s:elseif>
                        </td>
						<td class="Label">許可日期：</td>
                        <td  colspan='3'>
                        	<s:date name="iltb01Main.ilJbpmdt" format="yyyy年MM月dd日"/>
                        </td>
						
                        
					</tr>					
					<tr>
						<td  class="Label">文號：</td>
						<td width="20%">${iltb01Main.ilJbpmdc}</td>
						<td  class="Label">許可效期：</td>
                        <td  colspan='3'>
                        <s:date name="iltb01Main.ilJbpmfm" format="yyyy年MM月dd日"/> ~ 
                        <s:date name="iltb01Main.ilJbpmto" format="yyyy年MM月dd日"/>
                        </td>
						
                        
					</tr>					
					<tr>
						<td  class="Label">申請日期：</td>
						<td width="20%">
	                       <s:date name="iltb01Main.ilApydt" format="yyyy年MM月dd日"/>
	                       </td>
						<td  class="Label">收據號碼：</td>
	                       <td   colspan='3'>${iltb01Main.ilArcrcp}</td>
						
						
					</tr>					
					<tr>
						<td  class="Label">外來人口統一證號：</td>
						<td width="20%">${iltb01Main.ilArcno}</td>
						<td  class="Label">居留效期：</td>
                        <td  colspan='3'>
                        <s:date name="iltb01Main.ilArcfm" format="yyyy年MM月dd日"/> ~ 
                        <s:date name="iltb01Main.ilArcto" format="yyyy年MM月dd日"/>
                        </td>
						
                        
					</tr>					
					<tr>
						<td  class="Label">管轄分局：</td>
						<td width="20%">${e0UnitSNm}</td>
						<td  class="Label">外責區：</td>
                        <td   colspan='3'>${iltb01Main.ilPstext}</td>
						
                        						
					</tr><tr><td>&nbsp;</td><tr>					
					<tr>
						<td class="LabelCenter"><b>在華親屬</b></td>
						<td width="50%" colspan="5"></td>
					</tr>					
					<tr>
						<td  class="Label">稱謂：</td>
						<td width="20%">
                        	<s:if test="iltb01Main.ilFrshp==00"></s:if>
							<s:elseif test="iltb01Main.ilFrshp==01">夫</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==02">妻</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==03">父</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==04">母</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==05">子</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==06">女</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==07">祖父</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==08">祖母</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==09">兄</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==10">弟</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==11">姊</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==12">妹</s:elseif>
							<s:elseif test="iltb01Main.ilFrshp==13">其他</s:elseif>
                        </td>
						<td  class="Label">姓名：</td>
                        <td  colspan='3'>${iltb01Main.ilFnm}</td>
												
					</tr>					<tr>
						<td  class="Label">國籍：</td>
						<td width="20%">${ilNTNMFnt}</td>
						<td  class="Label">身分(居留)證號：</td>
                        <td  colspan='3'>${iltb01Main.ilFpid}</td>
												
					</tr>		<tr><td>&nbsp;</td><tr>			
					<tr>
						<td  class="LabelCenter"><b>重入國</b></td>
						<td width="50%" colspan="5"></td>
					</tr>					
					<tr>
						<td  class="Label">申請日期：</td>
						<td width="20%">
                        <s:date name="iltb01Main.ilReapydt" format="yyyy年MM月dd日"/>
                        </td>
						<td  class="Label">類別：</td>
                        <td>
                        	<s:if test="iltb01Main.ilRetp==0"></s:if>
							<s:elseif test="iltb01Main.ilRetp==1">單次</s:elseif>
							<s:elseif test="iltb01Main.ilRetp==2">多次</s:elseif>
                        </td>
												
					</tr>					<tr>
						<td  class="Label">核准期限：</td>
						<td width="20%">
                        <s:date name="iltb01Main.ilRepmdt" format="yyyy年MM月dd日"/>
                        </td>
						<td  class="Label">備考：</td>
                        <td>${iltb01Main.ilRrnote}</td>
											
					</tr>	

					<tr>
						<td class="Label">原許可證號(6位)：</td>
                        <td width="20%">${iltb01Main.ilRepmdc}</td>	
						<td class="Label">新許可證號(10位)：</td>
                        <td colspan="3" >${iltb01Main.ilRepmdcNic}</td>	</tr>
					</tr>
					<tr><td>&nbsp;</td><tr>
					<tr>
						<td  class="LabelCenter"><b>協尋</b></td>
						<td width="50%" colspan="5"></td>
					</tr>					
					<tr>
						<td  class="Label">處理情形：</td>
						<td width="20%">
							${iltb01Main.ilSrchst}
                        	<%-- <s:if test="iltb01Main.ilSrchst==00">無特殊身份</s:if>
							<s:elseif test="iltb01Main.ilSrchst==31">行方不明</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==32">取消協尋通報</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==33">查獲或收容</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==34">取消收容通報</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==35">收容費預墊</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==36">取消預墊通報</s:elseif> --%>
                        </td>
						<td  class="Label">行方不明日期：</td>
                        <td>
                        <s:date name="iltb01Main.ilMissdt" format="yyyy年MM月dd日"/>
                        </td>
						<td class="Label">報案日期：</td>
                        <td width="20%">
                        <s:date name="iltb01Main.ilSbmtdt" format="yyyy年MM月dd日"/>
                        </td>							
					</tr>					<tr>
						<td  class="Label">報案方式：</td>
						<td width="20%">
                        	<s:if test="iltb01Main.ilSbmttp==0"></s:if>
							<s:elseif test="iltb01Main.ilSbmttp==1">關係人報案</s:elseif>
							<s:elseif test="iltb01Main.ilSbmttp==2">警局主動註記</s:elseif>
							<s:elseif test="iltb01Main.ilSbmttp==3">雇主書面通知</s:elseif>
                        </td>
						<td  class="Label">尋獲單位：</td>
                        <td ><!--(ilFnddid)(用縣市分)-->${ilFnddNm}</td>
						<td  class="Label">尋獲日期：</td>
                        <td width="20%">
                        <s:date name="iltb01Main.ilFnddt" format="yyyy年MM月dd日"/>
                        </td>							
					</tr>	<tr><td>&nbsp;</td><tr>
					<tr>
						<td colspan='2' class="LabelCenter" style='text-align:left'><b>撤(註)銷居留/出國報備</b></td>
						<td width="50%" colspan="5"></td>
					</tr>					
					<tr>
						<td  class="Label">原因：</td>
						<td width="20%">
							<s:if test="iltb01Main.ilFbdrsn==0"></s:if>
							<s:elseif test="iltb01Main.ilFbdrsn==1">申請資料係偽(變)造者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==2">經判處一年以上刑期者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==3">每年居住未達183天者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==4">回復或取得我國國籍者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==5">已取得外僑永久居留證者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==6">經撤銷聘僱許可並限令出國者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==7">其他</s:elseif>	
							<s:elseif test="iltb01Main.ilFbdrsn==8">休學</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn==9">退學</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='A'.toString()">畢業</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='B'.toString()">申請資料虛偽或不實</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='C'.toString()">持用不法取得、偽造或變造之證件</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='D'.toString()">回復我國籍</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='E'.toString()">取得我國籍</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='F'.toString()">兼具我國籍，以國民身分入出國、居留或定居</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='G'.toString()">受驅逐出國</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='H'.toString()">經許可定居</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='I'.toString()">離婚</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='J'.toString()">離婚配偶喪失子女扶養權</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='K'.toString()">依親對象居留事由消失者</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='L'.toString()">當事人主動撤銷</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='M'.toString()">經撤銷、廢止居留許可(居留原因消失)-中途解約</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='N'.toString()">經撤銷、廢止居留許可(居留原因消失)-連續三日曠職</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='O'.toString()">經撤銷、廢止居留許可(居留原因消失)-非法工作</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='P'.toString()">經撤銷、廢止居留許可(居留原因消失)-健檢不合格</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='Q'.toString()">經撤銷、廢止居留許可(居留原因消失)-轉換雇主不成功</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='R'.toString()">經撤銷、廢止居留許可(居留原因消失)-投資</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='S'.toString()">經撤銷、廢止居留許可(居留原因消失)-傳教</s:elseif>
							<s:elseif test="iltb01Main.ilFbdrsn=='T'.toString()">死亡</s:elseif>
						</td>
						<td  class="Label">日期：</td>
                        <td>${iltb01Main.ilMrkdt}</td>
						<td  class="Label">文號：</td>
                        <td width="20%">${iltb01Main.ilMrkdc}</td>							
					</tr>
				</table>
			</fieldset>
			</td>
		</tr>
	</table>
	
	</div>
	<div class="FunctionArea">
		<!-- <input type="button" class='InputButton' value="歷史資料" name="history" onclick="onSubmit('IL03A01Q06.action');" /> -->
		<input type="button" class='InputButton' value="匯出Excel" onclick="onSubmit('IL03A01Q04_2.action');" />
		<input type="button" class='InputButton' value="匯出PDF" onclick="onSubmit('IL03A01Q04_3.action');" />
		<!-- <input type="button" class='InputButton' value="匯出PDF" onclick="toPdf();"/> -->
        <input type="button" class='InputButton' value="外責區-查察記事" name="query" onclick="onSubmit('IL03A01Q07.action');" />
        <!--<input type="button" class='InputButton' value="移民署-查察記事" name="query2" onclick="onSubmit('IL03A01Q07A.action');" />  -->  
		<input type="button" class='InputButton' id="print" name="print" value="列印"  />
		<input type="button" class='InputButton' value="歸戶歷程" onclick="showDialog();" />
		<input type="button" class='InputButton' onclick='javascript:prevPage()' value='回清單'  />
    </div>
    <div id='dialog' title='歸戶歷程'>
    	<div id="searchArcnoHistory" align='center' style="font-size:24px">歸戶歷程搜尋中……</div>
    	<table id="arcnoHistoryList" border='1'>
		    <thead>
		        <tr>
		            <th class="Center" width="150">申請日期</th>
		            <th class="Center" width="200">外來人口統一證號</th>
		        </tr>
		    </thead>
		    <tbody id="arcnoHistoryListTbody">
		    </tbody>
		</table>
    </div>
</div>
</s:form>
</div>
</body>
<script type="text/javascript">

<%-- watermark.load({ watermark_txt: "<%=logUnitNm%>-<%=logcn%>-<%=logtDt%>" }) --%>

/* 依照畫面解析度，動態生成浮水印 */
function setMask() {
	var height = $('#table').height();//table body的高
	var endNumber = 0;
	if($(window).width() <= 1024){
		endNumber = height/220;
	}else{
		endNumber = height/200;
	}
    
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