package com.dome.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * 读取页面
 */
public class UploadPage {
    public static void main(String[] args)
            throws Exception {
        URI url = new URI("http://www.runoob.com");
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(url));
        BufferedWriter writer = new BufferedWriter
                (new FileWriter("data.html"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
