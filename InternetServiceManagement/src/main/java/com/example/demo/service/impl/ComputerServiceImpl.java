package com.example.demo.service.impl;

import com.example.demo.service.ComputerService;
import org.springframework.stereotype.Service;

@Service
public class ComputerServiceImpl implements ComputerService {
<<<<<<< HEAD
=======


    @Autowired
    private ComputerRepository computerRepository;


    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }


    @Override
    public void save(Computer computer) {
        computerRepository.save(computer);
    }

    public Computer findById(String id) {
        return computerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(String id) {
        computerRepository.deleteById(id);
    }

    @Override
    public Page<Computer> search(String id, String computerLocation, String computerStartUsedFrom, String computerStartUsedTo, String type, String status, Pageable pageable) {
        return computerRepository.searchComputer(id, computerLocation, computerStartUsedFrom, computerStartUsedTo, type, status, pageable);
    }


>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
}
