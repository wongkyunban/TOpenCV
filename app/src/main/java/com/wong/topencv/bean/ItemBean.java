package com.wong.topencv.bean;

/**
 * @author WongKyunban
 * description
 * created at 2018-09-30 上午11:39
 * @version 1.0
 */
public class ItemBean {

    public ItemBean(){}
    public ItemBean(int id,String title){
        this.id = id;
        this.title = title;
    }
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
