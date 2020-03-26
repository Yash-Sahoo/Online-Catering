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
import javax.swing.JOptionPane;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class SaveUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        //reads the request
        PrintWriter out=response.getWriter();
        
        //String email=(String)session.getAttribute("userid");
        
        String email="",password="",name="",utype="",hno="",street="",city="",state="",country="",mobile="";
        byte cert[]=null;
        
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try{
            List<FileItem> items=upload.parseRequest(new ServletRequestContext(request));
            for(FileItem item:items){
                String naming=item.getFieldName();
                if(naming.equals("email")){
                    email=item.getString();
                }else if(naming.equals("password")){
                    password=item.getString();
                }else if(naming.equals("name")){
                    name=item.getString();
                }else if(naming.equals("utype")){
                    utype=item.getString();
                }else if(naming.equals("hno")){
                    hno=item.getString();
                }else if(naming.equals("street")){
                    street=item.getString();
                }else if(naming.equals("city")){
                    city=item.getString();
                }else if(naming.equals("state")){
                    state=item.getString();
                }else if(naming.equals("country")){
                    country=item.getString();
                }else if(naming.equals("mobile")){
                    mobile=item.getString();
                }else if(naming.equals("cert")){
                    cert=item.get();
                }
            }
        
            Connection con=pro.in.Util.connect();
            //String qr1="insert into caters(email,dish1,dish2,dish3,dish4,dish5,rate,speciality,photo,min_person,max_person) values(?,?,?,?,?,?,?,?,?,?,?)";
            String qr1="insert into users(email,password,name,utype,hno,street,city,state,country,mobile,status,fssai) values(?,?,?,?,?,?,?,?,?,?,'pending',?)";
            PreparedStatement ps=con.prepareStatement(qr1);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, utype);
            ps.setString(5, hno);
            ps.setString(6, street);
            ps.setString(7, city);
            ps.setString(8, state);
            ps.setString(9, country);
            ps.setString(10, mobile);
            ps.setBytes(11, cert);
            
            ps.executeUpdate();
            ps.close();
            con.close();
            
            out.println("<html>");
            out.println("<body>");
            out.println("<hr>");
            out.println("<h2>Account Created!!! Needs to be verified by Admin</h2>");
            out.println("<hr>");
            out.println("<a href=index.jsp>Home</a>");
            out.println("</body>");
            out.println("</html>");
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "This Email already exists in our site!!! Use Other email id....");
            response.sendRedirect("register.jsp");
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

