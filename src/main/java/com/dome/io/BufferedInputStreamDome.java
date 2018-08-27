package com.dome.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Java.io.BufferedInputStream 类添加功能到另一个输入流，缓冲输入以及支持mark和reset methods.Following是关于缓冲输入流的要点：
 * 当创建缓冲输入，创建一个内部缓冲区数组。
 * 如从该流的字节被读出或跳过，内部缓冲器被再从包含的输入流，许多字节一次必要的。
 *
 * 类的声明
 * 以下是java.io.BufferedInputStream类的声明：
 * public class BufferedInputStream  extends FilterInputStream
 *
 * 字段域
 * 以下是java.io.BufferedInputStream类中的字段：
 * protected byte[] buf -- 这是其中数据存储在内部缓冲器阵列。
 * protected int count -- 这是该指数1大于在缓冲器中的最后一个有效字节的索引。
 * protected int marklimit -- 这是预读之前，后续调用reset方法失败调用mark方法后允许的最大值。
 * protected int markpos -- 这是pos区域在最后标记方法被调用时的值。
 * protected int pos -- 这是在缓冲器中的当前位置。
 * protected InputStream in -- 这是将进行过滤的输入流。
 *
 * 类构造函数
 * S.N.	构造函数 & 描述
 * 1	BufferedInputStream(InputStream in)  这将创建一个缓冲输入并保存其参数在输入流中，以备后用。
 * 2	BufferedInputStream(InputStream in, int size)  这将创建具有指定缓冲区大小的一个缓冲输入流，并保存其参数在输入流中，以备后用。
 *
 * 类方法
 * S.N.	方法 & 描述
 * 1	int available()  此方法从这个输入流中可通过一个方法的下一次调用阻塞该输入流返回可以读取（或跳过）的字节数的估计值。
 * 2	void close()  此方法关闭此输入流并释放与该流关联的所有系统资源。
 * 3	void mark(int readlimit)  此方法请参阅InputStream的mark方法的常规协定。
 * 4	boolean markSupported()  如果此输入流是否支持mark和reset方法的方法测试。
 * 5	int read()  此方法读取从输入流中的下一个数据字节。
 * 6	int read(byte[] b, int off, int len)  此方法读取该字节输入流中的字节到指定的字节数组，并从给定的偏移量。
 * 7	void reset() 此方法重新定位这个流，以当时的mark方法最后调用这个输入流中的位置。
 * 8	long skip(long n)  此方法跳过并丢弃n个字节从此输入流中的数据。
 */
public class BufferedInputStreamDome {
    public static void main(String[] args) throws Exception {

        InputStream inStream = null;
        BufferedInputStream bis = null;

        try{
            // open input stream test.txt for reading purpose.
            inStream = new FileInputStream("d:/test.txt");

            // input stream is converted to buffered input stream
            bis = new BufferedInputStream(inStream);

            // read until a single byte is available
            while( bis.available() > 0 )
            {
                // get the number of bytes available
                Integer nBytes = bis.available();
                System.out.println("Available bytes = " + nBytes );

                // read next available character
                char ch =  (char)bis.read();

                // print the read character.
                System.out.println("The character read = " + ch );
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

            // releases any system resources associated with the stream
            if(inStream!=null)
                inStream.close();
            if(bis!=null)
                bis.close();
        }
    }
}
