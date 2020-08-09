package com.example.flux.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "order")
public class Order {
    @Id
    private String id;
    private User user;
    private List<Product> products;
    private String address;
    private Boolean isDelivered;


}

