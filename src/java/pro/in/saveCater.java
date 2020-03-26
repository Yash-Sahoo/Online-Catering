package pro.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class saveCater extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session=request.getSession();
        String id=(String)session.getAttribute("userid");
        if(id==null){
            response.sendRedirect("index.jsp");
        }
        //reads the request
        PrintWriter out=response.getWriter();
        
        String email=(String)session.getAttribute("userid");
        
        String dish1="",dish2="",dish3="",dish4="",dish5="",
                rent="",special="",min="",max="";
        byte imgdata[]=null;
        
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try{
            List<FileItem> items=upload.parseRequest(new ServletRequestContext(request));
            for(FileItem item:items){
                String name=item.getFieldName();
                if(name.equals("dish1")){
                    dish1=item.getString();
                }else if(name.equals("dish2")){
                    dish2=item.getString();
                }else if(name.equals("dish3")){
                    dish3=item.getString();
                }else if(name.equals("dish4")){
                    dish4=item.getString();
                }else if(name.equals("dish5")){
                    dish5=item.getString();
                }else if(name.equals("rent")){
                    rent=item.getString();
                }else if(name.equals("special")){
                    special=item.getString();
                }else if(name.equals("min")){
                    min=item.getString();
                }else if(name.equals("max")){
                    max=item.getString();
                }else if(name.equals("pimg")){
                    imgdata=item.get();
                }
            }
        
            Connection con=pro.in.Util.connect();
            String qr1="insert into caters(email,dish1,dish2,dish3,dish4,dish5,rate,speciality,photo,min_person,max_person) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(qr1);
            ps.setString(1, email);
            ps.setString(2, dish1);
            ps.setString(3, dish2);
            ps.setString(4, dish3);
            ps.setString(5, dish4);
            ps.setString(6, dish5);
            ps.setInt(7, Integer.parseInt(rent));
            ps.setString(8, special);
            ps.setBytes(9, imgdata);
            ps.setString(10, min);
            ps.setString(11, max);
            
            ps.executeUpdate();
            ps.close();
            con.close();
            
            out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
            out.println("<h2>Cater Details Submitted Successfully!!!</h2>");
            out.println("<hr>");
            out.println("<a href=registerDetail.jsp>Submit-Another</a><br>");
            out.println("<a href=ownerDashboard.jsp>Home</a>");
            out.println("</body>");
            out.println("</html>");
            
            
            
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
