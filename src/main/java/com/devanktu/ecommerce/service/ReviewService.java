package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.OrderedProductsResponseDto;
import com.devanktu.ecommerce.dto.ReviewDto;

import java.io.IOException;

public interface ReviewService {

    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
