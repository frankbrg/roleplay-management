package com.example.roleplaymanagement.entity;

import java.util.ArrayList;

public class Character {
    private int id;
    private String name;
    private int inventorySize;
    private int inventoryUsedSize;
    private ArrayList<Item> items;

    public Character(int id, String name, int inventorySize) {
        this.id = id;
        this.name = name;
        this.inventorySize = inventorySize;
        this.items = new ArrayList<>();
    }
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

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }


    public int getInventoryUsedSize() {
        return inventoryUsedSize;
    }

    public void setInventoryUsedSize(int inventoryUsedSize) {
        this.inventoryUsedSize = inventoryUsedSize;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
