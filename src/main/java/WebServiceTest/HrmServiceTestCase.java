/**
 * HrmServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebServiceTest;

public class HrmServiceTestCase extends junit.framework.TestCase {
    public HrmServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testHrmServiceHttpPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new WebServiceTest.HrmServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1HrmServiceHttpPortChangeUserPassword() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.changeUserPassword(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test2HrmServiceHttpPortGetHrmJobTitleInfoXML() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmJobTitleInfoXML(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test3HrmServiceHttpPortCheckInvokeClient() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.checkInvokeClient();
        // TBD - validate results
    }

    public void test4HrmServiceHttpPortGetDepartmentInfoWithPage() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getDepartmentInfoWithPage(new java.lang.String());
        // TBD - validate results
    }

    public void test5HrmServiceHttpPortGetHrmDepartmentInfoXML() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmDepartmentInfoXML(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test6HrmServiceHttpPortSynSubCompany() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.synSubCompany(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test7HrmServiceHttpPortGetHrmJobTitleInfo() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        WebServiceTest.JobTitleBean[] value = null;
        value = binding.getHrmJobTitleInfo(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test8HrmServiceHttpPortGetHrmSubcompanyInfo() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        WebServiceTest.SubCompanyBean[] value = null;
        value = binding.getHrmSubcompanyInfo(new java.lang.String());
        // TBD - validate results
    }

    public void test9HrmServiceHttpPortGetOneUserInfo() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getOneUserInfo(new java.lang.String());
        // TBD - validate results
    }

    public void test10HrmServiceHttpPortSynDepartment() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.synDepartment(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test11HrmServiceHttpPortGetUseridByWorkcode() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUseridByWorkcode(new java.lang.String());
        // TBD - validate results
    }

    public void test12HrmServiceHttpPortGetHrmUserInfo() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        WebServiceTest.UserBean[] value = null;
        value = binding.getHrmUserInfo(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test13HrmServiceHttpPortCheckUser() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkUser(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test14HrmServiceHttpPortGetJobtitleInfoWithPage() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getJobtitleInfoWithPage(new java.lang.String());
        // TBD - validate results
    }

    public void test15HrmServiceHttpPortSynHrmResource() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.synHrmResource(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test16HrmServiceHttpPortGetHrmUserImage() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmUserImage(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test17HrmServiceHttpPortSycHrmUserImage() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.sycHrmUserImage(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test18HrmServiceHttpPortGetHrmDepartmentInfo() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        WebServiceTest.DepartmentBean[] value = null;
        value = binding.getHrmDepartmentInfo(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test19HrmServiceHttpPortGetHrmUserInfoWithPage() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmUserInfoWithPage(new java.lang.String());
        // TBD - validate results
    }

    public void test20HrmServiceHttpPortGetHrmSubcompanyInfoWithPage() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmSubcompanyInfoWithPage(new java.lang.String());
        // TBD - validate results
    }

    public void test21HrmServiceHttpPortSynJobtitle() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.synJobtitle(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test22HrmServiceHttpPortGetHrmSubcompanyInfoXML() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmSubcompanyInfoXML(new java.lang.String());
        // TBD - validate results
    }

    public void test23HrmServiceHttpPortGetHrmUserInfoXML() throws Exception {
        WebServiceTest.HrmServiceHttpBindingStub binding;
        try {
            binding = (WebServiceTest.HrmServiceHttpBindingStub)
                          new WebServiceTest.HrmServiceLocator().getHrmServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getHrmUserInfoXML(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

}
