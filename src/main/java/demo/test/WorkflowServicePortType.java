/**
 * WorkflowServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package demo.test;

public interface WorkflowServicePortType extends java.rmi.Remote {
    public WorkflowRequestInfo getWorkflowRequest(int in0, int in1, int in2) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getHendledWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo getWorkflowRequest4Split(int in0, int in1, int in2, int in3) throws java.rmi.RemoteException;
    public java.lang.String submitWorkflowRequest(WorkflowRequestInfo in0, int in1, int in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException;
    public int getMyWorkflowRequestCount4OS(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public java.lang.String getTodoData(java.lang.String in0) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getCCWorkflowRequestList4OS(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
    public java.lang.String getLeaveDays(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getHendledWorkflowRequestList4Ofs(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
    public WorkflowBaseInfo[] getCreateWorkflowList(int in0, int in1, int in2, int in3, int in4, java.lang.String[] in5) throws java.rmi.RemoteException;
    public int getProcessedWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public java.lang.String doCreateRequest(WorkflowRequestInfo in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String doCreateWorkflowRequest(WorkflowRequestInfo in0, int in1) throws java.rmi.RemoteException;
    public int getToDoWorkflowRequestCount4OS(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public java.lang.String doForceOver(int in0, int in1) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getProcessedWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo getCreateWorkflowRequestInfo(int in0, int in1) throws java.rmi.RemoteException;
    public WorkflowBaseInfo[] getCreateWorkflowTypeList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public int getHendledWorkflowRequestCount4Ofs(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getMyWorkflowRequestList4OS(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getProcessedWorkflowRequestList4OS(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
    public int getForwardWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public int getToDoWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public java.lang.String givingOpinions(int in0, int in1, java.lang.String in2) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getCCWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public int getProcessedWorkflowRequestCount4OS(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public int getBeRejectWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public java.lang.String forward2WorkflowRequest(int in0, java.lang.String in1, java.lang.String in2, int in3, java.lang.String in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getAllWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getToDoWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public int getCCWorkflowRequestCount4OS(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public int getHendledWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getToDoWorkflowRequestList4OS(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
    public int getToBeReadWorkflowRequestCount(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public int getCreateWorkflowCount(int in0, int in1, java.lang.String[] in2) throws java.rmi.RemoteException;
    public java.lang.String forwardWorkflowRequest(int in0, java.lang.String in1, java.lang.String in2, int in3, java.lang.String in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getToBeReadWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getBeRejectWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public int getCCWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public int getAllWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public int getDoingWorkflowRequestCount(int in0, java.lang.String[] in1, boolean in2) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getForwardWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getMyWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4) throws java.rmi.RemoteException;
    public int getMyWorkflowRequestCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public java.lang.String[] getWorkflowNewFlag(java.lang.String[] in0, java.lang.String in1) throws java.rmi.RemoteException;
    public void writeWorkflowReadFlag(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public int getCreateWorkflowTypeCount(int in0, java.lang.String[] in1) throws java.rmi.RemoteException;
    public WorkflowRequestLog[] getWorkflowRequestLogs(java.lang.String in0, java.lang.String in1, int in2, int in3, int in4) throws java.rmi.RemoteException;
    public boolean deleteRequest(int in0, int in1) throws java.rmi.RemoteException;
    public java.lang.String getUserId(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
    public WorkflowRequestInfo[] getDoingWorkflowRequestList(int in0, int in1, int in2, int in3, java.lang.String[] in4, boolean in5) throws java.rmi.RemoteException;
}
