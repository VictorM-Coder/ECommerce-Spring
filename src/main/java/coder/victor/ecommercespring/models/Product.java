package coder.victor.ecommercespring.models;

import coder.victor.ecommercespring.storedfiles.StoredFile;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;

    @Getter
    private BigDecimal price;

    Set<StoredFile> images;

    public void setPrice(BigDecimal newPrice) {
        if (newPrice == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price can't be negative");
        }

        this.price = newPrice;
    }
}
