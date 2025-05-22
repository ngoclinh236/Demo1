/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author linhd
 */
public class ProductDAO extends DBContext {

    //Khai báo các thành phần xử lý Database
    PreparedStatement stm; //Thực hiện câu lệnh SQL
    ResultSet rs;//Lưu trữ và xử lý dữ liệu

    public ArrayList<Products> getProducts() {
        ArrayList<Products> data = new ArrayList<Products>();
        try {
            String strSQL = "select*from Products p join Categories c on p.CategoryID=c.CategoryID";
            stm = connection.prepareStatement(strSQL);

            rs = stm.executeQuery();
            while (rs.next()) {
                String code = String.valueOf(rs.getInt(1));
                String name = rs.getString(2);
                String price = String.valueOf(rs.getDouble(3));
                String stock = String.valueOf(rs.getInt(4));
                String image = rs.getString(5);
                String category = rs.getString(8);
                Products P = new Products(code, name, price, stock, image, category);
                data.add(P);
            }
        } catch (Exception e) {
            System.out.println("getProducts:" + e.getMessage());
        }
        return data;
    }

    public ArrayList<Categories> getCategories() {
        ArrayList<Categories> data1 = new ArrayList<Categories>();
        try {
            String strSQL = "select * from Categories";
            stm = connection.prepareStatement(strSQL);

            rs = stm.executeQuery();
            while (rs.next()) {
                String code = String.valueOf(rs.getInt(1));
                String name = rs.getString(2);

                Categories c = new Categories(code, name);
                data1.add(c);
            }
        } catch (Exception e) {
            System.out.println("getCategories:" + e.getMessage());
        }
        return data1;
    }

    public Products getProductByCode(String code) {
        try {
            String strSQL = "select * from Products where ProductID=?";
            stm = connection.prepareStatement(strSQL);
            stm.setString(1, code);
            rs = stm.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String price = String.valueOf(rs.getDouble(3));
                String stock = String.valueOf(rs.getInt(4));
                String image = rs.getString(5);
                String category = String.valueOf(rs.getInt(6));
                Products P = new Products(code, name, price, stock, image, category);
                return P;
            }
        } catch (Exception e) {
            System.out.println("getProductByCode:" + e.getMessage());
        }
        return null;
    }

    public void update(Products p) {
        try {
            String strSQL = "update Products set ProductName=?, UnitPrice=?,UnitsInStock=?,Image=?,CategoryID=? where ProductID=?";
            stm = connection.prepareStatement(strSQL);
            stm.setString(1, p.getName());
            stm.setDouble(2, Double.parseDouble(p.price));
            stm.setInt(3, Integer.parseInt(p.stock));
            stm.setString(4, p.image);
            stm.setInt(5, Integer.parseInt(p.category));
            stm.setString(6, p.code);
            stm.execute();
        } catch (Exception e) {
            System.out.println("update:" + e.getMessage());
        }
    }

    public void add(Products p) {
        try {
            String strSQL = "insert into Products(ProductName,UnitPrice,UnitsInStock,Image,CategoryID) values(?,?,?,?,?)";
            stm = connection.prepareStatement(strSQL);
            stm.setString(1, p.getName());
            stm.setDouble(2, Double.parseDouble(p.price));
            stm.setInt(3, Integer.parseInt(p.stock));
            stm.setString(4, p.image);
            stm.setInt(5, Integer.parseInt(p.category));
            stm.execute();
        } catch (Exception e) {
            System.out.println("add:" + e.getMessage());
        }
    }

    public void delete(String code) {
        try {
            String strSQL = "delete from Products where ProductID=?";
            stm = connection.prepareStatement(strSQL);
            stm.setString(1, code);
            stm.execute();
        } catch (Exception e) {
            System.out.println("delete:" + e.getMessage());
        }
    }

    public ArrayList<Products> getProductByName(String name1) {
        ArrayList<Products> data = new ArrayList<Products>();
        try {
            String strSQL = "select*from Products p join Categories c on p.CategoryID=c.CategoryID where ProductName like ?";
            stm = connection.prepareStatement(strSQL);
            stm.setString(1, "%" + name1 + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String code = String.valueOf(rs.getInt(1));
                String name = rs.getString(2);
                String price = String.valueOf(rs.getDouble(3));
                String stock = String.valueOf(rs.getInt(4));
                String image = rs.getString(5);
                String category = rs.getString(8);
                Products P = new Products(code, name, price, stock, image, category);
                data.add(P);
            }
        } catch (Exception e) {
            System.out.println("getProductsByName:" + e.getMessage());
        }
        return data;
    }

}
