package com.example.kyousukeg.myapplication;

import java.io.Serializable;

public class productsInfo implements Serializable {
    private String name;
    private double price;

    public productsInfo(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
