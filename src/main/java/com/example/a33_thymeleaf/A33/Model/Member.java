package com.example.a33_thymeleaf.A33.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    public int ID;
    public String Name;
    public String ShopName;
    public String Position;
    public String DaylikeStart;

    public String getDaylikeStart() {
        return DaylikeStart;
    }

    public void setDaylikeStart(String daylikeStart) {
        DaylikeStart = daylikeStart;
    }

    public String getDaylikeEnd() {
        return DaylikeEnd;
    }

    public void setDaylikeEnd(String daylikeEnd) {
        DaylikeEnd = daylikeEnd;
    }

    public String getTimelikeStart() {
        return TimelikeStart;
    }

    public void setTimelikeStart(String timelikeStart) {
        TimelikeStart = timelikeStart;
    }

    public String getTimelikeEnd() {
        return TimelikeEnd;
    }

    public void setTimelikeEnd(String timelikeEnd) {
        TimelikeEnd = timelikeEnd;
    }

    public String DaylikeEnd;
    public String TimelikeStart;
    public String TimelikeEnd;
    public int  Timelong;
    public String Phone;
    public String Mail;

    public int isBuzzy;

    public int getIsBuzzy() {
        return isBuzzy;
    }

    public void setIsBuzzy(int isBuzzy) {
        this.isBuzzy = isBuzzy;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }



    public int getTimelong() {
        return Timelong;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public void setTimelong(int timelong) {
        Timelong = timelong;
    }
}
