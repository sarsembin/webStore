package com.store.webStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductType {
    @Id
    @SequenceGenerator(name="seqPT", initialValue=1, allocationSize=250)
    @GeneratedValue(generator = "seqPT", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String type;

    public ProductType(String type){
        this.type = type;
    }
}
