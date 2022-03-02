<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
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
    <title>居留外僑動態管理系統-勤區查察作業</title>   
    <script src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="jQuery/development-bundle/themes/custom-theme_2012/jquery.ui.all.css">
    <link rel="stylesheet" type="text/css" href="css/sweetalert2.min.css" />
	<script src="jQuery/development-bundle/jquery-1.9.1.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.core.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.widget.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.button.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.position.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.menu.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.autocomplete.js"></script>
	<script src="jQuery/development-bundle/ui/jquery.ui.tooltip.js"></script>
    <script language="javascript" type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/myValidator.js"></script>
    <script type="text/javascript" src="js/sweetalert2.min.js"></script>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />
    <style>
	  
	  
	  .custom-combobox {
	    position: relative;
	    display: inline-block;
	  }
	  .custom-combobox-toggle {
	    position: absolute;
	    top: 0;
	    bottom: 0;
	    margin-left: -1px;
	    padding: 0;
	    /* support: IE7 */
	    *height: 1.2em;
	    *top: 0.1em;
	  }
	  .custom-combobox-input {
	    margin: 0;
	    padding: 0.3em;
	  }
	</style>
	
	<script>
	/*
	(function( $ ) {
		$.widget( "custom.combobox", {
			_create: function() {
				this.wrapper = $( "<span>" )
					.addClass( "custom-combobox" )
					.insertAfter( this.element );

				this.element.hide();
				this._createAutocomplete();
				this._createShowAllButton();
			},

			_createAutocomplete: function() {
				var selected = this.element.children( ":selected" ),
					value = selected.val() ? selected.text() : "";

				this.input = $( "<input>" )
					.appendTo( this.wrapper )
					.val( value )
					.attr( "title", "" )
					.addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
					.autocomplete({
						delay: 0,
						minLength: 0,
						source: $.proxy( this, "_source" )
					})
					.tooltip({
						tooltipClass: "ui-state-highlight"
					});

				this._on( this.input, {
					autocompleteselect: function( event, ui ) {
						ui.item.option.selected = true;
						this._trigger( "select", event, {
							item: ui.item.option
						});
					},

					autocompletechange: "_removeIfInvalid"
				});
			},

			_createShowAllButton: function() {
				var input = this.input,
					wasOpen = false;

				$( "<a>" )
					
					//.attr( "tabIndex", -1 )
					//.attr( "title", "Show All Items" )
					//.tooltip()
					
					.appendTo( this.wrapper )
					.button({
						icons: {
							primary: "ui-icon-triangle-1-s"
						},
						text: false
					})
					.removeClass( "ui-corner-all" )
					.addClass( "custom-combobox-toggle ui-corner-right" )
					.mousedown(function() {
						wasOpen = input.autocomplete( "widget" ).is( ":visible" );
					})
					.click(function() {
						input.focus();

						// Close if already visible
						if ( wasOpen ) {
							return;
						}

						// Pass empty string as value to search for, displaying all results
						input.autocomplete( "search", "" );
					});
			},

			_source: function( request, response ) {
				var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
				response( this.element.children( "option" ).map(function() {
					var text = myBestTrim($( this ).text());
					if ( this.value && ( !request.term || matcher.test(text) ) )
						return {
							label: text,
							value: text,
							option: this
						};
				}) );
			},

			_removeIfInvalid: function( event, ui ) {

				// Selected an item, nothing to do
				if ( ui.item ) {
					return;
				}

				// Search for a match (case-insensitive)
				var value = this.input.val(),
					valueLowerCase = value.toLowerCase(),
					valid = false;
				this.element.children( "option" ).each(function() {
					if ( $( this ).text().toLowerCase() === valueLowerCase ) {
						this.selected = valid = true;
						return false;
					}
				});

				// Found a match, nothing to do
				if ( valid ) {
					return;
				}

				// Remove invalid value
				this.input
					.val( "" )
					
					//.attr( "title", value + " 不符合輸入資料格式" )
					//.tooltip( "open" );
					
				this.element.val( "" );
				this._delay(function() {
					this.input.tooltip( "close" ).attr( "title", "" );
				}, 2500 );
				this.input.data( "ui-autocomplete" ).term = "";
			},

			_destroy: function() {
				this.wrapper.remove();
				this.element.show();
			}
		});
	})( jQuery );

	$(function() {
		$( "#ilNtcd" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#ilNtcd" ).toggle();
		});
	});
	*/
	</script>
	
    <script type="text/javascript">
	$(function() {
	
	});//$(function() {
	
   	function onSubmit(url){	

		if($("#main")[0].selectedIndex==0){
			swal("請輸入查詢用途");
			return;
		}

		if($("#main")[0].selectedIndex==6&&$("#other").val()==""){
			swal("請輸入查詢用途");
			return;
		}
	
   		if(myBestTrim(document.myForm.ilNtcd.value)==""&&myBestTrim(document.myForm.ilPspt.value)==""&&myBestTrim(document.myForm.ilEnm.value)==""&&myBestTrim(document.myForm.ilArcno.value)==""){
			swal("星號條件至少輸入一項");
			return;
		}
		/**    
	    if(myBestTrim(document.myForm.ilNtcd.value)==""&&myBestTrim(document.myForm.ilPspt.value)==""&&myBestTrim(document.myForm.ilEnm.value)==""&&myBestTrim(document.myForm.ilArcno.value)==""){
			window.alert("國籍該欄不可為空 !!!");
			document.myForm.NTCD.focus();
			return;
		}
		
		if(myBestTrim(document.myForm.ilPspt.value)==""){
			window.alert("護照號碼該欄不可為空 !!!");
			document.myForm.ilPspt.focus();
			return;
		}
		
		if(myBestTrim(document.myForm.ilEnm.value)==""){
			window.alert("英文姓名該欄不可為空 !!!");
			document.myForm.ilEnm.focus();
			return;
		}else{
			if(contain(document.myForm.ilEnm.value, "%\(\)><")){
				window.alert("英文姓名內含非法字元 !!!");
				document.myForm.ilEnm.focus();
				return;
			}
		}
		if(myBestTrim(document.myForm.ilArcno.value)==""){
			window.alert("外來人口統一證號該欄不可為空 !!!");
			document.myForm.ilArcno.focus();
			return;
		}				
		**/
		else{
			
			document.myForm.ilPspt.value=document.myForm.ilPspt.value.toUpperCase();
			document.myForm.ilEnm.value=document.myForm.ilEnm.value.toUpperCase();
			//alert(document.myForm.ilArcno.value);
			document.myForm.ilArcno.value=document.myForm.ilArcno.value.toUpperCase();
			//alert(document.myForm.ilArcno.value);
			document.myForm.action=url;
			document.myForm.submit();	
		}
					
	}
	</script>
    
