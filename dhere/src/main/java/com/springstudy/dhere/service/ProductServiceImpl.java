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

	@Override
	public List<Product> productList() {
		
		return productDao.productList();
	}
	
	@Override
	public Product getProduct(int productNo) {
		return productDao.getProduct(productNo);
	}

}
