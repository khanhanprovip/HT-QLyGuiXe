/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import baiguixe.DTO.veNgayDTO;
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
public class veNgayDAO {
    public void layVe(String masoVe){
    Connection cn=ketNoiDTB.ketnoi();
        String sql="UPDATE dbo.vengay SET tinhTrang=1 WHERE masoVe=?";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, masoVe);
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
}
   }
     public void traVe(String masoVe){
    Connection cn=ketNoiDTB.ketnoi();
        String sql="UPDATE dbo.vengay SET tinhTrang=0 WHERE masoVe=?";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, masoVe);
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
}
   }
     public ArrayList<veNgayDTO> xuatVe(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<veNgayDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT masoVe FROM dbo.vengay WHERE tinhTrang=0  ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           veNgayDTO var=new veNgayDTO();
           var.setIDVe(rs.getString("masoVe"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
     public void xoaVeNgay(String masoVe){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="DELETE FROM dbo.vengay WHERE masoVe=?";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, masoVe);
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
}
}
      public int KtVe(String masoVe){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(masoVe) FROM dbo.vengay WHERE masoVe=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, masoVe);
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
