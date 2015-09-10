//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.09.10 時間 11:29:11 AM JST 
//


package com.eitax.recall.yahoo.rest.search.xsd;

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
 *         &lt;element name="NewIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="StoreIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="CheckIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="PublicIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="FeaturedIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="FreeShippingIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="EscrowIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="NewItemIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="YBankIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="WrappingIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="BuynowIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="EasyPaymentIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="GiftIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="EnglishIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="StarClubIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="PointIcon" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="IsBold" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsBackGroundColor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsOffer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "newIcon",
    "storeIcon",
    "checkIcon",
    "publicIcon",
    "featuredIcon",
    "freeShippingIcon",
    "escrowIcon",
    "newItemIcon",
    "yBankIcon",
    "wrappingIcon",
    "buynowIcon",
    "easyPaymentIcon",
    "giftIcon",
    "englishIcon",
    "starClubIcon",
    "pointIcon",
    "isBold",
    "isBackGroundColor",
    "isOffer"
})
public class OptionType {

    @XmlElement(name = "NewIcon")
    @XmlSchemaType(name = "anyURI")
    protected String newIcon;
    @XmlElement(name = "StoreIcon")
    @XmlSchemaType(name = "anyURI")
    protected String storeIcon;
    @XmlElement(name = "CheckIcon")
    @XmlSchemaType(name = "anyURI")
    protected String checkIcon;
    @XmlElement(name = "PublicIcon")
    @XmlSchemaType(name = "anyURI")
    protected String publicIcon;
    @XmlElement(name = "FeaturedIcon")
    @XmlSchemaType(name = "anyURI")
    protected String featuredIcon;
    @XmlElement(name = "FreeShippingIcon")
    @XmlSchemaType(name = "anyURI")
    protected String freeShippingIcon;
    @XmlElement(name = "EscrowIcon")
    @XmlSchemaType(name = "anyURI")
    protected String escrowIcon;
    @XmlElement(name = "NewItemIcon")
    @XmlSchemaType(name = "anyURI")
    protected String newItemIcon;
    @XmlElement(name = "YBankIcon")
    @XmlSchemaType(name = "anyURI")
    protected String yBankIcon;
    @XmlElement(name = "WrappingIcon")
    @XmlSchemaType(name = "anyURI")
    protected String wrappingIcon;
    @XmlElement(name = "BuynowIcon")
    @XmlSchemaType(name = "anyURI")
    protected String buynowIcon;
    @XmlElement(name = "EasyPaymentIcon")
    @XmlSchemaType(name = "anyURI")
    protected String easyPaymentIcon;
    @XmlElement(name = "GiftIcon")
    @XmlSchemaType(name = "anyURI")
    protected String giftIcon;
    @XmlElement(name = "EnglishIcon")
    @XmlSchemaType(name = "anyURI")
    protected String englishIcon;
    @XmlElement(name = "StarClubIcon")
    @XmlSchemaType(name = "anyURI")
    protected String starClubIcon;
    @XmlElement(name = "PointIcon")
    @XmlSchemaType(name = "anyURI")
    protected String pointIcon;
    @XmlElement(name = "IsBold")
    protected boolean isBold;
    @XmlElement(name = "IsBackGroundColor")
    protected boolean isBackGroundColor;
    @XmlElement(name = "IsOffer")
    protected boolean isOffer;

    /**
     * newIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewIcon() {
        return newIcon;
    }

    /**
     * newIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewIcon(String value) {
        this.newIcon = value;
    }

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
     * publicIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicIcon() {
        return publicIcon;
    }

    /**
     * publicIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicIcon(String value) {
        this.publicIcon = value;
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
     * freeShippingIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeShippingIcon() {
        return freeShippingIcon;
    }

    /**
     * freeShippingIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeShippingIcon(String value) {
        this.freeShippingIcon = value;
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

    /**
     * pointIconプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPointIcon() {
        return pointIcon;
    }

    /**
     * pointIconプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPointIcon(String value) {
        this.pointIcon = value;
    }

    /**
     * isBoldプロパティの値を取得します。
     * 
     */
    public boolean isIsBold() {
        return isBold;
    }

    /**
     * isBoldプロパティの値を設定します。
     * 
     */
    public void setIsBold(boolean value) {
        this.isBold = value;
    }

    /**
     * isBackGroundColorプロパティの値を取得します。
     * 
     */
    public boolean isIsBackGroundColor() {
        return isBackGroundColor;
    }

    /**
     * isBackGroundColorプロパティの値を設定します。
     * 
     */
    public void setIsBackGroundColor(boolean value) {
        this.isBackGroundColor = value;
    }

    /**
     * isOfferプロパティの値を取得します。
     * 
     */
    public boolean isIsOffer() {
        return isOffer;
    }

    /**
     * isOfferプロパティの値を設定します。
     * 
     */
    public void setIsOffer(boolean value) {
        this.isOffer = value;
    }

}
