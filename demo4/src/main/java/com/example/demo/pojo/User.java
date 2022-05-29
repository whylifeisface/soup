package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class User {
    @TableField(value = "user_name")
    private String username;
    private String password;
    private int id;
}
