/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DTO;

import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class hoadonDTO {
   private String maHoaDon;
   private int thanhTien;
   private LocalDateTime timeOut; 
   phuongtienDTO xeOut;
    public hoadonDTO() {
        phuongtienDTO xeOut=new phuongtienDTO();
    }

    public hoadonDTO(String maHoaDon, int thanhTien, LocalDateTime timeOut) {
        this.maHoaDon = maHoaDon;
        this.thanhTien = thanhTien;
        this.timeOut = timeOut;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public LocalDateTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalDateTime timeOut) {
        this.timeOut = timeOut;
    }
    public String getBienSoXeOut(){
        return xeOut.getBiensoXe();
    }
    public String getLoaiXeOut(){
        return xeOut.getLoaiXe();
    }
    public LocalDateTime getGioVaoXeOut(){
        return xeOut.getTimeIn();
    }
    public String getVeXeOut(){
        return xeOut.getVeVao();
    }
    public String getLoaiVeXeOut(){
        return xeOut.getLoaiVeVao();
    }

    public void setXeOut(phuongtienDTO xeOut) {
        this.xeOut = xeOut;
    }
    
    
}
