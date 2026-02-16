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
}
