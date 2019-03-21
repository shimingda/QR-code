package com.dome.image;

import java.io.File;
import java.security.MessageDigest;

/**
 * @author Simon
 * @create 2019-03-05 17:19
 * @desc MD5图片加密
 **/
public class MD5ImageUtil {
    public static void encryptImage(File file, String path) {

        System.out.println("MD5加密解密");
        String s = new String("123asdfghjkl");
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + MD5(s));
        System.out.println("MD5后再加密：" + XorImageUtil.operate(MD5(s)));
        System.out.println("解密为MD5后的：" + XorImageUtil.operate(XorImageUtil.operate(MD5(s))));

    }

    public static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }



}
