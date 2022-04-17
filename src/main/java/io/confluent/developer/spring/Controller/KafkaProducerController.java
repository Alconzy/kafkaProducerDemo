package io.confluent.developer.spring.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.confluent.developer.spring.Producer.KafkaProducerService;
import io.confluent.developer.spring.RequestModel.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/sync")
    public void sendMessageSync() throws InterruptedException, ExecutionException, TimeoutException {
       producerService.sendMessageSync("purchases","同步发送消息测试");
       // kafkaTemplate.send("purchases","Kay");
    }

    @GetMapping("/async")
    public void sendMessageAsync(){
        producerService.sendMessageAsync("purchases","2333","异步发送消息测试");
    }

    @PostMapping("/order")
    public void createOrder(@RequestBody OrderRequest orderRequest) throws JsonProcessingException {
        System.out.println(orderRequest);
        producerService.sendOrderCreation(orderRequest);
    }
}
