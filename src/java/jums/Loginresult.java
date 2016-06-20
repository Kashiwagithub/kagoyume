/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wataru
 */
public class Loginresult extends HttpServlet {

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
                request.setCharacterEncoding("UTF-8");
                HttpSession  session = request.getSession();
                
                //UserDataにリクエストスコープを保存
                UserData ud  = new UserData();
                ud.setUsername(request.getParameter("username"));
		ud.setPassword(request.getParameter("password"));
                
                //引数をuddとしてDTO型にUserDataをマッピング
                UserDataDTO udd = new UserDataDTO();
                ud.UD2DTOMapping(udd);
                
                //DAOを使って検索結果がtrue(nameとpassword両方)ならuddに代入
                udd = UserDataDAO.getInstance().login(udd);
                
                //削除フラグが初期値(0)のままならログイン
                ud.DTO2UDMapping(udd);
                    if(ud.getDeleteflg()==0){
                        out.println("Login Complete!");
                
                //sessionに名前とパスワードを含む全てのデータを保存        
                        session.setAttribute("ud", ud);
                        out.println("test");
                        //リファラー
                        //response.sendRedirect(new URI(request.getHeader("referer")).getPath());
                        request.getRequestDispatcher("/top.jsp").forward(request, response);
                    }
                    else{
                        out.println("Login Failed!");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                        out.println("test");
                    }   
        }catch(Exception e){
        //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
           request.setAttribute("error", e.getMessage());
           request.getRequestDispatcher("/error.jsp").forward(request, response);
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
