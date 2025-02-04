package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_product")
public class ProductDTO extends BaseDTO {

	@Column(name = "QUANTITY", length = 50)
	private Long quantity;
	
	
	@Column(name = "BrandId", length = 10)
	private Long brandId = null;
	
	@Column(name = "PRODUCTNAME", length = 50)
	private String productName;
	
	@Column(name = "BRAND", length = 50)
	private String brand;
	
	@Column(name = "DELEVIRYDATE")
	private Date delevirydate;
	
	@Column(name = "ORG_NAME", length = 40)
	private String orgName;
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Column(name = "PRICE", length = 50)
	private Double price;
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getDelevirydate() {
		return delevirydate;
	}
	public void setDelevirydate(Date delevirydate) {
		this.delevirydate = delevirydate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Long getBrandId() {
		return brandId;
	}
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	public String getKey() {
		return id + "";
	}
	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return orgName;
	}
	@Override
	public String getUniqueKey() {
		return "productName";
	}
	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return productName;
	}
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return orgName;
	}
	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("productName", "asc");
		return map;
	}
	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("modifiedBy", modifiedBy);
		return map;
	}
	
	
}
