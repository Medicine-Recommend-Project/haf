package com.jsb.haf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RequestMapping("/api")
@RestController     // → @ResponseBody + @Controller
public class HomeController {

    //안되네
    // 3/5에 참고 : https://reiphiel.tistory.com/entry/spring-security-csrf
    // 왜 postmapping이 에러나는지.


    @GetMapping(value = "/why")
    public ModelAndView why(){
        ModelAndView mv = new ModelAndView("postTest");
        return mv;
    }

    @GetMapping("/hello")
    public String hello(){
        return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
    }

}
