/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

import edu.ijse.lms.dto.RequestDTO;
import java.io.IOException;
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
public class Profile extends HttpServlet {

    ServletContext application;
    HttpServletRequest req;
    HttpServletResponse resp;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        application = getServletContext();
        this.req=req;
        this.resp=resp;
        String username = req.getParameter("username");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
        String email = req.getParameter("email");
        String reason = req.getParameter("reason");

        RequestDTO request = new RequestDTO(username, position, department, email, reason);

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

        requestProcessManager(Managerrequestlist, Itdepartmentheadrequestlist, Findepartmentheadrequestlist, Saldepartmentheadrequestlist, Hrdepartmentheadrequestlist, request);

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

    private void requestProcessManager(ArrayList<RequestDTO> Managerrequestlist, ArrayList<RequestDTO> Itdepartmentheadrequestlist, ArrayList<RequestDTO> Findepartmentheadrequestlist, ArrayList<RequestDTO> Saldepartmentheadrequestlist, ArrayList<RequestDTO> Hrdepartmentheadrequestlist, RequestDTO request) throws ServletException, IOException {
        if (request.getPosition().equals("dh")) {
            
            Managerrequestlist.add(request);
            getServletConfig().getServletContext().getRequestDispatcher("/pro.jsp").forward(req, resp);
            
        } else if (request.getDepartment().equals("IT") & request.getPosition().equals("employee")) {
            
            Itdepartmentheadrequestlist.add(request);
            getServletConfig().getServletContext().getRequestDispatcher("/pro.jsp").forward(req, resp);
            
        } else if (request.getDepartment().equals("F") & request.getPosition().equals("employee")) {
            
            Findepartmentheadrequestlist.add(request);
            getServletConfig().getServletContext().getRequestDispatcher("/pro.jsp").forward(req, resp);
            
        } else if (request.getDepartment().equals("Sal") & request.getPosition().equals("employee")) {
            
            Saldepartmentheadrequestlist.add(request);
            getServletConfig().getServletContext().getRequestDispatcher("/pro.jsp").forward(req, resp);
            
        } else if (request.getDepartment().equals("HR") & request.getPosition().equals("employee")) {
            
            Hrdepartmentheadrequestlist.add(request);
            getServletConfig().getServletContext().getRequestDispatcher("/pro.jsp").forward(req, resp);
        }
    }

}
