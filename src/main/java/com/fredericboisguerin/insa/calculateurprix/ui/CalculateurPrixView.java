package com.fredericboisguerin.insa.calculateurprix.ui;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.*;

public class CalculateurPrixView extends JFrame {

    private  CalculateurPrixPresenter listener;

    private JTextField prixArticleTextField = new JTextField(10);

    private  JTextField quantiteArticleTextField = new JTextField(10);

    private  JFormattedTextField montantHTTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());


    public void setOrderAmountWithoutTax(BigDecimal orderAmountWithoutTax){
        montantHTTextField.setValue(orderAmountWithoutTax);
    }

    public CalculateurPrixView() throws HeadlessException {
        super("Calculateur de prix");


        JLabel prixArticleLabel = new JLabel("Prix d'un article (€) : ");
        prixArticleLabel.setLabelFor(prixArticleTextField);

        JLabel quantiteArticleLabel = new JLabel("Quantite d'articles : ");

        quantiteArticleLabel.setLabelFor(quantiteArticleTextField);
        prixArticleTextField.setToolTipText("Entrez ici la quantite d'article");

        JLabel montantHTLabel = new JLabel("Montant HT : ");

        montantHTTextField.setValue(15);
        montantHTTextField.setEditable(false);
        montantHTLabel.setLabelFor(montantHTTextField);

        JButton computeButton = new JButton("Calculer");
        computeButton.addActionListener(e -> onComputeButtonClicked());

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.add(prixArticleTextField);

        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(prixArticleLabel);
        labelPane.add(quantiteArticleLabel);
        labelPane.add(montantHTLabel);

        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(prixArticleTextField);
        fieldPane.add(quantiteArticleTextField);
        fieldPane.add(montantHTTextField);

        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, WEST);
        add(fieldPane, EAST);
        add(computeButton, SOUTH);

        prixArticleTextField.requestFocus();
        quantiteArticleTextField.requestFocus();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void afficherErreur(String message) {
        showMessageDialog(this, message, "Erreur", ERROR_MESSAGE);
    }
    
    public void onComputeButtonClicked(){
        String prixArticleAstext = prixArticleTextField.getText();
        String quantityAsText = quantiteArticleTextField.getText();
        listener.onComputeButtonClicked(prixArticleAstext,quantityAsText);
    }


    public void display() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void setListener(CalculateurPrixPresenter listener) {
        this.listener=listener;
    }
}
