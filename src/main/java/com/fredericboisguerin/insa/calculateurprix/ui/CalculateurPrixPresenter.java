package com.fredericboisguerin.insa.calculateurprix.ui;

import com.fredericboisguerin.insa.calculateurprix.core.AmountCalculator;
import com.fredericboisguerin.insa.calculateurprix.model.Country;
import com.fredericboisguerin.insa.calculateurprix.ui.converter.UserInputConverter;

import javax.swing.text.View;
import java.math.BigDecimal;

public class CalculateurPrixPresenter {
    private final CalculateurPrixView view;
    private final AmountCalculator amountCalculator;
    private final  UserInputConverter converter;

    public CalculateurPrixPresenter(CalculateurPrixView view,AmountCalculator amountCalculator, UserInputConverter converter) {
        this.view = view;
        this.amountCalculator = amountCalculator;
        this.converter = converter;
    }

    public void onComputeButtonClicked(String montantArticleAsText,String quantiteArticleAsText,Country country) {
        BigDecimal articlePrice = converter.convertToBigDecimal(montantArticleAsText);
        Integer quantity =  converter.convertToQuantity(quantiteArticleAsText);
        setAmountsInView(country, articlePrice,quantity);


    }

    private void setAmountsInView(Country country ,BigDecimal articlePrice, Integer quantity) {
        setTotalAmountWithoutTax(articlePrice,quantity);
        setTotalAmountWithTax(articlePrice,quantity,country);
    }

    private void setTotalAmountWithoutTax(BigDecimal articlePrice, Integer quantity) {
        BigDecimal totalWithoutTax=amountCalculator.calculateTotal(articlePrice,quantity);
        view.setOrderAmountWithoutTax(totalWithoutTax);
    }

    private void setTotalAmountWithTax(BigDecimal articlePrice, Integer quantity, Country country){
        BigDecimal totalWithTax = amountCalculator.calculateTotalWithTax(articlePrice,quantity,country);
        view.setOrderAmountWithTax(totalWithTax);
    }
}
