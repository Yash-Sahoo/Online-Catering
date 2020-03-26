<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
    session=request.getSession();
    String email=(String)session.getAttribute("userid");
    
    String sql="select password,name,hno,street,city,state,country,mobile from users where email=?";
    Connection con= pro.in.Util.connect();
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,email);
    ResultSet rs=ps.executeQuery();
    rs.next();
    String password=rs.getString("password");
    String name=rs.getString("name");
    String hno=rs.getString("hno");
    String street=rs.getString("street");
    String city=rs.getString("city");
    String state=rs.getString("state");
    String country=rs.getString("country");
    String mobile=rs.getString("mobile");
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
                if(mob.length<10){
                    alert("Please enter a valid Mobile Number");
                    return false;
                }else{
                    return true;
                }
            }
        }
    </script>
    <body  style="background: url(img1.jpg); background-size: 100% 100%;">
    <center><h3><font size="6" face="times new roman" color="red"><i><u>Online Catering Services</u></i></font></h3></center>
    <hr>
    <br>
    <font>
        <h3>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<font face="bookman old style" color="Orange">Update Profile Form</font></h3>
    <form action="UpdateProfileForCater" method="post" onsubmit="return checkAll()">
        <pre>
           
           
           <font face="bookman old style"> Name     </font>     <input type="text" id="nam" name="name" value="<%=name%>"/><br>

           <font face="bookman old style"> Password </font>    <input type="text" id="pw" name="password" value="<%=password%>"/><br>
           <font face="bookman old style"> Home No. </font>    <input type="text" id="hn" name="hno" value="<%=hno%>"/><br>
           <font face="bookman old style"> Street   </font>      <input type="text" id="street" name="street" value="<%=street%>"/><br>
           <font face="bookman old style"> City     </font>       <input type="text" id="cit" name="city" value="<%=city%>"/><br>

           <font face="bookman old style"> State    </font>      <input type="text" id="stat" name="state" value="<%=state%>"/><br>

           <font face="bookman old style"> Country  </font>     <input type="text" id="contry" name="country" value="<%=country%>"/><br>
           <font face="bookman old style"> Mob. No. </font>     <input type="text" id="mno" name="mobile" value="<%=mobile%>"/><br>
            
                <input type="submit" value="Update Profile"/>
        </pre>
    </form>
        </font>
    <hr>
    <center>
    <a href="ownerDashboard.jsp"><font face="bookman old style">Home</font></a>
    </center>
    </body>
</html>
