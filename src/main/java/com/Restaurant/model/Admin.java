package com.Restaurant.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection = "admins")
public class Admin {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Error error;

    @Getter
    @Setter
    public static class Error {
        private String message;

        public Error(String message) {
            this.message = message;
        }
    }
}