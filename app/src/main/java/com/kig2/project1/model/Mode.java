package com.kig2.project1.model;

public class Mode {
    public int modeId;
    public String modeName;
    public String image;

    public Mode(int modeId, String modeName, String image) {
        this.modeId = modeId;
        this.modeName = modeName;
        this.image = image;
    }

    public int getModeId() {
        return modeId;
    }

    public void setModeId(int modeId) {
        this.modeId = modeId;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
