package com.gensoft.order.message;

import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ desc：配置docker 虚拟机104IP的启动rabbitMQ
 * @ Author     ：.
 * @ Date       ：Created in 19:52 2019/6/17
 */
@Slf4j
@Component
public class MQReceiver {

	//1.0,需要手动在管理创建队列
	// @RabbitListener(queues = "myQueue")
	//2.0可自动创建队列
//	@RabbitListener(queuesToDeclare = @Queue("testQueue"))
	//3.0 自动创建 Exchange和Queue绑定
//	@RabbitListener(bindings = @QueueBinding(
//			value = @Queue("myQueues"),
//			exchange = @Exchange("myExchanges")
//	))
	public void process(String messgae){
		log.info("==myQueue=== is:"+messgae);
	}

	//3.0 自动创建 Exchange和Queue绑定
//	@RabbitListener(bindings = @QueueBinding(
//			key = "computer",
//			value = @Queue("myOrder"),
//			exchange = @Exchange("myOrder")
//	))
	public void processComputer(String messgae){
		log.info("=computer=myOrder=== is:"+messgae);
	}

//	@RabbitListener(bindings = @QueueBinding(
//			key = "fruit",
//			value = @Queue("fruitOrder"),
//			exchange = @Exchange("myOrder")
//	))
	public void processFruit(String messgae){
		log.info("=fruit=myOrder=== is:"+messgae);
	}
}
