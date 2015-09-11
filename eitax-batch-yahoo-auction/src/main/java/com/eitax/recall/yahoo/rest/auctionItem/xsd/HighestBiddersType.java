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
 * <p>HighestBiddersType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="HighestBiddersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Bidder" type="{urn:yahoo:jp:auc:auctionItem}UserType"/>
 *         &lt;element name="IsMore" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="totalHighestBidders" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HighestBiddersType", propOrder = {
    "bidder",
    "isMore"
})
public class HighestBiddersType {

    @XmlElement(name = "Bidder", required = true)
    protected UserType bidder;
    @XmlElement(name = "IsMore")
    protected boolean isMore;
    @XmlAttribute(name = "totalHighestBidders")
    protected BigInteger totalHighestBidders;

    /**
     * bidderプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getBidder() {
        return bidder;
    }

    /**
     * bidderプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setBidder(UserType value) {
        this.bidder = value;
    }

    /**
     * isMoreプロパティの値を取得します。
     * 
     */
    public boolean isIsMore() {
        return isMore;
    }

    /**
     * isMoreプロパティの値を設定します。
     * 
     */
    public void setIsMore(boolean value) {
        this.isMore = value;
    }

    /**
     * totalHighestBiddersプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalHighestBidders() {
        return totalHighestBidders;
    }

    /**
     * totalHighestBiddersプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalHighestBidders(BigInteger value) {
        this.totalHighestBidders = value;
    }

}
