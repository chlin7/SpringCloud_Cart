package com.gensoft.product.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 14:31 2019/6/6
 */
@Data
public class ProductInfoVO {

	@JSONField(name = "id")
	private String productId;

	@JSONField(name = "name")
	private String productName;

	@JSONField(name = "price")
	private BigDecimal productPrice;

	@JSONField(name = "description")
	private String productDescription;

	@JSONField(name = "icon")
	private String productIcon;
}
