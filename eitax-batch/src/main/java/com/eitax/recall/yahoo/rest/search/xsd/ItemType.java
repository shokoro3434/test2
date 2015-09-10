//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.09.10 時間 11:29:11 AM JST 
//


package com.eitax.recall.yahoo.rest.search.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ItemType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Seller" type="{urn:yahoo:jp:auc:search}SellerType"/>
 *         &lt;element name="ItemUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="AuctionItemUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="Image">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CurrentPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Bids" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BidOrBuy" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="IsReserved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Option" type="{urn:yahoo:jp:auc:search}OptionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType", propOrder = {
    "auctionID",
    "title",
    "seller",
    "itemUrl",
    "auctionItemUrl",
    "image",
    "currentPrice",
    "bids",
    "endTime",
    "bidOrBuy",
    "isReserved",
    "option"
})
public class ItemType {

    @XmlElement(name = "AuctionID", required = true)
    protected String auctionID;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Seller", required = true)
    protected SellerType seller;
    @XmlElement(name = "ItemUrl", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String itemUrl;
    @XmlElement(name = "AuctionItemUrl", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String auctionItemUrl;
    @XmlElement(name = "Image", required = true)
    protected ItemType.Image image;
    @XmlElement(name = "CurrentPrice")
    protected double currentPrice;
    @XmlElement(name = "Bids", required = true)
    protected BigInteger bids;
    @XmlElement(name = "EndTime", required = true)
    protected String endTime;
    @XmlElement(name = "BidOrBuy")
    protected Double bidOrBuy;
    @XmlElement(name = "IsReserved")
    protected boolean isReserved;
    @XmlElement(name = "Option", required = true)
    protected OptionType option;

    /**
     * auctionIDプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionID() {
        return auctionID;
    }

    /**
     * auctionIDプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionID(String value) {
        this.auctionID = value;
    }

    /**
     * titleプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * titleプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * sellerプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link SellerType }
     *     
     */
    public SellerType getSeller() {
        return seller;
    }

    /**
     * sellerプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link SellerType }
     *     
     */
    public void setSeller(SellerType value) {
        this.seller = value;
    }

    /**
     * itemUrlプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemUrl() {
        return itemUrl;
    }

    /**
     * itemUrlプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemUrl(String value) {
        this.itemUrl = value;
    }

    /**
     * auctionItemUrlプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuctionItemUrl() {
        return auctionItemUrl;
    }

    /**
     * auctionItemUrlプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuctionItemUrl(String value) {
        this.auctionItemUrl = value;
    }

    /**
     * imageプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ItemType.Image }
     *     
     */
    public ItemType.Image getImage() {
        return image;
    }

    /**
     * imageプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType.Image }
     *     
     */
    public void setImage(ItemType.Image value) {
        this.image = value;
    }

    /**
     * currentPriceプロパティの値を取得します。
     * 
     */
    public double getCurrentPrice() {
        return currentPrice;
    }

    /**
     * currentPriceプロパティの値を設定します。
     * 
     */
    public void setCurrentPrice(double value) {
        this.currentPrice = value;
    }

    /**
     * bidsプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBids() {
        return bids;
    }

    /**
     * bidsプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBids(BigInteger value) {
        this.bids = value;
    }

    /**
     * endTimeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * endTimeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndTime(String value) {
        this.endTime = value;
    }

    /**
     * bidOrBuyプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBidOrBuy() {
        return bidOrBuy;
    }

    /**
     * bidOrBuyプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBidOrBuy(Double value) {
        this.bidOrBuy = value;
    }

    /**
     * isReservedプロパティの値を取得します。
     * 
     */
    public boolean isIsReserved() {
        return isReserved;
    }

    /**
     * isReservedプロパティの値を設定します。
     * 
     */
    public void setIsReserved(boolean value) {
        this.isReserved = value;
    }

    /**
     * optionプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link OptionType }
     *     
     */
    public OptionType getOption() {
        return option;
    }

    /**
     * optionプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link OptionType }
     *     
     */
    public void setOption(OptionType value) {
        this.option = value;
    }


    /**
     * <p>anonymous complex typeのJavaクラス。
     * 
     * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}integer" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Image {

        @XmlAttribute(name = "width")
        protected BigInteger width;
        @XmlAttribute(name = "height")
        protected BigInteger height;

        /**
         * widthプロパティの値を取得します。
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getWidth() {
            return width;
        }

        /**
         * widthプロパティの値を設定します。
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setWidth(BigInteger value) {
            this.width = value;
        }

        /**
         * heightプロパティの値を取得します。
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getHeight() {
            return height;
        }

        /**
         * heightプロパティの値を設定します。
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setHeight(BigInteger value) {
            this.height = value;
        }

    }

}
