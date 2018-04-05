<%-- 
    Document   : index
    Created on : Jun 15, 2017, 2:39:40 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  
  
  
      <link rel="stylesheet" href="css1/style.css">

  
</head>

<body>

    
    
    
    
  <div id="clouds">
	<div class="cloud x1"></div>
	<!-- Time for multiple clouds to dance around -->
	<div class="cloud x2"></div>
	<div class="cloud x3"></div>
	<div class="cloud x4"></div>
	<div class="cloud x5"></div>
</div>

 <div class="container">


      <div id="login">
          
          <form method="post" action="login">

          <fieldset class="clearfix">

              <p><span class="fontawesome-user"></span><input type="text" value="Username" name="mail" onBlur="if(this.value == '') this.value = 'Username'" onFocus="if(this.value == 'Username') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Username" -->
              <p><span class="fontawesome-lock"></span><input type="password"  value="Password" name="upassword"   onBlur="if(this.value == '') this.value = 'Password'" onFocus="if(this.value == 'Password') this.value = ''" required></p> <!-- JS because of IE support; better: placeholder="Password" -->
            <p><input type="submit" value="Sign In"></p>

          </fieldset>

        </form>

        
      </div> <!-- end login -->

    </div>
    <div class="bottom">  <h5><a href="signup.html">Signup</a></h5></div>
  

</body>
</html>

