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
    <link rel="Stylesheet" type="text/css" href="css/shawWu2.css" />	
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
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
	
	<script type="text/javascript">
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
	</script>
	
	<script type="text/javascript">
	
	$(function() {/*	
		$( "#SEX" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#SEX" ).toggle();
		}); 
		$( "#MST" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#MST" ).toggle();
		});
		$( "#FRCEXIT" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#FRCEXIT" ).toggle();
		}); 
		$( "#OP" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#OP" ).toggle();
		});
		$( "#NT" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#NT" ).toggle();
		});
		$( "#UV" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#blUV" ).toggle();
		});
		$( "#ARCST" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#ARCST" ).toggle();
		});
		$( "#EDU" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#EDU" ).toggle();
		});
		$( "#FBDRSN" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#FBDRSN" ).toggle();
		});
		$( "#SRCHST" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#SRCHST" ).toggle();
		});
		$( "#ilMantype" ).combobox();
		$( "#toggle" ).click(function() {
			$( "#ilMantype" ).toggle();
		});	
		*/
		$("#FormSubmit").click(function(){
			
			mergeSelectedARCST();
			mergeSelectedOP();
			mergeSelectedNT();
			mergeSelectedEDU();
			
			if($("#ARCST_LIST").val().split(",").length>10||$("#OP_LIST").val().split(",").length>10||$("#NT_LIST").val().split(",").length>10||$("#EDU_LIST").val().split(",").length>10){				
				$.alert.open("warning", "每個可複選條件請勿選超過10個\n(若要查詢所有項目，則該條件空白即可)");
				
				$('#ARCST_LIST').val('');
				$('#EDU_LIST').val('');
				$('#OP_LIST').val('');
				$('#NT_LIST').val('');
				
				return;
			}
			
			onSubmit("IL03B01P03.action");
		});
			
	});
	
	//$(function() {
	
	//表單送出事件
	function onSubmit(url){
		document.myForm.action=url;
		document.myForm.submit();
	}
	
	
	
	function mergeSelectedARCST(){
		for(i=0;i<document.myForm.ARCST.options.length;i++){
			if(document.myForm.ARCST.options[i].selected==true){
				
				$("#ARCST_LIST").val($("#ARCST_LIST").val()+"'"+document.myForm.ARCST.options[i].value+"',");
				
			}
			
		}
		
		$("#ARCST_LIST").val($("#ARCST_LIST").val().substring(0,$("#ARCST_LIST").val().length-1));
		
		
		
		
	}
	
	
	
	function mergeSelectedOP(){
		for(i=0;i<document.myForm.OP.options.length;i++){
			if(document.myForm.OP.options[i].selected==true){
				
				$("#OP_LIST").val($("#OP_LIST").val()+"'"+document.myForm.OP.options[i].value+"',");
				
			}
			
		}
		
		$("#OP_LIST").val($("#OP_LIST").val().substring(0,$("#OP_LIST").val().length-1));
		
		
		 
		
	}
	
	function mergeSelectedNT(){
		for(i=0;i<document.myForm.NT.options.length;i++){
			if(document.myForm.NT.options[i].selected==true){
				
				$("#NT_LIST").val($("#NT_LIST").val()+"'"+document.myForm.NT.options[i].value+"',");
				
			}
			
		}
		
		$("#NT_LIST").val($("#NT_LIST").val().substring(0,$("#NT_LIST").val().length-1));
		
		
	}
	
	
	function mergeSelectedEDU(){
		for(i=0;i<document.myForm.EDU.options.length;i++){
			if(document.myForm.EDU.options[i].selected==true){
				
				$("#EDU_LIST").val($("#EDU_LIST").val()+"'"+document.myForm.EDU.options[i].value+"',");
				
			}
			
		}
		
		$("#EDU_LIST").val($("#EDU_LIST").val().substring(0,$("#EDU_LIST").val().length-1));
		
		
		
		
	}
	
	
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr><td width="90%"><div class="FuncName">轄區狀況統計資料-自由檢索條件輸入畫面</div></td></tr>
</table>
<p></p>	

