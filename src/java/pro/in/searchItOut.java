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

public class searchItOut extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String key = request.getParameter("key");
        //char ch[]=key.toCharArray();

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userid");
        if (id == null) {
            response.sendRedirect("index.jsp");
        }

        String sql = "select * from caters where email like ? or dish1 like ? or dish2 like ? or dish3 like ? or dish4 like ? or dish5 like ? or rate <= ? or speciality like ? or cid like ? order by rate asc";
        String sq = "select * from users where (city like ? or state like ? or country like ? or name like ?) and utype=?";

        try {
            Connection con = pro.in.Util.connect();
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sq);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");
            ps.setString(3, "%" + key + "%");
            ps.setString(4, "%" + key + "%");
            ps.setString(5, "%" + key + "%");
            ps.setString(6, "%" + key + "%");
            ps.setString(7, key);
            ps.setString(8, "%" + key + "%");
            ps.setString(9, "%" + key + "%");

            ps1.setString(1, "%" + key + "%");
            ps1.setString(2, "%" + key + "%");
            ps1.setString(3, "%" + key + "%");
            ps1.setString(4, "%" + key + "%");
            ps1.setString(5, "cater");

            ResultSet rs = ps.executeQuery();

            boolean b = rs.next();
            rs.beforeFirst();
            if (b == false) {
                ResultSet rs1 = ps1.executeQuery();
                boolean b1 = rs1.next();
                rs1.beforeFirst();
                if (b1 == false) {
                    JOptionPane.showMessageDialog(null, "No Such Cater Found!!!");
                    response.sendRedirect("customerDashboard.jsp");
                } else {
                    out.println("<html>");
                    out.println("<style>");
                    out.println("th {background-color:yellow; color:black;}");
                    out.println("tr:hover {background-color:black; color:white;}");
                    //out.println("a: {color:black;}");
                    out.println("</style>");
                    out.println("<body  style='background: url(img2.jpg); background-size: 100% 100%;'>");
                    out.println("<center><h2><font face=algerian>All Cater Details</font></h2></center>");
                    out.println("<hr>");
                    out.println("<center><table border=2 bgcolor=white>");
                    out.println("<tr>");
                    out.println("<th width=100>User ID</th>");
                    out.println("<th width=180>Email</th>");

                    out.println("<th width=110>Name</th>");
                    out.println("<th width=190>Street</th>");
                    out.println("<th width=100>City</th>");
                    out.println("<th width=100>State</th>");
                    out.println("<th width=100>Country</th>");
                    out.println("<th width=120>Mobile</th>");
                    out.println("<th width=140>Fssai Certification</th>");

                    out.println("</tr>");
                    while (rs1.next()) {
                        out.println("<tr>");
                        out.println("<td><center><b>" + rs1.getString("uid") + "</b></center></td>");
                        out.println("<td><center><a title=View href=\"detailExtractionInSearchReverseGear?mail=" + rs1.getString("email") + "&key=" + key + "\">" + rs1.getString("email") + "</a></center></td>");

                        out.println("<td><center>" + rs1.getString("name") + "</center></td>");
                        out.println("<td><center>" + rs1.getString("street") + "</center></td>");
                        out.println("<td><center>" + rs1.getString("city") + "</center></td>");
                        out.println("<td><center>" + rs1.getString("state") + "</center></td>");
                        out.println("<td><center>" + rs1.getString("country") + "</center></td>");
                        out.println("<td><center>" + rs1.getString("mobile") + "</center></td>");

                        out.println("<td><a class=lightbox href=\"imageloader1?id=" + rs1.getString("uid") + "\"><img title=View height=100 width=200 src=\"imageloader1?id=" + rs1.getString("uid") + "\"></a></td>");
                        out.println("</tr>");
                    }
                    out.println("</table></center>");
                    out.println("<hr>");
                    out.println("<center><font size=4><a href=customerDashboard.jsp>Home</a></font></center>");
                    out.println("</body>");
                    out.println("</html>");
                }
                ps1.close();
                rs1.close();
                con.close();
            } else {
                out.println("<html>");
                out.println("<style>");
                out.println("th {background-color:yellow; color:black;}");
                out.println("tr:hover {background-color:black; color:white;}");
                //out.println("a: {color:black;}");
                out.println("</style>");
                out.println("<body  style='background: url(img2.jpg); background-size: 100% 100%;'>");
                out.println("<center><h2><font face=algerian>All Cater Details</font></h2></center>");
                out.println("<hr>");
                out.println("<center><table border=2 bgcolor=white>");
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
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td><center><b>" + rs.getString("cid") + "</b></center></td>");
                    out.println("<td><center><a title=View href=\"detailExtractionInSearch?mail=" + rs.getString("email") + "&key=" + key + "\">" + rs.getString("email") + "</a></center></td>");

                    out.println("<td><center>" + rs.getString("dish1") + "</center></td>");
                    out.println("<td><center>" + rs.getString("dish2") + "</center></td>");
                    out.println("<td><center>" + rs.getString("dish3") + "</center></td>");
                    out.println("<td><center>" + rs.getString("dish4") + "</center></td>");
                    out.println("<td><center>" + rs.getString("dish5") + "</center></td>");
                    out.println("<td><center>" + rs.getString("rate") + "</center></td>");
                    out.println("<td><center>" + rs.getString("speciality") + "</center></td>");
                    out.println("<td><center>" + rs.getString("min_person") + "</center></td>");
                    out.println("<td><center>" + rs.getString("max_person") + "</center></td>");
                    out.println("<td><a title=View class=lightbox href=\"imageloader?id=" + rs.getString("cid") + "\"><img title=View height=100 width=200 src=\"imageloader?id=" + rs.getString("cid") + "\"></a></td>");
                    out.println("</tr>");
                }
                out.println("</table></center>");
                out.println("<hr>");
                out.println("<center><font size=4><a href=customerDashboard.jsp>Home</a></font></center>");
                out.println("</body>");
                out.println("</html>");
            }

        } catch (Exception e) {
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
