package com.example.demo.controllers;

import com.example.demo.model.Coupon;
import com.example.demo.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponController {

    @Autowired
    private CouponRepo repo;

//    @GetMapping("/")
//    public String index(){
//
//        return "index";
//    }


    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon(){

        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon){
        repo.save(coupon);
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon(Coupon coupon){
        repo.save(coupon);
        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code){
        ModelAndView mav = new ModelAndView("couponDetails");
        mav.addObject(repo.findByCode(code));
        return mav;
    }
}
