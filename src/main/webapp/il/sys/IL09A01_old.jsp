<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>權限設定</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <script type="text/javascript" src="js/jquery-1.8.3.js"/>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript">
	$(function() {
	
	
	});//$(function() {
    </script>
</head>

<body>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">權限設定</div>
		</td>
	</tr>
</table>
<p></p>

<!-- 查詢結果視窗 -->
<div id="queryResult" style="width:100%;">
<table cellspacing="0" width="90%" id="ListTable"  align="center">
	<tr>
		<td>
        <div>
			<table class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
				<thead>
					<tr>
						<th class="First" scope="col">群組</th>
                        <th scope="col">功能名稱</th>
                        <th scope="col">居留外僑一般權限<p>CWN00001</p></th>
                        <th scope="col">警/分局承辦人<p>CWN00002</p></th>
                        <th scope="col">署承辦人<p>CWN00004</p></th>
                        <th scope="col">更新</th>						
					</tr>
				</thead>
				<tbody>
					<s:iterator value="iltbFuncList" id="iltbFuncSet" status="count">
		                <tr bgcolor =lightcyan>
							<td class="Center">${iltbFuncSet.ilFuncGroup}</td>
							<td class="Center">${iltbFuncSet.ilFuncNm}</td>
							<td class="Center"><input type="checkbox" id="${iltbFuncSet.ilFuncNo}CWN00001"  name="${iltbFuncSet.ilFuncNo}" /></td >
							<td class="Center"><input type="checkbox" id="${iltbFuncSet.ilFuncNo}CWN00002"  name="${iltbFuncSet.ilFuncNo}" /></td>
							<td class="Center"><input type="checkbox" id="${iltbFuncSet.ilFuncNo}CWN00004"  name="${iltbFuncSet.ilFuncNo}" /></td>
		                	<td class="Center"><input type="button" name="btnUpdate" id="btnUpdate" class="InputButton" value="更新" /></td>
		                </tr >
		            </s:iterator >
					<!-- 
					<tr class="odd">
						<td class="Center">
	                    <input id="GridView1_chkRow_0" type="checkbox" name="GridView1$ctl02$chkRow" />
	                    </td>
	                    <td style="width:40%;">
	                    <a href="javascript:__doPostBack(&#39;GridView1&#39;,&#39;Select$0&#39;)">公告1</a>
	                    </td>
	                    <td class="Center" style="width:20%;">102/07/09</td>
	                    <td class="Center" style="width:20%;">102/08/10</td>
					</tr>
					<tr class="even">
						<td class="Center">
							<input id="GridView1_chkRow_1" type="checkbox" name="GridView1$ctl03$chkRow" />
	                    </td>
	                    <td style="width:40%;"><a href="javascript:__doPostBack(&#39;GridView1&#39;,&#39;Select$1&#39;)">公告2</a></td>
	                    <td class="Center" style="width:20%;">102/07/08</td>
	                    <td class="Center" style="width:20%;">102/08/10</td>
					</tr>
					<tr class="odd">
						<td class="Center">
	                    	<input id="GridView1_chkRow_2" type="checkbox" name="GridView1$ctl04$chkRow" />
	                    </td>
	                    <td style="width:40%;"><a href="javascript:__doPostBack(&#39;GridView1&#39;,&#39;Select$2&#39;)">公告3</a></td>
	                    <td class="Center" style="width:20%;">102/07/08</td>
	                    <td class="Center" style="width:20%;">102/08/10</td>
					</tr>
					<tr class="even">
						<td class="Center">
							<input id="GridView1_chkRow_3" type="checkbox" name="GridView1$ctl05$chkRow" />
						</td>
						<td style="width:40%;"><a href="javascript:__doPostBack(&#39;GridView1&#39;,&#39;Select$3&#39;)">公告4</a></td>
						<td class="Center" style="width:20%;">102/07/08</td>
						<td class="Center" style="width:20%;">102/08/10</td>
					</tr>
					<tr class="odd">
						<td class="Center">
	                        <input id="GridView1_chkRow_4" type="checkbox" name="GridView1$ctl06$chkRow" />
	                    </td>
	                    <td style="width:40%;"><a href="javascript:__doPostBack(&#39;GridView1&#39;,&#39;Select$4&#39;)">公告5</a></td>
	                    <td class="Center" style="width:20%;">102/07/07</td>
	                    <td class="Center" style="width:20%;">102/08/10</td>
					</tr>
					 -->
				</tbody>
				<tr class="GridPager">
					<td colspan="4">
						<table>
							<tr>
								<td><span>1</span></td>
								<td><a href="javascript:__doPostBack(&#39;GridView1&#39;,&#39;Page$2&#39;)">2</a></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		</td>
	</tr>
	<!-- 
    <tr>
		<td style="text-align:center;">
            &nbsp;<span id="lbGridPageInfo"><span>第</span><span style="color:Red;">1</span><span>頁 (共</span><span style="color:Red;">2</span><span>頁,</span><span style="color:Red;">7</span><span>筆)</span></span>
            &nbsp;&nbsp; [<a id="lkbtnPageFirst" href="javascript:__doPostBack(&#39;lkbtnPageFirst&#39;,&#39;&#39;)">第一頁</a>/
            <a id="lkbtnPageUp" class="aspNetDisabled">上一頁</a>] &nbsp;
            <a id="pageNum1" class="aspNetDisabled">1</a>, <a id="pageNum2" href="javascript:__doPostBack(&#39;pageNum2&#39;,&#39;&#39;)">2</a>
            &nbsp; [<a id="lkbtnPageDown" href="javascript:__doPostBack(&#39;lkbtnPageDown&#39;,&#39;&#39;)">下一頁</a>/
            <a id="lkbtnPageLast" href="javascript:__doPostBack(&#39;lkbtnPageLast&#39;,&#39;&#39;)">最末頁</a>]
        </td>
    </tr>
     -->
</table>
</div><!--<div id="queryResult" style="width:100%;">-->
</body>
</html>
