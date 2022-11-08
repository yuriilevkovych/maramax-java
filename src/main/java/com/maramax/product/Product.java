package com.maramax.product;

public class Product {
    Product(int id){
        this.id = id;
    }
    final private int id;

    public int getId() {
        return id;
    }
    public String getSrc() {
        return "/img/maramax-images-compressed/cashed/" + this.id + ".png";
    }
}
