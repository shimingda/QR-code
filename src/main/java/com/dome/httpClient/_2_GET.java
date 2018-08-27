package com.dome.httpClient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * Http GET请求
 */
public class _2_GET {
    public static void main(String[] args) throws IOException {
        try {
            HttpGet httpget = new HttpGet("http://httpbin.org/get");
            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler =HttpUtils.createResponse();

            System.out.println(responseHandler);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            String responseBody = httpclient.execute(httpget, responseHandler);

            System.out.println("----------------------------------------");
            System.out.println(responseBody);

        }catch (Exception e){

        }
    }
}