</head>

<body onload='javascript:$("#main")[0].selectedIndex=0'>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="90%">
			<div class="FuncName">查察記事-條件輸入畫面</div>
		</td>
	</tr>
</table>
<p></p>
<!-- 查詢條件視窗 -->  
<s:form id="myForm" action="">
<input type="hidden" id="ilNtnm" name="ilNtnm" value="" />
<!-- -----------------委託查詢人-------------------------  -->
<s:action name="searcher" executeResult="true" namespace="/"></s:action>
<!-- -------------------------------------------------  -->
<div id="queryDiv">	
	<table width="90%" align="center" >
		<tr>
			<td>
				<fieldset>
					<legend>查詢條件</legend>
					<table width="100%" style="align:center;">
						<tr>
							<td width="10%" class="Label">*國籍：</td>
							<td width="40%">
								<select id="ilNtcd" name="ilNtcd" class='InputText'>					
									<option value=""></option>
									<s:iterator value="iltb15CountryCodeList" var="result" status="count">
										<option value="${result.ilNtcd}">${result.ilNtcd} ${result.ilNtnm}</option>	
									</s:iterator>									
								</select>
							</td>                      
						</tr>					
						<tr>
							<td width="10%" class="Label">*護照號碼：</td>
							<td width="40%">
								<input id='ilPspt' name='ilPspt' maxlength='15' class="InputText" style="width:300px;" />
							</td>                         
						</tr>
						<tr>
							<td width="10%" class="Label">*英文姓名：</td>
							<td width="40%">
								<input id='ilEnm' name='ilEnm' maxlength='50' class="InputText" style="width:300px;" />
							</td>                         
						</tr>
						<tr>
							<td width="10%" class="Label">出生日期：</td>
                            <td>
								<input name="txtBEGIN_DT" type="text" id="txtBEGIN_DT" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                                &nbsp;<img onclick="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
							</td>
						</tr>
						<tr>
							<td width="10%" class="Label">*外來人口統一證號：</td>
							<td width="40%">
								<input id='ilArcno' name='ilArcno' maxlength='15' class="InputText" style="width:300px;" />
							</td>                         
						</tr>
					</table>
				</fieldset>
			</td>
		</tr>
	</table>
	<p></p>
	<div class="FunctionArea">				 	
    	<input type="button" name="btnQuery" id="btnQuery" class="InputButton" onclick="onSubmit('IL02A01U02.action');" value="查 詢" />
        <input type="reset" name="btnClear" id="btnClear" class="InputButton" value="清 除" />                   
    </div>	
</div>
<p></p>	
</s:form>
<!--
<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL02000M.action"><img border='0' height="36" src="./images/il/h-12.gif" width="36" alt='首頁'/></A>
			<A href="IL02000M.action"><img border='0' height='36' src="images/il/h-3.gif" width='36' Alt="上一層"/></A>				
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