package main.java.ufrn.imd.lp2.lab01.domain;

import java.util.ArrayList;

public class Item {

    private String name;
    private Double price;


    public Item( String name, Double price) {
        this.name = name;
        if (price > 0) {
            this.price = price;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (price > 0) {
            this.price = price;
        }
    }
}