package com.oshamahue.dictionarysearch.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.oshamahue.dictionarysearch.R;
import com.oshamahue.dictionarysearch.SearchResultsActivity;
import com.oshamahue.dictionarysearch.adapter.SearchResultsAdapter;
import com.oshamahue.dictionarysearch.models.GoogleApiResponse;
import com.oshamahue.dictionarysearch.request.GoogleApiRequest;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class SearchResultsFragment extends Fragment {
    private ListView listView;
    private String query;


    public SearchResultsFragment() {
        // Required empty public constructor
    }

    public static SearchResultsFragment getInstance(String query) {
        SearchResultsFragment fragment = new SearchResultsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SearchResultsActivity.QUERY_KEY, query);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        query = getArguments().getString(SearchResultsActivity.QUERY_KEY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_search_results, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        displayResults();
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    void displayResults() {
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addQueryParam("key", getString(R.string.googleApiKey));
                request.addQueryParam("cx", getString(R.string.googleCustomSearchKey));
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://www.googleapis.com")
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();


        final GoogleApiRequest googleApiRequest = restAdapter.create(GoogleApiRequest.class);
        googleApiRequest.search(query, new Callback<GoogleApiResponse>() {
            @Override
            public void success(final GoogleApiResponse googleApiResponse, Response response) {
                listView.setAdapter(new SearchResultsAdapter(getActivity(), 0, googleApiResponse.getItems()));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(googleApiResponse.getItems().get(position).getLink()));
                        startActivity(i);
                    }
                });
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ResultsActivity", "error on api request", error);
            }
        });

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
