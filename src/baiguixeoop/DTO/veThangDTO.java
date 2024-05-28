

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DTO;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class veThangDTO extends veDTO {
    private LocalDate ngayDangKy;
    private LocalDate ngayHetHan;
    private int giaVe;
    khachhangDTO khachDK;
    phuongtienDTO xeDK;

    public veThangDTO() {
        khachhangDTO khachDK=new khachhangDTO();
        phuongtienDTO xeDK=new phuongtienDTO();
    }

    public veThangDTO(LocalDate ngayDangKy, LocalDate ngayHetHan, khachhangDTO khachDK, phuongtienDTO xeDK, String IDVe, int tinhTrang, String loaiVe,int giaVe) {
        super(IDVe, tinhTrang, loaiVe);
        this.ngayDangKy = ngayDangKy;
        this.ngayHetHan = ngayHetHan;
        this.khachDK = khachDK;
        this.xeDK = xeDK;
        this.giaVe=giaVe;
    }

    public veThangDTO(String IDVe, int tinhTrang, String loaiVe) {
        super(IDVe, tinhTrang, loaiVe);
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public String getKhachDK() {
        return khachDK.getTenKH();
    }
    public String getKhackLienhe(){
        return khachDK.getSodienThoai();
    }

    public void setKhachDK(khachhangDTO khachDK) {
        this.khachDK = khachDK;
    }

    public String getXeDK() {
        return xeDK.getBiensoXe();
    }
    public String getLoaiXeDK(){
         return xeDK.getLoaiXe();
    }

    public void setXeDK(phuongtienDTO xeDK) {
        this.xeDK = xeDK;
    }

    public int getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(int giaVe) {
        this.giaVe = giaVe;
    }
    
    
    
}
