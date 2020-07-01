package com.example.quotingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class QuotesActivity extends AppCompatActivity {
    ViewPager viewPager;
    QuotesAdapter adapter;
    DatabaseReference movies;
    IFirebaseLoadDOne iFirebaseLoadDOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);


    }
    private void loadMovie() {
        movies.addListenerForSingleValueEvent(new ValueEventListener() {
            List<Movie> movieList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot movieSnapShot:dataSnapshot.getChildren())
                    movieList.add(movieSnapShot.getValue(Movie.class));
                iFirebaseLoadDOne.onFirebaseLoadSuccess(movieList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadDOne.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });
    }

    public void onFirebaseLoadSuccess(List<QuotesModel> movieList) {
        adapter=new QuotesAdapter(this,movieList);
        viewPager.setAdapter(adapter);
    }

    public void onFirebaseLoadFailed(String Message) {
        Toast.makeText(this, ""+Message, Toast.LENGTH_SHORT).show();
    }
}
