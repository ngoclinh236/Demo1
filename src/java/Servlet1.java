/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author TomTit
 */
public class Servlet1 extends HttpServlet {

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
            out.println("<title>Servlet Servlet1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
            out.println("<form action='demo1' method='post'>");
            out.println("Enter a:<input type='text' name='a'><br>");
            out.println("Enter b:<input type='text' name='b'><br>");
            out.println("<input type='submit' name='cong' value='a+b'>");
            out.println("<input type='submit' name='tru' value='a-b'>");
            out.println("<input type='submit' name='nhan' value='a*b'>");
            out.println("<input type='submit' name='chia' value='a/b'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

            //Nhận thông tin từ client
            String a = request.getParameter("a");
            String b = request.getParameter("b");

            //Xử lý yêu cầu
            int a1 = Integer.parseInt(a);
            int b1 = Integer.parseInt(b);
            int c = a1 + b1;
            String result = "a+b=" + c;

            //Trả kết quả cho client
            out.print(result);
        }
    }

    /**
     * Khi nào gọi đến hàm doGet(): 1.Chạy trực tiếp servlet 2.Khi gọi đến
     * servlet, set method=get hoặc không set thuộc tính method
     */
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

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Nhận thông tin từ client
            String a = request.getParameter("a");
            String b = request.getParameter("b");

            //Xử lý yêu cầu
            String err="";
            //Check input empty
            //Check nhap so nguyen
            if (a.isBlank()) {
                err+="Ban chua nhap a<br>";
            }
            else{
                try {
                    int a1 = Integer.parseInt(a);
                } catch (Exception e) {
                    err+="a khong phai so nguyen<br>";
                }
            }
            
            if (b.isBlank()) {
                err+="Ban chua nhap b<br>";
            }
            else{
                try {
                    int b1 = Integer.parseInt(b);
                } catch (Exception e) {
                    err+="b khong phai so nguyen<br>";
                }
            }
            
            out.print(err);
            
            int a1 = Integer.parseInt(a);
            int b1 = Integer.parseInt(b);
            String result = "";

            if (request.getParameter("cong") != null) {
                result = "a+b=" + (a1 + b1);
            }
            
            if (request.getParameter("tru") != null) {
                result = "a-b=" + (a1 - b1);
            }
            
            if (request.getParameter("nhan") != null) {
                result = "a*b=" + (a1 * b1);
            }
            
            if (request.getParameter("chia") != null) {
                if (b1==0) {
                    out.print("b khong the=0");
                }
                else
                    result = "a/b=" + ((double)a1 / b1);
            }

            //Trả kết quả cho client
            out.print(result);
        }
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
