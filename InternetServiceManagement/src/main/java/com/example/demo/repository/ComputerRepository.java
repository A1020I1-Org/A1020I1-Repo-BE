package com.example.demo.repository;

import com.example.demo.entity.Computer;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, String> {
    @Query(value = "select *\n" +
            "From computer c\n" +
            "inner join type t on c.type_id = t.type_id\n" +
            "inner join status s on c.status_id = s.status_id\n" +
            "where c.computer_id like %:computerId% or c.computer_location like %:computerLocation% or t.type_name like %:type% " +
            "or c.computer_start_used_date between :computerStartUsedFrom and :computerStartUsedTo or s.status_name like %:status%",nativeQuery= true)
    Page<Computer> searchComputer(@Param("computerId") String computerId,
                                  @Param("computerLocation") String computerLocation,
                                  @Param("computerStartUsedFrom") String computerStartUsedFrom,
                                  @Param("computerStartUsedTo") String computerStartUsedTo,
                                  @Param("type") String type,
                                  @Param("status") String status,
                                  Pageable pageable);
}
