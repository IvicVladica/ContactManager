package com.example.ContactManager.Enums;

public enum UserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    CT_READ("ct:read"),
    CT_WRITE("ct:write"),
    CONTACT_READ("contact:read"),
    CONTACT_WRITE("contact:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
