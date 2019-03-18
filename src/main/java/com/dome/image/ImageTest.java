package com.dome.image;

/**
 * @author Simon
 * @create 2019-03-05 15:03
 * @desc 测试图片加密工具
 **/
public class ImageTest {

/*
    	public static void main(String[] args) {

		File file = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\1.jpg");

		long start=System.currentTimeMillis();
		int i=0;
        while (i<1000){
            UUID uuid=    UUID.randomUUID();
            String path1="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\encrypt\\"+uuid.toString()+".jpg";
            System.out.println(path1);
	        AESImageUtil.encryptImage(file,path1);
	        i++;
            }
        long end=System.currentTimeMillis();
        System.out.println("==》加密使用时间："+(end-start));

        long start2=System.currentTimeMillis();
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\encrypt");
        File[] files= file2.listFiles();
            List<File> fileList= Arrays.asList(files);
            for (File f:fileList) {
                UUID uuid=    UUID.randomUUID();
                String path1="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\decode\\"+uuid.toString()+".jpg";
                System.out.println(path1);
                AESImageUtil.decodeImage(f,path1);
            }
            long end2=System.currentTimeMillis();
            System.out.println("==》解密使用时间："+(end2-start2));



	}*/
    /*
    public static void main(String[] args) {	File file = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\1.jpg");
        File srcFile = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\1.jpg");
        long start=System.currentTimeMillis();
        int i=0;
        while (i<1000){
            UUID uuid=    UUID.randomUUID();
            String path1="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\encrypt\\"+uuid.toString()+".jpg";

            File encFile = new File(path1);

            System.out.println(path1);
            BASE64ImageUtil.encryptImage(srcFile,encFile);

            i++;
        }
        long end=System.currentTimeMillis();


        long start2=System.currentTimeMillis();
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\encrypt");
        File[] files= file2.listFiles();
        List<File> fileList= Arrays.asList(files);
        for (File f:fileList) {
            UUID uuid=    UUID.randomUUID();
            String path1="C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\decode\\"+uuid.toString()+".jpg";
            System.out.println(path1);
            File decFile = new File(path1);
            BASE64ImageUtil.decodeImage(f,decFile);
        }
        long end2=System.currentTimeMillis();
        System.out.println("==》加密使用时间："+(end-start));
        System.out.println("==》解密使用时间："+(end2-start2));



    }*/
    /*
    public static void main(String[] args) {

        File srcFile = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\1.jpg"); //初始文件
        File encFile = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\101.jpg"); //加密文件
        File decFile = new File("C:\\Users\\Administrator\\Desktop\\文档\\image\\person\\201.jpg"); //解密文件

        try {
            XorImageUtil.operateFile(srcFile, encFile); //加密操作
            XorImageUtil.operateFile(encFile, decFile); //解密操作
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    /*
    public static void main(String[] args) {
        MD5ImageUtil.encryptImage(null,null);
    }*/
}
