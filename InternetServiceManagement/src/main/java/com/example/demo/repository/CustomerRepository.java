package com.example.demo.repository;


import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

/*
    List<Customer> getAllCustomer();
    Page<Customer> getAllCustomer(Pageable pageable);
*/


    @Query(value= "Select * from customer c where c.username = ?1", nativeQuery=true)
    Customer getCustomerByUsername(String username);


    /*
    @Query( value="select * \n" +
            "from customer c\n" +
            "inner join account a on a.user_name= c.user_name \n" +
            "where c.customer_id like %:id% and c.date_of_birth between :dateStart and :dateEnd " +
            "and c.start_work_date between :workStart and :workEnd or address =:address or p.position_name =:positionName ",
            nativeQuery = true)
    */


    @Query(value = "SELECT customer.*,account.username" +
            "   FROM `customer` " +
            "join `account` on `customer`.account_username = `customer`.username " +
            "where account.username like %?1% and customer.status like %?2% and customer.address like %?3% and (customer.date_of_birth between ?4 and ?5)", nativeQuery = true)
    Page<Customer> searchCustomer(Pageable pageable, String username, String status, String address, String dateBirthFrom, String dateBirthTo);
}

