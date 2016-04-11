package test.freelancer.com.fltest.Events;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.TextHttpResponseHandler;

import org.greenrobot.eventbus.EventBus;

import cz.msebera.android.httpclient.Header;
import test.freelancer.com.fltest.Model.HandlerFinished;
import test.freelancer.com.fltest.Model.ProgramsResponse;

/**
 * Created by V15 on 11/04/2016.
 */
public class MyTextHttpResponseHandler extends TextHttpResponseHandler {
    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String response) {
        // If the response is JSONObject instead of expected JSONArray
            Gson gson = new GsonBuilder().create();
            ProgramsResponse res = gson.fromJson(response, ProgramsResponse.class);
            EventBus.getDefault().post(new HandlerFinished(res.results));
    }



}
