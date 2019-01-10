package com.skooltchdev.multiplechoicequiz.Models;

/**
 * Created by Archishmaan Peyyety on 1/10/19.
 * Project: FBLA1819
 */
public class LeaderboardModel {
    String accountingScore, pProcedureScore, iFBLAScore, mScore, histFBLAScore;
    String accountingU, pProcedureU, iFBLAU, mU, histFBLAU;

    public LeaderboardModel(String accountingScore, String pProcedureScore, String iFBLAScore, String mScore, String histFBLAScore,
                            String accountingU, String pProcedureU, String iFBLAU, String mU, String histFBLAU) {
        this.accountingScore = accountingScore;
        this.pProcedureScore = pProcedureScore;
        this.iFBLAScore = iFBLAScore;
        this.mScore = mScore;
        this.histFBLAScore = histFBLAScore;
        this.accountingU = accountingU;
        this.pProcedureU = pProcedureU;
        this.iFBLAU = iFBLAU;
        this.mU = mU;
        this.histFBLAU = histFBLAU;
    }
    public LeaderboardModel() {

    }

    public String getAccountingScore() {
        return accountingScore;
    }

    public void setAccountingScore(String accountingScore) {
        this.accountingScore = accountingScore;
    }

    public String getpProcedureScore() {
        return pProcedureScore;
    }

    public void setpProcedureScore(String pProcedureScore) {
        this.pProcedureScore = pProcedureScore;
    }

    public String getiFBLAScore() {
        return iFBLAScore;
    }

    public void setiFBLAScore(String iFBLAScore) {
        this.iFBLAScore = iFBLAScore;
    }

    public String getmScore() {
        return mScore;
    }

    public void setmScore(String mScore) {
        this.mScore = mScore;
    }

    public String getHistFBLAScore() {
        return histFBLAScore;
    }

    public void setHistFBLAScore(String histFBLAScore) {
        this.histFBLAScore = histFBLAScore;
    }

    public String getAccountingU() {
        return accountingU;
    }

    public void setAccountingU(String accountingU) {
        this.accountingU = accountingU;
    }

    public String getpProcedureU() {
        return pProcedureU;
    }

    public void setpProcedureU(String pProcedureU) {
        this.pProcedureU = pProcedureU;
    }

    public String getiFBLAU() {
        return iFBLAU;
    }

    public void setiFBLAU(String iFBLAU) {
        this.iFBLAU = iFBLAU;
    }

    public String getmU() {
        return mU;
    }

    public void setmU(String mU) {
        this.mU = mU;
    }

    public String getHistFBLAU() {
        return histFBLAU;
    }

    public void setHistFBLAU(String histFBLAU) {
        this.histFBLAU = histFBLAU;
    }
}
