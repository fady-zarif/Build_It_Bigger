package com.example.fady.build_it_bigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.fady.build_it_bigger.backend.myApi.MyApi;
import com.example.viewjokes.DisplayJokes;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Fady on 2017-07-12.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressDialog progressDialog;

    public EndpointsAsyncTask(Context context) {
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        try {
            progressDialog = ProgressDialog.show(context, "Loading...", null, true, false);
        } catch (Exception e) {
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }


        try {
            String joke = myApiService.jokes().execute().getData();
            return joke;

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        try {
            progressDialog.dismiss();
            Intent intent = new Intent(context, DisplayJokes.class);
            intent.putExtra("MyJoke", result);
            context.startActivity(intent);
        } catch (Exception e) {
        }
    }
}