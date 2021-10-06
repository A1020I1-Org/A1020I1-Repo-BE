package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query( value="select * \n" +
            "from employee e\n" +
            "inner join position p on p.position_id= e.employee_id\n" +
            "where e.employee_id =:id or e.date_of_birth between :date1 and :date2 " +
            "or e.start_work_date between :work1 and :work2 or address =:address or p.position_name =:positionName ",
            nativeQuery = true)
    Page<Employee> searchEmployee(@Param("id") String id, @Param("date1") String date1, @Param("date2") String date2,
                                  @Param("work1") String work1, @Param("work2") String work2,
                                  @Param("address") String address, @Param("positionName") String positionName, Pageable pageable);
}
