package com.oshamahue.dictionarysearch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oshamahue.dictionarysearch.R;
import com.oshamahue.dictionarysearch.models.Item;

import java.util.List;

/**
 * Created by Hadi on 12/3/2014.
 */
public class SearchResultsAdapter extends ArrayAdapter<Item> {
    private final List<Item> items;
    LayoutInflater inflater;

    public SearchResultsAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
        this.items = objects;
        inflater =LayoutInflater.from(context);
    }

    class ViewHolder {
        TextView titleTv;
        TextView urlTv;
        TextView snippetTv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView =inflater.inflate(R.layout.search_result_item,null);
            holder= new ViewHolder();
            holder.snippetTv = (TextView) convertView.findViewById(R.id.snippetTv);
            holder.urlTv = (TextView) convertView.findViewById(R.id.urlTv);
            holder.titleTv = (TextView) convertView.findViewById(R.id.titleTv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Item item = items.get(position);
        holder.titleTv.setText(item.getTitle());
        holder.urlTv.setText(item.getDisplayLink());
        holder.snippetTv.setText(item.getSnippet());

        return convertView;
    }
}
