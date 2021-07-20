package com.example.roleplaymanagement.entity;

import java.util.ArrayList;

public class Character implements java.io.Serializable{

    private String name;
    private int inventorySize;
    private int inventoryUsedSize;
    private ArrayList<Item> items;

    public Character(String name, int inventorySize) {
        this.name = name;
        this.inventorySize = inventorySize;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventorySize() {
        return inventorySize;
    }

    public int getInventoryUsedSize() {
        int inventoryUsedSize = 0;

        for (int i = 0; i < items.size(); i++) {
            int weight = items.get(i).getWeight();
            inventoryUsedSize += weight;
        }

        return inventoryUsedSize;
    }

    public void setInventoryUsedSize(int inventoryUsedSize) {
        this.inventoryUsedSize = inventoryUsedSize;
    }

    public int addItem(Item item) {

        if (getInventoryUsedSize() > getInventorySize())
        {
            return 0;
        }

        this.items.add(item);
        return 1;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
