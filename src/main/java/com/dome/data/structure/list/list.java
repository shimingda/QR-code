package com.dome.data.structure.list;

import java.util.Arrays;
import java.util.List;

/**
 * list
 */
public class list {
    public static void main(String args[]){
        int n = 5;         // 5 个元素
        String[] name = new String[n];
        for(int i = 0; i < n; i++){
            name[i] = String.valueOf(i);
        }
        List<String> list = Arrays.asList(name);
        System.out.println();
        for(String li: list){
            String str = li;
            System.out.print(str + " ");
        }
    }
}
