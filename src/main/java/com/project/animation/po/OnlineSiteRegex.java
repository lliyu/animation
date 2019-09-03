package com.project.animation.po;

public class OnlineSiteRegex {
    private String name;

    private String url;

    private String perfix;

    private String img;

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPerfix() {
        return perfix;
    }

    public void setPerfix(String perfix) {
        this.perfix = perfix;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "OnlineSiteRegex{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", perfix='" + perfix + '\'' +
                ", img='" + img + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
