package com.springstudy.dhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springstudy.dhere.domain.Product;
import com.springstudy.dhere.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	// 카테고리 별 제품 리스트 출력
	@Override
	public List<Product> productList(String productCategory) {
		
		return productDao.productList(productCategory);
	}
	
	@Override
	public Product getProduct(int productNo) {
		return productDao.getProduct(productNo);
	}

}
