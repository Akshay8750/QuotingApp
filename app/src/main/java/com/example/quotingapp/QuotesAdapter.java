package com.example.quotingapp;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

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
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final View view = inflater.inflate(R.layout.quotes_item, container, false);

        TextView quote = view.findViewById(R.id.quote_tv);
        TextView author = view.findViewById(R.id.author_name);
        view.findViewById(R.id.copyBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = quotesModelList.get(position).getQuotes();
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", s);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "text copy", Toast.LENGTH_SHORT).show();

            }
        });
        view.findViewById(R.id.share_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "choose an option...", Toast.LENGTH_SHORT).show();
                String s = quotesModelList.get(position).getQuotes();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Quoting Mantra");
                intent.putExtra(Intent.EXTRA_TEXT, s);
                context.startActivity(Intent.createChooser(intent, "Share to..."));
            }
        });


        quote.setText(quotesModelList.get(position).getQuotes());
        author.setText(quotesModelList.get(position).getAuthor());
        container.addView(view);
        return view;
    }
}