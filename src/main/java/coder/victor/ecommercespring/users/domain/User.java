package coder.victor.ecommercespring.users.domain;

import coder.victor.ecommercespring.config.exceptions.ApiException;
import coder.victor.ecommercespring.documents.domain.StoredFile;
import coder.victor.ecommercespring.shared.Inactivable;
import coder.victor.ecommercespring.users.exceptions.UserErrorCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class User implements Inactivable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private boolean active = true;

    @NotNull
    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    @NotNull
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "profile_picture_id")
    private StoredFile profilePicture;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public User() {

    }

    @Override
    public void inactivate() {
        active = false;
    }

    @Override
    public void activate() {
        active = true;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public User(
            String firstName,
            String lastName,
            LocalDate birthDate,
            String email,
            String password,
            RoleEnum role
    ) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new ApiException(UserErrorCode.USER_FIRSTNAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new ApiException(UserErrorCode.USER_LASTNAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.lastName = lastName;
    }

    private void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new ApiException(UserErrorCode.USER_BIRTH_DATE_CANNOT_BE_NULL);
        }
        this.birthDate = birthDate;
    }

    private void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new ApiException(UserErrorCode.USER_EMAIL_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.email = email;
    }

    private void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new ApiException(UserErrorCode.USER_PASSWORD_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.password = password;
    }

    private void setRole(RoleEnum role) {
        if (role == null) {
            throw new ApiException(UserErrorCode.USER_ROLE_CANNOT_BE_NULL);
        }
        this.role = role;
    }
}
