package com.gensoft.product.service;

import com.gensoft.product.dto.CartDTO;
import com.gensoft.product.entity.ProductInfo;
import com.gensoft.product.dto.CartDTO;
import com.gensoft.product.entity.ProductInfo;

import java.util.List;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:11 2019/6/5
 */
public interface IProductService {

	/**
	 * 查询在架商品
	 * @return
	 */
	List<ProductInfo> findUpAll();

	List<ProductInfo> findList(List<String> productIdList);

	/**
	 * 扣除库存
	 */
	void decreaseStock(List<CartDTO> cartDTOList);
}
