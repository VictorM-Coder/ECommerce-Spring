package coder.victor.ecommercespring.documents.domain;

import coder.victor.ecommercespring.config.exceptions.ApiException;
import coder.victor.ecommercespring.documents.exceptions.DocumentsErrorCode;
import coder.victor.ecommercespring.users.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class StoredFileTest {

    public static final User USER_MOCKED = Mockito.mock(User.class);
    public static final String VALID_URL = "http://example.com/file.txt";

    @Test
    @DisplayName("Test updateUrl should throw ApiException when url is null")
    public void testUpdateUrlWithNull() {
        StoredFile storedFile = new StoredFile();

        ApiException apiException = Assertions.assertThrows(
                ApiException.class,
                () -> storedFile.updateUrl(null, USER_MOCKED)
        );

        assertEquals(DocumentsErrorCode.DOCUMENT_URL_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @DisplayName("Test updateUrl should throw ApiException when url is empty")
    @Test
    public void testUpdateUrlWithEmpty() {
        StoredFile storedFile = new StoredFile();

        ApiException apiException = Assertions.assertThrows(
                        ApiException.class,
                        () -> storedFile.updateUrl(" ", USER_MOCKED)
        );

        assertEquals(DocumentsErrorCode.DOCUMENT_URL_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @DisplayName("Test updateUrl should update url and lastUpdateBy when url is valid")
    @Test
    public void testUpdateUrlWithValidUrl() {
        StoredFile storedFile = new StoredFile();

        storedFile.updateUrl(VALID_URL, USER_MOCKED);

        assertTrue(storedFile.hasUrl());
        assertEquals(USER_MOCKED, storedFile.getLastUptadeBy());
        assertEquals(VALID_URL, storedFile.getUrlPath());
    }

    @DisplayName("Test hasUrl should return false when url is null or empty")
    @Test
    public void testHasUrlWithNullOrEmpty() {
        StoredFile storedFile = new StoredFile();
        assertFalse(storedFile.hasUrl());
    }

    @DisplayName("Test hasUrl should return true when url is not null or empty")
    @Test
    public void testHasUrlWithNotNullOrEmpty() {
        StoredFile storedFile = new StoredFile();
        storedFile.updateUrl(VALID_URL, USER_MOCKED);
        assertTrue(storedFile.hasUrl());
    }
}
