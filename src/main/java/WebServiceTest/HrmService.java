/**
 * HrmService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebServiceTest;

public interface HrmService extends javax.xml.rpc.Service {
    public java.lang.String getHrmServiceHttpPortAddress();

    public WebServiceTest.HrmServicePortType getHrmServiceHttpPort() throws javax.xml.rpc.ServiceException;

    public WebServiceTest.HrmServicePortType getHrmServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
