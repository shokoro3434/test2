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
 * <p>PaymentType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="PaymentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="YBank" type="{urn:yahoo:jp:auc:auctionItem}YBankType" minOccurs="0"/>
 *         &lt;element name="EasyPayment" type="{urn:yahoo:jp:auc:auctionItem}EasyPaymentType" minOccurs="0"/>
 *         &lt;element name="Bank" type="{urn:yahoo:jp:auc:auctionItem}BankType" minOccurs="0"/>
 *         &lt;element name="CashRegistration" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CashOnDelivery" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CreditCard" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Loan" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Other" type="{urn:yahoo:jp:auc:auctionItem}OtherType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentType", propOrder = {
    "yBank",
    "easyPayment",
    "bank",
    "cashRegistration",
    "cashOnDelivery",
    "creditCard",
    "loan",
    "other"
})
public class PaymentType {

    @XmlElement(name = "YBank")
    protected YBankType yBank;
    @XmlElement(name = "EasyPayment")
    protected EasyPaymentType easyPayment;
    @XmlElement(name = "Bank")
    protected BankType bank;
    @XmlElement(name = "CashRegistration")
    protected PaymentType.CashRegistration cashRegistration;
    @XmlElement(name = "CashOnDelivery")
    protected PaymentType.CashOnDelivery cashOnDelivery;
    @XmlElement(name = "CreditCard")
    protected PaymentType.CreditCard creditCard;
    @XmlElement(name = "Loan")
    protected PaymentType.Loan loan;
    @XmlElement(name = "Other")
    protected OtherType other;

    /**
     * yBankプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link YBankType }
     *     
     */
    public YBankType getYBank() {
        return yBank;
    }

    /**
     * yBankプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link YBankType }
     *     
     */
    public void setYBank(YBankType value) {
        this.yBank = value;
    }

    /**
     * easyPaymentプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link EasyPaymentType }
     *     
     */
    public EasyPaymentType getEasyPayment() {
        return easyPayment;
    }

    /**
     * easyPaymentプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link EasyPaymentType }
     *     
     */
    public void setEasyPayment(EasyPaymentType value) {
        this.easyPayment = value;
    }

    /**
     * bankプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BankType }
     *     
     */
    public BankType getBank() {
        return bank;
    }

    /**
     * bankプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BankType }
     *     
     */
    public void setBank(BankType value) {
        this.bank = value;
    }

    /**
     * cashRegistrationプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PaymentType.CashRegistration }
     *     
     */
    public PaymentType.CashRegistration getCashRegistration() {
        return cashRegistration;
    }

    /**
     * cashRegistrationプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType.CashRegistration }
     *     
     */
    public void setCashRegistration(PaymentType.CashRegistration value) {
        this.cashRegistration = value;
    }

    /**
     * cashOnDeliveryプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PaymentType.CashOnDelivery }
     *     
     */
    public PaymentType.CashOnDelivery getCashOnDelivery() {
        return cashOnDelivery;
    }

    /**
     * cashOnDeliveryプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType.CashOnDelivery }
     *     
     */
    public void setCashOnDelivery(PaymentType.CashOnDelivery value) {
        this.cashOnDelivery = value;
    }

    /**
     * creditCardプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PaymentType.CreditCard }
     *     
     */
    public PaymentType.CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * creditCardプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType.CreditCard }
     *     
     */
    public void setCreditCard(PaymentType.CreditCard value) {
        this.creditCard = value;
    }

    /**
     * loanプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link PaymentType.Loan }
     *     
     */
    public PaymentType.Loan getLoan() {
        return loan;
    }

    /**
     * loanプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType.Loan }
     *     
     */
    public void setLoan(PaymentType.Loan value) {
        this.loan = value;
    }

    /**
     * otherプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link OtherType }
     *     
     */
    public OtherType getOther() {
        return other;
    }

    /**
     * otherプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link OtherType }
     *     
     */
    public void setOther(OtherType value) {
        this.other = value;
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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CashOnDelivery {


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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CashRegistration {


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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CreditCard {


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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Loan {


    }

}
