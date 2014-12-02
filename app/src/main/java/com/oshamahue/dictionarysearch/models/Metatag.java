package com.oshamahue.dictionarysearch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metatag {

    @SerializedName("fb:app_id")
    @Expose
    private String fbAppId;
    @SerializedName("og:type")
    @Expose
    private String ogType;
    @SerializedName("og:title")
    @Expose
    private String ogTitle;
    @SerializedName("og:description")
    @Expose
    private String ogDescription;
    @Expose
    private String rating;
    @Expose
    private String distribution;
    @Expose
    private String copyright;
    @SerializedName("fb:admins")
    @Expose
    private String fbAdmins;

    /**
     *
     * @return
     * The fbAppId
     */
    public String getFbAppId() {
        return fbAppId;
    }

    /**
     *
     * @param fbAppId
     * The fb:app_id
     */
    public void setFbAppId(String fbAppId) {
        this.fbAppId = fbAppId;
    }

    /**
     *
     * @return
     * The ogType
     */
    public String getOgType() {
        return ogType;
    }

    /**
     *
     * @param ogType
     * The og:type
     */
    public void setOgType(String ogType) {
        this.ogType = ogType;
    }

    /**
     *
     * @return
     * The ogTitle
     */
    public String getOgTitle() {
        return ogTitle;
    }

    /**
     *
     * @param ogTitle
     * The og:title
     */
    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    /**
     *
     * @return
     * The ogDescription
     */
    public String getOgDescription() {
        return ogDescription;
    }

    /**
     *
     * @param ogDescription
     * The og:description
     */
    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    /**
     *
     * @return
     * The rating
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The distribution
     */
    public String getDistribution() {
        return distribution;
    }

    /**
     *
     * @param distribution
     * The distribution
     */
    public void setDistribution(String distribution) {
        this.distribution = distribution;
    }

    /**
     *
     * @return
     * The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     *
     * @param copyright
     * The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     *
     * @return
     * The fbAdmins
     */
    public String getFbAdmins() {
        return fbAdmins;
    }

    /**
     *
     * @param fbAdmins
     * The fb:admins
     */
    public void setFbAdmins(String fbAdmins) {
        this.fbAdmins = fbAdmins;
    }

}
