package com.example.demo.repos;

import com.example.demo.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {
    Coupon findByCode(String code);
}
