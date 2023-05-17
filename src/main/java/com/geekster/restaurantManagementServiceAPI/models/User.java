package com.geekster.restaurantManagementServiceAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userFirstName;

    private String userLastName;

    private String userEmail;
    @Column(nullable = false,unique = true)
    private String  userUserName;

    @NotNull
    private String userPassword;

}
