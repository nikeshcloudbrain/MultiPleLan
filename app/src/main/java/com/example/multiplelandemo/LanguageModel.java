package com.example.multiplelandemo;

public class LanguageModel {
    private int ccimage;
    private String code;
    private String firsttype;
    private String secondtype;
    private String thirdtype;
    public LanguageModel(String str, String str2, String str3, int i, String str4) {

        this.secondtype = str;
        this.firsttype = str2;
        this.thirdtype = str3;
        this.ccimage = i;
        this.code = str4;
    }

    public final int getCcimage() {
        return this.ccimage;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getFirsttype() {
        return this.firsttype;
    }

    public final String getSecondtype() {
        return this.secondtype;
    }

    public final String getThirdtype() {
        return this.thirdtype;
    }

    public final void setCcimage(int i) {
        this.ccimage = i;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final void setFirsttype(String str) {
        this.firsttype = str;
    }

    public final void setSecondtype(String str) {
        this.secondtype = str;
    }

    public final void setThirdtype(String str) {
        this.thirdtype = str;
    }

}
