package com.dome.concurrence.collection;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentMap接口是Map接口的子接口，支持底层Map变量上的原子操作。
 * 它具有获取和设置方法，如在变量上的读取和写入。
 * 也就是说，一个集合与同一变量上的任何后续读取相关联。
 * 该接口确保线程安全性和原子性保证。
 */
public class ConcurrentMapDome {
    public static void main(String[] args) {

            Map<String, String> map = new ConcurrentHashMap<String, String>();

            map.put("1", "One");
            map.put("2", "Two");
            map.put("3", "Three");
            map.put("5", "Five");
            map.put("6", "Six");

            System.out.println("Initial ConcurrentHashMap: " + map);
            Iterator<String> iterator = map.keySet().iterator();

            try {
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    if (key.equals("3")) {
                        map.put("4", "Four");
                    }
                }
            } catch (ConcurrentModificationException cme) {
                cme.printStackTrace();
            }
            System.out.println("ConcurrentHashMap after modification: " + map);

            map = new HashMap<String, String>();

            map.put("1", "One");
            map.put("2", "Two");
            map.put("3", "Three");
            map.put("5", "Five");
            map.put("6", "Six");

            System.out.println("Initial HashMap: " + map);

            try {
              map.forEach((k,v)-> System.out.print(k+":"+v  +"  "));
                System.out.println("HashMap after modification: " + map);
            } catch (ConcurrentModificationException cme) {
                cme.printStackTrace();
            }
        }
    }
