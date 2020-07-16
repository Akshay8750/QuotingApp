package com.kavara.quotingapp;

import java.util.List;

public interface IFirebaseLoadDone {

    void onFirebaseLoadSuccess(List<QuotesModel> quotesModelList);

    void onFirebaseLoadFailed(String message);
}
