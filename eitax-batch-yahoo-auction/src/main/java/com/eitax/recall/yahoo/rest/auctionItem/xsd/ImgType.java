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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ImgType complex typeのJavaクラス。
 * 
 * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
 * 
 * <pre>
 * &lt;complexType name="ImgType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Image1">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Image2">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Image3">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                 &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImgType", propOrder = {
    "image1",
    "image2",
    "image3"
})
public class ImgType {

    @XmlElement(name = "Image1", required = true)
    protected ImgType.Image1 image1;
    @XmlElement(name = "Image2", required = true)
    protected ImgType.Image2 image2;
    @XmlElement(name = "Image3", required = true)
    protected ImgType.Image3 image3;

    /**
     * image1プロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ImgType.Image1 }
     *     
     */
    public ImgType.Image1 getImage1() {
        return image1;
    }

    /**
     * image1プロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ImgType.Image1 }
     *     
     */
    public void setImage1(ImgType.Image1 value) {
        this.image1 = value;
    }

    /**
     * image2プロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ImgType.Image2 }
     *     
     */
    public ImgType.Image2 getImage2() {
        return image2;
    }

    /**
     * image2プロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ImgType.Image2 }
     *     
     */
    public void setImage2(ImgType.Image2 value) {
        this.image2 = value;
    }

    /**
     * image3プロパティの値を取得します。
     * 
     * @return
     *     possible object is
     *     {@link ImgType.Image3 }
     *     
     */
    public ImgType.Image3 getImage3() {
        return image3;
    }

    /**
     * image3プロパティの値を設定します。
     * 
     * @param value
     *     allowed object is
     *     {@link ImgType.Image3 }
     *     
     */
    public void setImage3(ImgType.Image3 value) {
        this.image3 = value;
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
     *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Image1 {

        @XmlAttribute(name = "width")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger width;
        @XmlAttribute(name = "height")
        @XmlSchemaType(name = "positiveInteger")
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


    /**
     * <p>anonymous complex typeのJavaクラス。
     * 
     * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Image2 {

        @XmlAttribute(name = "width")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger width;
        @XmlAttribute(name = "height")
        @XmlSchemaType(name = "positiveInteger")
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


    /**
     * <p>anonymous complex typeのJavaクラス。
     * 
     * <p>次のスキーマ・フラグメントは、このクラス内に含まれる予期されるコンテンツを指定します。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Image3 {

        @XmlAttribute(name = "width")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger width;
        @XmlAttribute(name = "height")
        @XmlSchemaType(name = "positiveInteger")
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
