package schemaorg_apache_xmlbeans.system.s45929A0F16157BF17C16833E0465E11D;

import org.apache.xmlbeans.SchemaTypeSystem;

public class TypeSystemHolder {
  public static final SchemaTypeSystem typeSystem = loadTypeSystem();
  
  private static final SchemaTypeSystem loadTypeSystem() {
    try {
      return (SchemaTypeSystem)Class.forName("org.apache.xmlbeans.impl.schema.SchemaTypeSystemImpl", true, TypeSystemHolder.class.getClassLoader()).getConstructor(new Class[] { Class.class }).newInstance(new Object[] { TypeSystemHolder.class });
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("Cannot load org.apache.xmlbeans.impl.SchemaTypeSystemImpl: make sure xbean.jar is on the classpath.", classNotFoundException);
    } catch (Exception exception) {
      throw new RuntimeException("Could not instantiate SchemaTypeSystemImpl (" + exception.toString() + "): is the version of xbean.jar correct?", exception);
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\schemaorg_apache_xmlbeans\system\s45929A0F16157BF17C16833E0465E11D\TypeSystemHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */