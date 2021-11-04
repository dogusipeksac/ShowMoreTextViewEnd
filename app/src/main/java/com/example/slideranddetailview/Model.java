package com.example.slideranddetailview;

public class Model {
            /*
            "https://picsum.photos/1000?random1",
            "https://picsum.photos/1000?random2",
            "https://picsum.photos/1000?random3",
            "https://picsum.photos/1000?random4",
            "https://picsum.photos/1000?random5"*/

    private String name;
    private String date;
    private String[] urlArr;
    private  String desc;

    public Model(String name, String date, String desc, String[] urlArr) {
        this.name = name;
        this.date = date;
        this.urlArr = urlArr;
        this.desc = desc;
    }

    public Model() {
    }

    public String[] getUrlArr() {
        return urlArr;
    }

    public void setUrlArr(String[] urlArr) {
        this.urlArr = urlArr;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
