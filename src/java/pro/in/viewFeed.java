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


public class viewFeed extends HttpServlet {

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
            Connection conn=pro.in.Util.connect();
            String sql="select * from review";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            
            if(rs.next()==false){
                JOptionPane.showMessageDialog(null, "No Record Found!!!");
                response.sendRedirect("adminDashboard.jsp");
            }else{
                    rs.beforeFirst();
            out.println("<html>");
            out.println("<head><title>View Reviews of Customers</title>");
            out.println("<style>a{color:yellow;} body{background: gray;} table{width:1300px; margin:auto; table-layout:fixed; text-align:center; margin-top:50px; font-family:arial; color:#fff;}");
            out.println("table,th,td{ border:1.px dotted white; border-collapse:collapse; padding:20px;font-size:20px;}");
            out.println("th{ background:purple; padding:30px; text-transform:uppercase;}");
            out.println("td:nth-child(5n+1){background:red;}");
            out.println("td:nth-child(5n+2){background:blue;}");
            out.println("td:nth-child(5n+3){background:green;}");
            out.println("td:nth-child(5n+4){background:orange;}");
            out.println("td:nth-child(5n+5){background:magenta;}");
            out.println("td:nth-child(5n+6){background:black;}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><font color=white><h2>View Feedbacks | <a color=white title='Delete All' href=deleteAllFeed>Delete All Feedback</a></h2></font></center>");
            out.println("<hr>");
            out.println("<table border=2>");
            out.println("<tr>");
            out.println("<th width=50>ID</th>");
            out.println("<th width=100>Name</th>");
            out.println("<th width=130>Email</th>");
            out.println("<th width=150>Subject</th>");
            out.println("<th width=250>Message</th>");
            out.println("<th width=80>Delete</th>");
            out.println("</tr>");
            while(rs.next()){
                String r_id=rs.getString("r_id");
                String name=rs.getString("name");
                String mail=rs.getString("email");
                String subj=rs.getString("subject");
                String msg=rs.getString("message");
                
                out.println("<tr>");
                out.println("<td>"+r_id+"</td>");
                out.println("<td>"+name+"</td>");
                out.println("<td>"+mail+"</td>");
                out.println("<td>"+subj+"</td>");
                out.println("<td>"+msg+"</td>");
                
                out.println("<td><a title=delete href='DeleteFeed?id="+r_id+"'>Delete</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<hr>");
            out.println("<center><font size=5><a href=adminDashboard.jsp>Home</a></font></center>");
            out.println("</body>");
            out.println("</html>");
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unable to fetch Feedbacks....Please Wait until we resolve the issue");
            response.sendRedirect("adminDashboard.jsp");
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
