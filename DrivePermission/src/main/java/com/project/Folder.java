package com.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Folder extends Store {
    private List<Store> children;

    public Folder(int id, String name) {
        super(id, name);
        this.children = new ArrayList<>();
    }

    @Override
    public List<Store> getChildren() {
        return children;
    }

    @Override
    public void addChild(Store store) {
        children.add(store);
    }

    @Override
    public void removeChild(Store store) {
        // Nếu đối tượng là thư mục, xóa đệ quy các con của nó
        if (store instanceof Folder folderToRemove) {
            // Xóa tất cả các tập tin và thư mục con của folderToRemove
            for (Store child : new ArrayList<>(folderToRemove.getChildren())) {
                removeChild(child); // Đệ quy xóa các con của thư mục
            }
        }
        // Xóa đối tượng khỏi danh sách con của thư mục hiện tại
        children.remove(store);
    }
}
