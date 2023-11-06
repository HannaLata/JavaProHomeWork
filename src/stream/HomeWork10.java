package stream;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWork10 {

    private static List<Product> getProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice().compareTo(new BigDecimal("250.0")) > 0)
                .toList();
    }

    private static List<Product> getProductsWithDiscount(List<Product> products) {
        BigDecimal discountRate = new BigDecimal("0.10");
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .filter(Product::isDiscountAvailable)
                .map(p -> p.applyDiscount(discountRate))
                .toList();
    }

    private static Product getTheCheapestProduct(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [category: Book] not found."));
    }

    private static List<Product> getLastThreeProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }

    private static BigDecimal getTotalCost(List<Product> products) {
        return products.stream()
                .filter(p -> p.getType().equals("Book") &&
                        p.getPrice().compareTo(new BigDecimal("75.0")) <= 0 &&
                        p.getDateAdded().getYear() == LocalDateTime.now().getYear())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static Map<String, List<Product>> getProductsGrouped(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
