package com.gensoft.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

	WAIT (0,"等待支付"),
	SUCCESS(1,"支付成功"),
	FAIL(2,"支付失败"),
	;

	private Integer code;
	private String message;

	PayStatusEnum(Integer code, String message){
		this.code =code;
		this.message = message;
	}
}
