package com.dome.image;

import com.dome.image.tool.ImageFileUtil;
import sun.misc.BASE64Decoder;
import sun.security.tools.keytool.CertAndKeyGen;

import javax.crypto.*;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


/**
 * @author Simon
 * @create 2019-03-05 15:02
 * @desc AES图片工具
 *  加密方式，把文件转化为byte数组，将key放到数组最前面，再将数组每一位数加一
 **/
public class AESImageUtil {
    //KeyGenerator 提供对称密钥生成器的功能，支持各种算法
    private KeyGenerator keygen;
    //SecretKey 负责保存对称密钥
    private SecretKey deskey;
    //Cipher负责完成加密或解密工作
    private Cipher c;
    //该字节数组负责保存加密的结果
    private byte[] cipherByte;

    String key = "79F4C976E54645EEA7DA0F57E89A3272";

    public AESImageUtil() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        keygen = KeyGenerator.getInstance("AES");

        SecureRandom secureRandom = new SecureRandom(key.getBytes());
        keygen.init(128,secureRandom);
        //生成密钥
        deskey = keygen.generateKey();
        //生成Cipher对象,指定其支持的DES算法
        c = Cipher.getInstance("AES");
    }
    public static byte[] decryptBase64(String key)  {
        try {
            return (new BASE64Decoder()).decodeBuffer(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
    return null;
    }
    /**
     * 对字符串加密
     *

     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Encrytor(byte[] src) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        c.init(Cipher.ENCRYPT_MODE, deskey);
        // 加密，结果保存进cipherByte
        cipherByte = c.doFinal(src);
        return cipherByte;
    }

    /**
     * 对字符串解密
     *
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Decryptor(byte[] buff) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
        c.init(Cipher.DECRYPT_MODE, deskey);

        cipherByte = c.doFinal(buff);
        return cipherByte;
    }

    /**
     * @param args
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws java.security.InvalidKeyException
     */
    public static void main(String[] args) throws Exception {

        CertAndKeyGen keypair = new CertAndKeyGen("RSA", "SHA1WithRSA", null);
        AESImageUtil de1 = new AESImageUtil();

        File srcFile = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\1.jpg"); //初始文件

        byte[] src=ImageFileUtil.readFile(srcFile);
        byte[] encontent = de1.Encrytor(src);
        long start=System.currentTimeMillis();
        for (int i=0;i<10000;i++){
        UUID uuid=    UUID.randomUUID();
        String path1="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\encrypt\\"+uuid.toString()+".jpg";
        File encFile = new File(path1);
        ImageFileUtil.writeFile(encFile,encontent);
        }
        long end=System.currentTimeMillis();

//        byte[] decontent = de1.Decryptor(encontent);

        long start2=System.currentTimeMillis();
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\encrypt");
        File[] files= file2.listFiles();
        List<File> fileList= Arrays.asList(files);
        for (File f:fileList) {
            UUID uuid=    UUID.randomUUID();
            String path1="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\decode\\"+uuid.toString()+".jpg";
            byte[] readFile=ImageFileUtil.readFile(f);
            byte[] decontent = de1.Decryptor(readFile);
            File decFile = new File(path1);
            ImageFileUtil.writeFile(decFile,decontent);
        }
        long end2=System.currentTimeMillis();
        System.out.println("==》加密使用时间："+(end-start));
        System.out.println("==》解密使用时间："+(end2-start2));

        for (File f:fileList) {
            f.delete();
        }
        String path3="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\decode";
        File file3= new File(path3);
        File[] files3= file3.listFiles();
        List<File> fileList3= Arrays.asList(files3);
        for (File f:fileList3) {
            f.delete();
        }
    }

}

