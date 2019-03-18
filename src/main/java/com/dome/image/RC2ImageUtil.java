package com.dome.image;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author Simon
 * @create 2019-03-06 10:57
 * @desc 传统对称分组加密算法，它可作为DES算法的建议替代算法。它的输入和输出都是64比特。密钥的长度是从1字节到128字节可变，但目前的实现是8字节（1998年）
 **/
public class RC2ImageUtil {
    //KeyGenerator 提供对称密钥生成器的功能，支持各种算法
    private KeyGenerator keygen;
    //SecretKey 负责保存对称密钥
    private SecretKey deskey;
    //Cipher负责完成加密或解密工作
    private Cipher c;
    //该字节数组负责保存加密的结果
    private byte[] cipherByte;

    public RC2ImageUtil() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
        keygen = KeyGenerator.getInstance("RC2");
        //生成密钥
        deskey = keygen.generateKey();
        //生成Cipher对象,指定其支持的DES算法
        c = Cipher.getInstance("RC2");
    }

    /**
     * 对字符串加密
     *
     * @param str
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public byte[] Encrytor(String str) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
        c.init(Cipher.ENCRYPT_MODE, deskey);
        byte[] src = str.getBytes();
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
     * @throws InvalidKeyException
     */
    public static void main(String[] args) throws Exception {
        RC2ImageUtil de1 = new RC2ImageUtil();
        String msg ="郭XX-搞笑相声全集";
        byte[] encontent = de1.Encrytor(msg);
        byte[] decontent = de1.Decryptor(encontent);
        System.out.println("明文是:" + msg);
        System.out.println("加密后:" + new String(encontent));
        System.out.println("解密后:" + new String(decontent));
    }

}
