package com.zking.ssm.vo;

import lombok.ToString;

@ToString
public class NoteVo {

    private String url;
    private  String tpl_id;
    private  String key;
    private  String tpl_value;

    public NoteVo() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTpl_id() {
        return tpl_id;
    }

    public void setTpl_id(String tpl_id) {
        this.tpl_id = tpl_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTpl_value() {
        return tpl_value;
    }

    public void setTpl_value(String tpl_value) {
        this.tpl_value = tpl_value;
    }
}
