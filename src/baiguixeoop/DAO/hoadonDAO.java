/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import baiguixe.DTO.hoadonDTO;
import baiguixe.DTO.khachhangDTO;
import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import baiguixe.DTO.veThangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class hoadonDAO {
    public void nhapHoaDon(veDTO veInfo,phuongtienDTO vehInfo,hoadonDTO hoadonInfo ){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="INSERT INTO dbo.thongke (biensoXe,loaiXe,gioVao,gioRa,masoVe,loaiVe,thanhTien) VALUES(?,?,?,?,?,?,?)";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         //st.setString(1, hoadonInfo.getMaHoaDon());
         st.setString(1, vehInfo.getBiensoXe());
         st.setNString(2, vehInfo.getLoaiXe());
         st.setObject(3, vehInfo.getTimeIn());
         st.setObject(4, hoadonInfo.getTimeOut());
         st.setString(5, veInfo.getIDVe());
         st.setNString(6, veInfo.getLoaiVe());
         st.setInt(7, hoadonInfo.getThanhTien());
         
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
}
     public int thongkeLuotGui(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(biensoXe) FROM dbo.thongke WHERE CAST(gioRa as date)>=? AND CAST(gioRa as date)<=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
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
      public int TongThu(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT sum(thanhTien) FROM dbo.thongke WHERE CAST(gioRa as date)>=? AND CAST(gioRa as date)<=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
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
      
      public int thongkePhanLoai(String tungay,String denngay,String loai){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(biensoXe) FROM dbo.thongke WHERE CAST(gioRa as date)>=? AND CAST(gioRa as date)<=? AND loaiXe=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
         st.setString(3, loai);
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
      
       public int TongThuPhanLoai(String tungay,String denngay,String loai){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT sum(thanhTien) FROM dbo.thongke WHERE CAST(gioRa as date)>=? AND CAST(gioRa as date)<=? AND loaiXe=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
         st.setString(3, loai);
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
       
       public ArrayList<hoadonDTO> hienthihoadon(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<hoadonDTO> hienXe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.thongke WHERE CAST(gioRa as date)>=? AND CAST(gioRa as date)<=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           hoadonDTO var=new hoadonDTO();
           phuongtienDTO evar1=new phuongtienDTO();
           veDTO evar2=new veDTO();
           evar1.setBiensoXe(rs.getString("biensoXe"));
           evar1.setLoaiXe(rs.getNString("loaiXe"));
           Timestamp ts=rs.getTimestamp("gioVao");
           evar1.setTimeIn(ts.toLocalDateTime());
           evar2.setIDVe(rs.getString("masoVe"));
           evar2.setLoaiVe(rs.getNString("loaiVe"));
           evar1.setVeVao(evar2);
           var.setXeOut(evar1);
           Timestamp ts2=rs.getTimestamp("gioRa");
           var.setTimeOut(ts2.toLocalDateTime());
           var.setThanhTien(rs.getInt("thanhTien"));
           hienXe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienXe; }
       
       public ArrayList<hoadonDTO> hienthiphanloai(String tungay,String denngay,String loai){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<hoadonDTO> hienXe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.thongke WHERE CAST(gioRa as date)>=? AND CAST(gioRa as date)<=? AND loaiXe=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
         st.setString(3, loai);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           hoadonDTO var=new hoadonDTO();
           phuongtienDTO evar1=new phuongtienDTO();
           veDTO evar2=new veDTO();
           evar1.setBiensoXe(rs.getString("biensoXe"));
           evar1.setLoaiXe(rs.getNString("loaiXe"));
           Timestamp ts=rs.getTimestamp("gioVao");
           evar1.setTimeIn(ts.toLocalDateTime());
           evar2.setIDVe(rs.getString("masoVe"));
           evar2.setLoaiVe(rs.getNString("loaiVe"));
           evar1.setVeVao(evar2);
           var.setXeOut(evar1);
           Timestamp ts2=rs.getTimestamp("gioRa");
           var.setTimeOut(ts2.toLocalDateTime());
           var.setThanhTien(rs.getInt("thanhTien"));
           hienXe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienXe; }
}
