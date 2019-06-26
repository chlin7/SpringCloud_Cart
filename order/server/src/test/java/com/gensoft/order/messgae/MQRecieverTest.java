package com.gensoft.order.messgae;

import com.gensoft.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.Action;
import java.util.Date;

/**
 * @ desc：
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 19:54 2019/6/17
 */
@Component
public class MQRecieverTest extends OrderApplicationTests {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Test
	public void send(){
		amqpTemplate.convertAndSend("myQueues","now is"+new Date());
	}

	@Test
	public void sendOrder(){
		amqpTemplate.convertAndSend("myOrder","computer","now is"+new Date());
	}
}
