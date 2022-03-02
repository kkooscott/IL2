<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2013/6/21
  Time: 下午 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公告顯示</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" />
    <script language="javascript" type="text/javascript" src="js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>
</head>

<body>

  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="90%">
                <div class="FuncName">
                    公告顯示
                </div>
            </td>
        </tr>
    </table>
<form id="form1" runat="server" class='Form1'>
    <br>
    <div id="queryResult" width="100%">
        <table cellspacing="0" width="90%" id="ListTable"  align="center">
            <tr>
                <td>
                    <div>
                    <fieldset>
  				 		<legend>系統公告</legend>
						<table width="100%" border='0'>                   
						<tr>
						<td class="Label">
						
  				 		 <display:table id="sAnnounce" name="sAnnounce" pagesize="10" requestURI="toCW09A01Q.action"
                                        decorator="tw.gov.npa.il.decorator.CW09A01Decorator"
                                        class="ListTable" cellpadding="8" cellspacing="0">
                                <display:column style="width:70%" headerClass="First"  property="content" title="內容"/>
                                <display:column style="width:15%" class="Center" property="beginDate" title="開始日期"/>
                                <display:column style="width:15%" class="Center" property="endDate" title="結束日期"/>
                            </display:table>
							
							</td></tr></table>
                     </fieldset>   
                    </div>
                </td>
            </tr>
        </table>
    </div>

    <div id="queryResult2" width="100%">
        <table cellspacing="0" width="90%" id="ListTable2"  align="center">
            <tr>
                <td>
                    <div>
                    <fieldset>
  				 		 <legend>一般性公告</legend>
						 
						 <table width="100%" border='0'>                   
						<tr>
						<td class="Label">
						 
                       	 <display:table id="nAnnounce" name="nAnnounce"  pagesize="10" requestURI="toCW09A01Q.action"
                                        decorator="tw.gov.npa.il.decorator.CW09A01Decorator"
                                        class="ListTable" style=""  cellpadding="8" cellspacing="0">
                                <display:column style="width:70%" headerClass="First" property="content" title="內容"/>
                                <display:column style="width:15%" class="Center" property="beginDate" title="開始日期"/>
                                <display:column style="width:15%" class="Center" property="endDate" title="結束日期"/>
                            </display:table>
							
						</td></tr></table>
                    </fieldset> 
                    </div>
                </td>
            </tr>
        </table>
    </div>
<!-- 
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="90%">
                <div class="FuncName">
                    公告顯示
                </div>
            </td>
        </tr>
    </table>

    <br/>
    <div id="queryResult" width="100%">
        <table cellspacing="0" width="90%" id="ListTable"  align="center">
            <tr>
                <td>
                    <div>
                        <table class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
                            <tr>
                                <th class="First" scope="col">一般性公告</th>
                            </tr>            
                            <s:iterator value="nAnnounce" status="st">
                                <tr class="<s:if test="#st.odd == true">odd</s:if><s:else>even</s:else>">
                                <td><s:property value="ilBeginDt"/></td>
                                    <td class="Center">
                                        <s:property value="ilContent"/>
                                    </td>
                  <td><s:property value="ilEndDt"/></td>
                                </tr>
                            </s:iterator>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </div>

    <div id="queryResult2" width="100%">
        <table cellspacing="0" width="90%" id="ListTable2"  align="center">
            <tr>
                <td>
                    <div>
                        <table class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView2" style="width:100%;border-collapse:collapse;">
                            <tr>
                                <th class="First" scope="col">系統維護公告</th>
                            </tr>
                            <s:iterator value="sAnnounce" status="st">
                                <tr class="<s:if test="#st.odd == true">odd</s:if><s:else>even</s:else>">
                                    <td class="Center">
                                        <s:property value="ilContent"/>
                                    </td>
                                </tr>
                            </s:iterator>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </div>
     -->
	 </form>
</body>

<%
/*
out.println(session.getAttribute("LOGUID"));
out.println(session.getAttribute("LOGDID"));
out.println(session.getAttribute("LOGUIP"));
out.println(session.getAttribute("LOGTDT"));
out.println(session.getAttribute("USERROLES"));
*/


%>
</html>
