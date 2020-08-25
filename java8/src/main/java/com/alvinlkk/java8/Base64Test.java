package com.alvinlkk.java8;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * base64编码
 *
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-08-23 16:50
 */
public class Base64Test {

    public static void main(String[] args) {
        final String text = "Lets Learn Java 8!";

        final String encoded = Base64
                .getEncoder()
                .encodeToString(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(encoded);

        final String decoded = new String(
                Base64.getDecoder().decode(encoded),
                StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}
