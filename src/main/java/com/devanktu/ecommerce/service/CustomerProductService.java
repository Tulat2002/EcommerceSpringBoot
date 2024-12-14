package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.ProductDetailDto;
import com.devanktu.ecommerce.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

    List<ProductDto> getAllProducts();

    List<ProductDto> searchProductByTitle(String title);

    ProductDetailDto getProductDetailById(Long productId);

}
