//package com.alvinlkk.nio;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.ByteBuffer;
//import java.nio.MappedByteBuffer;
//import java.nio.channels.FileChannel;
//import java.nio.file.StandardOpenOption;
//
//import org.junit.Test;
//
///**
// * 一、通道（Channel）:用于源节点与目标节点的连接。在Java NIO中负责缓冲区中数据的传输。Channel本身不存储数据，因此需要配合缓冲区进行传输。
// *
// * 二、通道的主要实现类
// *  java.nio.channels.Channel 接口：
// *      |--FileChannel
// *      |--SocketChannel
// *      |--ServerSocketChannel
// *      |--DatagramChannel
// *
// * 三、获取通道
// * 1. Java针对支持通道的类提供了getChannel()方法
// *      本地IO:
// *      FileInputStream/FileOutputStream
// *      RandomAccessFile
// *
// *      网络IO:
// *      Socket
// *      ServerSocket
// *      DatagramSocket
// *
// * 2. 在JDK1.7 中的NIO.2 针对各个通道提供了静态方法 open()
// * 3. 在JDK1.7 中的NIO.2 的Files 工具类的newByteChannel()
// *
// *
// * @author : alvinlkk
// * @version V1.0
// * @date Date : 2020-04-30 17:39
// */
//public class TestChannel {
//
//    //使用直接缓冲区完成文件的复制（内存映射文件）
//    @Test
//    public void test2() {
//        //1. 创建通道
//        FileChannel inChannel = FileChannel.open("a.jpg", StandardOpenOption.READ);
//        FileChannel outChannel = FileChannel.open("c.jpg", StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
//
//        //2. 获取映射
//        MappedByteBuffer inMapBuff = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
//        MappedByteBuffer outMapBuff = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
//
//        //3. 直接对缓冲区进行数据的读写操作
//        byte buf = new byte[inMapBuff.limit()];
//        inMapBuff.get(buf);
//        outMapBuff.put(buf);
//
//        inChannel.close();
//        outChannel.close();
//
//    }
//
//    //利用通道完成文件的复制
//    @Test
//    public void test1() {
//        FileInputStream fis = null;
//        FileOutputStream fos = null;
//        FileChannel fic = null;
//        FileChannel foc = null;
//        try {
//            //1. 建流
//            fis = new FileInputStream("a.jpg");
//            fos = new FileOutputStream("b.jpg");
//
//            //2. 获取通道
//            fic = fis.getChannel();
//            foc = fos.getChannel();
//
//            //3. 创建指定大小的缓冲区
//            ByteBuffer buf = ByteBuffer.allocate(1024);
//
//            //4. 写入数据到缓冲区
//            while (fic.read(buf) != -1) {
//                //切换缓冲区为读模式
//                buf.flip();
//
//                //将缓冲区的数据写到通道中
//                foc.write(buf);
//                buf.clear();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fic.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    foc.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//
//    }
//}
