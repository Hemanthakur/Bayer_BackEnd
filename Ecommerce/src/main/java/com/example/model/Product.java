package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.request.ProductRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String category;
	
	
	@Column(nullable=false)
	private int price;
	
	@Column(nullable=false)
	private int countInStock;
	
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Seller seller;
	
	public Product(ProductRequest productRequest ){
		this.productId = productRequest.getProductId();
		this.name = productRequest.getName();
		this.category = productRequest.getCategory();
		this.price = productRequest.getPrice();
		this.countInStock = productRequest.getCountInStock();
		this.description = productRequest.getDescription();	
	}
	
	
	
	
	
}

