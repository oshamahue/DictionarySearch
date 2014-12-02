package com.oshamahue.dictionarysearch.models;

/**
 * Created by Hadi on 12/3/2014.
 */

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Pagemap {

    @Expose
    private List<Article> article = new ArrayList<Article>();
    @Expose
    private List<Metatag> metatags = new ArrayList<Metatag>();

    /**
     * @return The article
     */
    public List<Article> getArticle() {
        return article;
    }

    /**
     * @param article The article
     */
    public void setArticle(List<Article> article) {
        this.article = article;
    }

    /**
     * @return The metatags
     */
    public List<Metatag> getMetatags() {
        return metatags;
    }

    /**
     * @param metatags The metatags
     */
    public void setMetatags(List<Metatag> metatags) {
        this.metatags = metatags;
    }

}