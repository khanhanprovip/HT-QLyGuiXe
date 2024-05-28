/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import baiguixe.DTO.khachhangDTO;
import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veNgayDTO;
//import baiguixe.DTO.veDTO;
//import baiguixe.DTO.veNgayDTO;
import baiguixe.DTO.veThangDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class veThangDAO {
    public ArrayList<veThangDTO> thongkeVeThang(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<veThangDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.vethang WHERE thoidiemDangKi>=? AND thoidiemDangKi<=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, tungay);
         st.setString(2, denngay);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           veThangDTO var=new veThangDTO();
           phuongtienDTO evar1=new phuongtienDTO();
           khachhangDTO evar2=new khachhangDTO();
           var.setIDVe(rs.getString("masoVe"));
           evar2.setSodienThoai(rs.getNString("lienhe"));
           evar2.setTenKH(rs.getNString("chuSoHuu"));
           var.setKhachDK(evar2);
           evar1.setBiensoXe(rs.getNString("xeDangKi"));
           evar1.setLoaiXe(rs.getNString("loaiXe"));
           var.setXeDK(evar1);
           var.setNgayDangKy(rs.getObject("thoidiemDangKi", LocalDate.class));
           var.setNgayHetHan(rs.getObject("thoidiemHethan", LocalDate.class));
           var.setGiaVe(rs.getInt("giaVe"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
    public void DKVeThang(veThangDTO veInfo,phuongtienDTO vehInfo,khachhangDTO khInfo ){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="INSERT INTO dbo.vethang (masoVe,chuSoHuu,xeDangKi,loaiXe,thoidiemDangKi,thoidiemHetHan,giaVe,lienhe) VALUES(?,?,?,?,?,?,?,?)";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, veInfo.getIDVe());
         st.setNString(2, khInfo.getTenKH());
         st.setNString(3, vehInfo.getBiensoXe());
         st.setNString(4, vehInfo.getLoaiXe());
         st.setObject(5, veInfo.getNgayDangKy());
         st.setObject(6, veInfo.getNgayHetHan());
         st.setInt(7, veInfo.getGiaVe());
         st.setString(8,khInfo.getSodienThoai());
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
}
    public void GiaHanVeThang(String hethan,String masoVe){
    Connection cn=ketNoiDTB.ketnoi();
        String sql="UPDATE dbo.vethang2 SET ngayDangKi=ngayHetHan,ngayHetHan=? WHERE masoVe=?";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, hethan);
         st.setString(2, masoVe);
         
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
}
   }
    public void xoaVeThang(String masoVe){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="DELETE FROM dbo.vethang2 WHERE masoVe=?";
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
     public int KtVeThang(String masoVe,String biensoXe){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(masoVe) FROM dbo.vethang2 WHERE masoVe=? AND biensoXe=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, masoVe);
         st.setNString(2, biensoXe);
        
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
     public int TongThuVeThang(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT sum(giaVe) FROM dbo.vethang WHERE thoidiemDangKi>=? AND thoidiemDangKi<=?";
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
     public int LuongVeThang(String tungay,String denngay){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(masoVe) FROM dbo.vethang WHERE thoidiemDangKi>=? AND thoidiemDangKi<=?";
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
      public ArrayList<veThangDTO> xuatVeThang(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<veThangDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT masoVe FROM dbo.vethang2 WHERE tinhTrang=0  ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           veThangDTO var=new veThangDTO();
           var.setIDVe(rs.getString("masoVe"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
      public void layVeThang(String masoVe){
    Connection cn=ketNoiDTB.ketnoi();
        String sql="UPDATE dbo.vethang2 SET tinhTrang=1 WHERE masoVe=?";
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
      
     public void traVeThang(String masoVe){
    Connection cn=ketNoiDTB.ketnoi();
        String sql="UPDATE dbo.vethang2 SET tinhTrang=0 WHERE masoVe=?";
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
     
    public veThangDTO thongtinVeThang(String masoVe){
       Connection cn=ketNoiDTB.ketnoi();
       veThangDTO hienVe=new veThangDTO(); 
       String sql="SELECT * FROM dbo.vethang WHERE masoVe=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, masoVe);
       
         ResultSet rs=st.executeQuery();
         
           while (rs.next()){
           phuongtienDTO evar1=new phuongtienDTO();
           khachhangDTO evar2=new khachhangDTO();
           hienVe.setIDVe(rs.getString("masoVe"));
           evar2.setSodienThoai(rs.getNString("lienhe"));
           evar2.setTenKH(rs.getNString("chuSoHuu"));
           hienVe.setKhachDK(evar2);
           evar1.setBiensoXe(rs.getNString("xeDangKi"));
           evar1.setLoaiXe(rs.getNString("loaiXe"));
           hienVe.setXeDK(evar1);
           hienVe.setNgayDangKy(rs.getObject("thoidiemDangKi", LocalDate.class));
           hienVe.setNgayHetHan(rs.getObject("thoidiemHethan", LocalDate.class));
           hienVe.setGiaVe(rs.getInt("giaVe"));
        
           }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
      public void LuuVeThang(veThangDTO veInfo,phuongtienDTO vehInfo){
        Connection cn=ketNoiDTB.ketnoi();
        String sql="INSERT INTO dbo.vethang2 VALUES(?,?,?,0,?)";
        try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1, veInfo.getIDVe());
         st.setObject(2, veInfo.getNgayDangKy());
         st.setObject(3, veInfo.getNgayHetHan());
         st.setNString(4, vehInfo.getBiensoXe());
         st.executeUpdate();
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
}
      
     
     
    
    

      
    
}
