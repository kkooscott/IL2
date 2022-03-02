<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>未命名頁面</title><link rel="Stylesheet" type="text/css" href="css/e8.css" />
</head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>

<script type='text/javascript' src='js/jquery-1.10.0.min.js'></script>
<link href="css/jquery.loadmask.css" rel="stylesheet" type="text/css" />
<script type='text/javascript' src='js/jquery.loadmask.js'></script>

<style>

#rslttb{
	font-size: 12px;
	
	border-top: 3px solid #848681;
	border-bottom: 2px solid #848681;
	border-left: 1px solid;
	border-right: 0px;
	margin-bottom: 15px;
	padding: 0px;
	margin-top: 3px;
}


#rslttb td{
	padding:5px;
	//border:1px solid;
	border-bottom: 1px solid;
	border-right: 1px solid;
}
#rslttb th{
	padding:5px;
	//border:1px solid;
	border-bottom: 1px solid;
	border-right: 1px solid;
}
#rslttb tr:hover td{
	background-color:#cccccc;
}
</style>
	
<script type='text/javascript'>	
var currpage;
var datacnt;
var pagecnt;

function goPage(pagenum){
	$("#loadinggif").show();
	$("#rslttb tr").hide();
	setTimeout(function(){
		
		currpage=pagenum;
		$("#currpage").html(pagenum);
		$("#rslttb tr").show();
		$("#rslttb tr:gt(0):lt("+(100*(pagenum-1))+")").hide();
		$("#rslttb tr:gt("+(100*(pagenum))+")").hide();
		window.scrollTo(0,0);
		
		$("#loadinggif").hide();
		
		
		
	},500);
}


function nextPage(){
	if(currpage!=pagecnt){
		
		goPage(currpage+1);
		
	}
}


function prevPage(){
	if(currpage!=1){
		
		goPage(currpage-1);
		
	}
}
function setNevigator(){
	
	$("#datacnt").html(datacnt);
	$("#pagecnt").html(pagecnt);
}

function doQry(){
	
	
	//alert($("#sqlstr").val().toUpperCase());
	
	var inputsql=$("#sqlstr").val().toUpperCase();
	
	if(inputsql.indexOf("UPDATE")!=-1||inputsql.indexOf("DELETE")!=-1||inputsql.indexOf("INSERT")!=-1||inputsql.indexOf("EXEC")!=-1||inputsql.indexOf("ALTER")!=-1||inputsql.indexOf("DROP")!=-1||inputsql.indexOf("CREATE")!=-1||inputsql.indexOf("TRUNCATE")!=-1||inputsql.indexOf("SP_")!=-1){
		alert("僅允許查詢作業");
		return;
	}
	
	
	$("#queryResult").mask("查詢中");
	$("#form1")[0].submit();
}

</script>
	
</head>

<!--<body onload='javascript:changeMainUsage(getCookie("usage"));setCookie("actuser","",1);setCookie("actunit","",1);setCookie("usage","",1);'>-->
<body onload='javascript:$("#form1")[0].reset();'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <div class="FuncName">
                    SQL指令查詢
                </div>
            </td>
        </tr>
    </table>
<form id="form1" method="post" class="Form1">

	
<div id="queryResult">

		
	

        <table width="80%" align="center">
        <tr><td><fieldset>
		<legend>SQL指令</legend>
			<table width="90%" align='center'>                   
				<tr><td width="100%" class="dataField" class='dataField;text-align:center !important'>
				<textarea id='sqlstr' name='sqlstr' rows='5' style='width:100%' class='InputText'><%=null==request.getParameter("sqlstr")?"":request.getParameter("sqlstr").toString()%></textarea>
				</td></tr>
				
			</table>
		
		</fieldset>
		
		
        <table align="center" cellspacing="0" cellpadding="0" width="90%">
            <tr>
                <td style="text-align: center;">
                    <div class="FunctionArea">
                        <input type="button" name="btnSave" value="查 詢" id="btnSave" class="InputButton" onclick='javascript:doQry()'/>
                        <input type="button" name="btnCancel" value="清 空" id="btnCancel" class="InputButton" onclick="javascript:$('#sqlstr').val('')"/>
                    </div>
                </td>
            </tr>
        </table>
		</td></tr>
		</table>
    </div>
