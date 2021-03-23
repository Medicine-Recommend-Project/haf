package com.jsb.haf.controller;

import com.jsb.haf.model.ProductVO;
import com.jsb.haf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//@CrossOrigin :  https://velog.io/@modsiw/Spring-CrossOrigin-Annotation-%EC%A0%95%EB%A6%AC
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
@RestController
@Controller
public class HomeController {

    /*  페이지 공통 기능 다룰 때 쓸 Controller임    */

    @GetMapping(value = "/why")
    public ModelAndView why(){
        ModelAndView mv = new ModelAndView("postTest");
        return mv;
    }

    @GetMapping(value = "/hello")
    public String hello(){
        return "안녕 지금 한국 시간은 " + new Date() + "입니다용 \n" ;
    }

    @Autowired
    ProductService productService;

    @GetMapping("/home")
    public ModelAndView goHome(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        List<ProductVO> ProductList = productService.getProduct();

        mav.addObject("ProductList", ProductList);
        mav.setViewName("content/home.html");

        return mav;
    }

    @GetMapping(value="/me")
    public String me(){
        return "postTest";
    }

    @PostMapping("/ip")
    public ResponseEntity<String> ip (HttpServletRequest request) {
        // 요청을 보낸 클라이언트의 IP주소를 반환합니다.
        return ResponseEntity.ok(request.getRemoteAddr());
    }
}
