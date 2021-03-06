//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.08.24 時間 02:38:24 AM JST 
//


package com.eitax.recall.rest.ebay.shopping.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Information about zero or more buying guides and the site's buying guide hub.
 * 				Buying guides contain content about particular product areas, categories, or subjects
 * 				to help buyers decide which type of item to purchase based on their particular interests.
 * 				Multiple buying guides can be returned. See the eBay Features Guide for additional information.
 * 			
 * 
 * <p>BuyingGuideDetailsType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="BuyingGuideDetailsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BuyingGuide" type="{urn:ebay:apis:eBLBaseComponents}BuyingGuideType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BuyingGuideHub" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuyingGuideDetailsType", propOrder = {
    "buyingGuide",
    "buyingGuideHub"
})
public class BuyingGuideDetailsType {

    @XmlElement(name = "BuyingGuide")
    protected List<BuyingGuideType> buyingGuide;
    @XmlElement(name = "BuyingGuideHub")
    @XmlSchemaType(name = "anyURI")
    protected String buyingGuideHub;

    /**
     * Gets the value of the buyingGuide property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buyingGuide property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuyingGuide().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuyingGuideType }
     * 
     * 
     */
    public List<BuyingGuideType> getBuyingGuide() {
        if (buyingGuide == null) {
            buyingGuide = new ArrayList<BuyingGuideType>();
        }
        return this.buyingGuide;
    }

    /**
     * buyingGuideHubプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyingGuideHub() {
        return buyingGuideHub;
    }

    /**
     * buyingGuideHubプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyingGuideHub(String value) {
        this.buyingGuideHub = value;
    }

}
