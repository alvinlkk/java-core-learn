package com.alvin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;

/**
 *
 * 处理流之 转换流
 *
 * 1. 转换流：属于字符流
 * InputStreamReader: 将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter: 将一个字符的输出流转换为字节的输出流
 *
 * 2. 作用： 提供字节流和字符流之间的转换
 *
 * 3. 解码： 字节、字节数组---->字符数组、字符串
 *    编码： 字符数组、字符串 -----> 字节、字节数组
 *
 * 4. 字符集
 * ASCII: 美国标准信息交换码。用一个字节的7位可以表示。
 * ISO8859-1:拉丁码表，欧洲码表 用一个字节的8位表示。
 * GB2312: 中国的中文编码表。最多两个字节编码所有字符。
 * GBK: 中国的中文编码表升级，融合了更多的中文文字字符号。最多两个字节编码。
 * Unicode: 国际标准码， 融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 * UTF-8:变长的编码方式，可用1-4个字节来表示一个字符。
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-03-24 13:16
 */
public class InputStreamReaderTest {

    @Test
    public void test1() throws IOException {
        //1. 建文件
        File file = new File("hello.txt");

        //2. 造流
        FileInputStream fis = new FileInputStream(file);
//        InputStreamReader isr = new InputStreamReader(fis);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");

        //3.读文件
        char[] chars = new char[4];
        int len;
        while ((len = isr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }

        //4. 关闭资源
        fis.close();
    }

    /**
     *  utf-8  ---> gbk
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        //1. 建文件
        File srcFile = new File("hello.txt");
        File destFile = new File("hello_gbk.txt");

        //2. 造流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
//        InputStreamReader isr = new InputStreamReader(fis);
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
        //3.读文件
        char[] chars = new char[4];
        int len;
        while ((len = isr.read(chars)) != -1) {
            osw.write(chars, 0, len);
        }

        //4. 关闭资源
        fis.close();
        osw.close();
    }
}
