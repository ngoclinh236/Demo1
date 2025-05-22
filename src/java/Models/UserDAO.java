/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import dal.DBContext;
import java.sql.*;
import java.util.ArrayList;
/**
 * Chứa các hàm xử lý liên quan đến User
 * @author linhd
 */
public class UserDAO extends DBContext{
    //Khai báo các thành phần xử lý Database
    PreparedStatement stm; //Thực hiện câu lệnh SQL
    ResultSet rs;//Lưu trữ và xử lý dữ liệu
    public ArrayList<Users> getUsers(){
        ArrayList<Users>data=new ArrayList<Users>();
        try {
            String strSQL="select*from Users";
            stm=connection.prepareStatement(strSQL);
           
            rs=stm.executeQuery();
            while(rs.next()){
                String account=rs.getString(1);
                String password=rs.getString(2);
                String name=rs.getString(3);
                String gender=String.valueOf(rs.getInt(4));
                String address=rs.getString(5);
                String dateOfBirth=rs.getString(6);
                Users S = new Users(account,password, name, gender, address, dateOfBirth);
                data.add(S);
            }
        } catch (Exception e) {
            System.out.println("getUsers:"+e.getMessage());
        }
        return data;
    }
    
        
    

    public Users getNameByAccount(String account) {
        try {
            String strSQL="select*from Users where account=?";
            stm=connection.prepareStatement(strSQL);
            stm.setString(1, account);
            rs=stm.executeQuery();
            while(rs.next()){
                
                String password=rs.getString(2);
                String name=rs.getString(3);
                String gender=String.valueOf(rs.getInt(4));
                String address=rs.getString(5);
                String dateOfBirth=rs.getString(6);
                Users S = new Users(account,password, name, gender, address, dateOfBirth);
                return S;
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount:"+e.getMessage());
        }
        return null;
    }

//    public static void main(String[] args) {
//        UserDAO a= new UserDAO();
//        ArrayList<Users> list= a.getUsers();
//        for(int i=0;i<list.size();i++){
//            System.out.println("aaa");
//        }
//    }

    public void update(Users s) {
        try {
            String strSQL="update Users set account=?, password=?, name=?, gender=?, address=?,dateofbirth=?";
            stm=connection.prepareStatement(strSQL);
            stm.setString(1, s.getAccount());
            stm.setString(2, s.getPassword());
            stm.setString(3, s.getName());
            stm.setInt(4, Integer.parseInt(s.gender));
            stm.setString(5, s.getAddress());
            stm.setString(6, s.getDateOfBirth());
            stm.execute();
        } catch (Exception e) {
            System.out.println("update:" + e.getMessage());
        }
    }

    public void add(Users s) {
         try {
            String strSQL="insert into Users(account,password,name,gender,address,dateofbirth) values(?,?,?,?,?,?)";
            stm=connection.prepareStatement(strSQL);
            stm.setString(1, s.getAccount());
            stm.setString(2, s.getPassword());
            stm.setString(3, s.getName());
            stm.setInt(4, Integer.parseInt(s.gender));
            stm.setString(5, s.getAddress());
            stm.setString(6, s.getDateOfBirth());
            stm.execute();
        } catch (Exception e) {
            System.out.println("add:" + e.getMessage());
        }
    }

    public void delete(String account) {
         try {
            String strSQL="delete from Users where account=?";
            stm=connection.prepareStatement(strSQL);
            stm.setString(1, account);
            
            stm.execute();
        } catch (Exception e) {
            System.out.println("delete:" + e.getMessage());
        }
    }
     public ArrayList<Users> getUsersByAccount(String account1){
        ArrayList<Users>data=new ArrayList<Users>();
        try {
            String strSQL="select*from Users where account like ?";
            stm=connection.prepareStatement(strSQL);
           stm.setString(1, "%" + account1 + "%");
            rs=stm.executeQuery();
            while(rs.next()){
                String account=rs.getString(1);
                String password=rs.getString(2);
                String name=rs.getString(3);
                String gender=String.valueOf(rs.getInt(4));
                String address=rs.getString(5);
                String dateOfBirth=rs.getString(6);
                Users S = new Users(account,password, name, gender, address, dateOfBirth);
                data.add(S);
            }
        } catch (Exception e) {
            System.out.println("getUsersByAccount:"+e.getMessage());
        }
        return data;
    }
    
}
