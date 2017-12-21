package com.fredericboisguerin.insa.calculateurprix.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountCalculator {

    public BigDecimal calculateTotal(BigDecimal articlePrice, int quantity){
        return roundValueOf(totalAmountWithoutTax(articlePrice,quantity));
    }

    private BigDecimal roundValueOf(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_EVEN);
    }

    private BigDecimal totalAmountWithoutTax(BigDecimal articlePrice, int quantity) {
        return articlePrice.multiply(new BigDecimal(quantity));
    }

}
