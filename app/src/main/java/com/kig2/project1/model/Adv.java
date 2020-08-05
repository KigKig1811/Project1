package com.kig2.project1.model;

import java.util.Date;

public class Adv {
    public int advId,seLLId,modeId,usedId;
    public String header,content,address,photo;
    public double price,area,bedroom;

    public Adv(int advId, int seLLId, int modeId, int usedId, String header, String content, String address, String photo, double price, double area, double bedroom) {
        this.advId = advId;
        this.seLLId = seLLId;
        this.modeId = modeId;
        this.usedId = usedId;
        this.header = header;
        this.content = content;
        this.address = address;
        this.photo = photo;
        this.price = price;
        this.area = area;
        this.bedroom = bedroom;
    }

    public int getAdvId() {
        return advId;
    }

    public void setAdvId(int advId) {
        this.advId = advId;
    }

    public int getSeLLId() {
        return seLLId;
    }

    public void setSeLLId(int seLLId) {
        this.seLLId = seLLId;
    }

    public int getModeId() {
        return modeId;
    }

    public void setModeId(int modeId) {
        this.modeId = modeId;
    }

    public int getUsedId() {
        return usedId;
    }

    public void setUsedId(int usedId) {
        this.usedId = usedId;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getBedroom() {
        return bedroom;
    }

    public void setBedroom(double bedroom) {
        this.bedroom = bedroom;
    }
}
