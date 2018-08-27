//package com.dome.httpClient;
//
//
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.springframework.cache.annotation.CacheConfig;
//
//import java.io.IOException;
//
///**
// * 配置请求缓存
// */
//public class _6_缓存 {
//    public static void main(String... args) throws IOException {
//
//        CacheConfig cacheConfig = CacheConfig.custom()
//                .setMaxCacheEntries(3000)
//                .setMaxObjectSize(10240) // 10MB
//                .build();
//
//        CloseableHttpClient cachingClient = CachingHttpClients.custom()
//                .setCacheConfig(cacheConfig)
//                .build();
//
//        for (int i = 0; i < 3; i++){
//            HttpCacheContext context = HttpCacheContext.create();
//            HttpGet httpget = new HttpGet("http://httpbin.org/cache");
//            System.out.println("Executing request " + httpget.getRequestLine());
//            CloseableHttpResponse response = cachingClient.execute(httpget, context);
//            try {
//                System.out.println("----------------------------------------");
//                CacheResponseStatus responseStatus = context.getCacheResponseStatus();
//                switch (responseStatus) {
//                    case CACHE_HIT:
//                        System.out.println("A response was generated from the cache with " +
//                                "no requests sent upstream");
//                        break;
//                    case CACHE_MODULE_RESPONSE:
//                        System.out.println("The response was generated directly by the " +
//                                "caching module");
//                        break;
//                    case CACHE_MISS:
//                        System.out.println("The response came from an upstream server");
//                        break;
//                    case VALIDATED:
//                        System.out.println("The response was generated from the cache " +
//                                "after validating the entry with the origin server");
//                        break;
//                }
//            } finally {
//                response.close();
//            }
//        }
//    }
//
//}