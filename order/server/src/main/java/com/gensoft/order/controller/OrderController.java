package com.gensoft.order.controller;

import com.gensoft.order.VO.ResultVO;
import com.gensoft.order.converter.OrderForm2OrderDTOConverter;
import com.gensoft.order.dto.OrderDTO;
import com.gensoft.order.enums.ResultEnum;
import com.gensoft.order.exception.OrderException;
import com.gensoft.order.form.OrderForm;
import com.gensoft.order.service.IOrderService;
import com.gensoft.order.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @ desc：订单controller
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 20:12 2019/6/11
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	private IOrderService orderService;

	/**
	 *
	 * @Valid 表单验证
	 * @param orderForm
	 * @param bindingResult  需要注意的是@Valid 和 BindingResult 是一 一对应的，如果有多个@Valid
	 * @return
	 */
	@PostMapping("/create")
	public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm
			,BindingResult bindingResult) {

		if (bindingResult.hasErrors()){
			log.error("【创建订单】参数不正确, orderForm={}", orderForm);
			throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
					bindingResult.getFieldError().getDefaultMessage());
		}
		// orderForm -> orderDTO
		OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("【创建订单】购物车信息为空");
			throw new OrderException(ResultEnum.CART_EMPTY);
		}

		OrderDTO result = orderService.create(orderDTO);
		Map<String, String> map = new HashMap<>();
		map.put("orderId", result.getOrderId());
		return ResultVOUtil.success(map);
	}

	/**
	 * 完结订单
	 * @param orderId
	 * @return
	 */
	@PostMapping("/finish")
	public ResultVO<OrderDTO> finish(@RequestParam("orderId") String orderId){
		return ResultVOUtil.success(orderService.finish(orderId));
	}

}
