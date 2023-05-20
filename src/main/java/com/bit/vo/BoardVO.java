package com.bit.vo;

public class BoardVO {
    private int NO;
    private String TITLE;
    private String CATEGORY;
    private String WRITER;
    private String PASSWORD;
    private String CONTENTS;
    private String FILENAME;
    private String regdate;

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getWRITER() {
        return WRITER;
    }

    public void setWRITER(String WRITER) {
        this.WRITER = WRITER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getCONTENTS() {
        return CONTENTS;
    }

    public void setCONTENTS(String CONTENTS) {
        this.CONTENTS = CONTENTS;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }


    public BoardVO(String TITLE, String CATEGORY, String WRITER, String PASSWORD, String CONTENTS, String FILENAME) {
        super();
        this.TITLE = TITLE;
        this.CATEGORY = CATEGORY;
        this.WRITER = WRITER;
        this.PASSWORD = PASSWORD;
        this.CONTENTS = CONTENTS;
        this.FILENAME = FILENAME;
    }



}
