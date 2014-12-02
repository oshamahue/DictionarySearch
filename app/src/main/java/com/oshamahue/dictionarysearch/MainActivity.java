package com.oshamahue.dictionarysearch;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.oshamahue.dictionarysearch.fragment.SuggestionsFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new SuggestionsFragment())
                    .commit();
        }
    }



}
