package com.dome.image.tool;

import java.io.*;

/**
 * @author Simon
 * @create 2005-05-01 16:41
 * @desc 文件输出
 **/
public class ImageFileUtil {
    public static void writeFile( File encFile,byte[] data) throws Exception {

        if(!encFile.exists()){
            System.out.println("encrypt file created");
            encFile.createNewFile();
        }

        OutputStream fos = new FileOutputStream(encFile);
        fos.write(data);
        fos.flush();
        fos.close();
    }
    public static byte[] readFile( File srcFile ) throws Exception {

        InputStream in = new FileInputStream(srcFile);
        byte[] data = new byte[in.available()];
        in.read(data);
        in.close();
        return data;
    }

}
