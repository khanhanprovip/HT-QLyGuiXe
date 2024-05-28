/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import baiguixe.DTO.khachhangDTO;
import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import baiguixe.DTO.veThangDTO;
import baiguixe.DTO.viphamDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Admin
 */
public class viphamDAO {
    public void ViPhamMatVe(viphamDTO vp,veDTO veInfo,phuongtienDTO vehInfo,khachhangDTO khInfo ){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="INSERT INTO dbo.viphammatve  VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setObject(1, vp.getNgaynhap());
         st.setNString(2, veInfo.getIDVe());
         st.setNString(3, khInfo.getTenKH());
         st.setNString(4, khInfo.getSodienThoai());
         st.setString(5, khInfo.getCccd());
         st.setString(6, vehInfo.getBiensoXe());
         st.setNString(7, vehInfo.getLoaiXe());
         st.setString(8,vehInfo.getSoDKxe());
         st.setObject(9,vehInfo.getTimeIn());
         st.setInt(10,vp.getTienPhat());
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
}
    public int TongTienPhat(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT sum(tienPhat) FROM dbo.viphammatve WHERE CAST(ngayNhap as date)>=? AND CAST(ngayNhap as date)<=?";
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
     public int TongLuotPhat(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(masoVe) FROM dbo.viphammatve WHERE CAST(ngayNhap as date)>=? AND CAST(ngayNhap as date)<=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setNString(2, denngay);
         
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
     public ArrayList<viphamDTO> thongkeVeMat(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<viphamDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.viphammatve WHERE CAST(ngayNhap as date)>=? AND CAST(ngayNhap as date)<=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           viphamDTO var=new viphamDTO();
           phuongtienDTO evar1=new phuongtienDTO();
           khachhangDTO evar2=new khachhangDTO();
           veDTO evar3=new veDTO();
           evar2.setSodienThoai(rs.getNString("sdt"));
           evar2.setTenKH(rs.getNString("khachHang"));
           evar2.setCccd(rs.getString("cccd"));
           var.setKh(evar2);
           evar1.setBiensoXe(rs.getNString("biensoXe"));
           evar1.setLoaiXe(rs.getNString("loaiXe"));
           evar1.setSoDKxe(rs.getString("soDKxe"));
           evar3.setIDVe(rs.getString("masoVe"));
           evar1.setVeVao(evar3);
           Timestamp ts1=rs.getTimestamp("gioVao");
           evar1.setTimeIn(ts1.toLocalDateTime());
           var.setPt(evar1);
           Timestamp ts2=rs.getTimestamp("ngayNhap");
           var.setNgaynhap(ts2.toLocalDateTime());
           var.setTienPhat(rs.getInt("tienPhat"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
     public void ViPhamViTri(viphamDTO vp,phuongtienDTO vehInfo){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="INSERT INTO dbo.viphamvitri  VALUES(?,?,?,?,?)";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, vehInfo.getBiensoXe());
         st.setString(2, vehInfo.getViTri());
         st.setString(3, vp.getVitriSai());
         st.setString(4, vp.getImgpath());
         st.setObject(5, vp.getNgaynhap());
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
}
     public ArrayList<viphamDTO> thongkeData(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<viphamDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.viphamvitri";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           viphamDTO var=new viphamDTO();
           phuongtienDTO evar=new phuongtienDTO();
           evar.setBiensoXe(rs.getString("biensoXe"));
           evar.setViTri(rs.getNString("vitriDung"));
           var.setPt(evar);
           var.setVitriSai(rs.getNString("vitriThuc"));
           var.setImgpath(rs.getString("minhChung"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
     public int KtViPham(String bienso){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(biensoXe) FROM dbo.viphamvitri WHERE biensoXe=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
        
         st.setNString(1, bienso);
        
         ResultSet rs=st.executeQuery();
         if (rs.next()){
            var=rs.getInt(1);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");}
       return var;
     }
     public viphamDTO minhchung(String bienso){
        Connection cn=ketNoiDTB.ketnoi();
        viphamDTO vph=new viphamDTO();
        String sql="SELECT * FROM dbo.viphamvitri WHERE biensoXe=?";
        try{
          PreparedStatement st=cn.prepareStatement(sql);
        
         st.setNString(1, bienso);
        
         ResultSet rs=st.executeQuery();
         while (rs.next()){
            phuongtienDTO evar=new phuongtienDTO();
            vph.setImgpath(rs.getNString("minhChung"));
            vph.setVitriSai(rs.getNString("vitriThuc"));
            evar.setBiensoXe(rs.getNString("biensoXe"));
            evar.setViTri(rs.getNString("vitriDung"));
            vph.setPt(evar);
            Timestamp ts=rs.getTimestamp("ngayNhap");
            vph.setNgaynhap(ts.toLocalDateTime());
            
         }
        }
        catch(SQLException e) {
     e.printStackTrace();
     System.out.print("failed");}
        return vph;
     }
     public void xoaHinhAnh(String bienso){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="DELETE FROM dbo.viphamvitri WHERE biensoXe=?";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, bienso);
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
}
}
      public ArrayList<phuongtienDTO> xuatds(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<phuongtienDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT biensoXe FROM dbo.baixe WHERE biensoXe NOT IN (SELECT biensoXe FROM dbo.viphamvitri)";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           phuongtienDTO var=new phuongtienDTO();
           var.setBiensoXe(rs.getString("biensoXe"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
     
     
    
    
}
