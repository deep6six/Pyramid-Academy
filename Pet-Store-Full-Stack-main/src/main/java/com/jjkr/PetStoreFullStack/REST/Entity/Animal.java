package com.jjkr.PetStoreFullStack.REST.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animal_gen")
    @SequenceGenerator(name="animal_gen", initialValue = 2001, allocationSize = 1)
    private int id;
    private String type;
    private String name;
    private String description;
    private double price;
    private String color;

    public Animal() {
    }

    public Animal(int id, String type, String name, String description, double price, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.color = color;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal { " +
                ", type = " + type +
                " name = " + name +
                ", description = " + description +
                ", price = " + price +
                ", color ="  + color +
                '}';
    }
}
