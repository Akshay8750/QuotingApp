package com.example.quotingapp;

import java.util.List;

public interface IFirebaseLoadDOne {
    void  onFirebaseLoadSuccess(List<QuotesModel>movieList);
    void  onFirebaseLoadFailed(String Message);

}
