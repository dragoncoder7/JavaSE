
package WebService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WorkflowRequestInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WorkflowRequestInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="canEdit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="canView" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="createTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentNodeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currentNodeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forwardButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isnextflow" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastOperateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastOperatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messageType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mustInputRemark" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="needAffirmance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="receiveTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rejectButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subbackButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submitButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subnobackButtonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workflowBaseInfo" type="{http://webservices.workflow.weaver}WorkflowBaseInfo" minOccurs="0"/>
 *         &lt;element name="workflowDetailTableInfos" type="{http://webservices.workflow.weaver}ArrayOfWorkflowDetailTableInfo" minOccurs="0"/>
 *         &lt;element name="workflowHtmlShow" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="workflowHtmlTemplete" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="workflowMainTableInfo" type="{http://webservices.workflow.weaver}WorkflowMainTableInfo" minOccurs="0"/>
 *         &lt;element name="workflowPhrases" type="{webservices.services.weaver.com.cn}ArrayOfArrayOfString" minOccurs="0"/>
 *         &lt;element name="workflowRequestLogs" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestLog" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowRequestInfo", namespace = "http://webservices.workflow.weaver", propOrder = {
    "canEdit",
    "canView",
    "createTime",
    "creatorId",
    "creatorName",
    "currentNodeId",
    "currentNodeName",
    "forwardButtonName",
    "isnextflow",
    "lastOperateTime",
    "lastOperatorName",
    "messageType",
    "mustInputRemark",
    "needAffirmance",
    "receiveTime",
    "rejectButtonName",
    "remark",
    "requestId",
    "requestLevel",
    "requestName",
    "secLevel",
    "status",
    "subbackButtonName",
    "submitButtonName",
    "subnobackButtonName",
    "workflowBaseInfo",
    "workflowDetailTableInfos",
    "workflowHtmlShow",
    "workflowHtmlTemplete",
    "workflowMainTableInfo",
    "workflowPhrases",
    "workflowRequestLogs"
})
public class WorkflowRequestInfo {

