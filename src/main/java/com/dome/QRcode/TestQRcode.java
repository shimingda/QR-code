package com.dome.QRcode;

/**
 * @author Simon
 * @create 2018-10-31 16:04
 * @desc
 **/
public class TestQRcode {

    public static void main(String[] args) {

    QRCodeService service=new QRCodeService();
    service.createOfHttp("https://blog.csdn.net/smd2575624555");
    }

}
