package com.fieldaudit_mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fieldaudit_mongo.enums.Role;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;   // Mongo uses string IDs

    private String firstName;
    private String lastName;
    private String gender;

    private String email;
    private String contact;
    private String password;
    private Date createdAt;

    private Set<Role> roles = new HashSet<>();
}

