/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/attenaction"})
public class attenaction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try {  
            
           String id=request.getParameter("id");
           String wname=request.getParameter("wname"); 
           String timese=request.getParameter("timese");            
           String dates=request.getParameter("dates"); 
          
           
           System.out.println(id+" "+wname+" "+timese+" "+dates);
           int mgs;
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worker","root","root");
                        PreparedStatement query=con.prepareStatement("select * from ureg where id='"+id+"' and wname='"+wname+"' ");
                        System.out.println(query);
                        ResultSet rs=query.executeQuery();
                        if(rs.next()){
         
           mgs=rs.getInt("atten");
           System.out.println(mgs);
           if(mgs==0){
               mgs=mgs+1;
           }else{
               mgs++;
           }
           System.out.println(mgs);
           PreparedStatement ps=con.prepareStatement("insert into attendance(id,wname,timese,dates,atten) values('"+id+"','"+wname+"','"+timese+"','"+dates+"','"+mgs+"')");
           System.out.println(ps);
           ps.executeUpdate();
           
           PreparedStatement ps2=con.prepareStatement("update ureg set atten='"+mgs+"'  where id='"+id+"' and wname='"+wname+"'");
           System.out.println(ps2);
           ps2.executeUpdate();
           System.out.println(ps2);}
        out.println("<script type=\"text/javascript\">"); 			
        out.println("alert(\"Successfully Update '"+wname+"' Attendance\")");
        out.println("</script>"); 
        RequestDispatcher rd=request.getRequestDispatcher("atten.jsp");
        rd.include(request, response);
        }
        catch(Exception e){
        out.println("<script type=\"text/javascript\">"); 			
        out.println("alert(\"Please Try Again\")");
        out.println("</script>"); 
        RequestDispatcher rd=request.getRequestDispatcher("atten.jsp");
        rd.include(request, response);
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
