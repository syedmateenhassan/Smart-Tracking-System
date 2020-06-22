package com.example.sts.ui;

public class Data {
    private String Eid, Ename, Econtact, Eleave, Cdate, Ctime, Estatus, Eusername, Epassword, EAcctype;
    int Epresent, Eabsent;

    public Data(String name, int age) {
    }

    public Data(String eid, String ename, String econtact, String eleave, String cdate, String ctime, String estatus, int epresent, int eabsent) {
        Eid = eid;
        Ename = ename;
        Econtact = econtact;
        Eleave = eleave;
        Cdate = cdate;
        Ctime = ctime;
        Estatus = estatus;
        Epresent = epresent;
        Eabsent = eabsent;
    }

    public String getEid() {
        return Eid;
    }

    public void setEid(String eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEcontact() {
        return Econtact;
    }

    public void setEcontact(String econtact) {
        Econtact = econtact;
    }

    public String getEleave() {
        return Eleave;
    }

    public void setEleave(String eleave) {
        Eleave = eleave;
    }

    public String getCdate() {
        return Cdate;
    }

    public void setCdate(String cdate) {
        Cdate = cdate;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String ctime) {
        Ctime = ctime;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }

    public int getEpresent() {
        return Epresent;
    }

    public void setEpresent(int epresent) {
        Epresent = epresent;
    }

    public int getEabsent() {
        return Eabsent;
    }

    public void setEabsent(int eabsent) {
        Eabsent = eabsent;
    }
}