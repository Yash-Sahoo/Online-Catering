<%
    session=request.getSession();
    String name=(String)session.getAttribute("userid");
    String n=(String)session.getAttribute("username");
    if(name==null){
        response.sendRedirect("index.jsp");
    }
%>


<!DOCTYPE html>
<html lang="en"><!-- Basic -->
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Site Metas -->
    <title>Online Caters and Services</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">    
	<!-- Site CSS -->
    <link rel="stylesheet" href="css/style.css">    
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/custom.css">

    

</head>

<body style="background: url(img3.jpg); background-size: 100% 130%; background-repeat:no-repeat;">
	<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="ownerDashboard.jsp">
                                    <img src="images/logo.png" alt="" height="80" width="300"/>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-rs-food" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
				  <span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-rs-food">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="ownerDashboard.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End header -->

        <hr>
        <br><br><br><br><br>
        <h2><font face="times new roman" size="7" color="red">Hello <%=n%></font></h2>
        <hr>
        <marquee bgcolor=black scrollamount="11"><font face="bookman old style" color=white>Any wrong information you found to be uploaded...Strict Actions will be taken by us for you. Actions by fssai Certification will be taken. Kindly be careful.</font></marquee>
        <hr>
        
        <a href="registerDetail.jsp"><font face="bookman old style" color="iron">Register-Details</font></a><br>
        <a href="ViewOwnDetails"><font face="bookman old style" color="iron">Your-Catering-Details</font></a><br>
        <a href="ViewOwnCateringforDelete"><font face="bookman old style" color="iron">Delete-Information</font></a><br>
        <a href="ProfileUpdate.jsp"><font face="bookman old style" color="iron">Update-Profile</font></a><br>
        <a href="contactInsideOfCater.jsp"><font face="bookman old style" color="iron">Post-Review</font></a><br>
       <!-- 
        <a href="odCopyForCertificate.jsp"><font face="bookman old style" color="iron">Upload-FSSAI-Certification</font></a><br>
        -->
        <hr>
	
	
	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
	<script src="js/jquery.superslides.min.js"></script>
	<script src="js/images-loded.min.js"></script>
	<script src="js/isotope.min.js"></script>
	<script src="js/baguetteBox.min.js"></script>
	<script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>
    <br>
    
</body>
</html>

