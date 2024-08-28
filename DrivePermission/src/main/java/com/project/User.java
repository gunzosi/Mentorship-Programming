package com.project;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String email;
    private List<Permission> permissions;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
        this.permissions = new ArrayList<>();
    }

    public User(int id, String email, List<Permission> permissions) {
        this.id = id;
        this.email = email;
        this.permissions = permissions;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        this.permissions.remove(permission);
    }

    public boolean hasPermission(Store store, PermissionType permissionType) {
        for (Permission permission : permissions) {
            if (permission.getStore().equals(store) && permission.getPermissionType() == permissionType) {
                return true;
            }
        }
        return false;
    }

    // Phương thức mới để kiểm tra xem người dùng có thể tạo thư mục hoặc tệp không
    public boolean canCreate(Store store) {
        if (store instanceof Folder) {
            Folder folder = (Folder) store;
            // Kiểm tra quyền ADMIN trên thư mục hoặc quyền trên thư mục cha của thư mục hiện tại
            return hasPermission(folder, PermissionType.ADMIN) ||
                    (folder.getParent() != null && hasPermission(folder.getParent(), PermissionType.ADMIN));
        }
        return false;
    }

    // Other getters and setters
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
