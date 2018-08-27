package com.dome.httpClient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class _5_Delete {
    public static void main(String... args) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete("http://httpbin.org/delete");

            System.out.println("Executing request " + httpDelete.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = HttpUtils.createResponse();
            String responseBody = httpclient.execute(httpDelete, responseHandler);

            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}