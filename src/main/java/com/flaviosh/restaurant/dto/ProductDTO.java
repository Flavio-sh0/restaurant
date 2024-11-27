package com.flaviosh.restaurant.dto;

import com.flaviosh.restaurant.enums.ProductType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    @NotBlank(message = "Name is a required property")
    private String name;

    @NotNull(message = "Price is a required property")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private BigDecimal price;

    @Size(max = 255, message = "Description should not exceed 255 characters")
    private String description;

    @NotNull(message = "Type is a required property")
    private ProductType type;

}
