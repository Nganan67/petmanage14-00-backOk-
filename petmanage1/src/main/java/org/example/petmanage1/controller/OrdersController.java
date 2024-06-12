package org.example.petmanage1.controller;

import jakarta.persistence.criteria.Order;
import org.example.petmanage1.entity.Orders;
import org.example.petmanage1.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping
    public ResponseEntity<Page<Orders>> getAllOrders(Pageable pageable) {
        Page<Orders> page = ordersService.findAllOrders(pageable);
        return ResponseEntity.ok(page);
    }
    @PostMapping
    public ResponseEntity<Orders> addOrder(@RequestBody Orders orders) {
        Orders newOrders = ordersService.ordersAdd(orders);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrders);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Orders> ordersEdit(@PathVariable Long ordersId, @RequestBody Orders orders) {
        Orders updatedOrders = ordersService.ordersEdit(ordersId, orders);
        return updatedOrders != null ? ResponseEntity.ok(updatedOrders) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ordersDelete(@PathVariable Long ordersId) {
        ordersService.ordersDelete(ordersId);
        return ResponseEntity.ok().build();
    }
        //支持分页显示orders列表请求
    //addOrders()实现添加订单请求
    //editOrders()实现编辑更新订单信息
    //deleteOrders()实现删除订单信息
}
