package com.feng.model;

import com.feng.util.TransformDate;

import java.util.Date;

/**
 * @author AsuraTu
 */
public class Goods {

    private int id;
    private int userId;
    private String name;
    private String description;
    private Date createAt;
    private Date updateAt;

    public Goods() {
    }

    public Goods(int id, int userId, String name, String description, Date createAt, Date updateAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        // 为 null 的字段不显示
        String result = "Goods{" +
                "id=" + id;

        if (userId != 0) {
            result += ", userId=" + userId;
        }
        if (name != null) {
            result += ", name='" + name + '\'';
        }
        if (description != null) {
            result += ", description='" + description + '\'';
        }
        if (createAt != null) {
            result += ", createAt='" + TransformDate.dateToString(createAt) + '\'';
        }
        if (updateAt != null) {
            result += ", updateAt='" + TransformDate.dateToString(updateAt) + '\'';
        }
        result += '}';

        return result;

    }

    public void test() {
        System.out.println("test");
    }
}
