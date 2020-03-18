package com.alvin.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * 一. 流的分类
 * 1. 操作数据单位： 字节流，字符流
 * 2. 数据的流向： 输入流、输出流
 * 3.流的角色： 节点流，处理流
 *
 * 二. 流的体系结构
 * 抽象基类                      节点流（或文件流）              处理流（或包装流）
 * InputStream                  FileInputStream             BufferedInputStream
 * OutputStream                 FileOutputStream            BufferedOutputStream
 * Reader                       FileReader                  BufferedReader
 * Writer                       FileWriter                  BufferedWriter
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-03-17 13:19
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");   //相对于当前工程
        System.out.println(file.getAbsolutePath());

        File file2 = new File("java-io/hello.txt");   //相对于当前工程
        System.out.println(file2.getAbsolutePath());
    }

    /**
     * 读取hello.txt内容到内存中，输出到控制台
     */
    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1. 实例化File对象
            File file = new File("hello.txt");    //相对于当前module
            System.out.println(file.getAbsolutePath());

            //2. 提供具体的流
            fr = new FileReader(file);

            //3.数据读入
            //read() 返回读入的一个字符，如果达到文件末尾，返回-1
            //方式一：
//        int data = fr.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            data = fr.read();
//        }

            //方式二： 语法上针对方式一的修改
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭操作，否则导致内存泄漏问题
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    //对read()操作升级， 使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1. File类的实例化
            File file = new File("hello.txt");
            //2. FileReader流的实例化
            fr = new FileReader(file);
            //3. 读入的操作
            // read(char[] cbuf): 返回每次读入cbuf数组中的字符的个数，如果达到文件末位， 返回-1
            char[] cbuffer = new char[5];
            int len;
            while((len = fr.read(cbuffer)) != -1) {
                //方式1
//                for(int i=0; i<len; i++) {
//                    System.out.print(cbuffer[i]);
//                }

                //方式2
                String str = new String(cbuffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 资源的关闭
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从内存中写出数据到磁盘
     *
     * 说明：
     * 1. 输出操作，对应的File可以不存在的。
     *    如果不存在，自动会创建文件
     *    如果存在，构造函数的append,true, false是否追加内容到文件中
     */
    @Test
    public void testFileWriter() throws IOException {
        //1. File对象，指明写出到文件
        File file = new File("hello1.txt");

        //2. 提供FileWriter对象，用于数据的写出
        FileWriter fw = new FileWriter(file, true);

        //3.写出操作
        fw.write("alvin is handsome boy! \n");
        fw.write("love kk");

        //4.关闭流
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1. 创建File对象
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            //2. 创建输入流和输出流
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3. 数据的读入和写出操作
            char[] cbuf = new char[4];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流资源的关闭
            try {
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
