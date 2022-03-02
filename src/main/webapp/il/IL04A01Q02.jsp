<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head> 
    <title>居留外僑動態管理系統-統計報表作業</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>	
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    
	<script type="text/javascript">
	$(function() {
		/**報表產生**/	
		$("#btnQuery").click(function(){
			var filename = $('input[name=RPT]:checked').val();
			if(filename=="6"){
				window.open("./report/"+$("#RPT2").val());
			}else if(filename=="10"){
				window.open("./report/"+$("#RPT3").val());
			}else if(filename=="13"){
				window.open("./report/"+$("#RPT4").val());
			}else if(filename=="5"){
				window.open("./report/"+$("#RPT1").val());
			}else{
				window.open("./report/"+$('input[name=RPT]:checked').val());
			}		
			
		});
	});//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.queryForm.action=url;
		document.queryForm.submit();
	}
	
	//開新視窗顯示
	function MM_openBrWindow(theURL,winName,width,height) { //v2.0	
		var features= "status=no,location=no,resizable=yes,scrollbars=yes,top=0,left=200,width="+width+",height="+height;
		theURL = theURL+"?RPT="+$('input[name=RPT]:checked').val();
		if($('input[name=RPT]:checked').val()==6){
			theURL = theURL+"&RPT2="+$('#RPT2').val();
		}
		window.open(theURL,winName,features);
	}
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">月統計報表下載-欄項選取畫面</div>
		</td>
	</tr>
</table>
<p></p>

