<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-統計報表作業</title> 
    <script src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="jQuery/development-bundle/themes/custom-theme_2012/jquery.ui.all.css">
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
    <link rel="Stylesheet" type="text/css" href="css/e8.css" /> 
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
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
					/**
					.attr( "tabIndex", -1 )
					.attr( "title", "Show All Items" )
					.tooltip()
					**/
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
					/**
					.attr( "title", value + " 不符合輸入資料格式" )
					.tooltip( "open" );
					**/
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
		
	});
	</script>
    
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

<body onload='javascript:window.location="IL03D01P01.action"'>	
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr><td width="90%"><div class="FuncName">自由檢索報表-條件輸入成功畫面</div></td></tr>
</table>
<p></p>	
		
<s:form id="myForm" action="">
<div id="queryDiv" >	
<table width="90%" align="center" style='display:none'>
<tr><td>
<fieldset>
    <legend>條件內容 </legend>	
	<TABLE width="100%" style="align:center;" cellpadding='8'>
		<TR>
		    <TD>使用者ID：</TD><TD>${report.id.ilUid}</TD>
		</TR>
		<!--  
		<TR>
		    <TD>報表ID:</TD><TD>${report.id.ilRptid}</TD>
		</TR>
		-->
		<TR>
		    <TD>報表名稱：</TD><TD>${report.ilRptnm}</TD>
		</TR>
		<TR>
		    <TD>條件字串：</TD><TD>${report.ilWhere1}</TD>
		</TR>
	</TABLE>
</fieldset>
</td></tr>
</table>
</div>
</s:form>
<p></p>	
	
	<!--<hr></hr>
	
	<TABLE id=Main5 border=0 cellPadding=0 cellSpacing=0 align=center width=758>
		<TR>
			<TD align=left width="33%">
				<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
				<A href="IL03000M.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
			</TD>
			<TD align="center" width="33%">
			</TD>
			<TD align=right width="33%"><s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" /></TD>
		</TR>
	</TABLE>-->
</body>
</html>