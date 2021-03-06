//
// このファイルは、JavaTM Architecture for XML Binding(JAXB) Reference Implementation、v2.2.8-b130911.1802によって生成されました 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>を参照してください 
// ソース・スキーマの再コンパイル時にこのファイルの変更は失われます。 
// 生成日: 2015.08.24 時間 02:38:24 AM JST 
//


package com.eitax.recall.rest.ebay.shopping.xsd;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FeedbackRatingDetailCodeTypeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * <p>
 * <pre>
 * &lt;simpleType name="FeedbackRatingDetailCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="ItemAsDescribed"/>
 *     &lt;enumeration value="Communication"/>
 *     &lt;enumeration value="ShippingTime"/>
 *     &lt;enumeration value="ShippingAndHandlingCharges"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeedbackRatingDetailCodeType")
@XmlEnum
public enum FeedbackRatingDetailCodeType {


    /**
     * 
     * 						Detailed seller rating in the area of "item as described."
     * 					
     * 
     */
    @XmlEnumValue("ItemAsDescribed")
    ITEM_AS_DESCRIBED("ItemAsDescribed"),

    /**
     * 
     * 						Detailed seller rating in the area of "communication."
     * 					
     * 
     */
    @XmlEnumValue("Communication")
    COMMUNICATION("Communication"),

    /**
     * 
     * 						Detailed seller rating in the area of "shipping time." Inapplicable to 
     * 						motor vehicle items.
     * 					
     * 
     */
    @XmlEnumValue("ShippingTime")
    SHIPPING_TIME("ShippingTime"),

    /**
     * 
     * 						Detailed seller rating in the area of "charges for shipping and handling."
     * 						Inapplicable to motor vehicle items. 
     * 					
     * 
     */
    @XmlEnumValue("ShippingAndHandlingCharges")
    SHIPPING_AND_HANDLING_CHARGES("ShippingAndHandlingCharges"),

    /**
     * 
     * 						(out) Reserved for internal or future use.
     * 					
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    FeedbackRatingDetailCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FeedbackRatingDetailCodeType fromValue(String v) {
        for (FeedbackRatingDetailCodeType c: FeedbackRatingDetailCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
