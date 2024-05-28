/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DTO;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 *
 * @author Admin
 */
public class viphamDTO {
    khachhangDTO kh;
    phuongtienDTO pt;
  private  LocalDateTime ngaynhap; 
  private int tienPhat;
  private String imgpath;
  private String vitriSai;

    public viphamDTO() {
    }

    public khachhangDTO getKh() {
        return kh;
    }

    public void setKh(khachhangDTO kh) {
        this.kh = kh;
    }

    public phuongtienDTO getPt() {
        return pt;
    }

    public void setPt(phuongtienDTO pt) {
        this.pt = pt;
    }

    public LocalDateTime getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(LocalDateTime ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

   

    public String getVitriSai() {
        return vitriSai;
    }

    public void setVitriSai(String vitriSai) {
        this.vitriSai = vitriSai;
    }
    

  

   
    
    
}
