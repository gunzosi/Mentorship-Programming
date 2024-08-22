package com.project;

import java.util.ArrayList;
import java.util.List;

public class Drive extends Store{
    private List<Folder> folders;

    public Drive(int id, String name) {
        super(id, name);
        this.folders = new ArrayList<>();
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


}
