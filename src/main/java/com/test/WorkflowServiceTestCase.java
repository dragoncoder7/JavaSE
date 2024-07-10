/**
 * WorkflowServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.test;

public class WorkflowServiceTestCase extends junit.framework.TestCase {
    public WorkflowServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testWorkflowServiceHttpPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.test.WorkflowServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1WorkflowServiceHttpPortGetWorkflowRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(180000);

        // Test operation
        com.test.WorkflowRequestInfo value = null;
        value = binding.getWorkflowRequest(0, 0, 0);
        // TBD - validate results
    }

    public void test2WorkflowServiceHttpPortGetHendledWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getHendledWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test3WorkflowServiceHttpPortGetWorkflowRequest4Split() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo value = null;
        value = binding.getWorkflowRequest4Split(0, 0, 0, 0);
        // TBD - validate results
    }

    public void test4WorkflowServiceHttpPortSubmitWorkflowRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.submitWorkflowRequest(new com.test.WorkflowRequestInfo(), 0, 0, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test5WorkflowServiceHttpPortGetMyWorkflowRequestCount4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getMyWorkflowRequestCount4OS(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test6WorkflowServiceHttpPortGetTodoData() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.getTodoData(new java.lang.String());
        // TBD - validate results
    }

    public void test7WorkflowServiceHttpPortGetCCWorkflowRequestList4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getCCWorkflowRequestList4OS(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test8WorkflowServiceHttpPortGetLeaveDays() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.getLeaveDays(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test9WorkflowServiceHttpPortGetHendledWorkflowRequestList4Ofs() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getHendledWorkflowRequestList4Ofs(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test10WorkflowServiceHttpPortGetCreateWorkflowList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowBaseInfo[] value = null;
        value = binding.getCreateWorkflowList(0, 0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test11WorkflowServiceHttpPortGetProcessedWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getProcessedWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test12WorkflowServiceHttpPortDoCreateRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.doCreateRequest(new com.test.WorkflowRequestInfo(), 0);
        // TBD - validate results
    }

    public void test13WorkflowServiceHttpPortDoCreateWorkflowRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.doCreateWorkflowRequest(new com.test.WorkflowRequestInfo(), 0);
        // TBD - validate results
    }

    public void test14WorkflowServiceHttpPortGetToDoWorkflowRequestCount4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getToDoWorkflowRequestCount4OS(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test15WorkflowServiceHttpPortDoForceOver() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.doForceOver(0, 0);
        // TBD - validate results
    }

    public void test16WorkflowServiceHttpPortGetProcessedWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getProcessedWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test17WorkflowServiceHttpPortGetCreateWorkflowRequestInfo() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo value = null;
        value = binding.getCreateWorkflowRequestInfo(0, 0);
        // TBD - validate results
    }

    public void test18WorkflowServiceHttpPortGetCreateWorkflowTypeList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowBaseInfo[] value = null;
        value = binding.getCreateWorkflowTypeList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test19WorkflowServiceHttpPortGetHendledWorkflowRequestCount4Ofs() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getHendledWorkflowRequestCount4Ofs(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test20WorkflowServiceHttpPortGetMyWorkflowRequestList4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getMyWorkflowRequestList4OS(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test21WorkflowServiceHttpPortGetProcessedWorkflowRequestList4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getProcessedWorkflowRequestList4OS(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test22WorkflowServiceHttpPortGetForwardWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getForwardWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test23WorkflowServiceHttpPortGetToDoWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getToDoWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test24WorkflowServiceHttpPortGivingOpinions() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.givingOpinions(0, 0, new java.lang.String());
        // TBD - validate results
    }

    public void test25WorkflowServiceHttpPortGetCCWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getCCWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test26WorkflowServiceHttpPortGetProcessedWorkflowRequestCount4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getProcessedWorkflowRequestCount4OS(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test27WorkflowServiceHttpPortGetBeRejectWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getBeRejectWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test28WorkflowServiceHttpPortForward2WorkflowRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.forward2WorkflowRequest(0, new java.lang.String(), new java.lang.String(), 0, new java.lang.String());
        // TBD - validate results
    }

    public void test29WorkflowServiceHttpPortGetAllWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getAllWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test30WorkflowServiceHttpPortGetToDoWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getToDoWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test31WorkflowServiceHttpPortGetCCWorkflowRequestCount4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getCCWorkflowRequestCount4OS(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test32WorkflowServiceHttpPortGetHendledWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getHendledWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test33WorkflowServiceHttpPortGetToDoWorkflowRequestList4OS() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getToDoWorkflowRequestList4OS(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test34WorkflowServiceHttpPortGetToBeReadWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getToBeReadWorkflowRequestCount(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test35WorkflowServiceHttpPortGetCreateWorkflowCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getCreateWorkflowCount(0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test36WorkflowServiceHttpPortForwardWorkflowRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.forwardWorkflowRequest(0, new java.lang.String(), new java.lang.String(), 0, new java.lang.String());
        // TBD - validate results
    }

    public void test37WorkflowServiceHttpPortGetToBeReadWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getToBeReadWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test38WorkflowServiceHttpPortGetBeRejectWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getBeRejectWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test39WorkflowServiceHttpPortGetCCWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getCCWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test40WorkflowServiceHttpPortGetAllWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getAllWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test41WorkflowServiceHttpPortGetDoingWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getDoingWorkflowRequestCount(0, new java.lang.String[0], true);
        // TBD - validate results
    }

    public void test42WorkflowServiceHttpPortGetForwardWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getForwardWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test43WorkflowServiceHttpPortGetMyWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getMyWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test44WorkflowServiceHttpPortGetMyWorkflowRequestCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getMyWorkflowRequestCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test45WorkflowServiceHttpPortGetWorkflowNewFlag() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        java.lang.String[] value = null;
        value = binding.getWorkflowNewFlag(new java.lang.String[0], new java.lang.String());
        // TBD - validate results
    }

    public void test46WorkflowServiceHttpPortWriteWorkflowReadFlag() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        binding.writeWorkflowReadFlag(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test47WorkflowServiceHttpPortGetCreateWorkflowTypeCount() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        int value = -3;
        value = binding.getCreateWorkflowTypeCount(0, new java.lang.String[0]);
        // TBD - validate results
    }

    public void test48WorkflowServiceHttpPortGetWorkflowRequestLogs() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestLog[] value = null;
        value = binding.getWorkflowRequestLogs(new java.lang.String(), new java.lang.String(), 0, 0, 0);
        // TBD - validate results
    }

    public void test49WorkflowServiceHttpPortDeleteRequest() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.deleteRequest(0, 0);
        // TBD - validate results
    }

    public void test50WorkflowServiceHttpPortGetUserId() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        value = binding.getUserId(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test51WorkflowServiceHttpPortGetDoingWorkflowRequestList() throws Exception {
        com.test.WorkflowServiceHttpBindingStub binding;
        try {
            binding = (com.test.WorkflowServiceHttpBindingStub)
                          new com.test.WorkflowServiceLocator().getWorkflowServiceHttpPort();
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
        com.test.WorkflowRequestInfo[] value = null;
        value = binding.getDoingWorkflowRequestList(0, 0, 0, 0, new java.lang.String[0], true);
        // TBD - validate results
    }

}
