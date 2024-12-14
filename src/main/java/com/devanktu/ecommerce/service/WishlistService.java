package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.WishlistDto;

import java.util.List;

public interface WishlistService {

    WishlistDto addProductToWishlist(WishlistDto wishlistDto);

    List<WishlistDto> getWishlistsByUserId(Long userId);

}
