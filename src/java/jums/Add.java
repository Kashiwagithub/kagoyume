/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wataru
 */
public class Add extends HttpServlet {

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
            HttpSession session = request.getSession();
            int i = Integer.parseInt(request.getParameter("code"));
            int j = Integer.parseInt(request.getParameter("number"));
            ItemDataBeans idb = new ItemDataBeans();
            JumsHelper jh = new JumsHelper();
            JsonNode jsonnode = (JsonNode)session.getAttribute("jsonnode"); //JsonNodeをsessionから取得
            
            HashMap<String,ItemDataBeans> Cart = null;
            //カートが空ならカートを作成する
                if(session.getAttribute("Cart") == null){
                    Cart = new HashMap <>();
                }
            //あるならsessionから”Cart”オブジェクトを取得
                else{
                    Cart = (HashMap<String,ItemDataBeans>)session.getAttribute("Cart");
                }
                
            //ItemDataBeansにJsonNodeから取得した情報を格納
            idb.setCode(jh.getCode(jsonnode, i));
            idb.setName(jh.getName(jsonnode, i));
            idb.setPrice(jh.getPrice(jsonnode, i));
            idb.setDescription(jh.getDescription(jsonnode, i));
            idb.setReview(jh.getReview(jsonnode, i));
            idb.setImage(jh.getImage(jsonnode, i));
            idb.setNumber(j);
            //Mapにidbを格納
            Cart.put(idb.getCode(),idb);
            session.setAttribute("Cart", Cart);
            request.setAttribute("Code", idb.getCode());
            //Foward
            request.getRequestDispatcher("/add.jsp").forward(request, response);
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
