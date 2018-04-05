<%-- 
    Document   : profile.jsp
    Created on : Jul 21, 2017, 2:44:02 PM
    Author     : Dell
--%>


<%@page import="edu.ijse.lms.dto.ConfirmDTO"%>
<%@page import="edu.ijse.lms.dto.RequestDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1>Profile</h1>
        <script>
            documetnt.getElementById(frmrequest).style.visibility=<%=session.getAttribute("visibility")%>;
            
        </script>
        
        <form action="profile" method="POST" id="frmrequest">
            <table>
                <tr>
                    <td>Name : </td>
                    <td><input type="text" value="<%= session.getAttribute("username")%>" name="username"/></td>
                </tr>
                <tr>
                    <td>
                        Position :
                    </td>
                    <td>
                        <input type="text" value="<%=session.getAttribute("position")%>" name="position"/>
                    </td>
                </tr>
                <tr>
                    <td>Department : </td>
                    <td><input type="text" value="<%=session.getAttribute("department")%>" name="department"/></td>
                </tr>
                <tr>
                    <td>Email : </td>
                    <td><input type="text" value="<%=session.getAttribute("email")%>" name="email"/></td>
                </tr>
                <tr>
                    <td>Reason : </td>
                    <td><textarea name="reason"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="send"/> </td>

                </tr>
            </table>
        </form>
                <a href="Logout">Logout</a>
                
                  
        <%
            String position = (String) session.getAttribute("position");
            String department = (String) session.getAttribute("department");
            String email1=(String)session.getAttribute("email");
            ArrayList<RequestDTO> managerrequestlist = (ArrayList<RequestDTO>) application.getAttribute("departmentheadtoManager");
            ArrayList<RequestDTO> Itdepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Itdepartmentheadrequestlist");
             
            ArrayList<RequestDTO> Findepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Findepartmentheadrequestlist");
            ArrayList<RequestDTO> Hrdepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Hrdepartmentheadrequestlist");
            ArrayList<RequestDTO> Saldepartmentheadrequestlist = (ArrayList<RequestDTO>) application.getAttribute("Saldepartmentheadrequestlist");
            
            if (managerrequestlist != null||Itdepartmentheadrequestlist!=null||Findepartmentheadrequestlist!=null||Hrdepartmentheadrequestlist!=null||Saldepartmentheadrequestlist!=null) {
                if (position.equals("manager")) {
                    session.setAttribute("visibility","hidden");
                    for (RequestDTO r : managerrequestlist) {%>
                    <a href="RR?list=mrl&decision=true&position=manager&email=<%=r.getEmail()%>"><%= r.getUsername()%> Confirm</a>
                     <a href="RR?list=mrl&decision=false&position=manager&email=<%=r.getEmail()%>"><%= r.getUsername()%> Cancel</a>
             <%}%>
        <%} else if (position.equals("dh") & department.equals("IT")) {
                     for (RequestDTO r : Itdepartmentheadrequestlist) {%>
                     <a href="RS?list=itdhrl&email=<%=r.getEmail()%>" target="_self"><%= r.getUsername()%> Confirm</a><br>
                      <a href="RR?list=itdhrl&decision=true&position=dh&email=<%=r.getEmail()%>"target="_self"><%= r.getUsername()%> Cancel</a>
             <%}%>
             <%}else if(position.equals("dh")& department.equals("F")){
                    for(RequestDTO r:Findepartmentheadrequestlist){%>
                    <a href="RS?list=Fdhrl&email=<%=r.getEmail()%>"><%=r.getUsername()%> Confirm</a><br>
                     <a href="RR?list=Fdhrl&decision=true&position=dh&email=<%=r.getEmail()%>"><%= r.getUsername()%> Cancel</a>
                <%}%>

                <%}else if(position.equals("dh")& department.equals("HR")){
                      for(RequestDTO r:Hrdepartmentheadrequestlist){%>
                      <a href="RS?list=Hrdhrl&email=<%=r.getEmail()%>"><%=r.getUsername()%> Confirm</a><br>
                       <a href="RR?list=Hrdhrl&decision=true&position=dh&email=<%=r.getEmail()%>"><%= r.getUsername()%> Cancel</a>
                        <%}%>

                        <%}else if(position.equals("dh")& department.equals("Sal")){
                                for(RequestDTO r:Saldepartmentheadrequestlist){%>
                                <a href="RS?list=Sdhrl&email=<%=r.getEmail()%>"> <%=r.getUsername()%> Confirm</a><br>
                                 <a href="RR?list=Sdhrl&decision=true&position=dh&email=<%=r.getEmail()%>"><%= r.getUsername()%> Cancel</a>
                            <%}%>

                <%}%>
        <%}%>
        <%
            ArrayList<ConfirmDTO>respondlist=(ArrayList<ConfirmDTO>)application.getAttribute("respondlist");
            String email=(String)session.getAttribute("email");
            if(respondlist!=null){
                for(ConfirmDTO r:respondlist){
                   if(r.getEmail().equals(email)){%>
                   <%=r.getEmail()%><br>
                   <%=r.getPosition()%>
                  <%=r.isDecision()%>
                   <%}
                }
            }
        
        %>

    </body>
</html>
