package com.dome.concurrence.collection;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentNavigableMap接口是ConcurrentMap接口的子接口，并且支持NavigableMap操作，并且对其可导航子映射和近似匹配进行递归。
 */
public class ConcurrentNavigableMapDome {
    public static void main(String[] args) {

        ConcurrentNavigableMap<String,String> map = new ConcurrentSkipListMap<String, String>();

        map.put("1", "One");
        map.put("2", "Two");
        map.put("3", "Three");
        map.put("5", "Five");
        map.put("6", "Six");

        System.out.println("Initial ConcurrentHashMap: "+map);
        System.out.println("HeadMap(\"2\") of ConcurrentHashMap: "+map.headMap("2"));
        System.out.println("TailMap(\"2\") of ConcurrentHashMap: "+map.tailMap("2"));
        System.out.println("SubMap(\"2\", \"4\") of ConcurrentHashMap: "+map.subMap("2","4"));
    }
}