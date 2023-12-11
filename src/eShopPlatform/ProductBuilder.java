package eShopPlatform;

class ProductBuilder implements Builder {
    private Product product;

    public ProductBuilder() {
        this.reset();
    }

    public void reset() {
        this.product = new Product("", "", 0.0);
    }

    public void setCategory(String category) {
        this.product = new Product(category, product.getName(), product.getPrice());
    }

    public void setName(String name) {
        this.product = new Product(product.getCategory(), name, product.getPrice());
    }

    public void setPrice(double price) {
        this.product = new Product(product.getCategory(), product.getName(), price);
    }

    public void setStock(int stock) {
        this.product.setStock(stock);
    }

    public Product getProduct() {
        Product result = this.product;
        this.reset();
        return result;
    }
}