package com.oshamahue.dictionarysearch.models;

import com.google.gson.annotations.Expose;

public class Article {

    @Expose
    private String name;
    @Expose
    private String datepublished;
    @Expose
    private String author;

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The datepublished
     */
    public String getDatepublished() {
        return datepublished;
    }

    /**
     * @param datepublished The datepublished
     */
    public void setDatepublished(String datepublished) {
        this.datepublished = datepublished;
    }

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

}