<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<script type ="text/javascript" >
    $(function() {
   		//實際查詢人送出按鈕動作
   		$('#btnSend').click(function(){
                 $('.opr').hide();
        });
    });//$(function() {
</script>
<div class="opr">
<table width="90%" height="30" border="0"  align="center">
    <tr>
        <td style="color:red ">*此框頁欄位可不輸入；若未輸入頁位案送出件時，系統會預設您極為實際查詢人</td>
    </tr>
</table>
<hr width="90%"></hr>
<table width="90%" height="30" border="0"  align="center">
    <tr>
        <td align="right">實際查詢人:</td>
        <td align="left"><input type="text" size="10" value="林阿鑫"/></td>
        <td align="right"> 實際查詢人單位:</td>
        <td align="left"><input type="text" size="20" value="臺北市警局"/></td>
        <td align="right">用途</td>
        <td align="left"><input type="text" size="20" value="臺北市警局"/></td>
        <td><input id="btnSend" type="button" value="送出"/></td>
    </tr>
</table>
</div>