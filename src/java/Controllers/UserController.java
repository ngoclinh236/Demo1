/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Categories;
import Models.UserDAO;
import Models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 *
 */
public class UserController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Gọi bên DAO xử lý check user
        UserDAO da = new UserDAO();
      

        //Trả kết quả về cho client
        if (request.getParameter("mode") != null && request.getParameter("mode").equals("1")) {
            //Tìm user tương ứng với code truyền sang
            //Get name tương ứng với account
            String account = request.getParameter("account");
            Users s = da.getNameByAccount(account);
            request.setAttribute("s", s);
        }
        if (request.getParameter("mode") != null && request.getParameter("mode").equals("2")) {
            //Tìm user tương ứng với code truyền sang
            //Get name tương ứng với account
            String account = request.getParameter("account");
            da.delete(account);
        }

        //Di chuyển về trong index.jsp
          ArrayList<Users> data = da.getUsers();
        request.setAttribute("data", data);

        request.getRequestDispatcher("ListUser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String dateOfBirth = request.getParameter("dateOfBirth");
        
        Users s= new Users(account, password, name, gender, address, dateOfBirth);
        
        UserDAO da = new UserDAO();
        
        if(request.getParameter("update")!=null){
            da.update(s);
        }
        if(request.getParameter("add")!=null){
            da.add(s);
        }
        
        if(request.getParameter("delete")!=null){
            da.delete(s.getAccount());
        }
        ArrayList<Users> data= da.getUsers();
        if(request.getParameter("search")!=null){
            data= da.getUsersByAccount(account);
        }
        request.setAttribute("data", data);
        request.setAttribute("s", s);
        request.getRequestDispatcher("ListUser,jsp").forward(request, response);
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
