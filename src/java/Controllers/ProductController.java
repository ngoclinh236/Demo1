/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Categories;
import Models.ProductDAO;
import Models.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author linhd
 */
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Get list Product từ DB
        //Trả về cho ListProduct.jsp
        ProductDAO da = new ProductDAO();

        if (request.getParameter("mode") != null && request.getParameter("mode").equals("1")) {
            //Tìm product tương ứng với code truyền sang
            String code = request.getParameter("code");
            Products p = da.getProductByCode(code);
            request.setAttribute("p", p);
        }

        if (request.getParameter("mode") != null && request.getParameter("mode").equals("2")) {
            //Tìm product tương ứng với code truyền sang
            String code = request.getParameter("code");
            da.delete(code);

        }
        ArrayList<Products> data = da.getProducts();
        ArrayList<Categories> data1 = da.getCategories();
        request.setAttribute("data", data);
        request.setAttribute("data1", data1);
        request.getRequestDispatcher("ListProduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String image = request.getParameter("image");
        String category = request.getParameter("category");

        Products p = new Products(code, name, price, stock, image, category);

        ProductDAO da = new ProductDAO();

        if (request.getParameter("update") != null) {
            da.update(p);
        }
        if (request.getParameter("add") != null) {
            da.add(p);
        }
        if (request.getParameter("delete") != null) {
            da.delete(p.getCode());
        }

        ArrayList<Products> data = da.getProducts();
        ArrayList<Categories> data1 = da.getCategories();
        
        if (request.getParameter("search") != null) {
            data = da.getProductByName(name);
        }
        request.setAttribute("data", data);
        request.setAttribute("data1", data1);
        request.setAttribute("p", p);

        request.getRequestDispatcher("ListProduct.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
