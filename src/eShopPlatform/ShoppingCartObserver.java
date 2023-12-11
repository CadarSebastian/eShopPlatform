package eShopPlatform;
import java.util.List;

public interface ShoppingCartObserver {
    void update(List<Product> shoppingCart);
}
