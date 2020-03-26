<%
    session=request.getSession();
    String name=(String)session.getAttribute("userid");
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

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body style="background: url(adminpage.jpg); background-size: 100% 130%; background-repeat:no-repeat;">
	<!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="adminDashboard.jsp">
                                    <img src="images/logo.png" alt="" height="80" width="300"/>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-rs-food" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
				  <span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-rs-food">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="adminDashboard.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End header -->

        <hr>
        <br><br><br><br><br>
        <h2><font face="times new roman" size="7" color="red">Hello Admin</font></h2>
        <hr>

        <a href="BlockCustomer"><font face="algerian" size="5" color="blue">Block-Customers</font></a><br>
        <a href="BlockOwner"><font face="algerian" size="5" color="blue">Block-Caters</font></a><br>
        
        <a href="ShowUnactivatedOwners"><font face="bookman old style" size="5" color="blue">Unactivated-Caters</font></a><br>
        <a href="ShowUnactivatedCustomers"><font face="bookman old style" size="5" color="blue">Unactivated-Customers</font></a><br><hr>
        <a href="ShowActivatedOwners"><font face="bookman old style" size="5" color="blue">Activated-Caters</font></a><br>
        <a href="ShowActivatedCustomers"><font face="bookman old style" size="5" color="blue">Activated-Customers</font></a><br><hr>
        <a href="ShowAllDetails"><font face="Lucida Handwriting" size="5" color="blue">View-All-Caters-Information</font></a><br>
        <a href="viewFeed"><font face="times new roman" size="5" color="blue">View-Feedback-Of-Users</font></a><br>
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
    <br><br><br>
    <marquee bgcolor=black scrollamount="10"><font face="bookman old style" color=white>Caters and Customers needs to verified fast to increase the efficiency of Portal. Special attention given to Cater for the verification of fssai Certificate.</font></marquee>
</body>
</html>

