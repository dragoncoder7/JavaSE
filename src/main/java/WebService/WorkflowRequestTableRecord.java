
package WebService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WorkflowRequestTableRecord complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WorkflowRequestTableRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="recordOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="workflowRequestTableFields" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestTableField" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowRequestTableRecord", namespace = "http://webservices.workflow.weaver", propOrder = {
    "recordOrder",
    "workflowRequestTableFields"
})
public class WorkflowRequestTableRecord {

    protected Integer recordOrder;
    @XmlElementRef(name = "workflowRequestTableFields", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWorkflowRequestTableField> workflowRequestTableFields;

    /**
     * 获取recordOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRecordOrder() {
        return recordOrder;
    }

    /**
     * 设置recordOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRecordOrder(Integer value) {
        this.recordOrder = value;
    }

    /**
     * 获取workflowRequestTableFields属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableField }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWorkflowRequestTableField> getWorkflowRequestTableFields() {
        return workflowRequestTableFields;
    }

    /**
     * 设置workflowRequestTableFields属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableField }{@code >}
     *     
     */
    public void setWorkflowRequestTableFields(JAXBElement<ArrayOfWorkflowRequestTableField> value) {
        this.workflowRequestTableFields = value;
    }

}
