package com.fredericboisguerin.insa.calculateurprix.ui.converter;

import java.math.BigDecimal;

public class UserInputConverter {

    public BigDecimal convertToBigDecimal(String amountPerarticle) {
        return new BigDecimal(amountPerarticle);
    }

    public int convertToQuantity(String quantityAsText){
        return Integer.valueOf(quantityAsText);
    }
}
