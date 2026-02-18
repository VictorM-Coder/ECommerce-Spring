package coder.victor.ecommercespring.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductTest {
    @Test
    @DisplayName("Test product price should not be null")
    void productPriceShouldNotBeNull() {
        Product product = new Product();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> product.setPrice(null)
        );
    }

    @Test
    @DisplayName("Test product price shoud not be negative")
    void productPriceShouldNotBeNegative() {
        Product product =  new Product();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> product.setPrice(BigDecimal.valueOf(-1))
        );
    }

}
