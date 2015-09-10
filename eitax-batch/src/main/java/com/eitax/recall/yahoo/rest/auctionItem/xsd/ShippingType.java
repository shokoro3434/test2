//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.09.10 時間 01:24:36 PM JST 
//


package com.eitax.recall.yahoo.rest.auctionItem.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ShippingType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ShippingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Method" type="{urn:yahoo:jp:auc:auctionItem}ShippingMethodType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="totalShippingMethodAvailable" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShippingType", propOrder = {
    "method"
})
public class ShippingType {

    @XmlElement(name = "Method", required = true)
    protected ShippingMethodType method;
    @XmlAttribute(name = "totalShippingMethodAvailable")
    protected BigInteger totalShippingMethodAvailable;

    /**
     * methodプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ShippingMethodType }
     *     
     */
    public ShippingMethodType getMethod() {
        return method;
    }

    /**
     * methodプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingMethodType }
     *     
     */
    public void setMethod(ShippingMethodType value) {
        this.method = value;
    }

    /**
     * totalShippingMethodAvailableプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalShippingMethodAvailable() {
        return totalShippingMethodAvailable;
    }

    /**
     * totalShippingMethodAvailableプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalShippingMethodAvailable(BigInteger value) {
        this.totalShippingMethodAvailable = value;
    }

}
