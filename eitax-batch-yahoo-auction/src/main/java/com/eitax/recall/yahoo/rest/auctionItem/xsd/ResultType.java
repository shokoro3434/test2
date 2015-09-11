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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResultType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuctionID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CategoryID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CategoryPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Seller" type="{urn:yahoo:jp:auc:auctionItem}UserType"/>
 *         &lt;element name="AuctionItemUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="Img" type="{urn:yahoo:jp:auc:auctionItem}ImgType"/>
 *         &lt;element name="Initprice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Bids" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="HighestBidders" type="{urn:yahoo:jp:auc:auctionItem}HighestBiddersType"/>
 *         &lt;element name="YPoint" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ItemStatus" type="{urn:yahoo:jp:auc:auctionItem}ItemStatusType"/>
 *         &lt;element name="ItemReturnable" type="{urn:yahoo:jp:auc:auctionItem}ItemReturnableType"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EndTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Bidorbuy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reserved" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsBidderRestrictions" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsEarlyClosing" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsAutomaticExtension" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsOffer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Option" type="{urn:yahoo:jp:auc:auctionItem}OptionType"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Payment" type="{urn:yahoo:jp:auc:auctionItem}PaymentType"/>
 *         &lt;element name="BlindBusiness" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SevenElevenReceive" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChargeForShipping" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsWorldwide" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ShipTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Shipping" type="{urn:yahoo:jp:auc:auctionItem}ShippingType" minOccurs="0"/>
 *         &lt;element name="BaggageInfo" type="{urn:yahoo:jp:auc:auctionItem}BaggageInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultType", propOrder = {
    "auctionID",
    "categoryID",
    "categoryPath",
    "title",
    "seller",
    "auctionItemUrl",
    "img",
    "initprice",
    "price",
    "quantity",
    "bids",
    "highestBidders",
    "yPoint",
    "itemStatus",
    "itemReturnable",
    "startTime",
    "endTime",
    "bidorbuy",
    "reserved",
    "isBidderRestrictions",
    "isEarlyClosing",
    "isAutomaticExtension",
    "isOffer",
    "option",
    "description",
    "payment",
    "blindBusiness",
    "sevenElevenReceive",
    "chargeForShipping",
    "location",
    "isWorldwide",
    "shipTime",
    "shipping",
    "baggageInfo"
})
public class ResultType {

