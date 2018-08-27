package com.dome.httpClient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class _3_POST {
    public static void main(String... args) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://httpbin.org/post");
            httpPost.setEntity(new StringEntity("Hello, World"));

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler=HttpUtils.createResponse();
            String responseBody = httpclient.execute(httpPost, responseHandler);

            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}
