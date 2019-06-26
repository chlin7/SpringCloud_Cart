package com.gensoft.order.controller;

import com.gensoft.order.dto.OrderDTO;
import com.gensoft.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ desc：stream消息发送测试接口
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:43 2019/6/26
 */
@RestController
public class SendMessageController {

	@Autowired
	private StreamClient streamClient;

	@GetMapping("/sendMessage")
	public void process(){
//		String message ="now is :"+new Date();
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId("123456");
		orderDTO.setBuyerName("11");
		streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
	}
}
