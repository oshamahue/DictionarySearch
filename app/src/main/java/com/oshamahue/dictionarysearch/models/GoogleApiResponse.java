package com.oshamahue.dictionarysearch.models;

/**
 * Created by Hadi on 12/3/2014.
 */

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class GoogleApiResponse {

    @Expose
    private String kind;
    @Expose
    private Url url;
    @Expose
    private Context context;
    @Expose
    private SearchInformation searchInformation;
    @Expose
    private List<Item> items = new ArrayList<Item>();

    /**
     * @return The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return The url
     */
    public Url getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(Url url) {
        this.url = url;
    }

    /**
     * @return The context
     */
    public Context getContext() {
        return context;
    }

    /**
     * @param context The context
     */
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * @return The searchInformation
     */
    public SearchInformation getSearchInformation() {
        return searchInformation;
    }

    /**
     * @param searchInformation The searchInformation
     */
    public void setSearchInformation(SearchInformation searchInformation) {
        this.searchInformation = searchInformation;
    }

    /**
     * @return The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }
}