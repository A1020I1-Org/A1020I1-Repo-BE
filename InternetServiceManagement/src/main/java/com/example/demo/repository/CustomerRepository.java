package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value= "Select * from customer c where c.username = ?1", nativeQuery=true)
    Customer getCustomerByUsername(String username);

    @Query(value = "select * from customer " , nativeQuery = true)
    Page<Customer> getListCustomer(Pageable pageable);


    @Query(value = "SELECT customer.*,account.username" +
            "   FROM `customer` " +
            "join `account` on `customer`.account_username = `customer`.username " +
            "where (account.username like %?1% or account.username is null ) and customer.status like %?2% and (customer.address like %?3% or is null ) and (customer.date_of_birth between ?4 and ?5)", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable, String username, String status, String address, String dateBirthFrom, String dateBirthTo);


    boolean existsByEmail(String email);

}

