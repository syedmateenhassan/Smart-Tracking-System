package com.example.sts.ui;

public class StsEtracking {
    String pre,abs,status;

    public StsEtracking() {
    }

    public StsEtracking(String pre, String abs, String status) {
        this.pre = pre;
        this.abs = abs;
        this.status = status;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
