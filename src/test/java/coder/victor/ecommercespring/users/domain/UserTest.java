package coder.victor.ecommercespring.users.domain;

import coder.victor.ecommercespring.config.exceptions.ApiException;
import coder.victor.ecommercespring.users.exceptions.UserErrorCode;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {
    private final String VALID_EMAIL = "email@email.com";
    private final String VALID_PASSWORD = "password";
    private final String VALID_FIRSTNAME = "name";
    private final String VALID_LASTNAME = "last_name";
    private final RoleEnum VALID_ROLE = RoleEnum.CLIENT;
    private final LocalDate VALID_BIRTHDATE = LocalDate.now();

    @Test
    @DisplayName("Test user role should not be null")
    public void userRoleShouldNotBeNull() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, VALID_LASTNAME, VALID_BIRTHDATE, VALID_EMAIL, VALID_PASSWORD, null)
        );

        assertEquals(UserErrorCode.USER_ROLE_CANNOT_BE_NULL, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user birth date should not be null")
    public void userBirthDateShouldNotBeNull() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, VALID_LASTNAME, null, VALID_EMAIL, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_BIRTH_DATE_CANNOT_BE_NULL, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user email should not be null")
    public void userEmailShouldNotBeNull() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, VALID_LASTNAME, VALID_BIRTHDATE, null, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_EMAIL_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user email should not be  empty")
    public void userEmailShouldNotBeNullOrEmpty() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, VALID_LASTNAME, VALID_BIRTHDATE, null, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_EMAIL_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user password should not be null")
    public void userPasswordShouldNotBeNull() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, VALID_LASTNAME, VALID_BIRTHDATE, VALID_EMAIL, null, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_PASSWORD_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user password should not be empty")
    public void userPasswordShouldNotBeEmpty() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, VALID_LASTNAME, VALID_BIRTHDATE, VALID_EMAIL, " ", VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_PASSWORD_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user first name should not be null")
    public void userFirstNameShouldNotBeNull() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(null, VALID_LASTNAME, VALID_BIRTHDATE, VALID_EMAIL, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_FIRSTNAME_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user first name should not be empty")
    public void userFirstNameShouldNotBeEmpty() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(" ", VALID_LASTNAME, VALID_BIRTHDATE, VALID_EMAIL, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_FIRSTNAME_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user last name should not be null")
    public void userLastNameShouldNotBeNull() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, null, VALID_BIRTHDATE, VALID_EMAIL, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_LASTNAME_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }

    @Test
    @DisplayName("Test user last name should not be empty")
    public void userLastNameShouldNotBeEmpty() {
        ApiException apiException = assertThrows(
                ApiException.class,
                () -> new User(VALID_FIRSTNAME, " ", VALID_BIRTHDATE, VALID_EMAIL, VALID_PASSWORD, VALID_ROLE)
        );

        assertEquals(UserErrorCode.USER_LASTNAME_CANNOT_BE_NULL_OR_EMPTY, apiException.getErrorCodeInterface());
    }
}
