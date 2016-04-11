package test.freelancer.com.fltest.HttpClient;

/**
 * Created by V15 on 11/04/2016.
 */

import com.loopj.android.http.*;
public class JsonHttpClient {
    private static final String BASE_URL = "https://whatsbeef.net/wabz/guide.php";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
