package com.gensoft.order.message;

import com.gensoft.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
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

	@StreamListener(StreamClient.ORDER_MESSAGE)
	public void process(OrderDTO orderDTO){
		log.info("StreamReceiver message is {}",orderDTO);
	}
}
