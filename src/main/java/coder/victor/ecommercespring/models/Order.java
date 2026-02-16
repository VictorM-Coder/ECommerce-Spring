package coder.victor.ecommercespring.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    private Instant moment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items;

    public void cancel() {
        if (status == OrderStatus.CANCELED) {
            throw new IllegalStateException("Order is already canceled");
        }
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Cannot cancel a paid order");
        }
        this.status = OrderStatus.CANCELED;
    }


}
