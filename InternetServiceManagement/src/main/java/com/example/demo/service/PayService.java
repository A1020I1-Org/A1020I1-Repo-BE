package com.example.demo.service;

import com.example.demo.entity.Pay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PayService {
    List<Pay> findALl();
    Page<Pay> findAll(Pageable pageable);
    Pay findById(Integer id);
    void save(Pay pay);
    void payment(Integer id);

}
