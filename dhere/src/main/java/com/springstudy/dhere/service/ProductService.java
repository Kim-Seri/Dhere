package com.springstudy.dhere.service;

import java.util.List;

import com.springstudy.dhere.domain.Product;

public interface ProductService {
	
	public abstract List<Product> productList();
	
	public abstract Product getProduct(int productNo);

}
