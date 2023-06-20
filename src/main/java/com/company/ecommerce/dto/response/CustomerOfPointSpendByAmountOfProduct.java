package com.company.ecommerce.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerOfPointSpendByAmountOfProduct {
    Long id;
    String customerName;
    int customerPoint;
    ProductResponseDto productDto;
}
