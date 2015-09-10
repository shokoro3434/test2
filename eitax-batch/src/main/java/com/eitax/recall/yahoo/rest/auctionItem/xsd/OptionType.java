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
 * <p>OptionType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="OptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StoreIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="CheckIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="FeaturedIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="FreeshippingIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="EscrowIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="NewItemIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="GiftIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="WrappingIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="BuynowIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="YBankIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="EasyPaymentIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="EnglishIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="StarClubIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OptionType", propOrder = {
    "storeIcon",
    "checkIcon",
    "featuredIcon",
    "freeshippingIcon",
    "escrowIcon",
    "newItemIcon",
    "giftIcon",
    "wrappingIcon",
    "buynowIcon",
    "yBankIcon",
    "easyPaymentIcon",
    "englishIcon",
    "starClubIcon"
})
public class OptionType {

    @XmlElement(name = "StoreIcon")
    @XmlSchemaType(name = "anyURI")
    protected String storeIcon;
    @XmlElement(name = "CheckIcon")
    @XmlSchemaType(name = "anyURI")
    protected String checkIcon;
    @XmlElement(name = "FeaturedIcon")
    @XmlSchemaType(name = "anyURI")
    protected String featuredIcon;
    @XmlElement(name = "FreeshippingIcon")
    @XmlSchemaType(name = "anyURI")
    protected String freeshippingIcon;
    @XmlElement(name = "EscrowIcon")
    @XmlSchemaType(name = "anyURI")
    protected String escrowIcon;
    @XmlElement(name = "NewItemIcon")
    @XmlSchemaType(name = "anyURI")
    protected String newItemIcon;
    @XmlElement(name = "GiftIcon")
    @XmlSchemaType(name = "anyURI")
    protected String giftIcon;
    @XmlElement(name = "WrappingIcon")
    @XmlSchemaType(name = "anyURI")
    protected String wrappingIcon;
    @XmlElement(name = "BuynowIcon")
    @XmlSchemaType(name = "anyURI")
    protected String buynowIcon;
    @XmlElement(name = "YBankIcon")
    @XmlSchemaType(name = "anyURI")
    protected String yBankIcon;
    @XmlElement(name = "EasyPaymentIcon")
    @XmlSchemaType(name = "anyURI")
    protected String easyPaymentIcon;
    @XmlElement(name = "EnglishIcon")
    @XmlSchemaType(name = "anyURI")
    protected String englishIcon;
    @XmlElement(name = "StarClubIcon")
    @XmlSchemaType(name = "anyURI")
    protected String starClubIcon;

    /**
     * storeIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreIcon() {
        return storeIcon;
    }

    /**
     * storeIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreIcon(String value) {
        this.storeIcon = value;
    }

    /**
     * checkIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckIcon() {
        return checkIcon;
    }

    /**
     * checkIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckIcon(String value) {
        this.checkIcon = value;
    }

    /**
     * featuredIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeaturedIcon() {
        return featuredIcon;
    }

    /**
     * featuredIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeaturedIcon(String value) {
        this.featuredIcon = value;
    }

    /**
     * freeshippingIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeshippingIcon() {
        return freeshippingIcon;
    }

    /**
     * freeshippingIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeshippingIcon(String value) {
        this.freeshippingIcon = value;
    }

    /**
     * escrowIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEscrowIcon() {
        return escrowIcon;
    }

    /**
     * escrowIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEscrowIcon(String value) {
        this.escrowIcon = value;
    }

    /**
     * newItemIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewItemIcon() {
        return newItemIcon;
    }

    /**
     * newItemIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewItemIcon(String value) {
        this.newItemIcon = value;
    }

    /**
     * giftIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftIcon() {
        return giftIcon;
    }

    /**
     * giftIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftIcon(String value) {
        this.giftIcon = value;
    }

    /**
     * wrappingIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrappingIcon() {
        return wrappingIcon;
    }

    /**
     * wrappingIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrappingIcon(String value) {
        this.wrappingIcon = value;
    }

    /**
     * buynowIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuynowIcon() {
        return buynowIcon;
    }

    /**
     * buynowIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuynowIcon(String value) {
        this.buynowIcon = value;
    }

    /**
     * yBankIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYBankIcon() {
        return yBankIcon;
    }

    /**
     * yBankIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYBankIcon(String value) {
        this.yBankIcon = value;
    }

    /**
     * easyPaymentIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEasyPaymentIcon() {
        return easyPaymentIcon;
    }

    /**
     * easyPaymentIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEasyPaymentIcon(String value) {
        this.easyPaymentIcon = value;
    }

    /**
     * englishIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishIcon() {
        return englishIcon;
    }

    /**
     * englishIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishIcon(String value) {
        this.englishIcon = value;
    }

    /**
     * starClubIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStarClubIcon() {
        return starClubIcon;
    }

    /**
     * starClubIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStarClubIcon(String value) {
        this.starClubIcon = value;
    }

}
