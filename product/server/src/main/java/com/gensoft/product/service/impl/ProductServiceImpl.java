package com.gensoft.product.service.impl;


import com.gensoft.product.dto.CartDTO;
import com.gensoft.product.entity.ProductInfo;
import com.gensoft.product.enums.ProductStatusEnum;
import com.gensoft.product.enums.ResultEnum;
import com.gensoft.product.exception.ProductException;
import com.gensoft.product.repository.ProductInfoRepository;
import com.gensoft.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:12 2019/6/5
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public List<ProductInfo> findList(List<String> productIdList) {
		return productInfoRepository.findByProductIdIn(productIdList);
	}

	@Override
	@Transactional
	public void decreaseStock(List<CartDTO> cartDTOList) {
		for (CartDTO cart:cartDTOList) {
			Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cart.getProductId());
			//判断商品是否存在
			if (!productInfoOptional.isPresent()){
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIT);
			}
			ProductInfo productInfo = productInfoOptional.get();
			//库存是否充足
			Integer result = productInfo.getProductStock() - cart.getProductQuantity();
			if (result < 0){
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			productInfo.setProductStock(result);
			productInfoRepository.save(productInfo);

		}
	}
}
