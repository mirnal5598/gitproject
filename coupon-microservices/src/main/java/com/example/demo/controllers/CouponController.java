package com.example.demo.controllers;

import com.example.demo.model.Coupon;
import com.example.demo.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CouponController {

//    @Autowired
//    private CouponRepo repo;
//
//    @GetMapping("/")
//    public String index(){
//
//        return "index";
//    }
//
//
//    @GetMapping("/showCreateCoupon")
//    public String showCreateCoupon(){
//
//        return "createCoupon";
//    }
//
//    @PostMapping("/saveCoupon")
//    public String save(Coupon coupon){
//        repo.save(coupon);
//        return "createResponse";
//    }
}
