/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wataru
 */
public class Search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String searchword = request.getParameter("product_name"); //検索した文字列
            
            //検索未入力判定
            if(searchword != ""){
            //クエリストリングでURL生成
                String requesturl = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch?appid=";
                String appid = "dj0zaiZpPXFlV2F1c0NtZ1NSayZzPWNvbnN1bWVyc2VjcmV0Jng9ZTk-";
                String requestparam = "&query=";

                String urlString = requesturl + appid + requestparam + searchword; //文字列を結合
            
                String str = JSON_Mapping.getResult(urlString); //生成されたURLのサイトから文字列を取得する
                JsonNode jsonnode = JSON_Mapping.getJsonNode(str); //文字列からJSONへの変換
            
                HttpSession session = request.getSession(); //Httpセッションインスタンスの取得
                session.setAttribute("jsonnode", jsonnode);
            
                //Foward
                request.getRequestDispatcher("/search.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
