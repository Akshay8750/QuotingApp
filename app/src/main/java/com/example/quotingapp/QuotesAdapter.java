package com.example.quotingapp;





 import android.content.Context;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ImageView;
 import android.widget.TextView;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.viewpager.widget.PagerAdapter;
 import androidx.viewpager.widget.ViewPager;

 import java.util.List;


public class QuotesAdapter extends PagerAdapter {
 Context context;
 List<QuotesModel> quotesList;
 LayoutInflater inflater;

 public QuotesAdapter(Context context, List<QuotesModel> quoteslist) {
 this.context = context;
 this.quotesList = quoteslist;
 inflater=LayoutInflater.from(context);
 }

 @Override
 public int getCount() {
 return quotesList.size();
 }

 @Override
 public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
 return view == object;
 }

 @Override
 public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
 ((ViewPager)container).removeView((View)object);
 }

 @NonNull
 @Override
 public Object instantiateItem(@NonNull ViewGroup container, int position) {
 View view=inflater.inflate(R.layout.quotes_item,container,false); // give quotes layeot

 TextView quotes_title=(TextView) view.findViewById(R.id.tv_cat_name);
 TextView quotes=(TextView) view.findViewById(R.id.quote_tv);
 TextView author = (TextView) view.findViewById(R.id.author_name);



 quotes_title.setText(quotesList.get(position).getName());
 quotes.setText(quotesList.get(position).getDescription()); //quotes
 //set Title
 //set Author Name


 /*btn_fav.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
 Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show();
 }
 });*/


 container.addView(view);

 return view;

 }
 }