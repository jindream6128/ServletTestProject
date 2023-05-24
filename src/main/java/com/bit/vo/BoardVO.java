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
    private int HIT;
    private int LIKECNT;
    private int HATECNT;
    private int SCRAPCNT;

    public int getLIKECNT() {
        return LIKECNT;
    }

    public void setLIKECNT(int LIKECNT) {
        this.LIKECNT = LIKECNT;
    }

    public int getHATECNT() {
        return HATECNT;
    }

    public void setHATECNT(int HATECNT) {
        this.HATECNT = HATECNT;
    }

    public int getSCRAPCNT() {
        return SCRAPCNT;
    }

    public void setSCRAPCNT(int SCRAPCNT) {
        this.SCRAPCNT = SCRAPCNT;
    }

    public int getHIT() {
        return HIT;
    }

    public void setHIT(int HIT) {
        this.HIT = HIT;
    }

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

    public BoardVO(String TITLE, String CATEGORY, String WRITER, String PASSWORD, String CONTENTS, String FILENAME, int HIT) {
        super();
        this.TITLE = TITLE;
        this.CATEGORY = CATEGORY;
        this.WRITER = WRITER;
        this.PASSWORD = PASSWORD;
        this.CONTENTS = CONTENTS;
        this.FILENAME = FILENAME;
        this.HIT = HIT;
    }

    public BoardVO(int NO, String TITLE, String CATEGORY, String WRITER, String PASSWORD, String CONTENTS, String FILENAME, String regdate, int HIT, int LIKECNT, int HATECNT, int SCRAPCNT) {
        super();
        this.NO = NO;
        this.TITLE = TITLE;
        this.CATEGORY = CATEGORY;
        this.WRITER = WRITER;
        this.PASSWORD = PASSWORD;
        this.CONTENTS = CONTENTS;
        this.FILENAME = FILENAME;
        this.regdate = regdate;
        this.HIT = HIT;
        this.LIKECNT = LIKECNT;
        this.HATECNT = HATECNT;
        this.SCRAPCNT = SCRAPCNT;
    }

    public BoardVO(int NO, String TITLE, String CATEGORY, String WRITER, String PASSWORD, String CONTENTS, String FILENAME, String regdate, int HIT) {
        super();
        this.NO = NO;
        this.TITLE = TITLE;
        this.CATEGORY = CATEGORY;
        this.WRITER = WRITER;
        this.PASSWORD = PASSWORD;
        this.CONTENTS = CONTENTS;
        this.FILENAME = FILENAME;
        this.regdate = regdate;
        this.HIT = HIT;
    }

    public BoardVO(int NO, String TITLE, String CATEGORY, String WRITER, String PASSWORD, String CONTENTS, String FILENAME, int HIT) {
        this.NO = NO;
        this.TITLE = TITLE;
        this.CATEGORY = CATEGORY;
        this.WRITER = WRITER;
        this.PASSWORD = PASSWORD;
        this.CONTENTS = CONTENTS;
        this.FILENAME = FILENAME;
        this.HIT = HIT;
    }

    @Override
    public String toString() {
        return "BoardVO{" +
                "NO=" + NO +
                ", TITLE='" + TITLE + '\'' +
                ", CATEGORY='" + CATEGORY + '\'' +
                ", WRITER='" + WRITER + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                ", CONTENTS='" + CONTENTS + '\'' +
                ", FILENAME='" + FILENAME + '\'' +
                ", regdate='" + regdate + '\'' +
                ", HIT=" + HIT +
                '}';
    }
}
