package com.springstudy.dhere.service;

import java.util.List;

import com.springstudy.dhere.domain.Product;

public interface ProductService {
	
	// 카테고리 별 제품 리스트 출력
	public abstract List<Product> productList(String productCategory);
	
	public abstract Product getProduct(int productNo);

}
