package com.udacity.nanodegree.builditbigger;

import android.os.AsyncTask;

import com.udacity.nanodegree.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


public class FetchJokeTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;

    private Callback callback;

    public interface Callback{
        void onFinished(String result);
    }

    public FetchJokeTask(Callback callback){
        this.callback = callback;
    }


    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builtitbigger-149908.appspot.com/_ah/api/");
            // end options for devappserver
                myApiService = builder.build();
        }


        try {
            return myApiService.getJokeFromLib().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String result) {
        if(result != null){
            callback.onFinished(result);
        }
    }
}