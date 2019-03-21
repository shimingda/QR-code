package com.dome.image;
/**
 * @author Simon
 * @create 2019-03-05 15:46
 * @desc 图片加密
 * 按位异或操作
 **/
public class XorImageUtil {
    private static final int key = 0x99; //加密解密秘钥
    private static int dataOfFile = 0; //文件字节内容

    // 可逆的加密算法
    public static String operate(String inStr) {
        char[] a = inStr.toCharArray();
        for (int i = dataOfFile; i < a.length; i++) {
            a[i] = (char) (a[i] ^ key);
        }
        return new String(a);
    }

}
