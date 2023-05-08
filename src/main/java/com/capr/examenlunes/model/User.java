package com.capr.examenlunes.model;

import com.capr.examenlunes.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    public User(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.phone = userDTO.getPhone();
        this.email = userDTO.getEmail();
    }
}
