package com.example.quotingapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;


public class QuotesAdapter extends PagerAdapter {

    Context context;
    List<QuotesModel> quotesModelList;
    LayoutInflater inflater;

    public QuotesAdapter(Context context, List<QuotesModel> quotesModelList) {
        this.context = context;
        this.quotesModelList = quotesModelList;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return quotesModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.quotes_item, container, false);

        TextView quote = view.findViewById(R.id.quote_tv);
        quote.setText(quotesModelList.get(position).getQuotes());
        container.addView(view);
        return view;
    }
}