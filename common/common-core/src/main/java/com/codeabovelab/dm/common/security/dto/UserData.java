

package com.codeabovelab.dm.common.security.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class UserData {
    private Long userId;
    @NotNull @NotBlank private String userName;
    @NotNull @NotBlank @Email private String email;
    @NotNull private Long mobile;
    /**
     * there will be many system use this user-module, this field specify user's origin
     */
    private String userType;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "userName='" + userName + "', email='" + email + "', mobile=" + mobile
                + "', userType is = " + userType;
    }
}
