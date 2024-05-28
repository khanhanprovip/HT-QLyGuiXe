/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DTO;

/**
 *
 * @author Admin
 */
public class veDTO {
   private String IDVe;
   private int tinhTrang;
   private String loaiVe;

    public veDTO() {
    }

    public veDTO(String IDVe, int tinhTrang,String loaiVe) {
        this.IDVe = IDVe;
        this.tinhTrang = tinhTrang;
        this.loaiVe=loaiVe;
    }

    public String getIDVe() {
        return IDVe;
    }

    public void setIDVe(String IDVe) {
        this.IDVe = IDVe;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }
   
}
