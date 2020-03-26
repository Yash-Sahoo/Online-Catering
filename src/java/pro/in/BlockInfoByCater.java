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

public class BlockInfoByCater extends HttpServlet {

    Connection con;
    
    PreparedStatement ps1;
    
    public void init(){
        try{
            con=pro.in.Util.connect();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void destroy(){
        try{
            con.close();
            ps1.close();
    
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String sql="delete from caters where cid=?";
        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("userid");
        if(id==null){
            response.sendRedirect("index.jsp");
        }
        try{
        
            ps1=con.prepareStatement(sql);
            String pcode=request.getParameter("id");
            ps1.setString(1,pcode);
            ps1.executeUpdate();
            response.sendRedirect("ViewOwnCateringforDelete");
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
