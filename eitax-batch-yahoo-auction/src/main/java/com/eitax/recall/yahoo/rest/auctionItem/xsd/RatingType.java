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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>RatingType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="RatingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Point" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="IsSuspended" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsDeleted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RatingType", propOrder = {
    "point",
    "isSuspended",
    "isDeleted"
})
public class RatingType {

    @XmlElement(name = "Point")
    protected BigInteger point;
    @XmlElement(name = "IsSuspended")
    protected boolean isSuspended;
    @XmlElement(name = "IsDeleted")
    protected boolean isDeleted;

    /**
     * pointプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPoint() {
        return point;
    }

    /**
     * pointプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPoint(BigInteger value) {
        this.point = value;
    }

    /**
     * isSuspendedプロパティの値を取得します。
     * 
     */
    public boolean isIsSuspended() {
        return isSuspended;
    }

    /**
     * isSuspendedプロパティの値を設定します。
     * 
     */
    public void setIsSuspended(boolean value) {
        this.isSuspended = value;
    }

    /**
     * isDeletedプロパティの値を取得します。
     * 
     */
    public boolean isIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedプロパティの値を設定します。
     * 
     */
    public void setIsDeleted(boolean value) {
        this.isDeleted = value;
    }

}
