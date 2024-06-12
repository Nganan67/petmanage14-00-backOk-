package org.example.petmanage1.service.Impl;

import org.example.petmanage1.entity.Orders;
import org.example.petmanage1.repository.OrdersRepository;
import org.example.petmanage1.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
    //返回全部订单列表selectOrdersList()
    @Override
    public Page<Orders> findAllOrders(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }
//?
    @Override
    public List<Orders> findAllOrders(Long ordersId) {
        return List.of();
    }
    @Override
    public Orders findOrdersByOrdersId(Long ordersId) {
        return null;
    }
//?
    @Override
    public Orders ordersAdd(Orders orders) {
        return ordersRepository.ordersAdd(orders);
    }
    @Override
    public Orders ordersEdit(Long ordersId, Orders updatedOrders){
        Orders orders = ordersRepository.findOrdersByOrdersId(ordersId).orElse(null);
        if(orders != null){
            //更新属性
            orders.setOrdersId(updatedOrders.getOrdersId());
            orders.setOrderStatus(updatedOrders.getOrderStatus());
            return ordersRepository.save(orders);
        }
        return null;
    }
    @Override
    public void ordersDelete(Long ordersId) {
        ordersRepository.ordersDelete(ordersId);
    }
    //通过订单ID选择管理员selectOrdersById()
    //保存订单OrdersSave()
    //更新订单OrdersEdit()
    //删除删除OrdersDelete()
    //获取删除getOrdersList()
}
