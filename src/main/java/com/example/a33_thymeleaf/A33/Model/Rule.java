package com.example.a33_thymeleaf.A33.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    public int RuleID;
    public int PrepareTime;
    public int PrepareDivNum;
    public String PreparePow;
    public int EmptyMemNum;
    public Double WorkDivNum;
    public String WorkPow;
    public int CloseTime;
    public int CloseDivNum;
    public int CloseAddNum;
    public String ClosePow;
    public int ShopID;
    public int getRuleID() {
        return RuleID;
    }

    public void setRuleID(int ruleID) {
        RuleID = ruleID;
    }

    public int getPrepareTime() {
        return PrepareTime;
    }

    public void setPrepareTime(int prepareTime) {
        PrepareTime = prepareTime;
    }

    public int getPrepareDivNum() {
        return PrepareDivNum;
    }

    public void setPrepareDivNum(int prepareDivNum) {
        PrepareDivNum = prepareDivNum;
    }

    public String getPreparePow() {
        return PreparePow;
    }

    public void setPreparePow(String preparePow) {
        PreparePow = preparePow;
    }

    public int getEmptyMemNum() {
        return EmptyMemNum;
    }

    public void setEmptyMemNum(int emptyMemNum) {
        EmptyMemNum = emptyMemNum;
    }

    public Double getWorkDivNum() {
        return WorkDivNum;
    }

    public void setWorkDivNum(Double workDivNum) {
        WorkDivNum = workDivNum;
    }

    public String getWorkPow() {
        return WorkPow;
    }

    public void setWorkPow(String workPow) {
        WorkPow = workPow;
    }

    public int getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(int closeTime) {
        CloseTime = closeTime;
    }

    public int getCloseDivNum() {
        return CloseDivNum;
    }

    public void setCloseDivNum(int closeDivNum) {
        CloseDivNum = closeDivNum;
    }

    public int getCloseAddNum() {
        return CloseAddNum;
    }

    public void setCloseAddNum(int closeAddNum) {
        CloseAddNum = closeAddNum;
    }

    public String getClosePow() {
        return ClosePow;
    }

    public void setClosePow(String closePow) {
        ClosePow = closePow;
    }

    public int getShopID() {
        return ShopID;
    }

    public void setShopID(int shopID) {
        ShopID = shopID;
    }
}
