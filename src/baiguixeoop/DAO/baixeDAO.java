/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DAO;

import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import baiguixe.DTO.veNgayDTO;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import java.util.List;
/**
 *
 * @author Admin
 */
public class baixeDAO {
    public ArrayList<phuongtienDTO> hienthiXe(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<phuongtienDTO> hienXe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.baixe  ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           phuongtienDTO var=new phuongtienDTO();
           veDTO evar=new veDTO();
           evar.setIDVe(rs.getString("masoVe"));
           evar.setLoaiVe(rs.getNString("loaiVe"));
           var.setVeVao(evar);
           var.setBiensoXe(rs.getString("biensoXe"));
           Timestamp ts=rs.getTimestamp("thoigianVao");
           var.setTimeIn(ts.toLocalDateTime());
           var.setViTri(rs.getNString("viTri"));
           var.setLoaiXe(rs.getNString("loaiXe"));
           hienXe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienXe; }
      public phuongtienDTO timkiemBienSo(String biensoXe){
       Connection cn=ketNoiDTB.ketnoi();
       phuongtienDTO  var=new phuongtienDTO();
       String sql="SELECT * FROM dbo.baixe WHERE biensoXe=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setNString(1,biensoXe );
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           
           veDTO evar=new veDTO();
           evar.setIDVe(rs.getString("masoVe"));
           evar.setLoaiVe(rs.getNString("loaiVe"));
           var.setVeVao(evar);
           var.setBiensoXe(rs.getString("biensoXe"));
           Timestamp ts=rs.getTimestamp("thoigianVao");
           var.setTimeIn(ts.toLocalDateTime());
           var.setViTri(rs.getNString("viTri"));
           var.setLoaiXe(rs.getNString("loaiXe"));
           
         }
         }
         catch (SQLException e) {
           e.printStackTrace();
           System.out.print("failed");
 }
          return var; }
     public phuongtienDTO timkiemMaVe(String maVe){
       Connection cn=ketNoiDTB.ketnoi();
       phuongtienDTO var=new phuongtienDTO();
       String sql="SELECT * FROM dbo.baixe WHERE masoVe=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setString(1,maVe );
         ResultSet rs=st.executeQuery();
         while (rs.next()){
            
           veDTO evar=new veDTO();
           evar.setIDVe(rs.getString("masoVe"));
           evar.setLoaiVe(rs.getNString("loaiVe"));
           var.setVeVao(evar);
           var.setBiensoXe(rs.getString("biensoXe"));
           Timestamp ts=rs.getTimestamp("thoigianVao");
           var.setTimeIn(ts.toLocalDateTime());
           var.setViTri(rs.getNString("viTri"));
           var.setLoaiXe(rs.getNString("loaiXe"));
           
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return var; }
     public ArrayList<phuongtienDTO> timkiemPhanLoai(String loaiXe){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<phuongtienDTO> hienXe=new ArrayList<>(); 
       String sql="SELECT * FROM dbo.baixe WHERE loaiXe=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setNString(1, loaiXe);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           phuongtienDTO var=new phuongtienDTO();
           veDTO evar=new veDTO();
           evar.setIDVe(rs.getString("masoVe"));
           evar.setLoaiVe(rs.getNString("loaiVe"));
           var.setVeVao(evar);
           var.setBiensoXe(rs.getString("biensoXe"));
           Timestamp ts=rs.getTimestamp("thoidiemVao");
           var.setTimeIn(ts.toLocalDateTime());
           var.setViTri(rs.getNString("viTri"));
           var.setLoaiXe(rs.getNString("loaiXe"));
           hienXe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienXe; } 
     public int thongkePhanLoai(String loaiXe){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(biensoXe) FROM dbo.baixe WHERE loaiXe=? ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setNString(1,loaiXe );
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
     //public int KtVe(String masoVe,String biensoXe,String loaiXe){
       //Connection cn=ketNoiDTB.ketnoi();
       //int var=0;
       //String sql="SELECT count(biensoXe) FROM dbo.baixe WHERE masoVe=? AND biensoXe=? AND loaiXe=? ";
       //try{
         //PreparedStatement st=cn.prepareStatement(sql);
         //st.setString(1, masoVe);
         //st.setNString(2, biensoXe);
         //st.setNString(3, loaiXe);
         //ResultSet rs=st.executeQuery();
         //if (rs.next()){
           // var=rs.getInt(1);
         //}
         //}
         //catch (SQLException e) {
     //e.printStackTrace();
     //System.out.print("failed");
 //}
   //       return var; }
     public ArrayList<veDTO> xuatVeTrongBai(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<veDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT masoVe FROM dbo.baixe   ";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         ResultSet rs=st.executeQuery();
         while (rs.next()){
           veDTO var=new veDTO();
           var.setIDVe(rs.getString("masoVe"));
           hienVe.add(var);
         }
         }
         catch (SQLException e) {
     e.printStackTrace();
     System.out.print("failed");
 }
          return hienVe; }
      public ArrayList<phuongtienDTO> xuatXeTrongBai(){
       Connection cn=ketNoiDTB.ketnoi();
       ArrayList<phuongtienDTO> hienVe=new ArrayList<>(); 
       String sql="SELECT biensoXe FROM dbo.baixe";
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
       public int KtXe(String loaiXe,String bienso){
       Connection cn=ketNoiDTB.ketnoi();
       int var=0;
       String sql="SELECT count(biensoXe) FROM dbo.baixe WHERE loaiXe=? AND biensoXe=?";
       try{
         PreparedStatement st=cn.prepareStatement(sql);
         st.setNString(1,loaiXe );
         st.setString(2, bienso);
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
