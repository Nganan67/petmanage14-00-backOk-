package org.example.petmanage1.service;

import org.example.petmanage1.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersService {
    Page<Orders> findAllOrders(Pageable pageable);
    List<Orders> findAllOrders(Long ordersId);
    Orders findOrdersByOrdersId(Long ordersId);
    Orders ordersAdd(Orders orders);
    Orders ordersEdit(Long ordersId, Orders updatedOrders);
    void ordersDelete(Long ordersId);
}
