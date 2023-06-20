package com.company.ecommerce.controller;

import com.company.ecommerce.dto.request.TransactionRequestDto;
import com.company.ecommerce.dto.response.CustomerOfPointSpendByAmountOfProduct;
import com.company.ecommerce.dto.response.ProductResponseDto;
import com.company.ecommerce.exception.AmountRequiredException;
import com.company.ecommerce.model.Customer;
import com.company.ecommerce.model.Product;
import com.company.ecommerce.repository.CustomerRepository;
import com.company.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/transactions")
public class TransactionController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @PostMapping(value = "/test")
    public CustomerOfPointSpendByAmountOfProduct spendAndEarn(@RequestBody TransactionRequestDto requestDto) {
        CustomerOfPointSpendByAmountOfProduct returnValue = new CustomerOfPointSpendByAmountOfProduct();
        Customer customer = customerRepository.findById(requestDto.getCustomerId()).get();
        Product product = productRepository.findById(requestDto.getProductId()).get();
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setName(product.getName());
        returnValue.setCustomerName(customer.getName());
        returnValue.setId(customer.getId());
        returnValue.setProductDto(productResponseDto);
        BigDecimal amount = requestDto.getAmount();
        int points = 0;
        if (Objects.isNull(amount)) {
            throw new AmountRequiredException();
        } else {
            if (amount.intValue() > 100) {
                points += (int) ((amount.intValue() - 100) * 2.0);
                returnValue.setCustomerPoint(points);
            }
            if (amount.intValue() > 50 && amount.intValue() <= 100) {
                points += (int) ((amount.intValue() - 50) * 1.0);
                returnValue.setCustomerPoint(points);
            }
        }
        return returnValue;
    }


}
