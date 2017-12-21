package com.fredericboisguerin.insa.calculateurprix.core;

import com.fredericboisguerin.insa.calculateurprix.model.Country;

import static java.math.BigDecimal.ONE;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class AmountCalculator {

    public BigDecimal calculateTotal(BigDecimal articlePrice, int quantity){
        return roundValueOf(totalAmountWithoutTax(articlePrice,quantity));
    }

    public BigDecimal calculateTotalWithTax(BigDecimal articlePrice,int quantity,Country country){
        return roundValueOf(totalAmountWithTax(totalAmountWithoutTax(articlePrice,quantity),country.getTaxRate()));
    }

    private BigDecimal roundValueOf(BigDecimal amount) {
        return amount.setScale(2, RoundingMode.HALF_EVEN);
    }

    private static BigDecimal totalAmountWithoutTax(BigDecimal articlePrice, int quantity) {
        return articlePrice.multiply(new BigDecimal(quantity));
    }

    private static BigDecimal totalAmountWithTax(BigDecimal amountWithoutTax, double taxRate){
        BigDecimal bigDecimalTaxrate = BigDecimal.valueOf(taxRate);
        return amountWithoutTax.multiply(ONE.add(bigDecimalTaxrate));
    }



}
