package com.skooltchdev.multiplechoicequiz.Models;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class LeaderboardModel {
    public static String[] leadership = new String[]{
            "Accounting 1", "Accounting 2", "Accounting 3",
            "Parliamentary Procedure 1", "Parliamentary Procedure 2", "Parliamentary Procedure 3",
            "Intro to FBLA 1", "Intro to FBLA 2", "Intro to FBLA 3",
            "Financial Math 1", "Financial Math 2", "Financial Math 3",
            "History of FBLA 1", "History of FBLA 2", "History of FBLA 3",
    };
    String accounting1, accounting2, accounting3,
        pProcedure1, pProcedure2, pProcedure3,
        iFBLA1, iFBLA2, iFBLA3,
        m1, m2, m3,
        histFBLA1, histFBLA2, histFBLA3;

    public LeaderboardModel(String accounting1, String accounting2, String accounting3,
                            String pProcedure1, String pProcedure2, String pProcedure3,
                            String iFBLA1, String iFBLA2, String iFBLA3,
                            String m1, String m2, String m3,
                            String histFBLA1, String histFBLA2, String histFBLA3) {
        this.accounting1 = accounting1;
        this.accounting2 = accounting2;
        this.accounting3 = accounting3;
        this.pProcedure1 = pProcedure1;
        this.pProcedure2 = pProcedure2;
        this.pProcedure3 = pProcedure3;
        this.iFBLA1 = iFBLA1;
        this.iFBLA2 = iFBLA2;
        this.iFBLA3 = iFBLA3;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.histFBLA1 = histFBLA1;
        this.histFBLA2 = histFBLA2;
        this.histFBLA3 = histFBLA3;
    }

    public String getAccounting1() {
        return accounting1;
    }

    public void setAccounting1(String accounting1) {
        this.accounting1 = accounting1;
    }

    public String getAccounting2() {
        return accounting2;
    }

    public void setAccounting2(String accounting2) {
        this.accounting2 = accounting2;
    }

    public String getAccounting3() {
        return accounting3;
    }

    public void setAccounting3(String accounting3) {
        this.accounting3 = accounting3;
    }

    public String getpProcedure1() {
        return pProcedure1;
    }

    public void setpProcedure1(String pProcedure1) {
        this.pProcedure1 = pProcedure1;
    }

    public String getpProcedure2() {
        return pProcedure2;
    }

    public void setpProcedure2(String pProcedure2) {
        this.pProcedure2 = pProcedure2;
    }

    public String getpProcedure3() {
        return pProcedure3;
    }

    public void setpProcedure3(String pProcedure3) {
        this.pProcedure3 = pProcedure3;
    }

    public String getiFBLA1() {
        return iFBLA1;
    }

    public void setiFBLA1(String iFBLA1) {
        this.iFBLA1 = iFBLA1;
    }

    public String getiFBLA2() {
        return iFBLA2;
    }

    public void setiFBLA2(String iFBLA2) {
        this.iFBLA2 = iFBLA2;
    }

    public String getiFBLA3() {
        return iFBLA3;
    }

    public void setiFBLA3(String iFBLA3) {
        this.iFBLA3 = iFBLA3;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getM3() {
        return m3;
    }

    public void setM3(String m3) {
        this.m3 = m3;
    }

    public String getHistFBLA1() {
        return histFBLA1;
    }

    public void setHistFBLA1(String histFBLA1) {
        this.histFBLA1 = histFBLA1;
    }

    public String getHistFBLA2() {
        return histFBLA2;
    }

    public void setHistFBLA2(String histFBLA2) {
        this.histFBLA2 = histFBLA2;
    }

    public String getHistFBLA3() {
        return histFBLA3;
    }

    public void setHistFBLA3(String histFBLA3) {
        this.histFBLA3 = histFBLA3;
    }
}
