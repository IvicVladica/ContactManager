package com.example.ContactManager.Enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum UserType {
    USER(Sets.newHashSet(UserPermission.CONTACT_READ, UserPermission.CONTACT_WRITE)),
    ADMIN(Sets.newHashSet(UserPermission.CT_READ, UserPermission.CT_WRITE, UserPermission.USER_WRITE, UserPermission.CONTACT_WRITE));

    private final Set<UserPermission> permissions;

    UserType(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
