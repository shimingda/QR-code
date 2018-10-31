package com.dome.QRcode;

/**
 * @author Simon
 * @create 2018-10-31 16:04
 * @desc
 **/
public class TestQRcode {
    public static void main(String[] args) {

        String text = QRCodeUtil.generateNumCode(12);  //随机生成的12位验证码
        System.out.println("随机生成的12位验证码为： " + text);
        int width = 100;    //二维码图片的宽
        int height = 100;   //二维码图片的高
        String format = "png";  //二维码图片的格式

        try {
            //生成二维码图片，并返回图片路径
            String pathName = QRCodeUtil.generateQRCode(text, width, height, format);
            System.out.println("生成二维码的图片路径： " + pathName);

            String content = QRCodeUtil.parseQRCode(pathName);
            System.out.println("解析出二维码的图片的内容为： " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
