package com.example.asm2java202.model;

import com.example.asm2java202.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;

    public Double getAmount(){
        return product.getPrice() * quantity;
    }
}
