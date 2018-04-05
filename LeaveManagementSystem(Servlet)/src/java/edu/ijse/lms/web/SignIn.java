/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

import edu.ijse.lms.dto.RegisterDTO;
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
public class SignIn extends HttpServlet {

    private String message;
    PrintWriter out;
    HttpServletRequest req;
    HttpServletResponse resp;
    String department,username,position,email; 
    HttpSession session;
    ServletContext application;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         application = getServletContext();
        session = req.getSession();
        this.req = req;
        this.resp = resp;
        out = resp.getWriter();
        String email = req.getParameter("mail");
        String password = req.getParameter("upassword");

        UserDTO signinuser = new UserDTO(email, password);

        ArrayList<RegisterDTO> combinedlist = (ArrayList<RegisterDTO>) application.getAttribute("combinedlist");
        ArrayList<UserDTO> onlineusers = (ArrayList<UserDTO>) application.getAttribute("onlineusers");
        if (onlineusers == null) {
            onlineusers = new ArrayList<>();
        }
       // if(isLoged(onlineusers, signinuser)& isUserOk(signinuser, combinedlist)&onlineusercheck(onlineusers,email,signinuser)){
     
        loginProcessManager(signinuser, combinedlist, onlineusers);
          
       
       // getServletConfig().getServletContext().getRequestDispatcher("/profile.jsp").forward(req, resp);
       // }else{}
        application.setAttribute("onlineusers", onlineusers);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void loginProcessManager(UserDTO signinuser, ArrayList<RegisterDTO> combinedlist, ArrayList<UserDTO> onlineusers) throws ServletException, IOException {
        if (combinedlist == null) {
            message = "No one signup to the system";
              print(message);
        } else {
            if (isUserOk(signinuser, combinedlist)) {
                if (isLoged(onlineusers, signinuser)) {
                    onlineusers.add(signinuser);
                       
                    getServletConfig().getServletContext().getRequestDispatcher("/pro.jsp").forward(req, resp);
                } else {
                    message = "user already signin to the system...";
                    print(message);
                }
            } else {
                message = "invalid  user";
                print(message);
               
            }
        }
    }

    private boolean isUserOk(UserDTO signinuser, ArrayList<RegisterDTO> combinedlist) {
        for (int i = 0; i < combinedlist.size(); i++) {
            if (combinedlist.get(i).getEmail().equals(signinuser.getEmail()) & combinedlist.get(i).getPassword().equals(signinuser.getPassword())) {
                department=combinedlist.get(i).getDepartment();
                username=combinedlist.get(i).getUsername();
                position=combinedlist.get(i).getPosition();
                email=combinedlist.get(i).getEmail();
                session.setAttribute("department", department);
                session.setAttribute("username", username);
                session.setAttribute("position", position);
                session.setAttribute("email", email);
                return true;
            }
        }
        return false;
    }

    private boolean isLoged(ArrayList<UserDTO> onlineusers, UserDTO signinuser) {
        for (int i = 0; i < onlineusers.size(); i++) {
            if (onlineusers.get(i).getEmail().equals(signinuser.getEmail())) {
                return false;
            }
        }
        return true;
    }

    private boolean onlineusercheck(ArrayList<UserDTO> onlineusers, String email, UserDTO signinuser) {
       for(int i=0;i<onlineusers.size();i++){
          if(onlineusers.get(i).getEmail().equals(email)){
               onlineusers.add(i, signinuser);
                 application.setAttribute("onlineusers", onlineusers);
               return true;
          }else if(isnothere(onlineusers,email,signinuser)){
              onlineusers.add(signinuser);
                application.setAttribute("onlineusers", onlineusers);
          }
       }
       return true;
    }

    private boolean isnothere(ArrayList<UserDTO> onlineusers, String email, UserDTO signinuser) {
        for(int i=0;i<onlineusers.size();i++){
           if(!onlineusers.get(i).getEmail().equals(email)){
             return true;
           }
        }
        return false;
    }
      private void print(String message){
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
"<div class=\"alert alert-danger alert-dismissable\">\n" +
"    <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>\n" +
"    <strong>Error!\t\t\t\t"+message+"</strong> \n" +
"  </div>\n" +
"   \n" +
"</div>\n" +
"</body>\n" +
"</html>");
      
      }
}
