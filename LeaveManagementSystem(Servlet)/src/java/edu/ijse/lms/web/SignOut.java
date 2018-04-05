/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

import edu.ijse.lms.dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
public class SignOut extends HttpServlet {
 PrintWriter out;
 HttpServletRequest req;
 HttpServletResponse resp;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req=req;
        this.resp=resp;
        out=resp.getWriter();
        ServletContext application=getServletContext();
        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        ArrayList<UserDTO>onlineuser=(ArrayList<UserDTO>) application.getAttribute("onlineusers");
        logoutManager(onlineuser,email);
        application.setAttribute("onlineusers", onlineuser);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void logoutManager(ArrayList<UserDTO> onlineuser, String email) throws ServletException, IOException {
       for(int i=0;i<onlineuser.size();i++){
           if(onlineuser.get(i).getEmail().equals(email)){
               onlineuser.remove(i);
               getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
           }
       }
    }
    
    
}
