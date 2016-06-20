/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;

/**
 *
 * @author Wataru
 */    
public class ItemDataBeans implements Serializable {
    private String name;
    private String image;
    private String description;
    private String code;
    private double review;
    private int price;
    private int number;
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description ;
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public double getReview(){
        return review;
    }
    public void setReview(double review){
        this.review = review;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getNumber(){
        return number;
    }
    public void setNumber(int number){
        this.number = number;
    }

}