package com.moon.dto;

import com.moon.entity.Cartitem;

import java.util.List;

public class CartDto {
    private List<Cartitem> items;

    private double totalPrice;

    public List<Cartitem> getItems() {
        return items;
    }

    public void setItems(List<Cartitem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    //
}
