package com.example.roleplaymanagement.entity;

public class Character {
    private String name;
    private int inventorySize;

    public Character(String name, int inventorySize) {
        this.name = name;
        this.inventorySize = inventorySize;
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
}
