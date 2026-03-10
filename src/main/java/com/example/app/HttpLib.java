package com.example.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpLib implements IHttpLib {

    @Override
    public Response call(String url) throws Exception {
        URL urlObj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        con.setRequestMethod("GET");

        int code = con.getResponseCode();

        if (code != 200) {
            return new Response(code, null);
        } else {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );
            String data = reader.readLine();
            reader.close();
            return new Response(code, data);
        }
    }
}