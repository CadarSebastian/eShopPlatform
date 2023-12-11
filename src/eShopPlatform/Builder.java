package eShopPlatform;

interface Builder {
    void reset();
    void setCategory(String category);
    void setName(String name);
    void setPrice(double price);
    void setStock(int stock);
    Product getProduct();
}