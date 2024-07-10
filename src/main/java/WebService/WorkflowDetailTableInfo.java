
package WebService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>WorkflowDetailTableInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="WorkflowDetailTableInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tableDBName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tableFieldName" type="{webservices.services.weaver.com.cn}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="tableTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workflowRequestTableRecords" type="{http://webservices.workflow.weaver}ArrayOfWorkflowRequestTableRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowDetailTableInfo", namespace = "http://webservices.workflow.weaver", propOrder = {
    "tableDBName",
    "tableFieldName",
    "tableTitle",
    "workflowRequestTableRecords"
})
public class WorkflowDetailTableInfo {

    @XmlElementRef(name = "tableDBName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tableDBName;
    @XmlElementRef(name = "tableFieldName", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfString> tableFieldName;
    @XmlElementRef(name = "tableTitle", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tableTitle;
    @XmlElementRef(name = "workflowRequestTableRecords", namespace = "http://webservices.workflow.weaver", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWorkflowRequestTableRecord> workflowRequestTableRecords;

    /**
     * 获取tableDBName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTableDBName() {
        return tableDBName;
    }

    /**
     * 设置tableDBName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTableDBName(JAXBElement<String> value) {
        this.tableDBName = value;
    }

    /**
     * 获取tableFieldName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public JAXBElement<ArrayOfString> getTableFieldName() {
        return tableFieldName;
    }

    /**
     * 设置tableFieldName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}
     *     
     */
    public void setTableFieldName(JAXBElement<ArrayOfString> value) {
        this.tableFieldName = value;
    }

    /**
     * 获取tableTitle属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTableTitle() {
        return tableTitle;
    }

    /**
     * 设置tableTitle属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTableTitle(JAXBElement<String> value) {
        this.tableTitle = value;
    }

    /**
     * 获取workflowRequestTableRecords属性的值。
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableRecord }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWorkflowRequestTableRecord> getWorkflowRequestTableRecords() {
        return workflowRequestTableRecords;
    }

    /**
     * 设置workflowRequestTableRecords属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWorkflowRequestTableRecord }{@code >}
     *     
     */
    public void setWorkflowRequestTableRecords(JAXBElement<ArrayOfWorkflowRequestTableRecord> value) {
        this.workflowRequestTableRecords = value;
    }

}
