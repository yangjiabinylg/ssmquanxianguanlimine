package com.zjyouths.healthproject.ssm.po;

import java.sql.Timestamp;
import java.util.List;

public class Orders3 {
    /**
     *    数据库 单词之间是 create_time  java中是creatTime
     *
     *
     */

    private Integer id;//订单的id
    private Timestamp createTime;//订单创建时间
    //private User user;//订单属于的用户
    private List<Product> products;

    @Override
    public String toString() {
        return "Orders3{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", products=" + products +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
