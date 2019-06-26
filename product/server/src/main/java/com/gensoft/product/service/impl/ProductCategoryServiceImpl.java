package com.gensoft.product.service.impl;

import com.gensoft.product.entity.ProductCategory;
import com.gensoft.product.repository.ProductCategoryRepository;
import com.gensoft.product.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:24 2019/6/5
 */
@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
	}
}
