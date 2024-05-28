/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import baiguixe.DTO.userDTO;
import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class userDAO {
    public String DangNhap(String tk,String mk){
       Connection cn=ketNoiDTB.ketnoi();
       //ArrayList<userDTO> hienXe=new ArrayList<>(); 
       String role="0";
       String sql="SELECT vaiTro FROM dbo.tkmk WHERE taiKhoan=? AND matKhau=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         
         st.setString(1, tk);
         st.setString(2, mk);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
          // userDTO var=new userDTO();
           //var.setvaiTro(rs.getNString("vaiTro"));
           //hienXe.add(var);
          role=rs.getNString("vaiTro");
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return role; }
    public int KtTK(String taiKhoan,String matKhau){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(taiKhoan) FROM dbo.tkmk WHERE taiKhoan=? AND matKhau=?  ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, taiKhoan);
         st.setNString(2, matKhau);
    
         ResultSet rs=st.executeQuery();
         if (rs.next()){
            var=rs.getInt(1);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return var; }
}
