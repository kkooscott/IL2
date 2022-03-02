<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<script type="text/javascript">
    $(function () {
        function getDetail(main) {
            if (main == '') {
                return false;
            }
            var url = "getDetails.action";
            $.ajax({
                url: url,
                type: 'post',
                data: {'main': main},
                success: setDetails,
                dataType: "json"
            });
        };

        function setDetails(json){
            var str = "";

            $.each(json.details, function (i, detail) {
                str = str + "<option value=\"" + i + "\">" + detail + "</value>"
            });

            $("select#detail").find('option').remove().end().append(str);
        }

        $('#main').change(function(){
            var main = $("#main").val();
            if(main == '600'){
                $("#other").show();
                $("#detail").hide();
            }else if(main == ''){
                $("#other").hide();
                $("#detail").hide();
            }else{
                getDetail(main);
                $("#other").hide();
                $("#detail").show();
            }
        });
    });
</script>
<div class="Form1"/>
<table width="90%" align="center">
    <tr>
        <td>
            <fieldset>
                <legend>委託查詢人</legend>
                <table>
                    <tr>
                        <td width="5%" class="Label">委託查詢者：</td>
                        <td width="5%">
                            <s:textfield name="logcn" id="logcn" cssClass='InputText' theme="simple" style="width:75px;"/>
                        </td>
                        <td width="5%" class="Label">委託單位：</td>
                        <td width="5%">
                            <s:textfield name="logpstname" id="logpstname" cssClass='InputText' theme="simple" style="width:125px;"/>
                        </td>
                        <td width="5%" class="Label"><font color='red'>*</font>用途：</td>
                        <td width="35%">
                            <s:select label=""
                                      headerKey="" headerValue=""
                                      list="mainMap"
                                      id="main"
									  cssClass='InputText'
                                      theme="simple"
                                      name="main"/>
                            <s:select label=""
                                      list="detailMap"
                                      id="detail"
									  cssClass='InputText'
                                      theme="simple"
                                      name="detail"
                                      cssStyle="display:none"/>
                            <s:textfield name="other" id="other"
                                         theme="simple"
                                         cssStyle="display:none"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </td>
    </tr>
</table>
</div>