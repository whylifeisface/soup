package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.net.UnknownServiceException;
import java.util.Collection;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@ApiModel(value = "Admin对象",description = "")
@Component
public class admin  implements UserDetails {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "name")
    private String name;
    @ApiModelProperty(value = "phone")
    private String phone;
    @ApiModelProperty(value = "telephone")
    private String telephone;
    @ApiModelProperty(value = "address")
    private String address;
    @ApiModelProperty(value = "enable")
    private Boolean enable;
    @ApiModelProperty(value = "username")
    private String username;
    @ApiModelProperty(value = "password")
    private String password;
    @ApiModelProperty(value = "userFace")
    private String userFace;
    @ApiModelProperty(value = "remark")
    private String remark;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enable;
    }
}
