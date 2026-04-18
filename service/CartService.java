package com.example.asm2java202.service;

import com.example.asm2java202.entity.Product;
import com.example.asm2java202.model.CartItem;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final HttpSession session;

    private Map<Integer, CartItem> getCart(){
        Map<Integer, CartItem> cart =
                (Map<Integer, CartItem>) session.getAttribute("CART");

        if(cart == null){
            cart = new HashMap<>();
            session.setAttribute("CART", cart);
        }
        return cart;
    }

    // ➕ thêm sản phẩm
    public void add(Product product){
        Map<Integer, CartItem> cart = getCart();

        if(cart.containsKey(product.getId())){
            CartItem item = cart.get(product.getId());
            item.setQuantity(item.getQuantity() + 1);
        } else {
            cart.put(product.getId(), new CartItem(product, 1));
        }
    }

    // ➖ xóa
    public void remove(Integer id){
        getCart().remove(id);
    }

    // 🔄 cập nhật số lượng
    public void update(Integer id, int qty){
        CartItem item = getCart().get(id);
        if(item != null){
            item.setQuantity(qty);
        }
    }

    // 🧹 clear
    public void clear(){
        getCart().clear();
    }

    public Collection<CartItem> getItems(){
        return getCart().values();
    }

    public Double getTotal(){
        return getItems().stream()
                .mapToDouble(CartItem::getAmount)
                .sum();
    }
}
