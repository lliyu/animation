package com.project.animation;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Tests {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decodeStr = URLDecoder.decode("%E5%9F%83%E7%BD%97%E97", "UTF-8");
        System.out.println(decodeStr);
    }
}
