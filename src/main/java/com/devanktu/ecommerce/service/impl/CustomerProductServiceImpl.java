package com.devanktu.ecommerce.service.impl;

import com.devanktu.ecommerce.dto.ProductDetailDto;
import com.devanktu.ecommerce.dto.ProductDto;
import com.devanktu.ecommerce.entity.FAQ;
import com.devanktu.ecommerce.entity.Product;
import com.devanktu.ecommerce.entity.Review;
import com.devanktu.ecommerce.repository.FAQRepository;
import com.devanktu.ecommerce.repository.ProductRepository;
import com.devanktu.ecommerce.repository.ReviewRepository;
import com.devanktu.ecommerce.service.CustomerProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerProductServiceImpl implements CustomerProductService {

    private final ProductRepository productRepository;

    private final FAQRepository faqRepository;

    private final ReviewRepository reviewRepository;

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> searchProductByTitle(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public ProductDetailDto getProductDetailById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            List<FAQ> faqList = faqRepository.findAllByProductId(productId);
            List<Review> reviewList = reviewRepository.findAllByProductId(productId);

            ProductDetailDto productDetailDto = new ProductDetailDto();

            productDetailDto.setProductDto(optionalProduct.get().getDto());
            productDetailDto.setFaqDtoList(faqList.stream().map(FAQ::getFAQDto).collect(Collectors.toList()));
            productDetailDto.setReviewDtoList(reviewList.stream().map(Review::getDto).collect(Collectors.toList()));
            return productDetailDto;
        }
        return null;
    }

}
