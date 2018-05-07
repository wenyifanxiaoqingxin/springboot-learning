package com.springboot.learning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = "com.springboot.learning.dao")
@ComponentScan(basePackages = {"com.springboot.learning"})
public class DemoApplication {

	@Bean
	public Queue hellwQueue(){
		return new Queue("helloQueue");
	}
	@Bean
	public Queue userQueue(){
		return new Queue("user");
	}
	//下面是topic exchange的队列
	@Bean
	public Queue queueMessage(){

		return new Queue("topic.message");
	}
	@Bean
	public Queue queueMessages(){

		return new Queue("topic.messages");
	}
	//下方是Fanout Exchanege的队列
	@Bean
	public Queue AMessage() {
		return new Queue("fanout.A");
	}

	@Bean
	public Queue BMessage() {
		return new Queue("fanout.B");
	}
	@Bean
	public Queue CMessage(){
		return new Queue("fanout.C");
	}
	@Bean
	TopicExchange exchange(){
		return new TopicExchange("exchange");
	}
	@Bean
	FanoutExchange fanoutExchange(){
		return new FanoutExchange("fanoutExchange");
	}

	/**
	 * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
	 * @param queueMessage
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	/**
	 * 将队列topic.messages与exchange绑定，binding_key为topic.#,就是模糊匹配
	 * @param queueMessage
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
	}

	//
	@Bean
	Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){

		return BindingBuilder.bind(AMessage).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){

		return BindingBuilder.bind(BMessage).to(fanoutExchange);
	}
	@Bean
	Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){

		return BindingBuilder.bind(CMessage).to(fanoutExchange);
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
