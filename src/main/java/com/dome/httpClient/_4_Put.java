package com.dome.httpClient;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * put请求
 */
public class _4_Put {
    public static void main(String... args) throws IOException {

            HttpPut httpPut = new HttpPut("http://httpbin.org/put");
            httpPut.setEntity(new StringEntity("Hello, World"));

            System.out.println("Executing request " + httpPut.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = HttpUtils.createResponse();

            CloseableHttpClient httpclient = HttpClients.createDefault();
            String responseBody = httpclient.execute(httpPut, responseHandler);

            System.out.println("----------------------------------------");
            System.out.println(responseBody);

    }
}
