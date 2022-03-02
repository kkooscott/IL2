<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd XHTML 1.0 transitional//EN" "http://www.w3.org/tr/xhtml1/Dtd/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<select id="ilZipCode" name="ilZipCode" class="InputSelect" >
	<s:iterator value="npaZipCodeBeanList" id="result" status="count">		
		<option value="${result.KT_PZONE}">${result.KT_PZONE}${result.KT_TOWN}</option>					
	</s:iterator>
</select>
