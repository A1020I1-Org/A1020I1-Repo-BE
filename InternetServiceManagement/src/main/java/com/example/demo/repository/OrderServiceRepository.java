package com.example.demo.repository;

import com.example.demo.entity.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, String> {
    @Query("select o from OrderService o where (o.orderDate between :startTime and :endTime) and (o.status = true) ")
    List<OrderService> findAllInStartTimeToEndTime(@Param("startTime") Date startTime,
                                                   @Param("endTime")Date endTime);
}
