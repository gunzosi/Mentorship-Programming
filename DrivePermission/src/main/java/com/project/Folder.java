package com.project;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Store {
    private List<Store> children;
    private List<Permission> permissions;
    private Folder parent; // Add this field to keep track of parent folder

    public Folder(int id, String name) {
        super(id, name);
        this.children = new ArrayList<>();
        this.permissions = new ArrayList<>();
    }

    @Override
    public List<Store> getChildren() {
        return children;
    }

    @Override
    public void addChild(Store store) {
        children.add(store);
        if (store instanceof Folder) {
            ((Folder) store).setParent(this); // Set parent when adding a folder as a child
        }
    }

    @Override
    public void removeChild(Store store) {
        children.remove(store);
        if (store instanceof Folder) {
            ((Folder) store).setParent(null); // Remove parent reference when removing a folder
        }
    }

    public boolean canUserPerformAction(User user, PermissionType permissionType) {
        return permissions.stream()
                .anyMatch(p -> p.getStore().equals(this) && p.getPermissionType() == permissionType && p.getUser().equals(user));
    }

    public void addPermission(User user, PermissionType permissionType) {
        permissions.add(new Permission(this, user, permissionType));
    }

    public void removePermission(User user, PermissionType permissionType) {
        permissions.removeIf(p -> p.getUser().equals(user) && p.getPermissionType() == permissionType);
    }

    public Folder getParent() {
        return parent; // Getter for parent
    }

    public void setParent(Folder parent) {
        this.parent = parent; // Setter for parent
    }
}
