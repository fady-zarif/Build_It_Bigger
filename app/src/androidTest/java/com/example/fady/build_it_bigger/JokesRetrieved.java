package com.example.fady.build_it_bigger;

import android.os.Looper;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Fady on 2017-07-12.
 */
@RunWith(AndroidJUnit4.class)
public class JokesRetrieved {
    @Test
    public void getMyJoke() throws Exception {
        try {
            Looper.prepare();
            MainActivity mainActivity = new MainActivity();
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(mainActivity);
            endpointsAsyncTask.execute();
            String joke = endpointsAsyncTask.get(50, TimeUnit.SECONDS);
            assertNotNull(joke);
        } catch (Exception e) {
            Log.e("Exception", e.getLocalizedMessage());
        }
    }
}