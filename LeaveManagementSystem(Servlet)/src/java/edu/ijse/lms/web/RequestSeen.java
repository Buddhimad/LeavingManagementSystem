/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

import edu.ijse.lms.dto.ConfirmDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class RequestSeen extends HttpServlet{
    PrintWriter out;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String email=req.getParameter("email");
        ServletContext application=getServletContext();
        out=resp.getWriter();
        ArrayList<ConfirmDTO>respondlist=(ArrayList<ConfirmDTO>) application.getAttribute("respondlist");
        
        removeRespond(respondlist,email);
        
        application.setAttribute("respondlist", respondlist);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    private void removeRespond(ArrayList<ConfirmDTO> respondlist, String email) {
      for(int i=0;i<respondlist.size();i++){
          if(respondlist.get(i).getEmail().equals(email)){
              respondlist.remove(i);
               out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"  <title></title>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n" +
" <link rel=\"stylesheet\" href=\"css/stylesheet.css\"/></head>\n" +
"<body>\n" +
"<div class=\"container\">\n" +
"<div class=\"alert alert-success alert-dismissable\">\n" +
"    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>\n" +
"    <strong>Success!</strong> \n" +
"  </div>\n" +
"   \n" +
"</div>\n" +
"</body>\n" +
"</html>");
          }
      }  
    }
    
    
    
    
}
