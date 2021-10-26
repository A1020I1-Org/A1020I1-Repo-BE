package com.example.demo.repository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderServiceRepository extends JpaRepository<OrderService, Integer> {
    @Query(value = "select * from order_service os inner join pay p on os.pay_id = p.pay_id\n" +
            "inner join order_hour oh on p.order_id = oh.id\n" +
            "inner join customer c on oh.customer_id = c.customer_id\n" +
            "where p.status = 0 and os.status = 0", nativeQuery = true)
    List<OrderService> findListOrderService();
}
