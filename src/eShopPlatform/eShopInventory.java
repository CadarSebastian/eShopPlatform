package eShopPlatform;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class eShopInventory {
    private Map<String, List<Product>> productsByCategory;

    public eShopInventory() {
        this.productsByCategory = new HashMap<>();
    }

    public void addProduct(Product product) {
        
        List<Product> products = productsByCategory.getOrDefault(product.getCategory(), new ArrayList<>());
        products.add(product);
        productsByCategory.put(product.getCategory(), products);
    }

//    public void displayInventory() {
//        System.out.println("Current Inventory:");
//        for (Map.Entry<String, List<Product>> entry : productsByCategory.entrySet()) {
//            System.out.println(entry.getKey() + ":");
//            for (Product product : entry.getValue()) {
//                System.out.println("  " + product.getName() + ": " + product.getStock() + " in stock");
//            }
//        }
//    }
   

    public List<String> getCategories() {
        return new ArrayList<>(productsByCategory.keySet());
    }

    public String getCategory(int index) {
        return getCategories().get(index);
    }

    public List<Product> getProductsInCategory(String category) {
        return productsByCategory.getOrDefault(category, new ArrayList<>());
    }
}
