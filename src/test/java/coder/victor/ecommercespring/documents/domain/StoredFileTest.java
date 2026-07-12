package coder.victor.ecommercespring.documents.domain;

import coder.victor.ecommercespring.config.exceptions.ApiException;
import coder.victor.ecommercespring.documents.exceptions.DocumentsErrorCode;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredFileTest {

    @Test
    @DisplayName("Test updateUrl should throw ApiException when url is null")
    public void testUpdateUrlWithNull() {
        StoredFile storedFile = new StoredFile();

        ApiException apiException = Assertions.assertThrows(
                ApiException.class,
                () -> storedFile.updateUrl(null)
        );

        assertEquals(DocumentsErrorCode.DOCUMENT_URL_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @DisplayName("Test updateUrl should throw ApiException when url is empty")
    @Test
    public void testUpdateUrlWithEmpty() {
        StoredFile storedFile = new StoredFile();

        ApiException apiException = Assertions.assertThrows(
                        ApiException.class,
                        () -> storedFile.updateUrl(" ")
        );

        assertEquals(DocumentsErrorCode.DOCUMENT_URL_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }
}
