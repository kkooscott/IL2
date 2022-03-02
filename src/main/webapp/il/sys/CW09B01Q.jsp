<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2013/6/21
  Time: 下午 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>公告維護</title>

    <link rel="Stylesheet" type="text/css" href="css/e8.css" />
    <style type="text/css">
        #resultList td.sid {
            display: none;
        }
        #resultList th.First {
            display: none;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.10.0.min.js"> </script>

    <script type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
    <script type="text/javascript">
        $(window).load(function () {
            if($('#msg').val() != ""){
                alert($('#msg').val());
                $('#msg').val('');
            }

            $('#btnQuery').click(function () {
            	
            	var check=true;
            	
            	if($("#txtEND_DT").val()!=""&&$("#txtBEGIN_DT").val()!=""&& ($("#txtBEGIN_DT").val()>$("#txtEND_DT").val())){check=false;alert("起日不可大於至日");}
            	
            	if(check){
                $('#reportForm').attr("action", "doQuery09B.action");
                $('#reportForm').submit();
                return false;
            	}
            });

            $('#btnInsert').click(function () {
                $('#reportForm').attr("action", "toCW09B02A.action");
                $('#reportForm').submit();
                return false;
            });

            $('#btnDelete').click(function(){
                var deleteList = new Array();

                $('#resultList > tbody > tr').each(function (i, e) {
                    var chk = $(this).find(':checkbox');
                    var sid = $(this).find('.sid').text();

                    if ($(chk).is(':checked')) {
                        var col = sid;
                        deleteList.push(col);
                    }
                });

               //console.log("deleteList: " + deleteList);
                $('#deleteList').val(deleteList);

                $('#reportForm').attr("action", "doDelete09B.action");
                $('#reportForm').submit();
            });


        });
    </script>
</head>

<body>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="90%">
                <div class="FuncName">
                    公告資料維護
                </div>
            </td>
        </tr>
    </table>
<form id="reportForm" method="post" class="Form1">


    <br>

    <!-- 查詢條件視窗 -->
    <div id="queryDiv">
        <table width="90%" align="center" >
            <tr>
                <td >
                    <fieldset>
                        <legend>查詢條件</legend>
                        <table width="100%">
                            <tr>
                                <td width="10%" class="Label">
                                    *公告種類
                                </td>
                                <td width="40%">
                                    <s:select cssClass="InputSelect"
                                            headerKey="-1"
                                            list="#{'0':'不限','1':'一般公告', '2':'系統公告'}"
                                            name="input.kind"
                                            value="0" theme="simple"
                                           />
                                </td>
                                <td width="10%" class="Label">
                                    *公告期間
                                </td>
                                <td>
                                    <s:textfield name="input.beginDate"  id="txtBEGIN_DT" cssclass="InputText" size="10"
                                                 onclick="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                                 onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                                 theme="simple" cssClass='InputText'/>
                                    &nbsp;<img onclick="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyy/MM/dd'})"
                                               onfocus="WdatePicker({el:'txtBEGIN_DT',dateFmt:'yyy/MM/dd'})"
                                               tabindex="2" src="images/calendar.gif"
                                               align="absmiddle" alt="選擇日期" />
                                    &nbsp;至
                                    <s:textfield name="input.endDate" id="txtEND_DT" class="InputText" size="10"
                                                 onclick="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                                 onfocus="WdatePicker({dateFmt:'yyy/MM/dd'})"
                                                 theme="simple" cssClass='InputText'/>
                                    &nbsp;<img style="cursor: hand"
                                               onclick="WdatePicker({el:'txtEND_DT',dateFmt:'yyy/MM/dd'})"
                                               onfocus="WdatePicker({el:'txtEND_DT',dateFmt:'yyy/MM/dd'})"
                                               tabindex="4" src="images/calendar.gif"
                                               align="absmiddle" alt="選擇日期" />
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </td>
            </tr>
        </table>

        <br>

        <table align="center" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <div class="FunctionArea">
                        <input type="button" name="btnQuery" value="查 詢" id="btnQuery" class="InputButton" />
                        <input type="reset" name="btnClear" value="清 除" id="btnClear" class="InputButton" />
                        <input type="button" name="btnInsert" value="新 增" id="btnInsert" class="InputButton" />
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <p></p>

    <!-- 查詢結果視窗 -->
    <s:if test='%{hasQuery}'>
        <div id="queryResult" width="100%">

            <table cellspacing="0" width="90%" id="ListTable"  align="center">
                <tr>
                    <td>
                        <div>
                            <display:table id="resultList" name="result" pagesize="10" requestURI="doQuery09B.action" cellpadding="8" 
                                           decorator="tw.gov.npa.il.decorator.CW09B01Decorator"
                                           style="width:100%;border-collapse:collapse;">
                                <display:column headerClass="First" property="sid" class="sid" title="流水號"/>
                                <display:column class="Center" property="select" title="選取"/>
                                <display:column class="content" property="content" title="內容"/>
                                <display:column class="Center" property="beginDate" title="開始日期"/>
                                <display:column class="Center" property="endDate" title="結束日期"/>
                            </display:table>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td style="text-align:right;">
                        <div class="FunctionArea">
                            <input type="button" name="btnDelete" value="刪　除" id="btnDelete" class="InputButton" />
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </s:if>
    <s:hidden name="deleteList" id="deleteList"/>
    <s:hidden name="msg" id="msg"/>
</form>
</body>
</html>