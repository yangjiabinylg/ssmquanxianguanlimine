package com.zjyouths.healthproject.ssm.dao;


import com.zjyouths.healthproject.ssm.po.Orders;
import com.zjyouths.healthproject.ssm.po.Orders2;
import com.zjyouths.healthproject.ssm.po.UserOrder;

/**
 *    写之前理顺思路
 *
 *    订单->用户什么关系
 *    一个订单只能属于一个用户，1对1
 *
 */
public interface OrderMapper {

    /**
     *     根据订单id查询订单信息 ，包含订单属于的用户信息
     *
     * @param id         订单id
     * @return
     */
    public Orders queryById(Integer id);
    /**
     *     根据订单id查询订单信息 ，包含订单属于的用户信息   产品列表
     *
     * @param id         订单id
     * @return
     */
    public Orders2 queryById2(Integer id);

    /**     根据用户的id查询用户的订单，订单中包含订单对应的商品
     *
     * @param uid       用户id
     * @return
     */
    public UserOrder queryByUid(Integer uid);


}
