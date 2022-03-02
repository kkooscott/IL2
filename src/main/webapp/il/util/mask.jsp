<%
	//製表姓名
String logcn = (String) session.getAttribute("LOGCN");
//製表單位
String logUnitNm = (String) session.getAttribute("LOGUNITNM");
//登入時間
String logtDt = (String) session.getAttribute("LOGTDT");
%>
<link rel="Stylesheet" type="text/css" href="css/style.css" />
<div id="tableMask" class="dataTable-info-mask" style="display: none;"></div>

<script type="text/javascript">

<%-- watermark.load({ watermark_txt: "<%=logUnitNm%>-<%=logcn%>-<%=logtDt%>" }) --%>

/* 依照畫面解析度，動態生成浮水印 */
function setMask() {
	var height = $('body').height();//table body的高
	var endNumber = 0;
	if($(window).width() <= 1024){
		endNumber = height/220;
	}else{
		endNumber = height/200;
	}
    
    var str = '';
    for(var i=0 ; i < endNumber ; i ++){
	    str += '<p class="info-text-left"><%=logUnitNm%>-<%=logcn%>-<%=logtDt%></p>';
	    str += '<p class="info-text-center"><%=logUnitNm%>-<%=logcn%>-<%=logtDt%></p>';
	    str += '<p class="info-text-right"><%=logUnitNm%>-<%=logcn%>-<%=logtDt%></p>';
    }
    $('#tableMask').html('');
    $('#tableMask').html(str);
    $('#tableMask').show();
    
}
window.onload=function(){
	setMask();
}
</script>