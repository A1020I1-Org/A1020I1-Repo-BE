package com.example.demo.service.impl;

import com.example.demo.entity.Pay;
import com.example.demo.repository.PayRepository;
import com.example.demo.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayRepository payRepository;
    @Override
    public List<Pay> findALl() {
        return payRepository.findAll();
    }

    @Override
    public Page<Pay> findAll(Pageable pageable) {
        return payRepository.findAll(pageable);
    }

    @Override
    public Pay findById(Integer id) {
        return payRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Pay pay) {
        payRepository.save(pay);
    }
}
