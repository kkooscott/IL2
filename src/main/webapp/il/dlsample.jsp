 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.net.*"%>
<%
    String path = "C:\\IL2\\file\\";                    
    //String filename = "IL7113CO.txt";                
	
	String filename=request.getParameter("filename");
	
    filename = new String(filename.getBytes("ISO-8859-1"),"Big5");
   
    File file = new File(path+filename);
    if(file.exists()){
        try{
            response.setHeader("Content-Disposition","attachment; filename=\""  + URLEncoder.encode(filename, "UTF-8") + "\"");  
            OutputStream output = response.getOutputStream();
            InputStream in = new FileInputStream(file);
            byte[] b = new byte[2048];
            int len;
           
            while((len = in.read(b))>0){
              output.write(b,0,len);
            }
            in.close();
            output.flush();
            output.close();   
            out.clear();

            out = pageContext.pushBody();
 
        }catch(Exception ex){
            out.println("Exception : "+ex.toString());
            out.println("<br/>");
        }
    }else{
        out.println(filename+" : 此檔案不存在");
        out.println("<br/>");
    }
%>
