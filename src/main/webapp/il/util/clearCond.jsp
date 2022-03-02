<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%
	session.setAttribute("ilArcno", "");	// 居留證號
	session.setAttribute("ilPspt", "");		// 護照號碼
	session.setAttribute("ilEnm", "");		// 英文姓名
	session.setAttribute("ilCnm", "");		// 中文姓名
	session.setAttribute("ilOfnm", "");		// 服務處所名稱
	session.setAttribute("ilPhq", "");		// 警分局代碼 
	session.setAttribute("ilJbpmdt", "");	// 工作許可日期
	session.setAttribute("ilJbpmdc", "");	// 文號

	
	session.setAttribute("ilMicro", "");	// 縮影編號：
	session.setAttribute("ilRepmdc", "");	// 重入國許可證號(6位)
	session.setAttribute("ilRepmdcNic", "");	// 重入國許可證號(10位)
	
	
	session.setAttribute("flag", "R");	// 記日誌
%>
<head>
<title>居留外僑動態管理系統-居留資料查詢作業</title>    
</head>

<body>

</body>
</html>