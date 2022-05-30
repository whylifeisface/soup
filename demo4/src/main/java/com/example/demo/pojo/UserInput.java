package com.example.demo.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class UserInput {
    private String PasswordInput;
    private String UserNameInput;

}
