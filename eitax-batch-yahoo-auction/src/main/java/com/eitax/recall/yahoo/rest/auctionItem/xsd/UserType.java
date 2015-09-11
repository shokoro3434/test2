//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.09.10 時間 01:24:36 PM JST 
//


package com.eitax.recall.yahoo.rest.auctionItem.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UserType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="UserType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Rating" type="{urn:yahoo:jp:auc:auctionItem}RatingType"/>
 *         &lt;element name="ItemListURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="RatingURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = {
    "id",
    "rating",
    "itemListURL",
    "ratingURL"
})
public class UserType {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Rating", required = true)
    protected RatingType rating;
    @XmlElement(name = "ItemListURL")
    @XmlSchemaType(name = "anyURI")
    protected String itemListURL;
    @XmlElement(name = "RatingURL")
    @XmlSchemaType(name = "anyURI")
    protected String ratingURL;

    /**
     * idプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * idプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ratingプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link RatingType }
     *     
     */
    public RatingType getRating() {
        return rating;
    }

    /**
     * ratingプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link RatingType }
     *     
     */
    public void setRating(RatingType value) {
        this.rating = value;
    }

    /**
     * itemListURLプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemListURL() {
        return itemListURL;
    }

    /**
     * itemListURLプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemListURL(String value) {
        this.itemListURL = value;
    }

    /**
     * ratingURLプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatingURL() {
        return ratingURL;
    }

    /**
     * ratingURLプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatingURL(String value) {
        this.ratingURL = value;
    }

}
