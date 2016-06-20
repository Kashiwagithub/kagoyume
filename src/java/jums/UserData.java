/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Wataru
 */
public class UserData implements Serializable {
    private int userid;
    private String username;
    private String password;
    private String mail;
    private String address;
    private int total;
    private int type;
    private int deleteFlg;
    
    public UserData(){
        this.userid = 0;
        this.username = "";
        this.password = "";
        this.mail = "";
        this.address = "";
        this.total = 0;
        this.type = 0;
        this.deleteFlg = 0;
    }
    
    public int getUserID(){
        return userid;
    }
    public void setUserID(int userid){
        this.userid = userid;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
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
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getDeleteflg(){
        return deleteFlg;
    }
    public void setDeleteFlg(int deleteFlg){
        this.deleteFlg = deleteFlg;
    }
    
    public ArrayList<String> checkproperties(){
        ArrayList<String> checkList = new ArrayList<String>();
        if(this.username.equals("")){
            checkList.add("username");
        }
        if(this.password.equals("")){
            checkList.add("password");
        }
        if(this.mail.equals("")){
            checkList.add("mail");
        }
        if(this.address.equals("")){
            checkList.add("address");
        }
        return checkList;
    }
    
    public void UD2DTOMapping(UserDataDTO udd){
        udd.setUserID(this.userid);
        udd.setName(this.username);
        udd.setPassword(this.password);
        udd.setMail(this.mail);
        udd.setAddress(this.address);
        udd.setTotal(this.total);
        udd.setType(this.type);
        udd.setDeleteflg(this.deleteFlg);
    }
    
    //DTOからUserDataに値を渡す
    public void DTO2UDMapping(UserDataDTO udd){
        this.setUserID(udd.getUserID());
        this.setUsername(udd.getName());
        this.setPassword(udd.getPassword());
        this.setMail(udd.getMail());
        this.setAddress(udd.getAddress());
        this.setTotal(udd.getTotal());
        this.setType(udd.getType());
        this.setDeleteFlg(udd.getDeleteflg());
    }
}
