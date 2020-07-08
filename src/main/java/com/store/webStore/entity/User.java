package com.store.webStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name="seqUser", initialValue=1, allocationSize=250)
    @GeneratedValue(generator = "seqUser", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

}
