/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

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
public class RequestSender extends HttpServlet {
    HttpServletRequest req;
    HttpServletResponse resp;
    PrintWriter out;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = getServletContext();
        String email = req.getParameter("email");
        String list = req.getParameter("list");
        this.req=req;
        this.resp=resp;
        out=resp.getWriter();
        ArrayList<RequestDTO> Managerrequestlist = (ArrayList<RequestDTO>) application.getAttribute("departmentheadtoManager");
        ArrayList<RequestDTO> Itdepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Itdepartmentheadrequestlist");
        ArrayList<RequestDTO> Findepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Findepartmentheadrequestlist");
        ArrayList<RequestDTO> Saldepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Saldepartmentheadrequestlist");
        ArrayList<RequestDTO> Hrdepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Hrdepartmentheadrequestlist");

        
        if (Managerrequestlist == null) {
            Managerrequestlist = new ArrayList<>();
        }
        if (Itdepartmentheadrequestlist == null) {
            Itdepartmentheadrequestlist = new ArrayList<>();
        }
        if (Findepartmentheadrequestlist == null) {
            Findepartmentheadrequestlist = new ArrayList<>();
        }
        if (Saldepartmentheadrequestlist == null) {
            Saldepartmentheadrequestlist = new ArrayList<>();
        }
        if (Hrdepartmentheadrequestlist == null) {
            Hrdepartmentheadrequestlist = new ArrayList<>();
        }
        
        RequestSenderManager(Managerrequestlist, Itdepartmentheadrequestlist, Findepartmentheadrequestlist, Saldepartmentheadrequestlist, Hrdepartmentheadrequestlist, email, list);

        application.setAttribute("departmentheadtoManager", Managerrequestlist);
        application.setAttribute("Itdepartmentheadrequestlist", Itdepartmentheadrequestlist);
        application.setAttribute("Findepartmentheadrequestlist", Findepartmentheadrequestlist);
        application.setAttribute("Saldepartmentheadrequestlist", Saldepartmentheadrequestlist);
        application.setAttribute("Hrdepartmentheadrequestlist", Hrdepartmentheadrequestlist);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void RequestSenderManager(ArrayList<RequestDTO> Managerrequestlist, ArrayList<RequestDTO> Itdepartmentheadrequestlist, ArrayList<RequestDTO> Findepartmentheadrequestlist, ArrayList<RequestDTO> Saldepartmentheadrequestlist, ArrayList<RequestDTO> Hrdepartmentheadrequestlist, String email, String list) throws ServletException, IOException {
        if (list.equals("itdhrl")) {
            for (int i = 0; i < Itdepartmentheadrequestlist.size(); i++) {
                if (Itdepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    Managerrequestlist.add(Itdepartmentheadrequestlist.get(i));
                    Itdepartmentheadrequestlist.remove(i);
                   print();
                }
            }
        } else if (list.equals("Fdhrl")) {
            for (int i = 0; i < Findepartmentheadrequestlist.size(); i++) {
                if (Findepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    Managerrequestlist.add(Findepartmentheadrequestlist.get(i));
                    Findepartmentheadrequestlist.remove(i);
                  print();
                }
            }

        } else if (list.equals("Sdhrl")) {
            for (int i = 0; i < Saldepartmentheadrequestlist.size(); i++) {
                if (Saldepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    Managerrequestlist.add(Saldepartmentheadrequestlist.get(i));
                    Saldepartmentheadrequestlist.remove(i);
                  print();
                }
            }
        } else if (list.equals("Hrdhrl")) {
            for (int i = 0; i < Hrdepartmentheadrequestlist.size(); i++) {
                if (Hrdepartmentheadrequestlist.get(i).getEmail().equals(email)) {
                    Managerrequestlist.add(Hrdepartmentheadrequestlist.get(i));
                    Hrdepartmentheadrequestlist.remove(i);
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
