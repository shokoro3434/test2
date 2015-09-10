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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{urn:yahoo:jp:auc:search}ResultType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="totalResultsAvailable" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="totalResultsReturned" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="firstResultPosition" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "result"
})
@XmlRootElement(name = "ResultSet")
public class ResultSet {

    @XmlElement(name = "Result", required = true)
    protected ResultType result;
    @XmlAttribute(name = "totalResultsAvailable")
    protected BigInteger totalResultsAvailable;
    @XmlAttribute(name = "totalResultsReturned")
    protected BigInteger totalResultsReturned;
    @XmlAttribute(name = "firstResultPosition")
    protected BigInteger firstResultPosition;

    /**
     * resultプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
    public ResultType getResult() {
        return result;
    }

    /**
     * resultプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
    public void setResult(ResultType value) {
        this.result = value;
    }

    /**
     * totalResultsAvailableプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalResultsAvailable() {
        return totalResultsAvailable;
    }

    /**
     * totalResultsAvailableプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalResultsAvailable(BigInteger value) {
        this.totalResultsAvailable = value;
    }

    /**
     * totalResultsReturnedプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTotalResultsReturned() {
        return totalResultsReturned;
    }

    /**
     * totalResultsReturnedプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTotalResultsReturned(BigInteger value) {
        this.totalResultsReturned = value;
    }

    /**
     * firstResultPositionプロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFirstResultPosition() {
        return firstResultPosition;
    }

    /**
     * firstResultPositionプロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFirstResultPosition(BigInteger value) {
        this.firstResultPosition = value;
    }

}
