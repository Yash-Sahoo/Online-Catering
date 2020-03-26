<%
    session=request.getSession();
    String name=(String)session.getAttribute("username");
    if(name==null){
        response.sendRedirect("index.jsp");
    }
%>
<html>
    
    <script>
        function checkAll(){
            var b1=checkrent();
            return b1;
        }
                
        function checkrent(){
            var rent=document.getElementById("price").value;
            if(isNaN(rent)){
                alert("Rent must be Numeric Value");
                return false;
            }else{
                if(rent<0){
                    alert("Please enter a valid Rent Price\nRent Price cannot be negative");
                    return false;
                }else if(rent.length===0){
                    alert("Enter Rent of your property");
                    return false;
                }
                else{
                    return true;
                }
            }
        }
    </script>    
    
    <body style="background: url(img2.jpg); background-size: 100% 100%;">
    <center><h3><font size="6" color="red" face="bookman old style"><i><b><u>Online Caters and Services</u></b></i></font></h3></center>
    <hr>
    <br>
    <font align="left" color="iron">
    <center><h3>&emsp;&emsp;<font size="5" face=algerian color=blue>Caters Details Form</font></h3></center>
    <center><form action="saveCater" method="post" onsubmit="return checkAll()" enctype="multipart/form-data">
        <pre>
        
    <b>Dish 1</b>           <input type="text" name="dish1" placeholder="Dish 1" required/><br>
    <b>Dish 2</b>           <input type="text" name="dish2" placeholder="Dish 2" required/><br>
    <b>Dish 3</b>           <input type="text" name="dish3" placeholder="Dish 3" required/><br>
    <b>Dish 4</b>           <input type="text" name="dish4" placeholder="Dish 4" required/><br>
    <b>Dish 5</b>           <input type="text" name="dish5" placeholder="Dish 5" required/><br>
    <b>Rent Price</b>       <input type="text" id="price" name="rent" placeholder="Per Person"/><br>
    <b>Specialty</b>         <select name="special">
                            <option>Birthday Event</option>
                            <option>Marriage Event</option>
                            <option>Home Opening</option>
                            <option>Anniversary</option>
                            <option>Annual Function</option>
                            </select><br>
    <b>Catering Image</b>   <input type="file" name="pimg" id="pim"/><br>
    <b>Minimum Person</b>   <input type="text" name="min" required/><br>
    <b>Maximum Person</b>   <input type="text" name="max" required/><br>
        
    
    <input type="submit" value="Save Details"/>
        </pre>
        </form>  </center>
    </font>
    <hr>
    <a href="ownerDashboard.jsp"><font color=blue><center>Home</center></font></a>
    </body>
</html>
