package com.devanktu.ecommerce.controller;

import com.devanktu.ecommerce.dto.OrderDto;
import com.devanktu.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
//@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class TrackingController {

    private final CartService cartService;

    @GetMapping("/order/{trackingId}")
    public ResponseEntity<OrderDto> searchOrderByTrackingId(@PathVariable UUID trackingId) {
        OrderDto orderDto = cartService.searchOrderByTrackingId(trackingId);
        if (orderDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(orderDto);
    }

}
