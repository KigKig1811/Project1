package com.kig2.project1.model;

import java.util.Date;

public class Adv {
    public int advId,seLLId,modeId,cateId,userId;
    public String header,content,address,street,district,ward,cityProvince,photo,agentAccount,sellAccount;
    public float price,area,bedroom;
    public Date dateUp,expdate;
    public boolean approved,paid;

    public Adv(int advId, int seLLId, int modeId, int cateId, int userId, String header, String content, String address, String street, String district, String ward, String cityProvince, String photo, String agentAccount, String sellAccount,
               float price, float area, float bedroom, Date dateUp, Date expdate, boolean approved, boolean paid) {
        this.advId = advId;
        this.seLLId = seLLId;
        this.modeId = modeId;
        this.cateId = cateId;
        this.userId = userId;
        this.header = header;
        this.content = content;
        this.address = address;
        this.street = street;
        this.district = district;
        this.ward = ward;
        this.cityProvince = cityProvince;
        this.photo = photo;
        this.agentAccount = agentAccount;
        this.sellAccount = sellAccount;
        this.price = price;
        this.area = area;
        this.bedroom = bedroom;
        this.dateUp = dateUp;
        this.expdate = expdate;
        this.approved = approved;
        this.paid = paid;
    }

    public Adv(int advId, int usedId, int seLLId, int modeId, int cateId, String header, String content, Double price, String address, String street, String district, String ward, String cityProvince, Double area, String photo, String dateUp, String expdate, int agentId, String agentAccount, String sellAccount, Boolean approved, Boolean paid, Double bedroom) {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getCityProvince() {
        return cityProvince;
    }

    public void setCityProvince(String cityProvince) {
        this.cityProvince = cityProvince;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAgentAccount() {
        return agentAccount;
    }

    public void setAgentAccount(String agentAccount) {
        this.agentAccount = agentAccount;
    }

    public String getSellAccount() {
        return sellAccount;
    }

    public void setSellAccount(String sellAccount) {
        this.sellAccount = sellAccount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getBedroom() {
        return bedroom;
    }

    public void setBedroom(float bedroom) {
        this.bedroom = bedroom;
    }

    public Date getDateUp() {
        return dateUp;
    }

    public void setDateUp(Date dateUp) {
        this.dateUp = dateUp;
    }

    public Date getExpdate() {
        return expdate;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
