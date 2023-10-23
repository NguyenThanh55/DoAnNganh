/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.pojo;

/**
 *
 * @author Thanh
 */
public class PostByCrawl {
    private String title;
    private String imageUrl;
    private String detailUrl;
    private String date;

    public PostByCrawl() {
    }

    public PostByCrawl(String title, String imageUrl, String detailUrl, String date) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.detailUrl = detailUrl;
        this.date = date;
    }

    
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl the imageUrl to set
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return the detailUrl
     */
    public String getDetailUrl() {
        return detailUrl;
    }

    /**
     * @param detailUrl the detailUrl to set
     */
    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
