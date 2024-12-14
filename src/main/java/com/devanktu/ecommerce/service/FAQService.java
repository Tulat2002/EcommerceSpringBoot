package com.devanktu.ecommerce.service;

import com.devanktu.ecommerce.dto.FAQDto;

public interface FAQService {

    FAQDto postFAQ(Long productId, FAQDto faqDto);

}
