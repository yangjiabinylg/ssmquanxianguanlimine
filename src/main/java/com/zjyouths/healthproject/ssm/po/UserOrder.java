package com.zjyouths.healthproject.ssm.po;

import java.util.List;

public class UserOrder extends User {


    private List<Orders3> orders;

    @Override
    public String toString() {
        return "UserOrder{" +
                "orders=" + orders +
                '}'+super.toString();
    }

    public List<Orders3> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders3> orders) {
        this.orders = orders;
    }
}
