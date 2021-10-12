package com.example.demo.controller;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.jwt.JwtResponse;
import com.example.demo.jwt.LoginRequest;
import com.example.demo.sercurity.AccountDetailServiceImpl;
import com.example.demo.sercurity.AccountDetailsImpl;
import com.example.demo.service.AccountService;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecurityController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AccountDetailServiceImpl accountDetailService;
    //    @Autowired
//    private AccountRoleService accountRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/api/public/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        Authentication authentication;
        Account account = accountService.findByUserName(loginRequest.getUsername());
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        }catch (Exception e) {
            if (accountService.findByUserName(loginRequest.getUsername()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.readTree("{\"error\": \"Tên đăng nhập hoặc mật khẩu không đúng\"}");
                return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
            } else {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.readTree("{\"error\": \"Không tìm thấy tài khoản\"}");
                return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
            }
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenUtil.generateJwtToken(loginRequest.getUsername());
        AccountDetailsImpl userDetails = (AccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Customer customer = customerService.findByAccount(account.getUserName());
        account.setPassword("");
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(
                new JwtResponse(jwt, account, customer, roles)
        );
    }
}