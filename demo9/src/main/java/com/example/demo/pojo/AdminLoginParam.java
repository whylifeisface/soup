package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;

@Data
@Accessors(chain = true)
@ApiModel("登录的用户名密码" )

public class AdminLoginParam {
    @ApiModelProperty(value = "用户名",required = true  )
    private String username;
    @ApiModelProperty(value = "密码",required = true  )
    private String password;

}
