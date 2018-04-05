<%-- 
    Document   : pro
    Created on : Jul 28, 2017, 11:33:03 AM
    Author     : Dell
--%>

<%@page import="edu.ijse.lms.dto.ConfirmDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.ijse.lms.dto.RequestDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/stylesheet.css"/>
        <script src="script/script.js"></script>
    </head>


    <body onload="visualizer()">

        <div class="container">
            <div class="span6" id="header">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>                        
                            </button>
                            <a class="navbar-brand" href="#">Trancendance</a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">

                            <ul class="nav navbar-nav navbar-right">
                                <li><a id="myBtn"><span class="glyphicon glyphicon-user"></span>Send</a></li>
                                <li><a href="Logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>

            <!-- Trigger the modal with a button -->


            <ul class="nav nav-tabs">
                <li class="active"><a href="#home">Profile</a></li>
                <li><a href="#menu1">Scheduler</a></li>
              
                <li><a href="#menu3">Request List</a></li>
            </ul>

            <div class="tab-content">

                <div id="home" class="tab-pane fade in active">

                    <div class="panel panel-default" id="transp">

                        <div class="panel-body">
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="position">Name:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="username" placeholder="Name" name="username" value="<%= session.getAttribute("username")%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="department">Department:</label>
                                <div class="col-sm-10">          
                                    <input type="text" class="form-control" id="department" placeholder="Department" name="department" value="<%=session.getAttribute("department")%>" readonly>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4" for="position">Position:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="position" placeholder="Position" name="position" value="<%=session.getAttribute("position")%>" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4" for="department">Email:</label>
                                <div class="col-sm-10">          
                                    <input type="email" class="form-control" id="email" placeholder="Email" name="email" value="<%=session.getAttribute("email")%>" readonly>
                                </div>
                            </div>


                        </div>
                    </div>



                </div>
                <div id="menu1" class="tab-pane fade">

                    <div class="panel panel-default" id="transp1">

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-4">
                                    <form name="sc" onsubmit="return false;">
                                    <table class="table table-hover">
                                        <tr>
                                            <td>Work</td>
                                            <td><input type="text" id="work" name="work" ></td>
                                        </tr>
                                        <tr>
                                            <td>Start Date</td>
                                            <td><input type="date" id="startdate" name="startdate"></td>
                                        </tr>
                                         <tr>
                                            <td>Start Time</td>
                                            <td><input type="time" id="starttime" name="starttime" ></td>
                                        </tr>
                                        <tr>
                                            <td>Due Date</td>
                                            <td><input type="date" id="duedate" name="duedate" ></td>
                                        </tr>
                                         <tr>
                                            <td>Due Time</td>
                                            <td><input type="time" id="duetime" name="duetime"></td>
                                        </tr>
                                         <tr>
                                             <td colspan="2" align="right" ><button class="btn btn-info" onclick="loadTable();">Add</button></td>
                                        </tr>
                                    </table>
                                    </form>
                                </div>
                                <div class="col-sm-8">
                                    <table class="table" id="sct">
                                        <tr>
                                        <th>Work</th>
                                         <th>Start Date</th>
                                          <th>Start Time</th>
                                           <th>Due Date</th>
                                            <th>Due Time</th>
                                        </tr>
                                        
                                    </table>
                                    
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
              
                <div id="menu3" class="tab-pane fade">
                    <div class="panel panel-default" id="transp3">

                        <div class="panel-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    
                                   
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
                    <div class="alert alert-success alert-dismissable">
                        
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>

                    <table class="table table-hover">
                        <tr>
                            <td>Name :</td><td><%=r.getUsername()%></td>
                        <tr>
                        <tr>
                            <td>Position :</td><td><%=r.getPosition()%></td>
                        </tr>
                        <tr>
                            <td>Department:</td><td><%=r.getDepartment()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td><td><%=r.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Reason:</td><td><%=r.getReason()%></td>
                       </tr>
                       <tr>
                           <td><a class="btn btn-success" href="RR?list=mrl&decision=confirm&position=manager&email=<%=r.getEmail()%>"> Confirm</a></td>
                           <td><a class="btn btn-danger" href="RR?list=mrl&decision=reject&position=manager&email=<%=r.getEmail()%>"> Cancel</a></td>
        </tr>
                    </table>
                    </div>
             <%}%>
        <%} else if (position.equals("dh") & department.equals("IT")) {
                     for (RequestDTO r : Itdepartmentheadrequestlist) {%>
                      <div class="alert alert-success alert-dismissable">
                        
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                      <table class="table table-hover">
                        <tr>
                            <td>Name :</td><td><%=r.getUsername()%></td>
                        <tr>
                        <tr>
                            <td>Position :</td><td><%=r.getPosition()%></td>
                        </tr>
                        <tr>
                            <td>Department:</td><td><%=r.getDepartment()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td><td><%=r.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Reason:</td><td><%=r.getReason()%></td>
                       </tr>
                       <tr>
                           <td><a class="btn btn-success" href="RS?list=itdhrl&email=<%=r.getEmail()%>" target="_self"> Confirm</a></td>
                           <td><a class="btn btn-danger" href="RR?list=itdhrl&decision=reject&position=dh&email=<%=r.getEmail()%>"target="_self"> Cancel</a></td>
                      
                        </tr>
                    </table>
                      </div>
             <%}%>
             <%}else if(position.equals("dh")& department.equals("F")){
                    for(RequestDTO r:Findepartmentheadrequestlist){%>
                     <div class="alert alert-success alert-dismissable">
                        
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                    <table class="table table-hover">
                        <tr>
                            <td>Name :</td><td><%=r.getUsername()%></td>
                        <tr>
                        <tr>
                            <td>Position :</td><td><%=r.getPosition()%></td>
                        </tr>
                        <tr>
                            <td>Department:</td><td><%=r.getDepartment()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td><td><%=r.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Reason:</td><td><%=r.getReason()%></td>
                       </tr>
                       <tr>
                           <td><a class="btn btn-success" href="RS?list=Fdhrl&email=<%=r.getEmail()%>"> Confirm</a></td>
                           <td><a class="btn btn-danger" href="RR?list=Fdhrl&decision=reject&position=dh&email=<%=r.getEmail()%>"> Cancel</a></td>
                     
                         </tr>
                    </table>
                     </div>
                <%}%>

                <%}else if(position.equals("dh")& department.equals("HR")){
                      for(RequestDTO r:Hrdepartmentheadrequestlist){%>
                       <div class="alert alert-success alert-dismissable">
                        
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                       <table class="table table-hover">
                        <tr>
                            <td>Name :</td><td><%=r.getUsername()%></td>
                        <tr>
                        <tr>
                            <td>Position :</td><td><%=r.getPosition()%></td>
                        </tr>
                        <tr>
                            <td>Department:</td><td><%=r.getDepartment()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td><td><%=r.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Reason:</td><td><%=r.getReason()%></td>
                       </tr>
                       <tr>
                           <td><a class="btn btn-success" href="RS?list=Hrdhrl&email=<%=r.getEmail()%>"> Confirm</a></td>
                           <td><a class="btn btn-danger" href="RR?list=Hrdhrl&decision=reject&position=dh&email=<%=r.getEmail()%>">Cancel</a></td>
                       
                        </tr>
                    </table>
                       </div>
                        <%}%>

                        <%}else if(position.equals("dh")& department.equals("Sal")){
                                for(RequestDTO r:Saldepartmentheadrequestlist){%>
                                 <div class="alert alert-success alert-dismissable">
                        
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                                    <table class="table table-hover">
                        <tr>
                            <td>Name :</td><td><%=r.getUsername()%></td>
                        <tr>
                        <tr>
                            <td>Position :</td><td><%=r.getPosition()%></td>
                        </tr>
                        <tr>
                            <td>Department:</td><td><%=r.getDepartment()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td><td><%=r.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Reason:</td><td><%=r.getReason()%></td>
                       </tr>
                       <tr>
                           <td><a class="btn btn-success" href="RS?list=Sdhrl&email=<%=r.getEmail()%>"> <%=r.getUsername()%> Confirm</a></td>
                           <td>    <a class="btn btn-danger" href="RR?list=Sdhrl&decision=reject&position=dh&email=<%=r.getEmail()%>"><%= r.getUsername()%> Cancel</a></td>
                                   </tr>
                    </table>
                                 </div>
                            <%}%>

                <%}%>
        <%}%>

                                  
                                </div>
                                <div class="col-sm-6">
                                   
        <%
            ArrayList<ConfirmDTO>respondlist=(ArrayList<ConfirmDTO>)application.getAttribute("respondlist");
            String email=(String)session.getAttribute("email");
            if(respondlist!=null){
                for(ConfirmDTO r:respondlist){
                   if(r.getEmail().equals(email)){%>
                   <div class="alert alert-success alert-dismissable">
                       
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                   <table class="table table-hover" >                     
                       <tr>
                           <td>Responder</td><td><%=r.getPosition()%></td>
                       </tr>
                       <tr>
                           <td>Decision</td><td><%=r.isDecision()%></td>
                       </tr>
                        <tr>
                            <td>Confirm</td><td><a class="btn btn-warning" href="seen?email=<%=r.getEmail()%>">OK</a></td>
                       </tr>
                   </table>
                   </div>
                   <%}
                }
            }
        
        %>

                                </div>
                            </div>


                        </div>
                    </div>


                </div>
            </div>




            <script>

                $(document).ready(function () {
                    $(".nav-tabs a").click(function () {
                        $(this).tab('show');
                    });
                });
            </script>

































            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Request Sender</h4>
                        </div>

                        <div class="modal-body">
                            <form class="form-horizontal" action="profile" method="POST" name="sct">
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="username">Name:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="username" placeholder="Username" name="username" value="<%= session.getAttribute("username")%>" readonly="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="position">Position:</label>
                                    <div class="col-sm-10">
                                        <input type="text" class="form-control" id="position" placeholder="Position" name="position" value="<%=session.getAttribute("position")%>" readonly="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="department">Department:</label>
                                    <div class="col-sm-10">          
                                        <input type="text" class="form-control" id="department" placeholder="Department" value="<%=session.getAttribute("department")%>" name="department" readonly="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="email">Email:</label>
                                    <div class="col-sm-10">
                                        <input type="email" class="form-control" id="email" placeholder="Enter email" value="<%=session.getAttribute("email")%>" name="email" readonly="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2" for="reason">Reason:</label>
                                    <div class="col-sm-10">
                                        <textarea class="form-control" name="reason"></textarea>
                                    </div>
                                </div>

                                <div class="form-group">        
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="submit" class="btn btn-default">Submit</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

        </div>

        <script>
            $(document).ready(function () {
                $("#myBtn").click(function () {
                    $("#myModal").modal();
                });
            });
        </script>
    </body>
</html>
