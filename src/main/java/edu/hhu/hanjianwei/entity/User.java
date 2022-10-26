package edu.hhu.hanjianwei.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author <a href="mail to: im.jianweihan@gmail.com" rel="nofollow">jwhan</a>
 * @date 10/26/2022 - 3:25 PM
 */
@Data
public class User {
    private String account;
    private String nickName;
    private String password;
    private boolean gender;
    private Date birthday;
    private String phone;
    private String email;
    private String description;
    private String realAccount; // 用来解决修改account的问题

    public User() {
    }

    public User(String account, String nickName, String password, boolean gender, Date birthday, String phone, String email, String description) {
        this.account = account;
        this.nickName = nickName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public User(String nickName, String account, String password, boolean gender, Date birthday, String phone, String email, String description, String realAccount) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.realAccount = realAccount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealAccount() {
        return realAccount;
    }

    public void setRealAccount(String realAccount) {
        this.realAccount = realAccount;
    }
}
