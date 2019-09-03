package com.project.animation.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

public class ObtainWebContentUtils {

    public static String getContent(String url){
        StringBuilder sb = new StringBuilder();

        try {
            CloseableHttpClient conn = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("accept", "*/*");
            httpGet.addHeader("connection", "Keep-Alive");
//            httpGet.addHeader("Content-Type","application/json");
            httpGet.addHeader("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
            CloseableHttpResponse response = conn.execute(httpGet);

            InputStream inputStream = response.getEntity().getContent();
            byte[] bytes = new byte[1024];
            int index = 0;
            while((index = inputStream.read(bytes))!=-1){
                sb.append(new String(bytes, "utf-8"));
            }
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getContent("https://api.bilibili.com/x/tag/info?tag_name=擅长捉弄的高木同学"));
    }

}
