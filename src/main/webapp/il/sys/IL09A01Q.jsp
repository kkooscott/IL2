<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>權限設定</title>
    <link rel="Stylesheet" type="text/css" href="css/e8.css" />
    <link rel="Stylesheet" type="text/css" href="css/shawWu.css" />
    <script type="text/javascript" src="js/jquery-1.10.0.min.js"></script>
    <script type="text/javascript">
    $(window).load(function(){
    	//取得被更改的boxname
    	var funbox="";
    	$('input[type="checkbox"]').change(function(){  		
        	//alert($(this).attr('name'));
        	var idname=$(this).attr('name')+",";    	
        	funbox=funbox.replace(idname, "");
        	funbox +=idname;
        });
    	//更新
    	$('#btnUpdate').click(function() {
    		doUpdate('IL09A01Update.action',funbox);
    	});
    });
    
        /**更新作業**/
        function doUpdate(url,arr){
        	//判斷成功與否用
        	var check=true;
        
        	var arrid=arr.split(",");

        	$.each(arrid,function(i,id){
        		
        		
        		id=id.replace("btnCheckBox", "");
        		 /**nxn選單事件處理**/
                var FuncDisable = "";
                $("input[name=btnCheckBox"+id+"]").each(function(){
                    //alert(id+", "+$(this).attr("checked")+", "+$(this).attr("id")+", "+ $('input[name=btnCheckBox'+id+']:checked').val());

                    if($(this).prop("checked")){
                        //alert("id: " + $(this).attr("id"));
                        FuncDisable += $(this).attr("id")+",";
                    }
                });

                //alert(FuncDisable);//test
                /**Ajax**/
       
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {Stepid: id, FuncDisable: FuncDisable},
                    async:false,
                    success: function(result){
                        if(result=="true"){
                        	check=check&true;
                        	
                            //alert("修改成功");
                        }else{
                        	check=check&false;
                        	
                           // alert("系統發生錯誤，請洽系統管理員\n錯誤訊息為：資料庫存取異常");
                        }
                    }//success
                });//$.ajax
        	});
        	  
             	alert("資料處理中");
             	 if(check){
      				alert("修改成功");
      			}else if(!check){
      				alert("系統發生錯誤，請洽系統管理員\n錯誤訊息為：資料庫存取異常");
      			}
             
             	
        }
           
    </script>
</head>

<body>
<!--標頭-->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td width="90%">
            <div class="FuncName">權限設定</div>
        </td>
    </tr>
</table>
<p></p>

<!-- 查詢結果視窗 -->
<div class="Form1" id="queryResult" style="width:98%;">
    <table cellspacing="0" width="90%" id="ListTable"  align="center">
        <tr>
            <td>
                <div >

  				  
                    <table class="ListTable" cellspacing="0" rules="all" align="left" border="1" id="GridView1" style="width:100%;border-collapse:collapse;">
                        <thead>
                        <tr>
                            <th class="First" scope="col">群組</th>
                            <th scope="col">功能名稱</th>
                            <s:iterator value="tbRoleList" var="tbRoleSet" status="count">
                                <th scope="col">${tbRoleSet.roleNm}<p>${tbRoleSet.role}</p></th>
                            </s:iterator>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="tbFuncList.{?#this.functag==1}" var="tbFuncSet" status="st">
                            <tr id="tr${st.count}" class="<s:if test="#st.odd == true">odd</s:if><s:else>even</s:else>">
                                <s:iterator value="tbFuncList" var="tbFuncGroupSet" status="gCount">
                                    <s:if test="%{#tbFuncGroupSet.functag==0}">
                                        <s:if test="%{#tbFuncGroupSet.indexid==#tbFuncSet.indexid.substring(0,1)}">
                                            <td class="Center">${tbFuncGroupSet.stepname}</td>
                                        </s:if>
                                    </s:if>
                                </s:iterator>
                                <td class="Center">${tbFuncSet.stepname}</td>
                                <s:iterator value="tbFuncRoleGroupList" var="tbFuncRoleGroupSet" status="count">
                                    <s:if test="%{#tbFuncRoleGroupSet.funcNo == #tbFuncSet.stepid}">
                                        <s:if test="%{#tbFuncRoleGroupSet.enable == 0}">
                                            <td class="Center"><input type="checkbox" id="${tbFuncRoleGroupSet.funcRoleNo}" name="btnCheckBox${tbFuncSet.stepid}" /></td >
                                        </s:if>
                                        <s:else>
                                            <td class="Center"><input type="checkbox" id="${tbFuncRoleGroupSet.funcRoleNo}" name="btnCheckBox${tbFuncSet.stepid}" checked /></td >
                                        </s:else>
                                    </s:if>
                                </s:iterator>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                  
                </div>
            </td>
        </tr>
    </table>
    <table align="center">
    	<tr>
    		<td ><input class="InputButton" type="button" id="btnUpdate" value="更新" /></td>
   	 </tr>
    </table>

</div><!--<div id="queryResult" style="width:100%;">-->
</body>
</html>