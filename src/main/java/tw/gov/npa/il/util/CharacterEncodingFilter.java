package tw.gov.npa.il.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
  private String characterEncoding;
  
  private boolean enabled;
  
  public void init(FilterConfig config) throws ServletException {
    this.characterEncoding = config.getInitParameter("characterEncoding");
    this.enabled = !(!"true".equalsIgnoreCase(this.characterEncoding.trim()) && 
      !"1".equalsIgnoreCase(this.characterEncoding.trim()));
  }
  
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    if (this.enabled || this.characterEncoding != null) {
      request.setCharacterEncoding(this.characterEncoding);
      response.setCharacterEncoding(this.characterEncoding);
    } 
    chain.doFilter(request, response);
  }
  
  public void destroy() {
    this.characterEncoding = null;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\CharacterEncodingFilter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */