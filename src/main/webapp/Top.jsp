<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Untitled Document</title>
    <script type="text/javascript" src="./js/jquery-1.10.0.min.js"></script>   
    <link rel="stylesheet" type="text/css" href="css/common.css"/>    
    <script language="javascript" type="text/javascript">
        var TIME_COUNTDOWN = 40 * 60;
        /* var TIME_COUNTDOWN = 180 * 60;
         設定倒數計時時間總長度(秒) */
        var timeRemain;
        var timerID = null;

        function start_countdown() {
            if (timeRemain <= 0) { /* 剩餘時間為0, 把視窗關閉 */
                window.top.ResetCountDown = null;
                //window.top.index.rows = "0,0,*";
                alert("您已經太久沒有使用系統，為保護帳號及系統安全，請重新登入系統！");
                closeSessionAndWindow(); // 呼叫關閉 session 的方法
                window.top.close();
                return;
            } else {
                timerID = setTimeout(start_countdown, 1000);
                timeRemain--;
                show_timer();
            }
        }

        function show_timer() {
            var elm = document.getElementById("timerDisplay");
            if (elm == null) return;
            var intH, intM;
            var strH, strM;

            intH = Math.floor(timeRemain / 60);
            intM = timeRemain % 60;
            strH = "00" + intH.toString();
            strM = "00" + intM.toString();
            strH = strH.substr(strH.length - 2, 2);
            strM = strM.substr(strM.length - 2, 2);

            elm.innerHTML = " " + strH + ":" + strM + " ";
        }

        function reset_timer() {
            if (timerID != null)
                clearTimeout(timerID);
            timeRemain = TIME_COUNTDOWN;
            start_countdown();
        }

        function closeSessionAndWindow() {
            // 發送 Ajax 請求，通知伺服器清除 session
            $.ajax({
                url: 'il/util/UserSessionCleaner.jsp', // 調用 UserSessionCleaner.jsp 來無效化 session
                type: 'GET',
                async: false, // 確保請求完成後再關閉視窗
                complete: function () {
                    window.top.close(); // 關閉視窗
                }
            });
        }


        $(window).load(function () {
            $('#btnLeave').click(function () {
                closeSessionAndWindow(); // 手動關閉 session 並關閉視窗
                // window.top.close();
                return false;
            });

            $('#goHome').click(function () {
                parent.location.reload();
                return;
            });

            $('#btnTestLogin').click(function (){
                parent.location.replace("toLogin.action");
                return;
            });

        });
        window.top.ResetCountDown = reset_timer;
    </script>
    <style>
        .timer {
            color: Lime;
            font-weight: bold;
            font-family: monospace;
            background: Black;
            width: 100px;
        }
    </style>

</head>
<body onload="reset_timer();">
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-image: url(images/bannerBgbg.jpg);">
    <tr>
        <td class="bannerBg"  valign="top" width="100%" height="60">
            <div style="position:relative">
                <div class="wMsg" style="position:absolute; right:0px; top:0px;z-index:99">
            <span class="welcomeMsg">
                歡迎&nbsp;<s:property value='#session.LOGCN'/>&nbsp;登入，您將<span class="timer" id="timerDisplay">&nbsp;&nbsp;</span>後登出&nbsp;&nbsp;
			</span>
                    <a id="goHome" style="cursor:hand;cursor:pointer;color:#B55110;text-decoration:none;cursor:hand;">回首頁</a>
                    <!--<a id="btnTestLogin" style="cursor:hand;cursor:pointer;color:#FF0000;text-decoration:none;">測試登入</a>&nbsp;-->
                    <span id="btnLeave" style="cursor:hand;cursor:pointer;color:#B55110;text-decoration:none;">離開</span>
                    <span id="testspan"></span>
                </div>
            </div>
            &nbsp;
        </td>
    </tr>
</table>
<div style="position:absolute; top:30px; left:250px; z-index:10"><img src="images/sysname.png" border="0" align="absmiddle" /></div>
</body>


</html>
