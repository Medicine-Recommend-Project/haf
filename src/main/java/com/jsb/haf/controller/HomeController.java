package com.jsb.haf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController     // → @ResponseBody + @Controller
@RequestMapping("/hi")
public class HomeController {

    //안되네
    // 3/5에 참고 : https://reiphiel.tistory.com/entry/spring-security-csrf
    // 왜 postmapping이 에러나는지.
    @PostMapping("/postTest")
    public String postTest(){
        return "postTest";
    }

    @GetMapping("/post")
    public String post() {
        //return "board/post.html";
        return "post";
    }

    @GetMapping(value = "/why")
    public ModelAndView why(){
        ModelAndView mv = new ModelAndView("post");
        return mv;
    }

    @GetMapping(value = "/jji")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}
