package com.devanktu.ecommerce.service.impl;

import com.devanktu.ecommerce.dto.WishlistDto;
import com.devanktu.ecommerce.entity.Product;
import com.devanktu.ecommerce.entity.User;
import com.devanktu.ecommerce.entity.WishList;
import com.devanktu.ecommerce.repository.ProductRepository;
import com.devanktu.ecommerce.repository.UserRepository;
import com.devanktu.ecommerce.repository.WishlistRepository;
import com.devanktu.ecommerce.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final WishlistRepository wishlistRepository;

    public WishlistDto addProductToWishlist(WishlistDto wishlistDto) {
        Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(wishlistDto.getUserId());

        if(optionalProduct.isPresent() && optionalUser.isPresent()) {
            WishList wishlist = new WishList();
            wishlist.setProduct(optionalProduct.get());
            wishlist.setUser(optionalUser.get());

            return wishlistRepository.save(wishlist).getWishlistDto();
        }
        return null;
    }

    public List<WishlistDto> getWishlistsByUserId(Long userId) {
        return wishlistRepository.findAllByUserId(userId).stream().map(WishList::getWishlistDto).collect(Collectors.toList());
    }

}
