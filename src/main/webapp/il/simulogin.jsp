<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
	<link rel="Stylesheet" type="text/css" href="css/e8.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.10.0.min.js"></script>
	<script type="text/javascript">
    $(function() {
        $('#btnLogin').click(function () {

            if (!$('#username').val()) {
                alert('請輸入登入帳號');
                return false;
            }

            if (!$('#password').val()) {
                alert('請輸入密碼');
                return false;
            }

            $('#reportForm').attr("action", "doSimuAudit.action");
            $('#reportForm').submit();
            return false;
        });

    });
    	$(window).load(function()
	{
			if($('#control').val()=="N")
		{
				alert("帳號或密碼錯誤，請重新輸入。");
		}
	}
	);
	</script>
    <title></title>
</head>
<body>
<s:if test="hasActionErrors()">
    <div class="errors">
        <s:actionerror/>
    </div>
</s:if>
<form id="reportForm" method="post">

<div id='bgdiv' style='position:absolute;z-index:-10;top:-100px;left:0px'>

<img src='images/login_bg.jpg'>

</div>

    <div id="localDiv">
<!--<center><font size=6 >居留外僑動態管理系統</font></center>
        <table>
            <tr>
                <td>帳號</td>
                <td>
                    
                </td>
                <td>
                    
                </td>
            </tr>
            <tr>
                <td>密碼</td>
                <td>
                    
                </td>
                <td>
                    
                </td>
            </tr>
        </table>
		
-->		
<input id="btnLogin" type="button" value="登入" style='display:none'/>
<input id="btnLeave" type="button" value="離開" style='display:none'/>
		<div id='formdiv' style='position:absolute;z-index:1;top:180px;left:220px'>
		<table width='450px' border='0'>
	<tr><td><font size='6' face='微軟正黑體'><b>居留外僑動態管理系統</b></font></td></tr>
	<tr><td height='50px'>　</td></tr>
	<tr><td>　　<font size='4' face='微軟正黑體'>帳號</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' onkeyup='javascript:this.value=$(this).val().toUpperCase()' class='InputText' id="username" name="username" value='' style='font-size:16pt'>　　　</td><td style='background-color:#80e969;cursor:pointer' width='100px' align='center' onclick='javascript:$("#btnLogin").click()'><font size='4' face='微軟正黑體'>登入</font></td></tr>
	<tr style='display:none'><td><font size='1'>&nbsp;</font></td></tr>
	<tr style='display:none'><td>　　<font size='4' face='微軟正黑體'>密碼</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type='password' class='InputText' id="password" name="password" value='test' style='width:200px;height:25px;font-size:16pt'>　　　</td><td style='background-color:#f37a83;cursor:pointer' align='center' onclick='javascript:$("#btnLeave").click()'><font size='4' face='微軟正黑體'>離開</font></td></tr>
	<tr><td>　　<font size='4' face='微軟正黑體'>角色</font>&nbsp;&nbsp;&nbsp;&nbsp;<select class='InputText' style='font-size:16pt' id='userrole' name='userrole'><option>ILN00001</option><option>ILN00002</option><option>ILN00004</option></select></td>
	<td  align='center' ></td></tr>
	<tr><td>　　<font size='4' face='微軟正黑體'>姓名</font>&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' style='font-size:16pt' onkeyup='javascript:this.value=$(this).val().toUpperCase()' class='InputText' id="usercname" name="usercname" value='' >
	</td>
	<td  align='center' ></td></tr>
	
	<tr><td>　　<font size='4' face='微軟正黑體'>單位</font>&nbsp;&nbsp;&nbsp;&nbsp;<select class='InputText' style='font-size:16pt' id='userdid' name='userdid'><option>A1E31</option><option>A2271</option><option>BJ0B1</option></select></td>
	</td>
	<td  align='center' ></td></tr>
	
	
	</table>
		</div>
		
		
		
		
		
		
    </div>
</form>
</body>
</html>