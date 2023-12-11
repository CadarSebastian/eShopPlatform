package eShopPlatform;

class ProductDirector {
    public void constructProduct(Builder builder, String category, String name, double price) {
        builder.reset();
        builder.setCategory(category);
        builder.setName(name);
        builder.setPrice(price);
    }
}
