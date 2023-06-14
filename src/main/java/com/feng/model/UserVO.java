package com.feng.model;

import java.util.List;

/**
 * @author asura
 */
public class UserVO extends User {

    List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "user=" + super.toString() +
                ", goodsList=" + goodsList +
                '}';
    }

}
