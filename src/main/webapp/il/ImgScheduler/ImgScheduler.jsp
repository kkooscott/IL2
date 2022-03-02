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


function updateBatch(id,bt){
	if(confirm("加入排程?")){
			
		$("#setid").val(id);
		$("#setpwd").val(bt.parentNode.parentNode.cells[2].childNodes[0].value);
		
		$("#form1")[0].submit();
		
	}else{
		return;
	}
}

</script>
	
</head>

<!--<body onload='javascript:changeMainUsage(getCookie("usage"));setCookie("actuser","",1);setCookie("actunit","",1);setCookie("usage","",1);'>-->
<body onload='javascript:$("#form1")[0].reset();'>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td>
                <div class="FuncName">
                    影像資料匯入
                </div>
            </td>
        </tr>
    </table>
<form id="form1" method="post" class="Form1">

<input type='hidden' id='setid' name='setid' value=''>
<input type='hidden' id='setpwd' name='setpwd' value=''>



<div id="queryResult">


	<table cellspacing="0" width="90%" id="ListTable"  align="center" border='0'>
    <tr><td>
	
	<%
	
		
	ResultSet rdr=null;
	Connection conn=null;

		try{
			
			
			Properties prop = new Properties();
	        
	        
			ResourceBundle dbConfig = ResourceBundle.getBundle("db");
			
			String connstr=dbConfig.getString("connstr");
			String dbuser=dbConfig.getString("user");
			String dbpwd=dbConfig.getString("pwd");
				
			conn = DriverManager.getConnection(connstr, dbuser, dbpwd);
			
			Statement stmt=conn.createStatement();
			
			if(request.getParameter("setid")!=null&&request.getParameter("setpwd")!=null){
				stmt.execute("update IL_SCHEDULE_MNG set mUserName=(mUserName||'@'||'"+request.getParameter("setpwd")+"'),status='0',sTime=getdate() where id="+request.getParameter("setid")+" and status=''");
			}
			
			
			rdr=stmt.executeQuery("select * from IL_SCHEDULE_MNG where status=''");
			
		}catch(Exception ex){
			
			out.println(ex.toString());
		}

		
		int datacnt=0;
		out.println("<table class='ListTable' id='resultGrid' cellpadding='3' cellspacing='0'><tr><th class=First  width='10%'>編號</th><th>檔名</th><th width='30%'>密碼</th><th>排程</th></tr>");

		while(rdr.next()){
		
			datacnt++;
			
			out.println("<tr><td style='text-align:center'>"+datacnt+"</td><td>"+rdr.getString("mUserName")+"</td><td><input type='text' class='InputText' style='width:100%'></td><td style='text-align:center'><input type='button' value='確定' onclick='javascript:updateBatch("+rdr.getString("id")+",this)' class='InputButton'></td></tr>");
				
		}
		conn.close();
		
		if(datacnt==0){
			out.println("<tr><td colspan='4' style='text-align:center'><font size='5' face='微軟正黑體'>無待處理檔案</font></td></tr>");
		
		}
		
		out.println("</table>");
		

		
		
	%>
	</td></tr></table>
		
	

	

</div>
</form>
<script type='text/javascript'>
	$("#resultGrid tr:odd").addClass('odd');
	$("#resultGrid tr:even").addClass('even');
		
</script>
</body>
</html>


