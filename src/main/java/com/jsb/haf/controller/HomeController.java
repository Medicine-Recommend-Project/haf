package com.jsb.haf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/hi")
public class HomeController {

    @GetMapping("/test")
    public String test(){

        String mv = "어떻게 설정하는 건줄 모르겠오요";
        return mv;
    }

    //안되네
    // 3/5에 참고 : https://reiphiel.tistory.com/entry/spring-security-csrf
    // 왜 postmapping이 에러나는지.
    @PostMapping("/postTest")
    public String postTest(){
        String str = "이것은 post mapping test";
        return str;
    }

}
