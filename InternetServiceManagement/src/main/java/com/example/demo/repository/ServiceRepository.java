package com.example.demo.repository;

import com.example.demo.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, String> {


    @Query(value = "SELECT * FROM Service s WHERE s.service_id like %:searchName% or " +
            "s.service_name like %:searchName% or s.unit like %:searchName% " +
            "or s.prices like %:searchName% or s.quantity like %:searchName%", nativeQuery = true)
    Page<Service> search(Pageable pageable, @Param("searchName") String searchName);

}
