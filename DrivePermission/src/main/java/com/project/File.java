package com.project;

import java.util.Collections;
import java.util.List;

public class File extends Store {
    public File(int id, String name) {
        super(id, name);
    }

    @Override
    public List<Store> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void addChild(Store store) {
        throw new UnsupportedOperationException("Cannot add a child to a File.");
    }

    @Override
    public void removeChild(Store store) {
        throw new UnsupportedOperationException("Cannot remove a child from a File.");
    }

    @Override
    public String toString() {
        return "File: { name = " + name + " }";
    }
}