<s:form id="myForm" action="" theme="simple">
<div id="queryDiv">	
<table width="90%" align="center" >
<tr><td>
<fieldset>
    <legend>查詢條件</legend>	
	<TABLE width="100%" style="align:center;" border='0'>
		<TR>
			<TD align="right" width="120"  class="Label">管轄警局：</TD>
			<TD colspan="1" width="240">
				<input type="hidden" id="PHQPST" name="PHQPST" value="${ilPst}" />
				<input type="hidden" id="ilPst" name="ilPst" value="${ilPst}" />
				<div id='deptname'>${ilPst}${ilPstName}</div>
				
				<script type="text/javascript">
				($('#deptname').text($('#deptname').text().replace('BE000','AE000').replace('桃園縣','桃園市')));
				</script>
			</TD>
			<TD align=right width=70 id=lblPSTEXT class="Label">外責區：</TD>
			<TD colspan="3" style="WIDTH:200px">
				<INPUT id=PSTEXT name=PSTEXT maxlength=2 tabindex=2 style="WIDTH:38px" value="${ilPstext}" class='InputText'>
				<input type="hidden" id="ilPstext" name="ilPstext" value="${ilPstext}" />
			</TD>
		</TR>
		<TR>
			<TD align="right" class="Label">郵遞區號：</TD><!-- Shaw -->
			<TD colspan=7>
				<input type="hidden" id="ilZipCode" name="ilZipCode" value="${ilZipCode}" />
				<input type="hidden" id="ilZipCodeName" name="ilZipCodeName" value="${ilZipCodeName}" />
				<input type="hidden" id="ilZipCodeList" name="ilZipCodeList" value="${ilZipCodeList}" />
				<input type="hidden" id="ilZipFullNameList" name="ilZipFullNameList" value="${ilZipFullNameList}" />
				${ilZipFullNameList}
			</TD>
		</TR>
		<TR>
			<TD align=right id=lblBTHDTFM class="Label">出生日期：</TD>
        	<TD>
        	    <input name="txtBTHD_FROM" type="text" id="txtBTHD_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtBTHD_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtBTHD_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtBTHD_TO" type="text" id="txtBTHD_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtBTHD_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtBTHD_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD align=right class="Label">性別：</TD>
			<TD>
				<SELECT id=SEX name=SEX tabindex=9  class='InputText'>
					<OPTION value=""></OPTION>
					<OPTION value="1">男</OPTION>
					<OPTION value="2">女</OPTION>
				</SELECT>
			</TD>
			<TD id=lblBTHDTTO width=35></TD>			
	        <TD>
        	    </TD>
			
		</TR>
		<TR>
			<TD align=right valign=top class="Label">居留狀況：</TD>
			<TD colspan=7>
				<!-- <LABEL id=lblARCST></LABEL>
				<INPUT id=btnARCST type=button value=查詢 tabindex=10 title=查詢 >-->
				<SELECT id=ARCST name=ARCST  tabindex=10 class='InputText'  multiple size='6'> 
					
					<OPTION value="1">改變國籍(原具我國籍者)</OPTION>
					<OPTION value="2">在台</OPTION>
					<OPTION value="3">離台</OPTION>
					<OPTION value="4">死亡</OPTION>
					<OPTION value="5">註銷居留證</OPTION>
					<OPTION value="6">棄原國籍取我國籍</OPTION>
				</SELECT>
				<input type='hidden' id='ARCST_LIST' name='ARCST_LIST'> 
			</TD>
		</TR>
		<TR>
			<TD align="right" valign="top" class="Label">職業：</TD><!-- Shaw -->
			<TD colspan="7">
				<select id="OP" name="OP" class='InputText' multiple size='6'>					
					
					<s:iterator value="iltb16JobCodeList" var="iltb16JobCode" status="count">
						<option value="${iltb16JobCode.ilOpcd}">${iltb16JobCode.ilOpcd} ${iltb16JobCode.ilOpnm}</option>	
					</s:iterator>	
					
				</select>
				<input type='hidden' id='OP_LIST' name='OP_LIST'> 					
			</TD>
		</TR>
		<TR>
			<TD align="right" valign="top" class="Label">國籍：</TD><!-- Shaw -->
			<TD colspan=7>
				<select id="NT" name="NT" class='InputText'  multiple size='5'>					
					
					<s:iterator value="iltb15CountryCodeList" var="iltb15CountryCode" status="count">
						<option value="${iltb15CountryCode.ilNtcd}">${iltb15CountryCode.ilNtcd} ${iltb15CountryCode.ilNtnm}</option>	
					</s:iterator>									
				</select>
				<input type='hidden' id='NT_LIST' name='NT_LIST'>
			</TD>
		</TR>
		<TR>
			<TD align=right valign=top class="Label">或 就讀學校：</TD>
			<TD colspan=7>
				<!-- <LABEL id=lblUV></LABEL>
				<INPUT id=btnUV type=button value=查詢 tabindex=15 title=查詢>-->
				<select id="UV" name="UV" tabindex=15 class='InputText'>					
					<option value=""></option>
					<s:iterator value="schoolCodes" var="schoolCode" status="count">
						<option value="${schoolCode.ilUvcd}">${schoolCode.ilUvcd} ${schoolCode.ilUvcnm}</option>	
					</s:iterator>									
				</select>
			</TD>
		</TR>
		<TR>
			<TD align=right id=lblARCFM class="Label">居留期限：</TD><TD>
        	    <input name="txtARC_FROM" type="text" id="txtARC_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtARC_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtARC_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtARC_TO" type="text" id="txtARC_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtARC_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtARC_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblARCTO></TD>
        	<TD>
        	    </TD>
        </TR>
		<TR>
			<TD align=right valign=top class="Label">教育程度：</TD>
			<TD colspan=7>
				<!-- <LABEL id=lblEDU></LABEL>
				<INPUT id=btnEDU type=button value=查詢 tabindex=27 title=查詢 > -->
				<SELECT id=EDU name=EDU tabindex=27 class='InputText'  multiple size='5'> 
					
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
		</TR>
		<TR>
			<TD align=right class="Label">婚姻狀況：</TD>		
			<TD colspan=7>
				<SELECT id=MST name=MST tabindex=28 class='InputText'>
					<OPTION value=""></OPTION>
					<OPTION value=1>單身</OPTION>
					<OPTION value=2>已婚</OPTION>
					<OPTION value=3>其他</OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD align=right class="Label">限期離境：</TD>
			<TD colspan=7>
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
		</TR>
		<TR>
			<TD align=right id=lblAPYDTFM class="Label">申請日期：</TD>
        	<TD>
        	    <input name="txtAPY_FROM" type="text" id="txtAPY_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtAPY_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtAPY_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtAPY_TO" type="text" id="txtAPY_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtAPY_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtAPY_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblAPYDTTO></TD>
        	<TD>
        	    </TD>
	    </TR>
		<TR>
			<TD align=right valign=top class="Label">撤銷居留原因：</TD>
			<TD colspan=7>
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
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD align=right id=lblREAPYDTFM class="Label">重入國申請日期：</TD>
        	<TD>
        	    <input name="txtREAPY_FROM" type="text" id="txtREAPY_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtREAPY_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtREAPY_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtREAPY_TO" type="text" id="txtREAPY_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtREAPY_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtREAPY_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblREAPYDTTO></TD>
        	<TD>
        	    </TD>
	    </TR>
		<TR>
			<TD align=right valign=top class="Label">協尋處理情形：</TD>
			<TD colspan=7>
				<!-- <LABEL id=lblSRCHST></LABEL>
				<INPUT id=btnSRCHST type=button value=查詢 tabindex=52 title=查詢> -->
				<SELECT id=SRCHST name=SRCHST tabindex=52 class='InputText'> 
					<OPTION value=""></OPTION>
					<OPTION value="31">行方不明</OPTION>
					<OPTION value="32">取消協尋通報</OPTION>
					<OPTION value="33">查獲或收容</OPTION>
					<OPTION value="34">取消查獲通報</OPTION>
					<OPTION value="35">收容費預墊</OPTION>
					<OPTION value="36">取消預墊通報</OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD align=right id=lblMISSDTFM class="Label">逃逸日期：</TD>
        	<TD>
        	    <input name="txtMISS_FROM" type="text" id="txtMISS_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtMISS_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtMISS_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
			~
			<input name="txtMISS_TO" type="text" id="txtMISS_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtMISS_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtMISS_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblMISSDTTO></TD>
        	<TD>
        	    </TD>
	    </TR>
		<TR>
			<TD align=right id=lblSBMTDTFM class="Label">或 報案日期：</TD>
        	<TD>
        	    <input name="txtSBMT_FROM" type="text" id="txtSBMT_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtSBMT_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtSBMT_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtSBMT_TO" type="text" id="txtSBMT_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtSBMT_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtSBMT_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblSBMTDTTO></TD>
        	<TD>
        	    </TD>
	    </TR>
		<TR>
			<TD align=right class="Label" >查獲單位：</TD>
			<TD colspan=7>
				<INPUT id=FNDDID name=FNDDID maxlength=5 tabindex=66 style="WIDTH:50px" value="" class='InputText'>
				<LABEL id=lblFNDDID></LABEL>
			</TD>
		</TR>
		<TR>
			<TD align=right id=lblFNDDTFM class="Label">查獲日期：</TD>
        	<TD>
        	    <input name="txtFIND_FROM" type="text" id="txtFIND_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtFIND_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtFIND_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtFIND_TO" type="text" id="txtFIND_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtFIND_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtFIND_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblFNDDTTO></TD>
        	<TD>
        	    </TD>
        </TR>
        <TR>
			<TD align=right id=lblINDTDTFM class="Label">抵台日期：</TD><!-- Shaw -->
        	<TD>
        	    <input name="txtINDT_FROM" type="text" id="txtINDT_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtINDT_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtINDT_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtINDT_TO" type="text" id="txtINDT_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtINDT_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtINDT_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblINDTDTTO></TD>
        	<TD>
        	    </TD>
	    </TR>
	    <TR>
			<TD align=right id=lblEXITFM class="Label">離台日期：</TD><!-- Shaw -->
        	<TD>
        	    <input name="txtEXIT_FROM" type="text" id="txtEXIT_FROM" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtEXIT_FROM',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtEXIT_FROM',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	~
			<input name="txtEXIT_TO" type="text" id="txtEXIT_TO" class="InputText" size="10" onclick="WdatePicker({dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({dateFmt:'yyyy/MM/dd'})" />
                &nbsp;<img onclick="WdatePicker({el:'txtEXIT_TO',dateFmt:'yyyy/MM/dd'})" onfocus="WdatePicker({el:'txtEXIT_TO',dateFmt:'yyyy/MM/dd'})" tabindex="2" src="images/calendar.gif" alt="選擇日期" />
        	
			</TD>
			<TD id=lblEXITTO></TD>
        	<TD>
        	    </TD>
	    </TR>
	    <TR>
			<TD align=right valign=top class="Label">人口分類：</TD><!-- Shaw -->
			<TD colspan="7">
				<SELECT id="ilMantype" name="ilMantype" class='InputText'> 
					<OPTION value="0" selected></OPTION>
					<OPTION value="A">A 治安顧慮人口</OPTION>
					<OPTION value="B">B 注意訪查人口</OPTION>
					<OPTION value="C">C 無顧慮人口</OPTION>
					<OPTION value="D">D 可供諮詢友善人口</OPTION>
				</SELECT>
			</TD>
		</TR>
	</TABLE>
</fieldset>
</td></tr>
</table>
<p></p>
<table border=0 cellPadding=0 cellSpacing=0 align=center>	
    <tr><td>
		<input id="FormSubmit" type="button" class="InputButton" value="確定" title="確定" />
		<input id="FormClear" type="reset" class="InputButton" value="清除" title="清除" />
		<input type="button"
								onclick="javascript:history.go(-1)" name="btnClear"
								value="回上頁" id="btnClear" class="InputButton" />
	</td></tr>
</table>	
</div>
</s:form>
<!--<hr/>
<table border=0 cellPadding=0 cellSpacing=0 align=center>
	<TR>
		<TD align=left width="33%">
			<A href="IL04000M.action"><IMG border=0 height=36 src="images/il/h-12.gif" width=36 Alt="回首頁"></A>
			<A href="IL03B01P01.action"><IMG border=0 height=36 src="images/il/h-3.gif" width=36 Alt="上一層"></A>
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