package com.project.animation.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.animation.mapper.OnlineSiteMapper;
import com.project.animation.po.OnlineSite;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtils {
    //配置ObjectMapper对象
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    @Autowired
    private OnlineSiteMapper onlineSiteMapper;

    public static void testOnlineSite(String uri, String keyword) throws IOException {
//        String keyword = "擅长捉弄的高木同学";
        String perfix = "/bangumi?keyword=%C3%A6%C2%93%C2%85%C3%A9%C2%95%C2%BF%C3%A6%C2%8D%C2%89%C3%A5%C2%BC%C2%84%C3%A7%C2%9A%C2%84%C3%A9%C2%AB%C2%98%C3%A6%C2%9C%C2%A8%C3%A5%C2%90%C2%8C%C3%A5%C2%AD%C2%A6";

        String source = System.getProperty("user.dir") + "/src/test/java/resource";
        File dir = new File(source);
        if(!dir.exists())
            dir.mkdirs();
        File file = new File(source + MessageFormat.format("/bilibili-{0}.txt", keyword));
        if(!file.exists())
            file.createNewFile();
        //将读取到的结果写入到文件中

        String resp = ObtainWebContentUtils.getContent(MessageFormat.format(uri, keyword));
//        System.out.println(resp);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(resp.getBytes());
        fos.close();
    }

    public static String readHtml(String keyword) throws IOException {
        String source = System.getProperty("user.dir") + MessageFormat.format("/src/test/java/resource/bilibili-{0}.txt", keyword);
        File file = new File(source);
        if(!file.exists())
            return "";
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder html = new StringBuilder();
        String res = "";
        while ((res = br.readLine())!=null){
            html.append(res);
        }
        br.close();
        return html.toString();
    }

    public static String parseSite(String html){
        //正则解析
        String regex = "<div class=\"headline\">.*?<a href=\"//(.*?)\" title=\"(.*?)\".*?>.*?</div>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html.toString());
        if (matcher.find()){
            return matcher.group(1);
        }
        return "";
    }

    public static OnlineSite parseInfo(String html){
        String imgRe = "\"media_id\".*?\"cover\":\"(.*?)\"";
        String urlRe = "\"media_id\":(.*?),";
        String titleRe = "<div class=\"headline\">.*?<a.*?title=\"(.*?)\"";
        Pattern pattern = Pattern.compile(imgRe);
        Matcher matcher = pattern.matcher(html);
        OnlineSite site = null;
        site = new OnlineSite();
        if (matcher.find()){
            site.setImg("https:" + RegexUtils.replaceImageChar(matcher.group(1)));
        }

        pattern = Pattern.compile(urlRe);
        matcher = pattern.matcher(html);
        if(matcher.find()){
            site.setUrl(MessageFormat.format("https://bilibili.com/bangumi/media/md{0}", matcher.group(1)));
        }

        pattern = Pattern.compile(titleRe);
        matcher = pattern.matcher(html);
        if(matcher.find()){
            site.setName(matcher.group(1));
        }
        return site;
    }
}
