package com.gensoft.product.repository;

import com.gensoft.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 19:56 2019/6/5
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

	List<ProductInfo> findByProductStatus(Integer productStatus);

	List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
