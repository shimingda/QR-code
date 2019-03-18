package com.dome.image;


import java.io.*;
import java.util.Base64;

/**
 * @author Simon
 * @create 2019-03-05 15:41
 * @desc base64图片加密
 **/
public class BASE64ImageUtil {
    /**
     * 加密
     * @param srcFile
     * @param encFile
     */
    public static void encryptImage(File srcFile,File encFile)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        byte[] encoder=null;
        OutputStream out=null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(srcFile);
            data = new byte[in.available()];
            in.read(data);
            encoder= Base64.getEncoder().encode(data);
            out=new FileOutputStream(encFile);
            out.write(encoder);
            out.flush();
            in.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 解密
     * @param srcFile
     * @param encFile
     */
    public static void decodeImage(File srcFile,File encFile)
    {
        InputStream in = null;
        byte[] data = null;
        byte[] decode=null;
        OutputStream out=null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(srcFile);
            data = new byte[in.available()];
            in.read(data);

            decode= Base64.getDecoder().decode(data);
            out=new FileOutputStream(encFile);
            out.write(decode);
            out.close();
            in.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
