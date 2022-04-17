//package io.confluent.developer.spring;
//
//
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.config.SaslConfigs;
//import org.apache.kafka.common.serialization.IntegerSerializer;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaAdmin;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//import static org.apache.kafka.clients.producer.ProducerConfig.*;
//
//@Configuration
//@EnableKafka
//public class KafkaConfiguration {
//    @Bean(name = "kafkaTemplate")
//    public KafkaTemplate<String, Object> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//
//    /**
//     * Producer 工厂配置
//     */
//    public ProducerFactory<String, Object> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//
//    public Map<String, Object> producerConfigs() {
//        Map<String, Object> prop = new HashMap<>();
//        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-2396y.us-east-1.aws.confluent.cloud:9092");
//        //prop.put("acks", "all");
//        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
//        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
//        prop.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
//        prop.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule   required username='XHCX3D4VXAJHCQ2U");
//        return prop;
//    }
//
//}