    protected Boolean canEdit;
    protected Boolean canView;
    @XmlElementRef(name = "createTime", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> createTime;
    @XmlElementRef(name = "creatorId", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creatorId;
    @XmlElementRef(name = "creatorName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creatorName;
    @XmlElementRef(name = "currentNodeId", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currentNodeId;
    @XmlElementRef(name = "currentNodeName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> currentNodeName;
    @XmlElementRef(name = "forwardButtonName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> forwardButtonName;
    @XmlElementRef(name = "isnextflow", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isnextflow;
    @XmlElementRef(name = "lastOperateTime", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastOperateTime;
    @XmlElementRef(name = "lastOperatorName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lastOperatorName;
    @XmlElementRef(name = "messageType", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageType;
    protected Boolean mustInputRemark;
    protected Boolean needAffirmance;
    @XmlElementRef(name = "receiveTime", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> receiveTime;
    @XmlElementRef(name = "rejectButtonName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rejectButtonName;
    @XmlElementRef(name = "remark", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remark;
    @XmlElementRef(name = "requestId", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> requestId;
    @XmlElementRef(name = "requestLevel", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> requestLevel;
    @XmlElementRef(name = "requestName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> requestName;
    @XmlElementRef(name = "secLevel", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secLevel;
    @XmlElementRef(name = "status", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "subbackButtonName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subbackButtonName;
    @XmlElementRef(name = "submitButtonName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> submitButtonName;
    @XmlElementRef(name = "subnobackButtonName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> subnobackButtonName;
    @XmlElementRef(name = "workflowBaseInfo", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<WorkflowBaseInfo> workflowBaseInfo;
    @XmlElementRef(name = "workflowDetailTableInfos", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWorkflowDetailTableInfo> workflowDetailTableInfos;
    @XmlElementRef(name = "workflowHtmlShow", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfString> workflowHtmlShow;
    @XmlElementRef(name = "workflowHtmlTemplete", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfString> workflowHtmlTemplete;
    @XmlElementRef(name = "workflowMainTableInfo", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<WorkflowMainTableInfo> workflowMainTableInfo;
    @XmlElementRef(name = "workflowPhrases", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfArrayOfString> workflowPhrases;
    @XmlElementRef(name = "workflowRequestLogs", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWorkflowRequestLog> workflowRequestLogs;

    /**
     * 获取canEdit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanEdit() {
        return canEdit;
    }

    /**
     * 设置canEdit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanEdit(Boolean value) {
        this.canEdit = value;
    }

    /**
     * 获取canView属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCanView() {
        return canView;
    }

    /**
     * 设置canView属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCanView(Boolean value) {
        this.canView = value;
    }

    /**
     * 获取createTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreateTime() {
        return createTime;
    }

    /**
     * 设置createTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreateTime(JAXBElement<String> value) {
        this.createTime = value;
    }

    /**
     * 获取creatorId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreatorId() {
        return creatorId;
    }

    /**
     * 设置creatorId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreatorId(JAXBElement<String> value) {
        this.creatorId = value;
    }

    /**
     * 获取creatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreatorName() {
        return creatorName;
    }

    /**
     * 设置creatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreatorName(JAXBElement<String> value) {
        this.creatorName = value;
    }

    /**
     * 获取currentNodeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrentNodeId() {
        return currentNodeId;
    }

    /**
     * 设置currentNodeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrentNodeId(JAXBElement<String> value) {
        this.currentNodeId = value;
    }

    /**
     * 获取currentNodeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCurrentNodeName() {
        return currentNodeName;
    }

    /**
     * 设置currentNodeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCurrentNodeName(JAXBElement<String> value) {
        this.currentNodeName = value;
    }

    /**
     * 获取forwardButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getForwardButtonName() {
        return forwardButtonName;
    }

    /**
     * 设置forwardButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setForwardButtonName(JAXBElement<String> value) {
        this.forwardButtonName = value;
    }

    /**
     * 获取isnextflow属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsnextflow() {
        return isnextflow;
    }

    /**
     * 设置isnextflow属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsnextflow(JAXBElement<String> value) {
        this.isnextflow = value;
    }

    /**
     * 获取lastOperateTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastOperateTime() {
        return lastOperateTime;
    }

    /**
     * 设置lastOperateTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastOperateTime(JAXBElement<String> value) {
        this.lastOperateTime = value;
    }

    /**
     * 获取lastOperatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLastOperatorName() {
        return lastOperatorName;
    }

    /**
     * 设置lastOperatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLastOperatorName(JAXBElement<String> value) {
        this.lastOperatorName = value;
    }

    /**
     * 获取messageType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageType() {
        return messageType;
    }

    /**
     * 设置messageType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageType(JAXBElement<String> value) {
        this.messageType = value;
    }

    /**
     * 获取mustInputRemark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMustInputRemark() {
        return mustInputRemark;
    }

    /**
     * 设置mustInputRemark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMustInputRemark(Boolean value) {
        this.mustInputRemark = value;
    }

    /**
     * 获取needAffirmance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNeedAffirmance() {
        return needAffirmance;
    }

    /**
     * 设置needAffirmance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNeedAffirmance(Boolean value) {
        this.needAffirmance = value;
    }

    /**
     * 获取receiveTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置receiveTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReceiveTime(JAXBElement<String> value) {
        this.receiveTime = value;
    }

    /**
     * 获取rejectButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRejectButtonName() {
        return rejectButtonName;
    }

    /**
     * 设置rejectButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRejectButtonName(JAXBElement<String> value) {
        this.rejectButtonName = value;
    }

    /**
     * 获取remark属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemark() {
        return remark;
    }

    /**
     * 设置remark属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemark(JAXBElement<String> value) {
        this.remark = value;
    }

    /**
     * 获取requestId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRequestId() {
        return requestId;
    }

    /**
     * 设置requestId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRequestId(JAXBElement<String> value) {
        this.requestId = value;
    }

    /**
     * 获取requestLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRequestLevel() {
        return requestLevel;
    }

    /**
     * 设置requestLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRequestLevel(JAXBElement<String> value) {
        this.requestLevel = value;
    }

    /**
     * 获取requestName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRequestName() {
        return requestName;
    }

    /**
     * 设置requestName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRequestName(JAXBElement<String> value) {
        this.requestName = value;
    }

    /**
     * 获取secLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecLevel() {
        return secLevel;
    }

    /**
     * 设置secLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecLevel(JAXBElement<String> value) {
        this.secLevel = value;
    }

    /**
     * 获取status属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * 设置status属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * 获取subbackButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubbackButtonName() {
        return subbackButtonName;
    }

    /**
     * 设置subbackButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubbackButtonName(JAXBElement<String> value) {
        this.subbackButtonName = value;
    }

    /**
     * 获取submitButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubmitButtonName() {
        return submitButtonName;
    }

    /**
     * 设置submitButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubmitButtonName(JAXBElement<String> value) {
        this.submitButtonName = value;
    }

    /**
     * 获取subnobackButtonName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSubnobackButtonName() {
        return subnobackButtonName;
    }

    /**
     * 设置subnobackButtonName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSubnobackButtonName(JAXBElement<String> value) {
        this.subnobackButtonName = value;
    }

    /**
     * 获取workflowBaseInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WorkflowBaseInfo }{@code >}
     *     
     */
    public JAXBElement<WorkflowBaseInfo> getWorkflowBaseInfo() {
        return workflowBaseInfo;
    }

    /**
     * 设置workflowBaseInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WorkflowBaseInfo }{@code >}
     *     
     */
    public void setWorkflowBaseInfo(JAXBElement<WorkflowBaseInfo> value) {
        this.workflowBaseInfo = value;
    }

    /**
     * 获取workflowDetailTableInfos属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowDetailTableInfo }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWorkflowDetailTableInfo> getWorkflowDetailTableInfos() {
        return workflowDetailTableInfos;
    }

    /**
     * 设置workflowDetailTableInfos属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowDetailTableInfo }{@code >}
     *     
     */
    public void setWorkflowDetailTableInfos(JAXBElement<ArrayOfWorkflowDetailTableInfo> value) {
        this.workflowDetailTableInfos = value;
    }

    /**
     * 获取workflowHtmlShow属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public JAXBElement<ArrayOfString> getWorkflowHtmlShow() {
        return workflowHtmlShow;
    }

    /**
     * 设置workflowHtmlShow属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public void setWorkflowHtmlShow(JAXBElement<ArrayOfString> value) {
        this.workflowHtmlShow = value;
    }

    /**
     * 获取workflowHtmlTemplete属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public JAXBElement<ArrayOfString> getWorkflowHtmlTemplete() {
        return workflowHtmlTemplete;
    }

    /**
     * 设置workflowHtmlTemplete属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public void setWorkflowHtmlTemplete(JAXBElement<ArrayOfString> value) {
        this.workflowHtmlTemplete = value;
    }

    /**
     * 获取workflowMainTableInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WorkflowMainTableInfo }{@code >}
     *     
     */
    public JAXBElement<WorkflowMainTableInfo> getWorkflowMainTableInfo() {
        return workflowMainTableInfo;
    }

    /**
     * 设置workflowMainTableInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WorkflowMainTableInfo }{@code >}
     *     
     */
    public void setWorkflowMainTableInfo(JAXBElement<WorkflowMainTableInfo> value) {
        this.workflowMainTableInfo = value;
    }

    /**
     * 获取workflowPhrases属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfArrayOfString }{@code >}
     *     
     */
    public JAXBElement<ArrayOfArrayOfString> getWorkflowPhrases() {
        return workflowPhrases;
    }

    /**
     * 设置workflowPhrases属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfArrayOfString }{@code >}
     *     
     */
    public void setWorkflowPhrases(JAXBElement<ArrayOfArrayOfString> value) {
        this.workflowPhrases = value;
    }

    /**
     * 获取workflowRequestLogs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestLog }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWorkflowRequestLog> getWorkflowRequestLogs() {
        return workflowRequestLogs;
    }

    /**
     * 设置workflowRequestLogs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestLog }{@code >}
     *     
     */
    public void setWorkflowRequestLogs(JAXBElement<ArrayOfWorkflowRequestLog> value) {
        this.workflowRequestLogs = value;
    }

}
