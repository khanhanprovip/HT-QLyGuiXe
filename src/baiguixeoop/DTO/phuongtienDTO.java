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
public class phuongtienDTO {
    private String biensoXe;
    private LocalDateTime timeIn;
    private String viTri;
    private String loaiXe;
    private String soDKxe;
    veDTO veVao;

    public phuongtienDTO() {
    }

    public phuongtienDTO(String biensoXe, LocalDateTime timeIn,String viTri,String loaiXe) {
        this.biensoXe = biensoXe;
        this.timeIn = timeIn;
        this.viTri=viTri;
        this.loaiXe=loaiXe;
       
    }

    public String getSoDKxe() {
        return soDKxe;
    }

    public void setSoDKxe(String soDKxe) {
        this.soDKxe = soDKxe;
    }
    

    public String getBiensoXe() {
        return biensoXe;
    }

    public void setBiensoXe(String biensoXe) {
        this.biensoXe = biensoXe;
    }

    public LocalDateTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalDateTime timeIn) {
        this.timeIn = timeIn;
    }

    public String getLoaiXe() {
        return loaiXe;
    }

    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public void setVeVao(veDTO veVao) {
        this.veVao = veVao;
    }

   
   

   

    
   
    public String getVeVao() {
        return veVao.getIDVe();
    }
    public String getLoaiVeVao(){
        return veVao.getLoaiVe();
    }
   
    
    
}

