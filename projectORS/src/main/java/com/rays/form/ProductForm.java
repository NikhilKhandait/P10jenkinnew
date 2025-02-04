package com.rays.form;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ProductDTO;

public class ProductForm extends BaseForm {

	@NotNull(message = "quantity is required")
	private Long quantity;
	
	@NotEmpty(message = "productName is required")
	private String productName;
	
	
	@NotNull(message = "Please enter  brandId")
	private Long brandId;
	
	@NotNull(message = "delevirydate is requireddddddd")
	private Date delevirydate;
	
	@NotNull(message = "price is required")
	private Double price;
	
	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	private String brand;
	
	
	
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

	@Override
	public BaseDTO getDto() {
		ProductDTO dto = initDTO(new ProductDTO());
		dto.setQuantity(quantity);
		dto.setProductName(productName);
		dto.setBrandId(brandId);
		dto.setDelevirydate(delevirydate);
		dto.setPrice(price);
		return dto;
	}
}
