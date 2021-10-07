package com.example.demo.service;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findById(int id);
}
