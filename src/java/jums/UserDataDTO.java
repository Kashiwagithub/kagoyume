/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Wataru
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private String password;
    private String mail;
    private String address;
    private int total;
    private Timestamp newDate;
    private int deleteFlg;
    private int type;
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type; 
    }
    public int getDeleteflg(){
        return deleteFlg;
    }
    public void setDeleteflg(int deleteFlg){
        this.deleteFlg = deleteFlg; 
    }
}
