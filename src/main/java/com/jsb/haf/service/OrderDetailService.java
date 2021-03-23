package com.jsb.haf.service;

import com.jsb.haf.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

    @Autowired
    public OrderDetailMapper mapper;


}
