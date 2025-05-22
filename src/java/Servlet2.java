
import Models.Operations;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TomTit
 */
public class Servlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Nhận thông tin từ client
            String a = request.getParameter("a");
            String b = request.getParameter("b");

            //Xử lý yêu cầu
            String err = "";
            //Check input empty
            //Check nhap so nguyen
            if (a.isBlank()) {
                err += "Ban chua nhap a<br>";
            } else {
                try {
                    int a1 = Integer.parseInt(a);
                } catch (Exception e) {
                    err += "a khong phai so nguyen<br>";
                }
            }

            if (b.isBlank()) {
                err += "Ban chua nhap b<br>";
            } else {
                try {
                    int b1 = Integer.parseInt(b);
                } catch (Exception e) {
                    err += "b khong phai so nguyen<br>";
                }
            }

            out.print(err);

            int a1 = Integer.parseInt(a);
            int b1 = Integer.parseInt(b);
            String result = "";
            boolean btn = false;
            if (request.getParameter("cong") != null) {
                result = "a+b=" + (a1 + b1);
                btn = true;
            }

            if (request.getParameter("tru") != null) {
                result = "a-b=" + (a1 - b1);
                btn = true;
            }

            if (request.getParameter("nhan") != null) {
                result = "a*b=" + (a1 * b1);
                btn = true;
            }

            if (request.getParameter("chia") != null) {
                if (b1 == 0) {
                    out.print("b khong the=0");
                } else {
                    result = "a/b=" + ((double) a1 / b1);
                }
                btn = true;
            }

            if (!btn) {
                if (request.getParameter("op").equals("0")) {
                    out.print("May chua chon operator");
                }

                if (request.getParameter("op").equals("1")) {
                    result = "UCLN=" + UCLN(a1, b1);
                }

                if (request.getParameter("op").equals("2")) {
                    result = "BCNN=" + BCNN(a1, b1);
                }
            }

            //Trả kết quả cho client
            out.print(result);
        }
    }

    //khai bao mot arraylist chua mot danhh sach phep tinh
    ArrayList<Operations> data = new ArrayList<Operations>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Nhận thông tin từ client
            String a = request.getParameter("a");
            String b = request.getParameter("b");
            String op = request.getParameter("op");
            //Xử lý yêu cầu
            String err = "";
            boolean check = true;

            //Check input empty
            //Check nhap so nguyen
            if (a.isBlank()) {
                err += "Ban chua nhap a<br>";
                check = false;
            } else {
                try {
                    int a1 = Integer.parseInt(a);
                } catch (Exception e) {
                    err += "a khong phai so nguyen<br>";
                    check = false;
                }
            }

            if (b.isBlank()) {
                err += "Ban chua nhap b<br>";
                check = false;
            } else {
                try {
                    int b1 = Integer.parseInt(b);
                } catch (Exception e) {
                    err += "b khong phai so nguyen<br>";
                    check = false;
                }
            }

            //out.print(err);
            String result = "";

            if (check) {
                String op1 = "";
                int a1 = Integer.parseInt(a);
                int b1 = Integer.parseInt(b);

                boolean btn = false;
                if (request.getParameter("cong") != null) {
                    result = "a+b=" + (a1 + b1);
                    btn = true;
                    op1 = "Cong";
                    data.add(new Operations(a, b, op1, result));
                }

                if (request.getParameter("tru") != null) {
                    result = "a-b=" + (a1 - b1);
                    btn = true;
                    op1 = "Tru";
                    data.add(new Operations(a, b, op1, result));
                }

                if (request.getParameter("nhan") != null) {
                    result = "a*b=" + (a1 * b1);
                    btn = true;
                    op1 = "Nhan";
                    data.add(new Operations(a, b, op1, result));
                }

                if (request.getParameter("chia") != null) {
                    if (b1 == 0) {
                        err += "b khong the=0";

                    } else {
                        op1 = "Chia";
                        result = "a/b=" + ((double) a1 / b1);
                        data.add(new Operations(a, b, op1, result));
                    }
                    btn = true;

                }

                if (!btn) {
                    if (request.getParameter("op").equals("0")) {
                        err += "Ban chua chon operator";
                    }

                    if (request.getParameter("op").equals("1")) {
                        result = "UCLN=" + UCLN(a1, b1);
                        op1 = "UCLN";
                        data.add(new Operations(a, b, op1, result));
                    }

                    if (request.getParameter("op").equals("2")) {
                        result = "BCNN=" + BCNN(a1, b1);
                        op1 = "BCNN";
                        data.add(new Operations(a, b, op1, result));
                    }
                }

            }

            //Trả kết quả cho client
            //out.print(result);
            request.setAttribute("err", err);
            request.setAttribute("result", result);
            request.setAttribute("a", a);
            request.setAttribute("b", b);
            request.setAttribute("op", op);
            request.setAttribute("data", data);
            request.getRequestDispatcher("Example.jsp").forward(request, response);
        }
    }

    private int UCLN(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private int BCNN(int a, int b) {
        return a * b / UCLN(a, b);
    }

}
