<%
    session=request.getSession();
    
%>
<html>
    <script>
        function checkAll(){
            var b1=checkemail();
            var b2=checkpassword();
            var b3=checkname();
            var b4=hno();
            var b5=street();
            var b6=mobileNo();
            return (b1 && b2 && b3 && b4 && b5 && b6);
        }
        function checkemail(){
            var email=document.getElementById("mail").value;
            if(email.length!==0){
                return true;
            }else{
                alert("Enter email id");
                return false;
            }
        }
        function checkpassword(){
            var pass=document.getElementById("pw").value;
            if(pass.length>=3){
                return true;
            }else{
                alert("password must be atleast 3 characters");
                return false;
            }
        }
        function checkname(){
            var nam=document.getElementById("nam").value;
            if(nam.length===0){
                alert("Enter Your Name");
                return false;
            }else{
                return true;
            }
        }
        function hno(){
            var hn=document.getElementById("hn").value;
            if(hn.length===0){
                alert("Enter Your House Number!");
                return false;
            }else{
                return true;
            }
        }
        function street(){
            var str=document.getElementById("street").value;
            if(str.length===0){
                alert("Enter Your Street Details!");
                return false;
            }else{
                return true;
            }
        }
        function mobileNo(){
            var mob=document.getElementById("mno").value;
            if(isNaN(mob)){
                alert("Mobile Number must be Numeric Value");
                return false;
            }else{
                if(mob.length<10 || mob.length>10){
                    alert("Please enter a valid Mobile Number");
                    return false;
                }else{
                    return true;
                }
            }
        }
    </script>
    <body  style="background: url(img2.jpg); background-size: 100% 100%;">
    <center><h3><font size="6" face="lucida console" color="red"><i><u>Online Caters and Services</u></i></font></h3></center>
    <hr>
    <br>
    <center>
    <font>
        <h3><font size="5" face="bookman old style" color="magenta">Registration Form</font></h3>
    <form action="SaveUser" method="post" onsubmit="return checkAll()"  enctype="multipart/form-data">
        <pre>
    <font face="bookman old style" color="black"> Email ID </font> <input placeholder="Email" type="email" id="mail" name="email"/><br>
    <font face="bookman old style" color="black"> Password </font> <input placeholder="Password" type="password" id="pw" name="password"/><br>
    <font face="bookman old style" color="black"> Name     </font> <input placeholder="Name" type="text" id="nam" name="name"/><br>
    <font face="bookman old style" color="black"> User Type </font>    <select name="utype">
                                                                       <option>customer</option>
                                                                       <option>cater</option>
                                                                       </select><br>
    <font face="bookman old style" color="black"> H.No.    </font>  <input placeholder="Home No." type="text" id="hn" name="hno"/><br>
    <font face="bookman old style" color="black"> Street   </font>  <input placeholder="Street" type="text" id="street" name="street"/><br>
    <font face="bookman old style" color="black"> City     </font>  <input placeholder="City" type="text" name="city"/><br>

    <font face="bookman old style" color="black"> State    </font>  <input placeholder="State" type="text" name="state"/><br>

    <font face="bookman old style" color="black"> Country  </font>  <input placeholder="Country" type="text" name="country"/><br>
    <font face="bookman old style" color="black"> Mobile No </font> <input placeholder="Mobile No." type="text" id="mno" name="mobile"/><br>
    
    <font face="bookman old style" color="black"> fssai Certificate <b>(*Only for Cater*)</b></font> <input type="file" name="cert"/><br>
    <font face="bookman old style" color="black"> ***fssai Certification is compulsory for Cater to access this portal***</font><br>
  <input type="submit" value="Register"/>
        </pre>
    </form>
        </font>
    </center>
    <hr>
    <center>
        <a href="index.jsp"><font face="bookman old style" color="black">Home</font></a><br><br>
    </center>
    <marquee bgcolor=blue scrollamount="10"><font face="bookman old style" color=white>Note: Customer Attention - Not to fill fssai certificate...Leave that portion.           Cater must upload fssai certification to access this website.</font></marquee>
</body>
</html>
