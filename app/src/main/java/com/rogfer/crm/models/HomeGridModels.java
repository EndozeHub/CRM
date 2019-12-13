package com.rogfer.crm.models;

public class HomeGridModels {
    private String id;
    private String name;
    private String image;
    private Integer img;

    public HomeGridModels(String id, String name, String image, Integer img) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
