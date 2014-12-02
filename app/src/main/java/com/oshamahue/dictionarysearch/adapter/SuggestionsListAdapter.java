package com.oshamahue.dictionarysearch.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Hadi on 11/30/2014.
 */
public class SuggestionsListAdapter extends ArrayAdapter<String> implements Filterable {
    List<String> resultList = new ArrayList<String>();
    Filter filter;
    List<String> dictionary;

    public List<String> getResultList() {
        return resultList;
    }

    public SuggestionsListAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public String getItem(int index) {
        return resultList.get(index);
    }

    @Override
    public Filter getFilter() {
        if (filter != null) {
            return filter;
        }
        filter = new Filter() {
            RandomAccessFile file;

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filterString = constraint.toString().toLowerCase();
                FilterResults results = new FilterResults();
                if (filterString.isEmpty()) {
                    results = null;
                    resultList.clear();
                    return results;
                }
                resultList = search(filterString);
                results.count = resultList.size();
                results.values = resultList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null ) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return filter;
    }

    List<String> search(String query) {
        return search(query.toLowerCase(Locale.ENGLISH), 0, getDictionary().size() - 1);


    }

    List<String> search(String query, int startIndex, int endIndex) {
        List<String> results = new ArrayList<String>();
        if (endIndex < startIndex) {
            return results;
        }
        int midIndex = (startIndex + endIndex) / 2;
        final String midString = getDictionary().get(midIndex).toLowerCase(Locale.ENGLISH);
        if (midString.startsWith(query)) {
            while (getDictionary().get(midIndex - 1).toLowerCase().startsWith(query)) {
                midIndex--;
            }
            for (int i = 0; i < 100; i++) {
                if (getDictionary().get(midIndex + i).toLowerCase().startsWith(query)) {
                    results.add(getDictionary().get(midIndex + i));
                }
            }
            return results;
        } else if (midString.compareTo(query) > 0) {
            return search(query, startIndex, midIndex - 1);
        } else if (midString.compareTo(query) < 0) {
            return search(query, midIndex + 1, endIndex);
        }
        return results;
    }



    List<String> getDictionary() {
        if (dictionary != null) {
            return dictionary;
        }
        dictionary = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getContext().getAssets().open("british-english-insane")));

            // do reading, usually loop until end of file reading
            String mLine = reader.readLine();
            while (mLine != null) {
                mLine = reader.readLine();
                dictionary.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return dictionary;
    }

}
