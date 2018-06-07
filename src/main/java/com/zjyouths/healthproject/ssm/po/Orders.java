package com.zjyouths.healthproject.ssm.po;

import java.sql.Timestamp;

public class Orders {
    /**
     *    数据库 单词之间是 create_time  java中是creatTime
     *
     *
     */

    private Integer id;//订单的id
    private Timestamp createTime;//订单创建时间
    private User user;//订单属于的用户

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", user=" + user +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
