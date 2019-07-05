package com.gensoft.order.message;

import com.gensoft.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @ desc：stream消息接收
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:30 2019/6/26
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

	/**
	 * @SendTo 消息接收成功发送消息返回结果
	 * @param orderDTO
	 * @return
	 */
	@StreamListener(StreamClient.ORDER_MESSAGE)
	@SendTo("returnMessage")
	public String process(OrderDTO orderDTO){
		log.info("StreamReceiver message is {}",orderDTO);
		return "receive success";
	}

	/**
	 * 模拟消息接收成功后返回的消息
	 */
	@StreamListener("returnMessage")
	public void process2(String msg){
		log.info("receiver return message is {}",msg);
	}
}
