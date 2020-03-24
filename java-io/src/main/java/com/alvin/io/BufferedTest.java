package com.alvin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 处理流之一： 缓冲流的使用
 *
 * 1. 缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2. 作用：提高流读写的速度, 原因是内部提供了一个缓冲区
 *
 * 3. 处理流，就是套接在已有的流的基础上
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-03-23 23:25
 */
public class BufferedTest {
    @Test
    public void bufferedStreamTest() {
        //1. 造文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("图片 1.png");
            File destFile = new File("alvin.png");
            //2 造流
            //2.1 造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 复制的细节：读取和写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源关闭  先关闭外层的流，再关闭内层的流
            try {

                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层的流，内层的流会自动关闭，所以内层的流关闭可以省略
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void testBufferedReaderBufferedWriter() {
        //1. 造文件
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello_buffer.txt");
            //2 造流
            //2.1 造节点流
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //2.2 造缓冲流
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);

            //3. 复制的细节：读取和写入
            //方式一
//            char[] buffer = new char[10];
//            int len;
//            while ((len = br.read(buffer)) != -1) {
//                bw.write(buffer, 0, len);
//            }
            //方式2
            String data;
            while ((data = br.readLine()) != null) {
                //方式一
                //bw.write(data + "\n");
                //方式2
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源关闭  先关闭外层的流，再关闭内层的流
            try {

                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
