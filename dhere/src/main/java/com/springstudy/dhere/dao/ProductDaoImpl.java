package com.springstudy.dhere.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springstudy.dhere.domain.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAME_SPACE = "com.springstudy.dhere.mappers.ProductMapper";

	@Override
	public List<Product> productList() {
		
		return sqlSession.selectList(NAME_SPACE + ".productList");
	}
	
	@Override
	public Product getProduct(int productNo) {
		return sqlSession.selectOne(NAME_SPACE + ".productDetail", productNo);
	}

}
