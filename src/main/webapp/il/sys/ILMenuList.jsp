<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>目錄清單</title>
    <!--<link rel="Stylesheet" type="text/css" href="css/e8.css" /> -->
    
    <link href="css/common.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/accordion.css" type="text/css" media="screen" />
    
    <script type="text/javascript" src="js/jquery-1.10.0.min.js"/>
    <script type="text/javascript" src="js/domtab.js"></script>
    
	<script type="text/javascript">

        $(document).ready(function () {
            $('.accordionHeaders:first').addClass('selected').next('.contentHolder').slideDown();
            $('.accordionHeaders').click(function () {
                $('.accordionHeaders').removeClass('selected');
                $('.contentHolder').slideUp();
                $(this).addClass('selected').next('.contentHolder').slideDown();
                
				//Shaw新增;去除點選主選單功能時, 反白畫面留在原功能項目         
              	$('.accordionContent').removeClass('selectedcontent');                
            });

            $('.accordionContent').click(function () {
                $('.accordionContent').removeClass('selectedcontent');
                $('.grandchild').slideUp();
                $(this).addClass('selectedcontent').next('.grandchild').slideDown();
            });

        });
    </script>
    <style type="text/css">
    .style1 {
        color: #0000FF
    }
    </style>
    
</head>

<body style="margin-left: 0px; margin-top: 0px;">

<div class="accordion">
	<%--目錄結構 --%>	
	<s:iterator value="getMenuList" var="m1" status="m1Cnt">
		<div id="${m1.index}" class="accordionHeaders">
        
        	<s:if test='%{#m1.url==0}'>
        		${m1.stepName}
        	</s:if>
        	<s:else>
        		${m1.stepName}
        	</s:else>	        
	    </div>
	    <div class="contentHolder">
	    		    	       
		    <s:iterator value="top.childList" var="m2" status="m2Cnt">
		    	<s:set var="isNull" value="1" />		    
		        <div class="accordionContent">
		            <a href="${m2.url}" target="mainFrame"><span></span>${m2.stepName}</a>
		        </div>		    
		    </s:iterator>
		    
		    <s:if test="%{#isNull!=1}">
		    	<script type="text/javascript">		    	
				$("#"+<s:property value="#m1.index"/>).hide();
		    	</script>
		    </s:if>
		    
		    <s:set var="isNull" value="0" />	
	    </div>
	</s:iterator>
		
</div>
</body>
</html>
