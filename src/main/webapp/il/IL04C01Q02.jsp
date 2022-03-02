<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
    <script src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="jQuery/development-bundle/themes/custom-theme_2012/jquery.ui.all.css">
    <script type="text/javascript" src="js/domtab.js"></script>  
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
	<script type="text/javascript">
	$(function() {	
		
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr><td width="90%"><div class="FuncName">自由檢索報表(無固定欄項)-欄項選取畫面</div></td></tr>
</table>
<p></p>	 
	
<s:form action="IL04C01Q03" cssClass='Form1'>
<div id="queryResult" style="width:100%;">		 
<table cellspacing="0" width="90%" id="ListTable"  align="center">
<tr><td><div>
	<TABLE class="ListTable" cellspacing="0" cellpadding='5' rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
    	<thead>
    	<TR>
    		<TH class="First" scope="col" width="20%">序號</TH>
			<TH scope="col" width="80%">欄位名稱</TH>
		</TR>
		</thead>
		<tbody>
			<TR class="odd">
				<TD width="20%" style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=1>1</TD>
				<TD>外來人口統一證號</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=2>2</TD>
		        <TD>居留效期(起)</TD>
		    </TR>
		    <TR class="odd">
		    	<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=3>3</TD>
				<TD>居留效期(迄)</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=4>4</TD>
				<TD>護照號碼</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=5>5</TD>
				<TD>英文姓名</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=6>6</TD>
				<TD>中文姓名</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=7>7</TD>
				<TD>國藉</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=8>8</TD>
				<TD>性別</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=9>9</TD>
				<TD>出生日期</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=10>10</TD>
				<TD>職業代碼</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=11>11</TD>
				<TD>居留狀況</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=12>12</TD>
				<TD>居留事由(居留目的)</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=13>13</TD>
				<TD>教育程度</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=14>14</TD>
				<TD>服務處所(大專院校)代碼</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=15>15</TD>
				<TD>服務處所名稱</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=16>16</TD>
				<TD>服務處所電話</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=17>17</TD>
				<TD>工作地址</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=18>18</TD>
				<TD>工作電話</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=19>19</TD>
				<TD>居留地址郵遞區號</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=20>20</TD>
				<TD>居留地址</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=21>21</TD>
				<TD>居留電話</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=22>22</TD>
				<TD>管轄分局代碼</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=23>23</TD>
				<TD>管轄外責區代碼</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=24>24</TD>
				<TD>在華親屬稱謂代碼</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=25>25</TD>
				<TD>在華親屬國藉代碼</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=26 value=>26</TD>
				<TD>逃逸日期</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=27>27</TD>
				<TD>報案日期</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=28>28</TD>
				<TD>查獲日期</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=29>29</TD>
				<TD>協尋處理情形</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=30>30</TD>
				<TD>在台日期</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=31>31</TD>
				<TD>離台日期</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=32>32</TD>
				<TD>親屬身分(居留)證號</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=33>33</TD>
				<TD>親屬姓名</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=34>34</TD>
				<TD>申請日期</TD>
			</TR>			
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=35>35</TD>	
				<TD>人口分類</TD>
			</TR>
			<TR class="even">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=36>36</TD>
				<TD>收據號碼</TD>
			</TR>
			<TR class="odd">
				<TD style='text-align:center'><INPUT id=chkField name=chkField type=checkbox value=37>37</TD>
				<TD>縮影編號</TD>
			</TR>
		</tbody>
	</TABLE>
</div></td></tr></table>
</div>	
	
	<TABLE id=Main5 border=0 cellPadding=0 cellSpacing=0 align=center width='100%'>
		<TR>
			<!--<TD align=left width="33%">
				<A href="IL04000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
				<A href="IL04C01Q01.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
			</TD>-->
			<TD align="center" width="100%" style='text-align:center'>
				<input id="FormSubmit" type="submit" value="確定" title="確定" class='InputButton' />
				<!--input id="FormClear" type="button" value="離開" title="離開" />-->
				<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
			</TD>
			<!--<TD align=right width="33%"><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>-->
		</TR>
	</TABLE>
	</s:form>	
	<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
</body>
</html>