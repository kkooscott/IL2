<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!-- 
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
-->
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <title>居留外僑動態管理系統-權限管理作業</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/domtab.css"/>
    <script src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/domtab.js"></script>   
    <script type="text/javascript" src="js/alert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom-lite.css" />
		<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.4.custom.css" />
		<link rel="stylesheet" type="text/css" href="css/alert.min.css" />
		<link rel="stylesheet" type="text/css" href="themes/default/theme.min.css" />
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet" />
    <style type="text/css">
      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    
    <script type ="text/javascript" >
   	
	</script>
    
</head>

<body>
<%@ include file="util/mask.jsp" %>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="background-color:#ACB8C6;">
	    <tr>
	        <td width="120" align="center"><img src="images/arrow.jpg" border="0" align="middle"/></td>
	        <td width="98%" class="pageTitle">權限管理作業-登入作業</td>
	    </tr>
	</table>
	<p></p>
	
	<!-- <hr id='Main2' width='758'></hr>  --> 
	
	
	<div class="container" style="width:758px;" align="center">

      <form class="form-signin">
        <h2 class="form-signin-heading">登入作業</h2>
        <input type="text" class="input-block-level" placeholder="帳號">
        <input type="password" class="input-block-level" placeholder="密碼">
        <!-- 
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> 記住我
        </label>
         -->
        <button class="btn btn-large btn-primary" type="submit">登入</button>
      </form>

    </div> <!-- /container -->
	
	
	<!-- <s:date name="nowDate" format="yyyy-MM-dd HH:ss:mm" />	 -->
	<!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap-transition.js"></script>
    <script src="bootstrap/js/bootstrap-alert.js"></script>
    <script src="bootstrap/js/bootstrap-modal.js"></script>
    <script src="bootstrap/js/bootstrap-dropdown.js"></script>
    <script src="bootstrap/js/bootstrap-scrollspy.js"></script>
    <script src="bootstrap/js/bootstrap-tab.js"></script>
    <script src="bootstrap/js/bootstrap-tooltip.js"></script>
    <script src="bootstrap/js/bootstrap-popover.js"></script>
    <script src="bootstrap/js/bootstrap-button.js"></script>
    <script src="bootstrap/js/bootstrap-collapse.js"></script>
    <script src="bootstrap/js/bootstrap-carousel.js"></script>
    <script src="bootstrap/js/bootstrap-typeahead.js"></script>
</body>
</html>