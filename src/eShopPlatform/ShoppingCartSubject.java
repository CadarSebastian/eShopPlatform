package eShopPlatform;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartSubject {
    private List<ShoppingCartObserver> observers = new ArrayList<>();
    private List<Product> shoppingCart = new ArrayList<>();

    
    
    
    
    public void addObserver(ShoppingCartObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(ShoppingCartObserver observer) {
        observers.remove(observer);
    }

    public void updateShoppingCart(List<Product> newShoppingCart) {
        shoppingCart = newShoppingCart;
        notifyObservers();
        
       
    }

    private void notifyObservers() {
        for (ShoppingCartObserver observer : observers) {
            observer.update(shoppingCart);
        }
    }
}
