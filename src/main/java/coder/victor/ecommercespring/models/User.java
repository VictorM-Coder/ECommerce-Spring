package coder.victor.ecommercespring.models;

import coder.victor.ecommercespring.storedfiles.StoredFile;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
public class User {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    private String name;

    @Getter
    private String description;

    @Getter
    private BigDecimal price;

    @Getter
    @OneToOne
    @JoinColumn(name = "profile_picture_id")
    private StoredFile profilePicture;

    @Getter
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Getter
    private String email;

    @Getter
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
