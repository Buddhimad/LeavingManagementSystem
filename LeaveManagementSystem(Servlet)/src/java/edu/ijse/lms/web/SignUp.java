/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.lms.web;

import edu.ijse.lms.dto.RegisterDTO;
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
public class SignUp extends HttpServlet {

    private String message;
    HttpServletRequest req;
    HttpServletResponse resp;
    PrintWriter out;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        out = resp.getWriter();
        ServletContext application = getServletContext();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String position = req.getParameter("position");
        String department = req.getParameter("department");

        this.req = req;
        this.resp = resp;

        RegisterDTO newuser = new RegisterDTO(username, password, email, position, department);

        ArrayList<RegisterDTO> managerlist = (ArrayList<RegisterDTO>) application.getAttribute("managerlist");
        ArrayList<RegisterDTO> dhlist = (ArrayList<RegisterDTO>) application.getAttribute("dhlist");
        ArrayList<RegisterDTO> elist = (ArrayList<RegisterDTO>) application.getAttribute("elist");
        ArrayList<RegisterDTO> combinedlist = (ArrayList<RegisterDTO>) application.getAttribute("combinedlist");

        if (managerlist == null) {
            managerlist = new ArrayList<>();

        }
        if (dhlist == null) {
            dhlist = new ArrayList<>();

        }
        if (elist == null) {
            elist = new ArrayList<>();
        }
        if (combinedlist == null) {
            combinedlist = new ArrayList<>();
        }

        processManager(managerlist, dhlist, elist, combinedlist, position, newuser);

        application.setAttribute("managerlist", managerlist);
        application.setAttribute("dhlist", dhlist);
        application.setAttribute("elist", elist);
        application.setAttribute("combinedlist", combinedlist);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void processManager(ArrayList<RegisterDTO> managerlist, ArrayList<RegisterDTO> dhlist, ArrayList<RegisterDTO> elist, ArrayList<RegisterDTO> combinedlist, String position, RegisterDTO newuser) throws ServletException, IOException {
        if (position.equals("manager")) {
            if (managerlist.size() < 1) {
                if (isSignUp(combinedlist, newuser)) {
                    managerlist.add(newuser);
                    combinedlist.add(newuser);
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {
                    message = "this user already signupto the system with different account";
                    out.println(message);
                }
            } else {
                message = "Already manager signup to the system";
                out.println(message);
            }

        } else if (position.equals("dh")) {
            if (dhlist.size() < 4) {
                if (isDHUnique(dhlist, newuser)) {
                    if (isSignUp(combinedlist, newuser)) {
                        dhlist.add(newuser);
                        combinedlist.add(newuser);
                        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                    } else {
                        message = "this user already signupto the system with different account";
                        out.println(message);
                    }
                } else {
                    message = "Departmenthead already signUp to the system";
                    out.println(message);
                }
            } else {
                message = "All department heads are signup to the system";
                out.println(message);
            }

        } else if (position.equals("employee")) {
            if (isEmpUnique(elist, newuser)) {
                if (isSignUp(combinedlist, newuser)) {
                    elist.add(newuser);
                    combinedlist.add(newuser);
                    getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
                } else {
                    message = "this user already signupto the system with different account";
                    out.println(message);
                }
            } else {
                message = "Employee already sign in to the system...";
                out.println(message);
            }
        }
    }

    private boolean isDHUnique(ArrayList<RegisterDTO> dhlist, RegisterDTO newuser) {
        for (int i = 0; i < dhlist.size(); i++) {
            if (dhlist.get(i).getDepartment().equals(newuser.getDepartment())) {
                return false;
            }
        }
        return true;
    }

    private boolean isEmpUnique(ArrayList<RegisterDTO> elist, RegisterDTO newuser) {
        for (int i = 0; i < elist.size(); i++) {
            if (elist.get(i).getEmail().equals(newuser.getEmail())) {
                return false;
            }
        }
        return true;
    }

    private boolean isSignUp(ArrayList<RegisterDTO> combinedlist, RegisterDTO newuser) {
        for (int i = 0; i < combinedlist.size(); i++) {
            if (combinedlist.get(i).getEmail().equals(newuser.getEmail())) {
                return false;
            }
        }
        return true;
    }

}
