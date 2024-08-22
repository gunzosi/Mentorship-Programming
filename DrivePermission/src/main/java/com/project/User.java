package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private int id;
    private String email;
    private List<Permission> permissions;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public User(int id, String email, List<Permission> permissions) {
        this.id = id;
        this.email = email;
        this.permissions = permissions != null ? permissions : new ArrayList<>();
    }

    public void addPermission(Permission permission) {
        permissions.add(permission);
    }

    public void removePermission(Permission permission) {
        permissions.remove(permission);
    }

    public List<Permission> getPermissionsForFolder(Folder folder) {
        return permissions.stream()
                .filter(permission -> permission.getStore().equals(folder))
                .collect(Collectors.toList());
    }

    public boolean hasPermission(Store store, PermissionType type ){
        return permissions.stream()
                .anyMatch(p -> p.getStore().equals(store) && p.getPermissionType().equals(type));
    }

    // Getter - Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
