/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

import edu.ijse.lms.dto.ConfirmDTO;
import edu.ijse.lms.dto.RequestDTO;
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
public class RequestReceiver extends HttpServlet {
    private boolean decision;
    PrintWriter out;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = getServletContext();
        String email = req.getParameter("email");
        String decision = req.getParameter("decision");
        String list=req.getParameter("list");
        String position=req.getParameter("position");
        out=resp.getWriter();
        
        
        ConfirmDTO respond=new ConfirmDTO(email,position,decision);
        
        ArrayList<RequestDTO> Managerrequestlist = (ArrayList<RequestDTO>) application.getAttribute("departmentheadtoManager");
        ArrayList<ConfirmDTO> respondlist = (ArrayList<ConfirmDTO>) application.getAttribute("respondlist");
        
        if(respondlist==null){
                respondlist=new ArrayList<>();
        }
        
        ArrayList<RequestDTO> Itdepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Itdepartmentheadrequestlist");
        ArrayList<RequestDTO> Findepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Findepartmentheadrequestlist");
        ArrayList<RequestDTO> Saldepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Saldepartmentheadrequestlist");
        ArrayList<RequestDTO> Hrdepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Hrdepartmentheadrequestlist");
        
        
        
        manageRequestReceiver(Managerrequestlist,respondlist,Itdepartmentheadrequestlist,Findepartmentheadrequestlist,Saldepartmentheadrequestlist,Hrdepartmentheadrequestlist,decision,list, email,position,respond);
        application.setAttribute("departmentheadtoManager", Managerrequestlist);
        application.setAttribute("respondlist", respondlist);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void manageRequestReceiver(ArrayList<RequestDTO>Managerrequestlist,ArrayList<ConfirmDTO> respondlist, ArrayList<RequestDTO> Itdepartmentheadrequestlist, ArrayList<RequestDTO> Findepartmentheadrequestlist, ArrayList<RequestDTO> Saldepartmentheadrequestlist, ArrayList<RequestDTO> Hrdepartmentheadrequestlist, String decision, String list, String email, String position, ConfirmDTO respond) {
         if (list.equals("itdhrl")) {
            for (int i = 0; i < Itdepartmentheadrequestlist.size(); i++) {
                if (Itdepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    respondlist.add(respond);
                    Itdepartmentheadrequestlist.remove(i);
                   print();
                }
            }
        } else if (list.equals("Fdhrl")) {
            for (int i = 0; i < Findepartmentheadrequestlist.size(); i++) {
                if (Findepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                   respondlist.add(respond);
                    Findepartmentheadrequestlist.remove(i);
                   print();
                }
            }

        } else if (list.equals("Sdhrl")) {
            for (int i = 0; i < Saldepartmentheadrequestlist.size(); i++) {
                if (Saldepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    respondlist.add(respond);
                    Saldepartmentheadrequestlist.remove(i);
                    print();
                }
            }
        } else if (list.equals("Hrdhrl")) {
            for (int i = 0; i < Hrdepartmentheadrequestlist.size(); i++) {
                if (Hrdepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    respondlist.add(respond);
                    Hrdepartmentheadrequestlist.remove(i);
                    print();
                }
            }
        }else if(list.equals("mrl")){
             for(int i=0;i<Managerrequestlist.size();i++){
                if(Managerrequestlist.get(i).getEmail().equals(email)){
                    respondlist.add(respond);
                    Managerrequestlist.remove(i);
                   print();
                }
             }
        } 
    }

    private void print(){
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
