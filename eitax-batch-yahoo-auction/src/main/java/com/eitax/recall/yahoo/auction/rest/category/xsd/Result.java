package com.eitax.recall.yahoo.auction.rest.category.xsd;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Result", namespace = "urn:yahoo:jp:auc:categoryTree")
@Data
public class Result {
	@XmlElement(name="CategoryId",namespace="urn:yahoo:jp:auc:categoryTree")
	private Integer categoryId;
	@XmlElement(name="CategoryName",namespace="urn:yahoo:jp:auc:categoryTree")
	private String categoryName;
	@XmlElement(name="CategoryPath",namespace="urn:yahoo:jp:auc:categoryTree")
	private String categoryPath;
	@XmlElement(name="ParentCategoryId",namespace="urn:yahoo:jp:auc:categoryTree")
	private Integer parentCategoryId;
	@XmlElement(name="IsLeaf",namespace="urn:yahoo:jp:auc:categoryTree")
	private Boolean isLeaf;
	@XmlElement(name="Depth",namespace="urn:yahoo:jp:auc:categoryTree")
	private Integer depth;
	@XmlElement(name="Order",namespace="urn:yahoo:jp:auc:categoryTree")
	private Integer order;
	@XmlElement(name="IsLink",namespace="urn:yahoo:jp:auc:categoryTree")
	private Boolean isLink;
	@XmlElement(name="ChildCategoryNum",namespace="urn:yahoo:jp:auc:categoryTree")
	private Integer childCategoryNum;
	@XmlElement(name="ChildCategory",namespace="urn:yahoo:jp:auc:categoryTree")
	private List<ChildCategory> childCategory;
}
