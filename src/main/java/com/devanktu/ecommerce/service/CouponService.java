package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.entity.Coupon;

import java.util.List;

public interface CouponService {

    Coupon createCoupon(Coupon coupon);

    List<Coupon> getAllCoupons();

}
