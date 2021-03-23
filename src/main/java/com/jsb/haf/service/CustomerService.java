package com.jsb.haf.service;

import com.jsb.haf.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerMapper mapper;


}
