package coder.victor.ecommercespring.storedfiles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "stored_files")
public class StoredFile {
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
    @Setter
    private String url;
}
