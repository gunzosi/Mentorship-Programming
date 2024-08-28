package com.project;

import java.util.List;

public abstract class Store {
    protected int id;
    protected String name;

    public Store(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // --------------- METHODS -----------------
    public abstract List<Store> getChildren();

    public abstract void addChild(Store store);

    public abstract void removeChild(Store store);

    // Getter - Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
