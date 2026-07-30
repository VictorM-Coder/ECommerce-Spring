package coder.victor.ecommercespring.documents.services;

import coder.victor.ecommercespring.documents.domain.StoredFile;
import org.springframework.web.multipart.MultipartFile;

public interface ExternalDocumentAdapter {
    StoredFile uploadOrUpdate(MultipartFile file, String path);
    void delete(StoredFile file);
    String getGeneratedUrl(StoredFile file);
}
