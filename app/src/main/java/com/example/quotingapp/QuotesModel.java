package com.example.quotingapp;

public class QuotesModel {
    private String Quotes;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Description;
    private String Name;

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
