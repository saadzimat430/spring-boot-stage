package com.ecommerce.ecommerce.dao;

import com.ecommerce.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Override
    @SuppressWarnings("unchecked")
    Order save(Order order);
}
