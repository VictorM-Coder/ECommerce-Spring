package coder.victor.ecommercespring.documents.domain;

import coder.victor.ecommercespring.config.exceptions.ApiException;
import coder.victor.ecommercespring.documents.exceptions.DocumentsErrorCode;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "stored_files")
public class StoredFile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    private String url;

    public String getUrl() {
        return url;
    }

    public void updateUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new ApiException(DocumentsErrorCode.DOCUMENT_URL_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.url = url;
    }
}
