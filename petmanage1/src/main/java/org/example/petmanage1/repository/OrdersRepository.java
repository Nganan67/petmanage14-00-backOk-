package org.example.petmanage1.repository;

import org.example.petmanage1.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    // 根据订单ID查询订单
    Orders findByOrdersId(Long ordersId);
    // 根据订单状态查询订单
    List<Orders> findByOrderStatus(String orderStatus);
    // 根据用户 ID 查询订单（按照订单 ID 降序排列）
    List<Orders> findByUserIdOrderByOrdersIdDesc(Long userId);
    //根据产品ID查询订单
    Optional<Orders> findOrdersByOrdersId(Long ordersId);
    Orders ordersAdd(Orders orders);
    Orders ordersDelete(Long ordersId);

}
