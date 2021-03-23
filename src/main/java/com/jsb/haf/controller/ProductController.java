package com.jsb.haf.controller;

import com.jsb.haf.model.ProductVO;
import com.jsb.haf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
@RestController
@Controller
public class ProductController {

    @Autowired
    ProductService productService;


}
