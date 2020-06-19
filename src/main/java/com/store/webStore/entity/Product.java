package com.store.webStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @SequenceGenerator(name="seq", initialValue=1, allocationSize=250)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @OneToOne(fetch = FetchType.EAGER)
    private ProductType productType;

    public Product(String name, double price, ProductType productType) {
        this.name = name;
        this.price = price;
        this.productType = productType;
    }
}
