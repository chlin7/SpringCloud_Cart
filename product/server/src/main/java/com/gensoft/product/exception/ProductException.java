package com.gensoft.product.exception;

import com.gensoft.product.enums.ResultEnum;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:35 2019/6/13
 */
public class ProductException extends RuntimeException {

	private Integer code;

	public ProductException(Integer code,String message){
		super(message);
		this.code = code;
	}

	public ProductException(ResultEnum resultEnum){
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
