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
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />	
    
	<script type="text/javascript">
	$(function(){	
		
	});//$(function(){
	
	//表單送出事件
	function onSubmit(){
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
			<div class="FuncName">查察記事-明細內容顯示畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 表單區塊 -->
<s:form id="myForm" action="IL02A01U04">
<!-- 日誌用開始 -->
<input type="hidden" id="logcn" name="logcn" value="${logcn}" />
<input type="hidden" id="logpstname" name="logpstname" value="${logpstname}" />
<input type="hidden" id="main" name="main" value="${main}" />
<input type="hidden" id="detail" name="detail" value="${detail}" />
<!-- 日誌結束 -->
<input type="hidden" id="ilArcid" name="ilArcid" value="${iltb01Main.ilArcid}" />
<input type="hidden" id="ilEnm" name="ilEnm" value="${iltb01Main.ilEnm}" />
<input type="hidden" id="ilArcno" name="ilArcno" value="${iltb01Main.ilArcno}" />
<div id="queryResult">
	<table width="90%" align="center">
		<tr>
			<td>
			<fieldset>
				<legend></legend>
				<table width="100%">			
					<tr>
						<td width="10%" class="Label">英文姓名：</td>
						<td width="20%">${iltb01Main.ilEnm}</td>
						<td width="10%" class="Label"></td>
                        <td width="20%"></td>
						<td width="10%" class="Label">中文姓名：</td>
                        <td width="20%">${iltb01Main.ilCnm}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">性別：</td>
						<td width="20%">
							<s:if test="iltb01Main.ilSex==1">男</s:if>
							<s:elseif test="iltb01Main.ilSex==2">女</s:elseif>						
						</td>
						<td width="10%" class="Label">國籍：</td>
                        <td width="20%">${ilNTNM}</td>
						<td width="10%" class="Label">出生日期：</td>
                        <td width="20%"><s:property value="iltb01Main.ilBthdt.substring(0,4)"/>年<s:property value="iltb01Main.ilBthdt.substring(4,6)"/>月<s:property value="iltb01Main.ilBthdt.substring(6,8)"/>日</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">護照號碼：</td>
						<td width="20%">${iltb01Main.ilPspt}</td>
						<td width="10%" class="Label">護照期限：</td>
                        <td width="20%"><s:date name="iltb01Main.ilPsdt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">教育程度：</td>
                        <td width="20%">
	                        <s:if test="iltb01Main.ilEdu==00"></s:if>
							<s:elseif test="iltb01Main.ilEdu==01">博士</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==02">碩士</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==03">大學畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==04">大學肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==05">專科畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==06">專科肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==07">高中畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==08">高中肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==09">初中畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==10">初中肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==11">小學畢業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==12">小學肄業</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==13">識字</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==14">不識字</s:elseif>
							<s:elseif test="iltb01Main.ilEdu==15">不明</s:elseif>
                        </td>							
					</tr>
					<tr>
						<td width="10%" class="Label">抵台日期：</td>
						<td width="20%"><s:date name="iltb01Main.ilIndt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">離台日期：</td>
                        <td width="20%"><s:date name="iltb01Main.ilExdt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">職業：</td>
                        <td width="20%">${ilOpnm}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">居留事由：</td>
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
						<td width="10%" class="Label">居留狀況：</td>
                        <td width="20%">
                        	<s:if test="iltb01Main.ilArcst==1">改變國籍(原具我國籍者)</s:if>
							<s:elseif test="iltb01Main.ilArcst==2">在台</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==3">離台</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==4">死亡</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==5">註銷居留證</s:elseif>
							<s:elseif test="iltb01Main.ilArcst==6">棄原國籍取我國籍</s:elseif>                                            
                        </td>
						<td width="10%" class="Label">縮影編號：</td>
                        <td width="20%">${iltb01Main.ilMicro}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">
							<s:if test="iltb01Main.ilArcrsn==1">依親對象：</s:if>
							<s:elseif test="iltb01Main.ilArcrsn==2">就讀學校：</s:elseif>
							<s:else>服務處所：</s:else>
						</td>
						<td width="20%">${iltb01Main.ilOfnm}</td>
						<td width="10%" class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilOftel}</td>
						<td width="10%" class="Label">職位：</td>
                        <td width="20%">${iltb01Main.ilJbpsn}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">工作地址：</td>
						<td width="50%" colspan="3">${iltb01Main.ilJbaddr}</td>						
						<td width="10%" class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilJbtel}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">居留地址：</td>
						<td width="50%" colspan="3">${iltb01Main.ilAraddr}</td>						
						<td width="10%" class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilArtel}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">仲介公司：</td>
						<td width="50%" colspan="3">${iltb01Main.ilAgnco}</td>						
						<td width="10%" class="Label">電話：</td>
                        <td width="20%">${iltb01Main.ilAgntel}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label">備註：</td>
						<td width="50%" colspan="5">${iltb01Main.ilRemrk}</td>																		
					</tr>
					<tr>
						<td width="10%" class="Label"></td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					
					<tr>
						<td width="10%" class="LabelCenter">工作許可</td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					<tr>
						<td width="10%" class="Label">機關：</td>
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
						<td width="10%" class="Label">許可日期：</td>
                        <td width="50%" colspan="3"><s:date name="iltb01Main.ilJbpmdt" format="yyyy年MM月dd日"/></td>											
					</tr>
					<tr>
						<td width="10%" class="Label">文號：</td>
						<td width="20%">${iltb01Main.ilJbpmdc}</td>
						<td width="10%" class="Label">許可效期：</td>
                        <td width="50%" colspan="3"><s:date name="iltb01Main.ilJbpmfm" format="yyyy年MM月dd日"/> ~ <s:date name="iltb01Main.ilJbpmto" format="yyyy年MM月dd日"/></td>											
					</tr>
					<tr>
						<td width="10%" class="Label"></td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					<tr>
						<td width="10%" class="Label">申請日期：</td>
						<td width="20%"><s:date name="iltb01Main.ilApydt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">收據號碼：</td>
                        <td width="50%" colspan="3">${iltb01Main.ilArcrcp}</td>											
					</tr>
					<tr>
						<td width="10%" class="Label">外來人口統一證號：</td>
						<td width="20%">${iltb01Main.ilArcno}</td>
						<td width="10%" class="Label">居留效期：</td>
                        <td width="50%" colspan="3"><s:date name="iltb01Main.ilArcfm" format="yyyy年MM月dd日"/> ~ <s:date name="iltb01Main.ilArcto" format="yyyy年MM月dd日"/></td>											
					</tr>
					<tr>
						<td width="10%" class="Label">管轄分局：</td>
						<td width="20%">${e0UnitSNm}</td>
						<td width="10%" class="Label">限期離境：</td>
                        <td width="50%" colspan="3">                     
	                        <s:if test="iltb01Main.ilFrcexit==00"></s:if>
							<s:elseif test="iltb01Main.ilFrcexit==21">違反就服法</s:elseif>
							<s:elseif test="iltb01Main.ilFrcexit==22">取消限期出境通報</s:elseif>
							<s:elseif test="iltb01Main.ilFrcexit==23">體檢不合格</s:elseif>
							<s:elseif test="iltb01Main.ilFrcexit==24">取消體檢通報</s:elseif>
							<s:elseif test="iltb01Main.ilFrcexit==2A">列管</s:elseif>
							<s:elseif test="iltb01Main.ilFrcexit==2B">取消列管通報</s:elseif>                       
                        </td>											
					</tr>
					<tr>
						<td width="10%" class="Label"></td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					
					<tr>
						<td width="10%" class="LabelCenter">在華親屬</td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					<tr>
						<td width="10%" class="Label">稱謂：</td>
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
						<td width="10%" class="Label">姓名：</td>
                        <td width="50%" colspan="3">${iltb01Main.ilFnm}</td>											
					</tr>
					<tr>
						<td width="10%" class="Label">國籍：</td>
						<td width="20%">${ilNTNMFnt}</td>
						<td width="10%" class="Label">身分(居留)證號：</td>
                        <td width="50%" colspan="3">${iltb01Main.ilFpid}</td>											
					</tr>
					<tr>
						<td width="10%" class="Label"></td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					
					<tr>
						<td width="10%" class="LabelCenter">重入國</td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					<tr>
						<td width="10%" class="Label">申請日期：</td>
						<td width="20%"><s:date name="iltb01Main.ilReapydt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">類別：</td>
                        <td width="20%">
                        	<s:if test="iltb01Main.ilRetp==0"></s:if>
							<s:elseif test="iltb01Main.ilRetp==1">單次</s:elseif>
							<s:elseif test="iltb01Main.ilRetp==2">多次</s:elseif>
						</td>
						<td width="10%" class="Label">原許可證號( 6位)：</td>
                        <td width="20%">${iltb01Main.ilRepmdc}</td>							
					</tr>	
					<tr>
						<td width="10%" class="Label">核准期限：</td>
						<td width="20%"><s:date name="iltb01Main.ilRepmdt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">備考：</td>
                        <td width="20%">${iltb01Main.ilRrnote}</td>
						<td width="10%" class="Label">新許可證號(10位)：</td>
                        <td width="20%">${iltb01Main.ilRepmdcNic}</td>							
					</tr>
					<tr>
						<td width="10%" class="Label"></td>
						<td width="50%" colspan="5"></td>																		
					</tr>	
					<tr>
						<td width="10%" class="Label">撤(註)銷居留/出國報備：</td>
						<td width="50%" colspan="5">						
							<s:if test="iltb01Main.ilMrkcs==0"></s:if>
							<s:elseif test="iltb01Main.ilMrkcs==1">出國報備</s:elseif>
							<s:elseif test="iltb01Main.ilMrkcs==2">撤(註)銷居留</s:elseif>
						</td>																		
					</tr>
					<tr>
						<td width="10%" class="Label">原因：</td>
						<td width="50%" colspan="5">
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
					</tr>
					<tr>
						<td width="10%" class="Label">日期：</td>
						<td width="20%"><s:date name="iltb01Main.ilMrkdt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">文號：</td>
                        <td width="50%" colspan="3">${iltb01Main.ilMrkdc}</td>											
					</tr>
					<tr>
						<td width="10%" class="Label"></td>
						<td width="50%" colspan="5"></td>																		
					</tr>
					
					<tr>
						<td width="10%" class="LabelCenter">協尋</td>
						<td width="50%" colspan="5"></td>																		
					</tr>		
					<tr>
						<td width="10%" class="Label">處理情形：</td>
						<td width="20%">
							<s:if test="iltb01Main.ilSrchst==00"></s:if>
							<s:elseif test="iltb01Main.ilSrchst==31">行方不明</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==32">取消協尋通報</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==33">查獲或收容</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==34">取消收容通報</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==35">收容費預墊</s:elseif>
							<s:elseif test="iltb01Main.ilSrchst==36">取消預墊通報</s:elseif>
						</td>
						<td width="10%" class="Label">逃逸日期：</td>
                        <td width="20%"><s:date name="iltb01Main.ilMissdt" format="yyyy年MM月dd日"/></td>
						<td width="10%" class="Label">報案日期：</td>
                        <td width="20%"><s:date name="iltb01Main.ilSbmtdt" format="yyyy年MM月dd日"/></td>							
					</tr>	
					<tr>
						<td width="10%" class="Label">報案方式：</td>
						<td width="20%">
							<s:if test="iltb01Main.ilSbmttp==0"></s:if>
							<s:elseif test="iltb01Main.ilSbmttp==1">關係人報案</s:elseif>
							<s:elseif test="iltb01Main.ilSbmttp==2">警局主動註記</s:elseif>
							<s:elseif test="iltb01Main.ilSbmttp==3">雇主書面通知</s:elseif>
						</td>
						<td width="10%" class="Label">查獲單位：</td>
                        <td width="20%"><!--(ilFnddid)(用縣市分)-->${ilFnddNm}</td>
						<td width="10%" class="Label">查獲日期：</td>
                        <td width="20%"><s:date name="iltb01Main.ilFnddt" format="yyyy年MM月dd日"/></td>							
					</tr>														
				</table>
			</fieldset>
			</td>
		</tr>
	</table>
	<div class="FunctionArea">
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" onclick="onSubmit();" value="查察記事" />
    </div>
</div>
</s:form>
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL02000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL02A01U02.action?ilNtnm=${ilNtnm}&ilNtcd=${ilNtcd}&ilPspt=${ilPspt}&ilEnm=${ilEnm}&txtBEGIN_DT=${txtBEGIN_DT}&ilArcno=${ilArcno}"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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