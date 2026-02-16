package coder.victor.ecommercespring.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@NoArgsConstructor
public class Category {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @Getter
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Getter
    private String name;

    public Category(String name) {
        setName(name);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }

        this.name = name;
    }
}