<s:form action="" cssClass='Form1'>
	<div id="queryResult" style="width:100%;">
	<table cellspacing="0" width="90%" id="ListTable" align="center">
		<tr>
			<td class='Label' style='text-align:left'>
			</td>
		</tr>
		<tr>
			<td>
	        <div>
			<TABLE class="ListTable" cellspacing="0" cellpadding="3" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
				<thead>
				
					<TR class="even">
			    		<td class="First" colspan='2' scope="col" width="20%" align="center">
						
			<font size='3'>
			<s:if test="RPT==1"><!-- 永久居留外僑統計 -->
			永久居留外僑統計
			</s:if>
			<s:elseif test="RPT==2"><!-- 現持有效居留證外僑統計 -->
			現持有效居留證外僑統計
			</s:elseif>
			<s:elseif test="RPT==3"><!-- 居留外僑統計 -->
			居留外僑統計
			</s:elseif>
			<s:elseif test="RPT==4"><!-- 行方不明外勞人數統計 -->
			行方不明外勞人數統計
			</s:elseif>
			<s:elseif test="RPT==5"><!-- 現持有效外僑居留證之外籍配偶統計 -->
			現持有效外僑居留證之外籍配偶統計
			</s:elseif>
			<s:elseif test="RPT==6"><!-- 行方不明外僑人數統計 -->
			行方不明外僑人數統計
			</s:elseif>
			<s:elseif test="RPT==7"><!-- 外籍配偶居留統計 -->
			外籍配偶居留統計
			</s:elseif>
			</font>
						
						
						
						</td>
			        
			        </TR>
				
			    	<TR>
			    		<th class="First" scope="col" width="20%" align="center">序號</th>
			        	<th scope="col" width="80%">報表名稱</th>
			        </TR>
        		</thead>
        		<tbody>
		        	<s:if test="RPT==1"><!-- 永久居留外僑統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_01_${chooseDay}.xls" checked>1</td>
				        	<td width="80%">按國籍與職業分</td>
				        </tr>
		        		<tr class="even">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_02_${chooseDay}.xls">2</td>
				        	<td width="80%">按國籍與區域分</td>
				        </tr>
		        	</s:if>
		        	<s:elseif test="RPT==2"><!-- 現持有效居留證外僑統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="5" checked>1</td>
				        	<td width="80%">按國籍與職業分
								<select id="RPT1" name="RPT1" class='InputText'>
				        	        <option value="IL04A01Q03A_07_01_${chooseDay}.xls">臺閩地區現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_02_${chooseDay}.xls">臺灣地區現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_03_${chooseDay}.xls">臺灣省現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_04_${chooseDay}.xls">福建省現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_05_${chooseDay}.xls">臺北市現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_06_${chooseDay}.xls">新北市現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_07_${chooseDay}.xls">台中市現持有效居留證外僑統計</option>
				        	        <option value="IL04A01Q03A_07_08_${chooseDay}.xls">台南市現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_26_${chooseDay}.xls">高雄市現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_09_${chooseDay}.xls">桃園市現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_25_${chooseDay}.xls">基隆市現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_10_${chooseDay}.xls">新竹市現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_11_${chooseDay}.xls">新竹縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_12_${chooseDay}.xls">苗栗縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_13_${chooseDay}.xls">彰化縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_14_${chooseDay}.xls">南投縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_15_${chooseDay}.xls">雲林縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_16_${chooseDay}.xls">嘉義市現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_17_${chooseDay}.xls">嘉義縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_18_${chooseDay}.xls">屏東縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_19_${chooseDay}.xls">台東縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_20_${chooseDay}.xls">花蓮縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_21_${chooseDay}.xls">宜蘭縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_22_${chooseDay}.xls">澎湖縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_23_${chooseDay}.xls">金門縣現持有效居留證外僑統計</option>
									<option value="IL04A01Q03A_07_24_${chooseDay}.xls">連江縣現持有效居留證外僑統計</option>
				        	        
									<!--<option value="IL04A01Q03A_07_27_${chooseDay}.xls">臺閩各縣市現持有效居留證外僑統計</option>-->
								</select>
							
							</td>
							
							
							
				        </tr>
		        		<tr class="even">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_08_${chooseDay}.xls">2</td>
				        	<td width="80%">按國籍與區域分</td>
				        </tr>
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_09_${chooseDay}.xls">3</td>
				        	<td width="80%">按居留目的與區域分</td>
				        </tr>
		        	</s:elseif>
		        	<s:elseif test="RPT==3"><!-- 居留外僑統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'>
			    		    <input type="radio" id="RPT" name="RPT" value="6" checked />1</td>
				        	<td width="80%">按國籍與職業分
				        	    <select id="RPT2" name="RPT2" class='InputText'>
				        	        				        	        <option value="IL04A01Q03A_10_${chooseDay}.xls">臺閩地區居留外僑統計</option>
				        	        <option value="IL04A01Q03A_11_${chooseDay}.xls">臺灣地區居留外僑統計</option>
				        	        <option value="IL04A01Q03A_12_${chooseDay}.xls">臺灣省居留外僑統計</option>
				        	        <option value="IL04A01Q03A_13_${chooseDay}.xls">福建省居留外僑統計</option>
				        	        <option value="IL04A01Q03A_14_${chooseDay}.xls">臺北市居留外僑統計</option>
				        	        <option value="IL04A01Q03A_14_2_${chooseDay}.xls">新北市居留外僑統計</option>
				        	        <!-- <option value="7">桃園市居留外僑統計</option> -->
				        	        <option value="IL04A01Q03A_14_3_${chooseDay}.xls">台中市居留外僑統計</option>
				        	        <option value="IL04A01Q03A_14_4_${chooseDay}.xls">台南市居留外僑統計</option>
									<option value="IL04A01Q03A_15_${chooseDay}.xls">高雄市居留外僑統計</option>
									<option value="IL04A01Q03A_14_5_${chooseDay}.xls">桃園市居留外僑統計</option>
									<option value="IL04A01Q03A_14_21_${chooseDay}.xls">基隆市居留外僑統計</option>
									<option value="IL04A01Q03A_14_6_${chooseDay}.xls">新竹市居留外僑統計</option>
									<option value="IL04A01Q03A_14_7_${chooseDay}.xls">新竹縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_8_${chooseDay}.xls">苗栗縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_9_${chooseDay}.xls">彰化縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_10_${chooseDay}.xls">南投縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_11_${chooseDay}.xls">雲林縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_12_${chooseDay}.xls">嘉義市居留外僑統計</option>
									<option value="IL04A01Q03A_14_13_${chooseDay}.xls">嘉義縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_14_${chooseDay}.xls">屏東縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_15_${chooseDay}.xls">台東縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_16_${chooseDay}.xls">花蓮縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_17_${chooseDay}.xls">宜蘭縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_18_${chooseDay}.xls">澎湖縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_19_${chooseDay}.xls">金門縣居留外僑統計</option>
									<option value="IL04A01Q03A_14_20_${chooseDay}.xls">連江縣居留外僑統計</option>
									
				        	        
				        	        <!--<option value="IL04A01Q03A_16_${chooseDay}.xls">臺閩各縣市居留外僑統計</option>-->
				        	    </select>
				        	</td>
				        </tr>
		        		<tr class="even">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_19_${chooseDay}.xls">2</td>
				        	<td width="80%">按國籍與區域分</td>
				        </tr>
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_17_${chooseDay}.xls">3</td>
				        	<td width="80%">按居留目的與區域分</td>
				        </tr>
		        		<tr class="even">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_18_${chooseDay}.xls">4</td>
				        	<td width="80%">按居留目的與國籍分</td>
				        </tr>
		                <tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_29_${chooseDay}.xls">5</td>
				        	<td width="80%">按職業與區域分</td>
				        </tr>
		        	</s:elseif>
		        	<s:elseif test="RPT==4"><!-- 行方不明外勞人數統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="10" checked>1</td>
				        	<td width="80%">行方不明外勞人數統計
				        		<select id="RPT3" name="RPT3" class='InputText'>
				        	        <option value="IL04A01Q03A_23_${chooseDay}.xls">臺閩地區行方不明外勞人數統計</option>
				        	        <option value="IL04A01Q03A_22_${chooseDay}.xls">臺灣省行方不明外勞人數統計</option>				  	        
				        	    </select>
				        	</td>
				        </tr>
		        	</s:elseif>
		        	<s:elseif test="RPT==5"><!-- 現持有效外僑居留證之外籍配偶統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_27_${chooseDay}.xls" checked>1</td>
				        	<td width="80%">按國籍與區域分</td>
				        </tr>
		        		<tr class="even">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_30_${chooseDay}.xls">2</td>
				        	<td width="80%">按證件與區域分</td>
				        </tr>
		        	</s:elseif>
		        	<s:elseif test="RPT==6"><!-- 行方不明外僑人數統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="13" checked>1</td>
				        	<td width="80%">行方不明外僑人數統計
				        		<select id="RPT4" name="RPT4" class='InputText'>
				        	        <option value="IL04A01Q03A_32_${chooseDay}.xls">臺閩地區行方不明外僑人數統計</option>
				        	        <option value="IL04A01Q03A_31_${chooseDay}.xls">臺灣省行方不明外僑人數統計</option>				  	        
				        	    </select>
				        	</td>
				        </tr>
		        	</s:elseif>  
		        	<s:elseif test="RPT==7"><!-- 外籍配偶居留統計 -->
		        		<tr class="odd">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_28_${chooseDay}.xls" checked>1</td>
				        	<td width="80%">按國籍與區域分</td>
				        </tr>
		        		<tr class="even">
				    		<td width="20%" style='text-align:center'><input type="radio" id="RPT" name="RPT" value="IL04A01Q03A_33_${chooseDay}.xls">2</td>
				        	<td width="80%">按證件與區域分</td>
				        </tr>
		        	</s:elseif>     	
		        </tbody>
			</TABLE>
			</div>
			</td>
		</tr>
	</table>
    </div>
    <center>
    <div class="FunctionArea">				 	
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" value="確定" />         
		<input type="button"
				onclick="javascript:history.go(-1)" name="btnClear"
				value="回上頁" id="btnClear" class="InputButton" />
    </div>
    </center>
	<p></p>	
</s:form>	
<!--<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL04000M.action"><img border='0' height="36" src="./images/il/h-12.gif" width="36" alt='首頁'/></A>
			<A href="IL04A01Q01.action"><img border='0' height='36' src="images/il/h-3.gif" width='36' Alt="上一層"/></A>				
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