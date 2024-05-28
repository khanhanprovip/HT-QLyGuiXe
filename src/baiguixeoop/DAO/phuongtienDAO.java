/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;


import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class phuongtienDAO {
    public void nhapXe(veDTO veInfo,phuongtienDTO vehInfo ){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="INSERT INTO dbo.baixe  VALUES(?,?,?,?,?,?)";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, veInfo.getIDVe());
         st.setString(2,vehInfo.getBiensoXe());
         st.setString(3, vehInfo.getLoaiXe());
         st.setObject(4, vehInfo.getTimeIn());
         st.setString(5, vehInfo.getViTri());
         st.setString(6, veInfo.getLoaiVe());
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
}
    public void xoaXe(String masoVe){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="DELETE FROM dbo.baixe WHERE masoVe=?";
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
    
}