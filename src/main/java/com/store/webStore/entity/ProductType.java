package com.store.webStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductType {
    @Id
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String type;
}
