package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select customer.* from customer " +
            "right join order_hour on customer.customer_id = order_hour.customer_id " +
            "where (order_hour.start_time between :startTime and :endTime) and (order_hour.end_time between :startTime and :endTime) " +
            "group by order_hour.customer_id " +
            " union " +
            "select customer.* from customer " +
            "right join order_service on customer.customer_id = order_service.customer_id " +
            "where (order_service.order_date between :startTime and :endTime) " +
            "group by order_service.customer_id", nativeQuery = true)
    List<Customer> findAllInStartTimeToEndTime(@Param("startTime")Date startTime, @Param("endTime")Date endTime);
}
