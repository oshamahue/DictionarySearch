package com.oshamahue.dictionarysearch;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.oshamahue.dictionarysearch.fragment.SearchResultsFragment;


public class SearchResultsActivity extends ActionBarActivity {
    public static final String QUERY_KEY = "QUERY";
    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle;
        if (savedInstanceState == null) {
            bundle = getIntent().getExtras();
        } else {
            bundle = savedInstanceState;
        }
        query = bundle.getString(QUERY_KEY);
        setTitle(query);
        SearchResultsFragment searchResultsFragment = SearchResultsFragment.getInstance(query);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, searchResultsFragment)
                    .commit();
        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(QUERY_KEY, query);

    }
}
