<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
	<head>
		<title>居留外僑動態管理系統-共用代碼維護作業</title>
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/domtab.css" />
		<link rel="stylesheet" type="text/css" href="css/e8.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/domtab.js"></script>
		<script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
		<link id="total" type="text/css"
			href="js/pager/jquery.tablesorter.pager.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jquery.tablesorter.min.js"></script>
		<script type="text/javascript"
			src="js/pager/jquery.tablesorter.pager.js"></script>
		<script type="text/javascript" src="js/Validator.js" charset="utf-8"></script>
		<script type="text/javascript">
	function onSubmit() {

		if (!$('#resultList').find(':radio').is(':checked')) {
			$.alert.open("warning", "項目未選取");
		} else {
			$('#resultList > tbody > tr').each(function(i, e) {
				var rdo = $(this).find(':radio');
				var sid = $(this).find('.sid').text();

				if ($(rdo).is(':checked')) {

					$.ajax({
				        url: 'IL07B00D.action',
				        type: 'post',
				        data: {
				        	txtOPCD : sid,
					        },
					        async:false,
					        success: function(result) { 
						        if(result == 'true') {
						        	$.alert.open({
						        	    content: '刪除成功',
						        	    callback: function() {
						        	    	window.location = "IL07B00M.action";
						        	    }
						        	});
						        }else {
						        	$.alert.open({
						        	    content: '刪除失敗',
						        	    callback: function() {
						        	    	window.location = "IL07B00M.action";
						        	    }
						        	});
						        }
					        }
				    });
				}
			});
		}

	}
</script>

		<style type="text/css">
#resultList td.sid {
	text-align: center;
	vertical-align: middle;
}

em {
	color: red;
}
</style>
	</head>

	<body>
	<%@ include file="util/mask.jsp" %>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="90%">
					<div class="FuncName">
						職業類別代碼刪除-資料選取畫面
					</div>
				</td>
			</tr>
		</table>

		<form id="form1" name="form1" method="post" class='Form1'>

			<input id="txtOPCD" name="txtOPCD" type="hidden" value="${ txtOPCD }" />
			<display:table id="resultList" name="queryList" pagesize="5" cellpadding="8" 
				requestURI="IL07B03D02.action"
				decorator="tw.gov.npa.il.decorator.IL07BDecorator"
				style="width:100%;border-collapse:collapse;">
				<display:column headerClass="First" class="Center"
					property="function" title="選取" />
				<display:column class="Center" title="筆次">${resultList_rowNum}</display:column>
				<display:column class="sid" property="OPCD" title="職業類別代碼" />
				<display:column class="Center" property="OPNM" title="中文名稱" />
				<display:column class="Center" property="OPPRSQ" title="列印順序" />
				<display:column class="Center" property="OPCS" title="統計歸屬代碼" />
			</display:table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td style="text-align: center;">
					<div class="FunctionArea">
						<input type="button" class='InputButton' value="確　定" onclick="onSubmit();" />
						<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
					</div>
				</td>
			</tr>
		</table>
		</form>

		
<!--
		<hr/>
		<table border=0 cellPadding=0 cellSpacing=0 align=center>
			<TR>
				<TD align=left width="33%">
					<A href="IL07000M.action"><img border='0' height="36"
							src="./images/il/h-12.gif" width="36" alt='首頁' /> </A>
					<A href="IL07A03D01.action"><img border='0' height='36'
							src="images/il/h-3.gif" width='36' Alt="上一層" /> </A>
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