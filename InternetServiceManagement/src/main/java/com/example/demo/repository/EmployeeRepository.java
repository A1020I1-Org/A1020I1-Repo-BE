package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query( value="select *\n" +
            "from employee e \n" +
            "where (e.employee_id like %?1% or e.employee_id is null) \n" +
            "and (e.date_of_birth > ?2 and e.date_of_birth < ?3 )\n" +
            "and ((e.start_work_date between ?4 and ?5 ) )\n" +
            "and (e.address like %?6% or e.address is null )\n" +
            "and (e.position_id like %?7% or e.position_id is null ) ",nativeQuery= true)
    Page<Employee> searchEmployee1(String idEmp,String dateStart,String dateEnd,String workStart,
                                  String workEnd, String address, String positionId,
                                  Pageable pageable);
}
