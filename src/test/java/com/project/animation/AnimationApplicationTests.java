package com.project.animation;

import com.project.animation.mapper.OnlineSiteMapper;
import com.project.animation.po.OnlineSite;
import com.project.animation.po.OnlineSiteRegexList;
import com.project.animation.util.ParseUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.project.animation.OnlineSiteTests.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimationApplicationTests {

    @Autowired
    private OnlineSiteMapper onlineSiteMapper;
    @Autowired
    private OnlineSiteRegexList siteRegexList;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testCall() throws IOException {
        String uri = "https://search.bilibili.com/all?keyword={0}";
        String keyword = "关于我转生变成史莱姆这档事";
        testOnlineSite(uri, keyword);
        String html = ParseUtils.readHtml(keyword);
        OnlineSite site = parseInfo(html);
        onlineSiteMapper.save(site);
    }

    @Test
    public void testProperties(){
        System.out.println(siteRegexList.getRegexes());
    }

}
