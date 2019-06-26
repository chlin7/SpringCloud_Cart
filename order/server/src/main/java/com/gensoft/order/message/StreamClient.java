package com.gensoft.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @ desc：spring cloud stream使用接口
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 10:29 2019/6/26
 */
public interface StreamClient {

	String ORDER_MESSAGE = "myMessage";

	@Output(StreamClient.ORDER_MESSAGE)
	MessageChannel output();

	@Input("eeeeMsg")
	SubscribableChannel input();
}
