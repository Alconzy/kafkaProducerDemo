package io.confluent.developer.spring.Producer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.confluent.developer.spring.RequestModel.OrderRequest;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * producer 同步方式发送数据
     * @param topic    topic名称
     * @param message  producer发送的数据
     */
    public void sendMessageSync(String topic, String message) throws InterruptedException, ExecutionException, TimeoutException {
        kafkaTemplate.send(topic, message).get(10, TimeUnit.SECONDS);
    }

    /**
     * producer 异步方式发送数据
     * @param topic    topic名称
     * @param message  producer发送的数据
     */
    public void sendMessageAsync(String topic, String key, String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println(result.getProducerRecord().key());
                System.out.println("success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("failure");
            }
        });
    }

    public void sendOrderCreation(OrderRequest orderRequest) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String jsonStr = objectMapper.writeValueAsString(orderRequest);
        kafkaTemplate.send("purchases", jsonStr);
    }


}
