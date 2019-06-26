package com.gensoft.product.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 16:51 2019/6/10
 */
@Data
public class OrderDTO {

	private String orderId;

	/** 买家名字. */
	private String buyerName;

	/** 买家手机号. */
	private String buyerPhone;

	/** 买家地址. */
	private String buyerAddress;

	/** 买家微信Openid. */
	private String buyerOpenid;

	/** 订单总金额. */
	private BigDecimal orderAmount;

	/** 订单状态, 默认为0新下单. */
	private Integer orderStatus;

	/** 支付状态, 默认为0未支付. */
	private Integer payStatus;


}
