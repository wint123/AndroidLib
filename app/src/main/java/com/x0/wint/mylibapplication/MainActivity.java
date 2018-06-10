package com.x0.wint.mylibapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.x0.wint.mylibrary.DataStorage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String PREFERENCES_NAME = "TEST_STORAGE";
    String DATA_KEY = "WORDS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //DataStorage
        ArrayList<String> words = new ArrayList<>();
        for (int i=4;i<14;i++){
            words.add(Integer.toString(i));
        }

        DataStorage<ArrayList<String>> dataStorage = new DataStorage<>(this, PREFERENCES_NAME, words);
        dataStorage.deleteData(DATA_KEY);
        dataStorage.storeData(DATA_KEY);
        ArrayList<String> words2 = dataStorage.loadData(DATA_KEY);
        for (String word: words2) {
            Log.d("WORD", word);
        }

        //contain
        /*for(int i=0;i<15;i++){
            Log.d("BOOLEAN", Boolean.toString(dataListStorage.contain(PREFERENCES_NAME, DATA_KEY, Integer.toString(i))));
        }*/
    }

}
