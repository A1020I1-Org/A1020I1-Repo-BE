package com.example.demo.service;

public interface ComputerService {
<<<<<<< HEAD
=======

    Page<Computer> findAll(Pageable pageable);

    List<Computer> findAll();

    Computer findById(String id);

    void save(Computer computer);

    void delete (String id);
    Page<Computer> search(String id, String computerLocation, String computerStartUsedFrom, String computerStartUsedTo, String type, String status,Pageable pageable);

>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
}
