package com.company.ecommerce.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {
    Long id;
    String name;
}
