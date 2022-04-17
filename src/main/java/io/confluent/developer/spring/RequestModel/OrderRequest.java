package io.confluent.developer.spring.RequestModel;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class OrderRequest implements Serializable {
        public String name;
        public int price;
}
