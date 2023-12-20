package com.springstudy.dhere.dao;

import java.util.List;

import com.springstudy.dhere.domain.Product;

public interface ProductDao {
	
	public abstract List<Product> productList();
	
	public abstract Product getProduct(int productNo);

}
