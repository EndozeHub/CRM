package com.rogfer.crm.models;

public class AppointmentLisymodels {
    public String id,tittle,vistLevel,appointId,desc,type;

    public AppointmentLisymodels() {
    }


    public AppointmentLisymodels(String id, String tittle, String vistLevel, String appointId, String desc, String type) {
        this.id = id;
        this.tittle = tittle;
        this.vistLevel = vistLevel;
        this.appointId = appointId;
        this.desc = desc;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getVistLevel() {
        return vistLevel;
    }

    public void setVistLevel(String vistLevel) {
        this.vistLevel = vistLevel;
    }

    public String getAppointId() {
        return appointId;
    }

    public void setAppointId(String appointId) {
        this.appointId = appointId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
