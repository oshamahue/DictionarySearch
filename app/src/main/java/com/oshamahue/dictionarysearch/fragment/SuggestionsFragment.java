package com.oshamahue.dictionarysearch.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.oshamahue.dictionarysearch.R;
import com.oshamahue.dictionarysearch.SearchResultsActivity;
import com.oshamahue.dictionarysearch.adapter.SuggestionsListAdapter;

import java.util.ArrayList;


public class SuggestionsFragment extends Fragment {
    private ListView listView;
    private EditText editText;


    public SuggestionsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_suggestions, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        editText = (EditText) view.findViewById(R.id.editText);
        final SuggestionsListAdapter adapter = new SuggestionsListAdapter(getActivity(), android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(adapter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), SearchResultsActivity.class);
                intent.putExtra(SearchResultsActivity.QUERY_KEY, adapter.getResultList().get(position));
                startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
