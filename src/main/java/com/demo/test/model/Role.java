package com.demo.test.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.demo.test.model.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
        Set.of(
                ADMIN_READ,
                ADMIN_CREATE,
                ADMIN_UPDATE,
                ADMIN_DELETE
        )
    );

    @Getter
    private final Set<Permission> permision;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermision()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add((new SimpleGrantedAuthority("ROLE_" + this.name())));
        return authorities;
    }
}
