package com.Restaurant.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "authentication_tokens")
public class AuthenticationToken {
    @Id
    private String id;
    private String token;
    private String userId;
    private boolean expired;
}