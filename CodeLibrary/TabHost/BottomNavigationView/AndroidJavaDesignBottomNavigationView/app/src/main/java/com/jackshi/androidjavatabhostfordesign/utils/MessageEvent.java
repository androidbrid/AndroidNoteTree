package com.jackshi.androidjavatabhostfordesign.utils;

public class MessageEvent {
    int type;
    Boolean flag;
    int position;

    public MessageEvent(int type, Boolean flag) {
        this.type = type;
        this.flag = flag;
    }

    public MessageEvent(int type, int position) {
        this.type = type;
        this.position = position;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
