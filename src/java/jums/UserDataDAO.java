/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Wataru
 */
public class UserDataDAO {
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,password,mail,address,total,newDate,deleteFlg) VALUES(?,?,?,?,?,?,?)");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setString(3, udd.getMail());
            st.setString(4, udd.getAddress());
            st.setInt(5, udd.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, udd.getDeleteflg());
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO login (UserDataDTO udd)  throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql ="SELECT * FROM user_t WHERE name = ? AND password = ?";
            
            st =  con.prepareStatement(sql);
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            ResultSet rs = st.executeQuery();
            
            if(rs.next()){
            udd.setUserID(rs.getInt("userID"));
            udd.setName(rs.getString("name"));
            udd.setPassword(rs.getString("password"));
            udd.setMail(rs.getString("mail"));
            udd.setAddress(rs.getString("address"));
            udd.setTotal(rs.getInt("total"));
            udd.setNewDate(rs.getTimestamp("newDate"));
            udd.setDeleteflg(rs.getInt("deleteFlg"));
            }
            return udd;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                try{
                    con.close();
                }catch(SQLException ignore){
                }
            }
            if(st != null){
                try{
                    st.close();
                }catch(SQLException ignore){
                }
            }
        }        
    }

//Update
public void update(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,address=?,total=?,newDate=?,deleteFlg=? WHERE userID = ?");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setString(3, udd.getMail());
            st.setString(4, udd.getAddress());
            st.setInt(5, udd.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, udd.getDeleteflg());
            st.setInt(8, udd.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

//Delete

    public void delete(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,password=?,mail=?,address=?,total=?,newDate=?,deleteFlg=?  WHERE userID = ?");
            st.setString(1, udd.getName());
            st.setString(2, udd.getPassword());
            st.setString(3, udd.getMail());
            st.setString(4, udd.getAddress());
            st.setInt(5, udd.getTotal());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, 1); //deleteFlgを1に変更して論理削除　ログイン判定がdeleteFlg=0でログイン可なのでログインできなくなる
            st.setInt(8, udd.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    //buy_t
    public void buyinsert(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO buy_t(userID,total,type,buyDate) VALUES(?,?,?,?)");
            st.setInt(1, udd.getUserID());
            st.setInt(2, udd.getTotal());
            st.setInt(3, udd.getType());
            st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}
