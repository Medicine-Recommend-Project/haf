package com.jsb.haf.service;

import com.jsb.haf.mapper.CustomerMapper;
import com.jsb.haf.model.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerMapper mapper;

    /******************SELECT******************/

    public int selectId(String cId){ return mapper.selectId(cId); }

    /******************INSERT******************/
    /******************UPDATE******************/
    /******************DELETE******************/
}
