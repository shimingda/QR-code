package com.dome.data.structure.linked;

import java.util.LinkedList;

/**
 * 链表
 */
public class Linked {

    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        /*
        添加
         */
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list);
        list.addFirst("0");
        System.out.println(list);
        list.addLast("6");
        System.out.println(list);
    /*
    删除
     */
        list.remove(2);
        System.out.println(list);
        list.remove("0");
        System.out.println(list);
        list.clear();
        System.out.println(list);
        /*
        查找
         */
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.peek());
        /*
         * 添加
         */
        list.push("6");
        System.out.println(list);
        /**
         * 去除
         */
        System.out.println(list.poll());
        System.out.println(list);

    }
}
