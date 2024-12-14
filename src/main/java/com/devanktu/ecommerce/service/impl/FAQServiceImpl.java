package com.devanktu.ecommerce.service.impl;

import com.devanktu.ecommerce.dto.FAQDto;
import com.devanktu.ecommerce.entity.FAQ;
import com.devanktu.ecommerce.entity.Product;
import com.devanktu.ecommerce.repository.FAQRepository;
import com.devanktu.ecommerce.repository.ProductRepository;
import com.devanktu.ecommerce.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FAQServiceImpl implements FAQService {

    private final FAQRepository faqRepository;

    private final ProductRepository productRepository;

    public FAQDto postFAQ(Long productId, FAQDto faqDto) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isPresent()) {
            FAQ faq = new FAQ();
            faq.setQuestion(faqDto.getQuestion());
            faq.setAnswer(faqDto.getAnswer());
            faq.setProduct(optionalProduct.get());

            return faqRepository.save(faq).getFAQDto();
        }
        return null;
    }

}
