package com.hibernate.introduction.model;

public class Img {
    
    private String  nombre;
    private String url;
    private String error;
    private String msg;
    public Img() {
    }
    public Img(String nombre, String url, String error, String msg) {
        this.nombre = nombre;
        this.url = url;
        this.error = error;
        this.msg = msg;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    
}
