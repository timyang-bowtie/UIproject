package com.tech_sim.uiproject.model;

public class SearchModel {


    private String title1;
    private String title2;
    private String subtitle;
    public SearchModel(){}
    public SearchModel(String title1,String title2,String subtitle)
    {
        this.subtitle=subtitle;
        this.title1=title1;
        this.title2=title2;
    }
    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

}
