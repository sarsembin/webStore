package com.store.webStore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Roles implements GrantedAuthority {
    @Id
    private Long id;
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
