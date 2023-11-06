package stream;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {

    private String type;

    private BigDecimal price;

    private boolean discountAvailable;

    private LocalDateTime dateAdded;

    private String id;

    public Product(String type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, BigDecimal price, boolean discountAvailable) {
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
    }

    public Product(String type, BigDecimal price, boolean discountAvailable, LocalDateTime date) {
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.dateAdded = date;
    }

    public Product(String type, BigDecimal price, boolean discountAvailable, LocalDateTime dateAdded, String id) {
        this.type = type;
        this.price = price;
        this.discountAvailable = discountAvailable;
        this.dateAdded = dateAdded;
        this.id = id;
    }

    public Product applyDiscount(BigDecimal discount) {
        BigDecimal discountAmount = price.multiply(discount);
        price = price.subtract(discountAmount);
        return this;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isDiscountAvailable() {
        return discountAvailable;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getId() {
        return id;
    }
}
