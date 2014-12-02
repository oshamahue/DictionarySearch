package com.oshamahue.dictionarysearch.request;

import com.oshamahue.dictionarysearch.models.GoogleApiResponse;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Hadi on 12/2/2014.
 */
public interface GoogleApiRequest {
    @GET("/customsearch/v1")
    void search(@Query("q") String query, Callback<GoogleApiResponse> googleApiResponse);
}
