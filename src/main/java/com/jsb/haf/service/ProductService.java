package com.jsb.haf.service;

import com.jsb.haf.mapper.ProductMapper;

import com.jsb.haf.model.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductMapper mapper;

    public List<ProductVO> getProduct() {
         return  mapper.getProduct();
    }

}
