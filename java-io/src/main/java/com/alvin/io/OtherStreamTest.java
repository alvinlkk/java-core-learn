package com.alvin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * 其他流的使用
 * 1. 标准的输入、输出流
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-03-24 23:45
 */
public class OtherStreamTest {

    /**
     * 1. 标准的输入、输出流
     * 1.1.
     * System.in 标准的输入流，默认从键盘输入
     * System.out 标准的输出流， 默认从控制台输出
     *
     * 1.2
     * System类的setIn(InputStream is)/setOut(PrintStream ps) 方式重新指定输入和输出的流
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        while (true) {
            String data = br.readLine();
            if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("程序结束");
                break;
            }

            String upperCase = data.toUpperCase();
            System.out.println(upperCase);
        }

        br.close();
    }

}
