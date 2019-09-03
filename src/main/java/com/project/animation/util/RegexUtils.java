package com.project.animation.util;

public class RegexUtils {


    /**
     * 将所有非中文字符去除
     * @param seg
     * @return
     */
    public static String obtainChineseWords(String seg){
        String regex = "[^\u4E00-\u9FFF]+";

        return seg.replaceAll(regex, "");
    }

    public static String replaceImageChar(String words){
        return words.replaceAll("\\\\u002F", "/");
    }

    public static void main(String[] args) {
        //\u003Cem class=\"keyword\"\u003E重来吧\u003C\u002Fem\u003E，\u003Cem class=\"keyword\"\u003E魔王大人\u003C\u002Fem\u003E！
        System.out.println(replaceImageChar("https:\u002F\u002Fi0.hdslb.com\u002Fbfs\u002Fbangumi\u002Fa223b1376633625be1cd214c34d8bf34a1e03770.jpg"));
    }
}