    @XmlElement(name = "AuctionID", required = true)
    protected String auctionID;
    @XmlElement(name = "CategoryID", required = true)
    protected String categoryID;
    @XmlElement(name = "CategoryPath", required = true)
    protected String categoryPath;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Seller", required = true)
    protected UserType seller;
    @XmlElement(name = "AuctionItemUrl", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String auctionItemUrl;
    @XmlElement(name = "Img", required = true)
    protected ImgType img;
    @XmlElement(name = "Initprice")
    protected double initprice;
    @XmlElement(name = "Price")
    protected double price;
    @XmlElement(name = "Quantity", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger quantity;
    @XmlElement(name = "Bids", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger bids;
    @XmlElement(name = "HighestBidders", required = true)
    protected HighestBiddersType highestBidders;
    @XmlElement(name = "YPoint")
    protected Double yPoint;
    @XmlElement(name = "ItemStatus", required = true)
    protected ItemStatusType itemStatus;
    @XmlElement(name = "ItemReturnable", required = true)
    protected ItemReturnableType itemReturnable;
    @XmlElement(name = "StartTime", required = true)
    protected String startTime;
    @XmlElement(name = "EndTime", required = true)
    protected String endTime;
    @XmlElement(name = "Bidorbuy")
    protected String bidorbuy;
    @XmlElement(name = "Reserved")
    protected String reserved;
    @XmlElement(name = "IsBidderRestrictions")
    protected boolean isBidderRestrictions;
    @XmlElement(name = "IsEarlyClosing")
    protected boolean isEarlyClosing;
    @XmlElement(name = "IsAutomaticExtension")
    protected boolean isAutomaticExtension;
    @XmlElement(name = "IsOffer")
    protected boolean isOffer;
    @XmlElement(name = "Option", required = true)
    protected OptionType option;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Payment", required = true)
    protected PaymentType payment;
    @XmlElement(name = "BlindBusiness", required = true)
    protected String blindBusiness;
    @XmlElement(name = "SevenElevenReceive", required = true)
    protected String sevenElevenReceive;
    @XmlElement(name = "ChargeForShipping")
    protected String chargeForShipping;
    @XmlElement(name = "Location")
    protected String location;
    @XmlElement(name = "IsWorldwide")
    protected boolean isWorldwide;
    @XmlElement(name = "ShipTime")
    protected String shipTime;
    @XmlElement(name = "Shipping")
    protected ShippingType shipping;
    @XmlElement(name = "BaggageInfo")
    protected BaggageInfoType baggageInfo;

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
     * categoryIDプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryID() {
        return categoryID;
    }

    /**
     * categoryIDプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryID(String value) {
        this.categoryID = value;
    }

    /**
     * categoryPathプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryPath() {
        return categoryPath;
    }

    /**
     * categoryPathプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryPath(String value) {
        this.categoryPath = value;
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
     *     {@link UserType }
     *     
     */
    public UserType getSeller() {
        return seller;
    }

    /**
     * sellerプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setSeller(UserType value) {
        this.seller = value;
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
     * imgプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ImgType }
     *     
     */
    public ImgType getImg() {
        return img;
    }

    /**
     * imgプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ImgType }
     *     
     */
    public void setImg(ImgType value) {
        this.img = value;
    }

    /**
     * initpriceプロパティの値を取得します。
     * 
     */
    public double getInitprice() {
        return initprice;
    }

    /**
     * initpriceプロパティの値を設定します。
     * 
     */
    public void setInitprice(double value) {
        this.initprice = value;
    }

    /**
     * priceプロパティの値を取得します。
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * priceプロパティの値を設定します。
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

    /**
     * quantityプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * quantityプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
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
     * highestBiddersプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link HighestBiddersType }
     *     
     */
    public HighestBiddersType getHighestBidders() {
        return highestBidders;
    }

    /**
     * highestBiddersプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link HighestBiddersType }
     *     
     */
    public void setHighestBidders(HighestBiddersType value) {
        this.highestBidders = value;
    }

    /**
     * yPointプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getYPoint() {
        return yPoint;
    }

    /**
     * yPointプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setYPoint(Double value) {
        this.yPoint = value;
    }

    /**
     * itemStatusプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ItemStatusType }
     *     
     */
    public ItemStatusType getItemStatus() {
        return itemStatus;
    }

    /**
     * itemStatusプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ItemStatusType }
     *     
     */
    public void setItemStatus(ItemStatusType value) {
        this.itemStatus = value;
    }

    /**
     * itemReturnableプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ItemReturnableType }
     *     
     */
    public ItemReturnableType getItemReturnable() {
        return itemReturnable;
    }

    /**
     * itemReturnableプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ItemReturnableType }
     *     
     */
    public void setItemReturnable(ItemReturnableType value) {
        this.itemReturnable = value;
    }

    /**
     * startTimeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * startTimeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
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
     * bidorbuyプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBidorbuy() {
        return bidorbuy;
    }

    /**
     * bidorbuyプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBidorbuy(String value) {
        this.bidorbuy = value;
    }

    /**
     * reservedプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserved() {
        return reserved;
    }

    /**
     * reservedプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserved(String value) {
        this.reserved = value;
    }

    /**
     * isBidderRestrictionsプロパティの値を取得します。
     * 
     */
    public boolean isIsBidderRestrictions() {
        return isBidderRestrictions;
    }

    /**
     * isBidderRestrictionsプロパティの値を設定します。
     * 
     */
    public void setIsBidderRestrictions(boolean value) {
        this.isBidderRestrictions = value;
    }

    /**
     * isEarlyClosingプロパティの値を取得します。
     * 
     */
    public boolean isIsEarlyClosing() {
        return isEarlyClosing;
    }

    /**
     * isEarlyClosingプロパティの値を設定します。
     * 
     */
    public void setIsEarlyClosing(boolean value) {
        this.isEarlyClosing = value;
    }

    /**
     * isAutomaticExtensionプロパティの値を取得します。
     * 
     */
    public boolean isIsAutomaticExtension() {
        return isAutomaticExtension;
    }

    /**
     * isAutomaticExtensionプロパティの値を設定します。
     * 
     */
    public void setIsAutomaticExtension(boolean value) {
        this.isAutomaticExtension = value;
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
     * descriptionプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * descriptionプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * paymentプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPayment() {
        return payment;
    }

    /**
     * paymentプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPayment(PaymentType value) {
        this.payment = value;
    }

    /**
     * blindBusinessプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlindBusiness() {
        return blindBusiness;
    }

    /**
     * blindBusinessプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlindBusiness(String value) {
        this.blindBusiness = value;
    }

    /**
     * sevenElevenReceiveプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSevenElevenReceive() {
        return sevenElevenReceive;
    }

    /**
     * sevenElevenReceiveプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSevenElevenReceive(String value) {
        this.sevenElevenReceive = value;
    }

    /**
     * chargeForShippingプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeForShipping() {
        return chargeForShipping;
    }

    /**
     * chargeForShippingプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeForShipping(String value) {
        this.chargeForShipping = value;
    }

    /**
     * locationプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * locationプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * isWorldwideプロパティの値を取得します。
     * 
     */
    public boolean isIsWorldwide() {
        return isWorldwide;
    }

    /**
     * isWorldwideプロパティの値を設定します。
     * 
     */
    public void setIsWorldwide(boolean value) {
        this.isWorldwide = value;
    }

    /**
     * shipTimeプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipTime() {
        return shipTime;
    }

    /**
     * shipTimeプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipTime(String value) {
        this.shipTime = value;
    }

    /**
     * shippingプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ShippingType }
     *     
     */
    public ShippingType getShipping() {
        return shipping;
    }

    /**
     * shippingプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ShippingType }
     *     
     */
    public void setShipping(ShippingType value) {
        this.shipping = value;
    }

    /**
     * baggageInfoプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BaggageInfoType }
     *     
     */
    public BaggageInfoType getBaggageInfo() {
        return baggageInfo;
    }

    /**
     * baggageInfoプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BaggageInfoType }
     *     
     */
    public void setBaggageInfo(BaggageInfoType value) {
        this.baggageInfo = value;
    }

}