</form>

<div id="queryResult">


	
	
    <%
	
	if(null!=(request.getParameter("sqlstr"))&&!"".equals(request.getParameter("sqlstr"))){
	%>
		<span>第</span><span style="color:Red;"><div style='display:inline' id='currpage'></div></span><span>頁 
		(共</span><span style="color:Red;"><div style='display:inline' id='pagecnt'></div></span><span>頁,</span>
		<span style="color:Red;"><div style='display:inline' id='datacnt'></div></span>筆)
		&nbsp;&nbsp;&nbsp;
		[<a  onclick='javascript:goPage(1)'>第一頁</a>/
		<a onclick='javascript:prevPage()'>上一頁</a>] 
		&nbsp;
			<div style='display:inline' id='pagelist'></div>
		&nbsp; [<a onclick='javascript:nextPage()'>下一頁</a>/
		<a  onclick='javascript:goPage(pagecnt)'>最末頁</a>]
		<br><br>
		
		<div id='msgdiv1' style='display:none'><font color='red'>超過500筆，僅顯示前500筆</font></div><div id='msgdiv2' style='display:none'><font color='red'>執行錯誤</font></div>
		
		<img id='loadinggif' src='images/loading.gif'>
	
	<%
	}
		
	ResultSet rdr=null;
	Connection conn=null;
	if(null!=(request.getParameter("sqlstr"))&&!"".equals(request.getParameter("sqlstr"))){
		try{
			String sqlstr=request.getParameter("sqlstr").toString();
			
			Properties prop = new Properties();
	        
	        
				ResourceBundle dbConfig = ResourceBundle.getBundle("db");
				
				String connstr=dbConfig.getString("connstr");
				String dbuser=dbConfig.getString("user");
				String dbpwd=dbConfig.getString("pwd");
				conn = DriverManager.getConnection(connstr, dbuser, dbpwd);
	            
			
			Statement stmt=conn.createStatement();
			rdr=stmt.executeQuery(sqlstr);
			
		}catch(Exception ex){
			//ScriptManager.RegisterClientScriptBlock(this, this.GetType(), "msg", "alert('執行失敗!');", true);
			out.println("<script type='text/javascript'>$('#msgdiv2').show()</script>");
		}
	}
	
	
	if(rdr!=null){
		
	
	
		int datacnt=0;
		out.println("<table id='rslttb' cellpadding='3' cellspacing='0' style='display:none'><tr><th>編號</th>");
		
		
		ResultSetMetaData rdrmd=rdr.getMetaData();
		
		
		
		for(int i=0;i<rdrmd.getColumnCount();i++){
			out.println("<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rdrmd.getColumnName(i+1)+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>");
		}
		out.println("</tr>");
		
		while(rdr.next()){
		
			datacnt++;
			if(datacnt==501){
				
				break;
			}
			out.println("<tr><td align='center'>"+datacnt+"</td>");
			
	
			for(int i=0;i<rdrmd.getColumnCount();i++){
				out.println("<td align='center'>"+rdr.getString(i+1)+"</td>");
				
			}
			out.println("</tr>");
			
		}
		conn.close();
		
		out.println("</table>");
		
		
		if(datacnt==501){
			datacnt=500;
			out.println("<script type='text/javascript'>$('#msgdiv1').show()</script>");
		}
		
		
		String pagelist="";
		for(int i=0;i<Math.ceil((double)datacnt/100);i++){
			pagelist+="<a onclick='javascript:goPage("+(i+1)+")'>"+(i+1)+"</a>";
			
			if(i!=Math.ceil((double)datacnt/100)-1){
				pagelist+="&nbsp;&nbsp;";
			}
		}
		
	%>
	
		<script type='text/javascript'>
		$("#rslttb").show();
		currpage=1;
		datacnt=<%=datacnt%>;
		pagecnt=<%=Math.ceil((double)datacnt/100)%>;
		
		$("#pagelist").html("<%=pagelist%>");
		
		setNevigator();
		goPage(1);
		
		$("#resultGrid tr:odd").addClass('odd');
		$("#resultGrid tr:even").addClass('even');
		
		</script>
	
	<%
	}	
	
	%>
	


</div>

</body>
</html>


