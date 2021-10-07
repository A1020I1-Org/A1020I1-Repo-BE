package com.example.demo.repository;

import com.example.demo.entity.OrderServiceToTal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderServiceTotalRepository extends JpaRepository<OrderServiceToTal, Integer> {
    @Query("select o from OrderServiceToTal o where (o.dateOrderService between ?1 and ?2) ")
    List<OrderServiceToTal> findAllInStartTimeToEndTime(Date startTime,Date endTime);
}
