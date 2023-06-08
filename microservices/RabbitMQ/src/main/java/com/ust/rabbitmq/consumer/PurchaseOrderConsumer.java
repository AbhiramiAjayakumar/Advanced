package com.ust.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ust.rabbitmq.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
	@Value("${ust.rabbitmq.queue}")
	String ust_queue;

	

	@RabbitListener(queues="ust_queue")
	public void consumeMessageFRomQueue(OrderStatus orderStatus) {
	System.out.println("Message Recieved from queue:"+orderStatus);
	}
	
}
