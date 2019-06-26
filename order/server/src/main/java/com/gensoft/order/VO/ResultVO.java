package com.gensoft.order.VO;

import lombok.Data;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 8:47 2019/6/6
 */
@Data
public class ResultVO<T> {

	/**
	 * 错误码
	 */
	private Integer code;
	/**
	 * 提示信息
	 */
	private String message;
	/**
	 * 数据
	 */
	private T data;
}
