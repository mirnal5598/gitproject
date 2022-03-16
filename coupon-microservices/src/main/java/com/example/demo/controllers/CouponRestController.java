package com.example.demo.controllers;

import com.example.demo.model.Coupon;
import com.example.demo.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    @Autowired
    CouponRepo couponRepo;

//    @RequestMapping(value = "/coupons", method = RequestMethod.POST)
    @PostMapping("/coupons")
    //@Secured("ADMIN")
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }

//    @RequestMapping(value = "/coupons/{code}", method = RequestMethod.GET)
    @GetMapping("/coupons/{code}")
    //@Secured({"ADMIN"})
    public Coupon getCoupon(@PathVariable("code") String code){
        return couponRepo.findByCode(code);
    }
}
