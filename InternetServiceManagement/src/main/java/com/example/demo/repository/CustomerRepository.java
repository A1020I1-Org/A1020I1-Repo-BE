package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select c from Customer c inner join Order o on c.customerId = o.customer.customerId " +
            "inner join OrderService os on c.customerId = os.customer.customerId " +
            "inner join OrderServiceToTal ot on os.orderServiceToTal.id = ot.id " +
            "where ((o.startTime between :startTime and :endTime) and (o.endTime between :startTime and:endTime)) " +
            "and (ot.dateOrderService between :startTime and :endTime)")
    List<Customer> findAllInStartTimeToEndTime(@Param("startTime")Date startTime, @Param("endTime")Date endTime);
}
