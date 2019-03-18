package com.dome.image;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Simon
 * @create 2019-03-05 15:46
 * @desc 图片加密
 * 按位异或操作
 **/
public class XorImageUtil {
    private static final int key = 0x99; //加密解密秘钥
    private static int dataOfFile = 0; //文件字节内容


    public static void operateFile(File srcFile, File encFile) throws Exception {

        InputStream fis  = new FileInputStream(srcFile);
        OutputStream fos = new FileOutputStream(encFile);

        while ((dataOfFile = fis.read()) > -1) {
            fos.write(dataOfFile^key);
        }

        fis.close();
        fos.flush();
        fos.close();
    }

}
