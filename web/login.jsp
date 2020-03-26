<%
    String v1 = "", v2 = "", v3 = "";
    Cookie ck[] = request.getCookies();
    if (ck != null) {
        for (Cookie c : ck) {
            String s = c.getName();
            if (s.equals("id")) {
                v1 = c.getValue();
            } else if (s.equals("pwd")) {
                v2 = c.getValue();
            } else if (s.equals("utype")) {
                v3 = c.getValue();
            }
        }
    }
%>


<html lang="en">
    <head>
        <title>Login Page | Online Cater Service</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100">
                    <form class="login100-form validate-form" action="VerifyUser" method="get">
                        <span class="login100-form-logo">
                            <i class="zmdi zmdi-landscape"></i>
                        </span>

                        <span class="login100-form-title p-b-34 p-t-27">
                            Log in
                        </span>
                        <pre>
	<font color="white">				
	Email ID    <input type="email" id="t1" name="email" value="<%=v1%>" placeholder="Email" required/><br>
	Password    <input type="password" id="t2" name="password" value="<%=v2%>" placeholder="Password" required/><br>
        User Type   <select name="utype" value="<%=v3%>">
                        <option>customer</option>
                        <option>cater</option>
                        <option>admin</option>
                    </select>
                
                Save Password <input type="checkbox" name="save" value="yes"/><br>
        </font>
                        </pre>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn">
                                <input type="submit" value="Login"/>
                            </button>
                        </div>

                        <div class="text-center p-t-90">
                            <a class="txt1" href="#">
                                Forgot Password?
                            </a>
                        </div>
                    </form>
                    <a href="index.jsp" title="Home">
                        <center><font color="white">Home</font></center>
                    </a>
                        <a href="register.jsp" title="Signup">
                        <center><font color="white">Don't have Account! Needs Signup?</font></center>
                    </a>

                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

    </body>
</html>