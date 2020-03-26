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

public class ShowAllDetails extends HttpServlet {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("userid");
        if(id==null){
            response.sendRedirect("index.jsp");
        }
        
        PrintWriter out=response.getWriter();
        try{
            con=pro.in.Util.connect();
            String qr="select * from caters";
            ps=con.prepareStatement(qr);
            rs=ps.executeQuery();
            boolean b=rs.next();
            rs.beforeFirst();
            if(b==false){
                JOptionPane.showMessageDialog(null,"No Such Cater Found!!!");
                response.sendRedirect("adminDashboard.jsp");
            }else{
                out.println("<html>");
                out.println("<style>");
                out.println("th {background-color:yellow;}");
                out.println("tr:hover {background-color:#50C7C7;}");
                out.println("</style>");
                out.println("<body style='background: url(img2.jpg); background-size: 100% 100%;'>");
                out.println("<center><h2><font face=algerian>All Cater Details</font></h2></center>");
                out.println("<hr>");
                out.println("<center><font size=4><a href=adminDashboard.jsp>Home</a></font></center>");
                out.println("<hr>");
                out.println("<center><table border=2>");
                out.println("<tr>");
                out.println("<th>Cater ID</th>");
                out.println("<th>Email</th>");
                out.println("<th>Dish1</th>");
                out.println("<th>Dish2</th>");
                out.println("<th>Dish3</th>");
                out.println("<th>Dish4</th>");
                out.println("<th>Dish5</th>");
                out.println("<th>Rate/Person</th>");
                out.println("<th>Specialty</th>");
                out.println("<th>Minimum Person</th>");
                out.println("<th>Maximum Person</th>");
                out.println("<th>Photo</th>");
                out.println("</tr>");
                while(rs.next()){
                    out.println("<tr>");
                    out.println("<td><center><b>"+rs.getString("cid")+"</b></center></td>");
                    out.println("<td><center>"+rs.getString("email")+"</center></td>");
                    out.println("<td><center>"+rs.getString("dish1")+"</center></td>");
                    out.println("<td><center>"+rs.getString("dish2")+"</center></td>");
                    out.println("<td><center>"+rs.getString("dish3")+"</center></td>");
                    out.println("<td><center>"+rs.getString("dish4")+"</center></td>");
                    out.println("<td><center>"+rs.getString("dish5")+"</center></td>");
                    out.println("<td><center>"+rs.getString("rate")+"</center></td>");
                    out.println("<td><center>"+rs.getString("speciality")+"</center></td>");
                    out.println("<td><center>"+rs.getString("min_person")+"</center></td>");
                    out.println("<td><center>"+rs.getString("max_person")+"</center></td>");
                    out.println("<td><a class=lightbox href=\"imageloader?id="+rs.getString("cid")+"\"><img title=View height=100 width=200 src=\"imageloader?id="+rs.getString("cid")+"\"></a></td>");
                    out.println("</tr>");
                }
                out.println("</table></center>");
                out.println("<hr>");
                out.println("<center><font size=4><a href=adminDashboard.jsp>Home</a></font></center>");
                out.println("</body>");
                out.println("</html>");
            }
        }catch(Exception e){
            out.println(e);
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
