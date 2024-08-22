package com.project;

public class Permission {
    private Store store;
    private PermissionType permissionType;

    public Permission(Store store, PermissionType permissionType) {
        this.store = store;
        this.permissionType = permissionType;
    }

    public Store getStore() {
        return store;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }
}
