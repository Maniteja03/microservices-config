package com.ctg.user.service.entity;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 200, message = "Password must be between 6 and 20 characters")
    private String password;

   
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Contact number must be exactly 10 digits and start with 6-9")
    @NotBlank(message = "Contact number cannot be empty")
    @Column(unique = true)
    private String contactNumber;
    
    @Column(nullable = false)
    private String role; // e.g., "ADMIN" or "USER"
 
    // Set default role to "USER" before persisting
    @PrePersist
    public void setDefaultRole() {
        if (this.role == null || this.role.isEmpty()) {
            this.role = "USER";
        }
    }
    
    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
