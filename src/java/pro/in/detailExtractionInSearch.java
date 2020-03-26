package pro.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

public class detailExtractionInSearch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        String mail=request.getParameter("mail");
        //char ch[]=key.toCharArray();
        String key=request.getParameter("key");
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("userid");
        if(id==null){
            response.sendRedirect("index.jsp");
        }
        String sql="select * from users where email=?";
        
        try{
            Connection con=pro.in.Util.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, mail);
            
            ResultSet rs=ps.executeQuery();
            
            boolean b=rs.next();
            rs.beforeFirst();
            if(b==false){
                JOptionPane.showMessageDialog(null,"No Such Cater Found!!!");
                response.sendRedirect("customerDashboard.jsp");
            }else{
                out.println("<html>");
                out.println("<style>");
                out.println("th {background-color:black; color:red;}");
                out.println("tr:hover {background-color:black; color:white;}");
                out.println("</style>");
                out.println("<body style='background: url(img2.jpg); background-size: 100% 100%;'>");
                out.println("<center><h2><font face=algerian>Your Selected Cater Detail</font></h2></center>");
                out.println("<hr>");
                out.println("<center><table border=2>");
                out.println("<tr>");
                out.println("<th width=70>User ID</th>");
                out.println("<th width=140>Email</th>");
                out.println("<th width=140>Name</th>");
                out.println("<th width=140>Street</th>");
                out.println("<th width=140>City</th>");
                out.println("<th width=140>State</th>");
                out.println("<th width=120>Country</th>");
                out.println("<th width=100>Mobile No.</th>");
                out.println("<th>Fssai Certification</th>");
                out.println("</tr>");
                while(rs.next()){
                    out.println("<tr>");
                    out.println("<td><center><b>"+rs.getString("uid")+"</b></center></td>");
                    out.println("<td><center>"+rs.getString("email")+"</center></td>");
                    out.println("<td><center>"+rs.getString("name")+"</center></td>");
                    out.println("<td><center>"+rs.getString("street")+"</center></td>");
                    out.println("<td><center>"+rs.getString("city")+"</center></td>");
                    out.println("<td><center>"+rs.getString("state")+"</center></td>");
                    out.println("<td><center>"+rs.getString("country")+"</center></td>");
                    out.println("<td><center>"+rs.getString("mobile")+"</center></td>");
                    out.println("<td><a class=lightbox href=\"imageloader1?id="+rs.getString("uid")+"\"><img title=View height=100 width=200 src=\"imageloader1?id="+rs.getString("uid")+"\"></a></td>");
                    out.println("</tr>");
                }
                out.println("</table></center>");
                out.println("<hr>");
                out.println("<center><font size=4><a href=customerDashboard.jsp>Home</a></font></center>");
                out.println("</body>");
                out.println("</html>");
            }
            
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Something went wrong while searching....");
            response.sendRedirect("customerDashboard.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
