package tw.gov.npa.il.ws;

public abstract class OEWebServiceCallbackHandler {
  protected Object clientData;
  
  public OEWebServiceCallbackHandler(Object clientData) {
    this.clientData = clientData;
  }
  
  public OEWebServiceCallbackHandler() {
    this.clientData = null;
  }
  
  public Object getClientData() {
    return this.clientData;
  }
  
  public void receiveResultoEServiceDaMain(OEWebServiceStub.OEServiceDaMainResponse result) {}
  
  public void receiveErroroEServiceDaMain(Exception e) {}
  
  public void receiveResultoEServiceDaMain2(OEWebServiceStub.OEServiceDaMain2Response result) {}
  
  public void receiveErroroEServiceDaMain2(Exception e) {}
  
  public void receiveResultoEServicePoMain(OEWebServiceStub.OEServicePoMainResponse result) {}
  
  public void receiveErroroEServicePoMain(Exception e) {}
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\ws\OEWebServiceCallbackHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */