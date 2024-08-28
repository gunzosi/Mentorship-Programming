package com.project;

public class Permission {
    private Store store;
    private User user;
    private PermissionType permissionType;

    public Permission(Store store, User user, PermissionType permissionType) {
        this.store = store;
        this.user = user;
        this.permissionType = permissionType;
    }

    public Store getStore() {
        return store;
    }

    public User getUser() {
        return user;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "store=" + store.getName() +
                ", user=" + user.getEmail() +
                ", permissionType=" + permissionType +
                '}';
    }
}
