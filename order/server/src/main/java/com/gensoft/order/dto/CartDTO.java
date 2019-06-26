package com.gensoft.order.dto;

import lombok.Data;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:31 2019/6/13
 */
@Data
public class CartDTO {

	private String productId;

	/**
	 * 商品数量
	 */
	private Integer productQuantity;

	public CartDTO(String productId, Integer productQuantity){
		this.productId = productId;
		this.productQuantity = productQuantity;
	}

	public CartDTO(){
	}
}
