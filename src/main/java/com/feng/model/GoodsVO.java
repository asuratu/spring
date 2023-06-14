package com.feng.model;

/**
 * @author AsuraTu
 */
public class GoodsVO extends Goods {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
                "user=" + user +
                ", goods=" + super.toString() +
                '}';
    }

}
