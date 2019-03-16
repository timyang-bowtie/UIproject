package com.tech_sim.uiproject.model;

public class ItemModel {
    private String itemlist;
    private String subtitle;
    public ItemModel(){}
    public ItemModel(String itemlist,String subtitle)
    {
        this.itemlist=itemlist;
        this.subtitle=subtitle;
    }

    public String getItemlist() {
        return itemlist;
    }

    public void setItemlist(String itemlist) {
        this.itemlist = itemlist;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
