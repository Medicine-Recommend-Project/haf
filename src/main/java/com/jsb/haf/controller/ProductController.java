package com.jsb.haf.controller;

import com.jsb.haf.model.ProductVO;
import com.jsb.haf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/product")
@RestController
@Controller
public class ProductController {

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
}
