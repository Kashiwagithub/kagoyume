/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;

/**
 *
 * @author Wataru
 */
public class JumsHelper {
    public static JumsHelper getInstance(){
        return new JumsHelper();
    }
    
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";
    
    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    
    //jsp用クラス
    public String getName(JsonNode jsonnode,int i){
        return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Name").textValue());  
    }
    public int getTotalresult(JsonNode jsonnode){
        return Integer.parseInt(String.valueOf(jsonnode.get("ResultSet").get("totalResultsAvailable").textValue()));
    }
    public String getImage(JsonNode jsonnode,int i){
        return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Image").get("Medium").textValue());
    }
    public int getPrice(JsonNode jsonnode,int i){
        return Integer.parseInt(String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Price").get("_value").textValue()));
    }
    public String getDescription(JsonNode jsonnode,int i){
        return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Description").textValue());
    }
    public double getReview(JsonNode jsonnode,int i){
        return Double.parseDouble(String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Review").get("Rate").textValue()));
    }
    public String getCode(JsonNode jsonnode,int i){
        return String.valueOf(jsonnode.get("ResultSet").get("0").get("Result").get(String.valueOf(i)).get("Code").textValue());
    }
    
    //入力漏れチェック
    public String checkinput(ArrayList<String> checkList){
        String output = "";
        for(String value : checkList){
                if(value.equals("username")){
                    output += "ユーザー名";
                }
                if(value.equals("password")){
                    output +="パスワード";
                }
                if(value.equals("mail")){
                    output +="メールアドレス";
                }
                if(value.equals("address")){
                    output +="住所";
                }
                output +="が未記入です<br>";
            }
        return output;
    }
    
    public String exTypenum(int i){
        switch(i){
            case 1:
                return "ヤマト運輸";
            case 2:
                return "佐川急便";
            case 3:
                return "ゆうパック";
        }
        return "";
    } 
}
