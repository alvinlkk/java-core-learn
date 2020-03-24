package com.alvin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 *
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 1. 对于文本文件（txt,java,.c,.cpp），使用字符流处理
 * 2. 对于非文本文件，使用字节流处理
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-03-18 13:14
 */
public class FileInputOutputStreamTest {

    //使用字节流处理文本文件，可能出现乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;

        try {
            //1. 造文件
            File file = new File("hello.txt");

            //2. 造流
            fis = new FileInputStream(file);

            //3. 读数据 在utf8字符中，一个英文字母如ask码表占一个字节，一个中文汉字占用3个字节
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testInputStreamOutputStream() {
        //建文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("图片 1.png");
            File destFile = new File("copy.png");

            //建流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //读和写
            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
