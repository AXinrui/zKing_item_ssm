package com.zking.ssm.model;

public class Dict {
    private Integer tid;

    private String dictType;

    private String dictItem;

    private String dictValue;

    private String dictLogo;

    private Integer dictIsEditable;

    public Dict(Integer tid, String dictType, String dictItem, String dictValue, String dictLogo, Integer dictIsEditable) {
        this.tid = tid;
        this.dictType = dictType;
        this.dictItem = dictItem;
        this.dictValue = dictValue;
        this.dictLogo = dictLogo;
        this.dictIsEditable = dictIsEditable;
    }

    public Dict() {
        super();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictItem() {
        return dictItem;
    }

    public void setDictItem(String dictItem) {
        this.dictItem = dictItem;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictLogo() {
        return dictLogo;
    }

    public void setDictLogo(String dictLogo) {
        this.dictLogo = dictLogo;
    }

    public Integer getDictIsEditable() {
        return dictIsEditable;
    }

    public void setDictIsEditable(Integer dictIsEditable) {
        this.dictIsEditable = dictIsEditable;
    }
}