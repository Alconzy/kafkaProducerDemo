package io.confluent.developer.spring.Entity;


import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public int price;
    public String name;
    private int id;
}
