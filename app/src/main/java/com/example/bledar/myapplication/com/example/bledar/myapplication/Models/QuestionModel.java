package com.example.bledar.myapplication.com.example.bledar.myapplication.Models;

/**
 * Created by Bledar on 23/08/2016.
 */
public class QuestionModel {

    public String getPyetja() {
        return Pyetja;
    }

    public void setPyetja(String pyetja) {
        Pyetja = pyetja;
    }

    public String getAlt1() {
        return Alt1;
    }

    public void setAlt1(String alt1) {
        Alt1 = alt1;
    }

    public String getAlt2() {
        return Alt2;
    }

    public void setAlt2(String alt2) {
        Alt2 = alt2;
    }

    public String getAlt3() {
        return Alt3;
    }

    public void setAlt3(String alt3) {
        Alt3 = alt3;
    }

    public String getAlt4() {
        return Alt4;
    }

    public void setAlt4(String alt4) {
        Alt4 = alt4;
    }

    public int getAlts() {
        return Alts;
    }

    public void setAlts(int alts) {
        Alts = alts;
    }

    private String Pyetja;
    private String Alt1;
    private String Alt2;
    private String Alt3;
    private String Alt4;
    private int Alts;
}
