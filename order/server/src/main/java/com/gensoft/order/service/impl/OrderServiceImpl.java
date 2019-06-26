package com.gensoft.order.service.impl;

import com.gensoft.order.dto.OrderDTO;
import com.gensoft.order.entity.OrderDetail;
import com.gensoft.order.entity.OrderMaster;
import com.gensoft.order.enums.OrderStatusEnum;
import com.gensoft.order.enums.PayStatusEnum;
import com.gensoft.order.repository.IOrderDetailRepository;
import com.gensoft.order.repository.IOrderMasterRepository;
import com.gensoft.order.service.IOrderService;
import com.gensoft.order.util.KeyUtil;
import com.gensoft.product.client.ProductClient;
import com.gensoft.product.common.DecreaseStockInput;
import com.gensoft.product.common.ProductInfoOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 16:12 2019/6/10
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderMasterRepository orderMasterRepository;

	@Autowired
	private IOrderDetailRepository orderDetailRepository;

	@Autowired
	private ProductClient productClient;

	@Override
	public OrderDTO create(OrderDTO orderDTO) {

		String orderId = KeyUtil.genUniqueKey();
		//Lamda表达式获取商品id集合
		List<String> productIdList = orderDTO.getOrderDetailList().stream()
				.map(OrderDetail::getProductId)
				.collect(Collectors.toList());

		//查询商品服务
		List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);

		//计算总价
		BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
		for (OrderDetail orderDetail:orderDTO.getOrderDetailList()) {
			for (ProductInfoOutput productinfo:productInfoList) {
				if (productinfo.getProductId().equals(orderDetail.getProductId())){
					//单价*数量
					orderAmout = productinfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
							.add(orderAmout);
					BeanUtils.copyProperties(productinfo,orderDetail);
					orderDetail.setOrderId(orderId);
					orderDetail.setDetailId(KeyUtil.genUniqueKey());
					//存储订单详情
					orderDetailRepository.save(orderDetail);
				}
			}
		}
		//扣除库存
		List<DecreaseStockInput> cartDTOList = orderDTO.getOrderDetailList().stream()
				.map(e->new DecreaseStockInput(e.getProductId(),e.getProductQuantity()))
				.collect(Collectors.toList());
		productClient.decreaseStock(cartDTOList);

		//订单入库
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO,orderMaster);
		orderMaster.setOrderAmount(new BigDecimal(5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

		orderMasterRepository.save(orderMaster);

		return orderDTO;
	}
}
