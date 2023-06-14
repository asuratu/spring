package com.feng.model;

import com.feng.util.TransformDate;

import java.io.Serializable;
import java.util.Date;

/**
 * @author asura
 */
public class User implements Serializable {
    // Serializable 序列化接口, 使用 二级缓存 必须实现序列化接口
    // Serializable 作用: 将对象转换为字节序列, 以便在 JVM 中传输和存储
    private Integer id;
    private String passport;
    private String password;
    private String nickname;
    private Date createAt;
    private Date updateAt;
    private Double balance;

    // 无参构造
    public User() {
    }

    // 有参构造
    public User(Integer id, String passport, String password, String nickname, Date createAt, Date updateAt, Double balance) {
        this.id = id;
        this.passport = passport;
        this.password = password;
        this.nickname = nickname;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        // 为 null 的字段不显示
        String result = "User{" +
                "id=" + id + ", ";
        if (passport != null) {
            result += "passport='" + passport + '\'' + ", ";
        }
        if (password != null) {
            result += "password='" + password + '\'' + ", ";
        }
        if (nickname != null) {
            result += "nickname='" + nickname + '\'' + ", ";
        }
        if (createAt != null) {
            result += "createAt='" + TransformDate.dateToString(createAt) + '\'' + ", ";
        }
        if (updateAt != null) {
            result += "updateAt='" + TransformDate.dateToString(updateAt) + '\'' + ", ";
        }
        if (balance != null) {
            result += "balance=" + balance;
        }
        result += '}';

        return result;
    }
}
