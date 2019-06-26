package com.gensoft.order.VO;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 13:42 2019/6/6
 */
@Data
public class ProductVO {

	@JSONField(name = "name")
	private String categoryName;

	@JSONField(name = "type")
	private String categoryType;

	@JSONField(name = "foods")
	private List<ProductInfoVO> productInfoVOS;
}
