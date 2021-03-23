package com.jsb.haf.controller;

import com.jsb.haf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
@RestController
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;


}
