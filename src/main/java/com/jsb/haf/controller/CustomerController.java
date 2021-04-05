package com.jsb.haf.controller;

import com.jsb.haf.model.CustomerVO;
import com.jsb.haf.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/customer")
//@RestController
@Controller
@Slf4j
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @ResponseBody
    @PostMapping("/checkId")
    public int checkId(@PathVariable @RequestBody String cId){
        log.info("cId : " + cId);
        return customerService.selectId(cId);
    }

    @PostMapping("/join")
    public String join(@RequestBody CustomerVO vo){
        log.info(vo.getCId());
        return "축하해~";
    }
}
