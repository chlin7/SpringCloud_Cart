package com.gensoft.order.service;

import com.gensoft.order.dto.OrderDTO;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 16:12 2019/6/10
 */
public interface IOrderService {

	/**
	 * 创建订单
	 * @param orderDTO
	 * @return
	 */
	OrderDTO create(OrderDTO orderDTO);
}
