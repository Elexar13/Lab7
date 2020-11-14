package com.example.lab7;

public class Animal {
    private int id;
    private String name;
    private String group;
    private boolean isPredator;
    private boolean isFlying;

    public Animal(int id, String name, String group, boolean isPredator, boolean isFlying) {
        this(name, group, isPredator, isFlying);
        this.id = id;
    }

    public Animal(String name, String group, boolean isPredator, boolean isFlying) {
        this.name = name;
        this.group = group;
        this.isPredator = isPredator;
        this.isFlying = isFlying;
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

    public String getGroup() {
        return group;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public boolean isPredator() {
        return isPredator;
    }

    @Override
    public String toString() {
        return name;
    }
}
