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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EasyPaymentType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="EasyPaymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SafeKeepingPayment" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="IsCreditCard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsNetBank" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EasyPaymentType", propOrder = {
    "safeKeepingPayment",
    "isCreditCard",
    "isNetBank"
})
public class EasyPaymentType {

    @XmlElement(name = "SafeKeepingPayment")
    protected Double safeKeepingPayment;
    @XmlElement(name = "IsCreditCard")
    protected boolean isCreditCard;
    @XmlElement(name = "IsNetBank")
    protected boolean isNetBank;

    /**
     * safeKeepingPaymentプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSafeKeepingPayment() {
        return safeKeepingPayment;
    }

    /**
     * safeKeepingPaymentプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSafeKeepingPayment(Double value) {
        this.safeKeepingPayment = value;
    }

    /**
     * isCreditCardプロパティの値を取得します。
     * 
     */
    public boolean isIsCreditCard() {
        return isCreditCard;
    }

    /**
     * isCreditCardプロパティの値を設定します。
     * 
     */
    public void setIsCreditCard(boolean value) {
        this.isCreditCard = value;
    }

    /**
     * isNetBankプロパティの値を取得します。
     * 
     */
    public boolean isIsNetBank() {
        return isNetBank;
    }

    /**
     * isNetBankプロパティの値を設定します。
     * 
     */
    public void setIsNetBank(boolean value) {
        this.isNetBank = value;
    }

}
