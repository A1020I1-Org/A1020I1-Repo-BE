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
            "inner join position p on p.position_id= e.position_id\n" +
            "where e.employee_id =:id or e.date_of_birth between :dateStart and :dateEnd " +
            "or e.start_work_date between :workStart and :workEnd or address =:address or p.position_name =:positionName ",
            nativeQuery = true)
    Page<Employee> searchEmployee(@Param("id") String id, @Param("dateStart") String dateStart,
                                  @Param("dateEnd") String dateEnd,
                                  @Param("workStart") String workStart, @Param("workEnd") String workEnd,
                                  @Param("address") String address, @Param("positionName") String positionName,
                                  Pageable pageable);
}
