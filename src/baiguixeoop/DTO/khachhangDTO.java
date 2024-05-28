/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DTO;

/**
 *
 * @author Admin
 */
public class khachhangDTO {
    private String tenKH;
    private String sodienThoai;
    private String cccd;

    public khachhangDTO() {
    }

    public khachhangDTO(String tenKH, String sodienThoai) {
        this.tenKH = tenKH;
        this.sodienThoai = sodienThoai;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }
    

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSodienThoai() {
        return sodienThoai;
    }

    public void setSodienThoai(String sodienThoai) {
        this.sodienThoai = sodienThoai;
    }
    
    
}
