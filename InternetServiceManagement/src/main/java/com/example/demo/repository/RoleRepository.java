package com.example.demo.repository;

<<<<<<< HEAD
public interface RoleRepository {
=======
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
}
