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

public class detailExtractionInSearchReverseGear extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        
        String mail=request.getParameter("mail");
        //char ch[]=key.toCharArray();
       
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("userid");
        if(id==null){
            response.sendRedirect("index.jsp");
        }
        String sql="select * from caters where email=?";
        
        try{
            Connection con=pro.in.Util.connect();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, mail);
            String key=request.getParameter("key");
            ResultSet rs=ps.executeQuery();
            
            boolean b=rs.next();
            rs.beforeFirst();
            if(b==false){
                JOptionPane.showMessageDialog(null,"No Such Cater Details Uploaded Found!!!");
                response.sendRedirect("customerDashboard.jsp");
            }else{
                out.println("<html>");
                out.println("<style>");
                out.println("th {background-color:black; color:red;}");
                out.println("tr:hover {background-color:black; color:white;}");
                out.println("</style>");
                out.println("<body style='background: url(img3.jpg); background-size: 100% 100%;'>");
                out.println("<center><h2><font face=algerian>Your selected cater details...</font></h2></center>");
                out.println("<hr>");
                out.println("<center><table border=2 bgcolor=white>");
                out.println("<tr>");
                out.println("<th width=40>Cater ID</th>");
                out.println("<th width=110>Email</th>");
                out.println("<th width=100>Dish1</th>");
                out.println("<th width=100>Dish2</th>");
                out.println("<th width=100>Dish3</th>");
                out.println("<th width=100>Dish4</th>");
                out.println("<th width=100>Dish5</th>");
                out.println("<th width=50>Rate/Person</th>");
                out.println("<th width=110>Specialty</th>");
                out.println("<th width=60>Min Person</th>");
                out.println("<th width=60>Max Person</th>");
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
                out.println("<center><font size=4><a href=searchItOut?key="+key+">Back</a></font></center>");
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
