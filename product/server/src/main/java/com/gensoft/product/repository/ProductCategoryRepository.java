package com.gensoft.product.repository;

import com.gensoft.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:03 2019/6/5
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
