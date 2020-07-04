package com.example.quotingapp;

public class QuotesModel {
    private String Quotes;

    public QuotesModel() {
    }

    public QuotesModel(String quotes) {
        Quotes = quotes;
    }

    public String getQuotes() {
        return Quotes;
    }

    public void setQuotes(String quotes) {
        Quotes = quotes;
    }
}
