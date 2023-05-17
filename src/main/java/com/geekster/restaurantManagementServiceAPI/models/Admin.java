package com.geekster.restaurantManagementServiceAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RestaurantAdmin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String adminFirstName;

    private String adminLastName;

    @Email
    @Column(nullable = false,unique = true)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@admin\\.com$")
    private String adminEmail;

    @Column(nullable = false,unique = true)
    private String  adminUserName;

}
