<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>居留外僑動態管理系統1</title>
  </head>
  
  <body>
<frameset rows="60,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="Top.html" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset rows="*" cols="200,7,*" framespacing="0" frameborder="no" border="0" name="bottomFrame" id="bottomFrame">
    <frame src="Left.html" name="leftFrame" scrolling="auto" id="leftFrame" title="leftFrame" />
    <frame src="Slider.html" name="sliderFrame" id="sliderFrame" scrolling="no" noresize />
    <frame src="IL02000M.action" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
  </body>
</html>
