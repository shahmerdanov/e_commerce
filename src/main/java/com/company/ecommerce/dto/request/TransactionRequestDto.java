package com.company.ecommerce.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionRequestDto {
    Long customerId;
    Long productId;
    BigDecimal amount;
}
