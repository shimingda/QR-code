package com.dome.QRcode;

import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

/**
 * @author Simon
 * @create 2018-10-31 17:25
 * @desc
 **/
@Component
public class QRCodeService {
    String text = generateName();  //随机生成的12位验证码

    void createOfImage(File image){
        String inputStream2String=inputStream2String(image);
        BufferedImage bufferedImage=QRCodeUtil.createQRCode(inputStream2String);
        File file = new File("D:/QRcode/"+text+".png");
        try {
            ImageIO.write(bufferedImage,"png",file);
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 文本转化为二维码
     * @param Text
     */
    void createOfText(String Text){

        BufferedImage bufferedImage=QRCodeUtil.createQRCode(Text);
        File file = new File("D:/QRcode/"+text+".png");
        try {
            ImageIO.write(bufferedImage,"png",file);
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * http创建
     * @param http
     */
    void createOfHttp(String http){


        BufferedImage bufferedImage=QRCodeUtil.createQRCode(http);
        File file = new File("D:/QRcode/"+text+".png");
        try {
            ImageIO.write(bufferedImage,"png",file);
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static  String inputStream2String(File file){

        InputStream is = null;
        try {
            is = new FileInputStream(file);

        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line);
        }
        return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String generateName(){

        long date=System.currentTimeMillis();
        String name=String.valueOf(date);
        return name;
    }
    /**
     *
     * 随机生成指定长度的验证码
     *
     * @param length 验证码长度
     * @return 生成的验证码
     */
    public static String generateNumCode(int length) {
        String val = "";
        String charStr = "char";
        String numStr = "num";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? charStr : numStr;
            //输出字母还是数字
            if (charStr.equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if (numStr.equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }
}
