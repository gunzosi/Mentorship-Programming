package com.project;

import java.util.ArrayList;
import java.util.List;

public class Drive extends Store {
    private List<Folder> folders;
    private User owner; // Chủ sở hữu của Drive
    private List<User> users; // Danh sách người dùng có quyền truy cập Drive

    public Drive(int id, String name, User owner) {
        super(id, name);
        this.folders = new ArrayList<>();
        this.owner = owner;
        this.users = new ArrayList<>();
        this.users.add(owner); // Mặc định chủ sở hữu có quyền truy cập
    }

    @Override
    public List<Store> getChildren() {
        return new ArrayList<>(folders);
    }

    @Override
    public void addChild(Store store) {
        if (store instanceof Folder) {
            folders.add((Folder) store);
        } else {
            throw new IllegalArgumentException("Only folders can be added to a drive");
        }
    }

    @Override
    public void removeChild(Store store) {
        folders.remove(store);
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (!users.contains(user)) {
            users.add(user);
        }
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
