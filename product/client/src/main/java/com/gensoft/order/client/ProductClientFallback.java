package com.gensoft.order.client;

import com.gensoft.product.client.ProductClient;
import com.gensoft.product.common.DecreaseStockInput;
import com.gensoft.product.common.ProductInfoOutput;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ desc：熔断,添加fallback，供order使用
 * 注意包路径，最好与Order应用默认扫描包路径一直，否则需要通过配置@ComponentScan扫描路径加载
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 17:00 2019/7/9
 */
@Component
public class ProductClientFallback implements ProductClient {
	@Override
	public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
		return null;
	}

	@Override
	public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

	}
}
