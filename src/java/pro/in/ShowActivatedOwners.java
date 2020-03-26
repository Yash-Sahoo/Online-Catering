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

public class ShowActivatedOwners extends HttpServlet {

    Connection con;
    ResultSet rs;
    PreparedStatement ps1;

    public void init() {
        try {
            con = pro.in.Util.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        try {
            con.close();
            ps1.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sql = "select * from users where utype='cater' and status='activated' order by name";

        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("userid");
        if (id == null) {
            response.sendRedirect("index.jsp");
        }

        try {

            ps1 = con.prepareStatement(sql);
            rs = ps1.executeQuery();
            boolean b = rs.next();
            if (b == false) {
                JOptionPane.showMessageDialog(null, "No Verified Caters Found....!!!!");
                response.sendRedirect("adminDashboard.jsp");
            } else {
                rs.beforeFirst();
                out.println("<html>");
                out.println("<head><title>Verified Caters</title>");
                out.println("<style>body{background: gray;} table{width:1500px; margin:auto; table-layout:fixed; text-align:center; margin-top:50px; font-family:arial; color:#fff;}");
                out.println("table,th,td{ border:1px dotted white; border-collapse:collapse; padding:20px;font-size:18px;}");
                out.println("th{ background:purple; padding:30px; text-transform:uppercase;}");
                out.println("td:nth-child(6n+1){background:red;}");
                out.println("td:nth-child(6n+2){background:blue;}");
                out.println("td:nth-child(6n+3){background:green;}");
                out.println("td:nth-child(6n+4){background:orange;}");
                out.println("td:nth-child(6n+5){background:lightgreen;}");
                out.println("td:nth-child(6n+6){background:white;}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<center><font color=white><h2>Verified Caters</h2></font></center>");
                out.println("<hr>");
                out.println("<table border=2>");
                out.println("<tr>");
                out.println("<th width=200>E-Mail</th>");
                out.println("<th width=140>Name</th>");
                out.println("<th width=350>Address</th>");
                out.println("<th width=80>Mobile</th>");
                out.println("<th width=80>Permission</th>");
                out.println("<th width=80>Block</th>");
                out.println("</tr>");
                while (rs.next()) {
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    String address = rs.getString("hno") + "," + rs.getString("street") + "," + rs.getString("city") + "," + rs.getString("state") + "," + rs.getString("country");
                    String mobile = rs.getString("mobile");

                    out.println("<tr>");
                    out.println("<td>" + email + "</td>");
                    out.println("<td>" + name + "</td>");
                    out.println("<td>" + address + "</td>");
                    out.println("<td>" + mobile + "</td>");
                    out.println("<td><a title=Suspend href='suspendOwner?id=" + email + "'>Suspend</a></td>");
                    out.println("<td><a href='deleteOwnerAppliedCopy?id=" + email + "'>block</a></td>");
                }
                out.println("</table>");
                out.println("<hr>");
                out.println("<center><font size=6><a href=adminDashboard.jsp>Home</a></font></center>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
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
