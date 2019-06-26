package com.gensoft.product.service;

import com.gensoft.product.entity.ProductCategory;

import java.util.List;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:24 2019/6/5
 */
public interface IProductCategoryService {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
